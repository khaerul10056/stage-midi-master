/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package mda;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see mda.MidiplayerPackage
 * @generated
 */
public interface MidiplayerFactory extends EFactory {
	/**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	MidiplayerFactory eINSTANCE = mda.impl.MidiplayerFactoryImpl.init();

	/**
   * Returns a new object of class '<em>Session</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Session</em>'.
   * @generated
   */
	Session createSession();

	/**
   * Returns a new object of class '<em>Midi File</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Midi File</em>'.
   * @generated
   */
	MidiFile createMidiFile();

	/**
   * Returns a new object of class '<em>Text Presentation Event</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Text Presentation Event</em>'.
   * @generated
   */
	TextPresentationEvent createTextPresentationEvent();

	/**
   * Returns a new object of class '<em>Midi File Part</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Midi File Part</em>'.
   * @generated
   */
	MidiFilePart createMidiFilePart();

	/**
   * Returns a new object of class '<em>Midi File Text Line</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Midi File Text Line</em>'.
   * @generated
   */
	MidiFileTextLine createMidiFileTextLine();

	/**
   * Returns a new object of class '<em>Gallery</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Gallery</em>'.
   * @generated
   */
	Gallery createGallery();

	/**
   * Returns a new object of class '<em>Midi Player Root</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Midi Player Root</em>'.
   * @generated
   */
	MidiPlayerRoot createMidiPlayerRoot();

	/**
   * Returns a new object of class '<em>Midi File Chord Part</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Midi File Chord Part</em>'.
   * @generated
   */
	MidiFileChordPart createMidiFileChordPart();

	/**
   * Returns a new object of class '<em>Configuration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Configuration</em>'.
   * @generated
   */
  Configuration createConfiguration();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
	MidiplayerPackage getMidiplayerPackage();

} //MidiplayerFactory
