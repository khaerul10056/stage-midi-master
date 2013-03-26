/**
 */
package mda;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Session</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link mda.Session#getName <em>Name</em>}</li>
 *   <li>{@link mda.Session#getItems <em>Items</em>}</li>
 *   <li>{@link mda.Session#getDefaultpath <em>Defaultpath</em>}</li>
 * </ul>
 * </p>
 *
 * @see mda.MidiplayerPackage#getSession()
 * @model
 * @generated
 */
public interface Session extends EObject {
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
	 * @see mda.MidiplayerPackage#getSession_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link mda.Session#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Items</b></em>' reference list.
	 * The list contents are of type {@link mda.AbstractSessionItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Items</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Items</em>' reference list.
	 * @see mda.MidiplayerPackage#getSession_Items()
	 * @model
	 * @generated
	 */
	EList<AbstractSessionItem> getItems();

	/**
	 * Returns the value of the '<em><b>Defaultpath</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Defaultpath</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Defaultpath</em>' attribute.
	 * @see #setDefaultpath(String)
	 * @see mda.MidiplayerPackage#getSession_Defaultpath()
	 * @model
	 * @generated
	 */
	String getDefaultpath();

	/**
	 * Sets the value of the '{@link mda.Session#getDefaultpath <em>Defaultpath</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Defaultpath</em>' attribute.
	 * @see #getDefaultpath()
	 * @generated
	 */
	void setDefaultpath(String value);

} // Session
