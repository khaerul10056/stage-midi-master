/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package mda.impl;

import mda.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MidiplayerFactoryImpl extends EFactoryImpl implements MidiplayerFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MidiplayerFactory init() {
		try {
			MidiplayerFactory theMidiplayerFactory = (MidiplayerFactory)EPackage.Registry.INSTANCE.getEFactory("org.mda.model"); 
			if (theMidiplayerFactory != null) {
				return theMidiplayerFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MidiplayerFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MidiplayerFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case MidiplayerPackage.SESSION: return createSession();
			case MidiplayerPackage.MIDI_FILE: return createMidiFile();
			case MidiplayerPackage.MIDI_FILE_PART: return createMidiFilePart();
			case MidiplayerPackage.MIDI_FILE_TEXT_LINE: return createMidiFileTextLine();
			case MidiplayerPackage.GALLERY: return createGallery();
			case MidiplayerPackage.MIDI_PLAYER_ROOT: return createMidiPlayerRoot();
			case MidiplayerPackage.MIDI_FILE_CHORD_PART: return createMidiFileChordPart();
			case MidiplayerPackage.CONFIGURATION: return createConfiguration();
			case MidiplayerPackage.USER: return createUser();
			case MidiplayerPackage.COPYRIGHT: return createCopyright();
			case MidiplayerPackage.PRESENTATION_SCHEME: return createPresentationScheme();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case MidiplayerPackage.MIDI_FILE_PART_TYPE:
				return createMidiFilePartTypeFromString(eDataType, initialValue);
			case MidiplayerPackage.ADDITIONAL_TYPE:
				return createAdditionalTypeFromString(eDataType, initialValue);
			case MidiplayerPackage.USER_TYPE:
				return createUserTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case MidiplayerPackage.MIDI_FILE_PART_TYPE:
				return convertMidiFilePartTypeToString(eDataType, instanceValue);
			case MidiplayerPackage.ADDITIONAL_TYPE:
				return convertAdditionalTypeToString(eDataType, instanceValue);
			case MidiplayerPackage.USER_TYPE:
				return convertUserTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Session createSession() {
		SessionImpl session = new SessionImpl();
		return session;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MidiFile createMidiFile() {
		MidiFileImpl midiFile = new MidiFileImpl();
		return midiFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MidiFilePart createMidiFilePart() {
		MidiFilePartImpl midiFilePart = new MidiFilePartImpl();
		return midiFilePart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MidiFileTextLine createMidiFileTextLine() {
		MidiFileTextLineImpl midiFileTextLine = new MidiFileTextLineImpl();
		return midiFileTextLine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Gallery createGallery() {
		GalleryImpl gallery = new GalleryImpl();
		return gallery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MidiPlayerRoot createMidiPlayerRoot() {
		MidiPlayerRootImpl midiPlayerRoot = new MidiPlayerRootImpl();
		return midiPlayerRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MidiFileChordPart createMidiFileChordPart() {
		MidiFileChordPartImpl midiFileChordPart = new MidiFileChordPartImpl();
		return midiFileChordPart;
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public Configuration createConfiguration() {
		ConfigurationImpl configuration = new ConfigurationImpl();
		return configuration;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public User createUser() {
		UserImpl user = new UserImpl();
		return user;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public Copyright createCopyright() {
		CopyrightImpl copyright = new CopyrightImpl();
		return copyright;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public PresentationScheme createPresentationScheme() {
		PresentationSchemeImpl presentationScheme = new PresentationSchemeImpl();
		return presentationScheme;
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MidiFilePartType createMidiFilePartTypeFromString(EDataType eDataType, String initialValue) {
		MidiFilePartType result = MidiFilePartType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMidiFilePartTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AdditionalType createAdditionalTypeFromString(EDataType eDataType, String initialValue) {
		AdditionalType result = AdditionalType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertAdditionalTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public UserType createUserTypeFromString(EDataType eDataType, String initialValue) {
		UserType result = UserType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertUserTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MidiplayerPackage getMidiplayerPackage() {
		return (MidiplayerPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MidiplayerPackage getPackage() {
		return MidiplayerPackage.eINSTANCE;
	}

} //MidiplayerFactoryImpl
