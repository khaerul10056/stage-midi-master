package org.mda.editor.preview.ui.newpart;

import static org.mda.Utils.ICON_PART;
import static org.mda.Utils.ICON_REFPART;
import static org.mda.Utils.loadImageFromProject;
import java.util.ArrayList;
import java.util.List;
import mda.MidiFile;
import mda.MidiFilePart;
import mda.MidiFilePartType;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Widget;
import org.mda.ApplicationSession;
import org.mda.MidiPlayerService;
import org.mda.additionals.AdditionalsHandler;


public class NewPartShell extends Shell implements SelectionListener {

  private MidiFile midifile;

  private MidiFilePart addAfter;

  private List <Button> buttonsDefault = new ArrayList<Button>();

  private List <Button> buttonsReference = new ArrayList<Button>();

  private List <MidiFilePart> partReferences = new ArrayList<MidiFilePart>();

  private ApplicationSession session = ApplicationSession.getInjector().getInstance(ApplicationSession.class);

  private AdditionalsHandler additionalHandler = session.getAdditionalsHandler();

  private static Image imgNewPart = loadImageFromProject(ICON_PART);
  private static Image imgNewRefPart = loadImageFromProject(ICON_REFPART);


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

  public NewPartShell (final Shell shell, final MidiFile midifile, MidiFilePart addAfter) {
    super (shell, SWT.NONE);
    this.midifile = midifile;
    this.addAfter = addAfter;

    setText("Add new part...");

    setLayout(new GridLayout(1, false));

    int completeNumbersOfButtons = 0;

    for (MidiFilePartType newTypes : MidiFilePartType.values()) {
      Button button = addButton();
      button.setText("New " + newTypes.getName());
      button.setImage(imgNewPart);
      completeNumbersOfButtons ++;
      buttonsDefault.add(button);
    }

    for (MidiFilePart nextPart: midifile.getParts()) {

      if (nextPart.getRefPart() == null) { //only parts that are no refpart itself
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
          preview += ": " + (rawText.get(0).length() > 30 ? rawText.get(0).substring(0, 30) + "..." : rawText.get(0));
        btn.setText("Reference to " + preview);
        btn.setImage(imgNewRefPart);
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

  private boolean isNewButton (final Widget widget) {
    return buttonsDefault.contains(widget);
  }

  private MidiFilePartType getPartType (final Widget widget) {
    int indexOf = buttonsDefault.indexOf(widget);
    if (indexOf < 0)
      return null;
    return MidiFilePartType.get(indexOf);
  }

  private MidiFilePart getRefPart (final Widget widget) {
    int indexOf = buttonsReference.indexOf(widget);
    if (indexOf < 0)
      return null;
    return partReferences.get(indexOf);
  }

  @Override
  public void widgetSelected (SelectionEvent arg0) {
    Widget widget = arg0.widget;

    MidiFilePartType type = getPartType(widget);
    MidiFilePart ref = getRefPart(widget);
    MidiPlayerService.addPartAfter(midifile, addAfter, type, ref);

    dispose();

  }

}
