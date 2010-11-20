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
 * A representation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link mda.Configuration#getScreenIDPresentation <em>Screen ID Presentation</em>}</li>
 *   <li>{@link mda.Configuration#getScreenIDAdmin <em>Screen ID Admin</em>}</li>
 *   <li>{@link mda.Configuration#getLastSession <em>Last Session</em>}</li>
 * </ul>
 * </p>
 *
 * @see mda.MidiplayerPackage#getConfiguration()
 * @model
 * @generated
 */
public interface Configuration extends EObject {
  /**
   * Returns the value of the '<em><b>Screen ID Presentation</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Screen ID Presentation</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Screen ID Presentation</em>' attribute.
   * @see #setScreenIDPresentation(String)
   * @see mda.MidiplayerPackage#getConfiguration_ScreenIDPresentation()
   * @model
   * @generated
   */
  String getScreenIDPresentation();

  /**
   * Sets the value of the '{@link mda.Configuration#getScreenIDPresentation <em>Screen ID Presentation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Screen ID Presentation</em>' attribute.
   * @see #getScreenIDPresentation()
   * @generated
   */
  void setScreenIDPresentation(String value);

  /**
   * Returns the value of the '<em><b>Screen ID Admin</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Screen ID Admin</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Screen ID Admin</em>' attribute.
   * @see #setScreenIDAdmin(String)
   * @see mda.MidiplayerPackage#getConfiguration_ScreenIDAdmin()
   * @model
   * @generated
   */
  String getScreenIDAdmin();

  /**
   * Sets the value of the '{@link mda.Configuration#getScreenIDAdmin <em>Screen ID Admin</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Screen ID Admin</em>' attribute.
   * @see #getScreenIDAdmin()
   * @generated
   */
  void setScreenIDAdmin(String value);

  /**
   * Returns the value of the '<em><b>Last Session</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Last Session</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Last Session</em>' reference.
   * @see #setLastSession(Session)
   * @see mda.MidiplayerPackage#getConfiguration_LastSession()
   * @model
   * @generated
   */
  Session getLastSession();

  /**
   * Sets the value of the '{@link mda.Configuration#getLastSession <em>Last Session</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Last Session</em>' reference.
   * @see #getLastSession()
   * @generated
   */
  void setLastSession(Session value);

} // Configuration
