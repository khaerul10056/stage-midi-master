/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package mda;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Midi File Chord Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link mda.MidiFileChordPart#getText <em>Text</em>}</li>
 *   <li>{@link mda.MidiFileChordPart#getChord <em>Chord</em>}</li>
 * </ul>
 * </p>
 *
 * @see mda.MidiplayerPackage#getMidiFileChordPart()
 * @model
 * @generated
 */
public interface MidiFileChordPart extends EObject {
	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see mda.MidiplayerPackage#getMidiFileChordPart_Text()
	 * @model
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link mda.MidiFileChordPart#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

	/**
	 * Returns the value of the '<em><b>Chord</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Chord</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Chord</em>' attribute.
	 * @see #setChord(String)
	 * @see mda.MidiplayerPackage#getMidiFileChordPart_Chord()
	 * @model unique="false"
	 * @generated
	 */
	String getChord();

	/**
	 * Sets the value of the '{@link mda.MidiFileChordPart#getChord <em>Chord</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Chord</em>' attribute.
	 * @see #getChord()
	 * @generated
	 */
	void setChord(String value);

} // MidiFileChordPart
