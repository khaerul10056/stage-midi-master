package org.mda.transpose;

import org.mda.ApplicationSession;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;

import mda.Session;


/**
 * Contains features that can be enabled/disabled by properties in file
 * mda.properties, mostly debugging features
 * @author oleym
 *
 */
public class FeatureActivation {
	
  private static final Log LOGGER  = LogFactory.getLogger(FeatureActivation.class);


  private boolean showGridEnabled;

  private boolean showWhitespaces;

  private boolean presentationAlwaysOnTop;
  
  private Session startWithSession;
  
  private Session lastUsedSession;

  public boolean isShowGridEnabled () {
    return showGridEnabled;
  }

  public void setShowGridEnabled (boolean showGridEnabled) {
    LOGGER.info("set showGridEnabled to " + showGridEnabled);	  
    this.showGridEnabled = showGridEnabled;
  }

  public boolean isShowWhitespaces () {
    return showWhitespaces;
  }

  public void setShowWhitespaces (boolean showWhitespaces) {
	LOGGER.info("set showWhitespaces to " + showGridEnabled);	  
    this.showWhitespaces = showWhitespaces;
  }

  public boolean isPresentationAlwaysOnTop () {
    return presentationAlwaysOnTop;
  }

  public void setPresentationAlwaysOnTop (boolean presentationAlwaysOnTop) {
	LOGGER.info("set presetnationAlwaysOnTop to " + showGridEnabled);	  
    this.presentationAlwaysOnTop = presentationAlwaysOnTop;
  }

public Session getRunSession() {
	return startWithSession;
}

public boolean isStartupSessionConfigured () {
	return startWithSession != null;
}

public boolean isEscClosingWindowEnabled () {
	return ! isStartupSessionConfigured();
}

public void setRunSession(Session runSession) {
	this.startWithSession = runSession;
}

public Session getLastUsedSession() {
	return lastUsedSession;
}

public void setLastUsedSession(Session lastUsedSession) {
	this.lastUsedSession = lastUsedSession;
}

}
