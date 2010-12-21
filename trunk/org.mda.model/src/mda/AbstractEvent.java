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
 * A representation of the model object '<em><b>Abstract Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link mda.AbstractEvent#getAtBar <em>At Bar</em>}</li>
 * </ul>
 * </p>
 *
 * @see mda.MidiplayerPackage#getAbstractEvent()
 * @model abstract="true"
 * @generated
 */
public interface AbstractEvent extends EObject {
	/**
	 * Returns the value of the '<em><b>At Bar</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>At Bar</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>At Bar</em>' attribute.
	 * @see #setAtBar(int)
	 * @see mda.MidiplayerPackage#getAbstractEvent_AtBar()
	 * @model
	 * @generated
	 */
	int getAtBar();

	/**
	 * Sets the value of the '{@link mda.AbstractEvent#getAtBar <em>At Bar</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>At Bar</em>' attribute.
	 * @see #getAtBar()
	 * @generated
	 */
	void setAtBar(int value);

} // AbstractEvent
