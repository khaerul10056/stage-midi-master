/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package mda;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Export Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link mda.ExportConfiguration#isWithChords <em>With Chords</em>}</li>
 * </ul>
 * </p>
 *
 * @see mda.MidiplayerPackage#getExportConfiguration()
 * @model
 * @generated
 */
public interface ExportConfiguration extends EObject {

  /**
   * Returns the value of the '<em><b>With Chords</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>With Chords</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>With Chords</em>' attribute.
   * @see #setWithChords(boolean)
   * @see mda.MidiplayerPackage#getExportConfiguration_WithChords()
   * @model
   * @generated
   */
  boolean isWithChords();

  /**
   * Sets the value of the '{@link mda.ExportConfiguration#isWithChords <em>With Chords</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>With Chords</em>' attribute.
   * @see #isWithChords()
   * @generated
   */
  void setWithChords(boolean value);
} // ExportConfiguration
