package org.mda.export.powerpoint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import mda.AbstractSessionItem;
import mda.ExportConfiguration;
import org.apache.poi.hslf.model.Fill;
import org.apache.poi.hslf.model.Picture;
import org.apache.poi.hslf.model.Slide;
import org.apache.poi.hslf.model.TextBox;
import org.apache.poi.hslf.usermodel.RichTextRun;
import org.apache.poi.hslf.usermodel.SlideShow;
import org.eclipse.swt.graphics.Point;
import org.mda.commons.ui.DefaultMidiFileContentEditorConfig;
import org.mda.export.AbstractExporter;
import org.mda.export.ExportException;
import org.mda.export.ExportResult;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;

public class PptExporter extends AbstractExporter {

  private final static Log LOG = LogFactory.getLogger(PptExporter.class);



  public ExportResult export (final Collection<AbstractSessionItem> items, final File exportFile, final ExportConfiguration exportconfig) throws ExportException {
    if (! exportFile.getAbsoluteFile().getParentFile().exists())
      exportFile.getParentFile().mkdirs();

    SlideShow show = new SlideShow();
    show.setPageSize(new Dimension(getCalculator().getConfig().getDefaultPresentationScreenSize().x, getCalculator().getConfig().getDefaultPresentationScreenSize().y));

    DefaultMidiFileContentEditorConfig config = new DefaultMidiFileContentEditorConfig();
    config.setChordVisible(exportconfig.isWithChords());
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
    ExportResult result = new ExportResult();
    return result;
  }

  private void exportSlide (SlideShow show, org.mda.commons.ui.calculator.Slide song) {

    if (song.getItems().size() == 0)
      return;

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
      fill.setFillType(Fill.FILL_SOLID);
      fill.setForegroundColor(Color.BLACK);
    }

    int height = song.getItems().get(0).getHeight();
    int y = 0;
    for (int i = 0; i < song.getLineCount(); i++) {
      TextBox txt = new TextBox();
      txt.setText(song.getTextline(i));

      RichTextRun rt = txt.getTextRun().getRichTextRuns()[0];
      rt.setFontColor(Color.WHITE);
      rt.setFontSize(song.getFont().getFontData() [0].getHeight());
      rt.setFontName("Arial");
      rt.setAlignment(TextBox.AlignLeft);

      Rectangle2D rect = new Rectangle();
      rect.setRect(10, y, show.getPageSize().getWidth() - 10, song.getItems().get(0).getHeight());
      txt.setAnchor(rect);

      newSlide.addShape(txt);
      y += height + 10;

    }

//    for (SlideItem nextItem: song.getItems()) {
//      TextBox txt = new TextBox();
//      txt.setText(nextItem.getText());
//
//      RichTextRun rt = txt.getTextRun().getRichTextRuns()[0];
//      rt.setFontSize(song.getFont().getFontData() [0].getHeight() + 15);
//      rt.setFontName("Arial Alternative");
//      rt.setAlignment(TextBox.AlignLeft);
//
//      Rectangle2D rect = new Rectangle();
//      rect.setRect(nextItem.getX(), nextItem.getY(), nextItem.getWidth(), nextItem.getHeight());
//      txt.setAnchor(rect);
//      newSlide.addShape(txt);
//    }
  }

  @Override
  public String getSuffix () {
    return ".ppt";
  }

}
