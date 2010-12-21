package org.mda.ui;

import java.awt.BorderLayout;
import java.awt.GraphicsDevice;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.sound.midi.MidiUnavailableException;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import mda.AbstractSessionItem;
import mda.MidiFile;
import mda.MidiPlayerRoot;
import mda.Session;

import org.mda.MidiPlayerListener;
import org.mda.MidiPlayerService;
import org.mda.PlayerMode;
import org.mda.export.PDFExporter;
import org.mda.player.IPlayer;
import org.mda.player.ManualPlayer;
import org.mda.player.MidiPlayer;
import org.mda.ui.util.NavigatorPanel;

public class MidiPlayerApplicationFrame extends JFrame implements ActionListener, MidiPlayerListener {

  /**
   *
   */
  private static final long serialVersionUID = -1129981358463133943L;

  private final SessionTable sessionTable;
  private final ItemDetailsPanel   detailcontrols;
  private final PerformanceFrame   performanceFrame;
  private final PresentationFrame presentationFrame;


  private IPlayer         player;

  private JMenuItem          menuItemExit;

  private JMenuItem          menuItemImportText;

  private JMenuItem          menuItemRemoveText;

  private MidiPlayerRoot     root;
  private JMenuItem menuItemSave;
  private JMenuBar menuBar;
  private JMenuItem menuItemAddSong;
  private Object menuItemRemoveSong;
  private JMenuItem menuItemConfig;

  private JMenuItem menuItemGallery;

  private JMenuItem menuItemChooseSession;

  private JMenuItem menuItemSessionDetails;

  private JMenuItem menuItemSongDetails;

  private JMenuItem menuItemExport;

  private NavigatorPanel outline;

private JMenuItem menuItemSongExport;



  public MidiPlayerApplicationFrame(MidiPlayerRoot root, GraphicsDevice gd) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
    super (gd.getDefaultConfiguration());
    this.root = root;
    setLayout(new BorderLayout());

    UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
    setSize(Toolkit.getDefaultToolkit().getScreenSize());
    setTitle("MDA - Midi Driven Application (" + root.eResource().getURI().toString() + ")");
    setExtendedState(JFrame.MAXIMIZED_BOTH);

    try {
		player = new MidiPlayer(root);
	} catch (MidiUnavailableException e1) {
		player = new ManualPlayer(root);
	}

    player.addMidiPlayerListener(this);

    GraphicsDevice grahpicsDevicePresentation = GuiHelper.findGraphicsDevice(root.getConfig().getScreenIDPresentation());
    presentationFrame = new PresentationFrame(grahpicsDevicePresentation.getDefaultConfiguration(), player);
    performanceFrame = new PerformanceFrame(gd.getDefaultConfiguration(), getPlayer());

    detailcontrols = new ItemDetailsPanel(this);
    sessionTable = new SessionTable(this);
    outline = new NavigatorPanel(this);

    setJMenuBar(createMainMenu());

