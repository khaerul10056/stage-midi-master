package org.mda;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import mda.Configuration;
import mda.Song;
import mda.MidiPlayerRoot;
import mda.Session;

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
  
  private UIState uistate = new UIState ();
 
  
  public UIState getUiState () {
	  return uistate;
  }
  
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
      path = new File (System.getProperty("user.dir"));

    LOGGER.info("Setting current path to " + path);

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

      setDefaultOnDemand(sessionProps, PROP_LASTMODELFILE, "mda.model.xml");
      setDefaultOnDemand(sessionProps, PROP_ENABLEGRID, "false");
      setDefaultOnDemand(sessionProps, PROP_SHOWWHITESPACES, "false");
      setDefaultOnDemand(sessionProps, PROP_PRESENTATIONALWAYSONTOP, "true");


      //Read the modelfile that was used at last start
      String property = sessionProps.getProperty(PROP_LASTMODELFILE);
      if (originpath != null)
        property = originpath;

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
    return new File (model.getConfig().getAdditionalsPath());
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
