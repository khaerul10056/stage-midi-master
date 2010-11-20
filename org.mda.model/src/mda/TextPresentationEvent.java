/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package mda;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Text Presentation Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link mda.TextPresentationEvent#getParts <em>Parts</em>}</li>
 * </ul>
 * </p>
 *
 * @see mda.MidiplayerPackage#getTextPresentationEvent()
 * @model
 * @generated
 */
public interface TextPresentationEvent extends AbstractEvent {
	/**
   * Returns the value of the '<em><b>Parts</b></em>' reference list.
   * The list contents are of type {@link mda.MidiFilePart}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parts</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Parts</em>' reference list.
   * @see mda.MidiplayerPackage#getTextPresentationEvent_Parts()
   * @model
   * @generated
   */
	EList<MidiFilePart> getParts();

} // TextPresentationEvent
