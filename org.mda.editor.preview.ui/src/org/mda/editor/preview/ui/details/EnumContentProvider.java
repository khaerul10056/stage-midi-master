package org.mda.editor.preview.ui.details;

import java.util.List;

import org.eclipse.jface.viewers.ArrayContentProvider;


public class EnumContentProvider extends ArrayContentProvider {
  

  @Override
  public Object[] getElements (Object parentElement) {

    if (parentElement instanceof List)
      return ((List) parentElement).toArray();

    return null;

  }


}
