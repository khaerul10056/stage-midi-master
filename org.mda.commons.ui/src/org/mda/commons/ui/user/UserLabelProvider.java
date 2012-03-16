package org.mda.commons.ui.user;

import java.util.logging.Logger;
import mda.User;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.mda.commons.ui.LabelProvider;


public class UserLabelProvider extends ColumnLabelProvider {

  private static final Logger LOGGER = Logger.getLogger(LabelProvider.class.getName());

  @Override
  public String getText (Object element) {
    if (element instanceof User) {
      User user = (User) element;
      return user.getFirstname() + " " + user.getName();
    }

    return null;
  }




}
