package org.mda.additionals;

import java.io.File;
import java.util.Collection;

import org.mda.resources.ImageDescriptor;


public class NoPreviewHandler implements IPreviewHandler {

  @Override
  public ImageDescriptor getImage (File file, final String key) {
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
