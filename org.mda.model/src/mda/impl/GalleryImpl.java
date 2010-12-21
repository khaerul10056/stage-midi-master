/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package mda.impl;

import java.util.Collection;

import mda.AbstractSessionItem;
import mda.Gallery;
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
 * An implementation of the model object '<em><b>Gallery</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link mda.impl.GalleryImpl#getGalleryItems <em>Gallery Items</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GalleryImpl extends EObjectImpl implements Gallery {
	/**
	 * The cached value of the '{@link #getGalleryItems() <em>Gallery Items</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGalleryItems()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractSessionItem> galleryItems;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GalleryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MidiplayerPackage.Literals.GALLERY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractSessionItem> getGalleryItems() {
		if (galleryItems == null) {
			galleryItems = new EObjectContainmentEList<AbstractSessionItem>(AbstractSessionItem.class, this, MidiplayerPackage.GALLERY__GALLERY_ITEMS);
		}
		return galleryItems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MidiplayerPackage.GALLERY__GALLERY_ITEMS:
				return ((InternalEList<?>)getGalleryItems()).basicRemove(otherEnd, msgs);
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
			case MidiplayerPackage.GALLERY__GALLERY_ITEMS:
				return getGalleryItems();
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
			case MidiplayerPackage.GALLERY__GALLERY_ITEMS:
				getGalleryItems().clear();
				getGalleryItems().addAll((Collection<? extends AbstractSessionItem>)newValue);
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
			case MidiplayerPackage.GALLERY__GALLERY_ITEMS:
				getGalleryItems().clear();
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
			case MidiplayerPackage.GALLERY__GALLERY_ITEMS:
				return galleryItems != null && !galleryItems.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //GalleryImpl
