package org.mda;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import mda.Configuration;
import mda.MidiPlayerRoot;
import mda.Session;
import mda.Song;

import org.mda.additionals.AdditionalsHandler;
import org.mda.listeners.ModelEvents;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.transpose.FeatureActivation;


public class ApplicationSession {

  private static final Log LOGGER  = LogFactory.getLogger(ApplicationSession.class);

  private Properties sessionProps = new Properties();
  
  private MidiPlayerRoot model;

  private File configFileAsFile;

  public static final String PROP_LASTMODELFILE = "org.mda.commons.ui.lastmodelfile";
  public static final String PROP_LASTSESSION = "org.mda.commons.ui.lastsession";

  public static final String PROP_ENABLEGRID = "org.mda.commons.ui.enableGrid";

  public static final String PROP_SHOWWHITESPACES = "org.mda.commons.ui.showWhitespaces";
  public static final String PROP_PRESENTATIONALWAYSONTOP = "org.mda.commons.ui.presentationAlwaysOnTop";
  private File lastModelFile;

  private AdditionalsHandler additionalsHandler;

  private String version;

  private final GlobalConfigurations globalConfs = new GlobalConfigurations();

  private final FeatureActivation featureActivation = new FeatureActivation();
  
  private ModelEvents modelEvents = new ModelEvents();
  
  
  /**
   * getter  
   * @return modelevents
   */
  public ModelEvents getModelEvents () {
	  return modelEvents;
  }
  
  
  

  
  public Configuration getConfig () {
	  return getCurrentModel().getConfig();
  }


  public MidiPlayerRoot getCurrentModel () {
    return model;
  }


  /**
   * gets configpath, creates it, if not yet available
   * @param basepath basepath
   * @return Configpath
   */
  public File getOrCreateConfigPath (File basepath) {
	File basepathReal = basepath != null ? basepath : new File (System.getProperty("user.home"));

    File confPath = new File (basepathReal, ".mda");
    if (! confPath.exists())
      confPath.mkdirs();
    return confPath;
  }
  
  public File getOrCreateConfigPath () {
	  return getOrCreateConfigPath(null);
  }
  
  


  private void setDefaultOnDemand (final Properties properties, final String key, final String defaultValue) {
    String value = properties.getProperty(key);
    if (value == null)
      properties.setProperty(key, defaultValue);
  }
  
  

  public void load (String originpath) {

    File path = new File (originpath != null ? originpath : System.getProperty("user.home"));

    LOGGER.info("Setting current path to " + path + "(from " + originpath + ")");

    if (sessionProps.isEmpty()) {

      File confPath = getOrCreateConfigPath(path);

      LOGGER.info("Create initial properties in " + confPath.getAbsolutePath());

      setConfigFile(new File (confPath + File.separator + "mda.properties"));

      //load if exists
      if (getConfigFile().exists()) {
        try {
          sessionProps.load(new FileInputStream(getConfigFile()));
        }
        catch (Exception e) {
          LOGGER.error(e.getLocalizedMessage(), e);
        }
      }

      setDefaultOnDemand(sessionProps, PROP_LASTMODELFILE, new File (confPath.getAbsolutePath(), "mda.model.xml").getAbsolutePath());
      setDefaultOnDemand(sessionProps, PROP_ENABLEGRID, "false");
      setDefaultOnDemand(sessionProps, PROP_SHOWWHITESPACES, "false");
      setDefaultOnDemand(sessionProps, PROP_PRESENTATIONALWAYSONTOP, "true");


      //Read the modelfile that was used at last start
      String property = sessionProps.getProperty(PROP_LASTMODELFILE);

      setLastModelPath(new File (property));
      getFeatureActivation().setShowGridEnabled(Boolean.valueOf(sessionProps.getProperty(PROP_ENABLEGRID)));
      getFeatureActivation().setShowWhitespaces(Boolean.valueOf(sessionProps.getProperty(PROP_SHOWWHITESPACES)));
      getFeatureActivation().setPresentationAlwaysOnTop(Boolean.valueOf(sessionProps.getProperty(PROP_PRESENTATIONALWAYSONTOP)));
      
      String propLastSession = sessionProps.getProperty(PROP_LASTSESSION); 
      if (propLastSession != null) {
    	  getFeatureActivation().setLastUsedSession(MidiPlayerService.findSession(getCurrentModel(), propLastSession));
    	  setCurrentSession(getFeatureActivation().getLastUsedSession());
      }
      
      if (! getConfigFile().exists())
        save(getConfigFile());
    }
  }


  public void save (final File configFile)  {
	LOGGER.info("Saving configs in " + configFile.getAbsolutePath());
    sessionProps.put(PROP_LASTMODELFILE, getLastModelPath().toString());
    if (getCurrentSession() != null)
      sessionProps.put(PROP_LASTSESSION, getCurrentSession().getName());

    try {
      sessionProps.store(new FileOutputStream(getConfigFile()), "properties saved by MDA");

    }
    catch (IOException e) {
      LOGGER.error(e.getLocalizedMessage(), e);
    }

  }

  public File getExportPath () {
    return new File (model.getConfig().getPdfExportPath());
  }

  public AdditionalsHandler getAdditionalsHandler () {
	  
	  
    if (additionalsHandler == null)
      additionalsHandler = new AdditionalsHandler(getAdditionalsPath());

    return additionalsHandler;
  }

  public File getAdditionalsPath () {
	File additionalsPath = new File (getOrCreateConfigPath(null), "additionals");
	
    return additionalsPath;
  }


  public File getLastModelPath () {
    return lastModelFile;
  }


  public void setLastModelPath (File lastModelPath) {
    if (! lastModelPath.exists())
      LOGGER.warn("Model " + lastModelPath.getAbsolutePath() + " doesn't exist");

    this.lastModelFile = lastModelPath;
    LOGGER.info ("Loading model " + lastModelPath.getAbsolutePath());
    model = MidiPlayerService.loadRootObject(lastModelPath);
    if (model.getConfig() == null)
      model.setConfig(MidiPlayerService.mf.createConfiguration());

    Configuration config = model.getConfig();
    if (config.getPdfExportPath() == null)
      config.setPdfExportPath("exportFiles");
    if (config.getAdditionalsPath() == null)
      config.setAdditionalsPath("additionals");
  }

  public void saveModel () {
    MidiPlayerService.saveRootObject(model);
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


  public Session getCurrentSession () {
    return (Session) getModelEvents().getCurrentModelElement(Session.class);
  }


  public void setCurrentSession (Session currentSession) {
    getModelEvents().setCurrentModelElement(Session.class, currentSession);
    setCurrentMidifile(null);
  }


public Song getCurrentMidifile() {
	return (Song) getModelEvents().getCurrentModelElement(Song.class);
}


public void setCurrentMidifile(Song currentMidifile) {
	getModelEvents().setCurrentModelElement(Song.class, currentMidifile);
}

public File getConfigFile() {
	return configFileAsFile;
}

public void setConfigFile(File configFileAsFile) {
	this.configFileAsFile = configFileAsFile;
}












}
