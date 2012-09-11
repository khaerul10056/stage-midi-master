package org.mda.commons.ui;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import mda.MidiFilePartType;
import mda.impl.PresentationSchemeImpl;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.mda.ApplicationSession;
import org.mda.Utils;
import org.mda.commons.ui.calculator.FontDescriptor;
import org.mda.commons.ui.calculator.SWTGraphicsContext;


public class DefaultMidiFileContentEditorConfig extends PresentationSchemeImpl implements IMidiFileEditorUIConfig {

  

  private Point                  defaultPresentationScreenSize = new Point (1280, 800); //TODO make better

  private List<MidiFilePartType> partsToIgnore   = new ArrayList<MidiFilePartType>();



  private IGraphicsContext graphicsContext = new SWTGraphicsContext();

  @Inject
  private ApplicationSession session;

  /**
   * configuration to define the used fontsize
   */
  private Integer fontsize;
 

  @Override
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


  public void addIgnoredPartType (MidiFilePartType solo) {
    partsToIgnore.add(solo);
  }

  @Override
  public boolean isPartIgnored (final MidiFilePartType parttype) {
    return partsToIgnore.contains(parttype);
  }

  @Override
  public Point getDefaultPresentationScreenSize () {
    return defaultPresentationScreenSize;
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
  
  public void setDefaultPresentationScreenSize (Point defaultPresentationScreenSize) {
	    this.defaultPresentationScreenSize = defaultPresentationScreenSize;
	  }
  
  
  //Convience Methods for presentationscheme
  @Override
  public boolean isChordPresented () {
    return getShowChords() != null ? getShowChords().booleanValue() : true;
  }

  @Override
  public Color getDefaultBackgroundColor () {
    return getBackgroundColor() != null ? Utils.stringToColor(getBackgroundColor(), null) : Display.getDefault().getSystemColor(SWT.COLOR_BLACK);
  }
  
  @Override
  public Color getDefaultForegroundColor () {
	  return getForegroundColor() != null ? Utils.stringToColor(getForegroundColor(), null) : Display.getDefault().getSystemColor(SWT.COLOR_WHITE);
  }

  @Override
  public boolean isShowBackground () {
    return getShowBackground() != null ? getShowBackground().booleanValue() : false;
  }
  
  @Override
  public boolean isShowBlockType () {
    return getShowBlockType() != null ? getShowBlockType().booleanValue() : false; 
  }

  @Override
  public boolean isPagePerPart () {
    return getPagePerPart() != null ? getPagePerPart().booleanValue() : true;
  }
  


  @Override
  public boolean isNewPageRespected () {
    return getNewPageRespected() != null ? getNewPageRespected().booleanValue() : true;
  }

  @Override
  public boolean isShowTitle () {
    return getShowTitle() != null ? getShowTitle().booleanValue() : false; 
  }

  public boolean isSkipEmptySlides () {
    return getSkipEmptySlides() != null ? getSkipEmptySlides().booleanValue() : false;
  }

  public boolean isOptimizeLineFilling () {
    return getOptimizeLineFilling() != null ? getOptimizeLineFilling().booleanValue() : false;
  }
  
  public Integer getBorder () {
    return super.getBorder() != null ? super.getBorder() : 0;
  }

  public boolean isOptimizeEqualParts () {
    return getOptimizeEqualParts() != null ? getOptimizeEqualParts().booleanValue() : false;
  }

  public boolean isOptimizeEmptyTokens () {
    return getOptimizeEmptyTokens() != null ? getOptimizeEmptyTokens().booleanValue() : false;
  }

  @Override
  public boolean isShowCopyright () {
    return getShowCopyright() != null ? getShowCopyright().booleanValue(): false;
  }

  public boolean isAutoWrapToNewPage () {
    return getAutoWrapToNewPage() != null ? getAutoWrapToNewPage().booleanValue() : false;
  }


}
