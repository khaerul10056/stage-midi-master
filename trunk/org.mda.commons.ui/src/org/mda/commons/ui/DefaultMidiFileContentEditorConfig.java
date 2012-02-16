package org.mda.commons.ui;

import java.util.ArrayList;
import java.util.List;
import mda.MidiFilePartType;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.mda.ApplicationSession;

public class DefaultMidiFileContentEditorConfig implements IMidiFileEditorUIConfig {

  private boolean                chordVisible    = true;

  private boolean                editable        = true;

  private Color                  backgroundColor = Display.getDefault().getSystemColor(SWT.COLOR_BLACK);

  private Color                  foregroundColor = Display.getDefault().getSystemColor(SWT.COLOR_WHITE);

  private List<MidiFilePartType> partsToIgnore   = new ArrayList<MidiFilePartType>();

  private Font                   font;

  private Integer fontsize;


  private ApplicationSession session = ApplicationSession.getInjector().getInstance(ApplicationSession.class);

  public Integer getFontsize () {
    if (fontsize != null)
      return fontsize.intValue();

    if (session != null && session.getCurrentModel() != null && session.getCurrentModel().getConfig() != null && session.getCurrentModel().getConfig().getFontsize() != null)
      return session.getCurrentModel().getConfig().getFontsize().intValue();

    return 40;
  }

  public void setFontsize (Integer fontsize) {
    this.fontsize = fontsize;
  }


  @Override
  public boolean isChordPresented () {
    return chordVisible;
  }

  public void setChordVisible (boolean chordVisible) {
    this.chordVisible = chordVisible;
  }

  public void setEditable (boolean editable) {
    this.editable = editable;
  }

  public boolean isEditable () {
    return editable;
  }

  public void setBackgroundColor (Color black) {
    this.backgroundColor = black;
  }

  public Color getBackgroundColor () {
    return backgroundColor;
  }

  public void setForegroundColor (Color white) {
    this.foregroundColor = white;
  }

  public Color getForegroundColor () {
    return foregroundColor;
  }

  public void addIgnoredPartType (MidiFilePartType solo) {
    partsToIgnore.add(solo);
  }

  public boolean isPartIgnored (final MidiFilePartType parttype) {
    return partsToIgnore.contains(parttype);
  }

  public Font getFont () {
    return font;
  }

  public void setFont (Font font) {
    this.font = font;
  }

  @Override
  public Point getDefaultPresentationScreenSize () {
    return new Point (1280, 800);  //TODO mechanism for size
    //Rectangle bounds = Display.getCurrent().getMonitors()[0].getBounds();
    //return new Point(bounds.width, bounds.height);
  }

}
