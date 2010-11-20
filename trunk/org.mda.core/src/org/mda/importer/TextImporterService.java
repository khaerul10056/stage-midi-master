package org.mda.importer;

import java.util.ArrayList;
import java.util.List;

import mda.MidiFile;
import mda.MidiFileChordPart;
import mda.MidiFilePart;
import mda.MidiFileTextLine;

import org.mda.MidiPlayerService;

public class TextImporterService {
  private List<TextImporterLine> lines = new ArrayList<TextImporterLine>();

  public TextImporterService(final List<String> text, final TextImporterConfigIF config) {
    TextImporterLine prevLine = null;
    for (String nextText : text) {
      TextImporterLine importedLine = new TextImporterLine(config, nextText, prevLine);
      lines.add(importedLine);
      prevLine = importedLine;
    }
  }

  public void importText(MidiFile midifile) {

    MidiFilePart currentMidifilePart = null;

    for (TextImporterLine nextLine : lines) {
      if (nextLine.getPartType() != null) {

        if (currentMidifilePart != null) {
          midifile.getParts().add(currentMidifilePart);
          System.out.println("Add part " + currentMidifilePart.getParttype());
        }

        if (nextLine.getPartType() != null) {
          currentMidifilePart = MidiPlayerService.mf.createMidiFilePart();
          currentMidifilePart.setParttype(nextLine.getPartType());
          System.out.println("Create part " + nextLine.getPartType());
        }
      }

      if (currentMidifilePart != null && !nextLine.isChordLine()) {
        MidiFileTextLine nextTextLine = MidiPlayerService.mf.createMidiFileTextLine();
        currentMidifilePart.getTextlines().add(nextTextLine);
        System.out.println("addLine " + nextTextLine.toString());
        for (MidiFileChordPart nextChordPart : nextLine.getChordParts()) {
          System.out.println("addPart " + nextChordPart.getText());
          nextTextLine.getChordParts().add(nextChordPart);
        }
      }

    }

    if (currentMidifilePart != null) {
      midifile.getParts().add(currentMidifilePart);
      currentMidifilePart = null;
    }

  }

}
