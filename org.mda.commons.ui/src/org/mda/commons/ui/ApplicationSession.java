package org.mda.commons.ui;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import mda.MidiPlayerRoot;
import org.mda.MidiPlayerService;


public class ApplicationSession {

  private static final Logger LOGGER  = Logger.getLogger(ApplicationSession.class.getName());

  private static Properties sessionProps = new Properties();

  public final static String DEFAULT_CONFIGFILE = "mda.conf";

  public final static String DEFAULT_EXPORTPATH = "/tmp";


  public static final String PROP_EXPORTPATH = "org.mda.commons.ui.exportpath";
  private File exportPath = new File (DEFAULT_EXPORTPATH);

  private MidiPlayerRoot playerroot = MidiPlayerService.loadRootObject(new File("/home/oleym/privat/soundOfFaith/stage-midi-master/org.mda.core.test/testdata/testmodel.conf")); //TODO get selected


  public MidiPlayerRoot getCurrentModel () {
    return playerroot;
  }

  public ApplicationSession () {
    load (DEFAULT_CONFIGFILE);
  }


  private void load (final String configFile) {
    if (sessionProps.isEmpty()) {
      File configFileAsFile = new File (configFile);
      if (configFileAsFile.exists())
        try {
          sessionProps.load(new FileInputStream(configFileAsFile));
          setExportPath(new File (sessionProps.getProperty(PROP_EXPORTPATH, DEFAULT_EXPORTPATH)));

        }
        catch (Exception e) {
          LOGGER.log(Level.SEVERE, e.getLocalizedMessage(), e);
        }
    }



  }


  public void save (final String configFile) {

  }

  public File getExportPath () {
    return exportPath;
  }

  public void setExportPath (File exportPath) {
    this.exportPath = exportPath;
  }



}
