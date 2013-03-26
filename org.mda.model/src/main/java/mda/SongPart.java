/**
 */
package mda;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Song Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link mda.SongPart#getTextlines <em>Textlines</em>}</li>
 *   <li>{@link mda.SongPart#getParttype <em>Parttype</em>}</li>
 *   <li>{@link mda.SongPart#getBar <em>Bar</em>}</li>
 *   <li>{@link mda.SongPart#getRefPart <em>Ref Part</em>}</li>
 *   <li>{@link mda.SongPart#getPosition <em>Position</em>}</li>
 * </ul>
 * </p>
 *
 * @see mda.MidiplayerPackage#getSongPart()
 * @model
 * @generated
 */
public interface SongPart extends EObject {
	/**
	 * Returns the value of the '<em><b>Textlines</b></em>' containment reference list.
	 * The list contents are of type {@link mda.SongTextLine}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Textlines</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Textlines</em>' containment reference list.
	 * @see mda.MidiplayerPackage#getSongPart_Textlines()
	 * @model containment="true"
	 * @generated
	 */
	EList<SongTextLine> getTextlines();

	/**
	 * Returns the value of the '<em><b>Parttype</b></em>' attribute.
	 * The literals are from the enumeration {@link mda.SongPartType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parttype</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parttype</em>' attribute.
	 * @see mda.SongPartType
	 * @see #setParttype(SongPartType)
	 * @see mda.MidiplayerPackage#getSongPart_Parttype()
	 * @model
	 * @generated
	 */
	SongPartType getParttype();

	/**
	 * Sets the value of the '{@link mda.SongPart#getParttype <em>Parttype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parttype</em>' attribute.
	 * @see mda.SongPartType
	 * @see #getParttype()
	 * @generated
	 */
	void setParttype(SongPartType value);

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
	 * @see mda.MidiplayerPackage#getSongPart_Bar()
	 * @model
	 * @generated
	 */
	int getBar();

	/**
	 * Sets the value of the '{@link mda.SongPart#getBar <em>Bar</em>}' attribute.
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
	 * @see #setRefPart(SongPart)
	 * @see mda.MidiplayerPackage#getSongPart_RefPart()
	 * @model
	 * @generated
	 */
	SongPart getRefPart();

	/**
	 * Sets the value of the '{@link mda.SongPart#getRefPart <em>Ref Part</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref Part</em>' reference.
	 * @see #getRefPart()
	 * @generated
	 */
	void setRefPart(SongPart value);

	/**
	 * Returns the value of the '<em><b>Position</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Position</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Position</em>' attribute.
	 * @see #setPosition(String)
	 * @see mda.MidiplayerPackage#getSongPart_Position()
	 * @model default=""
	 * @generated
	 */
	String getPosition();

	/**
	 * Sets the value of the '{@link mda.SongPart#getPosition <em>Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Position</em>' attribute.
	 * @see #getPosition()
	 * @generated
	 */
	void setPosition(String value);

} // SongPart
