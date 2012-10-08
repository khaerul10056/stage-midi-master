/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package mda;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see mda.MidiplayerFactory
 * @model kind="package"
 * @generated
 */
public interface MidiplayerPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "mda";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.mda.model";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.mda.model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MidiplayerPackage eINSTANCE = mda.impl.MidiplayerPackageImpl.init();

	/**
	 * The meta object id for the '{@link mda.impl.SessionImpl <em>Session</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mda.impl.SessionImpl
	 * @see mda.impl.MidiplayerPackageImpl#getSession()
	 * @generated
	 */
	int SESSION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SESSION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Items</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SESSION__ITEMS = 1;

	/**
	 * The feature id for the '<em><b>Defaultpath</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SESSION__DEFAULTPATH = 2;

	/**
	 * The number of structural features of the '<em>Session</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SESSION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link mda.impl.AbstractSessionItemImpl <em>Abstract Session Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mda.impl.AbstractSessionItemImpl
	 * @see mda.impl.MidiplayerPackageImpl#getAbstractSessionItem()
	 * @generated
	 */
	int ABSTRACT_SESSION_ITEM = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SESSION_ITEM__NAME = 0;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SESSION_ITEM__PATH = 1;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ABSTRACT_SESSION_ITEM__BACKGROUND_COLOR = 2;

  /**
	 * The feature id for the '<em><b>Foreground Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int ABSTRACT_SESSION_ITEM__FOREGROUND_COLOR = 3;

  /**
	 * The number of structural features of the '<em>Abstract Session Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SESSION_ITEM_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link mda.impl.MidiFileImpl <em>Midi File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mda.impl.MidiFileImpl
	 * @see mda.impl.MidiplayerPackageImpl#getMidiFile()
	 * @generated
	 */
	int MIDI_FILE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIDI_FILE__NAME = ABSTRACT_SESSION_ITEM__NAME;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIDI_FILE__PATH = ABSTRACT_SESSION_ITEM__PATH;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MIDI_FILE__BACKGROUND_COLOR = ABSTRACT_SESSION_ITEM__BACKGROUND_COLOR;

  /**
	 * The feature id for the '<em><b>Foreground Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MIDI_FILE__FOREGROUND_COLOR = ABSTRACT_SESSION_ITEM__FOREGROUND_COLOR;

  /**
	 * The feature id for the '<em><b>Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MIDI_FILE__PARTS = ABSTRACT_SESSION_ITEM_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Pic</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MIDI_FILE__PIC = ABSTRACT_SESSION_ITEM_FEATURE_COUNT + 1;

  /**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIDI_FILE__KEY = ABSTRACT_SESSION_ITEM_FEATURE_COUNT + 2;

		/**
	 * The feature id for the '<em><b>Copyright</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MIDI_FILE__COPYRIGHT = ABSTRACT_SESSION_ITEM_FEATURE_COUNT + 3;

    /**
	 * The number of structural features of the '<em>Midi File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIDI_FILE_FEATURE_COUNT = ABSTRACT_SESSION_ITEM_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link mda.impl.AbstractEventImpl <em>Abstract Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mda.impl.AbstractEventImpl
	 * @see mda.impl.MidiplayerPackageImpl#getAbstractEvent()
	 * @generated
	 */
	int ABSTRACT_EVENT = 3;

	/**
	 * The feature id for the '<em><b>At Bar</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_EVENT__AT_BAR = 0;

	/**
	 * The number of structural features of the '<em>Abstract Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_EVENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link mda.impl.TextPresentationEventImpl <em>Text Presentation Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mda.impl.TextPresentationEventImpl
	 * @see mda.impl.MidiplayerPackageImpl#getTextPresentationEvent()
	 * @generated
	 */
	int TEXT_PRESENTATION_EVENT = 4;

	/**
	 * The feature id for the '<em><b>At Bar</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_PRESENTATION_EVENT__AT_BAR = ABSTRACT_EVENT__AT_BAR;

	/**
	 * The feature id for the '<em><b>Parts</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_PRESENTATION_EVENT__PARTS = ABSTRACT_EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Text Presentation Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_PRESENTATION_EVENT_FEATURE_COUNT = ABSTRACT_EVENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link mda.impl.MidiFilePartImpl <em>Midi File Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mda.impl.MidiFilePartImpl
	 * @see mda.impl.MidiplayerPackageImpl#getMidiFilePart()
	 * @generated
	 */
	int MIDI_FILE_PART = 5;

	/**
	 * The feature id for the '<em><b>Textlines</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIDI_FILE_PART__TEXTLINES = 0;

	/**
	 * The feature id for the '<em><b>Parttype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIDI_FILE_PART__PARTTYPE = 1;

	/**
	 * The feature id for the '<em><b>Bar</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MIDI_FILE_PART__BAR = 2;

  /**
	 * The feature id for the '<em><b>Ref Part</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MIDI_FILE_PART__REF_PART = 3;

  /**
	 * The number of structural features of the '<em>Midi File Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIDI_FILE_PART_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link mda.impl.MidiFileTextLineImpl <em>Midi File Text Line</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mda.impl.MidiFileTextLineImpl
	 * @see mda.impl.MidiplayerPackageImpl#getMidiFileTextLine()
	 * @generated
	 */
	int MIDI_FILE_TEXT_LINE = 6;

	/**
	 * The feature id for the '<em><b>Chord Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIDI_FILE_TEXT_LINE__CHORD_PARTS = 0;

	/**
	 * The feature id for the '<em><b>New Slide</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MIDI_FILE_TEXT_LINE__NEW_SLIDE = 1;

  /**
	 * The number of structural features of the '<em>Midi File Text Line</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIDI_FILE_TEXT_LINE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link mda.impl.GalleryImpl <em>Gallery</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mda.impl.GalleryImpl
	 * @see mda.impl.MidiplayerPackageImpl#getGallery()
	 * @generated
	 */
	int GALLERY = 7;

	/**
	 * The feature id for the '<em><b>Gallery Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GALLERY__GALLERY_ITEMS = 0;

	/**
	 * The number of structural features of the '<em>Gallery</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GALLERY_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link mda.impl.MidiPlayerRootImpl <em>Midi Player Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mda.impl.MidiPlayerRootImpl
	 * @see mda.impl.MidiplayerPackageImpl#getMidiPlayerRoot()
	 * @generated
	 */
	int MIDI_PLAYER_ROOT = 8;

	/**
	 * The feature id for the '<em><b>Gallery</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIDI_PLAYER_ROOT__GALLERY = 0;

	/**
	 * The feature id for the '<em><b>Sessions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIDI_PLAYER_ROOT__SESSIONS = 1;

	/**
	 * The feature id for the '<em><b>Config</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MIDI_PLAYER_ROOT__CONFIG = 2;

  /**
	 * The feature id for the '<em><b>Users</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MIDI_PLAYER_ROOT__USERS = 3;

  /**
	 * The feature id for the '<em><b>Presentationschemes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MIDI_PLAYER_ROOT__PRESENTATIONSCHEMES = 4;

  /**
	 * The number of structural features of the '<em>Midi Player Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIDI_PLAYER_ROOT_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link mda.impl.MidiFileChordPartImpl <em>Midi File Chord Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mda.impl.MidiFileChordPartImpl
	 * @see mda.impl.MidiplayerPackageImpl#getMidiFileChordPart()
	 * @generated
	 */
	int MIDI_FILE_CHORD_PART = 9;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIDI_FILE_CHORD_PART__TEXT = 0;

	/**
	 * The feature id for the '<em><b>Chord</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIDI_FILE_CHORD_PART__CHORD = 1;

	/**
	 * The number of structural features of the '<em>Midi File Chord Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIDI_FILE_CHORD_PART_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link mda.impl.ConfigurationImpl <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see mda.impl.ConfigurationImpl
	 * @see mda.impl.MidiplayerPackageImpl#getConfiguration()
	 * @generated
	 */
  int CONFIGURATION = 10;

  /**
	 * The feature id for the '<em><b>Screen ID Presentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CONFIGURATION__SCREEN_ID_PRESENTATION = 0;

  /**
	 * The feature id for the '<em><b>Screen ID Admin</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CONFIGURATION__SCREEN_ID_ADMIN = 1;

  /**
	 * The feature id for the '<em><b>Last Session</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CONFIGURATION__LAST_SESSION = 2;

  /**
	 * The feature id for the '<em><b>Pdf Export Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__PDF_EXPORT_PATH = 3;

		/**
	 * The feature id for the '<em><b>Additionals Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CONFIGURATION__ADDITIONALS_PATH = 4;

    /**
	 * The feature id for the '<em><b>Fontsize</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CONFIGURATION__FONTSIZE = 5;

    /**
	 * The feature id for the '<em><b>Mailtext Send Songbook</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__MAILTEXT_SEND_SONGBOOK = 6;

				/**
	 * The feature id for the '<em><b>Mailserver Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__MAILSERVER_URL = 7;

				/**
	 * The feature id for the '<em><b>Mailserver User</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__MAILSERVER_USER = 8;

				/**
	 * The feature id for the '<em><b>Mailserver Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__MAILSERVER_PASSWORD = 9;

				/**
	 * The feature id for the '<em><b>Mailsubject Send Songbook</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__MAILSUBJECT_SEND_SONGBOOK = 10;

				/**
	 * The number of structural features of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CONFIGURATION_FEATURE_COUNT = 11;

  /**
	 * The meta object id for the '{@link mda.impl.UserImpl <em>User</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see mda.impl.UserImpl
	 * @see mda.impl.MidiplayerPackageImpl#getUser()
	 * @generated
	 */
  int USER = 11;

    /**
	 * The feature id for the '<em><b>Mail</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int USER__MAIL = 0;

    /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int USER__NAME = 1;

    /**
	 * The feature id for the '<em><b>Firstname</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int USER__FIRSTNAME = 2;

    /**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int USER__TYPE = 3;

    /**
	 * The feature id for the '<em><b>Send Songbook</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int USER__SEND_SONGBOOK = 4;

    /**
	 * The feature id for the '<em><b>Presentationschemes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int USER__PRESENTATIONSCHEMES = 5;

    /**
	 * The feature id for the '<em><b>Default Presentation Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int USER__DEFAULT_PRESENTATION_TYPE = 6;

    /**
	 * The number of structural features of the '<em>User</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int USER_FEATURE_COUNT = 7;

    /**
	 * The meta object id for the '{@link mda.impl.CopyrightImpl <em>Copyright</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see mda.impl.CopyrightImpl
	 * @see mda.impl.MidiplayerPackageImpl#getCopyright()
	 * @generated
	 */
  int COPYRIGHT = 12;

    /**
	 * The feature id for the '<em><b>Originaltitle</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int COPYRIGHT__ORIGINALTITLE = 0;

    /**
	 * The feature id for the '<em><b>Writer Music</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int COPYRIGHT__WRITER_MUSIC = 1;

    /**
	 * The feature id for the '<em><b>Writer Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int COPYRIGHT__WRITER_TEXT = 2;

    /**
	 * The feature id for the '<em><b>Writer Inland Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int COPYRIGHT__WRITER_INLAND_TEXT = 3;

    /**
	 * The feature id for the '<em><b>Year</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int COPYRIGHT__YEAR = 4;

    /**
	 * The feature id for the '<em><b>Publisher</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int COPYRIGHT__PUBLISHER = 5;

    /**
	 * The feature id for the '<em><b>Publisher Inland</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int COPYRIGHT__PUBLISHER_INLAND = 6;

    /**
	 * The number of structural features of the '<em>Copyright</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int COPYRIGHT_FEATURE_COUNT = 7;

  /**
	 * The meta object id for the '{@link mda.impl.PresentationSchemeImpl <em>Presentation Scheme</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see mda.impl.PresentationSchemeImpl
	 * @see mda.impl.MidiplayerPackageImpl#getPresentationScheme()
	 * @generated
	 */
  int PRESENTATION_SCHEME = 13;

    /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PRESENTATION_SCHEME__NAME = 0;

    /**
	 * The feature id for the '<em><b>Show Background</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PRESENTATION_SCHEME__SHOW_BACKGROUND = 1;

    /**
	 * The feature id for the '<em><b>Show Block Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PRESENTATION_SCHEME__SHOW_BLOCK_TYPE = 2;

    /**
	 * The feature id for the '<em><b>Page Per Part</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PRESENTATION_SCHEME__PAGE_PER_PART = 3;

    /**
	 * The feature id for the '<em><b>New Page Respected</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PRESENTATION_SCHEME__NEW_PAGE_RESPECTED = 4;

    /**
	 * The feature id for the '<em><b>Show Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PRESENTATION_SCHEME__SHOW_TITLE = 5;

    /**
	 * The feature id for the '<em><b>Show Copyright</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PRESENTATION_SCHEME__SHOW_COPYRIGHT = 6;

    /**
	 * The feature id for the '<em><b>Skip Empty Slides</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PRESENTATION_SCHEME__SKIP_EMPTY_SLIDES = 7;

    /**
	 * The feature id for the '<em><b>Optimize Line Filling</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PRESENTATION_SCHEME__OPTIMIZE_LINE_FILLING = 8;

    /**
	 * The feature id for the '<em><b>Optimize Equal Parts</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PRESENTATION_SCHEME__OPTIMIZE_EQUAL_PARTS = 9;

    /**
	 * The feature id for the '<em><b>Optimize Empty Tokens</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PRESENTATION_SCHEME__OPTIMIZE_EMPTY_TOKENS = 10;

    /**
	 * The feature id for the '<em><b>Border</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PRESENTATION_SCHEME__BORDER = 11;

    /**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PRESENTATION_SCHEME__TYPE = 12;

    /**
	 * The feature id for the '<em><b>Background Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PRESENTATION_SCHEME__BACKGROUND_COLOR = 13;

    /**
	 * The feature id for the '<em><b>Foreground Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PRESENTATION_SCHEME__FOREGROUND_COLOR = 14;

    /**
	 * The feature id for the '<em><b>Show Chords</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTATION_SCHEME__SHOW_CHORDS = 15;

				/**
	 * The feature id for the '<em><b>Auto Wrap To New Page</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTATION_SCHEME__AUTO_WRAP_TO_NEW_PAGE = 16;

				/**
	 * The number of structural features of the '<em>Presentation Scheme</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PRESENTATION_SCHEME_FEATURE_COUNT = 17;

  /**
	 * The meta object id for the '{@link mda.MidiFilePartType <em>Midi File Part Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mda.MidiFilePartType
	 * @see mda.impl.MidiplayerPackageImpl#getMidiFilePartType()
	 * @generated
	 */
	int MIDI_FILE_PART_TYPE = 14;


	/**
	 * The meta object id for the '{@link mda.AdditionalType <em>Additional Type</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see mda.AdditionalType
	 * @see mda.impl.MidiplayerPackageImpl#getAdditionalType()
	 * @generated
	 */
  int ADDITIONAL_TYPE = 15;


  /**
	 * The meta object id for the '{@link mda.UserType <em>User Type</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see mda.UserType
	 * @see mda.impl.MidiplayerPackageImpl#getUserType()
	 * @generated
	 */
  int USER_TYPE = 16;


  /**
	 * Returns the meta object for class '{@link mda.Session <em>Session</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Session</em>'.
	 * @see mda.Session
	 * @generated
	 */
	EClass getSession();

	/**
	 * Returns the meta object for the attribute '{@link mda.Session#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see mda.Session#getName()
	 * @see #getSession()
	 * @generated
	 */
	EAttribute getSession_Name();

	/**
	 * Returns the meta object for the reference list '{@link mda.Session#getItems <em>Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Items</em>'.
	 * @see mda.Session#getItems()
	 * @see #getSession()
	 * @generated
	 */
	EReference getSession_Items();

	/**
	 * Returns the meta object for the attribute '{@link mda.Session#getDefaultpath <em>Defaultpath</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Defaultpath</em>'.
	 * @see mda.Session#getDefaultpath()
	 * @see #getSession()
	 * @generated
	 */
	EAttribute getSession_Defaultpath();

	/**
	 * Returns the meta object for class '{@link mda.AbstractSessionItem <em>Abstract Session Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Session Item</em>'.
	 * @see mda.AbstractSessionItem
	 * @generated
	 */
	EClass getAbstractSessionItem();

	/**
	 * Returns the meta object for the attribute '{@link mda.AbstractSessionItem#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see mda.AbstractSessionItem#getName()
	 * @see #getAbstractSessionItem()
	 * @generated
	 */
	EAttribute getAbstractSessionItem_Name();

	/**
	 * Returns the meta object for the attribute '{@link mda.AbstractSessionItem#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see mda.AbstractSessionItem#getPath()
	 * @see #getAbstractSessionItem()
	 * @generated
	 */
	EAttribute getAbstractSessionItem_Path();

	/**
	 * Returns the meta object for the attribute '{@link mda.AbstractSessionItem#getBackgroundColor <em>Background Color</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Background Color</em>'.
	 * @see mda.AbstractSessionItem#getBackgroundColor()
	 * @see #getAbstractSessionItem()
	 * @generated
	 */
  EAttribute getAbstractSessionItem_BackgroundColor();

  /**
	 * Returns the meta object for the attribute '{@link mda.AbstractSessionItem#getForegroundColor <em>Foreground Color</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Foreground Color</em>'.
	 * @see mda.AbstractSessionItem#getForegroundColor()
	 * @see #getAbstractSessionItem()
	 * @generated
	 */
  EAttribute getAbstractSessionItem_ForegroundColor();

  /**
	 * Returns the meta object for class '{@link mda.MidiFile <em>Midi File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Midi File</em>'.
	 * @see mda.MidiFile
	 * @generated
	 */
	EClass getMidiFile();

	/**
	 * Returns the meta object for the containment reference list '{@link mda.MidiFile#getParts <em>Parts</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parts</em>'.
	 * @see mda.MidiFile#getParts()
	 * @see #getMidiFile()
	 * @generated
	 */
  EReference getMidiFile_Parts();

  /**
	 * Returns the meta object for the attribute '{@link mda.MidiFile#getPic <em>Pic</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pic</em>'.
	 * @see mda.MidiFile#getPic()
	 * @see #getMidiFile()
	 * @generated
	 */
  EAttribute getMidiFile_Pic();

  /**
	 * Returns the meta object for the attribute '{@link mda.MidiFile#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see mda.MidiFile#getKey()
	 * @see #getMidiFile()
	 * @generated
	 */
	EAttribute getMidiFile_Key();

		/**
	 * Returns the meta object for the containment reference '{@link mda.MidiFile#getCopyright <em>Copyright</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Copyright</em>'.
	 * @see mda.MidiFile#getCopyright()
	 * @see #getMidiFile()
	 * @generated
	 */
  EReference getMidiFile_Copyright();

    /**
	 * Returns the meta object for class '{@link mda.AbstractEvent <em>Abstract Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Event</em>'.
	 * @see mda.AbstractEvent
	 * @generated
	 */
	EClass getAbstractEvent();

	/**
	 * Returns the meta object for the attribute '{@link mda.AbstractEvent#getAtBar <em>At Bar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>At Bar</em>'.
	 * @see mda.AbstractEvent#getAtBar()
	 * @see #getAbstractEvent()
	 * @generated
	 */
	EAttribute getAbstractEvent_AtBar();

	/**
	 * Returns the meta object for class '{@link mda.TextPresentationEvent <em>Text Presentation Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text Presentation Event</em>'.
	 * @see mda.TextPresentationEvent
	 * @generated
	 */
	EClass getTextPresentationEvent();

	/**
	 * Returns the meta object for the reference list '{@link mda.TextPresentationEvent#getParts <em>Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parts</em>'.
	 * @see mda.TextPresentationEvent#getParts()
	 * @see #getTextPresentationEvent()
	 * @generated
	 */
	EReference getTextPresentationEvent_Parts();

	/**
	 * Returns the meta object for class '{@link mda.MidiFilePart <em>Midi File Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Midi File Part</em>'.
	 * @see mda.MidiFilePart
	 * @generated
	 */
	EClass getMidiFilePart();

	/**
	 * Returns the meta object for the containment reference list '{@link mda.MidiFilePart#getTextlines <em>Textlines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Textlines</em>'.
	 * @see mda.MidiFilePart#getTextlines()
	 * @see #getMidiFilePart()
	 * @generated
	 */
	EReference getMidiFilePart_Textlines();

	/**
	 * Returns the meta object for the attribute '{@link mda.MidiFilePart#getParttype <em>Parttype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parttype</em>'.
	 * @see mda.MidiFilePart#getParttype()
	 * @see #getMidiFilePart()
	 * @generated
	 */
	EAttribute getMidiFilePart_Parttype();

	/**
	 * Returns the meta object for the attribute '{@link mda.MidiFilePart#getBar <em>Bar</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bar</em>'.
	 * @see mda.MidiFilePart#getBar()
	 * @see #getMidiFilePart()
	 * @generated
	 */
  EAttribute getMidiFilePart_Bar();

  /**
	 * Returns the meta object for the reference '{@link mda.MidiFilePart#getRefPart <em>Ref Part</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref Part</em>'.
	 * @see mda.MidiFilePart#getRefPart()
	 * @see #getMidiFilePart()
	 * @generated
	 */
  EReference getMidiFilePart_RefPart();

  /**
	 * Returns the meta object for class '{@link mda.MidiFileTextLine <em>Midi File Text Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Midi File Text Line</em>'.
	 * @see mda.MidiFileTextLine
	 * @generated
	 */
	EClass getMidiFileTextLine();

	/**
	 * Returns the meta object for the containment reference list '{@link mda.MidiFileTextLine#getChordParts <em>Chord Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Chord Parts</em>'.
	 * @see mda.MidiFileTextLine#getChordParts()
	 * @see #getMidiFileTextLine()
	 * @generated
	 */
	EReference getMidiFileTextLine_ChordParts();

	/**
	 * Returns the meta object for the attribute '{@link mda.MidiFileTextLine#isNewSlide <em>New Slide</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>New Slide</em>'.
	 * @see mda.MidiFileTextLine#isNewSlide()
	 * @see #getMidiFileTextLine()
	 * @generated
	 */
  EAttribute getMidiFileTextLine_NewSlide();

  /**
	 * Returns the meta object for class '{@link mda.Gallery <em>Gallery</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gallery</em>'.
	 * @see mda.Gallery
	 * @generated
	 */
	EClass getGallery();

	/**
	 * Returns the meta object for the containment reference list '{@link mda.Gallery#getGalleryItems <em>Gallery Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Gallery Items</em>'.
	 * @see mda.Gallery#getGalleryItems()
	 * @see #getGallery()
	 * @generated
	 */
	EReference getGallery_GalleryItems();

	/**
	 * Returns the meta object for class '{@link mda.MidiPlayerRoot <em>Midi Player Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Midi Player Root</em>'.
	 * @see mda.MidiPlayerRoot
	 * @generated
	 */
	EClass getMidiPlayerRoot();

	/**
	 * Returns the meta object for the containment reference '{@link mda.MidiPlayerRoot#getGallery <em>Gallery</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Gallery</em>'.
	 * @see mda.MidiPlayerRoot#getGallery()
	 * @see #getMidiPlayerRoot()
	 * @generated
	 */
	EReference getMidiPlayerRoot_Gallery();

	/**
	 * Returns the meta object for the containment reference list '{@link mda.MidiPlayerRoot#getSessions <em>Sessions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sessions</em>'.
	 * @see mda.MidiPlayerRoot#getSessions()
	 * @see #getMidiPlayerRoot()
	 * @generated
	 */
	EReference getMidiPlayerRoot_Sessions();

	/**
	 * Returns the meta object for the containment reference '{@link mda.MidiPlayerRoot#getConfig <em>Config</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Config</em>'.
	 * @see mda.MidiPlayerRoot#getConfig()
	 * @see #getMidiPlayerRoot()
	 * @generated
	 */
  EReference getMidiPlayerRoot_Config();

  /**
	 * Returns the meta object for the containment reference list '{@link mda.MidiPlayerRoot#getUsers <em>Users</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Users</em>'.
	 * @see mda.MidiPlayerRoot#getUsers()
	 * @see #getMidiPlayerRoot()
	 * @generated
	 */
  EReference getMidiPlayerRoot_Users();

  /**
	 * Returns the meta object for the containment reference list '{@link mda.MidiPlayerRoot#getPresentationschemes <em>Presentationschemes</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Presentationschemes</em>'.
	 * @see mda.MidiPlayerRoot#getPresentationschemes()
	 * @see #getMidiPlayerRoot()
	 * @generated
	 */
  EReference getMidiPlayerRoot_Presentationschemes();

  /**
	 * Returns the meta object for class '{@link mda.MidiFileChordPart <em>Midi File Chord Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Midi File Chord Part</em>'.
	 * @see mda.MidiFileChordPart
	 * @generated
	 */
	EClass getMidiFileChordPart();

	/**
	 * Returns the meta object for the attribute '{@link mda.MidiFileChordPart#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see mda.MidiFileChordPart#getText()
	 * @see #getMidiFileChordPart()
	 * @generated
	 */
	EAttribute getMidiFileChordPart_Text();

	/**
	 * Returns the meta object for the attribute '{@link mda.MidiFileChordPart#getChord <em>Chord</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Chord</em>'.
	 * @see mda.MidiFileChordPart#getChord()
	 * @see #getMidiFileChordPart()
	 * @generated
	 */
	EAttribute getMidiFileChordPart_Chord();

	/**
	 * Returns the meta object for class '{@link mda.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see mda.Configuration
	 * @generated
	 */
  EClass getConfiguration();

  /**
	 * Returns the meta object for the attribute '{@link mda.Configuration#getScreenIDPresentation <em>Screen ID Presentation</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Screen ID Presentation</em>'.
	 * @see mda.Configuration#getScreenIDPresentation()
	 * @see #getConfiguration()
	 * @generated
	 */
  EAttribute getConfiguration_ScreenIDPresentation();

  /**
	 * Returns the meta object for the attribute '{@link mda.Configuration#getScreenIDAdmin <em>Screen ID Admin</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Screen ID Admin</em>'.
	 * @see mda.Configuration#getScreenIDAdmin()
	 * @see #getConfiguration()
	 * @generated
	 */
  EAttribute getConfiguration_ScreenIDAdmin();

  /**
	 * Returns the meta object for the reference '{@link mda.Configuration#getLastSession <em>Last Session</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Last Session</em>'.
	 * @see mda.Configuration#getLastSession()
	 * @see #getConfiguration()
	 * @generated
	 */
  EReference getConfiguration_LastSession();

  /**
	 * Returns the meta object for the attribute '{@link mda.Configuration#getPdfExportPath <em>Pdf Export Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pdf Export Path</em>'.
	 * @see mda.Configuration#getPdfExportPath()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_PdfExportPath();

		/**
	 * Returns the meta object for the attribute '{@link mda.Configuration#getAdditionalsPath <em>Additionals Path</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Additionals Path</em>'.
	 * @see mda.Configuration#getAdditionalsPath()
	 * @see #getConfiguration()
	 * @generated
	 */
  EAttribute getConfiguration_AdditionalsPath();

    /**
	 * Returns the meta object for the attribute '{@link mda.Configuration#getFontsize <em>Fontsize</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fontsize</em>'.
	 * @see mda.Configuration#getFontsize()
	 * @see #getConfiguration()
	 * @generated
	 */
  EAttribute getConfiguration_Fontsize();

    /**
	 * Returns the meta object for the attribute '{@link mda.Configuration#getMailtextSendSongbook <em>Mailtext Send Songbook</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mailtext Send Songbook</em>'.
	 * @see mda.Configuration#getMailtextSendSongbook()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_MailtextSendSongbook();

				/**
	 * Returns the meta object for the attribute '{@link mda.Configuration#getMailserverUrl <em>Mailserver Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mailserver Url</em>'.
	 * @see mda.Configuration#getMailserverUrl()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_MailserverUrl();

				/**
	 * Returns the meta object for the attribute '{@link mda.Configuration#getMailserverUser <em>Mailserver User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mailserver User</em>'.
	 * @see mda.Configuration#getMailserverUser()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_MailserverUser();

				/**
	 * Returns the meta object for the attribute '{@link mda.Configuration#getMailserverPassword <em>Mailserver Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mailserver Password</em>'.
	 * @see mda.Configuration#getMailserverPassword()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_MailserverPassword();

				/**
	 * Returns the meta object for the attribute '{@link mda.Configuration#getMailsubjectSendSongbook <em>Mailsubject Send Songbook</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mailsubject Send Songbook</em>'.
	 * @see mda.Configuration#getMailsubjectSendSongbook()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_MailsubjectSendSongbook();

				/**
	 * Returns the meta object for class '{@link mda.User <em>User</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User</em>'.
	 * @see mda.User
	 * @generated
	 */
  EClass getUser();

    /**
	 * Returns the meta object for the attribute '{@link mda.User#getMail <em>Mail</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mail</em>'.
	 * @see mda.User#getMail()
	 * @see #getUser()
	 * @generated
	 */
  EAttribute getUser_Mail();

    /**
	 * Returns the meta object for the attribute '{@link mda.User#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see mda.User#getName()
	 * @see #getUser()
	 * @generated
	 */
  EAttribute getUser_Name();

    /**
	 * Returns the meta object for the attribute '{@link mda.User#getFirstname <em>Firstname</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Firstname</em>'.
	 * @see mda.User#getFirstname()
	 * @see #getUser()
	 * @generated
	 */
  EAttribute getUser_Firstname();

    /**
	 * Returns the meta object for the attribute '{@link mda.User#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see mda.User#getType()
	 * @see #getUser()
	 * @generated
	 */
  EAttribute getUser_Type();

    /**
	 * Returns the meta object for the attribute '{@link mda.User#isSendSongbook <em>Send Songbook</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Send Songbook</em>'.
	 * @see mda.User#isSendSongbook()
	 * @see #getUser()
	 * @generated
	 */
  EAttribute getUser_SendSongbook();

    /**
	 * Returns the meta object for the containment reference list '{@link mda.User#getPresentationschemes <em>Presentationschemes</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Presentationschemes</em>'.
	 * @see mda.User#getPresentationschemes()
	 * @see #getUser()
	 * @generated
	 */
  EReference getUser_Presentationschemes();

    /**
	 * Returns the meta object for the attribute '{@link mda.User#getDefaultPresentationType <em>Default Presentation Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Presentation Type</em>'.
	 * @see mda.User#getDefaultPresentationType()
	 * @see #getUser()
	 * @generated
	 */
  EAttribute getUser_DefaultPresentationType();

    /**
	 * Returns the meta object for class '{@link mda.Copyright <em>Copyright</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Copyright</em>'.
	 * @see mda.Copyright
	 * @generated
	 */
  EClass getCopyright();

    /**
	 * Returns the meta object for the attribute '{@link mda.Copyright#getOriginaltitle <em>Originaltitle</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Originaltitle</em>'.
	 * @see mda.Copyright#getOriginaltitle()
	 * @see #getCopyright()
	 * @generated
	 */
  EAttribute getCopyright_Originaltitle();

    /**
	 * Returns the meta object for the attribute '{@link mda.Copyright#getWriterMusic <em>Writer Music</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Writer Music</em>'.
	 * @see mda.Copyright#getWriterMusic()
	 * @see #getCopyright()
	 * @generated
	 */
  EAttribute getCopyright_WriterMusic();

    /**
	 * Returns the meta object for the attribute '{@link mda.Copyright#getWriterText <em>Writer Text</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Writer Text</em>'.
	 * @see mda.Copyright#getWriterText()
	 * @see #getCopyright()
	 * @generated
	 */
  EAttribute getCopyright_WriterText();

    /**
	 * Returns the meta object for the attribute '{@link mda.Copyright#getWriterInlandText <em>Writer Inland Text</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Writer Inland Text</em>'.
	 * @see mda.Copyright#getWriterInlandText()
	 * @see #getCopyright()
	 * @generated
	 */
  EAttribute getCopyright_WriterInlandText();

    /**
	 * Returns the meta object for the attribute '{@link mda.Copyright#getYear <em>Year</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Year</em>'.
	 * @see mda.Copyright#getYear()
	 * @see #getCopyright()
	 * @generated
	 */
  EAttribute getCopyright_Year();

    /**
	 * Returns the meta object for the attribute '{@link mda.Copyright#getPublisher <em>Publisher</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Publisher</em>'.
	 * @see mda.Copyright#getPublisher()
	 * @see #getCopyright()
	 * @generated
	 */
  EAttribute getCopyright_Publisher();

    /**
	 * Returns the meta object for the attribute '{@link mda.Copyright#getPublisherInland <em>Publisher Inland</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Publisher Inland</em>'.
	 * @see mda.Copyright#getPublisherInland()
	 * @see #getCopyright()
	 * @generated
	 */
  EAttribute getCopyright_PublisherInland();

    /**
	 * Returns the meta object for class '{@link mda.PresentationScheme <em>Presentation Scheme</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Presentation Scheme</em>'.
	 * @see mda.PresentationScheme
	 * @generated
	 */
  EClass getPresentationScheme();

    /**
	 * Returns the meta object for the attribute '{@link mda.PresentationScheme#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see mda.PresentationScheme#getName()
	 * @see #getPresentationScheme()
	 * @generated
	 */
  EAttribute getPresentationScheme_Name();

    /**
	 * Returns the meta object for the attribute '{@link mda.PresentationScheme#getShowBackground <em>Show Background</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Show Background</em>'.
	 * @see mda.PresentationScheme#getShowBackground()
	 * @see #getPresentationScheme()
	 * @generated
	 */
  EAttribute getPresentationScheme_ShowBackground();

    /**
	 * Returns the meta object for the attribute '{@link mda.PresentationScheme#getShowBlockType <em>Show Block Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Show Block Type</em>'.
	 * @see mda.PresentationScheme#getShowBlockType()
	 * @see #getPresentationScheme()
	 * @generated
	 */
  EAttribute getPresentationScheme_ShowBlockType();

    /**
	 * Returns the meta object for the attribute '{@link mda.PresentationScheme#getPagePerPart <em>Page Per Part</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Page Per Part</em>'.
	 * @see mda.PresentationScheme#getPagePerPart()
	 * @see #getPresentationScheme()
	 * @generated
	 */
  EAttribute getPresentationScheme_PagePerPart();

    /**
	 * Returns the meta object for the attribute '{@link mda.PresentationScheme#getNewPageRespected <em>New Page Respected</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>New Page Respected</em>'.
	 * @see mda.PresentationScheme#getNewPageRespected()
	 * @see #getPresentationScheme()
	 * @generated
	 */
  EAttribute getPresentationScheme_NewPageRespected();

    /**
	 * Returns the meta object for the attribute '{@link mda.PresentationScheme#getShowTitle <em>Show Title</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Show Title</em>'.
	 * @see mda.PresentationScheme#getShowTitle()
	 * @see #getPresentationScheme()
	 * @generated
	 */
  EAttribute getPresentationScheme_ShowTitle();

    /**
	 * Returns the meta object for the attribute '{@link mda.PresentationScheme#getShowCopyright <em>Show Copyright</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Show Copyright</em>'.
	 * @see mda.PresentationScheme#getShowCopyright()
	 * @see #getPresentationScheme()
	 * @generated
	 */
  EAttribute getPresentationScheme_ShowCopyright();

    /**
	 * Returns the meta object for the attribute '{@link mda.PresentationScheme#getSkipEmptySlides <em>Skip Empty Slides</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Skip Empty Slides</em>'.
	 * @see mda.PresentationScheme#getSkipEmptySlides()
	 * @see #getPresentationScheme()
	 * @generated
	 */
  EAttribute getPresentationScheme_SkipEmptySlides();

    /**
	 * Returns the meta object for the attribute '{@link mda.PresentationScheme#getOptimizeLineFilling <em>Optimize Line Filling</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Optimize Line Filling</em>'.
	 * @see mda.PresentationScheme#getOptimizeLineFilling()
	 * @see #getPresentationScheme()
	 * @generated
	 */
  EAttribute getPresentationScheme_OptimizeLineFilling();

    /**
	 * Returns the meta object for the attribute '{@link mda.PresentationScheme#getOptimizeEqualParts <em>Optimize Equal Parts</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Optimize Equal Parts</em>'.
	 * @see mda.PresentationScheme#getOptimizeEqualParts()
	 * @see #getPresentationScheme()
	 * @generated
	 */
  EAttribute getPresentationScheme_OptimizeEqualParts();

    /**
	 * Returns the meta object for the attribute '{@link mda.PresentationScheme#getOptimizeEmptyTokens <em>Optimize Empty Tokens</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Optimize Empty Tokens</em>'.
	 * @see mda.PresentationScheme#getOptimizeEmptyTokens()
	 * @see #getPresentationScheme()
	 * @generated
	 */
  EAttribute getPresentationScheme_OptimizeEmptyTokens();

    /**
	 * Returns the meta object for the attribute '{@link mda.PresentationScheme#getBorder <em>Border</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Border</em>'.
	 * @see mda.PresentationScheme#getBorder()
	 * @see #getPresentationScheme()
	 * @generated
	 */
  EAttribute getPresentationScheme_Border();

    /**
	 * Returns the meta object for the attribute '{@link mda.PresentationScheme#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see mda.PresentationScheme#getType()
	 * @see #getPresentationScheme()
	 * @generated
	 */
  EAttribute getPresentationScheme_Type();

    /**
	 * Returns the meta object for the attribute '{@link mda.PresentationScheme#getBackgroundColor <em>Background Color</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Background Color</em>'.
	 * @see mda.PresentationScheme#getBackgroundColor()
	 * @see #getPresentationScheme()
	 * @generated
	 */
  EAttribute getPresentationScheme_BackgroundColor();

    /**
	 * Returns the meta object for the attribute '{@link mda.PresentationScheme#getForegroundColor <em>Foreground Color</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Foreground Color</em>'.
	 * @see mda.PresentationScheme#getForegroundColor()
	 * @see #getPresentationScheme()
	 * @generated
	 */
  EAttribute getPresentationScheme_ForegroundColor();

    /**
	 * Returns the meta object for the attribute '{@link mda.PresentationScheme#getShowChords <em>Show Chords</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Show Chords</em>'.
	 * @see mda.PresentationScheme#getShowChords()
	 * @see #getPresentationScheme()
	 * @generated
	 */
	EAttribute getPresentationScheme_ShowChords();

				/**
	 * Returns the meta object for the attribute '{@link mda.PresentationScheme#getAutoWrapToNewPage <em>Auto Wrap To New Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Auto Wrap To New Page</em>'.
	 * @see mda.PresentationScheme#getAutoWrapToNewPage()
	 * @see #getPresentationScheme()
	 * @generated
	 */
	EAttribute getPresentationScheme_AutoWrapToNewPage();

				/**
	 * Returns the meta object for enum '{@link mda.MidiFilePartType <em>Midi File Part Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Midi File Part Type</em>'.
	 * @see mda.MidiFilePartType
	 * @generated
	 */
	EEnum getMidiFilePartType();

	/**
	 * Returns the meta object for enum '{@link mda.AdditionalType <em>Additional Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Additional Type</em>'.
	 * @see mda.AdditionalType
	 * @generated
	 */
  EEnum getAdditionalType();

  /**
	 * Returns the meta object for enum '{@link mda.UserType <em>User Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>User Type</em>'.
	 * @see mda.UserType
	 * @generated
	 */
  EEnum getUserType();

  /**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MidiplayerFactory getMidiplayerFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link mda.impl.SessionImpl <em>Session</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mda.impl.SessionImpl
		 * @see mda.impl.MidiplayerPackageImpl#getSession()
		 * @generated
		 */
		EClass SESSION = eINSTANCE.getSession();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SESSION__NAME = eINSTANCE.getSession_Name();

		/**
		 * The meta object literal for the '<em><b>Items</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SESSION__ITEMS = eINSTANCE.getSession_Items();

		/**
		 * The meta object literal for the '<em><b>Defaultpath</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SESSION__DEFAULTPATH = eINSTANCE.getSession_Defaultpath();

		/**
		 * The meta object literal for the '{@link mda.impl.AbstractSessionItemImpl <em>Abstract Session Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mda.impl.AbstractSessionItemImpl
		 * @see mda.impl.MidiplayerPackageImpl#getAbstractSessionItem()
		 * @generated
		 */
		EClass ABSTRACT_SESSION_ITEM = eINSTANCE.getAbstractSessionItem();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_SESSION_ITEM__NAME = eINSTANCE.getAbstractSessionItem_Name();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_SESSION_ITEM__PATH = eINSTANCE.getAbstractSessionItem_Path();

		/**
		 * The meta object literal for the '<em><b>Background Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute ABSTRACT_SESSION_ITEM__BACKGROUND_COLOR = eINSTANCE.getAbstractSessionItem_BackgroundColor();

    /**
		 * The meta object literal for the '<em><b>Foreground Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute ABSTRACT_SESSION_ITEM__FOREGROUND_COLOR = eINSTANCE.getAbstractSessionItem_ForegroundColor();

    /**
		 * The meta object literal for the '{@link mda.impl.MidiFileImpl <em>Midi File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mda.impl.MidiFileImpl
		 * @see mda.impl.MidiplayerPackageImpl#getMidiFile()
		 * @generated
		 */
		EClass MIDI_FILE = eINSTANCE.getMidiFile();

		/**
		 * The meta object literal for the '<em><b>Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference MIDI_FILE__PARTS = eINSTANCE.getMidiFile_Parts();

    /**
		 * The meta object literal for the '<em><b>Pic</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute MIDI_FILE__PIC = eINSTANCE.getMidiFile_Pic();

    /**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MIDI_FILE__KEY = eINSTANCE.getMidiFile_Key();

				/**
		 * The meta object literal for the '<em><b>Copyright</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference MIDI_FILE__COPYRIGHT = eINSTANCE.getMidiFile_Copyright();

        /**
		 * The meta object literal for the '{@link mda.impl.AbstractEventImpl <em>Abstract Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mda.impl.AbstractEventImpl
		 * @see mda.impl.MidiplayerPackageImpl#getAbstractEvent()
		 * @generated
		 */
		EClass ABSTRACT_EVENT = eINSTANCE.getAbstractEvent();

		/**
		 * The meta object literal for the '<em><b>At Bar</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_EVENT__AT_BAR = eINSTANCE.getAbstractEvent_AtBar();

		/**
		 * The meta object literal for the '{@link mda.impl.TextPresentationEventImpl <em>Text Presentation Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mda.impl.TextPresentationEventImpl
		 * @see mda.impl.MidiplayerPackageImpl#getTextPresentationEvent()
		 * @generated
		 */
		EClass TEXT_PRESENTATION_EVENT = eINSTANCE.getTextPresentationEvent();

		/**
		 * The meta object literal for the '<em><b>Parts</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEXT_PRESENTATION_EVENT__PARTS = eINSTANCE.getTextPresentationEvent_Parts();

		/**
		 * The meta object literal for the '{@link mda.impl.MidiFilePartImpl <em>Midi File Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mda.impl.MidiFilePartImpl
		 * @see mda.impl.MidiplayerPackageImpl#getMidiFilePart()
		 * @generated
		 */
		EClass MIDI_FILE_PART = eINSTANCE.getMidiFilePart();

		/**
		 * The meta object literal for the '<em><b>Textlines</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MIDI_FILE_PART__TEXTLINES = eINSTANCE.getMidiFilePart_Textlines();

		/**
		 * The meta object literal for the '<em><b>Parttype</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MIDI_FILE_PART__PARTTYPE = eINSTANCE.getMidiFilePart_Parttype();

		/**
		 * The meta object literal for the '<em><b>Bar</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute MIDI_FILE_PART__BAR = eINSTANCE.getMidiFilePart_Bar();

    /**
		 * The meta object literal for the '<em><b>Ref Part</b></em>' reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference MIDI_FILE_PART__REF_PART = eINSTANCE.getMidiFilePart_RefPart();

    /**
		 * The meta object literal for the '{@link mda.impl.MidiFileTextLineImpl <em>Midi File Text Line</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mda.impl.MidiFileTextLineImpl
		 * @see mda.impl.MidiplayerPackageImpl#getMidiFileTextLine()
		 * @generated
		 */
		EClass MIDI_FILE_TEXT_LINE = eINSTANCE.getMidiFileTextLine();

		/**
		 * The meta object literal for the '<em><b>Chord Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MIDI_FILE_TEXT_LINE__CHORD_PARTS = eINSTANCE.getMidiFileTextLine_ChordParts();

		/**
		 * The meta object literal for the '<em><b>New Slide</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute MIDI_FILE_TEXT_LINE__NEW_SLIDE = eINSTANCE.getMidiFileTextLine_NewSlide();

    /**
		 * The meta object literal for the '{@link mda.impl.GalleryImpl <em>Gallery</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mda.impl.GalleryImpl
		 * @see mda.impl.MidiplayerPackageImpl#getGallery()
		 * @generated
		 */
		EClass GALLERY = eINSTANCE.getGallery();

		/**
		 * The meta object literal for the '<em><b>Gallery Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GALLERY__GALLERY_ITEMS = eINSTANCE.getGallery_GalleryItems();

		/**
		 * The meta object literal for the '{@link mda.impl.MidiPlayerRootImpl <em>Midi Player Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mda.impl.MidiPlayerRootImpl
		 * @see mda.impl.MidiplayerPackageImpl#getMidiPlayerRoot()
		 * @generated
		 */
		EClass MIDI_PLAYER_ROOT = eINSTANCE.getMidiPlayerRoot();

		/**
		 * The meta object literal for the '<em><b>Gallery</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MIDI_PLAYER_ROOT__GALLERY = eINSTANCE.getMidiPlayerRoot_Gallery();

		/**
		 * The meta object literal for the '<em><b>Sessions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MIDI_PLAYER_ROOT__SESSIONS = eINSTANCE.getMidiPlayerRoot_Sessions();

		/**
		 * The meta object literal for the '<em><b>Config</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference MIDI_PLAYER_ROOT__CONFIG = eINSTANCE.getMidiPlayerRoot_Config();

    /**
		 * The meta object literal for the '<em><b>Users</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference MIDI_PLAYER_ROOT__USERS = eINSTANCE.getMidiPlayerRoot_Users();

    /**
		 * The meta object literal for the '<em><b>Presentationschemes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference MIDI_PLAYER_ROOT__PRESENTATIONSCHEMES = eINSTANCE.getMidiPlayerRoot_Presentationschemes();

    /**
		 * The meta object literal for the '{@link mda.impl.MidiFileChordPartImpl <em>Midi File Chord Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mda.impl.MidiFileChordPartImpl
		 * @see mda.impl.MidiplayerPackageImpl#getMidiFileChordPart()
		 * @generated
		 */
		EClass MIDI_FILE_CHORD_PART = eINSTANCE.getMidiFileChordPart();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MIDI_FILE_CHORD_PART__TEXT = eINSTANCE.getMidiFileChordPart_Text();

		/**
		 * The meta object literal for the '<em><b>Chord</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MIDI_FILE_CHORD_PART__CHORD = eINSTANCE.getMidiFileChordPart_Chord();

		/**
		 * The meta object literal for the '{@link mda.impl.ConfigurationImpl <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see mda.impl.ConfigurationImpl
		 * @see mda.impl.MidiplayerPackageImpl#getConfiguration()
		 * @generated
		 */
    EClass CONFIGURATION = eINSTANCE.getConfiguration();

    /**
		 * The meta object literal for the '<em><b>Screen ID Presentation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute CONFIGURATION__SCREEN_ID_PRESENTATION = eINSTANCE.getConfiguration_ScreenIDPresentation();

    /**
		 * The meta object literal for the '<em><b>Screen ID Admin</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute CONFIGURATION__SCREEN_ID_ADMIN = eINSTANCE.getConfiguration_ScreenIDAdmin();

    /**
		 * The meta object literal for the '<em><b>Last Session</b></em>' reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference CONFIGURATION__LAST_SESSION = eINSTANCE.getConfiguration_LastSession();

    /**
		 * The meta object literal for the '<em><b>Pdf Export Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__PDF_EXPORT_PATH = eINSTANCE.getConfiguration_PdfExportPath();

				/**
		 * The meta object literal for the '<em><b>Additionals Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute CONFIGURATION__ADDITIONALS_PATH = eINSTANCE.getConfiguration_AdditionalsPath();

        /**
		 * The meta object literal for the '<em><b>Fontsize</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute CONFIGURATION__FONTSIZE = eINSTANCE.getConfiguration_Fontsize();

        /**
		 * The meta object literal for the '<em><b>Mailtext Send Songbook</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__MAILTEXT_SEND_SONGBOOK = eINSTANCE.getConfiguration_MailtextSendSongbook();

								/**
		 * The meta object literal for the '<em><b>Mailserver Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__MAILSERVER_URL = eINSTANCE.getConfiguration_MailserverUrl();

								/**
		 * The meta object literal for the '<em><b>Mailserver User</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__MAILSERVER_USER = eINSTANCE.getConfiguration_MailserverUser();

								/**
		 * The meta object literal for the '<em><b>Mailserver Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__MAILSERVER_PASSWORD = eINSTANCE.getConfiguration_MailserverPassword();

								/**
		 * The meta object literal for the '<em><b>Mailsubject Send Songbook</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__MAILSUBJECT_SEND_SONGBOOK = eINSTANCE.getConfiguration_MailsubjectSendSongbook();

								/**
		 * The meta object literal for the '{@link mda.impl.UserImpl <em>User</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see mda.impl.UserImpl
		 * @see mda.impl.MidiplayerPackageImpl#getUser()
		 * @generated
		 */
    EClass USER = eINSTANCE.getUser();

        /**
		 * The meta object literal for the '<em><b>Mail</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute USER__MAIL = eINSTANCE.getUser_Mail();

        /**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute USER__NAME = eINSTANCE.getUser_Name();

        /**
		 * The meta object literal for the '<em><b>Firstname</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute USER__FIRSTNAME = eINSTANCE.getUser_Firstname();

        /**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute USER__TYPE = eINSTANCE.getUser_Type();

        /**
		 * The meta object literal for the '<em><b>Send Songbook</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute USER__SEND_SONGBOOK = eINSTANCE.getUser_SendSongbook();

        /**
		 * The meta object literal for the '<em><b>Presentationschemes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference USER__PRESENTATIONSCHEMES = eINSTANCE.getUser_Presentationschemes();

        /**
		 * The meta object literal for the '<em><b>Default Presentation Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute USER__DEFAULT_PRESENTATION_TYPE = eINSTANCE.getUser_DefaultPresentationType();

        /**
		 * The meta object literal for the '{@link mda.impl.CopyrightImpl <em>Copyright</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see mda.impl.CopyrightImpl
		 * @see mda.impl.MidiplayerPackageImpl#getCopyright()
		 * @generated
		 */
    EClass COPYRIGHT = eINSTANCE.getCopyright();

        /**
		 * The meta object literal for the '<em><b>Originaltitle</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute COPYRIGHT__ORIGINALTITLE = eINSTANCE.getCopyright_Originaltitle();

        /**
		 * The meta object literal for the '<em><b>Writer Music</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute COPYRIGHT__WRITER_MUSIC = eINSTANCE.getCopyright_WriterMusic();

        /**
		 * The meta object literal for the '<em><b>Writer Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute COPYRIGHT__WRITER_TEXT = eINSTANCE.getCopyright_WriterText();

        /**
		 * The meta object literal for the '<em><b>Writer Inland Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute COPYRIGHT__WRITER_INLAND_TEXT = eINSTANCE.getCopyright_WriterInlandText();

        /**
		 * The meta object literal for the '<em><b>Year</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute COPYRIGHT__YEAR = eINSTANCE.getCopyright_Year();

        /**
		 * The meta object literal for the '<em><b>Publisher</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute COPYRIGHT__PUBLISHER = eINSTANCE.getCopyright_Publisher();

        /**
		 * The meta object literal for the '<em><b>Publisher Inland</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute COPYRIGHT__PUBLISHER_INLAND = eINSTANCE.getCopyright_PublisherInland();

        /**
		 * The meta object literal for the '{@link mda.impl.PresentationSchemeImpl <em>Presentation Scheme</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see mda.impl.PresentationSchemeImpl
		 * @see mda.impl.MidiplayerPackageImpl#getPresentationScheme()
		 * @generated
		 */
    EClass PRESENTATION_SCHEME = eINSTANCE.getPresentationScheme();

        /**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute PRESENTATION_SCHEME__NAME = eINSTANCE.getPresentationScheme_Name();

        /**
		 * The meta object literal for the '<em><b>Show Background</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute PRESENTATION_SCHEME__SHOW_BACKGROUND = eINSTANCE.getPresentationScheme_ShowBackground();

        /**
		 * The meta object literal for the '<em><b>Show Block Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute PRESENTATION_SCHEME__SHOW_BLOCK_TYPE = eINSTANCE.getPresentationScheme_ShowBlockType();

        /**
		 * The meta object literal for the '<em><b>Page Per Part</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute PRESENTATION_SCHEME__PAGE_PER_PART = eINSTANCE.getPresentationScheme_PagePerPart();

        /**
		 * The meta object literal for the '<em><b>New Page Respected</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute PRESENTATION_SCHEME__NEW_PAGE_RESPECTED = eINSTANCE.getPresentationScheme_NewPageRespected();

        /**
		 * The meta object literal for the '<em><b>Show Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute PRESENTATION_SCHEME__SHOW_TITLE = eINSTANCE.getPresentationScheme_ShowTitle();

        /**
		 * The meta object literal for the '<em><b>Show Copyright</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute PRESENTATION_SCHEME__SHOW_COPYRIGHT = eINSTANCE.getPresentationScheme_ShowCopyright();

        /**
		 * The meta object literal for the '<em><b>Skip Empty Slides</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute PRESENTATION_SCHEME__SKIP_EMPTY_SLIDES = eINSTANCE.getPresentationScheme_SkipEmptySlides();

        /**
		 * The meta object literal for the '<em><b>Optimize Line Filling</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute PRESENTATION_SCHEME__OPTIMIZE_LINE_FILLING = eINSTANCE.getPresentationScheme_OptimizeLineFilling();

        /**
		 * The meta object literal for the '<em><b>Optimize Equal Parts</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute PRESENTATION_SCHEME__OPTIMIZE_EQUAL_PARTS = eINSTANCE.getPresentationScheme_OptimizeEqualParts();

        /**
		 * The meta object literal for the '<em><b>Optimize Empty Tokens</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute PRESENTATION_SCHEME__OPTIMIZE_EMPTY_TOKENS = eINSTANCE.getPresentationScheme_OptimizeEmptyTokens();

        /**
		 * The meta object literal for the '<em><b>Border</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute PRESENTATION_SCHEME__BORDER = eINSTANCE.getPresentationScheme_Border();

        /**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute PRESENTATION_SCHEME__TYPE = eINSTANCE.getPresentationScheme_Type();

        /**
		 * The meta object literal for the '<em><b>Background Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute PRESENTATION_SCHEME__BACKGROUND_COLOR = eINSTANCE.getPresentationScheme_BackgroundColor();

        /**
		 * The meta object literal for the '<em><b>Foreground Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute PRESENTATION_SCHEME__FOREGROUND_COLOR = eINSTANCE.getPresentationScheme_ForegroundColor();

        /**
		 * The meta object literal for the '<em><b>Show Chords</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRESENTATION_SCHEME__SHOW_CHORDS = eINSTANCE.getPresentationScheme_ShowChords();

								/**
		 * The meta object literal for the '<em><b>Auto Wrap To New Page</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRESENTATION_SCHEME__AUTO_WRAP_TO_NEW_PAGE = eINSTANCE.getPresentationScheme_AutoWrapToNewPage();

								/**
		 * The meta object literal for the '{@link mda.MidiFilePartType <em>Midi File Part Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mda.MidiFilePartType
		 * @see mda.impl.MidiplayerPackageImpl#getMidiFilePartType()
		 * @generated
		 */
		EEnum MIDI_FILE_PART_TYPE = eINSTANCE.getMidiFilePartType();

        /**
		 * The meta object literal for the '{@link mda.AdditionalType <em>Additional Type</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see mda.AdditionalType
		 * @see mda.impl.MidiplayerPackageImpl#getAdditionalType()
		 * @generated
		 */
    EEnum ADDITIONAL_TYPE = eINSTANCE.getAdditionalType();

        /**
		 * The meta object literal for the '{@link mda.UserType <em>User Type</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see mda.UserType
		 * @see mda.impl.MidiplayerPackageImpl#getUserType()
		 * @generated
		 */
    EEnum USER_TYPE = eINSTANCE.getUserType();

	}

} //MidiplayerPackage
