package org.mda.transpose;


/**
 * Contains features that can be enabled/disabled by properties in file
 * mda.properties, mostly debugging features
 * @author oleym
 *
 */
public class FeatureActivation {

  private boolean showGridEnabled;

  private boolean showWhitespaces;

  private boolean presentationAlwaysOnTop;

  public boolean isShowGridEnabled () {
    return showGridEnabled;
  }

  public void setShowGridEnabled (boolean showGridEnabled) {
    this.showGridEnabled = showGridEnabled;
  }

  public boolean isShowWhitespaces () {
    return showWhitespaces;
  }

  public void setShowWhitespaces (boolean showWhitespaces) {
    this.showWhitespaces = showWhitespaces;
  }

  public boolean isPresentationAlwaysOnTop () {
    return presentationAlwaysOnTop;
  }

  public void setPresentationAlwaysOnTop (boolean presentationAlwaysOnTop) {
    this.presentationAlwaysOnTop = presentationAlwaysOnTop;
  }

}
