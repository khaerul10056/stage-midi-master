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
 * A representation of the model object '<em><b>Midi Player Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link mda.MidiPlayerRoot#getGallery <em>Gallery</em>}</li>
 *   <li>{@link mda.MidiPlayerRoot#getSessions <em>Sessions</em>}</li>
 *   <li>{@link mda.MidiPlayerRoot#getConfig <em>Config</em>}</li>
 * </ul>
 * </p>
 *
 * @see mda.MidiplayerPackage#getMidiPlayerRoot()
 * @model
 * @generated
 */
public interface MidiPlayerRoot extends EObject {
	/**
   * Returns the value of the '<em><b>Gallery</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gallery</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Gallery</em>' containment reference.
   * @see #setGallery(Gallery)
   * @see mda.MidiplayerPackage#getMidiPlayerRoot_Gallery()
   * @model containment="true"
   * @generated
   */
	Gallery getGallery();

	/**
   * Sets the value of the '{@link mda.MidiPlayerRoot#getGallery <em>Gallery</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Gallery</em>' containment reference.
   * @see #getGallery()
   * @generated
   */
	void setGallery(Gallery value);

	/**
   * Returns the value of the '<em><b>Sessions</b></em>' containment reference list.
   * The list contents are of type {@link mda.Session}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sessions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Sessions</em>' containment reference list.
   * @see mda.MidiplayerPackage#getMidiPlayerRoot_Sessions()
   * @model containment="true"
   * @generated
   */
	EList<Session> getSessions();

  /**
   * Returns the value of the '<em><b>Config</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Config</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Config</em>' containment reference.
   * @see #setConfig(Configuration)
   * @see mda.MidiplayerPackage#getMidiPlayerRoot_Config()
   * @model containment="true"
   * @generated
   */
  Configuration getConfig();

  /**
   * Sets the value of the '{@link mda.MidiPlayerRoot#getConfig <em>Config</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Config</em>' containment reference.
   * @see #getConfig()
   * @generated
   */
  void setConfig(Configuration value);

} // MidiPlayerRoot
