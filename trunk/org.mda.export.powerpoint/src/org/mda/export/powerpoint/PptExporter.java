package org.mda.export.powerpoint;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import mda.AbstractSessionItem;

import org.apache.poi.hslf.model.Fill;
import org.apache.poi.hslf.model.Line;
import org.apache.poi.hslf.model.Picture;
import org.apache.poi.hslf.model.Slide;
import org.apache.poi.hslf.model.TextBox;
import org.apache.poi.hslf.model.TextShape;
import org.apache.poi.hslf.usermodel.RichTextRun;
import org.apache.poi.hslf.usermodel.SlideShow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.mda.ApplicationSession;
import org.mda.Utils;
import org.mda.export.AbstractExporter;
import org.mda.export.ExportException;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.presenter.CalculationParam;
import org.mda.presenter.adapter.ColorInfo;
import org.mda.presenter.adapter.SizeInfo;
import org.mda.presenter.config.IPresenterConfig;


public class PptExporter extends AbstractExporter {

  private final static Log LOG = LogFactory.getLogger(PptExporter.class);

  private SlideShow lastExportedResult;

  @Inject
  private ApplicationSession applicationsession;
  
  
  
  



  @Override
public File export (final Collection<AbstractSessionItem> items, final File exportFile, final IPresenterConfig config) throws ExportException {
    if (! exportFile.getAbsoluteFile().getParentFile().exists())
      exportFile.getParentFile().mkdirs();
    
    

    SlideShow show = new SlideShow();
    
    CalculationParam param = new CalculationParam(new SizeInfo (640, 480));

    for (AbstractSessionItem nextItem : items) {
      List<org.mda.presenter.Slide> calculate = getCalculator().calculate(nextItem, param, config).getSlides();

      for (org.mda.presenter.Slide nextInternSlide : calculate) {
        exportSlide(show, nextInternSlide);
      }
    }
    try {
    FileOutputStream out = new FileOutputStream(exportFile);
    show.write(out);
    out.close();
    } catch (IOException e) {
      throw new ExportException("Error saving file " + exportFile.getAbsolutePath(), e);
    }
    lastExportedResult = show;
    return exportFile;
  }

  private void exportSlide (SlideShow show, org.mda.presenter.Slide song) {

    if (song.getItems().size() == 0)
      return;

    LOG.info("In PptExporter: \n" + song.toString());

    Slide newSlide = show.createSlide();

    newSlide.setFollowMasterBackground(false);
    newSlide.setFollowMasterScheme(false);

    Fill fill = newSlide.getBackground().getFill();
    if (song.getBackgroundImageFile() != null) {

      int idx;
      try {
        idx = show.addPicture(song.getBackgroundImageFile(), Picture.JPEG); //TODO make dynamic
        fill.setFillType(Fill.FILL_PICTURE);
        fill.setPictureData(idx);
      }
      catch (IOException e) {
        e.printStackTrace();
      }
    }
    else {
      fill.setFillType(Fill.FILL_SHADE);
      fill.setBackgroundColor(toAwtColor(song.getBackgroundColor()));
      fill.setForegroundColor(toAwtColor(song.getBackgroundColor()));
    }

    int height = (int) song.getItems().get(0).getHeight();
    int y = 0;
    for (int i = 0; i < song.getLineCount(); i++) {
      TextBox txt = new TextBox();
      txt.setText(song.getTextline(i));

      RichTextRun rt = txt.getTextRun().getRichTextRuns()[0];
      rt.setFontSize(song.getFont().getFontsizeAsInt());
      rt.setFontName("Arial");
      rt.setAlignment(TextShape.AlignLeft);
      if (song.getForegroundColor() != null)
        rt.setFontColor(toAwtColor(song.getForegroundColor()));
      else
        rt.setFontColor(Utils.toAwtColor(Display.getDefault().getSystemColor(SWT.COLOR_WHITE)));

      Rectangle2D rect = new Rectangle();
      rect.setRect(10, y, show.getPageSize().getWidth() - 10, song.getItems().get(0).getHeight());
      txt.setAnchor(rect);

      newSlide.addShape(txt);
      y += height + 10;

    }

    if (applicationsession != null && applicationsession.getGlobalConfs().isShowGrid())
      paintGrid(newSlide, song.getSize());

  }
  
  private static java.awt.Color toAwtColor (final ColorInfo color) {
	    return new java.awt.Color (color.getRed(), color.getGreen(), color.getBlue());
  }

  private void paintGrid (Slide newSlide, SizeInfo size) {
    for (int i = 0; i < size.getWidth(); i += 100) {
      Line line = new Line();
      line.setLineStyle(Line.PEN_DOT);
      line.setAnchor(new Rectangle (i, 0, 0, size.getHeightAsInt()));
      newSlide.addShape(line);
    }

    for (int i = 0; i < size.getHeight(); i += 100) {
      Line line = new Line();
      line.setLineStyle(Line.PEN_DOT);
      line.setAnchor(new Rectangle (0, i, size.getWidthAsInt(), 0));
      newSlide.addShape(line);
    }

  }

  @Override
  public String getSuffix () {
    return ".ppt";
  }

  public SlideShow getLastExportedResult () {
    return lastExportedResult;
  }



}
