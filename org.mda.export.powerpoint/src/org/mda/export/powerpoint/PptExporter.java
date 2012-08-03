package org.mda.export.powerpoint;

import java.awt.Dimension;
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
import org.apache.poi.hslf.usermodel.RichTextRun;
import org.apache.poi.hslf.usermodel.SlideShow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.mda.ApplicationSession;
import org.mda.Utils;
import org.mda.commons.ui.IMidiFileEditorUIConfig;
import org.mda.export.AbstractExporter;
import org.mda.export.ExportException;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;

public class PptExporter extends AbstractExporter {

  private final static Log LOG = LogFactory.getLogger(PptExporter.class);

  private SlideShow lastExportedResult;

  @Inject
  private ApplicationSession applicationsession;



  public File export (final Collection<AbstractSessionItem> items, final File exportFile, final IMidiFileEditorUIConfig config) throws ExportException {
    if (! exportFile.getAbsoluteFile().getParentFile().exists())
      exportFile.getParentFile().mkdirs();

    SlideShow show = new SlideShow();
    show.setPageSize(new Dimension(getCalculator().getConfig().getDefaultPresentationScreenSize().x, getCalculator().getConfig().getDefaultPresentationScreenSize().y));

//    DefaultMidiFileContentEditorConfig config = new DefaultMidiFileContentEditorConfig();
//    config.setChordVisible(exportconfig.isWithChords());
//    config.setShowBackground(true);
//    config.setSkipEmptySlides(true);
//    config.setOptimizeLineFilling(false);
    getCalculator().setConfig(config);
    LOG.info("Calculate size " + show.getPageSize().width + "x" + show.getPageSize().height + " from " +
        getCalculator().getConfig().getDefaultPresentationScreenSize().x + "x" + getCalculator().getConfig().getDefaultPresentationScreenSize().y );
    getCalcPreCondition().setCalculationsize(new Point (show.getPageSize().width, show.getPageSize().height));

    for (AbstractSessionItem nextItem : items) {
      List<org.mda.commons.ui.calculator.Slide> calculate = getCalculator().calculate(nextItem, getCalcPreCondition());

      for (org.mda.commons.ui.calculator.Slide nextInternSlide : calculate) {
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

  private void exportSlide (SlideShow show, org.mda.commons.ui.calculator.Slide song) {

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
      fill.setBackgroundColor(Utils.toAwtColor(song.getBackgroundColor()));
      fill.setForegroundColor(Utils.toAwtColor(song.getBackgroundColor()));
    }

    int height = song.getItems().get(0).getHeight();
    int y = 0;
    for (int i = 0; i < song.getLineCount(); i++) {
      TextBox txt = new TextBox();
      txt.setText(song.getTextline(i));

      RichTextRun rt = txt.getTextRun().getRichTextRuns()[0];
      rt.setFontSize(song.getFont().getFontData() [0].getHeight());
      rt.setFontName("Arial");
      rt.setAlignment(TextBox.AlignLeft);
      if (song.getForegroundColor() != null)
        rt.setFontColor(Utils.toAwtColor(song.getForegroundColor()));
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

  private void paintGrid (Slide newSlide, Point size) {
    for (int i = 0; i < size.x; i += 100) {
      Line line = new Line();
      line.setLineStyle(Line.PEN_DOT);
      line.setAnchor(new Rectangle (i, 0, 0, size.y));
      newSlide.addShape(line);
    }

    for (int i = 0; i < size.y; i += 100) {
      Line line = new Line();
      line.setLineStyle(Line.PEN_DOT);
      line.setAnchor(new Rectangle (0, i, size.x, 0));
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
