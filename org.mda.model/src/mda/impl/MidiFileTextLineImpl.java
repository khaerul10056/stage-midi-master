/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package mda.impl;

import java.util.Collection;

import mda.MidiFileChordPart;
import mda.MidiFileTextLine;
import mda.MidiplayerPackage;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Midi File Text Line</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link mda.impl.MidiFileTextLineImpl#getChordParts <em>Chord Parts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MidiFileTextLineImpl extends EObjectImpl implements MidiFileTextLine {
	/**
	 * The cached value of the '{@link #getChordParts() <em>Chord Parts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChordParts()
	 * @generated
	 * @ordered
	 */
	protected EList<MidiFileChordPart> chordParts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MidiFileTextLineImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MidiplayerPackage.Literals.MIDI_FILE_TEXT_LINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MidiFileChordPart> getChordParts() {
		if (chordParts == null) {
			chordParts = new EObjectContainmentEList<MidiFileChordPart>(MidiFileChordPart.class, this, MidiplayerPackage.MIDI_FILE_TEXT_LINE__CHORD_PARTS);
		}
		return chordParts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MidiplayerPackage.MIDI_FILE_TEXT_LINE__CHORD_PARTS:
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
			case MidiplayerPackage.MIDI_FILE_TEXT_LINE__CHORD_PARTS:
				return getChordParts();
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
			case MidiplayerPackage.MIDI_FILE_TEXT_LINE__CHORD_PARTS:
				getChordParts().clear();
				getChordParts().addAll((Collection<? extends MidiFileChordPart>)newValue);
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
			case MidiplayerPackage.MIDI_FILE_TEXT_LINE__CHORD_PARTS:
				getChordParts().clear();
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
			case MidiplayerPackage.MIDI_FILE_TEXT_LINE__CHORD_PARTS:
				return chordParts != null && !chordParts.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MidiFileTextLineImpl
