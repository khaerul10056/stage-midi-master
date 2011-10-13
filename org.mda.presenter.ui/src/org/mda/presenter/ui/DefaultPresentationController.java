package org.mda.presenter.ui;

import java.util.ArrayList;
import java.util.Collection;
import org.mda.presenter.ui.slide.IPresentationView;


public class DefaultPresentationController implements IPresentationController {

  private final Collection <IPresentationView> views = new ArrayList<IPresentationView>();

  public void connect (IPresentationView view) {
    views.add(view);
  }


  protected Collection <IPresentationView> getRegisteredViews () {
    return views;
  }

  public void end () {
    for (IPresentationView nextView: getRegisteredViews()) {
      nextView.end();
    }
  }

  

  public boolean nextSlide () {
    boolean done = true;
    for (IPresentationView nextView: getRegisteredViews()) {
      if (! nextView.nextSlide())
        done = false;
    }

    return done;
  }

  public boolean previousSlide () {
    boolean done = true;
    for (IPresentationView nextView: getRegisteredViews()) {
      if (!nextView.previousSlide())
        done = false;
    }

    return done;
  }

}
