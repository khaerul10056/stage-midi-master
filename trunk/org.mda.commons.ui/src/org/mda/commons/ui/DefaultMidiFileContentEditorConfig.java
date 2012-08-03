package org.mda.commons.ui;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import mda.MidiFilePartType;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.mda.ApplicationSession;
import org.mda.Utils;
import org.mda.commons.ui.calculator.FontDescriptor;
import org.mda.commons.ui.calculator.SWTGraphicsContext;


public class DefaultMidiFileContentEditorConfig implements IMidiFileEditorUIConfig {

  private boolean                chordVisible    = true;


  private boolean                editable        = true;

  /**
   * if set to true, every part is layouted on a new side
   * if set to false, any part of one item is layouted on one slide
   */
  private boolean                pagePerPart    = true;

  private Point                  defaultPresentationScreenSize = new Point (1280, 800); //TODO make better

  private Color                  backgroundColor = Display.getDefault().getSystemColor(SWT.COLOR_BLACK);

  private Color                  foregroundColor = Display.getDefault().getSystemColor(SWT.COLOR_WHITE);

  private List<MidiFilePartType> partsToIgnore   = new ArrayList<MidiFilePartType>();



  private IGraphicsContext graphicsContext = new SWTGraphicsContext();

  @Inject
  private ApplicationSession session;

  /**
   * configuration to define the used fontsize
   */
  private Integer fontsize;

  /**
   * configuration if a background-picture should be shown
   */
  private boolean showBackground;

  /**
   * configuration if the type of the current block (e.g. REFRAIN) should be
   * shown in front of the first line of a block
   */
  private boolean showBlockType;

  /**
   * start a new page automatically if text is out of border of the page
   */
  private boolean autoWrapToNewPage = true;


  /**
   * configuration if newPage should lead to a new slide
   */
  private boolean newPageRespected = true;

  /**
   * configuration if the title should be shown
   */
  private boolean showTitle = false;

  /**
   * configuration if copyright-information should be shown
   */
  private boolean showCopyright;


  /**
   * configuration if empty slides should be removed
   */
  private boolean skipEmptySlides = false;

  /**
   * checks if the next line of the part can be moved to the current line
   * so the songs need less place on a page
   */
  private boolean optimizeLineFilling = false;

  /**
   * multiple occurences of same parts are not shown multiple times but are shown as e.g. REFAIN 2x or the tag without content
   */
  private boolean optimizeEqualParts = false;

  /**
   * true: empty tokens are not shown and don't need any place
   * false: empty tokens, e.g. "    " need the place they are defined
   */
  private boolean optimizeEmptyTokens = false;

  /**
   * border for the slide
   */
  private Integer border = null;



  public FontDescriptor getFont () {
    if (fontsize != null)
      return new FontDescriptor(fontsize);

    if (session != null && session.getCurrentModel() != null && session.getCurrentModel().getConfig() != null && session.getCurrentModel().getConfig().getFontsize() != null)
      return new FontDescriptor(session.getCurrentModel().getConfig().getFontsize());

    return new FontDescriptor(40);
  }

  public void setFontsize (Integer fontsize) {
    this.fontsize = fontsize;
  }


  @Override
  public boolean isChordPresented () {
    return chordVisible;
  }

  public void setChordVisible (boolean chordVisible) {
    this.chordVisible = chordVisible;
  }

  public void setEditable (boolean editable) {
    this.editable = editable;
  }

  public boolean isEditable () {
    return editable;
  }

  public void setBackgroundColor (String backgroundColor) {
    this.backgroundColor = Utils.stringToColor(backgroundColor, null);
  }

  public Color getDefaultBackgroundColor () {
    return backgroundColor;
  }

  public void setForegroundColor (String foregroundColor) {
    this.foregroundColor = Utils.stringToColor(foregroundColor, null);
  }

  public Color getDefaultForegroundColor () {
    return foregroundColor;
  }

  public void addIgnoredPartType (MidiFilePartType solo) {
    partsToIgnore.add(solo);
  }

  public boolean isPartIgnored (final MidiFilePartType parttype) {
    return partsToIgnore.contains(parttype);
  }

  @Override
  public Point getDefaultPresentationScreenSize () {
    return defaultPresentationScreenSize;
  }

  @Override
  public boolean isShowBackground () {
    return showBackground;
  }

  public void setShowBackground (boolean showBackground) {
    this.showBackground = showBackground;
  }

  @Override
  public boolean isShowBlockType () {
    return showBlockType;
  }

  public void setShowBlockType (final boolean showBlockType) {
    this.showBlockType = showBlockType;
  }

  public boolean isPagePerPart () {
    return pagePerPart;
  }

  public void setPagePerPart (boolean pagePerPart) {
    this.pagePerPart = pagePerPart;
  }

  @Override
  public IGraphicsContext getGraphicsContext () {
    if (graphicsContext == null)
      throw new IllegalStateException("No Graphics context set, but accessed");
    return graphicsContext;
  }

  public void setGraphicsContext (IGraphicsContext graphicsContext) {
    this.graphicsContext = graphicsContext;
  }

  @Override
  public boolean isNewPageRespected () {
    return newPageRespected;
  }

  public void setNewPageRespected (boolean newPageRespected) {
    this.newPageRespected = newPageRespected;
  }

  @Override
  public boolean isShowTitle () {
    return showTitle;
  }

  public void setShowTitle (boolean showTitle) {
    this.showTitle = showTitle;
  }

  public boolean isSkipEmptySlides () {
    return skipEmptySlides;
  }

  public void setSkipEmptySlides (boolean skipEmptySlides) {
    this.skipEmptySlides = skipEmptySlides;
  }

  public boolean isOptimizeLineFilling () {
    return optimizeLineFilling;
  }

  public void setOptimizeLineFilling (boolean optimizeLineFilling) {
    this.optimizeLineFilling = optimizeLineFilling;
  }

  public Integer getBorder () {
    if (border == null)
      return 0;

    return border;
  }

  public void setBorder (Integer border) {
    this.border = border;
  }

  public boolean isOptimizeEqualParts () {
    return optimizeEqualParts;
  }

  public void setOptimizeEqualParts (boolean optimizeEqualParts) {
    this.optimizeEqualParts = optimizeEqualParts;
  }

  public boolean isOptimizeEmptyTokens () {
    return optimizeEmptyTokens;
  }

  public void setOptimizeEmptyTokens (boolean optimizeEmptyTokens) {
    this.optimizeEmptyTokens = optimizeEmptyTokens;
  }

  @Override
  public boolean isShowCopyright () {
    return showCopyright;
  }

  public void setShowCopyright (boolean showCopyright) {
    this.showCopyright = showCopyright;
  }

  public void setDefaultPresentationScreenSize (Point defaultPresentationScreenSize) {
    this.defaultPresentationScreenSize = defaultPresentationScreenSize;
  }

  public boolean isAutoWrapToNewPage () {
    return autoWrapToNewPage;
  }

  public void setAutoWrapToNewPage (boolean autoWrapToNewPage) {
    this.autoWrapToNewPage = autoWrapToNewPage;
  }




}
