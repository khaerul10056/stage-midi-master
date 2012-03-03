package org.mda.presenter.ui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import mda.AbstractSessionItem;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.presenter.ui.slide.IPresentationView;


public class DefaultPresentationController implements IPresentationController {

  private static final Log LOGGER  = LogFactory.getLogger(DefaultPresentationController.class);

  private final List <IPresentationView> views = new ArrayList<IPresentationView>();

  public void connect (IPresentationView view) {
    LOGGER.info("Connect " + getClass().getName() + " to " + view.getClass().getName() + "-" + System.identityHashCode(view));

    boolean replaced = false;

    for (int i = 0; i < views.size(); i++) {
      if (views.get(i).getClass().equals(view.getClass())) {
        views.set(i, view);
        replaced = true;
        break;
      }
    }

    if (! replaced)
      views.add(view);

    LOGGER.info("Views: " + views);
  }

  private Collection <IPresentationView> getRegisteredViews () {
    return views;
  }

  public void end () {
    for (IPresentationView nextView: getRegisteredViews()) {
      nextView.end();
    }
  }

  public boolean toItem (final AbstractSessionItem sessionItem) {
    boolean done = true;
    for (IPresentationView nextView: getRegisteredViews()) {
      LOGGER.info("Dispatch toItem to " + nextView.getClass().getName() + "-" + System.identityHashCode(nextView));
      if (! nextView.toItem(sessionItem))
        done = false;
    }

    return done;
  }



  public boolean nextSlide () {
    boolean done = true;
    for (IPresentationView nextView: getRegisteredViews()) {
      LOGGER.info("Dispatch nextSlide to " + nextView.getClass().getName() + "-" + System.identityHashCode(nextView));
      if (! nextView.nextSlide())
        done = false;
    }

    return done;
  }

  public boolean previousSlide () {
    boolean done = true;
    for (IPresentationView nextView: getRegisteredViews()) {
      LOGGER.info("Dispatch previousSlide to " + nextView.getClass().getName() + "-" + System.identityHashCode(nextView));
      if (!nextView.previousSlide())
        done = false;
    }

    return done;
  }

}
