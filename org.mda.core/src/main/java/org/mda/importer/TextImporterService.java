package org.mda.importer;

import java.util.ArrayList;
import java.util.List;
import mda.Song;
import mda.SongChordPart;
import mda.SongPart;
import mda.SongTextLine;
import org.mda.MidiPlayerService;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;

public class TextImporterService {

  private static final Log LOGGER  = LogFactory.getLogger(TextImporterService.class);

  private List<TextImporterLine> lines = new ArrayList<TextImporterLine>();

  public TextImporterService(final List<String> text, final TextImporterConfigIF config) {
    TextImporterLine prevLine = null;
    for (String nextText : text) {
      TextImporterLine importedLine = new TextImporterLine(config, nextText, prevLine);
      lines.add(importedLine);
      prevLine = importedLine;
    }
  }

  public void importText(Song midifile) {

    SongPart currentSongPart = null;

    for (TextImporterLine nextLine : lines) {
      if (nextLine.getPartType() != null) {

        if (currentSongPart != null) {
          midifile.getParts().add(currentSongPart);
          LOGGER.info("Add part " + currentSongPart.getParttype());
        }

        if (nextLine.getPartType() != null) {
          currentSongPart = MidiPlayerService.mf.createSongPart();
          currentSongPart.setParttype(nextLine.getPartType());
          LOGGER.info("Create part " + nextLine.getPartType());
        }
      }

      if (currentSongPart != null && !nextLine.isChordLine()) {
        SongTextLine nextTextLine = MidiPlayerService.mf.createSongTextLine();
        currentSongPart.getTextlines().add(nextTextLine);
        LOGGER.info("addLine " + nextTextLine.toString());
        for (SongChordPart nextChordPart : nextLine.getChordParts()) {
          LOGGER.info("addPart " + nextChordPart.getText());
          nextTextLine.getChordParts().add(nextChordPart);
        }
      }

    }

    if (currentSongPart != null) {
      midifile.getParts().add(currentSongPart);
      currentSongPart = null;
    }

  }

}
