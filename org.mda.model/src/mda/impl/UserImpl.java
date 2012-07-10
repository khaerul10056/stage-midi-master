/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package mda.impl;

import java.util.Collection;
import mda.MidiplayerPackage;
import mda.PresentationScheme;
import mda.User;
import mda.UserType;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>User</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link mda.impl.UserImpl#getMail <em>Mail</em>}</li>
 *   <li>{@link mda.impl.UserImpl#getName <em>Name</em>}</li>
 *   <li>{@link mda.impl.UserImpl#getFirstname <em>Firstname</em>}</li>
 *   <li>{@link mda.impl.UserImpl#getType <em>Type</em>}</li>
 *   <li>{@link mda.impl.UserImpl#isSendSongbook <em>Send Songbook</em>}</li>
 *   <li>{@link mda.impl.UserImpl#getPresentationschemes <em>Presentationschemes</em>}</li>
 *   <li>{@link mda.impl.UserImpl#getDefaultPresentationType <em>Default Presentation Type</em>}</li>
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
   * The default value of the '{@link #isSendSongbook() <em>Send Songbook</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSendSongbook()
   * @generated
   * @ordered
   */
  protected static final boolean SEND_SONGBOOK_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isSendSongbook() <em>Send Songbook</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSendSongbook()
   * @generated
   * @ordered
   */
  protected boolean sendSongbook = SEND_SONGBOOK_EDEFAULT;

  /**
   * The cached value of the '{@link #getPresentationschemes() <em>Presentationschemes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPresentationschemes()
   * @generated
   * @ordered
   */
  protected EList<PresentationScheme> presentationschemes;

  /**
   * The default value of the '{@link #getDefaultPresentationType() <em>Default Presentation Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefaultPresentationType()
   * @generated
   * @ordered
   */
  protected static final String DEFAULT_PRESENTATION_TYPE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDefaultPresentationType() <em>Default Presentation Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefaultPresentationType()
   * @generated
   * @ordered
   */
  protected String defaultPresentationType = DEFAULT_PRESENTATION_TYPE_EDEFAULT;

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
  public boolean isSendSongbook() {
    return sendSongbook;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSendSongbook(boolean newSendSongbook) {
    boolean oldSendSongbook = sendSongbook;
    sendSongbook = newSendSongbook;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.USER__SEND_SONGBOOK, oldSendSongbook, sendSongbook));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<PresentationScheme> getPresentationschemes() {
    if (presentationschemes == null) {
      presentationschemes = new EObjectContainmentEList<PresentationScheme>(PresentationScheme.class, this, MidiplayerPackage.USER__PRESENTATIONSCHEMES);
    }
    return presentationschemes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDefaultPresentationType() {
    return defaultPresentationType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDefaultPresentationType(String newDefaultPresentationType) {
    String oldDefaultPresentationType = defaultPresentationType;
    defaultPresentationType = newDefaultPresentationType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.USER__DEFAULT_PRESENTATION_TYPE, oldDefaultPresentationType, defaultPresentationType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case MidiplayerPackage.USER__PRESENTATIONSCHEMES:
        return ((InternalEList<?>)getPresentationschemes()).basicRemove(otherEnd, msgs);
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
      case MidiplayerPackage.USER__NAME:
        return getName();
      case MidiplayerPackage.USER__FIRSTNAME:
        return getFirstname();
      case MidiplayerPackage.USER__TYPE:
        return getType();
      case MidiplayerPackage.USER__SEND_SONGBOOK:
        return isSendSongbook();
      case MidiplayerPackage.USER__PRESENTATIONSCHEMES:
        return getPresentationschemes();
      case MidiplayerPackage.USER__DEFAULT_PRESENTATION_TYPE:
        return getDefaultPresentationType();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case MidiplayerPackage.USER__MAIL:
        setMail((String)newValue);
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
      case MidiplayerPackage.USER__SEND_SONGBOOK:
        setSendSongbook((Boolean)newValue);
        return;
      case MidiplayerPackage.USER__PRESENTATIONSCHEMES:
        getPresentationschemes().clear();
        getPresentationschemes().addAll((Collection<? extends PresentationScheme>)newValue);
        return;
      case MidiplayerPackage.USER__DEFAULT_PRESENTATION_TYPE:
        setDefaultPresentationType((String)newValue);
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
      case MidiplayerPackage.USER__NAME:
        setName(NAME_EDEFAULT);
        return;
      case MidiplayerPackage.USER__FIRSTNAME:
        setFirstname(FIRSTNAME_EDEFAULT);
        return;
      case MidiplayerPackage.USER__TYPE:
        setType(TYPE_EDEFAULT);
        return;
      case MidiplayerPackage.USER__SEND_SONGBOOK:
        setSendSongbook(SEND_SONGBOOK_EDEFAULT);
        return;
      case MidiplayerPackage.USER__PRESENTATIONSCHEMES:
        getPresentationschemes().clear();
        return;
      case MidiplayerPackage.USER__DEFAULT_PRESENTATION_TYPE:
        setDefaultPresentationType(DEFAULT_PRESENTATION_TYPE_EDEFAULT);
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
      case MidiplayerPackage.USER__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case MidiplayerPackage.USER__FIRSTNAME:
        return FIRSTNAME_EDEFAULT == null ? firstname != null : !FIRSTNAME_EDEFAULT.equals(firstname);
      case MidiplayerPackage.USER__TYPE:
        return type != TYPE_EDEFAULT;
      case MidiplayerPackage.USER__SEND_SONGBOOK:
        return sendSongbook != SEND_SONGBOOK_EDEFAULT;
      case MidiplayerPackage.USER__PRESENTATIONSCHEMES:
        return presentationschemes != null && !presentationschemes.isEmpty();
      case MidiplayerPackage.USER__DEFAULT_PRESENTATION_TYPE:
        return DEFAULT_PRESENTATION_TYPE_EDEFAULT == null ? defaultPresentationType != null : !DEFAULT_PRESENTATION_TYPE_EDEFAULT.equals(defaultPresentationType);
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
    result.append(", sendSongbook: ");
    result.append(sendSongbook);
    result.append(", defaultPresentationType: ");
    result.append(defaultPresentationType);
    result.append(')');
    return result.toString();
  }

} //UserImpl
