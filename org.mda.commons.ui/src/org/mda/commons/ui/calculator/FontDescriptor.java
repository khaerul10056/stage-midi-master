package org.mda.commons.ui.calculator;


public class FontDescriptor {

  private Integer fontsize;

  private boolean bold;

  public FontDescriptor (final FontDescriptor desc) {
    this.setFontsize(desc.getFontsize());
    this.setBold(desc.isBold());
  }

  public FontDescriptor (final Integer fontsize) {
    this.setFontsize(fontsize);
    this.setBold(false);
  }

  public FontDescriptor (final Integer fontsize, final boolean bold) {
    this.setFontsize(fontsize);
    this.setBold(bold);
  }

  public boolean isBold () {
    return bold;
  }

  public Integer getFontsize () {
    return fontsize;
  }

  public int getFontsizeAsInt () {
    return getFontsize().intValue();
  }

  public void setFontsize (Integer fontsize) {
    this.fontsize = fontsize;
  }

  public void setBold (boolean bold) {
    this.bold = bold;
  }

}
