package org.mda.commons.ui.config;

import java.util.Collection;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.mda.export.ExportEngine;
import org.mda.export.ExportResult;


public class SendSongbooksHandler  extends AbstractHandler{

  @Override
  public Object execute (ExecutionEvent arg0) throws ExecutionException {
    ExportEngine engine = new ExportEngine();
    Collection<ExportResult> exportSongbooks = engine.exportSongbooks();
    //TODO check results on errors
    //engine.mailExportedSongbooks(exportSongbooks); TODO enable, if sending is ok
    return null;
  }

}
