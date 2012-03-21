package org.mda.export;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import mda.MidiPlayerRoot;
import mda.User;
import org.mda.ApplicationSession;
import org.mda.MdaModule;
import org.mda.export.pdf.PdfExporter;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;


public class ExportEngine {

  private ApplicationSession  appSession =  MdaModule.getInjector().getInstance(ApplicationSession.class);;

  private final static Log LOG = LogFactory.getLogger(ExportEngine.class);

  private IExport getExporter (final User user) {
    return new PdfExporter ();
  }

  public Collection <ExportResult> exportSongbooks () {

    ArrayList<ExportResult> results = new ArrayList<ExportResult>();

    MidiPlayerRoot currentModel = appSession.getCurrentModel();
    for (User nextUser: currentModel.getUsers()) {
      IExport exporter = getExporter(nextUser);
      File exportFile = new File (appSession.getExportPath(), nextUser.getName() + "_" + nextUser.getFirstname() + exporter.getSuffix());
      LOG.info("Exporting file " + exportFile.getAbsolutePath() + " for user " + nextUser.getName() + " " + nextUser.getFirstname());
      ExportResult exportResult = null;
      try {
        exportResult = exporter.export(currentModel.getGallery().getGalleryItems(), exportFile, nextUser.getExportConfiguration());

      }
      catch (ExportException e) {
        exportResult.setException(e);
        LOG.error("Error exporting file " + exportFile.getAbsolutePath() + ":", e);
      }
      exportResult.setUser(nextUser);
      results.add(exportResult);



    }
    return results;
  }

  /**
   * mails the exported songbooks
   * @param results
   */
  public void mailExportedSongbooks (Collection <ExportResult> results) {

  }



}
