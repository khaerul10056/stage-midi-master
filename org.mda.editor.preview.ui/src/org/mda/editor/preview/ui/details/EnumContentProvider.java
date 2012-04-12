package org.mda.editor.preview.ui.details;

import java.util.List;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.Viewer;


public class EnumContentProvider extends ArrayContentProvider {





  @Override
  public void dispose () {
  }

  @Override
  public void inputChanged (Viewer viewer, Object oldInput, Object newInput) {
    // TODO Auto-generated method stub

  }

  @Override
  public Object[] getElements (Object parentElement) {

    if (parentElement instanceof List)
      return ((List) parentElement).toArray();

    return null;

  }


}
