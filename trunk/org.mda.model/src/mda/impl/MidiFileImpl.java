/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package mda.impl;

import java.util.Collection;

import mda.Copyright;
import mda.MidiFile;
import mda.MidiFilePart;
import mda.MidiplayerPackage;

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
 * An implementation of the model object '<em><b>Midi File</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link mda.impl.MidiFileImpl#getParts <em>Parts</em>}</li>
 *   <li>{@link mda.impl.MidiFileImpl#getPic <em>Pic</em>}</li>
 *   <li>{@link mda.impl.MidiFileImpl#getKey <em>Key</em>}</li>
 *   <li>{@link mda.impl.MidiFileImpl#getCopyright <em>Copyright</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MidiFileImpl extends AbstractSessionItemImpl implements MidiFile {
	/**
	 * The cached value of the '{@link #getParts() <em>Parts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getParts()
	 * @generated
	 * @ordered
	 */
  protected EList<MidiFilePart> parts;
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MidiFileImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MidiplayerPackage.Literals.MIDI_FILE;
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EList<MidiFilePart> getParts() {
		if (parts == null) {
			parts = new EObjectContainmentEList<MidiFilePart>(MidiFilePart.class, this, MidiplayerPackage.MIDI_FILE__PARTS);
		}
		return parts;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public String getPic() {
		return pic;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public void setPic(String newPic) {
		String oldPic = pic;
		pic = newPic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.MIDI_FILE__PIC, oldPic, pic));
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getKey() {
		return key;
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setKey(String newKey) {
		String oldKey = key;
		key = newKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.MIDI_FILE__KEY, oldKey, key));
	}

		/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MidiplayerPackage.MIDI_FILE__COPYRIGHT, oldCopyright, newCopyright);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

    /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public void setCopyright(Copyright newCopyright) {
		if (newCopyright != copyright) {
			NotificationChain msgs = null;
			if (copyright != null)
				msgs = ((InternalEObject)copyright).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MidiplayerPackage.MIDI_FILE__COPYRIGHT, null, msgs);
			if (newCopyright != null)
				msgs = ((InternalEObject)newCopyright).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MidiplayerPackage.MIDI_FILE__COPYRIGHT, null, msgs);
			msgs = basicSetCopyright(newCopyright, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.MIDI_FILE__COPYRIGHT, newCopyright, newCopyright));
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MidiplayerPackage.MIDI_FILE__PARTS:
				return ((InternalEList<?>)getParts()).basicRemove(otherEnd, msgs);
			case MidiplayerPackage.MIDI_FILE__COPYRIGHT:
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
			case MidiplayerPackage.MIDI_FILE__PARTS:
				return getParts();
			case MidiplayerPackage.MIDI_FILE__PIC:
				return getPic();
			case MidiplayerPackage.MIDI_FILE__KEY:
				return getKey();
			case MidiplayerPackage.MIDI_FILE__COPYRIGHT:
				return getCopyright();
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
			case MidiplayerPackage.MIDI_FILE__PARTS:
				getParts().clear();
				getParts().addAll((Collection<? extends MidiFilePart>)newValue);
				return;
			case MidiplayerPackage.MIDI_FILE__PIC:
				setPic((String)newValue);
				return;
			case MidiplayerPackage.MIDI_FILE__KEY:
				setKey((String)newValue);
				return;
			case MidiplayerPackage.MIDI_FILE__COPYRIGHT:
				setCopyright((Copyright)newValue);
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
			case MidiplayerPackage.MIDI_FILE__PARTS:
				getParts().clear();
				return;
			case MidiplayerPackage.MIDI_FILE__PIC:
				setPic(PIC_EDEFAULT);
				return;
			case MidiplayerPackage.MIDI_FILE__KEY:
				setKey(KEY_EDEFAULT);
				return;
			case MidiplayerPackage.MIDI_FILE__COPYRIGHT:
				setCopyright((Copyright)null);
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
			case MidiplayerPackage.MIDI_FILE__PARTS:
				return parts != null && !parts.isEmpty();
			case MidiplayerPackage.MIDI_FILE__PIC:
				return PIC_EDEFAULT == null ? pic != null : !PIC_EDEFAULT.equals(pic);
			case MidiplayerPackage.MIDI_FILE__KEY:
				return KEY_EDEFAULT == null ? key != null : !KEY_EDEFAULT.equals(key);
			case MidiplayerPackage.MIDI_FILE__COPYRIGHT:
				return copyright != null;
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
		result.append(')');
		return result.toString();
	}

} //MidiFileImpl
