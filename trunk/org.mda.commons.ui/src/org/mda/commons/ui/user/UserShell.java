package org.mda.commons.ui.user;

import javax.inject.Inject;
import javax.inject.Singleton;
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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.mda.ApplicationSession;


public class UserShell extends Shell{

  
  private ApplicationSession session;


  private Text txtFamilyName;

  private Text txtFirstName;

  private Text txtMail;

  private Table tblUsers;

  private TableViewer tblUsersViewer;

  private User currentUser;

  private Button chkWithChords;


  @Inject
  public UserShell (final Shell shell, ApplicationSession session) {
    setSize(800, 700);
    this.session = session;

    setLayout(new GridLayout(2, false));
    setText("Edit users...");

    tblUsers = new Table(this, SWT.NONE);
    tblUsers.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
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

  private GridData getLabelData () {
    return new GridData(SWT.BEGINNING, SWT.CENTER, false, false);
  }

  private GridData getContentData () {
    return new GridData(SWT.FILL, SWT.FILL, true, false);
  }

  private GridData getGapData () {
    return new GridData(SWT.FILL, SWT.FILL, true, true);
  }

  private void refreshDetails () {
    StructuredSelection structSelection = (StructuredSelection) tblUsersViewer.getSelection();
    currentUser = (User) structSelection.getFirstElement();

    txtFamilyName.setEnabled(currentUser != null);
    txtFirstName.setEnabled(currentUser != null);
    txtMail.setEnabled(currentUser != null);
    chkWithChords.setEnabled(currentUser != null);
    txtFamilyName.setText(currentUser != null ? currentUser.getName(): "");
    txtFirstName.setText(currentUser != null ? currentUser.getFirstname(): "");
    txtMail.setText(currentUser != null ? currentUser.getMail(): "");
    //chkWithChords.setSelection(currentUser != null ? currentUser.is)
  }

  private Composite createDetailsPanel () {
    Composite comp = new Composite(this, SWT.NONE);
    comp.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
    comp.setLayout(new GridLayout(2, false));

    Label lblFamilyName = new Label (comp, SWT.NONE);
    lblFamilyName.setText("Name:");
    lblFamilyName.setLayoutData(getLabelData());
    txtFamilyName = new Text (comp, SWT.NONE);
    txtFamilyName.setLayoutData(getContentData());

    Label lblFirstname = new Label (comp, SWT.NONE);
    lblFirstname.setText("First name:");
    lblFirstname.setLayoutData(getLabelData());
    txtFirstName = new Text (comp, SWT.NONE);
    txtFirstName.setLayoutData(getContentData());

    Label lblMail = new Label (comp, SWT.NONE);
    lblMail.setText("E-Mail:");
    lblMail.setLayoutData(getLabelData());
    txtMail = new Text (comp, SWT.NONE);
    txtMail.setLayoutData(getContentData());

    Label lblChords = new Label (comp, SWT.NONE);
    lblChords.setText("Chords:");
    lblChords.setLayoutData(getLabelData());
    chkWithChords = new Button(comp, SWT.CHECK);


    Label lblGap = new Label(comp, SWT.NONE);
    lblGap.setLayoutData(getGapData());
    lblGap = new Label(comp, SWT.NONE);
    lblGap.setLayoutData(getGapData());

    createButtonPanel(comp);

    return comp;
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
    //TODO

    session.saveModel();
  }


  protected void checkSubclass () {
    /* Do nothing - Subclassing is allowed */
  }

}
