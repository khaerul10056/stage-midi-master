package org.mda.logging;

import java.io.File;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.core.runtime.Platform;

/**
 * Log-Factory to use in eclipse. This factory handles loading the configuration
 * once and gives an API for structural logging
 *
 * @author oleym
 *
 */
public class LogFactory {

  private static ConsoleHandler consoleHandler;

  private static FileHandler fileHandler;

  private static LogFormatter formatter = new LogFormatter();

  static {

    String installPath = new File("").getAbsolutePath();
    try {
      installPath = Platform.getInstallLocation().getURL().getFile();
    } catch (Exception e) {
      // if we are not in an OSGI-Enviroment, we use the current path
    }

    Level level = Level.parse("INFO");

    consoleHandler = new ConsoleHandler();
    consoleHandler.setLevel(level);
    consoleHandler.setFormatter(new LogFormatter());

    try {
      File logPath = new File (installPath + "/logs");
      if (!logPath.exists())
        logPath.mkdirs();

      fileHandler = new FileHandler(installPath + "/logs/aid.log", 10485760 , 5, true);
    } catch (Exception e) {
      e.printStackTrace();
    }
    fileHandler.setLevel(level);
    fileHandler.setFormatter(new LogFormatter ());

  }


  /**
   * ermittelt sich den Logger
   *
   * @param clazz
   *            Klasse
   * @return Logger
   */
  public final static Log getLogger(Class<?> clazz) {

    //TODO configure from console
    Logger logger = Logger.getLogger(clazz.getName());
    logger.addHandler(consoleHandler);
    logger.addHandler(fileHandler);
    for (Handler handler: logger.getHandlers()) {
      handler.setFormatter(formatter);
    }

    logger.setUseParentHandlers(false);
    return new Log(logger);
  }

}
