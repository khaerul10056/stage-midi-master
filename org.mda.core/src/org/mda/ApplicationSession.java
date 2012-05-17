package org.mda;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import mda.Configuration;
import mda.MidiPlayerRoot;
import org.mda.additionals.AdditionalsHandler;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.transpose.FeatureActivation;


public class ApplicationSession {


  private static final Log LOGGER  = LogFactory.getLogger(ApplicationSession.class);

  private Properties sessionProps = new Properties();


  private MidiPlayerRoot playerroot;

  private File configFileAsFile;

  public static final String PROP_LASTMODELFILE = "org.mda.commons.ui.lastmodelfile";

  public static final String PROP_ENABLEGRID = "org.mda.commons.ui.enableGrid";

  private File lastModelFile;

  private AdditionalsHandler additionalsHandler;

  private String version;

  private final GlobalConfigurations globalConfs = new GlobalConfigurations();

  private final FeatureActivation featureActivation = new FeatureActivation();






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


  private void setDefaultOnDemand (final Properties properties, final String key, final String defaultValue) {
    String value = properties.getProperty(key);
    if (value == null)
      properties.setProperty(key, defaultValue);
  }

  public void load (String originpath) {

    File path = null;
    if (path == null)
      path = new File ("");

    if (sessionProps.isEmpty()) {

      File confPath = getOrCreateConfigPath(path);

      LOGGER.info("Create initial properties in " + confPath.getAbsolutePath());

      configFileAsFile = new File (confPath + File.separator + "mda.properties");

      //load if exists
      if (configFileAsFile.exists()) {
        try {
          sessionProps.load(new FileInputStream(configFileAsFile));
        }
        catch (Exception e) {
          LOGGER.error(e.getLocalizedMessage(), e);
        }
      }

      setDefaultOnDemand(sessionProps, PROP_LASTMODELFILE, "mda.model.xml");
      setDefaultOnDemand(sessionProps, PROP_ENABLEGRID, "false");


      //Read the modelfile that was used at last start
      String property = sessionProps.getProperty(PROP_LASTMODELFILE);
      if (originpath != null)
        property = originpath;

      setLastModelPath(new File (property));
      getFeatureActivation().setShowGridEnabled(Boolean.valueOf(sessionProps.getProperty(PROP_ENABLEGRID)));

      if (! configFileAsFile.exists())
        save(configFileAsFile);
    }
  }


  public void save (final File configFile)  {
    sessionProps.put(PROP_LASTMODELFILE, getLastModelPath().toString());

    try {
      sessionProps.store(new FileOutputStream(configFileAsFile), "properties saved by MDA");

    }
    catch (IOException e) {
      LOGGER.error(e.getLocalizedMessage(), e);
    }

  }

  public File getExportPath () {
    return new File (playerroot.getConfig().getPdfExportPath());
  }

  public AdditionalsHandler getAdditionalsHandler () {
    if (additionalsHandler == null)
      additionalsHandler = new AdditionalsHandler(getAdditionalsPath());

    return additionalsHandler;
  }

  public File getAdditionalsPath () {
    return new File (playerroot.getConfig().getAdditionalsPath());
  }


  public File getLastModelPath () {
    return lastModelFile;
  }


  public void setLastModelPath (File lastModelPath) {
    if (! lastModelPath.exists())
      LOGGER.warn("Model " + lastModelPath.getAbsolutePath() + " doesn't exist");

    this.lastModelFile = lastModelPath;
    LOGGER.info ("Loading model " + lastModelPath.getAbsolutePath());
    playerroot = MidiPlayerService.loadRootObject(lastModelPath);
    if (playerroot.getConfig() == null)
      playerroot.setConfig(MidiPlayerService.mf.createConfiguration());

    Configuration config = playerroot.getConfig();
    if (config.getPdfExportPath() == null)
      config.setPdfExportPath("exportFiles");
    if (config.getAdditionalsPath() == null)
      config.setAdditionalsPath("additionals");
  }

  public void saveModel () {
    MidiPlayerService.saveRootObject(playerroot);
  }


  public String getVersion () {
    return version;
  }


  public void setVersion (String version) {
    this.version = version;
  }





  public GlobalConfigurations getGlobalConfs () {
    return globalConfs;
  }


  public FeatureActivation getFeatureActivation () {
    return featureActivation;
  }












}
