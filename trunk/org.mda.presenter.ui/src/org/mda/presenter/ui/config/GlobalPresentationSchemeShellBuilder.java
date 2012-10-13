package org.mda.presenter.ui.config;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.e4.core.di.annotations.Execute;
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

@Creatable
public class GlobalPresentationSchemeShellBuilder {
	
	@Inject
	private PresentationSchemaEditorBuilder editorBuilder;
	private Shell configShell;
	
	private void createButtonPanel (Composite composite) {
	    Composite buttonPanel = new Composite(composite, SWT.NONE);
	    GridData gd = new GridData(SWT.RIGHT, SWT.CENTER, true, false);
	    gd.verticalIndent = 10;
	    buttonPanel.setLayoutData(gd);
	    //buttonPanel.setLayoutData(UIUtils.getContentData());
	    RowLayout rl = new RowLayout(SWT.HORIZONTAL); 
	    rl.spacing = 10;
	    buttonPanel.setLayout(rl);
	    

	    Button btnCancel = new Button(buttonPanel, SWT.NONE);
	    btnCancel.setText("Cancel");
	    btnCancel.addSelectionListener(new SelectionAdapter() {

	      @Override
	      public void widgetSelected (SelectionEvent arg0) {
	        configShell.dispose();
	      }
	    });
	    
	    Button btnOk = new Button(buttonPanel, SWT.NONE);
	    btnOk.setText("Ok");
	    btnOk.addSelectionListener(new SelectionAdapter() {
	      @Override
	      public void widgetSelected (SelectionEvent arg0) {
	        editorBuilder.save(null);
	        configShell.dispose();
	      }
	    });

	  }
	
	@Execute
	public Shell build (Shell shell) {
		configShell = new Shell(shell);
		configShell.setSize(600, 500);
		configShell.setLayout(new GridLayout()); 
		configShell.setText("Configure global presentation schemas");
		
		editorBuilder.build(configShell, null);
		
		Label lblBorder = new Label (configShell, SWT.SEPARATOR | SWT.HORIZONTAL);
		lblBorder.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		createButtonPanel(configShell);
		
		configShell.setVisible(true);
		return configShell;
		
	}

}
