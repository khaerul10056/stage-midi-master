package org.mda.commons.ui.user;

import mda.MidiPlayerRoot;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.Viewer;


public class UserContentProvider extends ArrayContentProvider {





  @Override
  public void dispose () {
  }

  @Override
  public void inputChanged (Viewer viewer, Object oldInput, Object newInput) {
    // TODO Auto-generated method stub

  }

  @Override
  public Object[] getElements (Object parentElement) {

    if (parentElement instanceof MidiPlayerRoot) {
      MidiPlayerRoot root = (MidiPlayerRoot) parentElement;
      return root.getUsers().toArray();
    }

    return null;

  }




}