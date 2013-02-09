package org.mda.commons.ui.config;

import org.eclipse.swt.widgets.Shell;
import org.mda.inject.InjectService;

import com.google.inject.Inject;


public class SendSongbooksHandler {
  
  @Inject
  SendSongbooksShell sendSongbooksShell;

  public void execute (Shell mother) {
	InjectService.injectObject(this);
    sendSongbooksShell.build(mother);  
  }

}
