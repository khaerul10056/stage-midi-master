package org.mda.additionals;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mda.AdditionalType;


public class AdditionalsHandler {

  private final List <Additional> additionals = new ArrayList<Additional>();

  private final File additionalsPath;

  public AdditionalsHandler (final File additionalsPath) {
    this.additionalsPath = additionalsPath;
    initialize();
  }

  public void read () {
    for (AdditionalType nextType: AdditionalType.VALUES) {
      File nextTypePath = new File (additionalsPath.getAbsolutePath(), nextType.toString().toLowerCase());
      for (File next: nextTypePath.listFiles()) {
        int suffixPos = next.getName().lastIndexOf(".");
        String name = suffixPos < 0 ? next.getName() : next.getName().substring(0, suffixPos);
        String suffix = suffixPos < 0 ? null : next.getName().substring(suffixPos + 1, next.getName().length());

        Additional additional = new Additional(next, nextType, name, suffix);
        getAdditionals().add(additional);
      }
    }
  }

  public void remove (final Additional additional) {
    if (!additional.getFile().delete())
      throw new IllegalStateException("Couldn't remove file " + additional.getFile());
    additionals.remove(additional);
  }

  public void initialize () {
    if (! additionalsPath.exists())
      additionalsPath.mkdirs();

    for (AdditionalType nextType: AdditionalType.VALUES) {
      File nextTypePath = new File (additionalsPath.getAbsolutePath(), nextType.toString().toLowerCase());
      if (! nextTypePath.exists())
        nextTypePath.mkdirs();
    }
  }

  public File getAdditionalsPath () {
    return additionalsPath;
  }

  public List <Additional> getAdditionals () {
    return additionals;
  }

  public List <Additional> getAdditionals (AdditionalType type) {
    List <Additional> filtered = new ArrayList<Additional>();
    for (Additional next: additionals) {
      if (next.getType().equals(type))
        filtered.add(next);
    }

    return filtered;
  }

}
