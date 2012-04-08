package org.mda.transpose;

import java.util.ArrayList;
import java.util.List;


public class Scale {

  private final List <ScaleStep> steps = new ArrayList<ScaleStep>();

  public Scale () {
    getSteps().add(new ScaleStep(Note.C));
    getSteps().add(new ScaleStep(Note.CIS, Note.DES));
    getSteps().add(new ScaleStep(Note.D));
    getSteps().add(new ScaleStep(Note.DIS, Note.ES));
    getSteps().add(new ScaleStep(Note.E));
    getSteps().add(new ScaleStep(Note.F));
    getSteps().add(new ScaleStep(Note.FIS, Note.GES));
    getSteps().add(new ScaleStep(Note.G));
    getSteps().add(new ScaleStep(Note.GIS, Note.AS));
    getSteps().add(new ScaleStep(Note.A));
    getSteps().add(new ScaleStep(Note.Bb, Note.HES));
    getSteps().add(new ScaleStep(Note.H));
  }

  public int getNoteOffset (final Note note) {
    ScaleStep noteFound = findNote(note);
    return getSteps().indexOf(noteFound);
  }

  public ScaleStep findNote (final Note note) {
    for (ScaleStep nextStep: getSteps()) {
      if (nextStep.hasNote(note))
        return nextStep;
    }

    return null;

  }


  public Note transpose (final Note from, int diff, Note to) {

    int offsetFrom = getNoteOffset(from);
    offsetFrom += diff;
    if (offsetFrom > getSteps().size())
      offsetFrom -= getSteps().size();


    ScaleStep toStep = getSteps().get(offsetFrom);

    ScaleStep compareStep = findNote(to);
    boolean isB = compareStep.isB(to);

    return isB ? toStep.getNote2() : toStep.getNote1();

  }

  public List <ScaleStep> getSteps () {
    return steps;
  }


}
