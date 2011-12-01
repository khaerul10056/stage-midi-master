package org.mda.commons.ui;

import mda.MidiFile;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;


public class MidiFileEditorInput implements IEditorInput {

  private final MidiFile rootObject;

  public MidiFileEditorInput (final MidiFile rootObject) {
    this.rootObject = rootObject;
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
    return getRootObject().getName();
  }

  @Override
  public IPersistableElement getPersistable () {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getToolTipText () {
    return getRootObject().getPath();
  }

  public MidiFile getRootObject () {
    return rootObject;
  }

}
