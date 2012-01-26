package org.mda.presenter.ui.slide;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.mda.presenter.ui.DefaultPresentationController;

public class GlobalKeyRegistryPresentationController extends DefaultPresentationController {

  private Display  display;

  private Listener listener;

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

        if (e.keyCode == SWT.ARROW_RIGHT)
          nextSlide();

        if (e.keyCode == SWT.ARROW_LEFT)
          previousSlide();
      }
    };
  }

  public void close () {
    display.removeFilter(SWT.KeyDown, listener);

  }

}
