/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package mda.impl;

import java.util.Collection;

import mda.AbstractSessionItem;
import mda.MidiplayerPackage;
import mda.Session;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Session</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link mda.impl.SessionImpl#getName <em>Name</em>}</li>
 *   <li>{@link mda.impl.SessionImpl#getItems <em>Items</em>}</li>
 *   <li>{@link mda.impl.SessionImpl#getDefaultpath <em>Defaultpath</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SessionImpl extends EObjectImpl implements Session {
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
	 * The cached value of the '{@link #getItems() <em>Items</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItems()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractSessionItem> items;

	/**
	 * The default value of the '{@link #getDefaultpath() <em>Defaultpath</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultpath()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULTPATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultpath() <em>Defaultpath</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultpath()
	 * @generated
	 * @ordered
	 */
	protected String defaultpath = DEFAULTPATH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SessionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MidiplayerPackage.Literals.SESSION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.SESSION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractSessionItem> getItems() {
		if (items == null) {
			items = new EObjectResolvingEList<AbstractSessionItem>(AbstractSessionItem.class, this, MidiplayerPackage.SESSION__ITEMS);
		}
		return items;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefaultpath() {
		return defaultpath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultpath(String newDefaultpath) {
		String oldDefaultpath = defaultpath;
		defaultpath = newDefaultpath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.SESSION__DEFAULTPATH, oldDefaultpath, defaultpath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MidiplayerPackage.SESSION__NAME:
				return getName();
			case MidiplayerPackage.SESSION__ITEMS:
				return getItems();
			case MidiplayerPackage.SESSION__DEFAULTPATH:
				return getDefaultpath();
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
			case MidiplayerPackage.SESSION__NAME:
				setName((String)newValue);
				return;
			case MidiplayerPackage.SESSION__ITEMS:
				getItems().clear();
				getItems().addAll((Collection<? extends AbstractSessionItem>)newValue);
				return;
			case MidiplayerPackage.SESSION__DEFAULTPATH:
				setDefaultpath((String)newValue);
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
			case MidiplayerPackage.SESSION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MidiplayerPackage.SESSION__ITEMS:
				getItems().clear();
				return;
			case MidiplayerPackage.SESSION__DEFAULTPATH:
				setDefaultpath(DEFAULTPATH_EDEFAULT);
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
			case MidiplayerPackage.SESSION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case MidiplayerPackage.SESSION__ITEMS:
				return items != null && !items.isEmpty();
			case MidiplayerPackage.SESSION__DEFAULTPATH:
				return DEFAULTPATH_EDEFAULT == null ? defaultpath != null : !DEFAULTPATH_EDEFAULT.equals(defaultpath);
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
		result.append(", defaultpath: ");
		result.append(defaultpath);
		result.append(')');
		return result.toString();
	}

} //SessionImpl
