package org.mda.commons.ui.calculator.configurator;

import org.junit.Before;
import org.junit.Test;
import org.mda.ApplicationSession;
import org.mda.MdaModule;
import org.mda.commons.ui.DefaultMidiFileContentEditorConfig;
import org.mda.commons.ui.IMidiFileEditorUIConfig;


public class PresentationConfiguratorTest {


  private PresentationConfigurator configurator;
  private static ApplicationSession appSession = MdaModule.getInjector().getInstance(ApplicationSession.class);

  @Before
  public void setup () {
    configurator = new PresentationConfigurator();
  }

  @Test
  public void dontOverwriteDefault () {
    DefaultMidiFileContentEditorConfig config = new DefaultMidiFileContentEditorConfig();
    IMidiFileEditorUIConfig configure = configurator.configure(null, appSession.getCurrentModel(), PresentationType.PDF);

    throw new IllegalStateException("TODO");
  }

  @Test
  public void overwriteWithGeneric () {

    throw new IllegalStateException("TODO");
  }

  @Test
  public void overwriteWithUser () {
    throw new IllegalStateException("TODO");
  }

  @Test
  public void overwriteWithGenericAndUser () {
    throw new IllegalStateException("TODO");

  }



}
