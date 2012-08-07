package org.mda.commons.ui;

import static org.mda.Utils.ICON_SESSION;
import static org.mda.Utils.ICON_SONG;
import static org.mda.Utils.loadImageFromProject;
import mda.AbstractSessionItem;
import mda.MidiFile;
import mda.MidiPlayerRoot;
import mda.Session;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.mda.find.SearchResult;


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
	  
	if (element instanceof SearchResult) {
		SearchResult result = (SearchResult) element;
		element = result.getEobject();
	}
		 
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
	  if (element instanceof SearchResult) {
			SearchResult result = (SearchResult) element;
			element = result.getEobject();
		}
	  
    if (element instanceof String)
      return element.toString();

    if (element instanceof MidiPlayerRoot) {
      MidiPlayerRoot root = (MidiPlayerRoot) element;
      String completeURI = root.eResource().getURI().toFileString();
      String lastURIFragment = root.eResource().getURI().lastSegment();
      return lastURIFragment + "(" + completeURI + ")";
    }

    if (element instanceof AbstractSessionItem) {
      return ((AbstractSessionItem) element).getName().replaceAll(".mid", "");
    }

    if (element instanceof Session) {
      return ((Session) element).getName();
    }
    return null;
  }

}
