package org.mda.additionals;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;


public class ImagePreviewHandler implements IPreviewHandler {

  @Override
  public Image getImage (File file) {
    try {
      return ImageDescriptor.createFromURL(file.toURL()).createImage();
    }
    catch (Exception e) {
      return null;
    }
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
