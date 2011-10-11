package org.mda.commons.ui.navigator;

import mda.AbstractSessionItem;
import mda.MidiPlayerRoot;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;


public class LabelProvider implements ILabelProvider {

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
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getText (Object element) {

    if (element instanceof NavigatorRoot)
      return "Root";

    if (element instanceof MidiPlayerRoot) {
      return ((MidiPlayerRoot) element).eResource().getURI().toFileString();
    }

    if (element instanceof AbstractSessionItem) {
      return ((AbstractSessionItem) element).getName();
    }
    return null;
  }

}
