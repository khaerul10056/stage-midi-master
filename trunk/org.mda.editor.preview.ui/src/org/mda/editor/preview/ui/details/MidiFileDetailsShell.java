package org.mda.editor.preview.ui.details;

import mda.AdditionalType;
import mda.MidiFile;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.ColorDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.mda.ApplicationSession;
import org.mda.Utils;
import org.mda.additionals.Additional;
import org.mda.additionals.AdditionalsHandler;
import org.mda.commons.ui.additionals.AdditionalShell;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;


public class MidiFileDetailsShell extends Shell {

  private MidiFile midifile;

  private Label lblPicture;

  private static final Log LOGGER  = LogFactory.getLogger(MidiFileDetailsShell.class);

  private int PREVIEW_HEIGHT = 100;
  private int PREVIEW_WIDTH = 130;


  private Color defaultBackground = Display.getCurrent().getSystemColor(SWT.COLOR_BLACK);
  private Color defaultForeground = Display.getCurrent().getSystemColor(SWT.COLOR_WHITE);

  private ApplicationSession session = ApplicationSession.getInjector().getInstance(ApplicationSession.class);

  private AdditionalsHandler additionalHandler = session.getAdditionalsHandler();


  private GridData getLabelData () {
    return new GridData(SWT.BEGINNING, SWT.CENTER, false, false);
  }

  private GridData getContentData () {
    return new GridData(SWT.FILL, SWT.FILL, false, false);
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
    setSize(500, 700);
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
            Additional additional = shell.getSelected();
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
    GridData cd = getContentData();
    cd.heightHint = PREVIEW_HEIGHT;
    cd.widthHint = PREVIEW_WIDTH;
    lblPicture.setLayoutData(cd);

    //Background-Color

    // Use a label full of spaces to show the color
    Label lblBackground = new Label (this, SWT.NONE);
    lblBackground.setText("Background-Color:");
    lblBackground.setLayoutData(getLabelData());
    final Label colorLabelBackground = new Label(this, SWT.NONE);
    colorLabelBackground.setText("                              ");

    colorLabelBackground.setBackground(Utils.stringToColor(midifile.getBackgroundColor(), defaultBackground));
    colorLabelBackground.addMouseListener(new MouseAdapter() {

      @Override
      public void mouseDoubleClick (MouseEvent e) {
        // Create the color-change dialog
        ColorDialog dlg = new ColorDialog(shell);

        // Set the selected color in the dialog from
        // user's selected color
        dlg.setRGB(colorLabelBackground.getBackground().getRGB());

        dlg.setText("Choose the background-color of " + midifile.getName());

        RGB rgb = dlg.open();
        if (rgb != null) {
          colorLabelBackground.setBackground(new Color(shell.getDisplay(), rgb));
          midifile.setBackgroundColor(Utils.colorToString(colorLabelBackground.getBackground()));
        }
        else {
          midifile.setBackgroundColor(null);
          colorLabelBackground.setBackground(defaultBackground);
        }
      }

    });

    //Foreground-Color
    Label lblForeground = new Label (this, SWT.NONE);
    lblForeground.setText("Foreground-Color:");
    lblForeground.setLayoutData(getLabelData());
    final Label colorLabelForeground = new Label(this, SWT.NONE);
    colorLabelForeground.setText("                              ");
    colorLabelForeground.setBackground(Utils.stringToColor(midifile.getForegroundColor(), defaultForeground));
    colorLabelForeground.addMouseListener(new MouseAdapter() {

      @Override
      public void mouseDoubleClick (MouseEvent e) {
        // Create the color-change dialog
        ColorDialog dlg = new ColorDialog(shell);

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
          midifile.setForegroundColor(Utils.colorToString(colorLabelForeground.getBackground()));
        }
        else {
          midifile.setForegroundColor(null);
          colorLabelForeground.setBackground(defaultForeground);
        }
      }

    });

    open ();
  }

  protected void checkSubclass () {
    /* Do nothing - Subclassing is allowed */
  }


}
