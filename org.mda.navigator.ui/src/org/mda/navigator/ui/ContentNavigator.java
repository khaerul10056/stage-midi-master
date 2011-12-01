package org.mda.navigator.ui;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mda.MidiFile;
import mda.Session;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.mda.commons.ui.ApplicationSession;
import org.mda.commons.ui.MidiFileEditorInput;
import org.mda.export.powerpoint.Exporter;

public class ContentNavigator extends ViewPart {

  private static final Logger LOGGER  = Logger.getLogger(ContentNavigator.class.getName());

  private Text                txtSearchfield;

  private Tree                treModel;

  private ApplicationSession  appSession = new ApplicationSession();

  private MenuItem            itemPowerpoint;

  private TreeViewer treviewer;

  private Menu createContextMenu (Tree tree) {
    Menu menu = new Menu (tree);
    itemPowerpoint = new MenuItem(menu, SWT.PUSH);
    itemPowerpoint.setText("Export powerpoint (.ppt)");

    itemPowerpoint.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
        IStructuredSelection structSelection = (IStructuredSelection) treviewer.getSelection();
        Session session = (Session) structSelection.getFirstElement();
        Exporter exporter = new Exporter();
        try {
          exporter.export(session.getItems(), new File (appSession.getExportPath().getAbsolutePath() + File.separator + session.getName() + ".ppt"));
        }
        catch (IOException e1) {
          LOGGER.log(Level.SEVERE, e1.getLocalizedMessage(), e1);
        }
      }
    });


    return menu;

  }



  @Override
  public void createPartControl (Composite arg0) {
    txtSearchfield = new Text(arg0, SWT.NONE);
    txtSearchfield.setText("Please type to search a song or a session...");

    arg0.setLayout(new GridLayout(1, false));

    treModel = new Tree(arg0, SWT.NONE);
    treModel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
    treviewer = new TreeViewer(treModel);
    treviewer.setContentProvider(new ContentProvider());
    treviewer.setLabelProvider(new LabelProvider());
    treviewer.setInput(appSession);
    treviewer.expandAll();

    treModel.setMenu(createContextMenu(treModel));

    treviewer.addDoubleClickListener(new IDoubleClickListener() {

      @Override
      public void doubleClick (DoubleClickEvent arg0) {
        if (arg0.getSelection() instanceof IStructuredSelection) {
          IStructuredSelection structSelection = (IStructuredSelection) arg0.getSelection();
          Object selectedObject = structSelection.getFirstElement();
          if (selectedObject instanceof MidiFile) {
            IEditorInput editorInput = new MidiFileEditorInput((MidiFile) selectedObject);
            IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
            IWorkbenchPage page = window.getActivePage();
            try {
              page.openEditor(editorInput, "org.mda.editor.preview.ui.editors.previeweditor");
            }
            catch (PartInitException e) {
              LOGGER.log(Level.SEVERE, e.getLocalizedMessage(), e);
            }
          }
        }
      }
    });

    treviewer.addSelectionChangedListener(new ISelectionChangedListener() {

      @Override
      public void selectionChanged (SelectionChangedEvent arg0) {

        if (arg0.getSelection() instanceof IStructuredSelection) {
          IStructuredSelection structSelection = (IStructuredSelection) arg0.getSelection();
          Object selectedObject = structSelection.getFirstElement();

          boolean currentItemIsMidiFile = selectedObject instanceof MidiFile;
          boolean currentItemIsSession = selectedObject instanceof Session;

          itemPowerpoint.setEnabled(currentItemIsSession);
        }

      }

    });

  }

  @Override
  public void setFocus () {
    // TODO Auto-generated method stub

  }

}
