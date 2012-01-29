package org.mda.logging;

import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Delegate for the logger instance
 * @author oleym
 *
 */
public class Log {

  private static Logger logger;

  /**
   * layer for loggin structural
   */
  private static int layer;

  /**
   * prefix of the logger
   */
  private static String prefix = "";

  private static Stack <Long> starttimes = new Stack<Long>();


  /**
   * Konstruktor
   * @param logger Logger
   */
  public Log (final Logger logger) {
    Log.logger = logger;
  }


  public boolean isDebugEnabled() {
    return logger.isLoggable(Level.FINE);
  }

  public void debug(final String meldung) {
    if (isDebugEnabled())
      logger.fine(prefix + meldung);
  }

  public void info(final String meldung) {
    if (isInfoEnabled())
      logger.info(prefix + meldung);
  }

  public boolean isInfoEnabled() {
    return logger.isLoggable(Level.INFO);
  }

  public void error(final String meldung) {
    logger.severe(prefix + meldung);
  }

  public void error(final String meldung, final Throwable e) {
    logger.log(Level.SEVERE, prefix + meldung, e);
  }

  public void warn(final String meldung) {
    logger.warning(prefix + meldung);
  }

  private void calculateLayer(final int layer) {
    prefix = "";
    for (int i = 0; i < layer; i++)
      prefix += "    ";
  }

  public void beginTask(final String meldung) {
    logger.info(meldung);
    starttimes.push(new Long (System.currentTimeMillis()));

    calculateLayer(++layer);
  }

  public void endTask(final String meldung) {
    calculateLayer(--layer);

    long duration = -1;


    if (!starttimes.empty()) {
      Long since = starttimes.pop();
      duration = System.currentTimeMillis() - since.longValue();
    }

    logger.info((duration >  0) ? meldung + " (Duration: " + duration + " ms)":meldung);

  }

}
