package org.mda.commons.ui;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;


public class MidiFileEditorInput implements IEditorInput {

  private EObject eObject;

  public MidiFileEditorInput (final EObject eobject) {
    this.eObject = eobject;
  }



  @Override
  public Object getAdapter (Class adapter) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean exists () {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public ImageDescriptor getImageDescriptor () {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getName () {
    return eObject.getClass().getName();
  }

  @Override
  public IPersistableElement getPersistable () {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getToolTipText () {
    return "";
  }

  public EObject getEObject () {
    return eObject;
  }

}
