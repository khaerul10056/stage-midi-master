package org.mda.editor.preview.ui.details;

import mda.MidiFile;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.mda.ApplicationSession;
import org.mda.additionals.Additional;
import org.mda.additionals.AdditionalsHandler;


public class MidiFileDetailsShell extends Shell {

  private MidiFile midifile;

  private Label lblPicture;


  private ApplicationSession session = ApplicationSession.getInjector().getInstance(ApplicationSession.class);

  private AdditionalsHandler additionalHandler = session.getAdditionalsHandler();


  private GridData getLabelData () {
    return new GridData(SWT.BEGINNING, SWT.CENTER, false, false);
  }

  private GridData getContentData () {
    return new GridData(SWT.FILL, SWT.FILL, false, false);
  }

  public MidiFileDetailsShell (final Shell shell, final MidiFile midifile) {
    this.midifile = midifile;
    setSize(500, 700);

    setLayout(new GridLayout(2, false));
    Label lblPictureText = new Label (this, SWT.NONE);
    lblPictureText.setText("Background-Image:");
    lblPictureText.setLayoutData(getLabelData());

    lblPicture = new Label (this, SWT.NONE);
    lblPicture.setBackground(getDisplay().getSystemColor(SWT.COLOR_DARK_GRAY));
    if (midifile.getPic() != null) {
      Additional findByKey = additionalHandler.findByKey(midifile.getPic());
      if (findByKey != null)
        lblPicture.setBackgroundImage(findByKey.getImage());
    }
    GridData cd = getContentData();
    cd.heightHint = 100;
    cd.widthHint = 130;
    lblPicture.setLayoutData(cd);



    open ();
  }

  protected void checkSubclass () {
    /* Do nothing - Subclassing is allowed */
  }


}
