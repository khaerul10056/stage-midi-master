/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package mda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Additional Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see mda.MidiplayerPackage#getAdditionalType()
 * @model
 * @generated
 */
public enum AdditionalType implements Enumerator {
  /**
	 * The '<em><b>IMAGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #IMAGE_VALUE
	 * @generated
	 * @ordered
	 */
  IMAGE(0, "IMAGE", "IMAGE"),

  /**
	 * The '<em><b>VIDEO</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #VIDEO_VALUE
	 * @generated
	 * @ordered
	 */
  VIDEO(1, "VIDEO", "VIDEO"),

  /**
	 * The '<em><b>MIDIFILE</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #MIDIFILE_VALUE
	 * @generated
	 * @ordered
	 */
  MIDIFILE(2, "MIDIFILE", "MIDIFILE"),

  /**
	 * The '<em><b>AUDIO</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #AUDIO_VALUE
	 * @generated
	 * @ordered
	 */
  AUDIO(3, "AUDIO", "AUDIO");

  /**
	 * The '<em><b>IMAGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>IMAGE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #IMAGE
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int IMAGE_VALUE = 0;

  /**
	 * The '<em><b>VIDEO</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>VIDEO</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #VIDEO
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int VIDEO_VALUE = 1;

  /**
	 * The '<em><b>MIDIFILE</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>MIDIFILE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #MIDIFILE
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int MIDIFILE_VALUE = 2;

  /**
	 * The '<em><b>AUDIO</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>AUDIO</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #AUDIO
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int AUDIO_VALUE = 3;

  /**
	 * An array of all the '<em><b>Additional Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static final AdditionalType[] VALUES_ARRAY =
    new AdditionalType[] {
			IMAGE,
			VIDEO,
			MIDIFILE,
			AUDIO,
		};

  /**
	 * A public read-only list of all the '<em><b>Additional Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static final List<AdditionalType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
	 * Returns the '<em><b>Additional Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static AdditionalType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AdditionalType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Additional Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static AdditionalType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AdditionalType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

  /**
	 * Returns the '<em><b>Additional Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static AdditionalType get(int value) {
		switch (value) {
			case IMAGE_VALUE: return IMAGE;
			case VIDEO_VALUE: return VIDEO;
			case MIDIFILE_VALUE: return MIDIFILE;
			case AUDIO_VALUE: return AUDIO;
		}
		return null;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private final int value;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private final String name;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private final String literal;

  /**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private AdditionalType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public int getValue() {
	  return value;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getName() {
	  return name;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getLiteral() {
	  return literal;
	}

  /**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public String toString() {
		return literal;
	}
  
} //AdditionalType
