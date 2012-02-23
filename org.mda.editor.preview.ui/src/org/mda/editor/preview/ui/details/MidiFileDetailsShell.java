package org.mda.editor.preview.ui.details;

import mda.AdditionalType;
import mda.MidiFile;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.mda.ApplicationSession;
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

    open ();
  }

  protected void checkSubclass () {
    /* Do nothing - Subclassing is allowed */
  }


}
