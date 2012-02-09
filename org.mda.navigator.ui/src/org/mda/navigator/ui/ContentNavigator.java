package org.mda.navigator.ui;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import mda.AbstractSessionItem;
import mda.Gallery;
import mda.Session;
import mda.impl.MidiFileImpl;
import mda.impl.SessionImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;
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
import org.mda.ApplicationSession;
import org.mda.MidiPlayerService;
import org.mda.commons.ui.ContentProvider;
import org.mda.commons.ui.DefaultMidiFileContentEditorConfig;
import org.mda.commons.ui.LabelProvider;
import org.mda.commons.ui.MidiFileEditorInput;
import org.mda.commons.ui.NewSessionPanel;
import org.mda.commons.ui.NewSongPanel;
import org.mda.commons.ui.SessionGroup;
import org.mda.commons.ui.SongSelectorPanel;
import org.mda.commons.ui.navigator.NavigatorItem;
import org.mda.export.powerpoint.Exporter;
import org.mda.presenter.ui.BeamerPresenter;
import org.mda.presenter.ui.slide.GlobalKeyRegistryPresentationController;

public class ContentNavigator extends ViewPart {

  private static final Logger LOGGER  = Logger.getLogger(ContentNavigator.class.getName());

  private Text                txtSearchfield;

  private Tree                treModel;

  private ApplicationSession  appSession = ApplicationSession.getInjector().getInstance(ApplicationSession.class);

  private MenuItem            itemPowerpoint;

  private TreeViewer treviewer;

  private HashMap<Class<? extends EObject>, String> editors = new HashMap<Class<? extends EObject>, String>();

  private MenuItem itemAdd;

  private MenuItem itemRemove;

  private ContentProvider contentprovider;

  private MenuItem itemUp;

  private MenuItem itemDown;

  private MenuItem itemStart;

  private MenuItem itemPreview;


  public ContentNavigator () {
    editors.put(MidiFileImpl.class, "org.mda.editor.preview.ui.editors.previeweditor");
    editors.put(SessionImpl.class, "org.mda.editor.session.ui.editors.sessioneditor");
  }


  private Session getSessionFromSelection (final SelectionEvent e) {
    Object object = getSelected(treviewer.getSelection());
    System.out.println ("Selected " + object);

    Session session = null;
    AbstractSessionItem selectedItem = null;

    if (object instanceof NavigatorItem) {
      NavigatorItem<AbstractSessionItem> item = (NavigatorItem<AbstractSessionItem>) object;
      selectedItem = item.getModelElement();

      if (item.getMother() instanceof Session)
        session = (Session) item.getMother();

    }
    else if (object instanceof Session) {
      session = (Session)object;
    }

    return session;
  }

