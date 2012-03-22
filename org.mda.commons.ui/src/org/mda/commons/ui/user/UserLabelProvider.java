package org.mda.commons.ui.user;

import mda.User;
import org.eclipse.jface.viewers.ColumnLabelProvider;


public class UserLabelProvider extends ColumnLabelProvider {


  @Override
  public String getText (Object element) {
    if (element instanceof User) {
      User user = (User) element;
      return user.getFirstname() + " " + user.getName();
    }

    return null;
  }




}
