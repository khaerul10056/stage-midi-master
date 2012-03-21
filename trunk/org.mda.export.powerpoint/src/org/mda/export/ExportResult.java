package org.mda.export;

import java.io.File;
import mda.User;


public class ExportResult {

  private User user;

  private File exportFile;

  private ExportException exception;

  public User getUser () {
    return user;
  }

  public void setUser (User user) {
    this.user = user;
  }

  public File getExportFile () {
    return exportFile;
  }

  public void setExportFile (File exportFile) {
    this.exportFile = exportFile;
  }

  public ExportException getException () {
    return exception;
  }

  public void setException (ExportException exception) {
    this.exception = exception;
  }




}
