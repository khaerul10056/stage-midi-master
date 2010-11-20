package org.mda.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import mda.MidiFilePart;
import mda.MidiPlayerRoot;

import org.mda.MidiFileContentEditorConfigIF;
import org.mda.MidiPlayer;
import org.mda.MidiPlayerService;

public class MidiFileContentShower extends JPanel {

  private MidiPlayerApplicationFrame application;
  private MidiFileContentEditorConfigIF config;
  private MidiPlayer midiplayer;
  private Image img;

  private String [] trenner = new String [] {",", ";", "\\.", "!", " "};

  private List<MidiFilePart> partsShown = new ArrayList<MidiFilePart>();
  private int y;
  private Graphics2D graphics2d;
  private PresentationFrame presentationFrame;

  public MidiFileContentShower (final MidiPlayerApplicationFrame application, PresentationFrame presentationFrame, final MidiPlayer midiplayer, MidiFileContentEditorConfigIF config) {
    this.application = application;
    this.presentationFrame = presentationFrame;
    this.midiplayer = midiplayer;
    this.config = config;
    setBackground(Color.BLACK);

    config.getFont();

  }


  private Graphics2D createGraphics(final Font font, final Graphics g) {
    Graphics2D g3 = (Graphics2D) g;
    g3.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
    g3.setColor(Color.WHITE);
    g3.setBackground(Color.BLACK);
    g3.setFont(font);
    return g3;
  }

  private List <String> getWrappedWithTrenner (final String text, final String trenner) {
    ArrayList <String> wrapped = new ArrayList<String>();
    String [] tokens = text.split(trenner);
    String nextLine = "";
    for (int i = 0; i < tokens.length; i++) {
      String nextToken = tokens [i];

      if (nextToken.trim().length() == 0)
        continue;

      String tmpLine = nextLine;

      tmpLine += nextToken;
      String completeTmpLen = tmpLine; //Line + Trenner getrimmt
      if (i < tokens.length - 1)
        completeTmpLen += trenner;

      double width = getWidth(completeTmpLen, config.getFont());
      System.out.println ("Text <" + completeTmpLen + "> braucht " + width + " Pixel");
      if (width > getWidth() - (2 * getIndention())) {
        if (nextLine.length() == 0) //first token is wide
          return null;
        else {
          wrapped.add(nextLine);
          nextLine = nextToken;
          if (i < tokens.length - 1)
            nextLine += trenner;
        }
      }
      else
        nextLine = completeTmpLen ;

    }

    if (nextLine.length() > 0)
      wrapped.add(nextLine.trim());

    System.out.println ("- " + text);
    for (String wraps: wrapped) {
      System.out.println ("+                        " + wraps + "\n");
    }

    return wrapped;

  }

  private List <String> getWrapped (final String text) {
    for (String nextTrenner: trenner) {

      List <String> wrapped = getWrappedWithTrenner(text, nextTrenner);
      if (wrapped != null) {
        return wrapped;
      }
    }

    throw new IllegalStateException("Error wraping text " + text);
  }

  private double getWidth (final String text, Font font) {
    FontMetrics fm = getFontMetrics(font);
    Rectangle2D lineMetrics = fm.getStringBounds(text, graphics2d);
    return lineMetrics.getWidth();
  }

  public void paint(Graphics g) {
	  super.paint(g);
	  Font font = config.getFont();
	  graphics2d = createGraphics(font, g);

	  // Draws the img to the BackgroundPanel.
    if (img != null) {
    	graphics2d.drawImage(img, 0, 0, this);
    }

		FontMetrics fm = getFontMetrics(graphics2d.getFont());
		y = fm.getHeight() + getIndention();

		for (MidiFilePart nextPart : partsShown) {
			List<String> text = MidiPlayerService.getRawText(nextPart);

			for (String nextLine : text) {

				List<String> wrappedLines = getWrapped(nextLine);
				for (String nextWrapped : wrappedLines) {
					drawNextLine(nextWrapped, fm, graphics2d);
				}
			}
		}
  }




private void drawNextLine (final String nextString, FontMetrics fm, Graphics2D createGraphics) {
	createGraphics.drawString(nextString, getIndention(), y);
    double width = getWidth(nextString, fm.getFont());
    if (width > (getWidth() - ( 2 * getIndention()))) {
      System.out.println ("Error: Text <" + nextString + "> braucht " + width + " Pixel");
    }

    y += fm.getHeight() + getIndention();
  }

  private int getIndention () {
    return 20;
  }

  public void setCurrentBar(int i) {
    if (i < 0)
      partsShown = new ArrayList<MidiFilePart>();

    if (midiplayer.getCurrentMidifile().getPic() != null && presentationFrame != null)
      img = presentationFrame.getImages().get(midiplayer.getCurrentMidifile().getPic());
    else
      img = null;

    List <MidiFilePart> parts = MidiPlayerService.getCurrentParts(midiplayer.getCurrentMidifile(), i, config);
    if (MidiPlayerService.changed(parts, partsShown)) {
      partsShown = parts;
      invalidate();
      validate();
    }
  }


}
