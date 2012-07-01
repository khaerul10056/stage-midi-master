package org.mda.editor.preview.ui.details;

import mda.AdditionalType;
import mda.Copyright;
import mda.MidiFile;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.ColorDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.mda.ApplicationSession;
import org.mda.MdaModule;
import org.mda.MidiPlayerService;
import org.mda.Utils;
import org.mda.additionals.Additional;
import org.mda.additionals.AdditionalsHandler;
import org.mda.commons.ui.additionals.AdditionalShell;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;


public class MidiFileDetailsShell extends Shell {

  private MidiFile midifile;

  private Label lblPicture;

  //copyright-infos
  private Text txtOriginaltitle;

  private Text txtWriterMusic;

  private Text txtWriterText;

  private Text txtWriterTextInland;

  private Text txtYear;

  private Text txtPublisher;

  private Text txtPublisherInland;

  private static final Log LOGGER  = LogFactory.getLogger(MidiFileDetailsShell.class);

  private int PREVIEW_HEIGHT = 100;
  private int PREVIEW_WIDTH = 130;


  private Color defaultBackground = Display.getCurrent().getSystemColor(SWT.COLOR_BLACK);
  private Color defaultForeground = Display.getCurrent().getSystemColor(SWT.COLOR_WHITE);

  private ApplicationSession session = MdaModule.getInjector().getInstance(ApplicationSession.class);

  private AdditionalsHandler additionalHandler = session.getAdditionalsHandler();

  private Label colorLabelForeground;

  private Label colorLabelBackground;

  private Additional additional;

  private GridData getLabelData () {
    return new GridData(SWT.BEGINNING, SWT.CENTER, false, false);
  }

  private GridData getContentData (final boolean fillHorizontal) {
    GridData gd = new GridData(SWT.FILL, SWT.FILL, fillHorizontal, false);
    gd.verticalIndent = 10;
    return gd;
  }

  private GridData getColorContentData () {
    GridData gd = new GridData(SWT.NONE, SWT.FILL, false, false);
    gd.verticalIndent = 10;
    return gd;
  }

  private void refreshData () {
    if (midifile.getPic() != null) {
      Additional findByKey = additionalHandler.findByKey(midifile.getPic());
      if (findByKey != null)
        lblPicture.setBackgroundImage(findByKey.getImageScaled(PREVIEW_WIDTH, PREVIEW_HEIGHT));
    }
  }

  public MidiFileDetailsShell (final Shell shell, final MidiFile midifile) {
    this.midifile = midifile;
    setSize(800, 700);
    setText("Details of song " + midifile.getName());

    setLayout(new GridLayout(2, false));

    //BackgroundImage
    Label lblPictureText = new Label (this, SWT.NONE);
    lblPictureText.setText("Background-Image:");
    lblPictureText.setLayoutData(getLabelData());

    lblPicture = new Label (this, SWT.NONE);
    lblPicture.setBackground(getDisplay().getSystemColor(SWT.COLOR_DARK_GRAY));

    refreshData();

    lblPicture.addMouseListener(new MouseAdapter() {

      @Override
      public void mouseDoubleClick (MouseEvent e) {
        final AdditionalShell shell = new AdditionalShell(getShell(), additionalHandler, AdditionalType.IMAGE, true);
        shell.addDisposeListener(new DisposeListener() {



          @Override
          public void widgetDisposed (DisposeEvent arg0) {
            additional = shell.getSelected();
            if (additional == null) {
              LOGGER.info("Set picture of file " + midifile.getName() + " to <null>");
              midifile.setPic(null);
            }
            else {
              LOGGER.info("Set picture of file " + midifile.getName() + " to " + additional.getKey());
              midifile.setPic(additional.getKey());
            }
            refreshData();
          }
        });
      }
    });
    GridData cd = getContentData(false);
    cd.heightHint = PREVIEW_HEIGHT;
    cd.widthHint = PREVIEW_WIDTH;
    lblPicture.setLayoutData(cd);

    //Background-Color
    // Use a label full of spaces to show the color
    addLabel ("Background-Color:");
    colorLabelBackground = new Label(this, SWT.NONE);
    colorLabelBackground.setText("                              ");
    colorLabelBackground.setLayoutData(getColorContentData());

    colorLabelBackground.setBackground(Utils.stringToColor(midifile.getBackgroundColor(), defaultBackground));
    colorLabelBackground.addMouseListener(new MouseAdapter() {

      @Override
      public void mouseDoubleClick (MouseEvent e) {
        // Create the color-change dialog
        ColorDialog dlg = new ColorDialog(getShell());

        // Set the selected color in the dialog from
        // user's selected color
        dlg.setRGB(colorLabelBackground.getBackground().getRGB());

        dlg.setText("Choose the background-color of " + midifile.getName());

        RGB rgb = dlg.open();
        if (rgb != null) {
          colorLabelBackground.setBackground(new Color(shell.getDisplay(), rgb));
          //midifile.setBackgroundColor(Utils.colorToString(colorLabelBackground.getBackground()));
        }
        else {
          //midifile.setBackgroundColor(null);
          colorLabelBackground.setBackground(defaultBackground);
        }
      }

    });

    //Foreground-Color
    addLabel("Foreground-Color:");
    colorLabelForeground = new Label(this, SWT.NONE);
    colorLabelForeground.setText("                              ");
    colorLabelForeground.setBackground(Utils.stringToColor(midifile.getForegroundColor(), defaultForeground));
    colorLabelForeground.setLayoutData(getColorContentData());
    colorLabelForeground.addMouseListener(new MouseAdapter() {

      @Override
      public void mouseDoubleClick (MouseEvent e) {
        // Create the color-change dialog
        ColorDialog dlg = new ColorDialog(getShell());

        // Set the selected color in the dialog from
        // user's selected color
        dlg.setRGB(colorLabelForeground.getBackground().getRGB());

        // Change the title bar text
        dlg.setText("Choose the foreground-color of " + midifile.getName());

        // Open the dialog and retrieve the selected color
        RGB rgb = dlg.open();
        if (rgb != null) {
          // Dispose the old color, create the
          // new one, and set into the label
          colorLabelForeground.setBackground(new Color(shell.getDisplay(), rgb));
          //midifile.setForegroundColor(Utils.colorToString(colorLabelForeground.getBackground()));
        }
        else {
          //midifile.setForegroundColor(null);
          colorLabelForeground.setBackground(defaultForeground);
        }
      }

    });

    addLabel("Original title:");
    txtOriginaltitle = new Text (this, SWT.NONE);
    txtOriginaltitle.setText(midifile.getCopyright() != null && midifile.getCopyright().getOriginaltitle() != null ? midifile.getCopyright().getOriginaltitle() : "" );
    txtOriginaltitle.setLayoutData(getContentData(true));

    addLabel ("Writer music:");
    txtWriterMusic = new Text (this, SWT.NONE);
    txtWriterMusic.setText(midifile.getCopyright() != null && midifile.getCopyright().getWriterMusic() != null ? midifile.getCopyright().getWriterMusic() : "" );
    txtWriterMusic.setLayoutData(getContentData(true));

    addLabel ("Writer text:");
    txtWriterText = new Text (this, SWT.NONE);
    txtWriterText.setText(midifile.getCopyright() != null && midifile.getCopyright().getWriterText() != null ? midifile.getCopyright().getWriterText() : "" );
    txtWriterText.setLayoutData(getContentData(true));

    addLabel ("Writer text inland:");
    txtWriterTextInland = new Text (this, SWT.NONE);
    txtWriterTextInland.setText(midifile.getCopyright() != null && midifile.getCopyright().getWriterInlandText() != null ? midifile.getCopyright().getWriterInlandText() : "" );
    txtWriterTextInland.setLayoutData(getContentData(true));

    addLabel ("Year of publication:");
    txtYear = new Text (this, SWT.NONE);
    txtYear.setText(midifile.getCopyright() != null && midifile.getCopyright().getYear() > 0 ? String.valueOf(midifile.getCopyright().getYear()) : "" );
    txtYear.setLayoutData(getContentData(true));

    addLabel ("Publisher:");
    txtPublisher = new Text (this, SWT.NONE);
    txtPublisher.setText(midifile.getCopyright() != null && midifile.getCopyright().getPublisher() != null ? midifile.getCopyright().getPublisher() : "" );
    txtPublisher.setLayoutData(getContentData(true));

    addLabel ("Publisher inland:");
    txtPublisherInland = new Text (this, SWT.NONE);
    txtPublisherInland.setText(midifile.getCopyright() != null && midifile.getCopyright().getPublisherInland() != null ? midifile.getCopyright().getPublisherInland() : "");
    txtPublisherInland.setLayoutData(getContentData(true));

    buildButtons();

    open ();
  }

