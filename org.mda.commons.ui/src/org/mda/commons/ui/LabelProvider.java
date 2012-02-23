package org.mda.commons.ui;

import static org.mda.Utils.*;
import java.util.logging.Logger;
import mda.AbstractSessionItem;
import mda.Gallery;
import mda.MidiFile;
import mda.MidiPlayerRoot;
import mda.Session;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.mda.commons.ui.navigator.NavigatorItem;


public class LabelProvider implements ILabelProvider {

  private static final Logger LOGGER = Logger.getLogger(LabelProvider.class.getName());

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

    if (element instanceof NavigatorItem)
      element = ((NavigatorItem) element).getModelElement();

    if (element instanceof MidiFile) {
      return loadImageFromProject(ICON_SONG);
    }

    if (element instanceof Session) {
      return loadImageFromProject(ICON_SESSION);
    }

    return null;
  }

  @Override
  public String getText (Object element) {
    if (element instanceof NavigatorItem)
      element = ((NavigatorItem) element).getModelElement();

    if (element instanceof String)
      return element.toString();

    if (element instanceof MidiPlayerRoot) {
      MidiPlayerRoot root = (MidiPlayerRoot) element;
      String completeURI = root.eResource().getURI().toFileString();
      String lastURIFragment = root.eResource().getURI().lastSegment();
      return lastURIFragment + "(" + completeURI + ")";
    }

    if (element instanceof SessionGroup)
      return "Sessions";

    if (element instanceof Gallery)
      return "Gallery";

    if (element instanceof AbstractSessionItem) {
      return ((AbstractSessionItem) element).getName().replaceAll(".mid", "");
    }

    if (element instanceof Session) {
      return ((Session) element).getName();
    }
    return null;
  }

}
