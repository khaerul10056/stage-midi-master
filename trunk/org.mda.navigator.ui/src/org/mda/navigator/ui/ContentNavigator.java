package org.mda.navigator.ui;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import mda.AbstractSessionItem;
import mda.ExportConfiguration;
import mda.Gallery;
import mda.MidiFile;
import mda.Session;
import mda.impl.MidiFileImpl;
import mda.impl.SessionImpl;
import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.part.ViewPart;
import org.mda.ApplicationSession;
import org.mda.MdaModule;
import org.mda.MidiPlayerService;
import org.mda.SelectionInfo;
import org.mda.commons.ui.ContentProvider;
import org.mda.commons.ui.LabelProvider;
import org.mda.commons.ui.MidiFileEditorInput;
import org.mda.commons.ui.NewSessionPanel;
import org.mda.commons.ui.NewSongPanel;
import org.mda.commons.ui.SessionGroup;
import org.mda.commons.ui.SongSelectorPanel;
import org.mda.commons.ui.Util;
import org.mda.commons.ui.imports.ImportShell;
import org.mda.commons.ui.navigator.NavigatorItem;
import org.mda.export.ExportException;
import org.mda.export.powerpoint.PptExporter;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;

public class ContentNavigator extends ViewPart {

  private static final Log LOGGER  = LogFactory.getLogger(ContentNavigator.class);

  private Text                txtSearchfield;

  private Tree                treModel;

  private ApplicationSession  appSession = MdaModule.getInjector().getInstance(ApplicationSession.class);

  private MenuItem            itemPowerpoint;

  private MenuItem            itemPdf;

  private TreeViewer treviewer;

  private HashMap<Class<? extends EObject>, String> editors = new HashMap<Class<? extends EObject>, String>();

  private MenuItem itemAdd;

  private MenuItem itemImportText;

  private MenuItem itemRemove;

  private ContentProvider contentprovider;

  private MenuItem itemUp;

  private MenuItem itemDown;

  private MenuItem itemStart;

  private MenuItem itemPreview;

  TreeViewer getTreeViewer () {
    return treviewer;
  }

  public ContentNavigator () {
    editors.put(MidiFileImpl.class, "org.mda.editor.preview.ui.editors.previeweditor");
    editors.put(SessionImpl.class, "org.mda.editor.session.ui.editors.sessioneditor");
  }


  public SelectionInfo getSessionFromSelection (final SelectionEvent e) {
    Object object = Util.getStructuredSelection(treviewer.getSelection());
    System.out.println ("Selected " + object);

    Session session = null;
    AbstractSessionItem selectedItem = null;

    if (object instanceof NavigatorItem) {
      NavigatorItem<? extends AbstractSessionItem> item = (NavigatorItem) object;
      selectedItem = item.getModelElement();

      if (item.getMother() instanceof Session)
        session = (Session) item.getMother();

    }
    else if (object instanceof Session) {
      session = (Session)object;
    }

    return new SelectionInfo(session, selectedItem);
  }

