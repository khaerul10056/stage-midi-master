package org.mda.additionals;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import mda.AdditionalType;
import org.mda.Utils;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;


public class AdditionalsHandler {

  private static final Log LOGGER  = LogFactory.getLogger(AdditionalsHandler.class);

  private List <Additional> additionals;

  private final File additionalsPath;

  public AdditionalsHandler (final File additionalsPath) {
    this.additionalsPath = additionalsPath;
    initialize();
  }

  /**
   *
   * @param importFiles
   * @return ErrorString, if not error occured, this is an empty string
   */
  public String importFiles (Collection <File> importFiles) {

    StringBuilder builder = new StringBuilder();
    for (File next: importFiles) {
      try {
        AdditionalSuffix suffix = getSuffix(next);

      String name = getName(next);

      if (suffix == null) {
        builder.append("Could not import file " + next.getAbsolutePath() + " due to unvalid suffix\n");
        continue;
      }

      AdditionalType type = AdditionalTypeRegistry.getType(suffix);

      if (type == null) {
        builder.append("Could not import file " + next.getAbsolutePath() + " because suffix " + suffix + " can not be assigned to a type\n");
        continue;
      }

      File importedFile = new File (additionalsPath.getAbsolutePath() + File.separator + type.name().toLowerCase(), name + "." + suffix.name().toLowerCase());
      LOGGER.info("Imported file " + next.getAbsolutePath() + " to " + importedFile.getAbsolutePath());

      Utils.copyFile(importedFile, next);


      Additional additional = new Additional(importedFile, type, name, suffix);
      getAdditionals().add(additional);
      } catch (IllegalArgumentException e) {
        builder.append("Could not import file " + next.getAbsolutePath() + " due to unvalid suffix\n");
        continue;
      }
    }

    return builder.toString();
  }

  private String getName (final File next) {
    int suffixPos = next.getName().lastIndexOf(".");
    String name = suffixPos < 0 ? next.getName() : next.getName().substring(0, suffixPos);
    return name;
  }

  private AdditionalSuffix getSuffix (final File next) {
    int suffixPos = next.getName().lastIndexOf(".");
    String suffix = suffixPos < 0 ? null : next.getName().substring(suffixPos + 1, next.getName().length());
    if (suffix == null)
      return null;
    else
      return AdditionalSuffix.valueOf(suffix.toUpperCase());
  }

  public void read () {

    if (additionals == null)
      additionals = new ArrayList<Additional>();

    for (AdditionalType nextType: AdditionalType.VALUES) {
      File nextTypePath = new File (additionalsPath.getAbsolutePath(), nextType.toString().toLowerCase());
      for (File next: nextTypePath.listFiles()) {
        Additional additional = new Additional(next, nextType, getName(next), getSuffix(next));
        getAdditionals().add(additional);
      }
    }
  }

  private void checkRead () {
    if (additionals == null)
      throw new IllegalStateException("Additions for " + additionalsPath.getAbsolutePath() + " were not read yet. Please call read()-method before working with additionals");
  }

  public void remove (final Additional additional) {
    checkRead();
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
    checkRead();
    return additionals;
  }

  public List <Additional> getAdditionals (AdditionalType type) {
    checkRead();
    List <Additional> filtered = new ArrayList<Additional>();
    for (Additional next: additionals) {
      if (next.getType().equals(type))
        filtered.add(next);
    }

    return filtered;
  }

}
