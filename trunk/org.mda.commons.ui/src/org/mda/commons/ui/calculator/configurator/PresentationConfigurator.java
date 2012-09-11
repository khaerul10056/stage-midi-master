package org.mda.commons.ui.calculator.configurator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import mda.MidiPlayerRoot;
import mda.PresentationScheme;
import mda.User;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.mda.MidiPlayerService;
import org.mda.commons.ui.DefaultMidiFileContentEditorConfig;
import org.mda.commons.ui.IMidiFileEditorUIConfig;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;


public class PresentationConfigurator {

  private static final Log LOGGER  = LogFactory.getLogger(PresentationConfigurator.class);
  
  private PresentationConfigDefaults defaults = new PresentationConfigDefaults();
  
  public Collection <PresentationScheme> getParents (final User user, final MidiPlayerRoot root, final PresentationScheme current) {
	  
	  if (current == null)
		  throw new IllegalArgumentException("current must not be <code>null</code>");
	  
	  Collection <PresentationScheme> parent = new ArrayList<PresentationScheme>();
	  
	  PresentationScheme foundAsUserScheme = user != null ? findSchemeByIdentity(user.getPresentationschemes(), current): null;
	  PresentationScheme foundAsGlobalScheme = findSchemeByIdentity(root.getPresentationschemes(), current);
	  
	  PresentationScheme defaultedGlobalScheme = findSchemeByType(root.getPresentationschemes(), PresentationType.valueOf(current.getType()));
	  PresentationScheme defaultedDefaultScheme = findSchemeByType(defaults.getAllDefaultSchemes(), PresentationType.valueOf(current.getType()));
	  
	  if (foundAsUserScheme != null) {
		  parent.add(defaultedGlobalScheme);
		  parent.add(defaultedDefaultScheme);
	  }
	  
	  if (foundAsGlobalScheme != null)
		  parent.add(defaultedDefaultScheme);
	  
	  return parent;
  }

  public IMidiFileEditorUIConfig configure (final User user, final MidiPlayerRoot root, final PresentationType currentType) {
    if (root == null)
       throw new IllegalArgumentException("parameter root must not be null");

    if (currentType == null)
      throw new IllegalArgumentException("parameter currentType must not be null");

    DefaultMidiFileContentEditorConfig defaultConfig = new DefaultMidiFileContentEditorConfig();
    
    overwriteConfiguration(defaultConfig, defaults.getAllDefaultSchemes(), currentType);  //programmatic defaults
    
    overwriteConfiguration(defaultConfig, root.getPresentationschemes(), currentType); //generally configured values
    
    if (user != null)
      overwriteConfiguration(defaultConfig, user.getPresentationschemes(), currentType); //per user configured values
    return defaultConfig;
  }
  
  public List <String> getPresentationTypes () {
	  ArrayList<String> types = new ArrayList<String>();
	  for (PresentationType next: PresentationType.values()) {
		  types.add(next.name());
	  }
	  return types;
  }
  
  
  public PresentationScheme createScheme (final User user, final MidiPlayerRoot root, final PresentationType currentType) {
	  PresentationScheme newScheme = MidiPlayerService.mf.createPresentationScheme();
	  newScheme.setType(currentType.name());
	  if (user != null)
		  user.getPresentationschemes().add(newScheme);
	  else
		  root.getPresentationschemes().add(newScheme);
	  
	  return newScheme;
  }
  

  /**
   * finds the scheme from a number of schemes by type
   * @param schemes schemes
   * @param type type to find
   * @return scheme or <code>null</code> if no scheme was found
   */
  public PresentationScheme findSchemeByType (Collection <PresentationScheme> schemes, final PresentationType type ) {
    for (PresentationScheme nextScheme: schemes) {
      if (nextScheme.getType().equals(type.name()))
        return nextScheme;
    }

    return null;

  }
  
  public PresentationScheme findSchemeByIdentity (Collection <PresentationScheme> schemes, final PresentationScheme scheme ) {
	    for (PresentationScheme nextScheme: schemes) {
	      if (nextScheme == scheme)
	        return nextScheme;
	    }

	    return null;

	  }

  public IMidiFileEditorUIConfig overwriteConfiguration (DefaultMidiFileContentEditorConfig originalConfig,
                                                          Collection <PresentationScheme> schemes,
                                                          final PresentationType type) {

    PresentationScheme fittingScheme = findSchemeByType(schemes, type);
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
            else if (LOGGER.isDebugEnabled())
              LOGGER.debug("Method " + nextMethod.getName() + " doesn't fit methodname " + methodname);
          }

        }
        else if (LOGGER.isDebugEnabled())
          LOGGER.info("content " + nextAttribute + " is not attribute");


      }

//      if (fittingScheme.getNewPageRespected() != null)
//        originalConfig.setNewPageRespected(fittingScheme.getNewPageRespected());



    }
    return originalConfig;
  }

}
