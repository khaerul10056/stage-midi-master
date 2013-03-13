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
	 * Returns a new object of class '<em>Song</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Song</em>'.
	 * @generated
	 */
	Song createSong();

	/**
	 * Returns a new object of class '<em>Song Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Song Part</em>'.
	 * @generated
	 */
	SongPart createSongPart();

	/**
	 * Returns a new object of class '<em>Song Text Line</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Song Text Line</em>'.
	 * @generated
	 */
	SongTextLine createSongTextLine();

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
	 * Returns a new object of class '<em>Song Chord Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Song Chord Part</em>'.
	 * @generated
	 */
	SongChordPart createSongChordPart();

	/**
	 * Returns a new object of class '<em>Configuration</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Configuration</em>'.
	 * @generated
	 */
  Configuration createConfiguration();

  /**
	 * Returns a new object of class '<em>User</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>User</em>'.
	 * @generated
	 */
  User createUser();

  /**
	 * Returns a new object of class '<em>Copyright</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Copyright</em>'.
	 * @generated
	 */
  Copyright createCopyright();

  /**
	 * Returns a new object of class '<em>Presentation Scheme</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Presentation Scheme</em>'.
	 * @generated
	 */
  PresentationScheme createPresentationScheme();

  /**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	MidiplayerPackage getMidiplayerPackage();

} //MidiplayerFactory
