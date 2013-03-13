package org.mda.export;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import mda.Configuration;
import mda.MidiPlayerRoot;
import mda.User;

import org.mda.ApplicationSession;
import org.mda.export.pdf.PdfExporter;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.presenter.config.IPresenterConfig;
import org.mda.presenter.config.PresentationConfigurator;
import org.mda.presenter.config.PresentationType;

import com.google.inject.Inject;


public class ExportEngine {

  @Inject
  private ApplicationSession appSession;
  
  @Inject
  private PdfExporter pdfexporter; //TODO implement other formats
  
  @Inject
  private MailingAdapter mailingAdapter;
  

  private final static Log LOG = LogFactory.getLogger(ExportEngine.class);

  private IExport getExporter (final User user) {
    return pdfexporter;
  }

  private File getFile (User nextUser, IExport export) {
    StringBuilder builderName = new StringBuilder();
    builderName.append("songbook");
    if (nextUser.getName() != null && ! nextUser.getName().isEmpty())
      builderName.append ("_" + nextUser.getName());
    if (nextUser.getFirstname() != null && ! nextUser.getFirstname().isEmpty())
      builderName.append ("_" + nextUser.getFirstname());

    builderName.append(export.getSuffix());

    return new File (appSession.getExportPath(), builderName.toString());
  }

  public List <ExportResult> exportSongbooks () {

    ArrayList<ExportResult> results = new ArrayList<ExportResult>();

    MidiPlayerRoot currentModel = appSession.getCurrentModel();
    for (User nextUser: currentModel.getUsers()) {
      IExport exporter = getExporter(nextUser);
      File exportFile = getFile(nextUser, exporter);
      
      ExportResult exportResult = new ExportResult();
      try {

        if (nextUser.isSendSongbook()) {
          LOG.info("Exporting file " + exportFile.getAbsolutePath() + " for user " + nextUser.getName() + " " + nextUser.getFirstname());
          PresentationConfigurator configurator = new PresentationConfigurator();
          PresentationType type = nextUser.getDefaultPresentationType() != null ? PresentationType.valueOf(nextUser.getDefaultPresentationType()) : PresentationType.PDF;
          IPresenterConfig config = configurator.configure(nextUser, appSession.getCurrentModel(), type);
          exportFile = exporter.export(currentModel.getGallery().getGalleryItems(), exportFile, config);
          exportResult.setUser(nextUser);
          exportResult.setExportFile(exportFile);
          results.add(exportResult);
        }
        else
        	LOG.info("User " + nextUser.getName() + " is configured to get no songbooks");

      }
      catch (ExportException e) {
        exportResult.setException(e);
        LOG.error("Error exporting file " + exportFile.getAbsolutePath() + ":", e);
      }




    }
    return results;
  }
  
  private Configuration getConfiguration () {
	  return appSession.getCurrentModel().getConfig();
  }

  /**
   * mails the exported songbooks
   * @param results
 * @throws MessagingException 
   */
  public void mailExportedSongbooks (Collection <ExportResult> results) throws MessagingException {
	  
	if (getConfiguration().getMailserverUser() == null || getConfiguration().getMailserverUrl() == null || getConfiguration().getMailserverPassword() == null)
      throw new MessagingException("Please configure mailserver, user and password before trying to send mails");
	  
	Collection <Message> messages = new ArrayList<Message>();

    for (ExportResult nextResult: results) {
   // Get system properties
      Properties props = System.getProperties();
      
      

      Authenticator authenticator = new Authenticator(getConfiguration().getMailserverUser(), getConfiguration().getMailserverPassword());
      props.put("mail.smtp.host", getConfiguration().getMailserverUrl());
      props.put("mail.smtp.auth", "true");

      Session session = Session.getDefaultInstance(props, authenticator);


   // Create the message part
      BodyPart messageBodyPart = new MimeBodyPart();
      
      
      // Fill the message
      messageBodyPart.setText(getConfiguration().getMailtextSendSongbook() != null ? getConfiguration().getMailtextSendSongbook() : "");
      Multipart multipart = new MimeMultipart();
      multipart.addBodyPart(messageBodyPart);

      // Part two is attachment
      MimeBodyPart attachmentPart = new MimeBodyPart();
      DataSource source = new FileDataSource(nextResult.getExportFile());
      attachmentPart.setDataHandler(new DataHandler(source));
      attachmentPart.setFileName(nextResult.getExportFile().getName());
      multipart.addBodyPart(attachmentPart);
      
      

      MimeMessage message = new MimeMessage(session);
      message.setFrom(new InternetAddress(getConfiguration().getMailserverUser()));
      message.addRecipient(Message.RecipientType.TO, new InternetAddress(nextResult.getUser().getMail()));
      message.setSubject(getConfiguration().getMailsubjectSendSongbook() != null ? getConfiguration().getMailsubjectSendSongbook() : "");
      message.setContent(multipart);

      // Send message
      messages.add(message);
      
    }
    
    mailingAdapter.mail(messages);

  }

  private class Authenticator extends javax.mail.Authenticator {
    private PasswordAuthentication authentication;

    public Authenticator(final String username, final String password) {
      authentication = new PasswordAuthentication(username, password);
    }

    @Override
	protected PasswordAuthentication getPasswordAuthentication() {
      return authentication;
    }
  }



}
