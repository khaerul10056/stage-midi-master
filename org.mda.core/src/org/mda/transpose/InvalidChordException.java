package org.mda.transpose;

public class InvalidChordException extends Exception{

  /**
   *
   */
  private static final long serialVersionUID = -6991493200076975226L;

  public InvalidChordException (final String chord) {
    super ("The chord <" + chord + "> is invalid");
  }

}
