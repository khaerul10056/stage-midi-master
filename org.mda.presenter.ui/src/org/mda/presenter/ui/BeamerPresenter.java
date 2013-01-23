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
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.mda.ApplicationSession;
import org.mda.commons.ui.MonitorManager;
import org.mda.commons.ui.Util;
import org.mda.commons.ui.imagecache.ImageCache;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.presenter.IPresentationView;
import org.mda.presenter.PresentationContext;
import org.mda.presenter.Slide;
import org.mda.presenter.SlideItem;
import org.mda.presenter.SpecialSlide;
import org.mda.presenter.adapter.FontInfo;


@Creatable
public class BeamerPresenter implements IPresentationView {

  private static final Log LOGGER  = LogFactory.getLogger(BeamerPresenter.class);

  @Inject
  private PresentationContext  presentationContext;
  
  @Inject
  private ColorResolver colorResolver;
  
  @Inject
  private ApplicationSession applicationSession;

  private Image currentShownImage = null;
  private File currentShownImageAsFile;
  
  @Inject
  private MonitorManager monitormanager;
  
  @Inject
  private ImageCache imageCache;

  private Shell shell;


  public Shell getShell () {
	  return shell;
  }

  public Shell build (Display display, Session session, final boolean onTop) {
	shell = new Shell (onTop ? SWT.ON_TOP: SWT.NONE);
	LOGGER.info(monitormanager.toString());
	shell.setBounds(monitormanager.getBeamerOrPreviewBounds());
    Util.disableEscOnComponent(shell);

    shell.setBackground(shell.getDisplay().getSystemColor(SWT.COLOR_BLACK));

    shell.open();
    shell.setFocus();

    shell.addPaintListener(new PaintListener() {
      @Override
      public void paintControl (PaintEvent e) {
    	  if (shell.isDisposed())
    		  return;
    	  
        LOGGER.info("BeamerPresenter.paintControl called with part " + presentationContext.getCurrentSlide().getModelRef());
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
            
            Image scaledImage =  imageCache.getImage(getCurrentSlide().getBackgroundImageFile(), shell.getSize());
            shell.setBackgroundImage(scaledImage);
            currentShownImage = shell.getBackgroundImage();
            currentShownImageAsFile = getCurrentSlide().getBackgroundImageFile();
          }
        }
        else {
          shell.setBackgroundImage(null);
          shell.setBackground(colorResolver.getColor(getCurrentSlide().getBackgroundColor()));
          currentShownImage = null;
          currentShownImageAsFile = null;
        }

        e.gc.setForeground(colorResolver.getColor(getCurrentSlide().getForegroundColor()));


        if (presentationContext.getSpecialSlide() == SpecialSlide.WITHOUT_TEXT) {
          return;
        }

        for (SlideItem nextItem: getCurrentSlide().getItems()) {
        	FontInfo font2 = getCurrentSlide().getFont();
        	
          Font swtfont = new Font(shell.getDisplay(), font2.getFontname(), font2.getFontsizeAsInt(), font2.isBold() ? SWT.BOLD : SWT.NORMAL);
          e.gc.setFont(swtfont);
          e.gc.drawText(nextItem.getText(), (int)nextItem.getX(), (int) nextItem.getY(), true);
        }

        if (applicationSession != null && applicationSession.getGlobalConfs().isShowGrid()) {
          showGrid (e.gc, (int) getCurrentSlide().getSize().getWidth(), (int) getCurrentSlide().getSize().getHeight());
        }

      }

      private void showGrid (GC gc, int width, int height) {
        for (int i = 0; i < width; i += 100) {
          gc.drawLine(i, 0, i, height);
        }

        for (int i = 0; i < height; i += 100) {
          gc.drawLine(0, i, width, i);
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
