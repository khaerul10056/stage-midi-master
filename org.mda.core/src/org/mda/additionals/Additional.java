package org.mda.additionals;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import mda.AdditionalType;
import org.eclipse.swt.graphics.Image;


public class Additional {

  private final AdditionalType type;

  private final String name;

  private final AdditionalSuffix suffix;

  private final File file;
  private Image descriptor;

  private static Collection <IPreviewHandler> previewHandlers = new ArrayList<IPreviewHandler>();

  static {
    previewHandlers.add(new ImagePreviewHandler());
  }

  public Additional (final File file, final AdditionalType type, String name, AdditionalSuffix suffix) {
    this.file = file;
    this.type = type;
    this.name = name;
    this.suffix = suffix;

  }

  private IPreviewHandler getPreviewHandler () {
    for (IPreviewHandler next: previewHandlers) {
      if (next.getSupportedSuffixes().contains(suffix))
          return next;

    }

    return new NoPreviewHandler();

  }

  public Image getImage () {
    return getPreviewHandler().getImage(getFile());

  }

  public AdditionalSuffix getSuffix () {
    return suffix;
  }

  public String getName () {
    return name;
  }

  public AdditionalType getType () {
    return type;
  }

  public File getFile () {
    return file;
  }

  public String toString () {
    return name + "." + suffix.name().toLowerCase();
  }

}
