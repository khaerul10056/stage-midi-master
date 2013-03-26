/**
 */
package mda.util;

import mda.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see mda.MidiplayerPackage
 * @generated
 */
public class MidiplayerAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MidiplayerPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MidiplayerAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = MidiplayerPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MidiplayerSwitch<Adapter> modelSwitch =
		new MidiplayerSwitch<Adapter>() {
			@Override
			public Adapter caseSession(Session object) {
				return createSessionAdapter();
			}
			@Override
			public Adapter caseAbstractSessionItem(AbstractSessionItem object) {
				return createAbstractSessionItemAdapter();
			}
			@Override
			public Adapter caseSong(Song object) {
				return createSongAdapter();
			}
			@Override
			public Adapter caseSongPart(SongPart object) {
				return createSongPartAdapter();
			}
			@Override
			public Adapter caseSongTextLine(SongTextLine object) {
				return createSongTextLineAdapter();
			}
			@Override
			public Adapter caseGallery(Gallery object) {
				return createGalleryAdapter();
			}
			@Override
			public Adapter caseMidiPlayerRoot(MidiPlayerRoot object) {
				return createMidiPlayerRootAdapter();
			}
			@Override
			public Adapter caseSongChordPart(SongChordPart object) {
				return createSongChordPartAdapter();
			}
			@Override
			public Adapter caseConfiguration(Configuration object) {
				return createConfigurationAdapter();
			}
			@Override
			public Adapter caseUser(User object) {
				return createUserAdapter();
			}
			@Override
			public Adapter caseCopyright(Copyright object) {
				return createCopyrightAdapter();
			}
			@Override
			public Adapter casePresentationScheme(PresentationScheme object) {
				return createPresentationSchemeAdapter();
			}
			@Override
			public Adapter caseSpecialMedia(SpecialMedia object) {
				return createSpecialMediaAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link mda.Session <em>Session</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mda.Session
	 * @generated
	 */
	public Adapter createSessionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mda.AbstractSessionItem <em>Abstract Session Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mda.AbstractSessionItem
	 * @generated
	 */
	public Adapter createAbstractSessionItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mda.Song <em>Song</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mda.Song
	 * @generated
	 */
	public Adapter createSongAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mda.SongPart <em>Song Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mda.SongPart
	 * @generated
	 */
	public Adapter createSongPartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mda.SongTextLine <em>Song Text Line</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mda.SongTextLine
	 * @generated
	 */
	public Adapter createSongTextLineAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mda.Gallery <em>Gallery</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mda.Gallery
	 * @generated
	 */
	public Adapter createGalleryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mda.MidiPlayerRoot <em>Midi Player Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mda.MidiPlayerRoot
	 * @generated
	 */
	public Adapter createMidiPlayerRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mda.SongChordPart <em>Song Chord Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mda.SongChordPart
	 * @generated
	 */
	public Adapter createSongChordPartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mda.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mda.Configuration
	 * @generated
	 */
	public Adapter createConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mda.User <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mda.User
	 * @generated
	 */
	public Adapter createUserAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mda.Copyright <em>Copyright</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mda.Copyright
	 * @generated
	 */
	public Adapter createCopyrightAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mda.PresentationScheme <em>Presentation Scheme</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mda.PresentationScheme
	 * @generated
	 */
	public Adapter createPresentationSchemeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mda.SpecialMedia <em>Special Media</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mda.SpecialMedia
	 * @generated
	 */
	public Adapter createSpecialMediaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //MidiplayerAdapterFactory
