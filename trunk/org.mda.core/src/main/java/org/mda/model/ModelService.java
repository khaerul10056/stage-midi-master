package org.mda.model;

import java.util.ArrayList;
import java.util.Collection;

import mda.AbstractSessionItem;
import mda.MidiPlayerRoot;
import mda.Session;

public class ModelService {
	
	/**
	   * removes a sessionitem itself and all references in any session, if it is referenced
	   * @param rootobject   rootobject
	   * @param sessionitem  sessionitem to be removed
	   */
	  public void removeSongAndReferences (final MidiPlayerRoot rootobject, final AbstractSessionItem sessionitem) {

	    for (Session session: rootobject.getSessions()) {

	      Collection<AbstractSessionItem> deleted = new ArrayList<AbstractSessionItem>();

	      for (AbstractSessionItem nextSessionitem : session.getItems()) {
	        if (sessionitem == nextSessionitem)
	          deleted.add(nextSessionitem);
	      }

	      session.getItems().removeAll(deleted);
	    }

	    rootobject.getGallery().getGalleryItems().remove(sessionitem);
	  }

}