  private Menu createContextMenu (final Tree tree) {
    final Menu menu = new Menu (tree);


    itemPreview = new MenuItem(menu, SWT.PUSH);
    itemPreview.setText("Preview...");
    itemPreview.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected (org.eclipse.swt.events.SelectionEvent e) {
        Session session = getSessionFromSelection(e);
        AbstractSessionItem selectedItem = null;

        if (session != null) {
          final GlobalKeyRegistryPresentationController controller = new GlobalKeyRegistryPresentationController(menu.getDisplay());
          DefaultMidiFileContentEditorConfig config = new DefaultMidiFileContentEditorConfig();
          config.setChordVisible(false);
          BeamerPresenter presenter = new BeamerPresenter(menu.getDisplay(), session, controller, config);
          if (selectedItem != null)
            controller.toItem(selectedItem);

          presenter.addDisposeListener(new DisposeListener() {

            @Override
            public void widgetDisposed (DisposeEvent arg0) {
              controller.close();
            }
          });

          presenter.setBounds(new Rectangle(tree.getShell().getBounds().x, tree.getShell().getBounds().y, 1024, 768)); // TODO adapt size
          presenter.setEnabled(true);
        }
      }
    });

    itemStart = new MenuItem(menu, SWT.PUSH);
    itemStart.setText("Run...");
    itemStart.addSelectionListener(new SelectionAdapter() {

      public void widgetSelected (org.eclipse.swt.events.SelectionEvent e) {
        Session session = getSessionFromSelection(e);
        AbstractSessionItem selectedItem = null;

        if (session != null) {
          final GlobalKeyRegistryPresentationController controller = new GlobalKeyRegistryPresentationController(menu.getDisplay());
          DefaultMidiFileContentEditorConfig config = new DefaultMidiFileContentEditorConfig();
          config.setChordVisible(false);
          BeamerPresenter presenter = new BeamerPresenter(menu.getDisplay(), session, controller, config);
          if (selectedItem != null)
            controller.toItem(selectedItem);

          presenter.addDisposeListener(new DisposeListener() {

            @Override
            public void widgetDisposed (DisposeEvent arg0) {
              controller.close();
            }
          });

          presenter.setEnabled(true);
        }
        //TODO else errormessage
      }

    });

    itemPowerpoint = new MenuItem(menu, SWT.PUSH);
    itemPowerpoint.setText("Export powerpoint (.ppt)");

    itemPowerpoint.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
        Session session = (Session) getSelected(treviewer.getSelection());
        Exporter exporter = new Exporter();
        try {
          File file = new File (appSession.getExportPath().getAbsolutePath() + File.separator + session.getName() + ".ppt");

          exporter.export(session.getItems(), file);

          MessageDialog.openConfirm(getSite().getShell(), "Exportfiles saved", "Powerpoint-Exportfile saved in " + file.getAbsolutePath());


        }
        catch (IOException e1) {
          LOGGER.log(Level.SEVERE, e1.getLocalizedMessage(), e1);
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

  private void insert () {
    Object object =  getSelected(treviewer.getSelection());

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

  private void remove () {
    Object object =  getSelected(treviewer.getSelection());

    if (object instanceof NavigatorItem) {
      NavigatorItem<?> item = (NavigatorItem<?>) object;
      item.remove();
      refresh();
    }

    if (object instanceof Session) {
      Collection <Session> session = new ArrayList<Session>();
      session.add((Session) object);
      MidiPlayerService.removeSessions(session);
      refresh();
    }
  }

  private void moveDown () {
    Object object =  getSelected(treviewer.getSelection());

    if (object instanceof NavigatorItem) {
      NavigatorItem<?> item = (NavigatorItem<?>) object;
      item.moveDown();
      refresh();
    }
  }

  private void moveUp () {
    Object object =  getSelected(treviewer.getSelection());
    if (object instanceof NavigatorItem) {
      NavigatorItem<?> item = (NavigatorItem<?>) object;
      item.moveUp();
      refresh();
    }
  }


  private Object getSelected (ISelection selection) {
    if (selection instanceof IStructuredSelection) {
      IStructuredSelection structSelection = (IStructuredSelection) selection;
      return structSelection.getFirstElement();
    }

    return null;
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

        Object object = getSelected(arg0.getSelection());

        if (object instanceof NavigatorItem)
          object = ((NavigatorItem) object).getModelElement();
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
          LOGGER.log(Level.SEVERE, e.getLocalizedMessage(), e);
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

          //boolean currentItemIsMidiFile = selectedObject instanceof MidiFile; TODO
          boolean currentItemIsSession = selectedObject instanceof Session;
          boolean currentItemIsGallery = selectedObject instanceof Gallery;
          boolean currentItemIsNavigatorItem = selectedObject instanceof NavigatorItem;
          boolean currentItemIsSessionGroup = selectedObject instanceof SessionGroup;

          itemPowerpoint.setEnabled(currentItemIsSession);
          itemAdd.setEnabled(currentItemIsSession || currentItemIsGallery || currentItemIsSessionGroup);
          itemRemove.setEnabled(currentItemIsNavigatorItem || currentItemIsSession);
          itemUp.setEnabled(currentItemIsNavigatorItem);
          itemDown.setEnabled(currentItemIsNavigatorItem);
        }

      }

    });

  }

  @Override
  public void setFocus () {
    // TODO Auto-generated method stub

  }

}
