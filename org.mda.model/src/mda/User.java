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
 * A representation of the model object '<em><b>User</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link mda.User#getMail <em>Mail</em>}</li>
 *   <li>{@link mda.User#getExportConfiguration <em>Export Configuration</em>}</li>
 *   <li>{@link mda.User#getName <em>Name</em>}</li>
 *   <li>{@link mda.User#getFirstname <em>Firstname</em>}</li>
 *   <li>{@link mda.User#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see mda.MidiplayerPackage#getUser()
 * @model
 * @generated
 */
public interface User extends EObject {
  /**
   * Returns the value of the '<em><b>Mail</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mail</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mail</em>' attribute.
   * @see #setMail(String)
   * @see mda.MidiplayerPackage#getUser_Mail()
   * @model
   * @generated
   */
  String getMail();

  /**
   * Sets the value of the '{@link mda.User#getMail <em>Mail</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Mail</em>' attribute.
   * @see #getMail()
   * @generated
   */
  void setMail(String value);

  /**
   * Returns the value of the '<em><b>Export Configuration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Export Configuration</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Export Configuration</em>' containment reference.
   * @see #setExportConfiguration(ExportConfiguration)
   * @see mda.MidiplayerPackage#getUser_ExportConfiguration()
   * @model containment="true"
   * @generated
   */
  ExportConfiguration getExportConfiguration();

  /**
   * Sets the value of the '{@link mda.User#getExportConfiguration <em>Export Configuration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Export Configuration</em>' containment reference.
   * @see #getExportConfiguration()
   * @generated
   */
  void setExportConfiguration(ExportConfiguration value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see mda.MidiplayerPackage#getUser_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link mda.User#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Firstname</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Firstname</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Firstname</em>' attribute.
   * @see #setFirstname(String)
   * @see mda.MidiplayerPackage#getUser_Firstname()
   * @model
   * @generated
   */
  String getFirstname();

  /**
   * Sets the value of the '{@link mda.User#getFirstname <em>Firstname</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Firstname</em>' attribute.
   * @see #getFirstname()
   * @generated
   */
  void setFirstname(String value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * The literals are from the enumeration {@link mda.UserType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see mda.UserType
   * @see #setType(UserType)
   * @see mda.MidiplayerPackage#getUser_Type()
   * @model
   * @generated
   */
  UserType getType();

  /**
   * Sets the value of the '{@link mda.User#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see mda.UserType
   * @see #getType()
   * @generated
   */
  void setType(UserType value);

} // User
