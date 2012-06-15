package org.mda.copyright;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import mda.Copyright;
import mda.MidiFile;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;


public class CopyrightSerializer {

  private static final Log LOGGER  = LogFactory.getLogger(CopyrightSerializer.class);

  private String template = CopyrightTokenType.NAME.getId() + " " + CopyrightTokenType.ORIGINALTITLE.getId() + " " +
                            CopyrightTokenType.WRITER_TEXT.getId() + " " + CopyrightTokenType.WRITER_MUSIC.getId() + "\n" +
                            CopyrightTokenType.WRITER_INLAND_TEXT.getId() + " " + CopyrightTokenType.YEAR.getId() + " " + CopyrightTokenType.PUBLISHER.getId() + " " +
                            CopyrightTokenType.PUBLISHER_INLAND.getId() + " genehmigtes Exemplar";


  private boolean isNullOrEmpty (final String field) {
    return field == null || field.trim().isEmpty();
  }

  private boolean isCopyrightEmpty (final Copyright copyright) {
    if (copyright == null)
      return true;

    if (! isNullOrEmpty(copyright.getOriginaltitle()))
      return false;

    if (! isNullOrEmpty(copyright.getPublisher()))
      return false;

    if (! isNullOrEmpty(copyright.getPublisherInland()))
      return false;

    if (! isNullOrEmpty(copyright.getWriterInlandText()))
      return false;

    if (! isNullOrEmpty(copyright.getWriterText()))
      return false;

    if (! isNullOrEmpty(copyright.getWriterMusic()))
      return false;

    if (copyright.getYear() > 0)
      return false;

    return true;
  }


  private String replaceToken (final String template, final CopyrightTokenType type, final String data) {
    if (!isNullOrEmpty(data)) {
      String completedToken = type.getLabel() + type.getDivider() + data + type.getPostfix() + ",";
      return template.replace(type.getId(), completedToken);
    }
    else
      return template.replace(type.getId(), "");
  }

  public Collection <String> serialize (final MidiFile midifile) {

    LOGGER.info("Serializing copyright using template <" + template + ">");

    String copiedTemplate = new String (template);

    Copyright copyright = midifile.getCopyright();

    if (isCopyrightEmpty(copyright))
      return Collections.emptyList();

    //Special case: WriterMusic == WriterText
    if (! isNullOrEmpty(copyright.getWriterMusic()) &&
        ! isNullOrEmpty(copyright.getWriterText()) &&
        copyright.getWriterMusic().trim().equals(copyright.getWriterText().trim())) {
      String pre = CopyrightTokenType.WRITER_MUSIC.getLabel() + " & " + CopyrightTokenType.WRITER_TEXT.getLabel() + ": " + copyright.getWriterMusic().trim();
      copiedTemplate = copiedTemplate.replace(CopyrightTokenType.WRITER_MUSIC.getId(), pre) ;
      copiedTemplate = copiedTemplate.replace(CopyrightTokenType.WRITER_TEXT.getId(), "");
    }

    copiedTemplate = replaceToken(copiedTemplate, CopyrightTokenType.NAME, midifile.getName());
    copiedTemplate = replaceToken(copiedTemplate, CopyrightTokenType.ORIGINALTITLE, copyright.getOriginaltitle());
    copiedTemplate = replaceToken(copiedTemplate, CopyrightTokenType.PUBLISHER, copyright.getPublisher());
    copiedTemplate = replaceToken(copiedTemplate, CopyrightTokenType.PUBLISHER_INLAND, copyright.getPublisherInland());
    copiedTemplate = replaceToken(copiedTemplate, CopyrightTokenType.WRITER_INLAND_TEXT, copyright.getWriterInlandText());
    copiedTemplate = replaceToken(copiedTemplate, CopyrightTokenType.WRITER_TEXT, copyright.getWriterText());
    copiedTemplate = replaceToken(copiedTemplate, CopyrightTokenType.WRITER_MUSIC, copyright.getWriterMusic());
    if (copyright.getYear() > 0)
      copiedTemplate = replaceToken(copiedTemplate, CopyrightTokenType.YEAR, String.valueOf(copyright.getYear()));

    String[] split = copiedTemplate.split("\n");
    Collection <String> strings = Arrays.asList(split);

    for (String next: strings) {
      LOGGER.info("Copyright:  <" + next + ">");
    }

    return strings;

  }

}
