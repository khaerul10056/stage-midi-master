/**
 */
package mda;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Song</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link mda.Song#getParts <em>Parts</em>}</li>
 *   <li>{@link mda.Song#getPic <em>Pic</em>}</li>
 *   <li>{@link mda.Song#getKey <em>Key</em>}</li>
 *   <li>{@link mda.Song#getCopyright <em>Copyright</em>}</li>
 *   <li>{@link mda.Song#getMidicontrol <em>Midicontrol</em>}</li>
 * </ul>
 * </p>
 *
 * @see mda.MidiplayerPackage#getSong()
 * @model
 * @generated
 */
public interface Song extends AbstractSessionItem {
	/**
	 * Returns the value of the '<em><b>Parts</b></em>' containment reference list.
	 * The list contents are of type {@link mda.SongPart}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parts</em>' containment reference list.
	 * @see mda.MidiplayerPackage#getSong_Parts()
	 * @model containment="true"
	 * @generated
	 */
	EList<SongPart> getParts();

	/**
	 * Returns the value of the '<em><b>Pic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pic</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pic</em>' attribute.
	 * @see #setPic(String)
	 * @see mda.MidiplayerPackage#getSong_Pic()
	 * @model
	 * @generated
	 */
	String getPic();

	/**
	 * Sets the value of the '{@link mda.Song#getPic <em>Pic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pic</em>' attribute.
	 * @see #getPic()
	 * @generated
	 */
	void setPic(String value);

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
	 * @see mda.MidiplayerPackage#getSong_Key()
	 * @model
	 * @generated
	 */
	String getKey();

	/**
	 * Sets the value of the '{@link mda.Song#getKey <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key</em>' attribute.
	 * @see #getKey()
	 * @generated
	 */
	void setKey(String value);

	/**
	 * Returns the value of the '<em><b>Copyright</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Copyright</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Copyright</em>' containment reference.
	 * @see #setCopyright(Copyright)
	 * @see mda.MidiplayerPackage#getSong_Copyright()
	 * @model containment="true"
	 * @generated
	 */
	Copyright getCopyright();

	/**
	 * Sets the value of the '{@link mda.Song#getCopyright <em>Copyright</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Copyright</em>' containment reference.
	 * @see #getCopyright()
	 * @generated
	 */
	void setCopyright(Copyright value);

	/**
	 * Returns the value of the '<em><b>Midicontrol</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Midicontrol</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Midicontrol</em>' attribute.
	 * @see #setMidicontrol(int)
	 * @see mda.MidiplayerPackage#getSong_Midicontrol()
	 * @model default="-1"
	 * @generated
	 */
	int getMidicontrol();

	/**
	 * Sets the value of the '{@link mda.Song#getMidicontrol <em>Midicontrol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Midicontrol</em>' attribute.
	 * @see #getMidicontrol()
	 * @generated
	 */
	void setMidicontrol(int value);

} // Song
