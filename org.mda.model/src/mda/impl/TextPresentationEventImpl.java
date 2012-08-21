/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package mda.impl;

import java.util.Collection;

import mda.MidiFilePart;
import mda.MidiplayerPackage;
import mda.TextPresentationEvent;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Text Presentation Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link mda.impl.TextPresentationEventImpl#getParts <em>Parts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TextPresentationEventImpl extends AbstractEventImpl implements TextPresentationEvent {
	/**
	 * The cached value of the '{@link #getParts() <em>Parts</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParts()
	 * @generated
	 * @ordered
	 */
	protected EList<MidiFilePart> parts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TextPresentationEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MidiplayerPackage.Literals.TEXT_PRESENTATION_EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MidiFilePart> getParts() {
		if (parts == null) {
			parts = new EObjectResolvingEList<MidiFilePart>(MidiFilePart.class, this, MidiplayerPackage.TEXT_PRESENTATION_EVENT__PARTS);
		}
		return parts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MidiplayerPackage.TEXT_PRESENTATION_EVENT__PARTS:
				return getParts();
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
			case MidiplayerPackage.TEXT_PRESENTATION_EVENT__PARTS:
				getParts().clear();
				getParts().addAll((Collection<? extends MidiFilePart>)newValue);
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
			case MidiplayerPackage.TEXT_PRESENTATION_EVENT__PARTS:
				getParts().clear();
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
			case MidiplayerPackage.TEXT_PRESENTATION_EVENT__PARTS:
				return parts != null && !parts.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TextPresentationEventImpl
