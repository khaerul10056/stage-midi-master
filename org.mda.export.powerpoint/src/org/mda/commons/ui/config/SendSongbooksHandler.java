package org.mda.commons.ui.config;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.swt.widgets.Shell;


public class SendSongbooksHandler {
  
  @Inject
  SendSongbooksShell sendSongbooksShell;

  @Execute
  public void execute (Shell mother) {
    sendSongbooksShell.build(mother);  
  }

}
