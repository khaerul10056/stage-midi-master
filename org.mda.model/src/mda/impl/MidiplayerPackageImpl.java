/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package mda.impl;

import mda.AbstractEvent;
import mda.AbstractSessionItem;
import mda.Configuration;
import mda.Gallery;
import mda.MidiFile;
import mda.MidiFileChordPart;
import mda.MidiFilePart;
import mda.MidiFilePartType;
import mda.MidiFileTextLine;
import mda.MidiPlayerRoot;
import mda.MidiplayerFactory;
import mda.MidiplayerPackage;
import mda.Session;
import mda.TextPresentationEvent;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MidiplayerPackageImpl extends EPackageImpl implements MidiplayerPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sessionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractSessionItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass midiFileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass textPresentationEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass midiFilePartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass midiFileTextLineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass galleryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass midiPlayerRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass midiFileChordPartEClass = null;

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass configurationEClass = null;

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum midiFilePartTypeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see mda.MidiplayerPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MidiplayerPackageImpl() {
		super(eNS_URI, MidiplayerFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link MidiplayerPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MidiplayerPackage init() {
		if (isInited) return (MidiplayerPackage)EPackage.Registry.INSTANCE.getEPackage(MidiplayerPackage.eNS_URI);

		// Obtain or create and register package
		MidiplayerPackageImpl theMidiplayerPackage = (MidiplayerPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MidiplayerPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MidiplayerPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theMidiplayerPackage.createPackageContents();

		// Initialize created meta-data
		theMidiplayerPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMidiplayerPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MidiplayerPackage.eNS_URI, theMidiplayerPackage);
		return theMidiplayerPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSession() {
		return sessionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSession_Name() {
		return (EAttribute)sessionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSession_Items() {
		return (EReference)sessionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSession_Defaultpath() {
		return (EAttribute)sessionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractSessionItem() {
		return abstractSessionItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractSessionItem_Name() {
		return (EAttribute)abstractSessionItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractSessionItem_Path() {
		return (EAttribute)abstractSessionItemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMidiFile() {
		return midiFileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getMidiFile_Parts() {
		return (EReference)midiFileEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getMidiFile_Fontsize() {
		return (EAttribute)midiFileEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getMidiFile_Pic() {
		return (EAttribute)midiFileEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractEvent() {
		return abstractEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractEvent_AtBar() {
		return (EAttribute)abstractEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTextPresentationEvent() {
		return textPresentationEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTextPresentationEvent_Parts() {
		return (EReference)textPresentationEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMidiFilePart() {
		return midiFilePartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMidiFilePart_Textlines() {
		return (EReference)midiFilePartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMidiFilePart_Parttype() {
		return (EAttribute)midiFilePartEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getMidiFilePart_Bar() {
		return (EAttribute)midiFilePartEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getMidiFilePart_RefPart() {
		return (EReference)midiFilePartEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMidiFileTextLine() {
		return midiFileTextLineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMidiFileTextLine_ChordParts() {
		return (EReference)midiFileTextLineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGallery() {
		return galleryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGallery_GalleryItems() {
		return (EReference)galleryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMidiPlayerRoot() {
		return midiPlayerRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMidiPlayerRoot_Gallery() {
		return (EReference)midiPlayerRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMidiPlayerRoot_Sessions() {
		return (EReference)midiPlayerRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getMidiPlayerRoot_Config() {
		return (EReference)midiPlayerRootEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMidiFileChordPart() {
		return midiFileChordPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMidiFileChordPart_Text() {
		return (EAttribute)midiFileChordPartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMidiFileChordPart_Chord() {
		return (EAttribute)midiFileChordPartEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getConfiguration() {
		return configurationEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getConfiguration_ScreenIDPresentation() {
		return (EAttribute)configurationEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getConfiguration_ScreenIDAdmin() {
		return (EAttribute)configurationEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getConfiguration_LastSession() {
		return (EReference)configurationEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConfiguration_PdfExportPath() {
		return (EAttribute)configurationEClass.getEStructuralFeatures().get(3);
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMidiFilePartType() {
		return midiFilePartTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MidiplayerFactory getMidiplayerFactory() {
		return (MidiplayerFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		sessionEClass = createEClass(SESSION);
		createEAttribute(sessionEClass, SESSION__NAME);
		createEReference(sessionEClass, SESSION__ITEMS);
		createEAttribute(sessionEClass, SESSION__DEFAULTPATH);

		abstractSessionItemEClass = createEClass(ABSTRACT_SESSION_ITEM);
		createEAttribute(abstractSessionItemEClass, ABSTRACT_SESSION_ITEM__NAME);
		createEAttribute(abstractSessionItemEClass, ABSTRACT_SESSION_ITEM__PATH);

		midiFileEClass = createEClass(MIDI_FILE);
		createEReference(midiFileEClass, MIDI_FILE__PARTS);
		createEAttribute(midiFileEClass, MIDI_FILE__FONTSIZE);
		createEAttribute(midiFileEClass, MIDI_FILE__PIC);

		abstractEventEClass = createEClass(ABSTRACT_EVENT);
		createEAttribute(abstractEventEClass, ABSTRACT_EVENT__AT_BAR);

		textPresentationEventEClass = createEClass(TEXT_PRESENTATION_EVENT);
		createEReference(textPresentationEventEClass, TEXT_PRESENTATION_EVENT__PARTS);

		midiFilePartEClass = createEClass(MIDI_FILE_PART);
		createEReference(midiFilePartEClass, MIDI_FILE_PART__TEXTLINES);
		createEAttribute(midiFilePartEClass, MIDI_FILE_PART__PARTTYPE);
		createEAttribute(midiFilePartEClass, MIDI_FILE_PART__BAR);
		createEReference(midiFilePartEClass, MIDI_FILE_PART__REF_PART);

		midiFileTextLineEClass = createEClass(MIDI_FILE_TEXT_LINE);
		createEReference(midiFileTextLineEClass, MIDI_FILE_TEXT_LINE__CHORD_PARTS);

		galleryEClass = createEClass(GALLERY);
		createEReference(galleryEClass, GALLERY__GALLERY_ITEMS);

		midiPlayerRootEClass = createEClass(MIDI_PLAYER_ROOT);
		createEReference(midiPlayerRootEClass, MIDI_PLAYER_ROOT__GALLERY);
		createEReference(midiPlayerRootEClass, MIDI_PLAYER_ROOT__SESSIONS);
		createEReference(midiPlayerRootEClass, MIDI_PLAYER_ROOT__CONFIG);

		midiFileChordPartEClass = createEClass(MIDI_FILE_CHORD_PART);
		createEAttribute(midiFileChordPartEClass, MIDI_FILE_CHORD_PART__TEXT);
		createEAttribute(midiFileChordPartEClass, MIDI_FILE_CHORD_PART__CHORD);

		configurationEClass = createEClass(CONFIGURATION);
		createEAttribute(configurationEClass, CONFIGURATION__SCREEN_ID_PRESENTATION);
		createEAttribute(configurationEClass, CONFIGURATION__SCREEN_ID_ADMIN);
		createEReference(configurationEClass, CONFIGURATION__LAST_SESSION);
		createEAttribute(configurationEClass, CONFIGURATION__PDF_EXPORT_PATH);

		// Create enums
		midiFilePartTypeEEnum = createEEnum(MIDI_FILE_PART_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		midiFileEClass.getESuperTypes().add(this.getAbstractSessionItem());
		textPresentationEventEClass.getESuperTypes().add(this.getAbstractEvent());

		// Initialize classes and features; add operations and parameters
		initEClass(sessionEClass, Session.class, "Session", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSession_Name(), ecorePackage.getEString(), "name", null, 0, 1, Session.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSession_Items(), this.getAbstractSessionItem(), null, "items", null, 0, -1, Session.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSession_Defaultpath(), ecorePackage.getEString(), "defaultpath", null, 0, 1, Session.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractSessionItemEClass, AbstractSessionItem.class, "AbstractSessionItem", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractSessionItem_Name(), ecorePackage.getEString(), "name", null, 0, 1, AbstractSessionItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractSessionItem_Path(), ecorePackage.getEString(), "path", null, 0, 1, AbstractSessionItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(midiFileEClass, MidiFile.class, "MidiFile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMidiFile_Parts(), this.getMidiFilePart(), null, "parts", null, 0, -1, MidiFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMidiFile_Fontsize(), ecorePackage.getEString(), "fontsize", null, 0, 1, MidiFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMidiFile_Pic(), ecorePackage.getEString(), "pic", null, 0, 1, MidiFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractEventEClass, AbstractEvent.class, "AbstractEvent", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractEvent_AtBar(), ecorePackage.getEInt(), "atBar", null, 0, 1, AbstractEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(textPresentationEventEClass, TextPresentationEvent.class, "TextPresentationEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTextPresentationEvent_Parts(), this.getMidiFilePart(), null, "parts", null, 0, -1, TextPresentationEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(midiFilePartEClass, MidiFilePart.class, "MidiFilePart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMidiFilePart_Textlines(), this.getMidiFileTextLine(), null, "textlines", null, 0, -1, MidiFilePart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMidiFilePart_Parttype(), this.getMidiFilePartType(), "parttype", null, 0, 1, MidiFilePart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMidiFilePart_Bar(), ecorePackage.getEInt(), "bar", null, 0, 1, MidiFilePart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMidiFilePart_RefPart(), this.getMidiFilePart(), null, "refPart", null, 0, 1, MidiFilePart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(midiFileTextLineEClass, MidiFileTextLine.class, "MidiFileTextLine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMidiFileTextLine_ChordParts(), this.getMidiFileChordPart(), null, "chordParts", null, 0, -1, MidiFileTextLine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(galleryEClass, Gallery.class, "Gallery", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGallery_GalleryItems(), this.getAbstractSessionItem(), null, "galleryItems", null, 0, -1, Gallery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(midiPlayerRootEClass, MidiPlayerRoot.class, "MidiPlayerRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMidiPlayerRoot_Gallery(), this.getGallery(), null, "gallery", null, 0, 1, MidiPlayerRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMidiPlayerRoot_Sessions(), this.getSession(), null, "sessions", null, 0, -1, MidiPlayerRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMidiPlayerRoot_Config(), this.getConfiguration(), null, "config", null, 0, 1, MidiPlayerRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(midiFileChordPartEClass, MidiFileChordPart.class, "MidiFileChordPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMidiFileChordPart_Text(), ecorePackage.getEString(), "text", null, 0, 1, MidiFileChordPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMidiFileChordPart_Chord(), ecorePackage.getEString(), "chord", null, 0, 1, MidiFileChordPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(configurationEClass, Configuration.class, "Configuration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConfiguration_ScreenIDPresentation(), ecorePackage.getEString(), "screenIDPresentation", null, 0, 1, Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConfiguration_ScreenIDAdmin(), ecorePackage.getEString(), "screenIDAdmin", null, 0, 1, Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConfiguration_LastSession(), this.getSession(), null, "lastSession", null, 0, 1, Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConfiguration_PdfExportPath(), ecorePackage.getEString(), "pdfExportPath", null, 0, 1, Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(midiFilePartTypeEEnum, MidiFilePartType.class, "MidiFilePartType");
		addEEnumLiteral(midiFilePartTypeEEnum, MidiFilePartType.REFRAIN);
		addEEnumLiteral(midiFilePartTypeEEnum, MidiFilePartType.BRIDGE);
		addEEnumLiteral(midiFilePartTypeEEnum, MidiFilePartType.VERS);
		addEEnumLiteral(midiFilePartTypeEEnum, MidiFilePartType.SOLO);
		addEEnumLiteral(midiFilePartTypeEEnum, MidiFilePartType.ZWISCHENSPIEL);
		addEEnumLiteral(midiFilePartTypeEEnum, MidiFilePartType.INTRO);
		addEEnumLiteral(midiFilePartTypeEEnum, MidiFilePartType.EXTRO);

		// Create resource
		createResource(eNS_URI);
	}

} //MidiplayerPackageImpl
