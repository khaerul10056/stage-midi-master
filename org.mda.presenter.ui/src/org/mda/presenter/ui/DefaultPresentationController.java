package org.mda.presenter.ui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import mda.AbstractSessionItem;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.presenter.ui.slide.IPresentationView;
import org.mda.presenter.ui.slide.NavigationRefreshAction;


public class DefaultPresentationController implements IPresentationController {

  private static final Log LOGGER  = LogFactory.getLogger(DefaultPresentationController.class);

  private final List <IPresentationView> views = new ArrayList<IPresentationView>();

  private PresentationContext  presentationContext = MdaPresenterModule.getInjector().getInstance(PresentationContext.class);

  public void connect (IPresentationView view) {
    LOGGER.info("Connect " + getClass().getName() + " to " + view.getClass().getName() + "-" + System.identityHashCode(view));

    boolean replaced = false;

    for (int i = 0; i < views.size(); i++) {
      if (views.get(i).getClass().equals(view.getClass())) {
        views.set(i, view);
        replaced = true;
        LOGGER.info("Replaced view " + view + " at position " + i);
        break;
      }
    }

    if (! replaced) {
      views.add(view);
      LOGGER.info("Added view " + view);
    }

    LOGGER.info("Views: " + views);
  }

  private Collection <IPresentationView> getRegisteredViews () {
    return views;
  }

  public void end () {
    presentationContext.closePresentationSession();

    for (IPresentationView nextView: getRegisteredViews()) {
      nextView.end();
    }
  }

  public boolean toItem (final AbstractSessionItem sessionItem) {
    boolean done = presentationContext.toItem(sessionItem, false);
    if (done) {
    for (IPresentationView nextView: getRegisteredViews()) {
      LOGGER.info("Dispatch toItem to " + nextView.getClass().getName() + "-" + System.identityHashCode(nextView));
      if (! nextView.toItem(sessionItem))
        done = false;
    }
    }
    return done;
  }



  public boolean nextSlide () {
    NavigationRefreshAction done = presentationContext.nextSlide();
    refreshViews(done);
    return done != NavigationRefreshAction.NONE;
  }

  public void refreshViews (NavigationRefreshAction done) {

    if (done.equals(NavigationRefreshAction.DIFFERENT_ITEM_START)) {
      presentationContext.toItem(presentationContext.getCurrentSessionItem(), false);
    }
    else
      if (done.equals(NavigationRefreshAction.DIFFERENT_ITEM_END)) {
        presentationContext.toItem(presentationContext.getCurrentSessionItem(), true);
      }

    if (! done.equals(NavigationRefreshAction.NONE)) {
      for (IPresentationView nextView : getRegisteredViews()) {
        LOGGER.info("Dispatch refreshView to " + nextView.getClass().getName() + "-" + System.identityHashCode(nextView));
        nextView.refresh();
      }
    }
  }

  public boolean previousSlide () {
    NavigationRefreshAction done = presentationContext.previousSlide();
    refreshViews(done);
    return done != NavigationRefreshAction.NONE;
  }

  public boolean previousSong () {
    boolean done = presentationContext.previousSong();
    toItem(presentationContext.getCurrentSessionItem());
    return done;
  }

  public boolean nextSong () {
    boolean done = presentationContext.nextSong();
    toItem(presentationContext.getCurrentSessionItem());
    return done;
  }

  public void toggleBlack (boolean isSelected) {
    if (isSelected)
      presentationContext.setSpecialSlide(SpecialSlide.BLACK);
    else
      presentationContext.setSpecialSlide(SpecialSlide.NONE);

    refreshViews(NavigationRefreshAction.REFRESH_VIEW);
  }

  public void toggleWhite (boolean isSelected) {
    if (isSelected)
      presentationContext.setSpecialSlide(SpecialSlide.WHITE);
    else
      presentationContext.setSpecialSlide(SpecialSlide.NONE);

    refreshViews(NavigationRefreshAction.REFRESH_VIEW);
  }

  public void toggleOnlyBackground (boolean isSelected) {
    if (isSelected)
      presentationContext.setSpecialSlide(SpecialSlide.WITHOUT_TEXT);
    else
      presentationContext.setSpecialSlide(SpecialSlide.NONE);

    refreshViews(NavigationRefreshAction.REFRESH_VIEW);
  }


}
