package org.mda.presenter.config;

import java.util.ArrayList;
import java.util.List;

import mda.SongPartType;
import mda.impl.PresentationSchemeImpl;

import org.mda.ApplicationSession;
import org.mda.measurement.ColorInfo;
import org.mda.measurement.FontInfo;
import org.mda.presenter.adapter.IGraphicsContext;

import com.google.inject.Inject;


public class DefaultPresenterConfig extends PresentationSchemeImpl implements IPresenterConfig {

  

  private List<SongPartType> partsToIgnore   = new ArrayList<SongPartType>();



  @Inject
  private IGraphicsContext graphicsContext;

  @Inject
  private ApplicationSession session;

  /**
   * configuration to define the used fontsize
   */
  private Integer fontsize;
  

  @Override
  public FontInfo getFont () {
    if (fontsize != null)
      return new FontInfo(fontsize);

    if (session != null && session.getCurrentModel() != null && session.getCurrentModel().getConfig() != null && session.getCurrentModel().getConfig().getFontsize() != null)
      return new FontInfo(session.getCurrentModel().getConfig().getFontsize());

    return new FontInfo(40);
  }

  public void setFontsize (Integer fontsize) {
    this.fontsize = fontsize;
  }


  public void addIgnoredPartType (SongPartType solo) {
    partsToIgnore.add(solo);
  }

  @Override
  public boolean isPartIgnored (final SongPartType parttype) {
    return partsToIgnore.contains(parttype);
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
  
  
  
  
  //Convience Methods for presentationscheme
  @Override
  public boolean isChordPresented () {
    return getShowChords() != null ? getShowChords().booleanValue() : true;
  }

  @Override
  public ColorInfo getDefaultBackgroundColor () {
    return PresentationConfigurator.getColorOrDefaultColor(getBackgroundColor(),ColorInfo.BLACK);
  }
  
  @Override
  public ColorInfo getDefaultForegroundColor () {
	  return PresentationConfigurator.getColorOrDefaultColor(getForegroundColor(), ColorInfo.WHITE);
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
