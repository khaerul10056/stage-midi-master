/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package mda.util;

import mda.*;
import mda.AbstractEvent;
import mda.AbstractSessionItem;
import mda.Configuration;
import mda.Gallery;
import mda.MidiFile;
import mda.MidiFileChordPart;
import mda.MidiFilePart;
import mda.MidiFileTextLine;
import mda.MidiPlayerRoot;
import mda.MidiplayerPackage;
import mda.Session;
import mda.TextPresentationEvent;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see mda.MidiplayerPackage
 * @generated
 */
public class MidiplayerSwitch<T> extends Switch<T> {
	/**
   * The cached model package
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected static MidiplayerPackage modelPackage;

	/**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public MidiplayerSwitch() {
    if (modelPackage == null) {
      modelPackage = MidiplayerPackage.eINSTANCE;
    }
  }

	/**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage) {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
	@Override
  protected T doSwitch(int classifierID, EObject theEObject) {
    switch (classifierID) {
      case MidiplayerPackage.SESSION: {
        Session session = (Session)theEObject;
        T result = caseSession(session);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MidiplayerPackage.ABSTRACT_SESSION_ITEM: {
        AbstractSessionItem abstractSessionItem = (AbstractSessionItem)theEObject;
        T result = caseAbstractSessionItem(abstractSessionItem);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MidiplayerPackage.MIDI_FILE: {
        MidiFile midiFile = (MidiFile)theEObject;
        T result = caseMidiFile(midiFile);
        if (result == null) result = caseAbstractSessionItem(midiFile);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MidiplayerPackage.ABSTRACT_EVENT: {
        AbstractEvent abstractEvent = (AbstractEvent)theEObject;
        T result = caseAbstractEvent(abstractEvent);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MidiplayerPackage.TEXT_PRESENTATION_EVENT: {
        TextPresentationEvent textPresentationEvent = (TextPresentationEvent)theEObject;
        T result = caseTextPresentationEvent(textPresentationEvent);
        if (result == null) result = caseAbstractEvent(textPresentationEvent);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MidiplayerPackage.MIDI_FILE_PART: {
        MidiFilePart midiFilePart = (MidiFilePart)theEObject;
        T result = caseMidiFilePart(midiFilePart);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MidiplayerPackage.MIDI_FILE_TEXT_LINE: {
        MidiFileTextLine midiFileTextLine = (MidiFileTextLine)theEObject;
        T result = caseMidiFileTextLine(midiFileTextLine);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MidiplayerPackage.GALLERY: {
        Gallery gallery = (Gallery)theEObject;
        T result = caseGallery(gallery);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MidiplayerPackage.MIDI_PLAYER_ROOT: {
        MidiPlayerRoot midiPlayerRoot = (MidiPlayerRoot)theEObject;
        T result = caseMidiPlayerRoot(midiPlayerRoot);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MidiplayerPackage.MIDI_FILE_CHORD_PART: {
        MidiFileChordPart midiFileChordPart = (MidiFileChordPart)theEObject;
        T result = caseMidiFileChordPart(midiFileChordPart);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MidiplayerPackage.CONFIGURATION: {
        Configuration configuration = (Configuration)theEObject;
        T result = caseConfiguration(configuration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MidiplayerPackage.USER: {
        User user = (User)theEObject;
        T result = caseUser(user);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MidiplayerPackage.EXPORT_CONFIGURATION: {
        ExportConfiguration exportConfiguration = (ExportConfiguration)theEObject;
        T result = caseExportConfiguration(exportConfiguration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Session</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Session</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseSession(Session object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Abstract Session Item</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract Session Item</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseAbstractSessionItem(AbstractSessionItem object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Midi File</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Midi File</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseMidiFile(MidiFile object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Abstract Event</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract Event</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseAbstractEvent(AbstractEvent object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Text Presentation Event</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Text Presentation Event</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseTextPresentationEvent(TextPresentationEvent object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Midi File Part</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Midi File Part</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseMidiFilePart(MidiFilePart object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Midi File Text Line</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Midi File Text Line</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseMidiFileTextLine(MidiFileTextLine object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Gallery</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Gallery</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseGallery(Gallery object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Midi Player Root</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Midi Player Root</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseMidiPlayerRoot(MidiPlayerRoot object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Midi File Chord Part</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Midi File Chord Part</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseMidiFileChordPart(MidiFileChordPart object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Configuration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Configuration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConfiguration(Configuration object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>User</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>User</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUser(User object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Export Configuration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Export Configuration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExportConfiguration(ExportConfiguration object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
	@Override
  public T defaultCase(EObject object) {
    return null;
  }

} //MidiplayerSwitch
