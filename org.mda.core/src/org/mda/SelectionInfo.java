package org.mda;

import mda.AbstractSessionItem;
import mda.Session;


public class SelectionInfo {

  private final Session session;
  private final AbstractSessionItem item;
  private boolean preview;

  public SelectionInfo (Session session, AbstractSessionItem item) {
    this.session = session;
    this.item = item;
  }

  public AbstractSessionItem getItem () {
    return item;
  }

  public Session getSession () {
    return session;
  }

  public boolean isPreview () {
    return preview;
  }

  public void setPreview (boolean preview) {
    this.preview = preview;
  }

}
