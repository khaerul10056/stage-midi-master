/**
 */
package mda.impl;

import java.util.Collection;

import mda.MidiplayerPackage;
import mda.SongChordPart;
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
 * An implementation of the model object '<em><b>Song Text Line</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link mda.impl.SongTextLineImpl#getChordParts <em>Chord Parts</em>}</li>
 *   <li>{@link mda.impl.SongTextLineImpl#isNewSlide <em>New Slide</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SongTextLineImpl extends EObjectImpl implements SongTextLine {
	/**
	 * The cached value of the '{@link #getChordParts() <em>Chord Parts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChordParts()
	 * @generated
	 * @ordered
	 */
	protected EList<SongChordPart> chordParts;

	/**
	 * The default value of the '{@link #isNewSlide() <em>New Slide</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNewSlide()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NEW_SLIDE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNewSlide() <em>New Slide</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNewSlide()
	 * @generated
	 * @ordered
	 */
	protected boolean newSlide = NEW_SLIDE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SongTextLineImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MidiplayerPackage.Literals.SONG_TEXT_LINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SongChordPart> getChordParts() {
		if (chordParts == null) {
			chordParts = new EObjectContainmentEList<SongChordPart>(SongChordPart.class, this, MidiplayerPackage.SONG_TEXT_LINE__CHORD_PARTS);
		}
		return chordParts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNewSlide() {
		return newSlide;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewSlide(boolean newNewSlide) {
		boolean oldNewSlide = newSlide;
		newSlide = newNewSlide;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.SONG_TEXT_LINE__NEW_SLIDE, oldNewSlide, newSlide));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MidiplayerPackage.SONG_TEXT_LINE__CHORD_PARTS:
				return ((InternalEList<?>)getChordParts()).basicRemove(otherEnd, msgs);
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
			case MidiplayerPackage.SONG_TEXT_LINE__CHORD_PARTS:
				return getChordParts();
			case MidiplayerPackage.SONG_TEXT_LINE__NEW_SLIDE:
				return isNewSlide();
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
			case MidiplayerPackage.SONG_TEXT_LINE__CHORD_PARTS:
				getChordParts().clear();
				getChordParts().addAll((Collection<? extends SongChordPart>)newValue);
				return;
			case MidiplayerPackage.SONG_TEXT_LINE__NEW_SLIDE:
				setNewSlide((Boolean)newValue);
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
			case MidiplayerPackage.SONG_TEXT_LINE__CHORD_PARTS:
				getChordParts().clear();
				return;
			case MidiplayerPackage.SONG_TEXT_LINE__NEW_SLIDE:
				setNewSlide(NEW_SLIDE_EDEFAULT);
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
			case MidiplayerPackage.SONG_TEXT_LINE__CHORD_PARTS:
				return chordParts != null && !chordParts.isEmpty();
			case MidiplayerPackage.SONG_TEXT_LINE__NEW_SLIDE:
				return newSlide != NEW_SLIDE_EDEFAULT;
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
		result.append(" (newSlide: ");
		result.append(newSlide);
		result.append(')');
		return result.toString();
	}

} //SongTextLineImpl
