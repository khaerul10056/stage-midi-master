package org.mda.commons.ui.config;

import javax.inject.Inject;

import mda.Configuration;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;
import org.mda.ApplicationSession;


@Creatable
public class ConfigShellBuilder  {

  private Spinner spnFontSize;

  private Button chkEnableGrid;
  
  private Text txtMailserverUrl;
  
  private Text txtMailserverUser;
  
  private Text txtMailserverPassword;

  @Inject
  private ApplicationSession session;
  
  
  public Configuration getConfiguration () {
	  return session.getConfig();
  }
  
  public Shell build (final Shell mother) {
	Shell configShell = new Shell (mother); 
    configShell.setSize(500, 700);

    configShell.setLayout(new GridLayout(2, false));

    //Fontsize
    Label lblFontsize = new Label (configShell, SWT.NONE);
    lblFontsize.setText("Fontsize:");
    lblFontsize.setLayoutData(getLabelData());
    
    Configuration configuration = session.getConfig();

    spnFontSize = new Spinner(configShell, SWT.NONE);
    if (configuration.getFontsize() != null)
      spnFontSize.setSelection(configuration.getFontsize());
    spnFontSize.setLayoutData(getContentData());

    if (session.getFeatureActivation().isShowGridEnabled()) {
      Label lblGrid = new Label (configShell, SWT.NONE);
      lblGrid.setText("Grid:");
      lblGrid.setLayoutData(getLabelData());

      chkEnableGrid = new Button(configShell, SWT.CHECK);
      chkEnableGrid.setSelection(session.getGlobalConfs().isShowGrid());
      chkEnableGrid.setLayoutData(getContentData());
    }
    
    Label lblMailserverUrl = new Label (configShell, SWT.NONE);
    lblMailserverUrl.setText("Mailserver URL:");
    lblMailserverUrl.setLayoutData(getLabelData());
    
    txtMailserverUrl = new Text(configShell, SWT.NONE);
    txtMailserverUrl.setText(configuration.getMailserverUrl() != null ? configuration.getMailserverUrl() : "");
    txtMailserverUrl.setLayoutData(getContentData());
    
    Label lblMailserverUser = new Label (configShell, SWT.NONE);
    lblMailserverUser.setText("Mailserver User:");
    lblMailserverUser.setLayoutData(getLabelData());
    
    txtMailserverUser = new Text(configShell, SWT.NONE);
    txtMailserverUser.setText(configuration.getMailserverUser() != null ? configuration.getMailserverUser() : "");
    txtMailserverUser.setLayoutData(getContentData());
    
    Label lblMailserverPassword = new Label (configShell, SWT.NONE);
    lblMailserverPassword.setText("Mailserver Password:");
    lblMailserverPassword.setLayoutData(getLabelData());
    
    txtMailserverPassword = new Text(configShell, SWT.PASSWORD);
    txtMailserverPassword.setText(configuration.getMailserverPassword() != null ? configuration.getMailserverPassword() : "");
    txtMailserverPassword.setLayoutData(getContentData());

    Label lblExtender = new Label (configShell, SWT.NONE);
    lblExtender.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true, 2, 1));


    createButtonPanel(configShell);

    configShell.open ();
    return configShell;
  }


  private GridData getLabelData () {
    return new GridData(SWT.BEGINNING, SWT.CENTER, false, false);
  }

  private GridData getContentData () {
    return new GridData(SWT.FILL, SWT.FILL, false, false);
  }

  private void createButtonPanel (final Composite composite) {
    Composite buttonPanel = new Composite(composite, SWT.NONE);
    buttonPanel.setLayout(new RowLayout(SWT.HORIZONTAL));
    Button btnOk = new Button(buttonPanel, SWT.NONE);
    btnOk.setText("Ok");
    btnOk.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected (SelectionEvent arg0) {
        save ();
        composite.dispose();
      }
    });

    Button btnCancel = new Button(buttonPanel, SWT.NONE);
    btnCancel.setText("Cancel");
    btnCancel.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected (SelectionEvent arg0) {
        composite.dispose();
      }
    });
  }

  protected void save () {
    getConfiguration().setFontsize(spnFontSize.getSelection());
    getConfiguration().setMailserverUrl(txtMailserverUrl.getText());
    getConfiguration().setMailserverUser(txtMailserverUser.getText());
    getConfiguration().setMailserverPassword(txtMailserverPassword.getText());
    session.getGlobalConfs().setShowGrid(chkEnableGrid.getSelection());

    session.saveModel();
  }



  protected void checkSubclass () {
    /* Do nothing - Subclassing is allowed */
  }

}
