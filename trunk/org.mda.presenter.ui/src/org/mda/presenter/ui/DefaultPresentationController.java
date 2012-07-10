package org.mda.presenter.ui;

import mda.AbstractSessionItem;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.presenter.ui.slide.IPresentationView;
import org.mda.presenter.ui.slide.NavigationRefreshAction;


public class DefaultPresentationController implements IPresentationController {

  private static final Log LOGGER  = LogFactory.getLogger(DefaultPresentationController.class);

  private PresentationContext  presentationContext = MdaPresenterModule.getInjector().getInstance(PresentationContext.class);



  public void end () {
    presentationContext.closePresentationSession();
  }

  public boolean toItem (final AbstractSessionItem sessionItem) {
    boolean done = presentationContext.toItem(sessionItem, false);
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
      for (IPresentationView nextView : presentationContext.getRegisteredViews()) {
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
    if (done)
      toItem(presentationContext.getCurrentSessionItem());
    return done;
  }

  public boolean nextSong () {
    boolean done = presentationContext.nextSong();
    if (done)
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
