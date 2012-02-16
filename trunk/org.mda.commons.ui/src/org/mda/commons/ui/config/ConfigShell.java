package org.mda.commons.ui.config;

import mda.Configuration;
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
import org.mda.ApplicationSession;


public class ConfigShell extends Shell {

  private Configuration configuration;


  private Spinner spnFontSize;

  private ApplicationSession session = ApplicationSession.getInjector().getInstance(ApplicationSession.class);



  public ConfigShell (final Shell shell, final Configuration configuration) {
    this.configuration = configuration;
    setSize(500, 700);

    setLayout(new GridLayout(2, false));

    //Fontsize
    Label lblFontsize = new Label (this, SWT.NONE);
    lblFontsize.setText("Fontsize:");
    lblFontsize.setLayoutData(getLabelData());

    spnFontSize = new Spinner(this, SWT.NONE);
    if (configuration.getFontsize() != null)
      spnFontSize.setSelection(configuration.getFontsize());
    spnFontSize.setLayoutData(getContentData());

    Label lblExtender = new Label (this, SWT.NONE);
    lblExtender.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true, 2, 1));


    createButtonPanel(this);

    open ();
  }


  private GridData getLabelData () {
    return new GridData(SWT.BEGINNING, SWT.CENTER, false, false);
  }

  private GridData getContentData () {
    return new GridData(SWT.FILL, SWT.FILL, false, false);
  }

  private void createButtonPanel (Composite composite) {
    Composite buttonPanel = new Composite(composite, SWT.NONE);
    buttonPanel.setLayout(new RowLayout(SWT.HORIZONTAL));
    Button btnOk = new Button(buttonPanel, SWT.NONE);
    btnOk.setText("Ok");
    btnOk.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected (SelectionEvent arg0) {
        save ();

        dispose();

      }
    });

    Button btnCancel = new Button(buttonPanel, SWT.NONE);
    btnCancel.setText("Cancel");
    btnCancel.addSelectionListener(new SelectionAdapter() {

      @Override
      public void widgetSelected (SelectionEvent arg0) {

        dispose();
      }

    });

  }

  protected void save () {
    configuration.setFontsize(spnFontSize.getSelection());

    session.saveModel();
  }



  protected void checkSubclass () {
    /* Do nothing - Subclassing is allowed */
  }

}
