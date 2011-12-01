package org.mda.export;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import mda.MidiFile;
import mda.MidiFileChordPart;
import mda.MidiFilePart;
import mda.MidiFileTextLine;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * exports a list of songs to pdf files
 * @author oleym
 *
 */
public class PDFExporter {

	private File exportPath;

	public PDFExporter () {

	}


	public void setExportPath (final File path) {
		this.exportPath = path;
	}


//	private Font getFont (final int size, boolean bold) throws DocumentException, IOException {
//		Font font = new Font(DocumentFont.createFont());
//		font.setSize(size);
//		if (bold)
//		  font.setStyle(Font.BOLD);
//
//		return font;
//	}

	public void exportMidifile (final MidiFile midifiles) {
		try {
			if (exportPath == null)
				throw new IllegalStateException("Exportpath not set");

			File file = new File(exportPath.getAbsolutePath() + "/" + midifiles.getName() + ".pdf");
			if (!file.getParentFile().exists())
				file.getParentFile().mkdirs();

			FileOutputStream fileout = new FileOutputStream(file);
			Document document = new Document();
			PdfWriter writer = PdfWriter.getInstance(document, fileout);
			document.addTitle("created by itext");

			document.open();
			System.out.println ("DocumentSize: " + document.getPageSize().getWidth() + "x" + document.getPageSize().getHeight());
			System.out.println ("Left border: " + document.getPageSize().getBorderWidthLeft() + "\n" +
					"Upper border: " + document.getPageSize().getBorderWidthRight() + "\n" +
					"Right border: " + document.getPageSize().getBorderWidthTop() + "\n" +
					"Lower border: " + document.getPageSize().getBorderWidthBottom() + "\n" +
					"Generic : " + document.getPageSize().getBorderWidth());

			PdfContentByte cb = writer.getDirectContent();
			cb.beginText();
			BaseFont font = BaseFont.createFont();
			font.setPostscriptFontName(BaseFont.HELVETICA_BOLD);
			cb.setFontAndSize(font, 20f);

			cb.showTextAligned(PdfContentByte.ALIGN_CENTER, midifiles.getName().toUpperCase().replace(".MID", ""), document.getPageSize().getWidth() / 2, 800,0);

			cb.endText();


			cb = writer.getDirectContent();
			cb.beginText();
			font.setPostscriptFontName(BaseFont.HELVETICA);
			cb.setFontAndSize(font, 12f);

			float verticalPos = 750;

			for (MidiFilePart nextPart: midifiles.getParts()) {
				if (nextPart.getRefPart() != null)
					nextPart = nextPart.getRefPart();

				for (int currentLine = 0; currentLine < nextPart.getTextlines().size(); currentLine ++) {
					MidiFileTextLine line = nextPart.getTextlines().get(currentLine);

					if (currentLine == 0) {
 					 cb.setColorFill(new BaseColor(Color.GRAY));
				     cb.showTextAligned(PdfContentByte.ALIGN_LEFT, nextPart.getParttype().toString(), 10, verticalPos, 0);
				     cb.setColorFill(new BaseColor(Color.BLACK));
					}

					float horizontalPos = 110;

					for (MidiFileChordPart nextChordPart: line.getChordParts()) {
						if (nextChordPart.getText() != null) {
							float effecticeStringWidth = cb.getEffectiveStringWidth(nextChordPart.getText(), true);
							cb.showTextAligned(PdfContentByte.ALIGN_LEFT, nextChordPart.getText(), horizontalPos, verticalPos, 0);
							horizontalPos += effecticeStringWidth;
						}
					}

				    verticalPos -= 15;
				}

				verticalPos -= 15;

			}

			cb.endText();


			document.close();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
