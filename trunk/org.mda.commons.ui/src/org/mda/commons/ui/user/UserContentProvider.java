package org.mda.commons.ui.user;

import mda.MidiPlayerRoot;

import org.eclipse.jface.viewers.ArrayContentProvider;


/**
 * content provider to show all users
 * @author mao
 *
 */
public class UserContentProvider extends ArrayContentProvider {

  @Override
  public Object[] getElements (Object parentElement) {

    if (parentElement instanceof MidiPlayerRoot) {
      MidiPlayerRoot root = (MidiPlayerRoot) parentElement;
      return root.getUsers().toArray();
    }

    return null;

  }




}