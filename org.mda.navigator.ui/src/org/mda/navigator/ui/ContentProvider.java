package org.mda.navigator.ui;

import mda.MidiPlayerRoot;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.mda.commons.ui.ApplicationSession;


public class ContentProvider implements ITreeContentProvider {


  public ContentProvider () {

  }

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

    if (parentElement instanceof ApplicationSession) {
      ApplicationSession session = (ApplicationSession) parentElement;
      return new Object [] {session.getCurrentModel()};
    }

    if (parentElement instanceof MidiPlayerRoot) {
      MidiPlayerRoot root = (MidiPlayerRoot) parentElement;
      return new Object [] {new SongGroup(root), new SessionGroup(root)};
    }

    if (parentElement instanceof SongGroup) {
      SongGroup group = (SongGroup) parentElement;
      return group.getRoot().getGallery().getGalleryItems().toArray();
    }

    if (parentElement instanceof SessionGroup) {
      SessionGroup session = (SessionGroup) parentElement;
      return session.getRoot().getSessions().toArray();
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
    return element instanceof MidiPlayerRoot || element instanceof SongGroup || element instanceof SessionGroup;
  }

}
