/**
 */
package mda.impl;

import java.util.Collection;

import mda.Configuration;
import mda.Gallery;
import mda.MidiPlayerRoot;
import mda.MidiplayerPackage;
import mda.PresentationScheme;
import mda.Session;
import mda.User;

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
 * An implementation of the model object '<em><b>Midi Player Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link mda.impl.MidiPlayerRootImpl#getGallery <em>Gallery</em>}</li>
 *   <li>{@link mda.impl.MidiPlayerRootImpl#getSessions <em>Sessions</em>}</li>
 *   <li>{@link mda.impl.MidiPlayerRootImpl#getConfig <em>Config</em>}</li>
 *   <li>{@link mda.impl.MidiPlayerRootImpl#getUsers <em>Users</em>}</li>
 *   <li>{@link mda.impl.MidiPlayerRootImpl#getPresentationschemes <em>Presentationschemes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MidiPlayerRootImpl extends EObjectImpl implements MidiPlayerRoot {
	/**
	 * The cached value of the '{@link #getGallery() <em>Gallery</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGallery()
	 * @generated
	 * @ordered
	 */
	protected Gallery gallery;

	/**
	 * The cached value of the '{@link #getSessions() <em>Sessions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSessions()
	 * @generated
	 * @ordered
	 */
	protected EList<Session> sessions;

	/**
	 * The cached value of the '{@link #getConfig() <em>Config</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfig()
	 * @generated
	 * @ordered
	 */
	protected Configuration config;

	/**
	 * The cached value of the '{@link #getUsers() <em>Users</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsers()
	 * @generated
	 * @ordered
	 */
	protected EList<User> users;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MidiPlayerRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MidiplayerPackage.Literals.MIDI_PLAYER_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Gallery getGallery() {
		return gallery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGallery(Gallery newGallery, NotificationChain msgs) {
		Gallery oldGallery = gallery;
		gallery = newGallery;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MidiplayerPackage.MIDI_PLAYER_ROOT__GALLERY, oldGallery, newGallery);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGallery(Gallery newGallery) {
		if (newGallery != gallery) {
			NotificationChain msgs = null;
			if (gallery != null)
				msgs = ((InternalEObject)gallery).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MidiplayerPackage.MIDI_PLAYER_ROOT__GALLERY, null, msgs);
			if (newGallery != null)
				msgs = ((InternalEObject)newGallery).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MidiplayerPackage.MIDI_PLAYER_ROOT__GALLERY, null, msgs);
			msgs = basicSetGallery(newGallery, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.MIDI_PLAYER_ROOT__GALLERY, newGallery, newGallery));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Session> getSessions() {
		if (sessions == null) {
			sessions = new EObjectContainmentEList<Session>(Session.class, this, MidiplayerPackage.MIDI_PLAYER_ROOT__SESSIONS);
		}
		return sessions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Configuration getConfig() {
		return config;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConfig(Configuration newConfig, NotificationChain msgs) {
		Configuration oldConfig = config;
		config = newConfig;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MidiplayerPackage.MIDI_PLAYER_ROOT__CONFIG, oldConfig, newConfig);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfig(Configuration newConfig) {
		if (newConfig != config) {
			NotificationChain msgs = null;
			if (config != null)
				msgs = ((InternalEObject)config).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MidiplayerPackage.MIDI_PLAYER_ROOT__CONFIG, null, msgs);
			if (newConfig != null)
				msgs = ((InternalEObject)newConfig).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MidiplayerPackage.MIDI_PLAYER_ROOT__CONFIG, null, msgs);
			msgs = basicSetConfig(newConfig, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.MIDI_PLAYER_ROOT__CONFIG, newConfig, newConfig));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<User> getUsers() {
		if (users == null) {
			users = new EObjectContainmentEList<User>(User.class, this, MidiplayerPackage.MIDI_PLAYER_ROOT__USERS);
		}
		return users;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PresentationScheme> getPresentationschemes() {
		if (presentationschemes == null) {
			presentationschemes = new EObjectContainmentEList<PresentationScheme>(PresentationScheme.class, this, MidiplayerPackage.MIDI_PLAYER_ROOT__PRESENTATIONSCHEMES);
		}
		return presentationschemes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MidiplayerPackage.MIDI_PLAYER_ROOT__GALLERY:
				return basicSetGallery(null, msgs);
			case MidiplayerPackage.MIDI_PLAYER_ROOT__SESSIONS:
				return ((InternalEList<?>)getSessions()).basicRemove(otherEnd, msgs);
			case MidiplayerPackage.MIDI_PLAYER_ROOT__CONFIG:
				return basicSetConfig(null, msgs);
			case MidiplayerPackage.MIDI_PLAYER_ROOT__USERS:
				return ((InternalEList<?>)getUsers()).basicRemove(otherEnd, msgs);
			case MidiplayerPackage.MIDI_PLAYER_ROOT__PRESENTATIONSCHEMES:
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
			case MidiplayerPackage.MIDI_PLAYER_ROOT__GALLERY:
				return getGallery();
			case MidiplayerPackage.MIDI_PLAYER_ROOT__SESSIONS:
				return getSessions();
			case MidiplayerPackage.MIDI_PLAYER_ROOT__CONFIG:
				return getConfig();
			case MidiplayerPackage.MIDI_PLAYER_ROOT__USERS:
				return getUsers();
			case MidiplayerPackage.MIDI_PLAYER_ROOT__PRESENTATIONSCHEMES:
				return getPresentationschemes();
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
			case MidiplayerPackage.MIDI_PLAYER_ROOT__GALLERY:
				setGallery((Gallery)newValue);
				return;
			case MidiplayerPackage.MIDI_PLAYER_ROOT__SESSIONS:
				getSessions().clear();
				getSessions().addAll((Collection<? extends Session>)newValue);
				return;
			case MidiplayerPackage.MIDI_PLAYER_ROOT__CONFIG:
				setConfig((Configuration)newValue);
				return;
			case MidiplayerPackage.MIDI_PLAYER_ROOT__USERS:
				getUsers().clear();
				getUsers().addAll((Collection<? extends User>)newValue);
				return;
			case MidiplayerPackage.MIDI_PLAYER_ROOT__PRESENTATIONSCHEMES:
				getPresentationschemes().clear();
				getPresentationschemes().addAll((Collection<? extends PresentationScheme>)newValue);
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
			case MidiplayerPackage.MIDI_PLAYER_ROOT__GALLERY:
				setGallery((Gallery)null);
				return;
			case MidiplayerPackage.MIDI_PLAYER_ROOT__SESSIONS:
				getSessions().clear();
				return;
			case MidiplayerPackage.MIDI_PLAYER_ROOT__CONFIG:
				setConfig((Configuration)null);
				return;
			case MidiplayerPackage.MIDI_PLAYER_ROOT__USERS:
				getUsers().clear();
				return;
			case MidiplayerPackage.MIDI_PLAYER_ROOT__PRESENTATIONSCHEMES:
				getPresentationschemes().clear();
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
			case MidiplayerPackage.MIDI_PLAYER_ROOT__GALLERY:
				return gallery != null;
			case MidiplayerPackage.MIDI_PLAYER_ROOT__SESSIONS:
				return sessions != null && !sessions.isEmpty();
			case MidiplayerPackage.MIDI_PLAYER_ROOT__CONFIG:
				return config != null;
			case MidiplayerPackage.MIDI_PLAYER_ROOT__USERS:
				return users != null && !users.isEmpty();
			case MidiplayerPackage.MIDI_PLAYER_ROOT__PRESENTATIONSCHEMES:
				return presentationschemes != null && !presentationschemes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MidiPlayerRootImpl
