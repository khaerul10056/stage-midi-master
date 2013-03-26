/**
 */
package mda;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gallery</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link mda.Gallery#getGalleryItems <em>Gallery Items</em>}</li>
 * </ul>
 * </p>
 *
 * @see mda.MidiplayerPackage#getGallery()
 * @model
 * @generated
 */
public interface Gallery extends EObject {
	/**
	 * Returns the value of the '<em><b>Gallery Items</b></em>' containment reference list.
	 * The list contents are of type {@link mda.AbstractSessionItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gallery Items</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gallery Items</em>' containment reference list.
	 * @see mda.MidiplayerPackage#getGallery_GalleryItems()
	 * @model containment="true"
	 * @generated
	 */
	EList<AbstractSessionItem> getGalleryItems();

} // Gallery
