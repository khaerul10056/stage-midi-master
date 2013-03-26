/**
 */
package mda;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Song Text Line</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link mda.SongTextLine#getChordParts <em>Chord Parts</em>}</li>
 *   <li>{@link mda.SongTextLine#isNewSlide <em>New Slide</em>}</li>
 * </ul>
 * </p>
 *
 * @see mda.MidiplayerPackage#getSongTextLine()
 * @model
 * @generated
 */
public interface SongTextLine extends EObject {
	/**
	 * Returns the value of the '<em><b>Chord Parts</b></em>' containment reference list.
	 * The list contents are of type {@link mda.SongChordPart}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Chord Parts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Chord Parts</em>' containment reference list.
	 * @see mda.MidiplayerPackage#getSongTextLine_ChordParts()
	 * @model containment="true"
	 * @generated
	 */
	EList<SongChordPart> getChordParts();

	/**
	 * Returns the value of the '<em><b>New Slide</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Slide</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Slide</em>' attribute.
	 * @see #setNewSlide(boolean)
	 * @see mda.MidiplayerPackage#getSongTextLine_NewSlide()
	 * @model
	 * @generated
	 */
	boolean isNewSlide();

	/**
	 * Sets the value of the '{@link mda.SongTextLine#isNewSlide <em>New Slide</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Slide</em>' attribute.
	 * @see #isNewSlide()
	 * @generated
	 */
	void setNewSlide(boolean value);

} // SongTextLine
