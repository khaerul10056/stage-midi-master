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
 * A representation of the model object '<em><b>Abstract Session Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link mda.AbstractSessionItem#getName <em>Name</em>}</li>
 *   <li>{@link mda.AbstractSessionItem#getPath <em>Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see mda.MidiplayerPackage#getAbstractSessionItem()
 * @model abstract="true"
 * @generated
 */
public interface AbstractSessionItem extends EObject {
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
   * @see mda.MidiplayerPackage#getAbstractSessionItem_Name()
   * @model
   * @generated
   */
	String getName();

	/**
   * Sets the value of the '{@link mda.AbstractSessionItem#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
	void setName(String value);

	/**
   * Returns the value of the '<em><b>Path</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Path</em>' attribute.
   * @see #setPath(String)
   * @see mda.MidiplayerPackage#getAbstractSessionItem_Path()
   * @model
   * @generated
   */
	String getPath();

	/**
   * Sets the value of the '{@link mda.AbstractSessionItem#getPath <em>Path</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Path</em>' attribute.
   * @see #getPath()
   * @generated
   */
	void setPath(String value);

} // AbstractSessionItem