    GuiHelper.layout(this, false);

    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }

      public void windowIconified(WindowEvent e) {
      }
    });

    JPanel panNavigation = new JPanel();
    panNavigation.setLayout(new BorderLayout(5, 5));
    panNavigation.add(getSessionTable(), BorderLayout.CENTER);
    panNavigation.add(outline, BorderLayout.SOUTH);

    addKeyListener(getPlayer());
    add(panNavigation, BorderLayout.WEST);
    add(getDetailcontrols(), BorderLayout.CENTER);

    getPlayer().setCurrentSession(getPlayer().getCurrentSession()); // to trigger session changed event
    getPlayer().setCurrentSong(0);
    getPlayer().open();
    setVisible(true);
  }

  private JMenuItem createMenuItem(JMenu menu, String text, int mnemonic) {
    JMenuItem item = new JMenuItem(text);
    if (mnemonic >= 0) item.setMnemonic(mnemonic);
    item.addActionListener(this);

    GuiHelper.layout(item, false);
    menu.add(item);
    return item;

  }

  private JMenu createMenu (String text, int mnemonic) {
    JMenu menuSession = new JMenu(text);
    if (mnemonic >= 0) menuSession.setMnemonic(mnemonic);

    GuiHelper.layout(menuSession, false);
    menuBar.add(menuSession);

    return menuSession;

  }

  private JMenuBar createMainMenu() {

    menuBar = new JMenuBar();
    GuiHelper.layout(menuBar, false);

    //Menu Application
    JMenu menuApplication = createMenu("Application", 0);
    menuItemGallery = createMenuItem (menuApplication, "Gallery", 0);// Program->Gallery
    menuItemSave = createMenuItem (menuApplication, "Save", 0);// Program->Save
    menuItemConfig = createMenuItem (menuApplication, "Configuration", 0);// Program->Save
    menuItemExport = createMenuItem (menuApplication, "Export all..", 0);
    menuApplication.addSeparator();
    menuItemExit = createMenuItem(menuApplication, "Exit", 0);// Program->Exit

    //Menu Session
    JMenu menuSession = createMenu ("Session", -1);
    menuItemChooseSession = createMenuItem(menuSession, "Choose session", 0);
    menuSession.addSeparator();
    menuItemAddSong = createMenuItem (menuSession, "Add song", 0);
    menuItemRemoveSong = createMenuItem(menuSession, "Remove song", 0);
    menuItemSessionDetails = createMenuItem(menuSession, "Session details", 0);



    //Menu song
    JMenu menuSong = createMenu("Song", -1);
    menuItemImportText = createMenuItem(menuSong, "Import text...", 0);    // Song->Import Text
    menuItemRemoveText = createMenuItem(menuSong, "Remove text", 0);    // Song->Import Text
    menuItemSongDetails = createMenuItem(menuSong, "Song details", 0);
    menuItemSongExport = createMenuItem(menuSong, "Export to PDF", 0);

    return menuBar;
  }

  public MidiPlayerRoot getRoot() {
    return root;
  }

  public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
    File conffileAsFile = null;
    if (args.length == 1)
      conffileAsFile = new File (args [0]);

    if (conffileAsFile == null) {
      System.out.println ("Aufruf: mda [FILENAME]");
      System.exit(1);
    }

    MidiPlayerRoot root = MidiPlayerService.loadRootObject(conffileAsFile);
    new MidiPlayerApplicationFrame(root, GuiHelper.findGraphicsDevice(root.getConfig().getScreenIDAdmin()));
  }

  @Override
  public void actionPerformed(ActionEvent e) {

    if (e.getSource() == null) return;

    if (e.getSource().equals(menuItemExit)) {
      setVisible(false);
      System.exit(0);
    }

    if (e.getSource().equals(menuItemExport)) {
    	if (root.getConfig().getPdfExportPath() == null || root.getConfig().getPdfExportPath().trim().length() == 0) {

    	}
    	else {
    		PDFExporter exporter = new PDFExporter();
    		exporter.setExportPath(new File (root.getConfig().getPdfExportPath()));
    		for (AbstractSessionItem nextItem: root.getGallery().getGalleryItems()) {
    			if (nextItem instanceof MidiFile)
    			exporter.exportMidifile((MidiFile) nextItem);
    		}
    	}
    }

    if (e.getSource().equals(menuItemGallery)) {
      new GalleryChooser(getRoot().getGallery());
    }

    if (e.getSource().equals(menuItemConfig)) {
      new ConfigurationDialog(this);
    }

    if (e.getSource().equals(menuItemImportText)) {
      new TextImportFrame(this, getPlayer().getCurrentMidifile());
      getDetailcontrols().renderContent();
    }

    if (e.getSource().equals(menuItemChooseSession)) {
      new SessionChooser(this, root);
    }

    if (e.getSource().equals(menuItemSessionDetails)) {
      new SessionDetailDialog(this);
    }

    if (e.getSource().equals(menuItemRemoveText)) {
      MidiPlayerService.removeText(getPlayer().getCurrentMidifile());
      getDetailcontrols().renderContent();
    }

    if (e.getSource().equals(menuItemSave)) {
      MidiPlayerService.saveRootObject(getRoot());
    }

    if (e.getSource().equals(menuItemAddSong)) {
      GalleryChooser chooser = new GalleryChooser(getRoot().getGallery());

      if (chooser.getSelectedItems().size() > 0);
        getPlayer().getCurrentSession().getItems().addAll(getPlayer().isSessionListEmpty() ? 0: getPlayer().getCurrentSongIndex() + 1, chooser.getSelectedItems());

      getSessionTable().update();
    }

    if (e.getSource().equals(menuItemRemoveSong)) {
      getPlayer().getCurrentSession().getItems().remove(getPlayer().getCurrentSongIndex());
      getSessionTable().update();
    }

    if (e.getSource().equals(menuItemSongDetails)) {
      new SongDetailDialog(this);
    }
    if (e.getSource().equals(menuItemSongExport)) {
			if (root.getConfig().getPdfExportPath() == null || root.getConfig().getPdfExportPath().trim().length() == 0) {

			} else {
				PDFExporter exporter = new PDFExporter();
				exporter.setExportPath(new File (root.getConfig().getPdfExportPath()));
				exporter.exportMidifile(getPlayer().getCurrentMidifile());
			}

    }
  }

  public ItemDetailsPanel getDetailcontrols() {
    return detailcontrols;
  }

  public SessionTable getSessionTable() {
    return sessionTable;
  }

  public PerformanceFrame getPerformanceFrame() {
    return performanceFrame;
  }

  public IPlayer getPlayer() {
    return player;
  }

  @Override
  public void sessionChanged(Session newSession) {
    // TODO Auto-generated method stub

  }

  @Override
  public void sessionItemChanged(AbstractSessionItem abstractSessionItem) {
    // TODO Auto-generated method stub

  }

  @Override
  public void started() {
    performanceFrame.setVisible(true);
    presentationFrame.setVisible(true);

  }

  @Override
  public void stopped() {
    performanceFrame.setVisible(false);
    presentationFrame.setVisible(false);
  }

  @Override
  public void modeToggled(PlayerMode chosePlayerMode) {


  }

  @Override
  public void barChanged(int currentBar) {
    // TODO Auto-generated method stub

  }

@Override
public void tickChanged(int currentTick) {
	// TODO Auto-generated method stub

}

}
