package org.mda.additionals;

import org.eclipse.swt.graphics.Image;
import mda.AdditionalType;


public class AdditionalInfo {



  private final AdditionalSuffix suffix;
  private final Image image;
  private final AdditionalType type;

  public AdditionalInfo (AdditionalSuffix suffix, Image image, AdditionalType type ) {
    this.suffix = suffix;
    this.image = image;
    this.type = type;

  }

  public AdditionalSuffix getSuffix () {
    return suffix;
  }

  public Image getImage () {
    return image;
  }

  public AdditionalType getType () {
    return type;
  }

}
