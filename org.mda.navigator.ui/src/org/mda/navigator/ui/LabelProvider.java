package org.mda.navigator.ui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mda.AbstractSessionItem;
import mda.MidiFile;
import mda.MidiPlayerRoot;
import mda.Session;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.mda.commons.ui.Activator;
import org.mda.commons.ui.Util;


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
    try {
    if (element instanceof MidiFile) {
      return Activator.loadImage(Display.getDefault(), Util.ICON_SONG).createImage();
    }

    if (element instanceof Session) {
      return Activator.loadImage(Display.getDefault(), Util.ICON_SESSION).createImage();
    }

    }
    catch (IOException e) {
      LOGGER.log (Level.SEVERE, e.getLocalizedMessage(), e);
    }
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getText (Object element) {

    if (element instanceof MidiPlayerRoot) {
      MidiPlayerRoot root = (MidiPlayerRoot) element;
      String completeURI = root.eResource().getURI().toFileString();
      String lastURIFragment = root.eResource().getURI().lastSegment();
      return lastURIFragment + "(" + completeURI + ")";
    }

    if (element instanceof SessionGroup)
      return "Sessions";

    if (element instanceof SongGroup)
      return "Songs";

    if (element instanceof AbstractSessionItem) {
      return ((AbstractSessionItem) element).getName().replaceAll(".mid", "");
    }

    if (element instanceof Session) {
      return ((Session) element).getName();
    }
    return null;
  }

}
