package org.mda.additionals;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.swt.graphics.Image;
import org.mda.Utils;


public class ImagePreviewHandler implements IPreviewHandler {

  @Override
  public Image getImage (File file, final String key) {
    return Utils.loadImageFromProject(file);
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
