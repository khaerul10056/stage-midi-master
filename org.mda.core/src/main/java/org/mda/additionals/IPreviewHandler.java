package org.mda.additionals;

import java.io.File;
import java.util.Collection;

import org.mda.resources.ImageDescriptor;


public interface IPreviewHandler {

  public ImageDescriptor getImage (File file, String key);

  public Collection <AdditionalSuffix> getSupportedSuffixes ();

  public void play (File file);

}
