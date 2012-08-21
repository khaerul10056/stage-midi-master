/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package mda.impl;

import mda.AbstractSessionItem;
import mda.MidiplayerPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Session Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link mda.impl.AbstractSessionItemImpl#getName <em>Name</em>}</li>
 *   <li>{@link mda.impl.AbstractSessionItemImpl#getPath <em>Path</em>}</li>
 *   <li>{@link mda.impl.AbstractSessionItemImpl#getBackgroundColor <em>Background Color</em>}</li>
 *   <li>{@link mda.impl.AbstractSessionItemImpl#getForegroundColor <em>Foreground Color</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractSessionItemImpl extends EObjectImpl implements AbstractSessionItem {
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
	 * The default value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected static final String PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected String path = PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getBackgroundColor() <em>Background Color</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getBackgroundColor()
	 * @generated
	 * @ordered
	 */
  protected static final String BACKGROUND_COLOR_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getBackgroundColor() <em>Background Color</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getBackgroundColor()
	 * @generated
	 * @ordered
	 */
  protected String backgroundColor = BACKGROUND_COLOR_EDEFAULT;

  /**
	 * The default value of the '{@link #getForegroundColor() <em>Foreground Color</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getForegroundColor()
	 * @generated
	 * @ordered
	 */
  protected static final String FOREGROUND_COLOR_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getForegroundColor() <em>Foreground Color</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getForegroundColor()
	 * @generated
	 * @ordered
	 */
  protected String foregroundColor = FOREGROUND_COLOR_EDEFAULT;

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractSessionItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MidiplayerPackage.Literals.ABSTRACT_SESSION_ITEM;
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
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.ABSTRACT_SESSION_ITEM__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPath() {
		return path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPath(String newPath) {
		String oldPath = path;
		path = newPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.ABSTRACT_SESSION_ITEM__PATH, oldPath, path));
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getBackgroundColor() {
		return backgroundColor;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setBackgroundColor(String newBackgroundColor) {
		String oldBackgroundColor = backgroundColor;
		backgroundColor = newBackgroundColor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.ABSTRACT_SESSION_ITEM__BACKGROUND_COLOR, oldBackgroundColor, backgroundColor));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getForegroundColor() {
		return foregroundColor;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setForegroundColor(String newForegroundColor) {
		String oldForegroundColor = foregroundColor;
		foregroundColor = newForegroundColor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.ABSTRACT_SESSION_ITEM__FOREGROUND_COLOR, oldForegroundColor, foregroundColor));
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MidiplayerPackage.ABSTRACT_SESSION_ITEM__NAME:
				return getName();
			case MidiplayerPackage.ABSTRACT_SESSION_ITEM__PATH:
				return getPath();
			case MidiplayerPackage.ABSTRACT_SESSION_ITEM__BACKGROUND_COLOR:
				return getBackgroundColor();
			case MidiplayerPackage.ABSTRACT_SESSION_ITEM__FOREGROUND_COLOR:
				return getForegroundColor();
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
			case MidiplayerPackage.ABSTRACT_SESSION_ITEM__NAME:
				setName((String)newValue);
				return;
			case MidiplayerPackage.ABSTRACT_SESSION_ITEM__PATH:
				setPath((String)newValue);
				return;
			case MidiplayerPackage.ABSTRACT_SESSION_ITEM__BACKGROUND_COLOR:
				setBackgroundColor((String)newValue);
				return;
			case MidiplayerPackage.ABSTRACT_SESSION_ITEM__FOREGROUND_COLOR:
				setForegroundColor((String)newValue);
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
			case MidiplayerPackage.ABSTRACT_SESSION_ITEM__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MidiplayerPackage.ABSTRACT_SESSION_ITEM__PATH:
				setPath(PATH_EDEFAULT);
				return;
			case MidiplayerPackage.ABSTRACT_SESSION_ITEM__BACKGROUND_COLOR:
				setBackgroundColor(BACKGROUND_COLOR_EDEFAULT);
				return;
			case MidiplayerPackage.ABSTRACT_SESSION_ITEM__FOREGROUND_COLOR:
				setForegroundColor(FOREGROUND_COLOR_EDEFAULT);
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
			case MidiplayerPackage.ABSTRACT_SESSION_ITEM__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case MidiplayerPackage.ABSTRACT_SESSION_ITEM__PATH:
				return PATH_EDEFAULT == null ? path != null : !PATH_EDEFAULT.equals(path);
			case MidiplayerPackage.ABSTRACT_SESSION_ITEM__BACKGROUND_COLOR:
				return BACKGROUND_COLOR_EDEFAULT == null ? backgroundColor != null : !BACKGROUND_COLOR_EDEFAULT.equals(backgroundColor);
			case MidiplayerPackage.ABSTRACT_SESSION_ITEM__FOREGROUND_COLOR:
				return FOREGROUND_COLOR_EDEFAULT == null ? foregroundColor != null : !FOREGROUND_COLOR_EDEFAULT.equals(foregroundColor);
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
		result.append(" (name: ");
		result.append(name);
		result.append(", path: ");
		result.append(path);
		result.append(", backgroundColor: ");
		result.append(backgroundColor);
		result.append(", foregroundColor: ");
		result.append(foregroundColor);
		result.append(')');
		return result.toString();
	}

} //AbstractSessionItemImpl
