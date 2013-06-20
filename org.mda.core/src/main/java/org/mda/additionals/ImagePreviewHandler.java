package org.mda.additionals;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import org.mda.resources.ImageDescriptor;


public class ImagePreviewHandler implements IPreviewHandler {

  @Override
  public ImageDescriptor getImage (File file, final String key) {
    return null;
  }

  @Override
  public Collection<AdditionalSuffix> getSupportedSuffixes () {
    Collection <AdditionalSuffix> suffixes = new ArrayList<AdditionalSuffix>();
    suffixes.add(AdditionalSuffix.PNG);
    suffixes.add(AdditionalSuffix.JPG);
    return suffixes;
  }

  @Override
  public void play (File file) {
    //nothing to do, because a image must not be played

  }

}
