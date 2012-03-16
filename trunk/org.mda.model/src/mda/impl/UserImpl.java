/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package mda.impl;

import mda.ExportConfiguration;
import mda.MidiplayerPackage;
import mda.User;

import mda.UserType;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>User</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link mda.impl.UserImpl#getMail <em>Mail</em>}</li>
 *   <li>{@link mda.impl.UserImpl#getExportConfiguration <em>Export Configuration</em>}</li>
 *   <li>{@link mda.impl.UserImpl#getName <em>Name</em>}</li>
 *   <li>{@link mda.impl.UserImpl#getFirstname <em>Firstname</em>}</li>
 *   <li>{@link mda.impl.UserImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UserImpl extends EObjectImpl implements User {
  /**
   * The default value of the '{@link #getMail() <em>Mail</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMail()
   * @generated
   * @ordered
   */
  protected static final String MAIL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getMail() <em>Mail</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMail()
   * @generated
   * @ordered
   */
  protected String mail = MAIL_EDEFAULT;

  /**
   * The cached value of the '{@link #getExportConfiguration() <em>Export Configuration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExportConfiguration()
   * @generated
   * @ordered
   */
  protected ExportConfiguration exportConfiguration;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getFirstname() <em>Firstname</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFirstname()
   * @generated
   * @ordered
   */
  protected static final String FIRSTNAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFirstname() <em>Firstname</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFirstname()
   * @generated
   * @ordered
   */
  protected String firstname = FIRSTNAME_EDEFAULT;

  /**
   * The default value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected static final UserType TYPE_EDEFAULT = UserType.MEMBER;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected UserType type = TYPE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UserImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return MidiplayerPackage.Literals.USER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getMail() {
    return mail;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMail(String newMail) {
    String oldMail = mail;
    mail = newMail;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.USER__MAIL, oldMail, mail));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExportConfiguration getExportConfiguration() {
    return exportConfiguration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExportConfiguration(ExportConfiguration newExportConfiguration, NotificationChain msgs) {
    ExportConfiguration oldExportConfiguration = exportConfiguration;
    exportConfiguration = newExportConfiguration;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MidiplayerPackage.USER__EXPORT_CONFIGURATION, oldExportConfiguration, newExportConfiguration);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExportConfiguration(ExportConfiguration newExportConfiguration) {
    if (newExportConfiguration != exportConfiguration) {
      NotificationChain msgs = null;
      if (exportConfiguration != null)
        msgs = ((InternalEObject)exportConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MidiplayerPackage.USER__EXPORT_CONFIGURATION, null, msgs);
      if (newExportConfiguration != null)
        msgs = ((InternalEObject)newExportConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MidiplayerPackage.USER__EXPORT_CONFIGURATION, null, msgs);
      msgs = basicSetExportConfiguration(newExportConfiguration, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.USER__EXPORT_CONFIGURATION, newExportConfiguration, newExportConfiguration));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName() {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName) {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.USER__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getFirstname() {
    return firstname;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFirstname(String newFirstname) {
    String oldFirstname = firstname;
    firstname = newFirstname;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.USER__FIRSTNAME, oldFirstname, firstname));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UserType getType() {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(UserType newType) {
    UserType oldType = type;
    type = newType == null ? TYPE_EDEFAULT : newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.USER__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case MidiplayerPackage.USER__EXPORT_CONFIGURATION:
        return basicSetExportConfiguration(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case MidiplayerPackage.USER__MAIL:
        return getMail();
      case MidiplayerPackage.USER__EXPORT_CONFIGURATION:
        return getExportConfiguration();
      case MidiplayerPackage.USER__NAME:
        return getName();
      case MidiplayerPackage.USER__FIRSTNAME:
        return getFirstname();
      case MidiplayerPackage.USER__TYPE:
        return getType();
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
      case MidiplayerPackage.USER__MAIL:
        setMail((String)newValue);
        return;
      case MidiplayerPackage.USER__EXPORT_CONFIGURATION:
        setExportConfiguration((ExportConfiguration)newValue);
        return;
      case MidiplayerPackage.USER__NAME:
        setName((String)newValue);
        return;
      case MidiplayerPackage.USER__FIRSTNAME:
        setFirstname((String)newValue);
        return;
      case MidiplayerPackage.USER__TYPE:
        setType((UserType)newValue);
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
      case MidiplayerPackage.USER__MAIL:
        setMail(MAIL_EDEFAULT);
        return;
      case MidiplayerPackage.USER__EXPORT_CONFIGURATION:
        setExportConfiguration((ExportConfiguration)null);
        return;
      case MidiplayerPackage.USER__NAME:
        setName(NAME_EDEFAULT);
        return;
      case MidiplayerPackage.USER__FIRSTNAME:
        setFirstname(FIRSTNAME_EDEFAULT);
        return;
      case MidiplayerPackage.USER__TYPE:
        setType(TYPE_EDEFAULT);
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
      case MidiplayerPackage.USER__MAIL:
        return MAIL_EDEFAULT == null ? mail != null : !MAIL_EDEFAULT.equals(mail);
      case MidiplayerPackage.USER__EXPORT_CONFIGURATION:
        return exportConfiguration != null;
      case MidiplayerPackage.USER__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case MidiplayerPackage.USER__FIRSTNAME:
        return FIRSTNAME_EDEFAULT == null ? firstname != null : !FIRSTNAME_EDEFAULT.equals(firstname);
      case MidiplayerPackage.USER__TYPE:
        return type != TYPE_EDEFAULT;
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
    result.append(" (mail: ");
    result.append(mail);
    result.append(", name: ");
    result.append(name);
    result.append(", firstname: ");
    result.append(firstname);
    result.append(", type: ");
    result.append(type);
    result.append(')');
    return result.toString();
  }

} //UserImpl
