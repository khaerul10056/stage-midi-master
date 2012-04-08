package org.mda.commons.ui.transpose;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.mda.transpose.ScaleStep;


public class ChordLabelProvider extends ColumnLabelProvider {


  @Override
  public String getText (Object element) {
    if (element instanceof ScaleStep) {
      ScaleStep step = (ScaleStep) element;

      StringBuilder builder = new StringBuilder();

      builder.append(step.getNote1().getLabel());
      if (step.getNote2() != null)
        builder.append(" / " + step.getNote2().getLabel());
      return builder.toString();
    }

    return null;
  }

}
