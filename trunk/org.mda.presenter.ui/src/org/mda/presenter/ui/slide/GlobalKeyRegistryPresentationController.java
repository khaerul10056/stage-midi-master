package org.mda.presenter.ui.slide;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.mda.presenter.ui.DefaultPresentationController;

@Creatable
public class GlobalKeyRegistryPresentationController extends DefaultPresentationController {

  private Display  display;

  private Listener listener;

  public GlobalKeyRegistryPresentationController () {
    this.display = Display.getCurrent();
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
          toggleWhite();
        }

        if (e.character == 'b') {
          toggleBlack();
        }

        if (e.character == 't') {
          toggleOnlyBackground();
        }
        
        if (e.character == 'n') {
            toggleNormalize();
          }
      }
    };
  }

  public void close () {
    display.removeFilter(SWT.KeyDown, listener);

  }

}
