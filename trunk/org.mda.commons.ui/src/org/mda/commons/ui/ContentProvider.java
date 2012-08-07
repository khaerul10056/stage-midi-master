package org.mda.commons.ui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import mda.AbstractSessionItem;
import mda.Gallery;
import mda.MidiPlayerRoot;
import mda.Session;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.mda.ApplicationSession;
import org.mda.MidiPlayerService;
import org.mda.commons.ui.navigator.NavigatorItem;


public class ContentProvider implements ITreeContentProvider {


    @Override
  public void dispose () {
    // TODO Auto-generated method stub

  }

  @Override
  public void inputChanged (Viewer viewer, Object oldInput, Object newInput) {
    // TODO Auto-generated method stub

  }

  @Override
  public Object[] getElements (Object parentElement) {
	  
	if (parentElement instanceof List)
		return ((List) parentElement).toArray();

    if (parentElement instanceof ApplicationSession) {
      ApplicationSession session = (ApplicationSession) parentElement;
      if (session.getCurrentModel() != null)
        return new Object [] {session.getCurrentModel()};
      else
        return new String [] {"No model loaded"};
    }

    if (parentElement instanceof MidiPlayerRoot) {
      MidiPlayerRoot root = (MidiPlayerRoot) parentElement;
      return new Object [] {root.getGallery()};
    }

    if (parentElement instanceof Gallery) {
      Gallery group = (Gallery) parentElement;

      List <AbstractSessionItem> sortedGalleryItems = MidiPlayerService.sortedSessionItemList(group.getGalleryItems());

      List <NavigatorItem<AbstractSessionItem>> songs = new ArrayList<NavigatorItem<AbstractSessionItem>>();
      for (AbstractSessionItem next: sortedGalleryItems) {
        songs.add(new NavigatorItem<AbstractSessionItem>(next, group.getGalleryItems(), group));
      }

      return songs.toArray();
    }

    if (parentElement instanceof Session) {
      Session session = (Session) parentElement;
      Collection <NavigatorItem<?>> songs = new ArrayList<NavigatorItem<?>>();
      for (AbstractSessionItem next: session.getItems()) {
        songs.add(new NavigatorItem<AbstractSessionItem>(next, session.getItems(), session));
      }
      return songs.toArray();
    }

    return null;

  }

  @Override
  public Object[] getChildren (Object parentElement) {
    return getElements(parentElement);
  }

  @Override
  public Object getParent (Object element) {
    return null;
  }

  @Override
  public boolean hasChildren (Object element) {
    return element instanceof MidiPlayerRoot || element instanceof Gallery || element instanceof Session;
  }

}
