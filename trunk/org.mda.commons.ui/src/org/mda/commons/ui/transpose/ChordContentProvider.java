package org.mda.commons.ui.transpose;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.mda.transpose.Scale;


public class ChordContentProvider extends ArrayContentProvider {

  @Override
  public void dispose () {
  }

  @Override
  public void inputChanged (Viewer viewer, Object oldInput, Object newInput) {
    // TODO Auto-generated method stub

  }

  @Override
  public Object[] getElements (Object parentElement) {

    if (parentElement instanceof Scale) {
      Scale scale = (Scale) parentElement;
      return scale.getSteps().toArray();
    }

    return null;

  }
}
