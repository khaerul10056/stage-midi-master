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
	 * The meta object id for the '{@link mda.impl.SongImpl <em>Song</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mda.impl.SongImpl
	 * @see mda.impl.MidiplayerPackageImpl#getSong()
	 * @generated
	 */
	int SONG = 2;

		/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SONG__NAME = ABSTRACT_SESSION_ITEM__NAME;

		/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SONG__PATH = ABSTRACT_SESSION_ITEM__PATH;

		/**
	 * The feature id for the '<em><b>Background Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SONG__BACKGROUND_COLOR = ABSTRACT_SESSION_ITEM__BACKGROUND_COLOR;

		/**
	 * The feature id for the '<em><b>Foreground Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SONG__FOREGROUND_COLOR = ABSTRACT_SESSION_ITEM__FOREGROUND_COLOR;

		/**
	 * The feature id for the '<em><b>Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SONG__PARTS = ABSTRACT_SESSION_ITEM_FEATURE_COUNT + 0;

		/**
	 * The feature id for the '<em><b>Pic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SONG__PIC = ABSTRACT_SESSION_ITEM_FEATURE_COUNT + 1;

		/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SONG__KEY = ABSTRACT_SESSION_ITEM_FEATURE_COUNT + 2;

		/**
	 * The feature id for the '<em><b>Copyright</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SONG__COPYRIGHT = ABSTRACT_SESSION_ITEM_FEATURE_COUNT + 3;

		/**
	 * The feature id for the '<em><b>Midicontrol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SONG__MIDICONTROL = ABSTRACT_SESSION_ITEM_FEATURE_COUNT + 4;

		/**
	 * The number of structural features of the '<em>Song</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SONG_FEATURE_COUNT = ABSTRACT_SESSION_ITEM_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link mda.impl.SongPartImpl <em>Song Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mda.impl.SongPartImpl
	 * @see mda.impl.MidiplayerPackageImpl#getSongPart()
	 * @generated
	 */
	int SONG_PART = 3;

		/**
	 * The feature id for the '<em><b>Textlines</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SONG_PART__TEXTLINES = 0;

		/**
	 * The feature id for the '<em><b>Parttype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SONG_PART__PARTTYPE = 1;

		/**
	 * The feature id for the '<em><b>Bar</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SONG_PART__BAR = 2;

		/**
	 * The feature id for the '<em><b>Ref Part</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SONG_PART__REF_PART = 3;

		/**
	 * The feature id for the '<em><b>Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SONG_PART__POSITION = 4;

		/**
	 * The number of structural features of the '<em>Song Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SONG_PART_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link mda.impl.SongTextLineImpl <em>Song Text Line</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mda.impl.SongTextLineImpl
	 * @see mda.impl.MidiplayerPackageImpl#getSongTextLine()
	 * @generated
	 */
	int SONG_TEXT_LINE = 4;

		/**
	 * The feature id for the '<em><b>Chord Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SONG_TEXT_LINE__CHORD_PARTS = 0;

		/**
	 * The feature id for the '<em><b>New Slide</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SONG_TEXT_LINE__NEW_SLIDE = 1;

		/**
	 * The number of structural features of the '<em>Song Text Line</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SONG_TEXT_LINE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link mda.impl.GalleryImpl <em>Gallery</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mda.impl.GalleryImpl
	 * @see mda.impl.MidiplayerPackageImpl#getGallery()
	 * @generated
	 */
	int GALLERY = 5;

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
	int MIDI_PLAYER_ROOT = 6;

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
	 * The meta object id for the '{@link mda.impl.SongChordPartImpl <em>Song Chord Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mda.impl.SongChordPartImpl
	 * @see mda.impl.MidiplayerPackageImpl#getSongChordPart()
	 * @generated
	 */
	int SONG_CHORD_PART = 7;

		/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SONG_CHORD_PART__TEXT = 0;

		/**
	 * The feature id for the '<em><b>Chord</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SONG_CHORD_PART__CHORD = 1;

		/**
	 * The number of structural features of the '<em>Song Chord Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SONG_CHORD_PART_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link mda.impl.ConfigurationImpl <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see mda.impl.ConfigurationImpl
	 * @see mda.impl.MidiplayerPackageImpl#getConfiguration()
	 * @generated
	 */
  int CONFIGURATION = 8;

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
	 * The feature id for the '<em><b>Mididevice</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__MIDIDEVICE = 11;

				/**
	 * The number of structural features of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CONFIGURATION_FEATURE_COUNT = 12;

  /**
	 * The meta object id for the '{@link mda.impl.UserImpl <em>User</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see mda.impl.UserImpl
	 * @see mda.impl.MidiplayerPackageImpl#getUser()
	 * @generated
	 */
  int USER = 9;

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
  int COPYRIGHT = 10;

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
  int PRESENTATION_SCHEME = 11;

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
	 * The feature id for the '<em><b>Autosizing Percent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTATION_SCHEME__AUTOSIZING_PERCENT = 17;

				/**
	 * The number of structural features of the '<em>Presentation Scheme</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int PRESENTATION_SCHEME_FEATURE_COUNT = 18;

  /**
	 * The meta object id for the '{@link mda.SongPartType <em>Song Part Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mda.SongPartType
	 * @see mda.impl.MidiplayerPackageImpl#getSongPartType()
	 * @generated
	 */
	int SONG_PART_TYPE = 12;

		/**
	 * The meta object id for the '{@link mda.AdditionalType <em>Additional Type</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see mda.AdditionalType
	 * @see mda.impl.MidiplayerPackageImpl#getAdditionalType()
	 * @generated
	 */
  int ADDITIONAL_TYPE = 13;


  /**
	 * The meta object id for the '{@link mda.UserType <em>User Type</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see mda.UserType
	 * @see mda.impl.MidiplayerPackageImpl#getUserType()
	 * @generated
	 */
  int USER_TYPE = 14;


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
	 * Returns the meta object for class '{@link mda.Song <em>Song</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Song</em>'.
	 * @see mda.Song
	 * @generated
	 */
	EClass getSong();

		/**
	 * Returns the meta object for the containment reference list '{@link mda.Song#getParts <em>Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parts</em>'.
	 * @see mda.Song#getParts()
	 * @see #getSong()
	 * @generated
	 */
	EReference getSong_Parts();

		/**
	 * Returns the meta object for the attribute '{@link mda.Song#getPic <em>Pic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pic</em>'.
	 * @see mda.Song#getPic()
	 * @see #getSong()
	 * @generated
	 */
	EAttribute getSong_Pic();

		/**
	 * Returns the meta object for the attribute '{@link mda.Song#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see mda.Song#getKey()
	 * @see #getSong()
	 * @generated
	 */
	EAttribute getSong_Key();

		/**
	 * Returns the meta object for the containment reference '{@link mda.Song#getCopyright <em>Copyright</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Copyright</em>'.
	 * @see mda.Song#getCopyright()
	 * @see #getSong()
	 * @generated
	 */
	EReference getSong_Copyright();

		/**
	 * Returns the meta object for the attribute '{@link mda.Song#getMidicontrol <em>Midicontrol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Midicontrol</em>'.
	 * @see mda.Song#getMidicontrol()
	 * @see #getSong()
	 * @generated
	 */
	EAttribute getSong_Midicontrol();

		/**
	 * Returns the meta object for class '{@link mda.SongPart <em>Song Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Song Part</em>'.
	 * @see mda.SongPart
	 * @generated
	 */
	EClass getSongPart();

		/**
	 * Returns the meta object for the containment reference list '{@link mda.SongPart#getTextlines <em>Textlines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Textlines</em>'.
	 * @see mda.SongPart#getTextlines()
	 * @see #getSongPart()
	 * @generated
	 */
	EReference getSongPart_Textlines();

		/**
	 * Returns the meta object for the attribute '{@link mda.SongPart#getParttype <em>Parttype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parttype</em>'.
	 * @see mda.SongPart#getParttype()
	 * @see #getSongPart()
	 * @generated
	 */
	EAttribute getSongPart_Parttype();

		/**
	 * Returns the meta object for the attribute '{@link mda.SongPart#getBar <em>Bar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bar</em>'.
	 * @see mda.SongPart#getBar()
	 * @see #getSongPart()
	 * @generated
	 */
	EAttribute getSongPart_Bar();

		/**
	 * Returns the meta object for the reference '{@link mda.SongPart#getRefPart <em>Ref Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref Part</em>'.
	 * @see mda.SongPart#getRefPart()
	 * @see #getSongPart()
	 * @generated
	 */
	EReference getSongPart_RefPart();

		/**
	 * Returns the meta object for the attribute '{@link mda.SongPart#getPosition <em>Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Position</em>'.
	 * @see mda.SongPart#getPosition()
	 * @see #getSongPart()
	 * @generated
	 */
	EAttribute getSongPart_Position();

		/**
	 * Returns the meta object for class '{@link mda.SongTextLine <em>Song Text Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Song Text Line</em>'.
	 * @see mda.SongTextLine
	 * @generated
	 */
	EClass getSongTextLine();

		/**
	 * Returns the meta object for the containment reference list '{@link mda.SongTextLine#getChordParts <em>Chord Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Chord Parts</em>'.
	 * @see mda.SongTextLine#getChordParts()
	 * @see #getSongTextLine()
	 * @generated
	 */
	EReference getSongTextLine_ChordParts();

		/**
	 * Returns the meta object for the attribute '{@link mda.SongTextLine#isNewSlide <em>New Slide</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>New Slide</em>'.
	 * @see mda.SongTextLine#isNewSlide()
	 * @see #getSongTextLine()
	 * @generated
	 */
	EAttribute getSongTextLine_NewSlide();

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
	 * Returns the meta object for class '{@link mda.SongChordPart <em>Song Chord Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Song Chord Part</em>'.
	 * @see mda.SongChordPart
	 * @generated
	 */
	EClass getSongChordPart();

		/**
	 * Returns the meta object for the attribute '{@link mda.SongChordPart#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see mda.SongChordPart#getText()
	 * @see #getSongChordPart()
	 * @generated
	 */
	EAttribute getSongChordPart_Text();

		/**
	 * Returns the meta object for the attribute '{@link mda.SongChordPart#getChord <em>Chord</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Chord</em>'.
	 * @see mda.SongChordPart#getChord()
	 * @see #getSongChordPart()
	 * @generated
	 */
	EAttribute getSongChordPart_Chord();

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
	 * Returns the meta object for the attribute '{@link mda.Configuration#getMididevice <em>Mididevice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mididevice</em>'.
	 * @see mda.Configuration#getMididevice()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_Mididevice();

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
	 * Returns the meta object for the attribute '{@link mda.PresentationScheme#getAutosizingPercent <em>Autosizing Percent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Autosizing Percent</em>'.
	 * @see mda.PresentationScheme#getAutosizingPercent()
	 * @see #getPresentationScheme()
	 * @generated
	 */
	EAttribute getPresentationScheme_AutosizingPercent();

				/**
	 * Returns the meta object for enum '{@link mda.SongPartType <em>Song Part Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Song Part Type</em>'.
	 * @see mda.SongPartType
	 * @generated
	 */
	EEnum getSongPartType();

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
		 * The meta object literal for the '{@link mda.impl.SongImpl <em>Song</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mda.impl.SongImpl
		 * @see mda.impl.MidiplayerPackageImpl#getSong()
		 * @generated
		 */
		EClass SONG = eINSTANCE.getSong();

				/**
		 * The meta object literal for the '<em><b>Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SONG__PARTS = eINSTANCE.getSong_Parts();

				/**
		 * The meta object literal for the '<em><b>Pic</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SONG__PIC = eINSTANCE.getSong_Pic();

				/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SONG__KEY = eINSTANCE.getSong_Key();

				/**
		 * The meta object literal for the '<em><b>Copyright</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SONG__COPYRIGHT = eINSTANCE.getSong_Copyright();

				/**
		 * The meta object literal for the '<em><b>Midicontrol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SONG__MIDICONTROL = eINSTANCE.getSong_Midicontrol();

				/**
		 * The meta object literal for the '{@link mda.impl.SongPartImpl <em>Song Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mda.impl.SongPartImpl
		 * @see mda.impl.MidiplayerPackageImpl#getSongPart()
		 * @generated
		 */
		EClass SONG_PART = eINSTANCE.getSongPart();

				/**
		 * The meta object literal for the '<em><b>Textlines</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SONG_PART__TEXTLINES = eINSTANCE.getSongPart_Textlines();

				/**
		 * The meta object literal for the '<em><b>Parttype</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SONG_PART__PARTTYPE = eINSTANCE.getSongPart_Parttype();

				/**
		 * The meta object literal for the '<em><b>Bar</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SONG_PART__BAR = eINSTANCE.getSongPart_Bar();

				/**
		 * The meta object literal for the '<em><b>Ref Part</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SONG_PART__REF_PART = eINSTANCE.getSongPart_RefPart();

				/**
		 * The meta object literal for the '<em><b>Position</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SONG_PART__POSITION = eINSTANCE.getSongPart_Position();

				/**
		 * The meta object literal for the '{@link mda.impl.SongTextLineImpl <em>Song Text Line</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mda.impl.SongTextLineImpl
		 * @see mda.impl.MidiplayerPackageImpl#getSongTextLine()
		 * @generated
		 */
		EClass SONG_TEXT_LINE = eINSTANCE.getSongTextLine();

				/**
		 * The meta object literal for the '<em><b>Chord Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SONG_TEXT_LINE__CHORD_PARTS = eINSTANCE.getSongTextLine_ChordParts();

				/**
		 * The meta object literal for the '<em><b>New Slide</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SONG_TEXT_LINE__NEW_SLIDE = eINSTANCE.getSongTextLine_NewSlide();

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
		 * The meta object literal for the '{@link mda.impl.SongChordPartImpl <em>Song Chord Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mda.impl.SongChordPartImpl
		 * @see mda.impl.MidiplayerPackageImpl#getSongChordPart()
		 * @generated
		 */
		EClass SONG_CHORD_PART = eINSTANCE.getSongChordPart();

				/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SONG_CHORD_PART__TEXT = eINSTANCE.getSongChordPart_Text();

				/**
		 * The meta object literal for the '<em><b>Chord</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SONG_CHORD_PART__CHORD = eINSTANCE.getSongChordPart_Chord();

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
		 * The meta object literal for the '<em><b>Mididevice</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__MIDIDEVICE = eINSTANCE.getConfiguration_Mididevice();

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
		 * The meta object literal for the '<em><b>Autosizing Percent</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRESENTATION_SCHEME__AUTOSIZING_PERCENT = eINSTANCE.getPresentationScheme_AutosizingPercent();

								/**
		 * The meta object literal for the '{@link mda.SongPartType <em>Song Part Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mda.SongPartType
		 * @see mda.impl.MidiplayerPackageImpl#getSongPartType()
		 * @generated
		 */
		EEnum SONG_PART_TYPE = eINSTANCE.getSongPartType();

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
