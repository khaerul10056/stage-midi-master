package org.mda.editor.preview.ui.details;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.jface.viewers.ColumnLabelProvider;


public class EnumLabelProvider extends ColumnLabelProvider {

  @Override
  public String getText (Object element) {
    if (element instanceof Enumerator) {
      Enumerator enumerator = (Enumerator) element;
      return enumerator.getName();
    }

    return null;
  }


}
