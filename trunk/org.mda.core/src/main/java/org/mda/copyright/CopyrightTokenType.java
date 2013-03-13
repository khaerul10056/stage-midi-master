/**
 *
 */
package org.mda.copyright;


/**
 * @author oleym
 *
 */
public enum CopyrightTokenType {


  NAME ("<N>", true),
  ORIGINALTITLE ("<OT>", "Originaltitel", true),
  PUBLISHER ("<P>", true),
  PUBLISHER_INLAND ("<PI>", "Für D,A,CH", true),
  WRITER_INLAND_TEXT ("<WIT>", "Dt. Text", true),
  WRITER_MUSIC ("<WM>", "Melodie", true),
  WRITER_TEXT ("<WT>", "Text", true),
  YEAR ("<Y>", "(c) ", false);

  private final String id;

  private final String label;
  private final String postfix;
  private final boolean divider;

  private CopyrightTokenType (final String id, final boolean divider) {
    this (id, "", "", divider);
  }

  private CopyrightTokenType (final String id, final String label, final boolean divider) {
    this (id, label, "", divider);
  }

  private CopyrightTokenType (final String id, final String label, final String postfix, final boolean divider) {
    this.id = id;
    this.label = label;
    this.postfix = postfix;
    this.divider = divider;
  }

  public String getDivider () {
    if (getLabel().isEmpty() || !divider)
      return "";
    else
      return (": ");
  }

  public String getId () {
    return id;
  }

  public String getLabel () {
    return label;
  }

  public String getPostfix () {
    return postfix;
  }


}
