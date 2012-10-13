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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;
import org.mda.ApplicationSession;
import org.mda.commons.ui.util.UIUtils;


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
	configShell.setText("Global configurations");
    configShell.setSize(600, 600);
    configShell.setLayout(UIUtils.createLayout(2, 20));

    //Fontsize
    Label lblFontsize = new Label (configShell, SWT.NONE);
    lblFontsize.setText("Fontsize:");
    lblFontsize.setLayoutData(UIUtils.getLabelData());
    
    Configuration configuration = session.getConfig();

    spnFontSize = new Spinner(configShell, SWT.NONE);
    if (configuration.getFontsize() != null)
      spnFontSize.setSelection(configuration.getFontsize());
    spnFontSize.setLayoutData(UIUtils.getContentData());

    if (session.getFeatureActivation().isShowGridEnabled()) {
      Label lblGrid = new Label (configShell, SWT.NONE);
      lblGrid.setText("Grid:");
      lblGrid.setLayoutData(UIUtils.getLabelData());

      chkEnableGrid = new Button(configShell, SWT.CHECK);
      chkEnableGrid.setSelection(session.getGlobalConfs().isShowGrid());
      chkEnableGrid.setLayoutData(UIUtils.getContentData());
    }
    
    Group mailgroup = new Group(configShell, SWT.SHADOW_IN);
    mailgroup.setText("Mail");
    mailgroup.setLayoutData(UIUtils.getContentData(2));
    mailgroup.setLayout(UIUtils.createLayout(2, 10));
    
    Label lblMailserverUrl = new Label (mailgroup, SWT.NONE);
    lblMailserverUrl.setText("Mailserver URL:");
    lblMailserverUrl.setLayoutData(UIUtils.getLabelData());
    
    txtMailserverUrl = new Text(mailgroup, SWT.NONE);
    txtMailserverUrl.setText(configuration.getMailserverUrl() != null ? configuration.getMailserverUrl() : "");
    txtMailserverUrl.setLayoutData(UIUtils.getContentData());
    
    Label lblMailserverUser = new Label (mailgroup, SWT.NONE);
    lblMailserverUser.setText("Mailserver User:");
    lblMailserverUser.setLayoutData(UIUtils.getLabelData());
    
    txtMailserverUser = new Text(mailgroup, SWT.NONE);
    txtMailserverUser.setText(configuration.getMailserverUser() != null ? configuration.getMailserverUser() : "");
    txtMailserverUser.setLayoutData(UIUtils.getContentData());
    
    Label lblMailserverPassword = new Label (mailgroup, SWT.NONE);
    lblMailserverPassword.setText("Mailserver Password:");
    lblMailserverPassword.setLayoutData(UIUtils.getLabelData());
    
    txtMailserverPassword = new Text(mailgroup, SWT.PASSWORD);
    txtMailserverPassword.setText(configuration.getMailserverPassword() != null ? configuration.getMailserverPassword() : "");
    txtMailserverPassword.setLayoutData(UIUtils.getContentData());

    Label lblExtender = new Label (configShell, SWT.NONE);
    lblExtender.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true, 2, 1));

    Label lblBorder = new Label (configShell, SWT.SEPARATOR | SWT.HORIZONTAL);
	lblBorder.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

    createButtonPanel(configShell);

    configShell.open ();
    return configShell;
  }



  private void createButtonPanel (final Composite composite) {
    Composite buttonPanel = new Composite(composite, SWT.NONE);
    RowLayout buttonLayout = new RowLayout(SWT.HORIZONTAL);
    buttonLayout.spacing = 10;
    buttonPanel.setLayout(buttonLayout);
    buttonPanel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 2, 1));

    Button btnCancel = new Button(buttonPanel, SWT.NONE);
    btnCancel.setText("Cancel");
    btnCancel.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected (SelectionEvent arg0) {
        composite.dispose();
      }
    });
    
    Button btnOk = new Button(buttonPanel, SWT.NONE);
    btnOk.setText("Ok");
    btnOk.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected (SelectionEvent arg0) {
        save ();
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
