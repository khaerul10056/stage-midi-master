/**
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
			MidiplayerFactory theMidiplayerFactory = (MidiplayerFactory)EPackage.Registry.INSTANCE.getEFactory(MidiplayerPackage.eNS_URI);
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
			case MidiplayerPackage.SONG: return createSong();
			case MidiplayerPackage.SONG_PART: return createSongPart();
			case MidiplayerPackage.SONG_TEXT_LINE: return createSongTextLine();
			case MidiplayerPackage.GALLERY: return createGallery();
			case MidiplayerPackage.MIDI_PLAYER_ROOT: return createMidiPlayerRoot();
			case MidiplayerPackage.SONG_CHORD_PART: return createSongChordPart();
			case MidiplayerPackage.CONFIGURATION: return createConfiguration();
			case MidiplayerPackage.USER: return createUser();
			case MidiplayerPackage.COPYRIGHT: return createCopyright();
			case MidiplayerPackage.PRESENTATION_SCHEME: return createPresentationScheme();
			case MidiplayerPackage.SPECIAL_MEDIA: return createSpecialMedia();
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
			case MidiplayerPackage.SONG_PART_TYPE:
				return createSongPartTypeFromString(eDataType, initialValue);
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
			case MidiplayerPackage.SONG_PART_TYPE:
				return convertSongPartTypeToString(eDataType, instanceValue);
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
	public Session createSession() {
		SessionImpl session = new SessionImpl();
		return session;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Song createSong() {
		SongImpl song = new SongImpl();
		return song;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SongPart createSongPart() {
		SongPartImpl songPart = new SongPartImpl();
		return songPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SongTextLine createSongTextLine() {
		SongTextLineImpl songTextLine = new SongTextLineImpl();
		return songTextLine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Gallery createGallery() {
		GalleryImpl gallery = new GalleryImpl();
		return gallery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MidiPlayerRoot createMidiPlayerRoot() {
		MidiPlayerRootImpl midiPlayerRoot = new MidiPlayerRootImpl();
		return midiPlayerRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SongChordPart createSongChordPart() {
		SongChordPartImpl songChordPart = new SongChordPartImpl();
		return songChordPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Configuration createConfiguration() {
		ConfigurationImpl configuration = new ConfigurationImpl();
		return configuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public User createUser() {
		UserImpl user = new UserImpl();
		return user;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Copyright createCopyright() {
		CopyrightImpl copyright = new CopyrightImpl();
		return copyright;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PresentationScheme createPresentationScheme() {
		PresentationSchemeImpl presentationScheme = new PresentationSchemeImpl();
		return presentationScheme;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecialMedia createSpecialMedia() {
		SpecialMediaImpl specialMedia = new SpecialMediaImpl();
		return specialMedia;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SongPartType createSongPartTypeFromString(EDataType eDataType, String initialValue) {
		SongPartType result = SongPartType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSongPartTypeToString(EDataType eDataType, Object instanceValue) {
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
