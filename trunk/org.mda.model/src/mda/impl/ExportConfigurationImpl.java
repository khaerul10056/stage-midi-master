/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package mda.impl;

import mda.ExportConfiguration;
import mda.MidiplayerPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Export Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link mda.impl.ExportConfigurationImpl#isWithChords <em>With Chords</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExportConfigurationImpl extends EObjectImpl implements ExportConfiguration {
  /**
   * The default value of the '{@link #isWithChords() <em>With Chords</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isWithChords()
   * @generated
   * @ordered
   */
  protected static final boolean WITH_CHORDS_EDEFAULT = false;
  /**
   * The cached value of the '{@link #isWithChords() <em>With Chords</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isWithChords()
   * @generated
   * @ordered
   */
  protected boolean withChords = WITH_CHORDS_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExportConfigurationImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return MidiplayerPackage.Literals.EXPORT_CONFIGURATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isWithChords() {
    return withChords;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setWithChords(boolean newWithChords) {
    boolean oldWithChords = withChords;
    withChords = newWithChords;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.EXPORT_CONFIGURATION__WITH_CHORDS, oldWithChords, withChords));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case MidiplayerPackage.EXPORT_CONFIGURATION__WITH_CHORDS:
        return isWithChords();
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
      case MidiplayerPackage.EXPORT_CONFIGURATION__WITH_CHORDS:
        setWithChords((Boolean)newValue);
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
      case MidiplayerPackage.EXPORT_CONFIGURATION__WITH_CHORDS:
        setWithChords(WITH_CHORDS_EDEFAULT);
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
      case MidiplayerPackage.EXPORT_CONFIGURATION__WITH_CHORDS:
        return withChords != WITH_CHORDS_EDEFAULT;
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
    result.append(" (withChords: ");
    result.append(withChords);
    result.append(')');
    return result.toString();
  }

} //ExportConfigurationImpl
