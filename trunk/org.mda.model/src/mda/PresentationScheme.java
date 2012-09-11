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
 * A representation of the model object '<em><b>Presentation Scheme</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link mda.PresentationScheme#getName <em>Name</em>}</li>
 *   <li>{@link mda.PresentationScheme#getShowBackground <em>Show Background</em>}</li>
 *   <li>{@link mda.PresentationScheme#getShowBlockType <em>Show Block Type</em>}</li>
 *   <li>{@link mda.PresentationScheme#getPagePerPart <em>Page Per Part</em>}</li>
 *   <li>{@link mda.PresentationScheme#getNewPageRespected <em>New Page Respected</em>}</li>
 *   <li>{@link mda.PresentationScheme#getShowTitle <em>Show Title</em>}</li>
 *   <li>{@link mda.PresentationScheme#getShowCopyright <em>Show Copyright</em>}</li>
 *   <li>{@link mda.PresentationScheme#getSkipEmptySlides <em>Skip Empty Slides</em>}</li>
 *   <li>{@link mda.PresentationScheme#getOptimizeLineFilling <em>Optimize Line Filling</em>}</li>
 *   <li>{@link mda.PresentationScheme#getOptimizeEqualParts <em>Optimize Equal Parts</em>}</li>
 *   <li>{@link mda.PresentationScheme#getOptimizeEmptyTokens <em>Optimize Empty Tokens</em>}</li>
 *   <li>{@link mda.PresentationScheme#getBorder <em>Border</em>}</li>
 *   <li>{@link mda.PresentationScheme#getType <em>Type</em>}</li>
 *   <li>{@link mda.PresentationScheme#getBackgroundColor <em>Background Color</em>}</li>
 *   <li>{@link mda.PresentationScheme#getForegroundColor <em>Foreground Color</em>}</li>
 *   <li>{@link mda.PresentationScheme#getShowChords <em>Show Chords</em>}</li>
 *   <li>{@link mda.PresentationScheme#getAutoWrapToNewPage <em>Auto Wrap To New Page</em>}</li>
 * </ul>
 * </p>
 *
 * @see mda.MidiplayerPackage#getPresentationScheme()
 * @model
 * @generated
 */
public interface PresentationScheme extends EObject {
  /**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see mda.MidiplayerPackage#getPresentationScheme_Name()
	 * @model
	 * @generated
	 */
  String getName();

  /**
	 * Sets the value of the '{@link mda.PresentationScheme#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
  void setName(String value);

  /**
	 * Returns the value of the '<em><b>Show Background</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Show Background</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Show Background</em>' attribute.
	 * @see #setShowBackground(Boolean)
	 * @see mda.MidiplayerPackage#getPresentationScheme_ShowBackground()
	 * @model
	 * @generated
	 */
  Boolean getShowBackground();

  /**
	 * Sets the value of the '{@link mda.PresentationScheme#getShowBackground <em>Show Background</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Show Background</em>' attribute.
	 * @see #getShowBackground()
	 * @generated
	 */
  void setShowBackground(Boolean value);

  /**
	 * Returns the value of the '<em><b>Show Block Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Show Block Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Show Block Type</em>' attribute.
	 * @see #setShowBlockType(Boolean)
	 * @see mda.MidiplayerPackage#getPresentationScheme_ShowBlockType()
	 * @model
	 * @generated
	 */
  Boolean getShowBlockType();

  /**
	 * Sets the value of the '{@link mda.PresentationScheme#getShowBlockType <em>Show Block Type</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Show Block Type</em>' attribute.
	 * @see #getShowBlockType()
	 * @generated
	 */
  void setShowBlockType(Boolean value);

  /**
	 * Returns the value of the '<em><b>Page Per Part</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Page Per Part</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Page Per Part</em>' attribute.
	 * @see #setPagePerPart(Boolean)
	 * @see mda.MidiplayerPackage#getPresentationScheme_PagePerPart()
	 * @model
	 * @generated
	 */
  Boolean getPagePerPart();

  /**
	 * Sets the value of the '{@link mda.PresentationScheme#getPagePerPart <em>Page Per Part</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Page Per Part</em>' attribute.
	 * @see #getPagePerPart()
	 * @generated
	 */
  void setPagePerPart(Boolean value);

  /**
	 * Returns the value of the '<em><b>New Page Respected</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>New Page Respected</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>New Page Respected</em>' attribute.
	 * @see #setNewPageRespected(Boolean)
	 * @see mda.MidiplayerPackage#getPresentationScheme_NewPageRespected()
	 * @model
	 * @generated
	 */
  Boolean getNewPageRespected();

  /**
	 * Sets the value of the '{@link mda.PresentationScheme#getNewPageRespected <em>New Page Respected</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Page Respected</em>' attribute.
	 * @see #getNewPageRespected()
	 * @generated
	 */
  void setNewPageRespected(Boolean value);

  /**
	 * Returns the value of the '<em><b>Show Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Show Title</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Show Title</em>' attribute.
	 * @see #setShowTitle(Boolean)
	 * @see mda.MidiplayerPackage#getPresentationScheme_ShowTitle()
	 * @model
	 * @generated
	 */
  Boolean getShowTitle();

  /**
	 * Sets the value of the '{@link mda.PresentationScheme#getShowTitle <em>Show Title</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Show Title</em>' attribute.
	 * @see #getShowTitle()
	 * @generated
	 */
  void setShowTitle(Boolean value);

  /**
	 * Returns the value of the '<em><b>Show Copyright</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Show Copyright</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Show Copyright</em>' attribute.
	 * @see #setShowCopyright(Boolean)
	 * @see mda.MidiplayerPackage#getPresentationScheme_ShowCopyright()
	 * @model
	 * @generated
	 */
  Boolean getShowCopyright();

  /**
	 * Sets the value of the '{@link mda.PresentationScheme#getShowCopyright <em>Show Copyright</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Show Copyright</em>' attribute.
	 * @see #getShowCopyright()
	 * @generated
	 */
  void setShowCopyright(Boolean value);

  /**
	 * Returns the value of the '<em><b>Skip Empty Slides</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Skip Empty Slides</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Skip Empty Slides</em>' attribute.
	 * @see #setSkipEmptySlides(Boolean)
	 * @see mda.MidiplayerPackage#getPresentationScheme_SkipEmptySlides()
	 * @model
	 * @generated
	 */
  Boolean getSkipEmptySlides();

  /**
	 * Sets the value of the '{@link mda.PresentationScheme#getSkipEmptySlides <em>Skip Empty Slides</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Skip Empty Slides</em>' attribute.
	 * @see #getSkipEmptySlides()
	 * @generated
	 */
  void setSkipEmptySlides(Boolean value);

  /**
	 * Returns the value of the '<em><b>Optimize Line Filling</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Optimize Line Filling</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Optimize Line Filling</em>' attribute.
	 * @see #setOptimizeLineFilling(Boolean)
	 * @see mda.MidiplayerPackage#getPresentationScheme_OptimizeLineFilling()
	 * @model
	 * @generated
	 */
  Boolean getOptimizeLineFilling();

  /**
	 * Sets the value of the '{@link mda.PresentationScheme#getOptimizeLineFilling <em>Optimize Line Filling</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Optimize Line Filling</em>' attribute.
	 * @see #getOptimizeLineFilling()
	 * @generated
	 */
  void setOptimizeLineFilling(Boolean value);

  /**
	 * Returns the value of the '<em><b>Optimize Equal Parts</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Optimize Equal Parts</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Optimize Equal Parts</em>' attribute.
	 * @see #setOptimizeEqualParts(Boolean)
	 * @see mda.MidiplayerPackage#getPresentationScheme_OptimizeEqualParts()
	 * @model
	 * @generated
	 */
  Boolean getOptimizeEqualParts();

  /**
	 * Sets the value of the '{@link mda.PresentationScheme#getOptimizeEqualParts <em>Optimize Equal Parts</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Optimize Equal Parts</em>' attribute.
	 * @see #getOptimizeEqualParts()
	 * @generated
	 */
  void setOptimizeEqualParts(Boolean value);

  /**
	 * Returns the value of the '<em><b>Optimize Empty Tokens</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Optimize Empty Tokens</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Optimize Empty Tokens</em>' attribute.
	 * @see #setOptimizeEmptyTokens(Boolean)
	 * @see mda.MidiplayerPackage#getPresentationScheme_OptimizeEmptyTokens()
	 * @model
	 * @generated
	 */
  Boolean getOptimizeEmptyTokens();

  /**
	 * Sets the value of the '{@link mda.PresentationScheme#getOptimizeEmptyTokens <em>Optimize Empty Tokens</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Optimize Empty Tokens</em>' attribute.
	 * @see #getOptimizeEmptyTokens()
	 * @generated
	 */
  void setOptimizeEmptyTokens(Boolean value);

  /**
	 * Returns the value of the '<em><b>Border</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Border</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Border</em>' attribute.
	 * @see #setBorder(Integer)
	 * @see mda.MidiplayerPackage#getPresentationScheme_Border()
	 * @model
	 * @generated
	 */
  Integer getBorder();

  /**
	 * Sets the value of the '{@link mda.PresentationScheme#getBorder <em>Border</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Border</em>' attribute.
	 * @see #getBorder()
	 * @generated
	 */
  void setBorder(Integer value);

  /**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see mda.MidiplayerPackage#getPresentationScheme_Type()
	 * @model
	 * @generated
	 */
  String getType();

  /**
	 * Sets the value of the '{@link mda.PresentationScheme#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
  void setType(String value);

  /**
	 * Returns the value of the '<em><b>Background Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Background Color</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Background Color</em>' attribute.
	 * @see #setBackgroundColor(String)
	 * @see mda.MidiplayerPackage#getPresentationScheme_BackgroundColor()
	 * @model
	 * @generated
	 */
  String getBackgroundColor();

  /**
	 * Sets the value of the '{@link mda.PresentationScheme#getBackgroundColor <em>Background Color</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Background Color</em>' attribute.
	 * @see #getBackgroundColor()
	 * @generated
	 */
  void setBackgroundColor(String value);

  /**
	 * Returns the value of the '<em><b>Foreground Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Foreground Color</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Foreground Color</em>' attribute.
	 * @see #setForegroundColor(String)
	 * @see mda.MidiplayerPackage#getPresentationScheme_ForegroundColor()
	 * @model
	 * @generated
	 */
  String getForegroundColor();

  /**
	 * Sets the value of the '{@link mda.PresentationScheme#getForegroundColor <em>Foreground Color</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Foreground Color</em>' attribute.
	 * @see #getForegroundColor()
	 * @generated
	 */
  void setForegroundColor(String value);

		/**
	 * Returns the value of the '<em><b>Show Chords</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Show Chords</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Show Chords</em>' attribute.
	 * @see #setShowChords(Boolean)
	 * @see mda.MidiplayerPackage#getPresentationScheme_ShowChords()
	 * @model
	 * @generated
	 */
	Boolean getShowChords();

		/**
	 * Sets the value of the '{@link mda.PresentationScheme#getShowChords <em>Show Chords</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Show Chords</em>' attribute.
	 * @see #getShowChords()
	 * @generated
	 */
	void setShowChords(Boolean value);

		/**
	 * Returns the value of the '<em><b>Auto Wrap To New Page</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Auto Wrap To New Page</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Auto Wrap To New Page</em>' attribute.
	 * @see #setAutoWrapToNewPage(Boolean)
	 * @see mda.MidiplayerPackage#getPresentationScheme_AutoWrapToNewPage()
	 * @model
	 * @generated
	 */
	Boolean getAutoWrapToNewPage();

		/**
	 * Sets the value of the '{@link mda.PresentationScheme#getAutoWrapToNewPage <em>Auto Wrap To New Page</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Auto Wrap To New Page</em>' attribute.
	 * @see #getAutoWrapToNewPage()
	 * @generated
	 */
	void setAutoWrapToNewPage(Boolean value);

} // PresentationScheme
