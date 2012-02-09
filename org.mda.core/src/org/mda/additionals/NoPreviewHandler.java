package org.mda.additionals;

import java.io.File;
import java.util.Collection;
import org.eclipse.swt.graphics.Image;


public class NoPreviewHandler implements IPreviewHandler {

  @Override
  public Image getImage (File file) {
    return null;
  }

  @Override
  public Collection<AdditionalSuffix> getSupportedSuffixes () {
    return null;
  }

  @Override
  public void play (File file) {
    // TODO Auto-generated method stub

  }

}
