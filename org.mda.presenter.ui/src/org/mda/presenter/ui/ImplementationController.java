package org.mda.presenter.ui;

import java.util.ArrayList;
import java.util.List;
import mda.MidiFilePart;
import org.mda.IPresentationController;
import org.mda.IPresentationView;


public class ImplementationController implements IPresentationController {

  private List <IPresentationView> views = new ArrayList<IPresentationView>();


  public void end () {
    for (IPresentationView nextView: views) {
      nextView.end();
    }
  }

  public void showPart (final MidiFilePart part) {
    for (IPresentationView nextView: views) {
      nextView.showSlide(part);
    }
  }

  public boolean nextSlide () {
    boolean done = true;
    for (IPresentationView nextView: views) {
      if (! nextView.nextSlide())
        done = false;
    }

    return done;
  }

  public boolean previousSlide () {
    boolean done = true;
    for (IPresentationView nextView: views) {
      if (!nextView.previousSlide())
        done = false;
    }

    return done;
  }


  @Override
  public void connect (IPresentationView view) {
    views.add(view);

  }

}