  private Menu createContextMenu (final Tree tree) {
    final Menu menu = new Menu (tree);


    itemPreview = new MenuItem(menu, SWT.PUSH);
    itemPreview.setText("Preview...");
    itemPreview.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected (org.eclipse.swt.events.SelectionEvent e) {
        SelectionInfo selectioninfo = getSessionFromSelection(e);

        if (selectioninfo != null) {
          selectioninfo.setPreview(true);
          IWorkbench workbench = getSite().getWorkbenchWindow().getWorkbench();
          ICommandService cmdService = (ICommandService) workbench.getService(ICommandService.class);
          Command cmd = cmdService.getCommand("org.mda.presenter.ui.commands.startPresentation");
          ExecutionEvent event = new ExecutionEvent(cmd, new HashMap<String, String>(), this, selectioninfo);
          try {
            cmd.executeWithChecks(event);
          }
          catch (Exception e1) {
              LOGGER.error(e1.getLocalizedMessage(), e1);
          }
        }
      }
    });

    itemStart = new MenuItem(menu, SWT.PUSH);
    itemStart.setText("Run...");
    itemStart.addSelectionListener(new SelectionAdapter() {

      public void widgetSelected (org.eclipse.swt.events.SelectionEvent e) {
        SelectionInfo selectioninfo = getSessionFromSelection(e);

        if (selectioninfo != null) {
          selectioninfo.setPreview(false);
          IWorkbench workbench = getSite().getWorkbenchWindow().getWorkbench();
          ICommandService cmdService = (ICommandService) workbench.getService(ICommandService.class);
          Command cmd = cmdService.getCommand("org.mda.presenter.ui.commands.startPresentation");
          ExecutionEvent event = new ExecutionEvent(cmd, new HashMap<String, String>(), this, selectioninfo);
          try {
            cmd.executeWithChecks(event);
          }
          catch (Exception e1) {
              LOGGER.error(e1.getLocalizedMessage(), e1);
          }
        }
      }

    });

    itemPowerpoint = new MenuItem(menu, SWT.PUSH);
    itemPowerpoint.setText("Export powerpoint (.ppt)");

    itemPowerpoint.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
        Session session = (Session) Util.getStructuredSelection(treviewer.getSelection());
        PptExporter exporter = new PptExporter();
        try {
          File file = new File (appSession.getExportPath().getAbsolutePath() + File.separator + session.getName() + ".ppt");

          ExportConfiguration conf = MidiPlayerService.mf.createExportConfiguration();
          conf.setWithChords(false);
          exporter.export(session.getItems(), file, conf);

          MessageDialog.openConfirm(getSite().getShell(), "Exportfiles saved", "Powerpoint-Exportfile saved in " + file.getAbsolutePath());


        }
        catch (ExportException e1) {
          LOGGER.error(e1.getLocalizedMessage(), e1);
        }
      }
    });
    itemImportText = new MenuItem(menu, SWT.PUSH);
    itemImportText.setText("Import text");
    itemImportText.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
        NavigatorItem item = (NavigatorItem) Util.getStructuredSelection(treviewer.getSelection());
        new ImportShell(getSite().getShell(), (MidiFile) item.getModelElement());



      }

    });


    itemPdf = new MenuItem(menu, SWT.PUSH);
    itemPdf.setText("Export pdf (.pdf)");

    itemPdf.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
        Gallery gallery = (Gallery) Util.getStructuredSelection(treviewer.getSelection());

        System.out.println (Platform.getBundle("org.mda.export.powerpoint").getLocation());

        org.mda.export.pdf.PdfExporter exporter = new org.mda.export.pdf.PdfExporter();
        try {
          File file = new File (appSession.getExportPath().getAbsolutePath() + File.separator + "songsheets.pdf");
          ExportConfiguration conf = MidiPlayerService.mf.createExportConfiguration();
          conf.setWithChords(false);

          exporter.export(gallery.getGalleryItems(), file, conf);

          MessageDialog.openConfirm(getSite().getShell(), "Exportfiles saved", "PDF-Exportfile saved in " + file.getAbsolutePath());


        }
        catch (Exception e1) {
          LOGGER.error(e1.getLocalizedMessage(), e1);
        }
      }
    });

    itemAdd = new MenuItem (menu, SWT.PUSH);
    itemAdd.setText("Add...");
    itemAdd.addSelectionListener(new SelectionAdapter () {
      public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
        insert();
      }
    });

    itemRemove = new MenuItem (menu, SWT.PUSH);
    itemRemove.setText("Remove");
    itemRemove.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
        remove();
      }
    });


    itemUp = new MenuItem (menu, SWT.PUSH);
    itemUp.setText ("Move up");
    itemUp.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
        moveUp();
      }
    });

    itemDown = new MenuItem (menu, SWT.PUSH);
    itemDown.setText ("Move down");
    itemDown.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
        moveDown();
      }
    });


    return menu;
  }

  public void insert () {
    Object object = Util.getStructuredSelection(treviewer.getSelection());

    //add a new song into gallery
    if (object instanceof Gallery) {
      NewSongPanel panel = new NewSongPanel();
      while (!panel.isDisposed()) {
        // Check for waiting events
        if (!panel.getDisplay().readAndDispatch())
          panel.getDisplay().sleep();
      }
      if (panel.getNewSong() != null) {
        Gallery gallery = (Gallery) object;
        gallery.getGalleryItems().add(panel.getNewSong());
        refresh();
      }
    }

    //add a new song from gallery into a session
    if (object instanceof Session) {
      Session session = (Session) object;
      SongSelectorPanel panel = new SongSelectorPanel();
      while (!panel.isDisposed()) {
        // Check for waiting events
        if (!panel.getDisplay().readAndDispatch())
          panel.getDisplay().sleep();
      }
      if (panel.getSelectedSongs().size() > 0) {
        MidiPlayerService.addSong (session, panel.getSelectedSongs());
        refresh();
      }
    }

    //add a new session
    if (object instanceof SessionGroup) {
      NewSessionPanel panel = new NewSessionPanel();
      while (!panel.isDisposed()) {
        // Check for waiting events
        if (!panel.getDisplay().readAndDispatch())
          panel.getDisplay().sleep();
      }
      if (panel.getNewSession() != null) {
        SessionGroup group = (SessionGroup) object;
        group.getRoot().getSessions().add(panel.getNewSession());
        refresh();
      }

    }

  }

  public void remove () {
    Object object = Util.getStructuredSelection(treviewer.getSelection());

    if (object instanceof NavigatorItem) {
      NavigatorItem<AbstractSessionItem> item = (NavigatorItem<AbstractSessionItem>) object;

      String referenced = MidiPlayerService.getReferenced(appSession.getCurrentModel(), item.getModelElement());
      boolean removeAnyway = true;
      if (referenced != null) {

      MessageBox messageBox = new MessageBox(getSite().getShell(), SWT.ICON_QUESTION | SWT.YES | SWT.NO);
      messageBox.setMessage(referenced);
      messageBox.setText("Current item is referenced");
      int response = messageBox.open();
      if (response == SWT.NO)
        removeAnyway = false;
      }

      if (removeAnyway) {
        MidiPlayerService.removeSongAndReferences(appSession.getCurrentModel(), item.getModelElement());
        refresh();
      }

    }

    if (object instanceof Session) {
      Collection <Session> session = new ArrayList<Session>();
      session.add((Session) object);
      MidiPlayerService.removeSessions(session);
      refresh();
    }
  }

  public void moveDown () {
    Object object = Util.getStructuredSelection(treviewer.getSelection());

    if (object instanceof NavigatorItem) {
      NavigatorItem<?> item = (NavigatorItem<?>) object;
      item.moveDown();
      refresh();
    }
  }

  public void moveUp () {
    Object object = Util.getStructuredSelection(treviewer.getSelection());
    if (object instanceof NavigatorItem) {
      NavigatorItem<?> item = (NavigatorItem<?>) object;
      item.moveUp();
      refresh();
    }
  }



  public void refresh () {
    IStructuredSelection selection = (IStructuredSelection) treviewer.getSelection();

    Object firstElement = selection.getFirstElement();

    treviewer.setInput(appSession);
    treviewer.expandAll();
    if (firstElement != null) {
      selection = new StructuredSelection(firstElement);
      treviewer.setSelection(selection);
    }
  }

  @Override
  public void createPartControl (Composite arg0) {
    txtSearchfield = new Text(arg0, SWT.NONE);
    txtSearchfield.setText("Please type to search a song or a session...");

    arg0.setLayout(new GridLayout(1, false));

    treModel = new Tree(arg0, SWT.NONE);
    treModel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
    treviewer = new TreeViewer(treModel);
    contentprovider = new ContentProvider();
    treviewer.setContentProvider(contentprovider);
    treviewer.setLabelProvider(new LabelProvider());
    refresh();


    treModel.setMenu(createContextMenu(treModel));

    treModel.addKeyListener(new KeyAdapter() {

      public void keyPressed (KeyEvent e) {
        if (e.keyCode == SWT.ARROW_UP && (e.stateMask & SWT.SHIFT) != 0) {
          moveUp();
          e.doit = false;
        }

        if (e.keyCode == SWT.ARROW_DOWN && (e.stateMask & SWT.SHIFT) != 0) {
          moveDown();
          e.doit = false;

        }

        if (e.keyCode == SWT.DEL) {
          remove();
          e.doit = false;
        }

        if (e.keyCode == SWT.INSERT) {
          insert();
          e.doit = false;
        }
      }


    });

    treviewer.addDoubleClickListener(new IDoubleClickListener() {

      @Override
      public void doubleClick (DoubleClickEvent arg0) {

        Object object = Util.getStructuredSelection(arg0.getSelection());

        if (object instanceof NavigatorItem)
          object = ((NavigatorItem<?>) object).getModelElement();
        if (object instanceof EObject) {
          EObject eobject = (EObject) object;
        String editorId = editors.get(eobject.getClass());

        IEditorInput editorInput = new MidiFileEditorInput(eobject);

        IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
        IWorkbenchPage page = window.getActivePage();
        try {
          page.openEditor(editorInput, editorId);
        }
        catch (PartInitException e) {
          LOGGER.error(e.getLocalizedMessage(), e);
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
          NavigatorItem<?> selectedNavigatorItem = null;
          if (selectedObject instanceof NavigatorItem)
            selectedNavigatorItem = (NavigatorItem<?>) selectedObject;

          //boolean currentItemIsMidiFile = selectedObject instanceof MidiFile; TODO
          boolean currentItemIsSession = selectedObject instanceof Session;
          boolean currentItemIsGallery = selectedObject instanceof Gallery;

          boolean currentItemIsNavigatorItem = selectedNavigatorItem != null;
          boolean currentItemIsNavigatorItemInSession = currentItemIsNavigatorItem  && selectedNavigatorItem.getMother() instanceof Session;
          boolean currentItemIsSessionGroup = selectedObject instanceof SessionGroup;

          itemPreview.setEnabled(currentItemIsNavigatorItemInSession);
          itemStart.setEnabled(currentItemIsNavigatorItemInSession);
          itemPowerpoint.setEnabled(currentItemIsSession);
          itemAdd.setEnabled(currentItemIsSession || currentItemIsGallery || currentItemIsSessionGroup);
          itemRemove.setEnabled(currentItemIsNavigatorItem || currentItemIsSession);
          itemUp.setEnabled(currentItemIsNavigatorItem);
          itemDown.setEnabled(currentItemIsNavigatorItem);
          itemPdf.setEnabled(currentItemIsGallery);
          itemImportText.setEnabled(currentItemIsNavigatorItem);
        }

      }

    });

  }

  @Override
  public void setFocus () {
    // TODO Auto-generated method stub

  }

}
