package org.mda.export;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.inject.Inject;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import mda.MidiPlayerRoot;
import mda.User;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.mda.ApplicationSession;
import org.mda.commons.ui.IMidiFileEditorUIConfig;
import org.mda.commons.ui.calculator.configurator.PresentationConfigurator;
import org.mda.commons.ui.calculator.configurator.PresentationType;
import org.mda.export.pdf.PdfExporter;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;

@Creatable
public class ExportEngine {

  @Inject
  private ApplicationSession appSession;
  
  @Inject
  private PdfExporter pdfexporter; //TODO implement other formats
  
  

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
          IMidiFileEditorUIConfig config = configurator.configure(nextUser, appSession.getCurrentModel(), type);
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

  /**
   * mails the exported songbooks
   * @param results
   */
  public void mailExportedSongbooks (Collection <ExportResult> results) {

    for (ExportResult nextResult: results) {
      try {
   // Get system properties
      Properties props = System.getProperties();

      Authenticator authenticator = new Authenticator("oleys@gmx.de", "mo351977");
      props.put("mail.smtp.host", "mail.gmx.net");
      props.put("mail.smtp.auth", "true");

      Session session = Session.getDefaultInstance(props, authenticator);


   // Create the message part
      BodyPart messageBodyPart = new MimeBodyPart();

      // Fill the message
      messageBodyPart.setText("...gibts anbei");
      Multipart multipart = new MimeMultipart();
      multipart.addBodyPart(messageBodyPart);

      // Part two is attachment
      MimeBodyPart attachmentPart = new MimeBodyPart();
      DataSource source = new FileDataSource(nextResult.getExportFile());
      attachmentPart.setDataHandler(new DataHandler(source));
      attachmentPart.setFileName(nextResult.getExportFile().getName());
      multipart.addBodyPart(attachmentPart);

      MimeMessage message = new MimeMessage(session);
      message.setFrom(new InternetAddress("oleys@gmx.de"));
      message.addRecipient(Message.RecipientType.TO, new InternetAddress(nextResult.getUser().getMail()));
      message.setSubject("Neueste Version des Songbooks");
      message.setContent(multipart);

      // Send message
      Transport.send(message);
      } catch (Exception e) {
        LOG.error("Error sending mail to " + nextResult.getUser().getMail() + ":", e);
      }
    }

  }

  private class Authenticator extends javax.mail.Authenticator {
    private PasswordAuthentication authentication;

    public Authenticator(final String username, final String password) {
      authentication = new PasswordAuthentication(username, password);
    }

    protected PasswordAuthentication getPasswordAuthentication() {
      return authentication;
    }
  }



}
