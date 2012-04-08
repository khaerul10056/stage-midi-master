package org.mda.transpose;

import java.util.ArrayList;
import java.util.List;


public class Scale {

  private List <ScaleStep> steps = new ArrayList<ScaleStep>();

  public Scale () {
    steps.add(new ScaleStep(Note.C));
    steps.add(new ScaleStep(Note.CIS, Note.DES));
    steps.add(new ScaleStep(Note.D));
    steps.add(new ScaleStep(Note.DIS, Note.ES));
    steps.add(new ScaleStep(Note.E));
    steps.add(new ScaleStep(Note.F));
    steps.add(new ScaleStep(Note.FIS, Note.GES));
    steps.add(new ScaleStep(Note.G));
    steps.add(new ScaleStep(Note.GIS, Note.AS));
    steps.add(new ScaleStep(Note.A));
    steps.add(new ScaleStep(Note.Bb, Note.HES));
    steps.add(new ScaleStep(Note.H));
  }

  public int getNoteOffset (final Note note) {
    ScaleStep noteFound = findNote(note);
    return steps.indexOf(noteFound);
  }

  public ScaleStep findNote (final Note note) {
    for (ScaleStep nextStep: steps) {
      if (nextStep.hasNote(note))
        return nextStep;
    }

    return null;

  }


  public Note transpose (final Note from, int diff, Note to) {

    int offsetFrom = getNoteOffset(from);
    offsetFrom += diff;
    if (offsetFrom > steps.size())
      offsetFrom -= steps.size();


    ScaleStep toStep = steps.get(offsetFrom);

    ScaleStep compareStep = findNote(to);
    boolean isB = compareStep.isB(to);

    return isB ? toStep.getNote2() : toStep.getNote1();

  }


}
