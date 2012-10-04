package org.mda.commons.ui.config;

import java.util.Collection;

import javax.inject.Inject;

import mda.User;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.mda.ApplicationSession;
import org.mda.export.ExportEngine;
import org.mda.export.ExportResult;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;

@Creatable
public class SendSongbooksShell {
	
	  Text txtMailtext;

	  private Shell shell;

	  private static final Log LOGGER  = LogFactory.getLogger(SendSongbooksShell.class);

	  @Inject
	  private ApplicationSession session;
	  
	  @Inject
	  ExportEngine engine;

	  
	  private GridData getLabelData () {
	    return new GridData(SWT.BEGINNING, SWT.CENTER, false, false);
	  }
	  
	  public Shell getShell () {
		  return shell;
	  }

	  private GridData getContentData (final boolean fillHorizontal) {
	    GridData gd = new GridData(SWT.FILL, SWT.FILL, fillHorizontal, false);
	    gd.verticalIndent = 10;
	    return gd;
	  }

	 public Shell build (final Shell mother) {
	    this.shell = new Shell (mother); 
	    shell.setSize(800, 700);
	    shell.setText("Send songbooks");
	    shell.setLayout(new GridLayout(2, false));

	    //BackgroundImage
	    Label lblPictureText = new Label (shell, SWT.NONE);
	    lblPictureText.setText("Mailtext:");
	    lblPictureText.setLayoutData(getLabelData());

	    txtMailtext = new Text (shell, SWT.MULTI);
	    GridData gd = getContentData(true); 
	    gd.grabExcessVerticalSpace = true;
	    txtMailtext.setLayoutData(gd);
	    if (session.getCurrentModel().getConfig().getMailtext() != null)
	      txtMailtext.setText(session.getCurrentModel().getConfig().getMailtext());
	    
	    Label lblInfo = new Label (shell, SWT.NONE);
	    String sendTo = "Sending songbook to:\n";
	    for (User next: session.getCurrentModel().getUsers()) {
	    	if (next.isSendSongbook())
	    	  sendTo += "- " + next.getFirstname() + " " + next.getName() + "(" + next.getMail() + ")\n";
	    }
	    lblInfo.setText(sendTo);
	    GridData gd2 = getContentData(true); 
	    gd2.horizontalSpan = 2;
	    lblInfo.setLayoutData(gd2);
	    lblInfo.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_DARK_GRAY));
	    lblInfo.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
	    
	    buildButtons();

	    shell.open ();
	    return shell;
	  }

	  private void buildButtons () {
	    Composite btnComp = new Composite(shell, SWT.NONE);
	    
	    btnComp.setLayout(new RowLayout(SWT.HORIZONTAL));
	    btnComp.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 2 , 1));

	    Button btnOk = new Button(btnComp, SWT.NONE);
	    btnOk.setText("Send");
	    btnOk.addSelectionListener(new SelectionAdapter() {
	      public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
	    	session.getCurrentModel().getConfig().setMailtext(txtMailtext.getText());
    	    Collection<ExportResult> exportSongbooks = engine.exportSongbooks();
	    	engine.mailExportedSongbooks(exportSongbooks, session.getCurrentModel().getConfig().getMailtext());  
	        shell.dispose();
	      }
	    });

	    Button btnCancel = new Button(btnComp, SWT.NONE);
	    btnCancel.setText("Cancel");
	    btnCancel.addSelectionListener(new SelectionAdapter() {
	      public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
	    	  shell.dispose();
	      }
	    });
	  }

}
