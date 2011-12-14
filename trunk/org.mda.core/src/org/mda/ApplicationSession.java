package org.mda;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import mda.MidiPlayerRoot;
import com.google.inject.Guice;
import com.google.inject.Injector;


public class ApplicationSession {

  private static final Logger LOGGER  = Logger.getLogger(ApplicationSession.class.getName());

  private Properties sessionProps = new Properties();


  private MidiPlayerRoot playerroot;

  private File configFileAsFile;

  public static final String PROP_EXPORTPATH = "org.mda.commons.ui.exportpath";
  private File exportPath;

  public static final String PROP_LASTMODELFILE = "org.mda.commons.ui.lastmodelfile";
  private File lastModelFile;

  /**
   * injector
   */
  private final static Injector injector = Guice.createInjector(new MdaModule());

  /**
   * getter
   * @return Injector
   */
  public static Injector getInjector () {
    return injector;
  }

  public MidiPlayerRoot getCurrentModel () {
    return playerroot;
  }


  /**
   * gets configpath, creates it, if not yet available
   * @param basepath basepath
   * @return Configpath
   */
  public File getOrCreateConfigPath (File basepath) {
    File confPath = new File (basepath.getAbsolutePath() + File.separator + ".mda");
    if (! confPath.exists())
      confPath.mkdirs();
    return confPath;
  }


  public void load (String path) {

    if (path == null)
      path = new File ("").getAbsolutePath();

    if (sessionProps.isEmpty()) {

      File confPath = getOrCreateConfigPath(new File (path));

      configFileAsFile = new File (confPath + File.separator + "mda.properties");

      //load if exists
      if (configFileAsFile.exists()) {
        try {
          sessionProps.load(new FileInputStream(configFileAsFile));
        }
        catch (Exception e) {
          LOGGER.log(Level.SEVERE, e.getLocalizedMessage(), e);
        }
      } else { //or set defaults
        sessionProps.setProperty(PROP_EXPORTPATH, "exportFiles");
        sessionProps.setProperty(PROP_LASTMODELFILE, "mda.model.xml");

      }

      //Last used exportpath
      String exportPathProp = sessionProps.getProperty(PROP_EXPORTPATH);
      setExportPath(new File (exportPathProp));


      //Read the modelfile that was used at last start
      String property = sessionProps.getProperty(PROP_LASTMODELFILE);
        setLastModelPath(new File (property));

      if (! configFileAsFile.exists())
        save(configFileAsFile);
    }
  }


  public void save (final File configFile)  {
    sessionProps.put(PROP_EXPORTPATH, getExportPath().toString());
    sessionProps.put(PROP_LASTMODELFILE, getLastModelPath().toString());

    try {
      sessionProps.store(new FileOutputStream(configFileAsFile), "properties saved by MDA");

    }
    catch (IOException e) {
      LOGGER.log(Level.SEVERE, e.getLocalizedMessage(), e);
    }

  }

  public File getExportPath () {
    return exportPath;
  }

  public void setExportPath (File exportPath) {
    this.exportPath = exportPath;
  }


  public File getLastModelPath () {
    return lastModelFile;
  }


  public void setLastModelPath (File lastModelPath) {
    if (! lastModelPath.exists())
      LOGGER.warning("Model " + lastModelPath.getAbsolutePath() + " doesn't exist");

    this.lastModelFile = lastModelPath;
    LOGGER.info ("Loading model " + lastModelPath.getAbsolutePath());
    playerroot = MidiPlayerService.loadRootObject(lastModelPath);
  }

  public void saveModel () {
    MidiPlayerService.saveRootObject(playerroot);
  }





}
