/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package mda;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Midi File Text Line</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link mda.MidiFileTextLine#getChordParts <em>Chord Parts</em>}</li>
 *   <li>{@link mda.MidiFileTextLine#isNewSlide <em>New Slide</em>}</li>
 * </ul>
 * </p>
 *
 * @see mda.MidiplayerPackage#getMidiFileTextLine()
 * @model
 * @generated
 */
public interface MidiFileTextLine extends EObject {
	/**
	 * Returns the value of the '<em><b>Chord Parts</b></em>' containment reference list.
	 * The list contents are of type {@link mda.MidiFileChordPart}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Chord Parts</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Chord Parts</em>' containment reference list.
	 * @see mda.MidiplayerPackage#getMidiFileTextLine_ChordParts()
	 * @model containment="true"
	 * @generated
	 */
	EList<MidiFileChordPart> getChordParts();

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
	 * @see mda.MidiplayerPackage#getMidiFileTextLine_NewSlide()
	 * @model
	 * @generated
	 */
  boolean isNewSlide();

  /**
	 * Sets the value of the '{@link mda.MidiFileTextLine#isNewSlide <em>New Slide</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Slide</em>' attribute.
	 * @see #isNewSlide()
	 * @generated
	 */
  void setNewSlide(boolean value);

} // MidiFileTextLine
