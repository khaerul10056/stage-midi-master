package org.mda.transpose;

import java.util.ArrayList;
import java.util.List;


public class Scale {

  private final List <ScaleStep> steps = new ArrayList<ScaleStep>();

  public Scale () {
    getSteps().add(new ScaleStep(Pitch.C));
    getSteps().add(new ScaleStep(Pitch.CIS, Pitch.DES));
    getSteps().add(new ScaleStep(Pitch.D));
    getSteps().add(new ScaleStep(Pitch.DIS, Pitch.ES));
    getSteps().add(new ScaleStep(Pitch.E));
    getSteps().add(new ScaleStep(Pitch.F));
    getSteps().add(new ScaleStep(Pitch.FIS, Pitch.GES));
    getSteps().add(new ScaleStep(Pitch.G));
    getSteps().add(new ScaleStep(Pitch.GIS, Pitch.AS));
    getSteps().add(new ScaleStep(Pitch.A));
    getSteps().add(new ScaleStep(Pitch.Bb, Pitch.HES));
    getSteps().add(new ScaleStep(Pitch.H));
  }

  public int getNoteOffset (final Pitch note) {
    ScaleStep noteFound = findNote(note);
    return getSteps().indexOf(noteFound);
  }

  public ScaleStep findNote (final Pitch note) {
    for (ScaleStep nextStep: getSteps()) {
      if (nextStep.hasNote(note))
        return nextStep;
    }

    return null;

  }


  public Pitch transpose (final Pitch from, int diff, Pitch to) {

    int offsetFrom = getNoteOffset(from);
    offsetFrom += diff;
    if (offsetFrom > getSteps().size())
      offsetFrom -= getSteps().size();
    else if (offsetFrom < 0)
      offsetFrom = getSteps().size() + offsetFrom;




    ScaleStep toStep = getSteps().get(offsetFrom);

    ScaleStep compareStep = findNote(to);
    boolean isB = compareStep.isB(to);

    return isB ? toStep.getNote2() : toStep.getNote1();

  }

  public List <ScaleStep> getSteps () {
    return steps;
  }


}
