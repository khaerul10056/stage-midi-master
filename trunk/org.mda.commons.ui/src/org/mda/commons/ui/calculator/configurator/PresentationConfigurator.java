package org.mda.commons.ui.calculator.configurator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import mda.MidiPlayerRoot;
import mda.PresentationScheme;
import mda.User;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.mda.commons.ui.DefaultMidiFileContentEditorConfig;
import org.mda.commons.ui.IMidiFileEditorUIConfig;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;


public class PresentationConfigurator {

  private static final Log LOGGER  = LogFactory.getLogger(PresentationConfigurator.class);



  public IMidiFileEditorUIConfig configure (final User user, final MidiPlayerRoot root, final PresentationType currentType) {
    if (root == null)
       throw new IllegalArgumentException("parameter root must not be null");

    if (currentType == null)
      throw new IllegalArgumentException("parameter currentType must not be null");

    DefaultMidiFileContentEditorConfig defaultConfig = new DefaultMidiFileContentEditorConfig();
    overwriteConfiguration(defaultConfig, root.getPresentationschemes(), currentType);
    if (user != null)
      overwriteConfiguration(defaultConfig, user.getPresentationschemes(), currentType);
    return defaultConfig;
  }

  /**
   * finds the scheme from a number of schemes by type
   * @param schemes schemes
   * @param type type to find
   * @return scheme or <code>null</code> if no scheme was found
   */
  private PresentationScheme findScheme (Collection <PresentationScheme> schemes, final PresentationType type ) {
    for (PresentationScheme nextScheme: schemes) {
      if (nextScheme.getType().equals(type.name()))
        return nextScheme;
    }

    return null;

  }

  private IMidiFileEditorUIConfig overwriteConfiguration (DefaultMidiFileContentEditorConfig originalConfig,
                                                          Collection <PresentationScheme> schemes,
                                                          final PresentationType type) {

    PresentationScheme fittingScheme = findScheme(schemes, type);
    if (fittingScheme != null) {

      for (EObject nextAttribute: fittingScheme.eClass().eContents()) {
        if (nextAttribute instanceof EAttribute) {
          EAttribute att = ((EAttribute) nextAttribute);
          if (! fittingScheme.eIsSet(att))
            continue;

          String name = ((EAttribute) nextAttribute).getName();
          String methodname = "set" + Character.toUpperCase(name.charAt(0)) + name.substring(1);
          for (Method nextMethod : originalConfig.getClass().getMethods()) {
            if (nextMethod.getName().equals(methodname)) {
              final Object parameter = fittingScheme.eGet(att);
              try {

                nextMethod.invoke(originalConfig, parameter);
                LOGGER.info("Calling setter " + nextMethod.getName() + " with parameter " + parameter);
              }
              catch (IllegalArgumentException e) {
                throw new IllegalStateException("method " + nextMethod.getName() + " can not be called with parameter " + parameter + "-" + parameter.getClass().getName());
              }
              catch (IllegalAccessException e) {
                throw new IllegalStateException(e);
              }
              catch (InvocationTargetException e) {
                throw new IllegalStateException(e);
              }
            }
            else
              LOGGER.info("Method " + nextMethod.getName() + " doesn't fit methodname " + methodname);
          }

        }
        else
          LOGGER.info("content " + nextAttribute + " is not attribute");


      }

//      if (fittingScheme.getNewPageRespected() != null)
//        originalConfig.setNewPageRespected(fittingScheme.getNewPageRespected());



    }
    return originalConfig;
  }

}
