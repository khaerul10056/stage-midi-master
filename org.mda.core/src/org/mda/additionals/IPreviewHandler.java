package org.mda.additionals;

import java.io.File;
import java.util.Collection;
import org.eclipse.swt.graphics.Image;


public interface IPreviewHandler {

  public Image getImage (File file, String key);

  public Collection <AdditionalSuffix> getSupportedSuffixes ();

  public void play (File file);

}