  private void buildButtons () {
    Composite btnComp = new Composite(this, SWT.NONE);
    btnComp.setLayout(new RowLayout(SWT.HORIZONTAL));
    btnComp.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 2 , 1));

    Button btnOk = new Button(btnComp, SWT.NONE);
    btnOk.setText("Save");
    btnOk.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {

        save ();
        dispose();

      }
    });

    Button btnCancel = new Button(btnComp, SWT.NONE);
    btnCancel.setText("Cancel");
    btnCancel.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
        dispose();
      }
    });
  }

  protected void save () {
    midifile.setBackgroundColor(! colorLabelBackground.getBackground().equals(defaultBackground) ? Utils.colorToString(colorLabelForeground.getBackground()) : null);
    midifile.setForegroundColor(! colorLabelForeground.getBackground().equals(defaultForeground) ? Utils.colorToString(colorLabelForeground.getForeground()) : null);
    midifile.setPic(additional != null ? additional.getKey() : null);

    if (midifile.getCopyright() == null)
      midifile.setCopyright(MidiPlayerService.mf.createCopyright());

    Copyright copyright = midifile.getCopyright();
    copyright.setOriginaltitle(! txtOriginaltitle.getText().isEmpty() ? txtOriginaltitle.getText().trim() : null);
    copyright.setPublisher(! txtPublisher.getText().isEmpty() ? txtPublisher.getText().trim() : null);
    copyright.setPublisherInland(! txtPublisherInland.getText().isEmpty() ? txtPublisherInland.getText().trim() : null);
    copyright.setWriterInlandText(! txtWriterTextInland.getText().isEmpty() ? txtWriterTextInland.getText().trim() : null);
    copyright.setWriterMusic(! txtWriterMusic.getText().isEmpty() ? txtWriterMusic.getText().trim() : null);
    copyright.setWriterText(! txtWriterText.getText().isEmpty() ? txtWriterText.getText().trim() : null);
    copyright.setYear(! (txtYear.getText() == null && txtYear.getText().isEmpty()) ? Integer.valueOf(txtYear.getText().trim()) : null);
  }

  private void addLabel (final String labeltext) {
    Label lblForeground = new Label (this, SWT.NONE);
    lblForeground.setText(labeltext);
    lblForeground.setLayoutData(getLabelData());
  }

  protected void checkSubclass () {
    /* Do nothing - Subclassing is allowed */
  }


}
