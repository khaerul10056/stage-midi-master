package org.mda.presenter.adapter;

public class Font {
	
  private String fontname;

  private Integer fontsize;
  
  private boolean bold;
  
  public Font(String name, final Integer fontsize) {
	  this.fontname = name;
	  this.fontsize = fontsize;
  }

  public Font (final Font desc) {
    this.setFontsize(desc.getFontsize());
    this.setBold(desc.isBold());
  }

  public Font (final Integer fontsize) {
    this.setFontsize(fontsize);
    this.setBold(false);
  }

  public Font (final Integer fontsize, final boolean bold) {
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
    Font other = (Font) obj;
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

public String getFontname() {
	return fontname;
}

public void setFontname(String fontname) {
	this.fontname = fontname;
}



}