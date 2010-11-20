/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package mda.impl;

import mda.AbstractEvent;
import mda.MidiplayerPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link mda.impl.AbstractEventImpl#getAtBar <em>At Bar</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractEventImpl extends EObjectImpl implements AbstractEvent {
	/**
   * The default value of the '{@link #getAtBar() <em>At Bar</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getAtBar()
   * @generated
   * @ordered
   */
	protected static final int AT_BAR_EDEFAULT = 0;

	/**
   * The cached value of the '{@link #getAtBar() <em>At Bar</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getAtBar()
   * @generated
   * @ordered
   */
	protected int atBar = AT_BAR_EDEFAULT;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected AbstractEventImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return MidiplayerPackage.Literals.ABSTRACT_EVENT;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public int getAtBar() {
    return atBar;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setAtBar(int newAtBar) {
    int oldAtBar = atBar;
    atBar = newAtBar;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.ABSTRACT_EVENT__AT_BAR, oldAtBar, atBar));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case MidiplayerPackage.ABSTRACT_EVENT__AT_BAR:
        return getAtBar();
    }
    return super.eGet(featureID, resolve, coreType);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case MidiplayerPackage.ABSTRACT_EVENT__AT_BAR:
        setAtBar((Integer)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public void eUnset(int featureID) {
    switch (featureID) {
      case MidiplayerPackage.ABSTRACT_EVENT__AT_BAR:
        setAtBar(AT_BAR_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public boolean eIsSet(int featureID) {
    switch (featureID) {
      case MidiplayerPackage.ABSTRACT_EVENT__AT_BAR:
        return atBar != AT_BAR_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (atBar: ");
    result.append(atBar);
    result.append(')');
    return result.toString();
  }

} //AbstractEventImpl
