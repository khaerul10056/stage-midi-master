package org.mda.google;

import java.util.ArrayList;
import java.util.Collection;
import mda.UserType;


public class GoogleContactsDescriptor {

  private final UserType usertype;
  private Collection <String> groups = new ArrayList<String>();

  public GoogleContactsDescriptor (final UserType usertype) {
    this.usertype = usertype;
  }

  public void addGroup (String groupname) {
    this.groups.add(groupname);
  }

  public UserType getUsertype () {
    return usertype;
  }

  public boolean usesGroup (final String groupname) {
    return groups.contains(groupname);
  }

  public String toString () {
    StringBuilder builder = new StringBuilder();
    builder.append("GoogleContactsDescriptor " + usertype.getName() + ":");
    for (String nextGroup: groups) {
      builder.append("- " + nextGroup + "\n");
    }

    return builder.toString();
  }



}
