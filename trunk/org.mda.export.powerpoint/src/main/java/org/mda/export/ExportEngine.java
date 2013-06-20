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

import org.mda.export.pdf.PdfExporter;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.presenter.config.IPresenterConfig;
import org.mda.presenter.config.PresentationConfigurator;
import org.mda.presenter.config.PresentationType;

import com.google.inject.Inject;


public class ExportEngine {

  
  @Inject
  private PdfExporter pdfexporter; //TODO implement other formats
  
  
  @Inject
  private MailingAdapter mailingAdapter;


  private final static Log LOG = LogFactory.getLogger(ExportEngine.class);

  private IExport getExporter (final User user) {
    return pdfexporter;
  }
  
  
  
  private File getFile (User nextUser, IExport export, final File exportpath) {
    StringBuilder builderName = new StringBuilder();
    builderName.append("songbook");
    if (nextUser.getName() != null && ! nextUser.getName().isEmpty())
      builderName.append ("_" + nextUser.getName());
    if (nextUser.getFirstname() != null && ! nextUser.getFirstname().isEmpty())
      builderName.append ("_" + nextUser.getFirstname());

    builderName.append(export.getSuffix());

    return new File (exportpath, builderName.toString());
  }

  public List <ExportResult> exportSongbooks (final MidiPlayerRoot model, final File exportpath) {
    ArrayList<ExportResult> results = new ArrayList<ExportResult>();
    
    for (User nextUser: model.getUsers()) {
      IExport exporter = getExporter(nextUser);
      File exportFile = getFile(nextUser, exporter, exportpath);
      
      ExportResult exportResult = new ExportResult();
      try {

        if (nextUser.isSendSongbook()) {
          LOG.info("Exporting file " + exportFile.getAbsolutePath() + " for user " + nextUser.getName() + " " + nextUser.getFirstname());
          PresentationConfigurator configurator = new PresentationConfigurator();
          PresentationType type = nextUser.getDefaultPresentationType() != null ? PresentationType.valueOf(nextUser.getDefaultPresentationType()) : PresentationType.PDF;
          IPresenterConfig config = configurator.configure(nextUser, model, type);
          exportFile = exporter.export(model.getGallery().getGalleryItems(), exportFile, config);
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
  
  private Configuration getConfiguration (MidiPlayerRoot model) {
	  return model.getConfig();
  }

  /**
   * mails the exported songbooks
   * @param results
 * @throws MessagingException 
   */
  public void mailExportedSongbooks (final MidiPlayerRoot model, Collection <ExportResult> results) throws MessagingException {
	  
	Configuration configuration = getConfiguration(model);
	  
	if (configuration.getMailserverUser() == null || configuration.getMailserverUrl() == null || configuration.getMailserverPassword() == null)
      throw new MessagingException("Please configure mailserver, user and password before trying to send mails");
	  
	Collection <Message> messages = new ArrayList<Message>();

    for (ExportResult nextResult: results) {
   // Get system properties
      Properties props = System.getProperties();

      Authenticator authenticator = new Authenticator(configuration.getMailserverUser(), configuration.getMailserverPassword());
      props.put("mail.smtp.host", configuration.getMailserverUrl());
      props.put("mail.smtp.auth", "true");

      Session session = Session.getDefaultInstance(props, authenticator);


   // Create the message part
      BodyPart messageBodyPart = new MimeBodyPart();
      
      
      // Fill the message
      messageBodyPart.setText(configuration.getMailtextSendSongbook() != null ? configuration.getMailtextSendSongbook() : "");
      Multipart multipart = new MimeMultipart();
      multipart.addBodyPart(messageBodyPart);

      // Part two is attachment
      MimeBodyPart attachmentPart = new MimeBodyPart();
      DataSource source = new FileDataSource(nextResult.getExportFile());
      attachmentPart.setDataHandler(new DataHandler(source));
      attachmentPart.setFileName(nextResult.getExportFile().getName());
      multipart.addBodyPart(attachmentPart);
      
      

      MimeMessage message = new MimeMessage(session);
      message.setFrom(new InternetAddress(configuration.getMailserverUser()));
      message.addRecipient(Message.RecipientType.TO, new InternetAddress(nextResult.getUser().getMail()));
      message.setSubject(configuration.getMailsubjectSendSongbook() != null ? configuration.getMailsubjectSendSongbook() : "");
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
