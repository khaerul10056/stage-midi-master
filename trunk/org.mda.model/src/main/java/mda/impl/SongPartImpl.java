/**
 */
package mda.impl;

import java.util.Collection;

import mda.MidiplayerPackage;
import mda.SongPart;
import mda.SongPartType;
import mda.SongTextLine;

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
 * An implementation of the model object '<em><b>Song Part</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link mda.impl.SongPartImpl#getTextlines <em>Textlines</em>}</li>
 *   <li>{@link mda.impl.SongPartImpl#getParttype <em>Parttype</em>}</li>
 *   <li>{@link mda.impl.SongPartImpl#getBar <em>Bar</em>}</li>
 *   <li>{@link mda.impl.SongPartImpl#getRefPart <em>Ref Part</em>}</li>
 *   <li>{@link mda.impl.SongPartImpl#getPosition <em>Position</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SongPartImpl extends EObjectImpl implements SongPart {
	/**
	 * The cached value of the '{@link #getTextlines() <em>Textlines</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTextlines()
	 * @generated
	 * @ordered
	 */
	protected EList<SongTextLine> textlines;

	/**
	 * The default value of the '{@link #getParttype() <em>Parttype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParttype()
	 * @generated
	 * @ordered
	 */
	protected static final SongPartType PARTTYPE_EDEFAULT = SongPartType.REFRAIN;

	/**
	 * The cached value of the '{@link #getParttype() <em>Parttype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParttype()
	 * @generated
	 * @ordered
	 */
	protected SongPartType parttype = PARTTYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getBar() <em>Bar</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBar()
	 * @generated
	 * @ordered
	 */
	protected static final int BAR_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getBar() <em>Bar</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBar()
	 * @generated
	 * @ordered
	 */
	protected int bar = BAR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRefPart() <em>Ref Part</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefPart()
	 * @generated
	 * @ordered
	 */
	protected SongPart refPart;

	/**
	 * The default value of the '{@link #getPosition() <em>Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPosition()
	 * @generated
	 * @ordered
	 */
	protected static final String POSITION_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getPosition() <em>Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPosition()
	 * @generated
	 * @ordered
	 */
	protected String position = POSITION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SongPartImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MidiplayerPackage.Literals.SONG_PART;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SongTextLine> getTextlines() {
		if (textlines == null) {
			textlines = new EObjectContainmentEList<SongTextLine>(SongTextLine.class, this, MidiplayerPackage.SONG_PART__TEXTLINES);
		}
		return textlines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SongPartType getParttype() {
		return parttype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParttype(SongPartType newParttype) {
		SongPartType oldParttype = parttype;
		parttype = newParttype == null ? PARTTYPE_EDEFAULT : newParttype;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.SONG_PART__PARTTYPE, oldParttype, parttype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getBar() {
		return bar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBar(int newBar) {
		int oldBar = bar;
		bar = newBar;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.SONG_PART__BAR, oldBar, bar));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SongPart getRefPart() {
		if (refPart != null && refPart.eIsProxy()) {
			InternalEObject oldRefPart = (InternalEObject)refPart;
			refPart = (SongPart)eResolveProxy(oldRefPart);
			if (refPart != oldRefPart) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MidiplayerPackage.SONG_PART__REF_PART, oldRefPart, refPart));
			}
		}
		return refPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SongPart basicGetRefPart() {
		return refPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefPart(SongPart newRefPart) {
		SongPart oldRefPart = refPart;
		refPart = newRefPart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.SONG_PART__REF_PART, oldRefPart, refPart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPosition(String newPosition) {
		String oldPosition = position;
		position = newPosition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.SONG_PART__POSITION, oldPosition, position));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MidiplayerPackage.SONG_PART__TEXTLINES:
				return ((InternalEList<?>)getTextlines()).basicRemove(otherEnd, msgs);
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
			case MidiplayerPackage.SONG_PART__TEXTLINES:
				return getTextlines();
			case MidiplayerPackage.SONG_PART__PARTTYPE:
				return getParttype();
			case MidiplayerPackage.SONG_PART__BAR:
				return getBar();
			case MidiplayerPackage.SONG_PART__REF_PART:
				if (resolve) return getRefPart();
				return basicGetRefPart();
			case MidiplayerPackage.SONG_PART__POSITION:
				return getPosition();
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
			case MidiplayerPackage.SONG_PART__TEXTLINES:
				getTextlines().clear();
				getTextlines().addAll((Collection<? extends SongTextLine>)newValue);
				return;
			case MidiplayerPackage.SONG_PART__PARTTYPE:
				setParttype((SongPartType)newValue);
				return;
			case MidiplayerPackage.SONG_PART__BAR:
				setBar((Integer)newValue);
				return;
			case MidiplayerPackage.SONG_PART__REF_PART:
				setRefPart((SongPart)newValue);
				return;
			case MidiplayerPackage.SONG_PART__POSITION:
				setPosition((String)newValue);
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
			case MidiplayerPackage.SONG_PART__TEXTLINES:
				getTextlines().clear();
				return;
			case MidiplayerPackage.SONG_PART__PARTTYPE:
				setParttype(PARTTYPE_EDEFAULT);
				return;
			case MidiplayerPackage.SONG_PART__BAR:
				setBar(BAR_EDEFAULT);
				return;
			case MidiplayerPackage.SONG_PART__REF_PART:
				setRefPart((SongPart)null);
				return;
			case MidiplayerPackage.SONG_PART__POSITION:
				setPosition(POSITION_EDEFAULT);
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
			case MidiplayerPackage.SONG_PART__TEXTLINES:
				return textlines != null && !textlines.isEmpty();
			case MidiplayerPackage.SONG_PART__PARTTYPE:
				return parttype != PARTTYPE_EDEFAULT;
			case MidiplayerPackage.SONG_PART__BAR:
				return bar != BAR_EDEFAULT;
			case MidiplayerPackage.SONG_PART__REF_PART:
				return refPart != null;
			case MidiplayerPackage.SONG_PART__POSITION:
				return POSITION_EDEFAULT == null ? position != null : !POSITION_EDEFAULT.equals(position);
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
		result.append(" (parttype: ");
		result.append(parttype);
		result.append(", bar: ");
		result.append(bar);
		result.append(", position: ");
		result.append(position);
		result.append(')');
		return result.toString();
	}

} //SongPartImpl
