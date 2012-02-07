package org.mda.core;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.junit.Test;
import org.mda.ApplicationSession;
import org.mda.Utils;


public class ApplicationSessionTest {

  @Test
  public void defaults () throws Exception {
    final String PATH = "tmp";

    try {
    ApplicationSession session = new ApplicationSession();

    session.load(PATH);

    File confFile = new File (PATH + "/.mda/mda.properties");
    assertTrue (confFile.exists());

    Properties props = new Properties();
    props.load(new FileInputStream(confFile));
    assertNotNull (props.get(ApplicationSession.PROP_LASTMODELFILE));


    } finally  {
      Utils.deleteDirectory(new File (PATH));
    }
  }

}
