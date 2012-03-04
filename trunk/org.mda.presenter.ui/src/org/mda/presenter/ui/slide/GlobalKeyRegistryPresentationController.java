package org.mda.presenter.ui.slide;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.mda.presenter.ui.DefaultPresentationController;

public class GlobalKeyRegistryPresentationController extends DefaultPresentationController {

  private Display  display;

  private Listener listener;
  boolean toggled = false;

  public GlobalKeyRegistryPresentationController (final Display display) {
    this.display = display;
    this.listener = createListener();
    this.display.addFilter(SWT.KeyDown, listener);
  }

  private Listener createListener () {
    return new Listener() {

      @Override
      public void handleEvent (Event e) {
        if (e.character == SWT.ESC)
          end();

        if (e.keyCode == SWT.ARROW_RIGHT && e.stateMask == SWT.NONE)
          nextSlide();

        if (e.keyCode == SWT.ARROW_LEFT && e.stateMask == SWT.NONE)
          previousSlide();

        if (e.keyCode == SWT.ARROW_LEFT && e.stateMask == SWT.SHIFT)
          previousSong();

        if (e.keyCode == SWT.ARROW_RIGHT && e.stateMask == SWT.SHIFT)
          nextSong();

        if (e.character == 'w') {
          toggled = ! toggled;
          toggleWhite(toggled);
        }

        if (e.character == 'b') {
          toggled = ! toggled;
          toggleBlack(toggled);
        }

        if (e.character == 't') {
          toggled = ! toggled;
          toggleOnlyBackground(toggled);
        }
      }
    };
  }

  public void close () {
    display.removeFilter(SWT.KeyDown, listener);

  }

}
