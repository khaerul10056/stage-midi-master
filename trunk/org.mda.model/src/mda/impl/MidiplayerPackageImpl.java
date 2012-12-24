/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package mda.impl;

import mda.AbstractSessionItem;
import mda.AdditionalType;
import mda.Configuration;
import mda.Copyright;
import mda.Gallery;
import mda.MidiFile;
import mda.MidiFileChordPart;
import mda.MidiFilePart;
import mda.MidiFilePartType;
import mda.MidiFileTextLine;
import mda.MidiPlayerRoot;
import mda.MidiplayerFactory;
import mda.MidiplayerPackage;
import mda.PresentationScheme;
import mda.Session;
import mda.User;
import mda.UserType;
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
  private EClass userEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass copyrightEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass presentationSchemeEClass = null;

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum midiFilePartTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum additionalTypeEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum userTypeEEnum = null;

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
	@Override
	public EClass getSession() {
		return sessionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSession_Name() {
		return (EAttribute)sessionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSession_Items() {
		return (EReference)sessionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSession_Defaultpath() {
		return (EAttribute)sessionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAbstractSessionItem() {
		return abstractSessionItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAbstractSessionItem_Name() {
		return (EAttribute)abstractSessionItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAbstractSessionItem_Path() {
		return (EAttribute)abstractSessionItemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EAttribute getAbstractSessionItem_BackgroundColor() {
		return (EAttribute)abstractSessionItemEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EAttribute getAbstractSessionItem_ForegroundColor() {
		return (EAttribute)abstractSessionItemEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMidiFile() {
		return midiFileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EReference getMidiFile_Parts() {
		return (EReference)midiFileEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EAttribute getMidiFile_Pic() {
		return (EAttribute)midiFileEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMidiFile_Key() {
		return (EAttribute)midiFileEClass.getEStructuralFeatures().get(2);
	}

		/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EReference getMidiFile_Copyright() {
		return (EReference)midiFileEClass.getEStructuralFeatures().get(3);
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMidiFilePart() {
		return midiFilePartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMidiFilePart_Textlines() {
		return (EReference)midiFilePartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMidiFilePart_Parttype() {
		return (EAttribute)midiFilePartEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EAttribute getMidiFilePart_Bar() {
		return (EAttribute)midiFilePartEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EReference getMidiFilePart_RefPart() {
		return (EReference)midiFilePartEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMidiFilePart_Position() {
		return (EAttribute)midiFilePartEClass.getEStructuralFeatures().get(4);
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMidiFileTextLine() {
		return midiFileTextLineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMidiFileTextLine_ChordParts() {
		return (EReference)midiFileTextLineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EAttribute getMidiFileTextLine_NewSlide() {
		return (EAttribute)midiFileTextLineEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGallery() {
		return galleryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGallery_GalleryItems() {
		return (EReference)galleryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMidiPlayerRoot() {
		return midiPlayerRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMidiPlayerRoot_Gallery() {
		return (EReference)midiPlayerRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMidiPlayerRoot_Sessions() {
		return (EReference)midiPlayerRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EReference getMidiPlayerRoot_Config() {
		return (EReference)midiPlayerRootEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EReference getMidiPlayerRoot_Users() {
		return (EReference)midiPlayerRootEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EReference getMidiPlayerRoot_Presentationschemes() {
		return (EReference)midiPlayerRootEClass.getEStructuralFeatures().get(4);
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMidiFileChordPart() {
		return midiFileChordPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMidiFileChordPart_Text() {
		return (EAttribute)midiFileChordPartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMidiFileChordPart_Chord() {
		return (EAttribute)midiFileChordPartEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EClass getConfiguration() {
		return configurationEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EAttribute getConfiguration_ScreenIDPresentation() {
		return (EAttribute)configurationEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EAttribute getConfiguration_ScreenIDAdmin() {
		return (EAttribute)configurationEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EReference getConfiguration_LastSession() {
		return (EReference)configurationEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getConfiguration_PdfExportPath() {
		return (EAttribute)configurationEClass.getEStructuralFeatures().get(3);
	}

		/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EAttribute getConfiguration_AdditionalsPath() {
		return (EAttribute)configurationEClass.getEStructuralFeatures().get(4);
	}

    /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EAttribute getConfiguration_Fontsize() {
		return (EAttribute)configurationEClass.getEStructuralFeatures().get(5);
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getConfiguration_MailtextSendSongbook() {
		return (EAttribute)configurationEClass.getEStructuralFeatures().get(6);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getConfiguration_MailserverUrl() {
		return (EAttribute)configurationEClass.getEStructuralFeatures().get(7);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getConfiguration_MailserverUser() {
		return (EAttribute)configurationEClass.getEStructuralFeatures().get(8);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getConfiguration_MailserverPassword() {
		return (EAttribute)configurationEClass.getEStructuralFeatures().get(9);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getConfiguration_MailsubjectSendSongbook() {
		return (EAttribute)configurationEClass.getEStructuralFeatures().get(10);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConfiguration_Mididevice() {
		return (EAttribute)configurationEClass.getEStructuralFeatures().get(11);
	}

				/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EClass getUser() {
		return userEClass;
	}

    /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EAttribute getUser_Mail() {
		return (EAttribute)userEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EAttribute getUser_Name() {
		return (EAttribute)userEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EAttribute getUser_Firstname() {
		return (EAttribute)userEClass.getEStructuralFeatures().get(2);
	}

    /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EAttribute getUser_Type() {
		return (EAttribute)userEClass.getEStructuralFeatures().get(3);
	}

    /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EAttribute getUser_SendSongbook() {
		return (EAttribute)userEClass.getEStructuralFeatures().get(4);
	}

    /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EReference getUser_Presentationschemes() {
		return (EReference)userEClass.getEStructuralFeatures().get(5);
	}

    /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EAttribute getUser_DefaultPresentationType() {
		return (EAttribute)userEClass.getEStructuralFeatures().get(6);
	}

    /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EClass getCopyright() {
		return copyrightEClass;
	}

    /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EAttribute getCopyright_Originaltitle() {
		return (EAttribute)copyrightEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EAttribute getCopyright_WriterMusic() {
		return (EAttribute)copyrightEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EAttribute getCopyright_WriterText() {
		return (EAttribute)copyrightEClass.getEStructuralFeatures().get(2);
	}

    /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EAttribute getCopyright_WriterInlandText() {
		return (EAttribute)copyrightEClass.getEStructuralFeatures().get(3);
	}

    /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EAttribute getCopyright_Year() {
		return (EAttribute)copyrightEClass.getEStructuralFeatures().get(4);
	}

    /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EAttribute getCopyright_Publisher() {
		return (EAttribute)copyrightEClass.getEStructuralFeatures().get(5);
	}

    /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EAttribute getCopyright_PublisherInland() {
		return (EAttribute)copyrightEClass.getEStructuralFeatures().get(6);
	}

    /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EClass getPresentationScheme() {
		return presentationSchemeEClass;
	}

    /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EAttribute getPresentationScheme_Name() {
		return (EAttribute)presentationSchemeEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EAttribute getPresentationScheme_ShowBackground() {
		return (EAttribute)presentationSchemeEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EAttribute getPresentationScheme_ShowBlockType() {
		return (EAttribute)presentationSchemeEClass.getEStructuralFeatures().get(2);
	}

    /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EAttribute getPresentationScheme_PagePerPart() {
		return (EAttribute)presentationSchemeEClass.getEStructuralFeatures().get(3);
	}

    /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EAttribute getPresentationScheme_NewPageRespected() {
		return (EAttribute)presentationSchemeEClass.getEStructuralFeatures().get(4);
	}

    /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EAttribute getPresentationScheme_ShowTitle() {
		return (EAttribute)presentationSchemeEClass.getEStructuralFeatures().get(5);
	}

    /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EAttribute getPresentationScheme_ShowCopyright() {
		return (EAttribute)presentationSchemeEClass.getEStructuralFeatures().get(6);
	}

    /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EAttribute getPresentationScheme_SkipEmptySlides() {
		return (EAttribute)presentationSchemeEClass.getEStructuralFeatures().get(7);
	}

    /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EAttribute getPresentationScheme_OptimizeLineFilling() {
		return (EAttribute)presentationSchemeEClass.getEStructuralFeatures().get(8);
	}

    /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EAttribute getPresentationScheme_OptimizeEqualParts() {
		return (EAttribute)presentationSchemeEClass.getEStructuralFeatures().get(9);
	}

    /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EAttribute getPresentationScheme_OptimizeEmptyTokens() {
		return (EAttribute)presentationSchemeEClass.getEStructuralFeatures().get(10);
	}

    /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EAttribute getPresentationScheme_Border() {
		return (EAttribute)presentationSchemeEClass.getEStructuralFeatures().get(11);
	}

    /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EAttribute getPresentationScheme_Type() {
		return (EAttribute)presentationSchemeEClass.getEStructuralFeatures().get(12);
	}

    /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EAttribute getPresentationScheme_BackgroundColor() {
		return (EAttribute)presentationSchemeEClass.getEStructuralFeatures().get(13);
	}

    /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EAttribute getPresentationScheme_ForegroundColor() {
		return (EAttribute)presentationSchemeEClass.getEStructuralFeatures().get(14);
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPresentationScheme_ShowChords() {
		return (EAttribute)presentationSchemeEClass.getEStructuralFeatures().get(15);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPresentationScheme_AutoWrapToNewPage() {
		return (EAttribute)presentationSchemeEClass.getEStructuralFeatures().get(16);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getMidiFilePartType() {
		return midiFilePartTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EEnum getAdditionalType() {
		return additionalTypeEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
public EEnum getUserType() {
		return userTypeEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
		createEAttribute(abstractSessionItemEClass, ABSTRACT_SESSION_ITEM__BACKGROUND_COLOR);
		createEAttribute(abstractSessionItemEClass, ABSTRACT_SESSION_ITEM__FOREGROUND_COLOR);

		midiFileEClass = createEClass(MIDI_FILE);
		createEReference(midiFileEClass, MIDI_FILE__PARTS);
		createEAttribute(midiFileEClass, MIDI_FILE__PIC);
		createEAttribute(midiFileEClass, MIDI_FILE__KEY);
		createEReference(midiFileEClass, MIDI_FILE__COPYRIGHT);

		midiFilePartEClass = createEClass(MIDI_FILE_PART);
		createEReference(midiFilePartEClass, MIDI_FILE_PART__TEXTLINES);
		createEAttribute(midiFilePartEClass, MIDI_FILE_PART__PARTTYPE);
		createEAttribute(midiFilePartEClass, MIDI_FILE_PART__BAR);
		createEReference(midiFilePartEClass, MIDI_FILE_PART__REF_PART);
		createEAttribute(midiFilePartEClass, MIDI_FILE_PART__POSITION);

		midiFileTextLineEClass = createEClass(MIDI_FILE_TEXT_LINE);
		createEReference(midiFileTextLineEClass, MIDI_FILE_TEXT_LINE__CHORD_PARTS);
		createEAttribute(midiFileTextLineEClass, MIDI_FILE_TEXT_LINE__NEW_SLIDE);

		galleryEClass = createEClass(GALLERY);
		createEReference(galleryEClass, GALLERY__GALLERY_ITEMS);

		midiPlayerRootEClass = createEClass(MIDI_PLAYER_ROOT);
		createEReference(midiPlayerRootEClass, MIDI_PLAYER_ROOT__GALLERY);
		createEReference(midiPlayerRootEClass, MIDI_PLAYER_ROOT__SESSIONS);
		createEReference(midiPlayerRootEClass, MIDI_PLAYER_ROOT__CONFIG);
		createEReference(midiPlayerRootEClass, MIDI_PLAYER_ROOT__USERS);
		createEReference(midiPlayerRootEClass, MIDI_PLAYER_ROOT__PRESENTATIONSCHEMES);

		midiFileChordPartEClass = createEClass(MIDI_FILE_CHORD_PART);
		createEAttribute(midiFileChordPartEClass, MIDI_FILE_CHORD_PART__TEXT);
		createEAttribute(midiFileChordPartEClass, MIDI_FILE_CHORD_PART__CHORD);

		configurationEClass = createEClass(CONFIGURATION);
		createEAttribute(configurationEClass, CONFIGURATION__SCREEN_ID_PRESENTATION);
		createEAttribute(configurationEClass, CONFIGURATION__SCREEN_ID_ADMIN);
		createEReference(configurationEClass, CONFIGURATION__LAST_SESSION);
		createEAttribute(configurationEClass, CONFIGURATION__PDF_EXPORT_PATH);
		createEAttribute(configurationEClass, CONFIGURATION__ADDITIONALS_PATH);
		createEAttribute(configurationEClass, CONFIGURATION__FONTSIZE);
		createEAttribute(configurationEClass, CONFIGURATION__MAILTEXT_SEND_SONGBOOK);
		createEAttribute(configurationEClass, CONFIGURATION__MAILSERVER_URL);
		createEAttribute(configurationEClass, CONFIGURATION__MAILSERVER_USER);
		createEAttribute(configurationEClass, CONFIGURATION__MAILSERVER_PASSWORD);
		createEAttribute(configurationEClass, CONFIGURATION__MAILSUBJECT_SEND_SONGBOOK);
		createEAttribute(configurationEClass, CONFIGURATION__MIDIDEVICE);

		userEClass = createEClass(USER);
		createEAttribute(userEClass, USER__MAIL);
		createEAttribute(userEClass, USER__NAME);
		createEAttribute(userEClass, USER__FIRSTNAME);
		createEAttribute(userEClass, USER__TYPE);
		createEAttribute(userEClass, USER__SEND_SONGBOOK);
		createEReference(userEClass, USER__PRESENTATIONSCHEMES);
		createEAttribute(userEClass, USER__DEFAULT_PRESENTATION_TYPE);

		copyrightEClass = createEClass(COPYRIGHT);
		createEAttribute(copyrightEClass, COPYRIGHT__ORIGINALTITLE);
		createEAttribute(copyrightEClass, COPYRIGHT__WRITER_MUSIC);
		createEAttribute(copyrightEClass, COPYRIGHT__WRITER_TEXT);
		createEAttribute(copyrightEClass, COPYRIGHT__WRITER_INLAND_TEXT);
		createEAttribute(copyrightEClass, COPYRIGHT__YEAR);
		createEAttribute(copyrightEClass, COPYRIGHT__PUBLISHER);
		createEAttribute(copyrightEClass, COPYRIGHT__PUBLISHER_INLAND);

		presentationSchemeEClass = createEClass(PRESENTATION_SCHEME);
		createEAttribute(presentationSchemeEClass, PRESENTATION_SCHEME__NAME);
		createEAttribute(presentationSchemeEClass, PRESENTATION_SCHEME__SHOW_BACKGROUND);
		createEAttribute(presentationSchemeEClass, PRESENTATION_SCHEME__SHOW_BLOCK_TYPE);
		createEAttribute(presentationSchemeEClass, PRESENTATION_SCHEME__PAGE_PER_PART);
		createEAttribute(presentationSchemeEClass, PRESENTATION_SCHEME__NEW_PAGE_RESPECTED);
		createEAttribute(presentationSchemeEClass, PRESENTATION_SCHEME__SHOW_TITLE);
		createEAttribute(presentationSchemeEClass, PRESENTATION_SCHEME__SHOW_COPYRIGHT);
		createEAttribute(presentationSchemeEClass, PRESENTATION_SCHEME__SKIP_EMPTY_SLIDES);
		createEAttribute(presentationSchemeEClass, PRESENTATION_SCHEME__OPTIMIZE_LINE_FILLING);
		createEAttribute(presentationSchemeEClass, PRESENTATION_SCHEME__OPTIMIZE_EQUAL_PARTS);
		createEAttribute(presentationSchemeEClass, PRESENTATION_SCHEME__OPTIMIZE_EMPTY_TOKENS);
		createEAttribute(presentationSchemeEClass, PRESENTATION_SCHEME__BORDER);
		createEAttribute(presentationSchemeEClass, PRESENTATION_SCHEME__TYPE);
		createEAttribute(presentationSchemeEClass, PRESENTATION_SCHEME__BACKGROUND_COLOR);
		createEAttribute(presentationSchemeEClass, PRESENTATION_SCHEME__FOREGROUND_COLOR);
		createEAttribute(presentationSchemeEClass, PRESENTATION_SCHEME__SHOW_CHORDS);
		createEAttribute(presentationSchemeEClass, PRESENTATION_SCHEME__AUTO_WRAP_TO_NEW_PAGE);

		// Create enums
		midiFilePartTypeEEnum = createEEnum(MIDI_FILE_PART_TYPE);
		additionalTypeEEnum = createEEnum(ADDITIONAL_TYPE);
		userTypeEEnum = createEEnum(USER_TYPE);
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

		// Initialize classes and features; add operations and parameters
		initEClass(sessionEClass, Session.class, "Session", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSession_Name(), ecorePackage.getEString(), "name", null, 0, 1, Session.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSession_Items(), this.getAbstractSessionItem(), null, "items", null, 0, -1, Session.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSession_Defaultpath(), ecorePackage.getEString(), "defaultpath", null, 0, 1, Session.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractSessionItemEClass, AbstractSessionItem.class, "AbstractSessionItem", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractSessionItem_Name(), ecorePackage.getEString(), "name", null, 0, 1, AbstractSessionItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractSessionItem_Path(), ecorePackage.getEString(), "path", null, 0, 1, AbstractSessionItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractSessionItem_BackgroundColor(), ecorePackage.getEString(), "backgroundColor", null, 0, 1, AbstractSessionItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractSessionItem_ForegroundColor(), ecorePackage.getEString(), "foregroundColor", null, 0, 1, AbstractSessionItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(midiFileEClass, MidiFile.class, "MidiFile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMidiFile_Parts(), this.getMidiFilePart(), null, "parts", null, 0, -1, MidiFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMidiFile_Pic(), ecorePackage.getEString(), "pic", null, 0, 1, MidiFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMidiFile_Key(), ecorePackage.getEString(), "key", null, 0, 1, MidiFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMidiFile_Copyright(), this.getCopyright(), null, "copyright", null, 0, 1, MidiFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(midiFilePartEClass, MidiFilePart.class, "MidiFilePart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMidiFilePart_Textlines(), this.getMidiFileTextLine(), null, "textlines", null, 0, -1, MidiFilePart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMidiFilePart_Parttype(), this.getMidiFilePartType(), "parttype", null, 0, 1, MidiFilePart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMidiFilePart_Bar(), ecorePackage.getEInt(), "bar", null, 0, 1, MidiFilePart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMidiFilePart_RefPart(), this.getMidiFilePart(), null, "refPart", null, 0, 1, MidiFilePart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMidiFilePart_Position(), ecorePackage.getEString(), "position", "", 0, 1, MidiFilePart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(midiFileTextLineEClass, MidiFileTextLine.class, "MidiFileTextLine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMidiFileTextLine_ChordParts(), this.getMidiFileChordPart(), null, "chordParts", null, 0, -1, MidiFileTextLine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMidiFileTextLine_NewSlide(), ecorePackage.getEBoolean(), "newSlide", null, 0, 1, MidiFileTextLine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(galleryEClass, Gallery.class, "Gallery", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGallery_GalleryItems(), this.getAbstractSessionItem(), null, "galleryItems", null, 0, -1, Gallery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(midiPlayerRootEClass, MidiPlayerRoot.class, "MidiPlayerRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMidiPlayerRoot_Gallery(), this.getGallery(), null, "gallery", null, 0, 1, MidiPlayerRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMidiPlayerRoot_Sessions(), this.getSession(), null, "sessions", null, 0, -1, MidiPlayerRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMidiPlayerRoot_Config(), this.getConfiguration(), null, "config", null, 0, 1, MidiPlayerRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMidiPlayerRoot_Users(), this.getUser(), null, "users", null, 0, -1, MidiPlayerRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMidiPlayerRoot_Presentationschemes(), this.getPresentationScheme(), null, "presentationschemes", null, 0, -1, MidiPlayerRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(midiFileChordPartEClass, MidiFileChordPart.class, "MidiFileChordPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMidiFileChordPart_Text(), ecorePackage.getEString(), "text", null, 0, 1, MidiFileChordPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMidiFileChordPart_Chord(), ecorePackage.getEString(), "chord", null, 0, 1, MidiFileChordPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(configurationEClass, Configuration.class, "Configuration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConfiguration_ScreenIDPresentation(), ecorePackage.getEString(), "screenIDPresentation", null, 0, 1, Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConfiguration_ScreenIDAdmin(), ecorePackage.getEString(), "screenIDAdmin", null, 0, 1, Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConfiguration_LastSession(), this.getSession(), null, "lastSession", null, 0, 1, Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConfiguration_PdfExportPath(), ecorePackage.getEString(), "pdfExportPath", null, 0, 1, Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConfiguration_AdditionalsPath(), ecorePackage.getEString(), "additionalsPath", null, 0, 1, Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConfiguration_Fontsize(), ecorePackage.getEIntegerObject(), "fontsize", null, 0, 1, Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConfiguration_MailtextSendSongbook(), ecorePackage.getEString(), "mailtextSendSongbook", null, 0, 1, Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConfiguration_MailserverUrl(), ecorePackage.getEString(), "mailserverUrl", "", 0, 1, Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConfiguration_MailserverUser(), ecorePackage.getEString(), "mailserverUser", null, 0, 1, Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConfiguration_MailserverPassword(), ecorePackage.getEString(), "mailserverPassword", null, 0, 1, Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConfiguration_MailsubjectSendSongbook(), ecorePackage.getEString(), "mailsubjectSendSongbook", null, 0, 1, Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConfiguration_Mididevice(), ecorePackage.getEString(), "mididevice", "", 0, 1, Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(userEClass, User.class, "User", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUser_Mail(), ecorePackage.getEString(), "mail", null, 0, 1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUser_Name(), ecorePackage.getEString(), "name", null, 0, 1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUser_Firstname(), ecorePackage.getEString(), "firstname", null, 0, 1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUser_Type(), this.getUserType(), "type", null, 0, 1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUser_SendSongbook(), ecorePackage.getEBoolean(), "sendSongbook", null, 0, 1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUser_Presentationschemes(), this.getPresentationScheme(), null, "presentationschemes", null, 0, -1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUser_DefaultPresentationType(), ecorePackage.getEString(), "defaultPresentationType", null, 0, 1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(copyrightEClass, Copyright.class, "Copyright", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCopyright_Originaltitle(), ecorePackage.getEString(), "originaltitle", null, 0, 1, Copyright.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCopyright_WriterMusic(), ecorePackage.getEString(), "writerMusic", null, 0, 1, Copyright.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCopyright_WriterText(), ecorePackage.getEString(), "writerText", null, 0, 1, Copyright.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCopyright_WriterInlandText(), ecorePackage.getEString(), "writerInlandText", null, 0, 1, Copyright.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCopyright_Year(), ecorePackage.getEInt(), "year", null, 0, 1, Copyright.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCopyright_Publisher(), ecorePackage.getEString(), "publisher", null, 0, 1, Copyright.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCopyright_PublisherInland(), ecorePackage.getEString(), "publisherInland", null, 0, 1, Copyright.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(presentationSchemeEClass, PresentationScheme.class, "PresentationScheme", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPresentationScheme_Name(), ecorePackage.getEString(), "name", null, 0, 1, PresentationScheme.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationScheme_ShowBackground(), ecorePackage.getEBooleanObject(), "showBackground", null, 0, 1, PresentationScheme.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationScheme_ShowBlockType(), ecorePackage.getEBooleanObject(), "showBlockType", null, 0, 1, PresentationScheme.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationScheme_PagePerPart(), ecorePackage.getEBooleanObject(), "pagePerPart", null, 0, 1, PresentationScheme.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationScheme_NewPageRespected(), ecorePackage.getEBooleanObject(), "newPageRespected", null, 0, 1, PresentationScheme.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationScheme_ShowTitle(), ecorePackage.getEBooleanObject(), "showTitle", null, 0, 1, PresentationScheme.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationScheme_ShowCopyright(), ecorePackage.getEBooleanObject(), "showCopyright", null, 0, 1, PresentationScheme.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationScheme_SkipEmptySlides(), ecorePackage.getEBooleanObject(), "skipEmptySlides", null, 0, 1, PresentationScheme.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationScheme_OptimizeLineFilling(), ecorePackage.getEBooleanObject(), "optimizeLineFilling", null, 0, 1, PresentationScheme.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationScheme_OptimizeEqualParts(), ecorePackage.getEBooleanObject(), "optimizeEqualParts", null, 0, 1, PresentationScheme.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationScheme_OptimizeEmptyTokens(), ecorePackage.getEBooleanObject(), "optimizeEmptyTokens", null, 0, 1, PresentationScheme.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationScheme_Border(), ecorePackage.getEIntegerObject(), "border", null, 0, 1, PresentationScheme.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationScheme_Type(), ecorePackage.getEString(), "type", null, 0, 1, PresentationScheme.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationScheme_BackgroundColor(), ecorePackage.getEString(), "backgroundColor", null, 0, 1, PresentationScheme.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationScheme_ForegroundColor(), ecorePackage.getEString(), "foregroundColor", null, 0, 1, PresentationScheme.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationScheme_ShowChords(), ecorePackage.getEBooleanObject(), "showChords", null, 0, 1, PresentationScheme.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPresentationScheme_AutoWrapToNewPage(), ecorePackage.getEBooleanObject(), "autoWrapToNewPage", null, 0, 1, PresentationScheme.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(midiFilePartTypeEEnum, MidiFilePartType.class, "MidiFilePartType");
		addEEnumLiteral(midiFilePartTypeEEnum, MidiFilePartType.REFRAIN);
		addEEnumLiteral(midiFilePartTypeEEnum, MidiFilePartType.BRIDGE);
		addEEnumLiteral(midiFilePartTypeEEnum, MidiFilePartType.VERS);
		addEEnumLiteral(midiFilePartTypeEEnum, MidiFilePartType.SOLO);
		addEEnumLiteral(midiFilePartTypeEEnum, MidiFilePartType.ZWISCHENSPIEL);
		addEEnumLiteral(midiFilePartTypeEEnum, MidiFilePartType.INTRO);
		addEEnumLiteral(midiFilePartTypeEEnum, MidiFilePartType.EXTRO);

		initEEnum(additionalTypeEEnum, AdditionalType.class, "AdditionalType");
		addEEnumLiteral(additionalTypeEEnum, AdditionalType.IMAGE);
		addEEnumLiteral(additionalTypeEEnum, AdditionalType.VIDEO);
		addEEnumLiteral(additionalTypeEEnum, AdditionalType.MIDIFILE);
		addEEnumLiteral(additionalTypeEEnum, AdditionalType.AUDIO);

		initEEnum(userTypeEEnum, UserType.class, "UserType");
		addEEnumLiteral(userTypeEEnum, UserType.MEMBER);
		addEEnumLiteral(userTypeEEnum, UserType.FRIEND);

		// Create resource
		createResource(eNS_URI);
	}

} //MidiplayerPackageImpl
