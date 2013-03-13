package org.mda.additionals;

import java.util.HashSet;
import mda.AdditionalType;


public class AdditionalTypeRegistry {

  public static HashSet<AdditionalInfo> typesPerSuffix = new HashSet<AdditionalInfo>();

  static {
    typesPerSuffix.add(new AdditionalInfo(AdditionalSuffix.PNG, null, AdditionalType.IMAGE));
    typesPerSuffix.add(new AdditionalInfo(AdditionalSuffix.JPG, null, AdditionalType.IMAGE));

    typesPerSuffix.add(new AdditionalInfo(AdditionalSuffix.MID, null, AdditionalType.MIDIFILE));

    typesPerSuffix.add(new AdditionalInfo(AdditionalSuffix.MP3, null, AdditionalType.AUDIO));
    typesPerSuffix.add(new AdditionalInfo(AdditionalSuffix.WAV, null, AdditionalType.AUDIO));

    typesPerSuffix.add(new AdditionalInfo(AdditionalSuffix.MP4, null, AdditionalType.VIDEO));
    typesPerSuffix.add(new AdditionalInfo(AdditionalSuffix.AVI, null, AdditionalType.VIDEO));
  }

  public static AdditionalType getType (final AdditionalSuffix suffix) {
    AdditionalInfo info = getInfo(suffix);
    return info != null ? info.getType() : null;
  }


  public static AdditionalInfo getInfo (final AdditionalSuffix suffix) {
    for (AdditionalInfo info: typesPerSuffix) {
      if (info.getSuffix().equals(suffix))
        return info;
    }



    return null;
  }

}
