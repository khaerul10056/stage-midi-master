/**
 */
package mda.impl;

import java.util.Collection;

import mda.Copyright;
import mda.MidiplayerPackage;
import mda.Song;
import mda.SongPart;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Song</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link mda.impl.SongImpl#getParts <em>Parts</em>}</li>
 *   <li>{@link mda.impl.SongImpl#getPic <em>Pic</em>}</li>
 *   <li>{@link mda.impl.SongImpl#getKey <em>Key</em>}</li>
 *   <li>{@link mda.impl.SongImpl#getCopyright <em>Copyright</em>}</li>
 *   <li>{@link mda.impl.SongImpl#getMidicontrol <em>Midicontrol</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SongImpl extends AbstractSessionItemImpl implements Song {
	/**
	 * The cached value of the '{@link #getParts() <em>Parts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParts()
	 * @generated
	 * @ordered
	 */
	protected EList<SongPart> parts;

	/**
	 * The default value of the '{@link #getPic() <em>Pic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPic()
	 * @generated
	 * @ordered
	 */
	protected static final String PIC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPic() <em>Pic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPic()
	 * @generated
	 * @ordered
	 */
	protected String pic = PIC_EDEFAULT;

	/**
	 * The default value of the '{@link #getKey() <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKey()
	 * @generated
	 * @ordered
	 */
	protected static final String KEY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKey() <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKey()
	 * @generated
	 * @ordered
	 */
	protected String key = KEY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCopyright() <em>Copyright</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCopyright()
	 * @generated
	 * @ordered
	 */
	protected Copyright copyright;

	/**
	 * The default value of the '{@link #getMidicontrol() <em>Midicontrol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMidicontrol()
	 * @generated
	 * @ordered
	 */
	protected static final int MIDICONTROL_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getMidicontrol() <em>Midicontrol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMidicontrol()
	 * @generated
	 * @ordered
	 */
	protected int midicontrol = MIDICONTROL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SongImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MidiplayerPackage.Literals.SONG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SongPart> getParts() {
		if (parts == null) {
			parts = new EObjectContainmentEList<SongPart>(SongPart.class, this, MidiplayerPackage.SONG__PARTS);
		}
		return parts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPic() {
		return pic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPic(String newPic) {
		String oldPic = pic;
		pic = newPic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.SONG__PIC, oldPic, pic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getKey() {
		return key;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKey(String newKey) {
		String oldKey = key;
		key = newKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.SONG__KEY, oldKey, key));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Copyright getCopyright() {
		return copyright;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCopyright(Copyright newCopyright, NotificationChain msgs) {
		Copyright oldCopyright = copyright;
		copyright = newCopyright;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MidiplayerPackage.SONG__COPYRIGHT, oldCopyright, newCopyright);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCopyright(Copyright newCopyright) {
		if (newCopyright != copyright) {
			NotificationChain msgs = null;
			if (copyright != null)
				msgs = ((InternalEObject)copyright).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MidiplayerPackage.SONG__COPYRIGHT, null, msgs);
			if (newCopyright != null)
				msgs = ((InternalEObject)newCopyright).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MidiplayerPackage.SONG__COPYRIGHT, null, msgs);
			msgs = basicSetCopyright(newCopyright, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.SONG__COPYRIGHT, newCopyright, newCopyright));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMidicontrol() {
		return midicontrol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMidicontrol(int newMidicontrol) {
		int oldMidicontrol = midicontrol;
		midicontrol = newMidicontrol;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.SONG__MIDICONTROL, oldMidicontrol, midicontrol));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MidiplayerPackage.SONG__PARTS:
				return ((InternalEList<?>)getParts()).basicRemove(otherEnd, msgs);
			case MidiplayerPackage.SONG__COPYRIGHT:
				return basicSetCopyright(null, msgs);
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
			case MidiplayerPackage.SONG__PARTS:
				return getParts();
			case MidiplayerPackage.SONG__PIC:
				return getPic();
			case MidiplayerPackage.SONG__KEY:
				return getKey();
			case MidiplayerPackage.SONG__COPYRIGHT:
				return getCopyright();
			case MidiplayerPackage.SONG__MIDICONTROL:
				return getMidicontrol();
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
			case MidiplayerPackage.SONG__PARTS:
				getParts().clear();
				getParts().addAll((Collection<? extends SongPart>)newValue);
				return;
			case MidiplayerPackage.SONG__PIC:
				setPic((String)newValue);
				return;
			case MidiplayerPackage.SONG__KEY:
				setKey((String)newValue);
				return;
			case MidiplayerPackage.SONG__COPYRIGHT:
				setCopyright((Copyright)newValue);
				return;
			case MidiplayerPackage.SONG__MIDICONTROL:
				setMidicontrol((Integer)newValue);
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
			case MidiplayerPackage.SONG__PARTS:
				getParts().clear();
				return;
			case MidiplayerPackage.SONG__PIC:
				setPic(PIC_EDEFAULT);
				return;
			case MidiplayerPackage.SONG__KEY:
				setKey(KEY_EDEFAULT);
				return;
			case MidiplayerPackage.SONG__COPYRIGHT:
				setCopyright((Copyright)null);
				return;
			case MidiplayerPackage.SONG__MIDICONTROL:
				setMidicontrol(MIDICONTROL_EDEFAULT);
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
			case MidiplayerPackage.SONG__PARTS:
				return parts != null && !parts.isEmpty();
			case MidiplayerPackage.SONG__PIC:
				return PIC_EDEFAULT == null ? pic != null : !PIC_EDEFAULT.equals(pic);
			case MidiplayerPackage.SONG__KEY:
				return KEY_EDEFAULT == null ? key != null : !KEY_EDEFAULT.equals(key);
			case MidiplayerPackage.SONG__COPYRIGHT:
				return copyright != null;
			case MidiplayerPackage.SONG__MIDICONTROL:
				return midicontrol != MIDICONTROL_EDEFAULT;
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
		result.append(" (pic: ");
		result.append(pic);
		result.append(", key: ");
		result.append(key);
		result.append(", midicontrol: ");
		result.append(midicontrol);
		result.append(')');
		return result.toString();
	}

} //SongImpl
