package org.mda.editor.preview.ui.newpart;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import mda.MidiFile;
import mda.MidiFilePart;
import mda.MidiFilePartType;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Shell;
import org.mda.ApplicationSession;
import org.mda.MidiPlayerService;
import org.mda.additionals.AdditionalsHandler;


public class NewPartShell extends Shell implements SelectionListener {

  private MidiFile midifile;

  private Collection <Button> buttonsDefault = new ArrayList<Button>();

  private Collection <Button> buttonsReference = new ArrayList<Button>();

  private Collection <MidiFilePart> partReferences = new ArrayList<MidiFilePart>();

  private ApplicationSession session = ApplicationSession.getInjector().getInstance(ApplicationSession.class);

  private AdditionalsHandler additionalHandler = session.getAdditionalsHandler();


  private GridData getLabelData () {
    return new GridData(SWT.BEGINNING, SWT.CENTER, false, false);
  }

  private GridData getContentData () {
    return new GridData(SWT.FILL, SWT.FILL, false, false);
  }

  public Button addButton () {
    Button button = new Button(this, SWT.NONE);
    GridData cd = getContentData();
    cd.widthHint = 485;
    cd.heightHint = 30;
    cd.verticalIndent = 5;
    button.setLayoutData(cd);
    button.addSelectionListener(this);
    return button;
  }

  public NewPartShell (final Shell shell, final MidiFile midifile, int addposition) {
    super (shell, SWT.NONE);
    this.midifile = midifile;

    setText("Add new part...");

    setLayout(new GridLayout(1, false));

    int completeNumbersOfButtons = 0;

    for (MidiFilePartType newTypes : MidiFilePartType.values()) {
      Button button = addButton();
      button.setText("New " + newTypes.getName());
      completeNumbersOfButtons ++;
      buttonsDefault.add(button);
    }

    for (MidiFilePart nextPart: midifile.getParts()) {

      if (nextPart.getRefPart() != null) {
        Button btn = addButton();
        List<String> rawText = MidiPlayerService.getRawText(nextPart);

        String tooltip = "";
        for (String nextRaw: rawText) {
          if (tooltip.length() > 0)
            tooltip += "\n";
          tooltip += nextRaw;
        }
        String preview = nextPart.getParttype().getName();
        if (rawText != null && rawText.size() > 0)
          preview += ": " + rawText.get(0);
        btn.setText("Reference to " + preview);
        btn.setToolTipText(tooltip);

        buttonsReference.add(btn);
        partReferences.add(nextPart);

        completeNumbersOfButtons ++;

      }


    }


    setSize(500, (completeNumbersOfButtons * 40) + 10);


    open ();
  }

  protected void checkSubclass () {
    /* Do nothing - Subclassing is allowed */
  }

  @Override
  public void widgetDefaultSelected (SelectionEvent arg0) {
   //empty by default

  }

  @Override
  public void widgetSelected (SelectionEvent arg0) {
    // TODO Auto-generated method stub

  }

}
