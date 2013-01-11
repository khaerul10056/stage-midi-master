package org.mda.commons.ui.calculator;

/**
 * @deprecated use class in org.mda.presenter
 * @author oleym
 *
 */
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

  @Override
  public int hashCode () {
    final int prime = 31;
    int result = 1;
    result = prime *
      result + (bold ? 1231 : 1237);
    result = prime *
      result + ((fontsize == null) ? 0 : fontsize.hashCode());
    return result;
  }

  @Override
  public boolean equals (Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    FontDescriptor other = (FontDescriptor) obj;
    if (bold != other.bold)
      return false;
    if (fontsize == null) {
      if (other.fontsize != null)
        return false;
    }
    else if (!fontsize.equals(other.fontsize))
      return false;
    return true;
  }



}
