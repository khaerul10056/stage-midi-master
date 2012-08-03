package org.mda.commons.ui;

import mda.MidiPlayerRoot;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;


public class SessionsContentProvider implements ITreeContentProvider {


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

    if (parentElement instanceof MidiPlayerRoot) {
      MidiPlayerRoot root = (MidiPlayerRoot) parentElement;
      return root.getSessions().toArray();
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
    return element instanceof MidiPlayerRoot;
  }

}
