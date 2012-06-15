/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package mda;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Midi File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link mda.MidiFile#getParts <em>Parts</em>}</li>
 *   <li>{@link mda.MidiFile#getPic <em>Pic</em>}</li>
 *   <li>{@link mda.MidiFile#getKey <em>Key</em>}</li>
 *   <li>{@link mda.MidiFile#getCopyright <em>Copyright</em>}</li>
 * </ul>
 * </p>
 *
 * @see mda.MidiplayerPackage#getMidiFile()
 * @model
 * @generated
 */
public interface MidiFile extends AbstractSessionItem {
	/**
   * Returns the value of the '<em><b>Parts</b></em>' containment reference list.
   * The list contents are of type {@link mda.MidiFilePart}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parts</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parts</em>' containment reference list.
   * @see mda.MidiplayerPackage#getMidiFile_Parts()
   * @model containment="true"
   * @generated
   */
  EList<MidiFilePart> getParts();

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
   * @see mda.MidiplayerPackage#getMidiFile_Pic()
   * @model
   * @generated
   */
  String getPic();

  /**
   * Sets the value of the '{@link mda.MidiFile#getPic <em>Pic</em>}' attribute.
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
   * @see mda.MidiplayerPackage#getMidiFile_Key()
   * @model
   * @generated
   */
	String getKey();

		/**
   * Sets the value of the '{@link mda.MidiFile#getKey <em>Key</em>}' attribute.
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
   * @see mda.MidiplayerPackage#getMidiFile_Copyright()
   * @model containment="true"
   * @generated
   */
  Copyright getCopyright();

    /**
   * Sets the value of the '{@link mda.MidiFile#getCopyright <em>Copyright</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Copyright</em>' containment reference.
   * @see #getCopyright()
   * @generated
   */
  void setCopyright(Copyright value);

} // MidiFile
