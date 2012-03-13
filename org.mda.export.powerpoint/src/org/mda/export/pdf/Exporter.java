package org.mda.export.pdf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import mda.AbstractSessionItem;
import mda.MidiFile;
import mda.MidiFilePart;
import org.mda.MidiPlayerService;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;


public class Exporter {

  public void export (final Collection<AbstractSessionItem> items, final File exportFile) throws IOException, DocumentException {
    if (! exportFile.getAbsoluteFile().getParentFile().exists())
      exportFile.getParentFile().mkdirs();

    Document document = new Document(PageSize.A4);
    PdfWriter.getInstance(document, new FileOutputStream(exportFile));
    document.open();

    for (AbstractSessionItem next: items) {
      export(document, (MidiFile) next);
    }

    document.close();
  }

  private void addEmptyCells (final PdfPTable table, final int number, final float minimumheight) {
    for (int i = 0; i < number; i++) {
      PdfPCell empty = new PdfPCell();
      empty.setBorder(PdfPCell.NO_BORDER);
      if (minimumheight > 0)
        empty.setMinimumHeight(minimumheight);
      table.addCell(empty);
    }
  }

  private void export (final Document doc, final MidiFile nextItem) throws DocumentException {

    doc.newPage();

    Font header = new Font(Font.HELVETICA, 24, Font.BOLD | Font.UNDERLINE);


    Font normal = new Font(Font.HELVETICA, 14, Font.NORMAL);
    Font bold = new Font(Font.HELVETICA, 14, Font.BOLD);
    doc.add(new Phrase (new Chunk(nextItem.getName().toUpperCase().replace(".MID", ""), header)));
    doc.add(Chunk.NEWLINE);

    PdfPTable table = new PdfPTable(2);
    table.setHorizontalAlignment(PdfPTable.ALIGN_LEFT);
    table.setWidths(new float [] {1, 3});
    table.setWidthPercentage(100);

    for (MidiFilePart nextPart: nextItem.getParts()) {
        PdfPCell cell = new PdfPCell(new Phrase (nextPart.getParttype().getName(), bold));
        cell.setBorder(PdfPCell.NO_BORDER);
        table.addCell(cell);

        List<String> rawText = MidiPlayerService.getRawText(nextPart, false);
        for (int i = 0; i < rawText.size(); i++) {
          PdfPCell cell1 = new PdfPCell(new Phrase (rawText.get(i), normal));
          cell1.setBorder(PdfPCell.NO_BORDER);
          table.addCell(cell1);

          if (i < rawText.size() - 1)
            addEmptyCells(table, 1, -1);
        }


        addEmptyCells(table, 2, 10);


    }

    doc.add(table);

  }

}
