package org.mda.commons.ui.additionals;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import mda.AdditionalType;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.mda.additionals.Additional;
import org.mda.additionals.AdditionalsHandler;


public class AdditionalShell extends Shell {

  private AdditionalsHandler handler;

  private Combo cmbType;
  private List lstItems;

  private AdditionalType currentType = AdditionalType.IMAGE;

  private AdditionalContentProvider contentProvider = new AdditionalContentProvider();
  private AdditionalLabelProvider labelProvider = new AdditionalLabelProvider();

  private ListViewer viewer;

  private Label lblPreview;
  private boolean select;

  private AdditionalType onlyType;

  private Additional currentSelection;

  public Additional getSelected () {
    return currentSelection;
  }


  private void buildButtons () {
    Composite btnComp = new Composite(this, SWT.NONE);
    btnComp.setLayout(new RowLayout(SWT.HORIZONTAL));
    int anzahlButtons = select ? 3 : 2;
    btnComp.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, anzahlButtons, 1));

    Button btnImport = new Button(btnComp, SWT.NONE);
    btnImport.setText("Import");
    btnImport.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
        FileDialog dialog = new FileDialog(getShell());
        dialog.open();

        String [] filenames = dialog.getFileNames();
        Collection <File> files = new ArrayList<File>();
        for (String next:filenames)
          files.add(new File (dialog.getFilterPath(), next));

        String importFiles = handler.importFiles(files);

        if (importFiles.length() > 0) {
          Status status = new Status( IStatus.ERROR, "org.mda.commons.ui", importFiles);
          ErrorDialog.openError(getShell(), "Error checking out", "Please check the errorlog-view", status);
        }

        refreshView(currentType);


      }
    });

    if (select) {
      Button btnSelect = new Button(btnComp, SWT.NONE);
      btnSelect.setText("Select");
      btnSelect.addSelectionListener(new SelectionAdapter() {

        public void widgetSelected (org.eclipse.swt.events.SelectionEvent e) {
          if (viewer.getSelection() != null && viewer.getSelection() instanceof IStructuredSelection) {
            IStructuredSelection structSelection = (IStructuredSelection) viewer.getSelection();
            if (structSelection.getFirstElement() != null && structSelection.getFirstElement() instanceof Additional)
              currentSelection = (Additional) structSelection.getFirstElement();
          }

          dispose();
        }
      });
    }

    Button btnCancel = new Button(btnComp, SWT.NONE);
    btnCancel.setText("Cancel");
    btnCancel.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
        dispose();
      }
    });


  }

  public AdditionalShell (final Shell parent, final AdditionalsHandler handler, final AdditionalType onlyType, final boolean select) {
    this.handler = handler;
    this.select = select;
    this.onlyType = onlyType;
    setText("Additionals - " + handler.getAdditionalsPath().getAbsolutePath());
    setLayout(new GridLayout(2, false));

    if (onlyType == null) {
      cmbType = new Combo(this, SWT.NONE);

      for (AdditionalType nextType : AdditionalType.VALUES) {
        cmbType.add(nextType.toString());
      }

      cmbType.select(0);
      GridData gd = new GridData(SWT.BEGINNING, SWT.FILL, false, false);
      gd.horizontalSpan = 2;
      cmbType.setLayoutData(gd);
      cmbType.addSelectionListener(new SelectionAdapter() {

        @Override
        public void widgetSelected (SelectionEvent arg0) {
          if (arg0.widget.equals(cmbType)) {
            int selected = cmbType.getSelectionIndex();
            refreshView(AdditionalType.VALUES.get(selected));
          }
        }
      });
    }




    lstItems = new List(this, SWT.SCROLL_LINE);
    GridData gd = new GridData(SWT.BEGINNING, SWT.FILL, false, true);
    gd.widthHint = 350;
    lstItems.setLayoutData(gd);
    viewer = new ListViewer(lstItems);
    viewer.setLabelProvider(labelProvider);
    viewer.setContentProvider(contentProvider);

    lblPreview = new Label (this, SWT.NONE);
    lblPreview.setBackground(getDisplay().getSystemColor(SWT.COLOR_DARK_GRAY));
    GridData gd1 = new GridData(SWT.FILL, SWT.FILL, true, true);
    gd1.verticalSpan = 2;
    lblPreview.setLayoutData(gd1);

    refreshView (currentType);



    viewer.addSelectionChangedListener(new ISelectionChangedListener() {

      @Override
      public void selectionChanged (SelectionChangedEvent arg0) {
        if (arg0.getSelection() instanceof IStructuredSelection)  {
          IStructuredSelection structselection = (IStructuredSelection) arg0.getSelection();
          if (structselection.getFirstElement() instanceof Additional) {
            Additional additional = (Additional) structselection.getFirstElement();
            lblPreview.setBackgroundImage(additional.getImageScaled(lblPreview.getSize().x, lblPreview.getSize().y));
            return;
          }
        }

        lblPreview.setBackgroundImage(null);
      }
    });

    buildButtons();

    open();

  }

  public void refreshView (final AdditionalType type) {

    contentProvider.setCurrentType(type);
    viewer.setInput(handler);



  }

  @Override
  public void checkSubclass () {
  }


  public static void main (String [] args) throws Exception {
    File forTest = new File ("test");
    Shell shell = new Shell ();
    AdditionalsHandler handler = new AdditionalsHandler(forTest);
    handler.read();
    final String name1 = "This is a crazy song";
    final String suffix1 = "mp3";
    final String suffix2 = "midi";
    File mp3File = new File (handler.getAdditionalsPath().getAbsolutePath() + "/" + AdditionalType.AUDIO.name().toLowerCase() +"/" + name1 + "." + suffix1);
    mp3File.createNewFile();

    File midifile = new File (handler.getAdditionalsPath().getAbsolutePath() + "/" + AdditionalType.MIDIFILE.name().toLowerCase() +"/" + name1 + "." +  suffix2);
    midifile.createNewFile();



    AdditionalShell additionalshell = new AdditionalShell(shell, handler, null, true);



    while (!additionalshell.isDisposed()) {
      if (!shell.getDisplay().readAndDispatch()) {
        shell.getDisplay().sleep();
      }
    }

  }

}
