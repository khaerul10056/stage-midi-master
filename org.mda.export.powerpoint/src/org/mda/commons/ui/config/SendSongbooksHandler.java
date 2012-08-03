package org.mda.commons.ui.config;

import java.util.Collection;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Execute;
import org.mda.export.ExportEngine;
import org.mda.export.ExportResult;


public class SendSongbooksHandler {
  
  @Inject
  ExportEngine engine;

  @Execute
  public void execute (ExportEngine engine) {
    Collection<ExportResult> exportSongbooks = engine.exportSongbooks();
    //engine.mailExportedSongbooks(exportSongbooks); TODO enable, if sending is OK 
  }

}
