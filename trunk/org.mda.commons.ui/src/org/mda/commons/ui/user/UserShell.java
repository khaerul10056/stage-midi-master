package org.mda.commons.ui.user;

import java.util.Collection;

import javax.inject.Inject;

import mda.User;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.Table;
import org.mda.ApplicationSession;
import org.mda.commons.ui.Util;
import org.mda.commons.ui.util.UIUtils;


public class UserShell extends Shell{

  
  private ApplicationSession session;

  private Collection <IUserTab> userTabs;

  
  
  Table tblUsers;

  TableViewer tblUsersViewer;

  User currentUser;

  
  
  


  @Inject
  public UserShell (final Shell shell, ApplicationSession session, Collection <IUserTab> userTabs) {
    setSize(800, 700);
    Util.centreShell(this);
    this.session = session;
    this.userTabs = userTabs;

    setLayout(new GridLayout(2, false));
    setText("Edit users...");

    tblUsers = new Table(this, SWT.NONE);
    GridData gdTable = UIUtils.getLabelData(); 
    gdTable.grabExcessVerticalSpace = true;
    gdTable.verticalAlignment = SWT.FILL;
    gdTable.widthHint = 250;
    tblUsers.setLayoutData(gdTable);
    tblUsersViewer = new TableViewer(tblUsers);
    tblUsersViewer.setContentProvider(new UserContentProvider());
    tblUsersViewer.setLabelProvider(new UserLabelProvider());
    tblUsersViewer.setInput(session.getCurrentModel());

    tblUsersViewer.addSelectionChangedListener(new ISelectionChangedListener() {

      @Override
      public void selectionChanged (SelectionChangedEvent arg0) {
        refreshDetails();

      }
    });


    createDetailsPanel();

    tblUsers.setSelection(0);

    refreshDetails();





    open ();
  }

  

  void refreshDetails () {
    StructuredSelection structSelection = (StructuredSelection) tblUsersViewer.getSelection();
    currentUser = (User) structSelection.getFirstElement();
    
    for (IUserTab nextTab: userTabs) {
    	nextTab.load(currentUser);
    }

    
  }

  private Composite createDetailsPanel () {
		Composite detailComp = new Composite(this, SWT.NONE);
		detailComp.setLayoutData(UIUtils.getContentData());
		detailComp.setLayout(new GridLayout(1, false));
		
		TabFolder folder = new TabFolder(detailComp, SWT.NONE);
		GridData gdTabFolder = UIUtils.getContentData();
		gdTabFolder.grabExcessVerticalSpace = true;
		gdTabFolder.grabExcessHorizontalSpace = true;
		folder.setLayoutData(gdTabFolder);
		
		for (IUserTab nextTab : userTabs) {
			nextTab.build(folder);
		}

    createButtonPanel(detailComp);

    return detailComp;
  }

  private void createButtonPanel (Composite composite) {
    Composite buttonPanel = new Composite(composite, SWT.NONE);
    buttonPanel.setLayoutData(UIUtils.getLabelData());
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
	  for (IUserTab nextTab: userTabs) {
	    	nextTab.save(currentUser);
	    }
  }


  protected void checkSubclass () {
    /* Do nothing - Subclassing is allowed */
  }

}
