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
 * A representation of the literals of the enumeration '<em><b>Midi File Part Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see mda.MidiplayerPackage#getMidiFilePartType()
 * @model
 * @generated
 */
public enum MidiFilePartType implements Enumerator {
	/**
	 * The '<em><b>REFRAIN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REFRAIN_VALUE
	 * @generated
	 * @ordered
	 */
	REFRAIN(0, "REFRAIN", "REFRAIN"),

	/**
	 * The '<em><b>BRIDGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BRIDGE_VALUE
	 * @generated
	 * @ordered
	 */
	BRIDGE(1, "BRIDGE", "BRIDGE"),

	/**
	 * The '<em><b>VERS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VERS_VALUE
	 * @generated
	 * @ordered
	 */
	VERS(2, "VERS", "VERS"),

	/**
	 * The '<em><b>SOLO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SOLO_VALUE
	 * @generated
	 * @ordered
	 */
	SOLO(3, "SOLO", "SOLO"), /**
	 * The '<em><b>ZWISCHENSPIEL</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #ZWISCHENSPIEL_VALUE
	 * @generated
	 * @ordered
	 */
  ZWISCHENSPIEL(4, "ZWISCHENSPIEL", "ZWISCHENSPIEL"), /**
	 * The '<em><b>INTRO</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #INTRO_VALUE
	 * @generated
	 * @ordered
	 */
  INTRO(5, "INTRO", "INTRO"), /**
	 * The '<em><b>EXTRO</b></em>' literal object.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #EXTRO_VALUE
	 * @generated
	 * @ordered
	 */
  EXTRO(6, "EXTRO", "EXTRO");

	/**
	 * The '<em><b>REFRAIN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>REFRAIN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REFRAIN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int REFRAIN_VALUE = 0;

	/**
	 * The '<em><b>BRIDGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BRIDGE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BRIDGE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BRIDGE_VALUE = 1;

	/**
	 * The '<em><b>VERS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>VERS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VERS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int VERS_VALUE = 2;

	/**
	 * The '<em><b>SOLO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SOLO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SOLO
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SOLO_VALUE = 3;

	/**
	 * The '<em><b>ZWISCHENSPIEL</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>ZWISCHENSPIEL</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #ZWISCHENSPIEL
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int ZWISCHENSPIEL_VALUE = 4;

  /**
	 * The '<em><b>INTRO</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>INTRO</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #INTRO
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int INTRO_VALUE = 5;

  /**
	 * The '<em><b>EXTRO</b></em>' literal value.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>EXTRO</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @see #EXTRO
	 * @model
	 * @generated
	 * @ordered
	 */
  public static final int EXTRO_VALUE = 6;

  /**
	 * An array of all the '<em><b>Midi File Part Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final MidiFilePartType[] VALUES_ARRAY =
		new MidiFilePartType[] {
			REFRAIN,
			BRIDGE,
			VERS,
			SOLO,
			ZWISCHENSPIEL,
			INTRO,
			EXTRO,
		};

	/**
	 * A public read-only list of all the '<em><b>Midi File Part Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<MidiFilePartType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Midi File Part Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MidiFilePartType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MidiFilePartType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Midi File Part Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MidiFilePartType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MidiFilePartType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Midi File Part Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MidiFilePartType get(int value) {
		switch (value) {
			case REFRAIN_VALUE: return REFRAIN;
			case BRIDGE_VALUE: return BRIDGE;
			case VERS_VALUE: return VERS;
			case SOLO_VALUE: return SOLO;
			case ZWISCHENSPIEL_VALUE: return ZWISCHENSPIEL;
			case INTRO_VALUE: return INTRO;
			case EXTRO_VALUE: return EXTRO;
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
	private MidiFilePartType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	
} //MidiFilePartType
