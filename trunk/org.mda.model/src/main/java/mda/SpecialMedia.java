/**
 */
package mda;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Special Media</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link mda.SpecialMedia#getKey <em>Key</em>}</li>
 * </ul>
 * </p>
 *
 * @see mda.MidiplayerPackage#getSpecialMedia()
 * @model
 * @generated
 */
public interface SpecialMedia extends AbstractSessionItem {
	/**
	 * Returns the value of the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key</em>' attribute.
	 * @see #setKey(String)
	 * @see mda.MidiplayerPackage#getSpecialMedia_Key()
	 * @model
	 * @generated
	 */
	String getKey();

	/**
	 * Sets the value of the '{@link mda.SpecialMedia#getKey <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key</em>' attribute.
	 * @see #getKey()
	 * @generated
	 */
	void setKey(String value);

} // SpecialMedia
