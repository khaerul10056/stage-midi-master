package org.mda.editor.preview.ui.details;

import mda.MidiFile;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.mda.ApplicationSession;
import org.mda.additionals.Additional;
import org.mda.additionals.AdditionalsHandler;


public class MidiFileDetailsShell extends Shell {

  private MidiFile midifile;

  private Label lblPicture;

  private Spinner spnFontSize;

  private ApplicationSession session = ApplicationSession.getInjector().getInstance(ApplicationSession.class);

  private AdditionalsHandler additionalHandler = session.getAdditionalsHandler();


  private GridData getLabelData () {
    return new GridData(SWT.BEGINNING, SWT.CENTER, false, false);
  }

  private GridData getContentData () {
    return new GridData(SWT.FILL, SWT.FILL, false, false);
  }

  public MidiFileDetailsShell (final Shell shell, final MidiFile midifile) {
    setSize(500, 700);

    setLayout(new GridLayout(2, false));
    Label lblPictureText = new Label (this, SWT.NONE);
    lblPictureText.setText("Background-Image:");
    lblPictureText.setLayoutData(getLabelData());

    lblPicture = new Label (this, SWT.NONE);
    Additional findByKey = additionalHandler.findByKey(midifile.getPic());
    lblPicture.setBackground(getDisplay().getSystemColor(SWT.COLOR_DARK_GRAY));
    if (findByKey != null)
      lblPicture.setBackgroundImage(findByKey.getImage());
    GridData cd = getContentData();
    cd.heightHint = 100;
    cd.widthHint = 130;
    lblPicture.setLayoutData(cd);

    //Fontsize
    Label lblFontsize = new Label (this, SWT.NONE);
    lblFontsize.setText("Fontsize:");
    lblFontsize.setLayoutData(getLabelData());

    spnFontSize = new Spinner(this, SWT.NONE);
    if (midifile.getFontsize() != null)
      spnFontSize.setDigits(Integer.parseInt(midifile.getFontsize()));
    spnFontSize.setLayoutData(getContentData());

    open ();
  }

  protected void checkSubclass () {
    /* Do nothing - Subclassing is allowed */
  }


}
