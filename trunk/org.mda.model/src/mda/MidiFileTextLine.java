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

} // MidiFileTextLine
