package org.mda.presenter.ui;

import java.io.File;

import javax.inject.Inject;

import mda.AbstractSessionItem;
import mda.Session;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import org.mda.ApplicationSession;
import org.mda.commons.ui.calculator.Slide;
import org.mda.commons.ui.calculator.SlideItem;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.presenter.ui.slide.IPresentationView;


@Creatable
public class BeamerPresenter implements IPresentationView {

  private static final Log LOGGER  = LogFactory.getLogger(BeamerPresenter.class);

  @Inject
  private PresentationContext  presentationContext;
  
  @Inject
  private ApplicationSession applicationSession;

  private Image currentShownImage = null;
  private File currentShownImageAsFile;

  private Shell shell;


  private Monitor getPreferredExternalMonitor (Display display) {
    for (Monitor nextMonitor: display.getMonitors()) {
      if (! nextMonitor.equals(Display.getCurrent().getPrimaryMonitor()))
        return nextMonitor;
    }

    return display.getPrimaryMonitor();

  }
  
  public Shell getShell () {
	  return shell;
  }

  public Shell build (Display display, Session session, final boolean onTop) {
	shell = new Shell (display, onTop ? SWT.ON_TOP: SWT.NONE);

    Monitor preferredMonitor = getPreferredExternalMonitor(display);
    if (! preferredMonitor.equals(Display.getCurrent().getPrimaryMonitor())) {
      Rectangle bounds = getPreferredExternalMonitor(display).getBounds();
      LOGGER.info("Set beamer-size to " + bounds.width + "x" + bounds.height);
      shell.setBounds(bounds);
      //1400x1050 =0,75   ->preview: 770x262 = 0,34
    }

    LOGGER.info("Bounds of Display: " + Display.getCurrent().getBounds());
    LOGGER.info("ClientArea of Display: " + Display.getCurrent().getClientArea());

    shell.setBackground(shell.getDisplay().getSystemColor(SWT.COLOR_BLACK));

    shell.open();
    shell.setFocus();

    shell.addPaintListener(new PaintListener() {
      @Override
      public void paintControl (PaintEvent e) {
    	  if (shell.isDisposed())
    		  return;
    	  
        LOGGER.info("BeamerPresenter.paintControl called");
        Font font = shell.getFont();
        e.gc.setFont(font);

        if (presentationContext.getSpecialSlide() == SpecialSlide.BLACK) {
          e.gc.setBackground(shell.getDisplay().getSystemColor(SWT.COLOR_BLACK));
          e.gc.fillRectangle(e.gc.getClipping());
          return;
        }

        if (presentationContext.getSpecialSlide() == SpecialSlide.WHITE) {
          e.gc.setBackground(shell.getDisplay().getSystemColor(SWT.COLOR_WHITE));
          e.gc.fillRectangle(e.gc.getClipping());
          return;
        }

        if (presentationContext.getCurrentSlide().getBackgroundImageFile() != null) {
          if (currentShownImage == null ||
              ! currentShownImageAsFile.equals(getCurrentSlide().getBackgroundImageFile()) ||   //image has changed
              currentShownImage.getBounds().width != shell.getBounds().width ||                       // size has changed
              currentShownImage.getBounds().height != shell.getBounds().height) {
            LOGGER.info("Repaint background image: " + (currentShownImage != null ? currentShownImage.getBounds() : "<null>") +  shell.getBounds());
            shell.setBackgroundImage(getCurrentSlide().getBackgroundImage(shell.getSize()));
            currentShownImage = shell.getBackgroundImage();
            currentShownImageAsFile = getCurrentSlide().getBackgroundImageFile();
          }
        }
        else {
          shell.setBackgroundImage(null);
          shell.setBackground(getCurrentSlide().getBackgroundColor());
          currentShownImage = null;
          currentShownImageAsFile = null;
        }

        e.gc.setForeground(getCurrentSlide().getForegroundColor());


        if (presentationContext.getSpecialSlide() == SpecialSlide.WITHOUT_TEXT) {
          return;
        }

        for (SlideItem nextItem: getCurrentSlide().getItems()) {
          e.gc.setFont(getCurrentSlide().getFont());
          e.gc.drawText(nextItem.getText(), nextItem.getX(), nextItem.getY(), true);
        }

        if (applicationSession != null && applicationSession.getGlobalConfs().isShowGrid()) {
          showGrid (e.gc, getCurrentSlide().getSize());
        }

      }

      private void showGrid (GC gc, Point size) {
        for (int i = 0; i < size.x; i += 100) {
          gc.drawLine(i, 0, i, size.y);
        }

        for (int i = 0; i < size.y; i += 100) {
          gc.drawLine(0, i, size.x, i);
        }

      }
    });

    shell.redraw();
    return shell;
  }


  public Slide getCurrentSlide () {
    return presentationContext.getCurrentSlide();
  }

  @Override
  public void end () {
	  shell.dispose();
  }

  public boolean toItem (AbstractSessionItem item) {
    shell.redraw();
    return true;
  }


  @Override
  public void refresh () {
	  shell.redraw();
  }

   public AbstractSessionItem getCurrentSessionItem () {
    return presentationContext.getCurrentSessionItem();
  }


}
