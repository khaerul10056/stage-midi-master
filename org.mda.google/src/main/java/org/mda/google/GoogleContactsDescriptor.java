package org.mda.google;

import mda.UserType;


public class GoogleContactsDescriptor {

  private final UserType usertype;
  private final String group;

  public GoogleContactsDescriptor (final UserType usertype, final String group) {
    this.usertype = usertype;
    this.group = group;
  }




  @Override
public String toString () {
    StringBuilder builder = new StringBuilder();
    builder.append("GoogleContactsDescriptor " + getUsertype().getName() + ":<" + group + ">");
    return builder.toString();
  }




  public String getGroup () {
    return group;
  }




  public UserType getUsertype () {
    return usertype;
  }



}
