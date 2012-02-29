package org.mda.presenter.ui;

import java.io.File;
import java.util.Collection;
import java.util.logging.Logger;
import mda.AbstractSessionItem;
import mda.Session;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import org.mda.commons.ui.IMidiFileEditorUIConfig;
import org.mda.commons.ui.calculator.Slide;
import org.mda.commons.ui.calculator.SlideItem;
import org.mda.presenter.ui.slide.IPresentationView;


public class BeamerPresenter extends Shell implements IPresentationView {

  private static final Logger LOGGER  = Logger.getLogger(BeamerPresenter.class.getName());

  private PresentationContext  presentationContext = MdaPresenterModule.getInjector().getInstance(PresentationContext.class);

  private Image currentShownImage = null;
  private File currentShownImageAsFile;


  private Monitor getPreferredExternalMonitor (Display display) {
    for (Monitor nextMonitor: display.getMonitors()) {
      if (! nextMonitor.equals(Display.getCurrent().getPrimaryMonitor()))
        return nextMonitor;
    }

    return Display.getCurrent().getPrimaryMonitor();

  }

  public BeamerPresenter (Display display, Session session, final boolean onTop) {
    super (display, onTop ? SWT.ON_TOP: SWT.NONE);

    Monitor preferredMonitor = getPreferredExternalMonitor(display);
    if (! preferredMonitor.equals(Display.getCurrent().getPrimaryMonitor())) {
      Rectangle bounds = getPreferredExternalMonitor(display).getBounds();
      LOGGER.info("Set beamer-size to " + bounds.width + "x" + bounds.height);
      setBounds(bounds);
      //1400x1050 =0,75   ->preview: 770x262 = 0,34
    }

    LOGGER.info("Bounds of Display: " + Display.getCurrent().getBounds());
    LOGGER.info("ClientArea of Display: " + Display.getCurrent().getClientArea());

    for (Shell shell: Display.getCurrent().getShells()) {
      LOGGER.info ("Shell " + shell.getText() + "-" + shell.getBounds());
    }

    setBackground(getDisplay().getSystemColor(SWT.COLOR_BLACK));

    for (IPresentationController nextController: presentationContext.getRegisteredControllers()) {
      nextController.connect(this);
    }

    open();
    setFocus();



    addPaintListener(new PaintListener() {



      @Override
      public void paintControl (PaintEvent e) {
        Font font = getFont();
        e.gc.setFont(font);

        if (presentationContext.getCurrentSlide().getBackgroundImageFile() != null) {
          if (currentShownImage == null ||
              ! currentShownImageAsFile.equals(getCurrentSlide().getBackgroundImageFile()) ||   //image has changed
              currentShownImage.getBounds().width != getBounds().width ||                       // size has changed
              currentShownImage.getBounds().height != getBounds().height) {
            LOGGER.info("Repaint background image: " + (currentShownImage != null ? currentShownImage.getBounds() : "<null>") +  getBounds());
            setBackgroundImage(getCurrentSlide().getBackgroundImage(getSize()));
            currentShownImage = getBackgroundImage();
            currentShownImageAsFile = getCurrentSlide().getBackgroundImageFile();
          }
        }
        else {
          setBackgroundImage(null);
          setBackground(getCurrentSlide().getBackgroundColor());
          currentShownImage = null;
          currentShownImageAsFile = null;
        }

        e.gc.setForeground(getCurrentSlide().getForegroundColor());


        for (SlideItem nextItem: getCurrentSlide().getItems()) {
          e.gc.setFont(getCurrentSlide().getFont());
          e.gc.drawText(nextItem.getText(), nextItem.getX(), nextItem.getY(), true);
        }
      }
    });

    redraw();
  }

  public Slide getCurrentSlide () {
    return presentationContext.getCurrentSlide();
  }

  public void setBackgroundImage(Image newImage) {
    if (currentShownImage != null)
      currentShownImage.dispose();
    super.setBackgroundImage(newImage);
  }


  protected void checkSubclass () {
    /* Do nothing - Subclassing is allowed */
  }

  @Override
  public void end () {
    dispose();
  }




  @Override
  public boolean nextSlide () {
    boolean bool = presentationContext.nextSlide();
    if (bool)
      redraw();

    return true;
  }

  @Override
  public boolean previousSlide () {
    boolean bool = presentationContext.previousSlide();
    if (bool)
      redraw();

    return true;
  }

  @Override
  public boolean toItem (AbstractSessionItem item) {
    boolean bool = presentationContext.toItem(item);
    if (bool)
      redraw();

    LOGGER.info("To item (not found)");
    return false;
  }

  public AbstractSessionItem getCurrentSessionItem () {
    return presentationContext.getCurrentSessionItem();
  }


}
