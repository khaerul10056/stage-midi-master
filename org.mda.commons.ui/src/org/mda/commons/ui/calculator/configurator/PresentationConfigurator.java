package org.mda.commons.ui.calculator.configurator;

import java.util.Collection;
import mda.MidiPlayerRoot;
import mda.PresentationScheme;
import mda.User;
import org.mda.commons.ui.DefaultMidiFileContentEditorConfig;
import org.mda.commons.ui.IMidiFileEditorUIConfig;


public class PresentationConfigurator {


  public IMidiFileEditorUIConfig configure (final User user, final MidiPlayerRoot root, final PresentationType currentType) {
    IMidiFileEditorUIConfig defaultConfig = new DefaultMidiFileContentEditorConfig();
    overwriteConfiguration(defaultConfig, root.getPresentationschemes(), currentType);
    overwriteConfiguration(defaultConfig, user.getPresentationschemes(), currentType);
    return defaultConfig;
  }

  private IMidiFileEditorUIConfig overwriteConfiguration (IMidiFileEditorUIConfig originalConfig,
                                                          Collection <PresentationScheme> schemes,
                                                          final PresentationType type) {



    return originalConfig;
  }

}
