package org.mda.navigator.ui;

import mda.AbstractSessionItem;
import mda.Session;


public class SelectionInfo {

  private final Session session;
  private final AbstractSessionItem item;

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

}
