package org.mda.additionals;

import mda.AdditionalType;

import org.mda.resources.ImageDescriptor;


public class AdditionalInfo {



  private final AdditionalSuffix suffix;
  private final ImageDescriptor image;
  private final AdditionalType type;

  public AdditionalInfo (AdditionalSuffix suffix, ImageDescriptor image, AdditionalType type ) {
    this.suffix = suffix;
    this.image = image;
    this.type = type;

  }

  public AdditionalSuffix getSuffix () {
    return suffix;
  }

  public ImageDescriptor getImage () {
    return image;
  }

  public AdditionalType getType () {
    return type;
  }

}
