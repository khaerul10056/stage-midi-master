package org.mda.commons.ui.additionals;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.mda.additionals.Additional;


public class AdditionalLabelProvider implements ILabelProvider {


  @Override
  public void addListener (ILabelProviderListener listener) {
    // TODO Auto-generated method stub

  }

  @Override
  public void dispose () {
    // TODO Auto-generated method stub

  }

  @Override
  public boolean isLabelProperty (Object element, String property) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void removeListener (ILabelProviderListener listener) {
    // TODO Auto-generated method stub

  }

  @Override
  public Image getImage (Object element) {
    return null;
  }

  @Override
  public String getText (Object element) {
    if (element instanceof Additional) {
      Additional additional = (Additional) element;
      return additional.getName();
    }

    return null;
  }

}
