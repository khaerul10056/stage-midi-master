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


  public Additional findByKey (final String key) {
    LOGGER.info("Find additional by key " + key);
    String [] keyArray = key.split("#");
    if (keyArray.length != 3)
      return null;

    AdditionalType typeFound = AdditionalType.valueOf(keyArray [0].toUpperCase());
    String name = keyArray [1];
    AdditionalSuffix suffixFound = AdditionalSuffix.valueOf(keyArray [2].toUpperCase());

    Additional compareAdditional = new Additional(null, typeFound, name, suffixFound);

    for (Additional additional : additionals) {
      if (additional.equals(compareAdditional))
          return additional;
    }

    return null;
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
    else {
      try {
      AdditionalSuffix addsuffix = AdditionalSuffix.valueOf(suffix.toUpperCase());
      return addsuffix;

      } catch (Exception e) {
        return null;
      }
    }
  }

  public void read () {

    if (additionals == null)
      additionals = new ArrayList<Additional>();

    for (AdditionalType nextType: AdditionalType.VALUES) {
      File nextTypePath = new File (additionalsPath.getAbsolutePath(), nextType.toString().toLowerCase());
      for (File next: nextTypePath.listFiles()) {
        AdditionalSuffix suffix = getSuffix(next);
        if (suffix != null) {
        Additional additional = new Additional(next, nextType, getName(next), suffix);
        if (additional != null)
          getAdditionals().add(additional);
        }
        else
          LOGGER.warn("File " + next.getAbsolutePath() + " has no valid suffix, ignoring");
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
