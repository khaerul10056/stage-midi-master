package org.mda;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import mda.MidiPlayerRoot;


public class ApplicationSession {

  private static final Logger LOGGER  = Logger.getLogger(ApplicationSession.class.getName());

  private static Properties sessionProps = new Properties();

  public static final String PROP_EXPORTPATH = "org.mda.commons.ui.exportpath";

  private MidiPlayerRoot playerroot = MidiPlayerService.loadRootObject(new File("/home/oleym/privat/soundOfFaith/stage-midi-master/org.mda.core.test/testdata/testmodel.conf")); //TODO get selected

  private File configFileAsFile;

  private File exportPath;


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


  public void load (final String path) {
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
        sessionProps.setProperty(PROP_EXPORTPATH, "/tmp");

      }

      setExportPath(new File (sessionProps.getProperty(PROP_EXPORTPATH)));

      if (! configFileAsFile.exists())
        save(configFileAsFile);
    }



  }


  public void save (final File configFile)  {
    sessionProps.put(PROP_EXPORTPATH, getExportPath().toString());

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



}
