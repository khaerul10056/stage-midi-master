package org.mda.presenter.config;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import mda.MidiFilePartType;
import mda.impl.PresentationSchemeImpl;

import org.mda.ApplicationSession;
import org.mda.presenter.adapter.Color;
import org.mda.presenter.adapter.Font;
import org.mda.presenter.adapter.IGraphicsContext;
import org.mda.presenter.adapter.Size;


public class DefaultMidiFilePresenterConfig extends PresentationSchemeImpl implements IMidiFilePresenterConfig {

  

  private Size                  defaultPresentationScreenSize = new Size (1280, 800); //TODO make better

  private List<MidiFilePartType> partsToIgnore   = new ArrayList<MidiFilePartType>();



  @Inject
  private IGraphicsContext graphicsContext;

  @Inject
  private ApplicationSession session;

  /**
   * configuration to define the used fontsize
   */
  private Integer fontsize;
 

  @Override
  public Font getFont () {
    if (fontsize != null)
      return new Font(fontsize);

    if (session != null && session.getCurrentModel() != null && session.getCurrentModel().getConfig() != null && session.getCurrentModel().getConfig().getFontsize() != null)
      return new Font(session.getCurrentModel().getConfig().getFontsize());

    return new Font(40);
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
  public Size getDefaultPresentationScreenSize () {
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
  
  @Override
  public void setDefaultPresentationScreenSize (Size defaultPresentationScreenSize) {
	    this.defaultPresentationScreenSize = defaultPresentationScreenSize;
  }
  
  
  //Convience Methods for presentationscheme
  @Override
  public boolean isChordPresented () {
    return getShowChords() != null ? getShowChords().booleanValue() : true;
  }

  @Override
  public Color getDefaultBackgroundColor () {
    return PresentationConfigurator.getColorOrDefaultColor(getBackgroundColor(),Color.BLACK);
  }
  
  @Override
  public Color getDefaultForegroundColor () {
	  return PresentationConfigurator.getColorOrDefaultColor(getForegroundColor(), Color.WHITE);
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

  @Override
public boolean isSkipEmptySlides () {
    return getSkipEmptySlides() != null ? getSkipEmptySlides().booleanValue() : false;
  }

  @Override
public boolean isOptimizeLineFilling () {
    return getOptimizeLineFilling() != null ? getOptimizeLineFilling().booleanValue() : false;
  }
  
  @Override
public Integer getBorder () {
    return super.getBorder() != null ? super.getBorder() : 0;
  }

  @Override
public boolean isOptimizeEqualParts () {
    return getOptimizeEqualParts() != null ? getOptimizeEqualParts().booleanValue() : false;
  }

  @Override
public boolean isOptimizeEmptyTokens () {
    return getOptimizeEmptyTokens() != null ? getOptimizeEmptyTokens().booleanValue() : false;
  }

  @Override
  public boolean isShowCopyright () {
    return getShowCopyright() != null ? getShowCopyright().booleanValue(): false;
  }

  @Override
public boolean isAutoWrapToNewPage () {
    return getAutoWrapToNewPage() != null ? getAutoWrapToNewPage().booleanValue() : false;
  }


}
