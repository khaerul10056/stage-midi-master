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
 * A representation of the model object '<em><b>Midi File Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link mda.MidiFilePart#getTextlines <em>Textlines</em>}</li>
 *   <li>{@link mda.MidiFilePart#getParttype <em>Parttype</em>}</li>
 *   <li>{@link mda.MidiFilePart#getBar <em>Bar</em>}</li>
 *   <li>{@link mda.MidiFilePart#getRefPart <em>Ref Part</em>}</li>
 * </ul>
 * </p>
 *
 * @see mda.MidiplayerPackage#getMidiFilePart()
 * @model
 * @generated
 */
public interface MidiFilePart extends EObject {
	/**
   * Returns the value of the '<em><b>Textlines</b></em>' containment reference list.
   * The list contents are of type {@link mda.MidiFileTextLine}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Textlines</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Textlines</em>' containment reference list.
   * @see mda.MidiplayerPackage#getMidiFilePart_Textlines()
   * @model containment="true"
   * @generated
   */
	EList<MidiFileTextLine> getTextlines();

	/**
   * Returns the value of the '<em><b>Parttype</b></em>' attribute.
   * The literals are from the enumeration {@link mda.MidiFilePartType}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parttype</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Parttype</em>' attribute.
   * @see mda.MidiFilePartType
   * @see #setParttype(MidiFilePartType)
   * @see mda.MidiplayerPackage#getMidiFilePart_Parttype()
   * @model
   * @generated
   */
	MidiFilePartType getParttype();

	/**
   * Sets the value of the '{@link mda.MidiFilePart#getParttype <em>Parttype</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Parttype</em>' attribute.
   * @see mda.MidiFilePartType
   * @see #getParttype()
   * @generated
   */
	void setParttype(MidiFilePartType value);

  /**
   * Returns the value of the '<em><b>Bar</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Bar</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Bar</em>' attribute.
   * @see #setBar(int)
   * @see mda.MidiplayerPackage#getMidiFilePart_Bar()
   * @model
   * @generated
   */
  int getBar();

  /**
   * Sets the value of the '{@link mda.MidiFilePart#getBar <em>Bar</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Bar</em>' attribute.
   * @see #getBar()
   * @generated
   */
  void setBar(int value);

  /**
   * Returns the value of the '<em><b>Ref Part</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ref Part</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref Part</em>' reference.
   * @see #setRefPart(MidiFilePart)
   * @see mda.MidiplayerPackage#getMidiFilePart_RefPart()
   * @model
   * @generated
   */
  MidiFilePart getRefPart();

  /**
   * Sets the value of the '{@link mda.MidiFilePart#getRefPart <em>Ref Part</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref Part</em>' reference.
   * @see #getRefPart()
   * @generated
   */
  void setRefPart(MidiFilePart value);

} // MidiFilePart
