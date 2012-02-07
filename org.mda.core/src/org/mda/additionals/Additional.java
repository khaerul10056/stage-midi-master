package org.mda.additionals;

import java.io.File;
import mda.AdditionalType;


public class Additional {

  private final AdditionalType type;

  private final String name;

  private final String suffix;

  private final File file;

  public Additional (final File file, final AdditionalType type, String name, String suffix) {
    this.file = file;
    this.type = type;
    this.name = name;
    this.suffix = suffix;

  }

  public String getSuffix () {
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

}
