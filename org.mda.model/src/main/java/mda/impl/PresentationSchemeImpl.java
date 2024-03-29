/**
 */
package mda.impl;

import mda.MidiplayerPackage;
import mda.PresentationScheme;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Presentation Scheme</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link mda.impl.PresentationSchemeImpl#getName <em>Name</em>}</li>
 *   <li>{@link mda.impl.PresentationSchemeImpl#getShowBackground <em>Show Background</em>}</li>
 *   <li>{@link mda.impl.PresentationSchemeImpl#getShowBlockType <em>Show Block Type</em>}</li>
 *   <li>{@link mda.impl.PresentationSchemeImpl#getPagePerPart <em>Page Per Part</em>}</li>
 *   <li>{@link mda.impl.PresentationSchemeImpl#getNewPageRespected <em>New Page Respected</em>}</li>
 *   <li>{@link mda.impl.PresentationSchemeImpl#getShowTitle <em>Show Title</em>}</li>
 *   <li>{@link mda.impl.PresentationSchemeImpl#getShowCopyright <em>Show Copyright</em>}</li>
 *   <li>{@link mda.impl.PresentationSchemeImpl#getSkipEmptySlides <em>Skip Empty Slides</em>}</li>
 *   <li>{@link mda.impl.PresentationSchemeImpl#getOptimizeLineFilling <em>Optimize Line Filling</em>}</li>
 *   <li>{@link mda.impl.PresentationSchemeImpl#getOptimizeEqualParts <em>Optimize Equal Parts</em>}</li>
 *   <li>{@link mda.impl.PresentationSchemeImpl#getOptimizeEmptyTokens <em>Optimize Empty Tokens</em>}</li>
 *   <li>{@link mda.impl.PresentationSchemeImpl#getBorder <em>Border</em>}</li>
 *   <li>{@link mda.impl.PresentationSchemeImpl#getType <em>Type</em>}</li>
 *   <li>{@link mda.impl.PresentationSchemeImpl#getBackgroundColor <em>Background Color</em>}</li>
 *   <li>{@link mda.impl.PresentationSchemeImpl#getForegroundColor <em>Foreground Color</em>}</li>
 *   <li>{@link mda.impl.PresentationSchemeImpl#getShowChords <em>Show Chords</em>}</li>
 *   <li>{@link mda.impl.PresentationSchemeImpl#getAutoWrapToNewPage <em>Auto Wrap To New Page</em>}</li>
 *   <li>{@link mda.impl.PresentationSchemeImpl#getAutosizingPercent <em>Autosizing Percent</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PresentationSchemeImpl extends EObjectImpl implements PresentationScheme {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getShowBackground() <em>Show Background</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShowBackground()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean SHOW_BACKGROUND_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getShowBackground() <em>Show Background</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShowBackground()
	 * @generated
	 * @ordered
	 */
	protected Boolean showBackground = SHOW_BACKGROUND_EDEFAULT;

	/**
	 * The default value of the '{@link #getShowBlockType() <em>Show Block Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShowBlockType()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean SHOW_BLOCK_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getShowBlockType() <em>Show Block Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShowBlockType()
	 * @generated
	 * @ordered
	 */
	protected Boolean showBlockType = SHOW_BLOCK_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPagePerPart() <em>Page Per Part</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPagePerPart()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean PAGE_PER_PART_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPagePerPart() <em>Page Per Part</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPagePerPart()
	 * @generated
	 * @ordered
	 */
	protected Boolean pagePerPart = PAGE_PER_PART_EDEFAULT;

	/**
	 * The default value of the '{@link #getNewPageRespected() <em>New Page Respected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewPageRespected()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean NEW_PAGE_RESPECTED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNewPageRespected() <em>New Page Respected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewPageRespected()
	 * @generated
	 * @ordered
	 */
	protected Boolean newPageRespected = NEW_PAGE_RESPECTED_EDEFAULT;

	/**
	 * The default value of the '{@link #getShowTitle() <em>Show Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShowTitle()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean SHOW_TITLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getShowTitle() <em>Show Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShowTitle()
	 * @generated
	 * @ordered
	 */
	protected Boolean showTitle = SHOW_TITLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getShowCopyright() <em>Show Copyright</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShowCopyright()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean SHOW_COPYRIGHT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getShowCopyright() <em>Show Copyright</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShowCopyright()
	 * @generated
	 * @ordered
	 */
	protected Boolean showCopyright = SHOW_COPYRIGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #getSkipEmptySlides() <em>Skip Empty Slides</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSkipEmptySlides()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean SKIP_EMPTY_SLIDES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSkipEmptySlides() <em>Skip Empty Slides</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSkipEmptySlides()
	 * @generated
	 * @ordered
	 */
	protected Boolean skipEmptySlides = SKIP_EMPTY_SLIDES_EDEFAULT;

	/**
	 * The default value of the '{@link #getOptimizeLineFilling() <em>Optimize Line Filling</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptimizeLineFilling()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean OPTIMIZE_LINE_FILLING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOptimizeLineFilling() <em>Optimize Line Filling</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptimizeLineFilling()
	 * @generated
	 * @ordered
	 */
	protected Boolean optimizeLineFilling = OPTIMIZE_LINE_FILLING_EDEFAULT;

	/**
	 * The default value of the '{@link #getOptimizeEqualParts() <em>Optimize Equal Parts</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptimizeEqualParts()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean OPTIMIZE_EQUAL_PARTS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOptimizeEqualParts() <em>Optimize Equal Parts</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptimizeEqualParts()
	 * @generated
	 * @ordered
	 */
	protected Boolean optimizeEqualParts = OPTIMIZE_EQUAL_PARTS_EDEFAULT;

	/**
	 * The default value of the '{@link #getOptimizeEmptyTokens() <em>Optimize Empty Tokens</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptimizeEmptyTokens()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean OPTIMIZE_EMPTY_TOKENS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOptimizeEmptyTokens() <em>Optimize Empty Tokens</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptimizeEmptyTokens()
	 * @generated
	 * @ordered
	 */
	protected Boolean optimizeEmptyTokens = OPTIMIZE_EMPTY_TOKENS_EDEFAULT;

	/**
	 * The default value of the '{@link #getBorder() <em>Border</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBorder()
	 * @generated
	 * @ordered
	 */
	protected static final Integer BORDER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBorder() <em>Border</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBorder()
	 * @generated
	 * @ordered
	 */
	protected Integer border = BORDER_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getBackgroundColor() <em>Background Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBackgroundColor()
	 * @generated
	 * @ordered
	 */
	protected static final String BACKGROUND_COLOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBackgroundColor() <em>Background Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBackgroundColor()
	 * @generated
	 * @ordered
	 */
	protected String backgroundColor = BACKGROUND_COLOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getForegroundColor() <em>Foreground Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForegroundColor()
	 * @generated
	 * @ordered
	 */
	protected static final String FOREGROUND_COLOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getForegroundColor() <em>Foreground Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForegroundColor()
	 * @generated
	 * @ordered
	 */
	protected String foregroundColor = FOREGROUND_COLOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getShowChords() <em>Show Chords</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShowChords()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean SHOW_CHORDS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getShowChords() <em>Show Chords</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShowChords()
	 * @generated
	 * @ordered
	 */
	protected Boolean showChords = SHOW_CHORDS_EDEFAULT;

	/**
	 * The default value of the '{@link #getAutoWrapToNewPage() <em>Auto Wrap To New Page</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAutoWrapToNewPage()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean AUTO_WRAP_TO_NEW_PAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAutoWrapToNewPage() <em>Auto Wrap To New Page</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAutoWrapToNewPage()
	 * @generated
	 * @ordered
	 */
	protected Boolean autoWrapToNewPage = AUTO_WRAP_TO_NEW_PAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getAutosizingPercent() <em>Autosizing Percent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAutosizingPercent()
	 * @generated
	 * @ordered
	 */
	protected static final Integer AUTOSIZING_PERCENT_EDEFAULT = new Integer(100);

	/**
	 * The cached value of the '{@link #getAutosizingPercent() <em>Autosizing Percent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAutosizingPercent()
	 * @generated
	 * @ordered
	 */
	protected Integer autosizingPercent = AUTOSIZING_PERCENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PresentationSchemeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MidiplayerPackage.Literals.PRESENTATION_SCHEME;
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
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.PRESENTATION_SCHEME__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getShowBackground() {
		return showBackground;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShowBackground(Boolean newShowBackground) {
		Boolean oldShowBackground = showBackground;
		showBackground = newShowBackground;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.PRESENTATION_SCHEME__SHOW_BACKGROUND, oldShowBackground, showBackground));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getShowBlockType() {
		return showBlockType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShowBlockType(Boolean newShowBlockType) {
		Boolean oldShowBlockType = showBlockType;
		showBlockType = newShowBlockType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.PRESENTATION_SCHEME__SHOW_BLOCK_TYPE, oldShowBlockType, showBlockType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getPagePerPart() {
		return pagePerPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPagePerPart(Boolean newPagePerPart) {
		Boolean oldPagePerPart = pagePerPart;
		pagePerPart = newPagePerPart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.PRESENTATION_SCHEME__PAGE_PER_PART, oldPagePerPart, pagePerPart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getNewPageRespected() {
		return newPageRespected;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewPageRespected(Boolean newNewPageRespected) {
		Boolean oldNewPageRespected = newPageRespected;
		newPageRespected = newNewPageRespected;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.PRESENTATION_SCHEME__NEW_PAGE_RESPECTED, oldNewPageRespected, newPageRespected));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getShowTitle() {
		return showTitle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShowTitle(Boolean newShowTitle) {
		Boolean oldShowTitle = showTitle;
		showTitle = newShowTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.PRESENTATION_SCHEME__SHOW_TITLE, oldShowTitle, showTitle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getShowCopyright() {
		return showCopyright;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShowCopyright(Boolean newShowCopyright) {
		Boolean oldShowCopyright = showCopyright;
		showCopyright = newShowCopyright;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.PRESENTATION_SCHEME__SHOW_COPYRIGHT, oldShowCopyright, showCopyright));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getSkipEmptySlides() {
		return skipEmptySlides;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSkipEmptySlides(Boolean newSkipEmptySlides) {
		Boolean oldSkipEmptySlides = skipEmptySlides;
		skipEmptySlides = newSkipEmptySlides;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.PRESENTATION_SCHEME__SKIP_EMPTY_SLIDES, oldSkipEmptySlides, skipEmptySlides));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getOptimizeLineFilling() {
		return optimizeLineFilling;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOptimizeLineFilling(Boolean newOptimizeLineFilling) {
		Boolean oldOptimizeLineFilling = optimizeLineFilling;
		optimizeLineFilling = newOptimizeLineFilling;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.PRESENTATION_SCHEME__OPTIMIZE_LINE_FILLING, oldOptimizeLineFilling, optimizeLineFilling));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getOptimizeEqualParts() {
		return optimizeEqualParts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOptimizeEqualParts(Boolean newOptimizeEqualParts) {
		Boolean oldOptimizeEqualParts = optimizeEqualParts;
		optimizeEqualParts = newOptimizeEqualParts;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.PRESENTATION_SCHEME__OPTIMIZE_EQUAL_PARTS, oldOptimizeEqualParts, optimizeEqualParts));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getOptimizeEmptyTokens() {
		return optimizeEmptyTokens;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOptimizeEmptyTokens(Boolean newOptimizeEmptyTokens) {
		Boolean oldOptimizeEmptyTokens = optimizeEmptyTokens;
		optimizeEmptyTokens = newOptimizeEmptyTokens;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.PRESENTATION_SCHEME__OPTIMIZE_EMPTY_TOKENS, oldOptimizeEmptyTokens, optimizeEmptyTokens));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getBorder() {
		return border;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBorder(Integer newBorder) {
		Integer oldBorder = border;
		border = newBorder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.PRESENTATION_SCHEME__BORDER, oldBorder, border));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.PRESENTATION_SCHEME__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBackgroundColor() {
		return backgroundColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBackgroundColor(String newBackgroundColor) {
		String oldBackgroundColor = backgroundColor;
		backgroundColor = newBackgroundColor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.PRESENTATION_SCHEME__BACKGROUND_COLOR, oldBackgroundColor, backgroundColor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getForegroundColor() {
		return foregroundColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setForegroundColor(String newForegroundColor) {
		String oldForegroundColor = foregroundColor;
		foregroundColor = newForegroundColor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.PRESENTATION_SCHEME__FOREGROUND_COLOR, oldForegroundColor, foregroundColor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getShowChords() {
		return showChords;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShowChords(Boolean newShowChords) {
		Boolean oldShowChords = showChords;
		showChords = newShowChords;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.PRESENTATION_SCHEME__SHOW_CHORDS, oldShowChords, showChords));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getAutoWrapToNewPage() {
		return autoWrapToNewPage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAutoWrapToNewPage(Boolean newAutoWrapToNewPage) {
		Boolean oldAutoWrapToNewPage = autoWrapToNewPage;
		autoWrapToNewPage = newAutoWrapToNewPage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.PRESENTATION_SCHEME__AUTO_WRAP_TO_NEW_PAGE, oldAutoWrapToNewPage, autoWrapToNewPage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getAutosizingPercent() {
		return autosizingPercent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAutosizingPercent(Integer newAutosizingPercent) {
		Integer oldAutosizingPercent = autosizingPercent;
		autosizingPercent = newAutosizingPercent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.PRESENTATION_SCHEME__AUTOSIZING_PERCENT, oldAutosizingPercent, autosizingPercent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MidiplayerPackage.PRESENTATION_SCHEME__NAME:
				return getName();
			case MidiplayerPackage.PRESENTATION_SCHEME__SHOW_BACKGROUND:
				return getShowBackground();
			case MidiplayerPackage.PRESENTATION_SCHEME__SHOW_BLOCK_TYPE:
				return getShowBlockType();
			case MidiplayerPackage.PRESENTATION_SCHEME__PAGE_PER_PART:
				return getPagePerPart();
			case MidiplayerPackage.PRESENTATION_SCHEME__NEW_PAGE_RESPECTED:
				return getNewPageRespected();
			case MidiplayerPackage.PRESENTATION_SCHEME__SHOW_TITLE:
				return getShowTitle();
			case MidiplayerPackage.PRESENTATION_SCHEME__SHOW_COPYRIGHT:
				return getShowCopyright();
			case MidiplayerPackage.PRESENTATION_SCHEME__SKIP_EMPTY_SLIDES:
				return getSkipEmptySlides();
			case MidiplayerPackage.PRESENTATION_SCHEME__OPTIMIZE_LINE_FILLING:
				return getOptimizeLineFilling();
			case MidiplayerPackage.PRESENTATION_SCHEME__OPTIMIZE_EQUAL_PARTS:
				return getOptimizeEqualParts();
			case MidiplayerPackage.PRESENTATION_SCHEME__OPTIMIZE_EMPTY_TOKENS:
				return getOptimizeEmptyTokens();
			case MidiplayerPackage.PRESENTATION_SCHEME__BORDER:
				return getBorder();
			case MidiplayerPackage.PRESENTATION_SCHEME__TYPE:
				return getType();
			case MidiplayerPackage.PRESENTATION_SCHEME__BACKGROUND_COLOR:
				return getBackgroundColor();
			case MidiplayerPackage.PRESENTATION_SCHEME__FOREGROUND_COLOR:
				return getForegroundColor();
			case MidiplayerPackage.PRESENTATION_SCHEME__SHOW_CHORDS:
				return getShowChords();
			case MidiplayerPackage.PRESENTATION_SCHEME__AUTO_WRAP_TO_NEW_PAGE:
				return getAutoWrapToNewPage();
			case MidiplayerPackage.PRESENTATION_SCHEME__AUTOSIZING_PERCENT:
				return getAutosizingPercent();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MidiplayerPackage.PRESENTATION_SCHEME__NAME:
				setName((String)newValue);
				return;
			case MidiplayerPackage.PRESENTATION_SCHEME__SHOW_BACKGROUND:
				setShowBackground((Boolean)newValue);
				return;
			case MidiplayerPackage.PRESENTATION_SCHEME__SHOW_BLOCK_TYPE:
				setShowBlockType((Boolean)newValue);
				return;
			case MidiplayerPackage.PRESENTATION_SCHEME__PAGE_PER_PART:
				setPagePerPart((Boolean)newValue);
				return;
			case MidiplayerPackage.PRESENTATION_SCHEME__NEW_PAGE_RESPECTED:
				setNewPageRespected((Boolean)newValue);
				return;
			case MidiplayerPackage.PRESENTATION_SCHEME__SHOW_TITLE:
				setShowTitle((Boolean)newValue);
				return;
			case MidiplayerPackage.PRESENTATION_SCHEME__SHOW_COPYRIGHT:
				setShowCopyright((Boolean)newValue);
				return;
			case MidiplayerPackage.PRESENTATION_SCHEME__SKIP_EMPTY_SLIDES:
				setSkipEmptySlides((Boolean)newValue);
				return;
			case MidiplayerPackage.PRESENTATION_SCHEME__OPTIMIZE_LINE_FILLING:
				setOptimizeLineFilling((Boolean)newValue);
				return;
			case MidiplayerPackage.PRESENTATION_SCHEME__OPTIMIZE_EQUAL_PARTS:
				setOptimizeEqualParts((Boolean)newValue);
				return;
			case MidiplayerPackage.PRESENTATION_SCHEME__OPTIMIZE_EMPTY_TOKENS:
				setOptimizeEmptyTokens((Boolean)newValue);
				return;
			case MidiplayerPackage.PRESENTATION_SCHEME__BORDER:
				setBorder((Integer)newValue);
				return;
			case MidiplayerPackage.PRESENTATION_SCHEME__TYPE:
				setType((String)newValue);
				return;
			case MidiplayerPackage.PRESENTATION_SCHEME__BACKGROUND_COLOR:
				setBackgroundColor((String)newValue);
				return;
			case MidiplayerPackage.PRESENTATION_SCHEME__FOREGROUND_COLOR:
				setForegroundColor((String)newValue);
				return;
			case MidiplayerPackage.PRESENTATION_SCHEME__SHOW_CHORDS:
				setShowChords((Boolean)newValue);
				return;
			case MidiplayerPackage.PRESENTATION_SCHEME__AUTO_WRAP_TO_NEW_PAGE:
				setAutoWrapToNewPage((Boolean)newValue);
				return;
			case MidiplayerPackage.PRESENTATION_SCHEME__AUTOSIZING_PERCENT:
				setAutosizingPercent((Integer)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MidiplayerPackage.PRESENTATION_SCHEME__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MidiplayerPackage.PRESENTATION_SCHEME__SHOW_BACKGROUND:
				setShowBackground(SHOW_BACKGROUND_EDEFAULT);
				return;
			case MidiplayerPackage.PRESENTATION_SCHEME__SHOW_BLOCK_TYPE:
				setShowBlockType(SHOW_BLOCK_TYPE_EDEFAULT);
				return;
			case MidiplayerPackage.PRESENTATION_SCHEME__PAGE_PER_PART:
				setPagePerPart(PAGE_PER_PART_EDEFAULT);
				return;
			case MidiplayerPackage.PRESENTATION_SCHEME__NEW_PAGE_RESPECTED:
				setNewPageRespected(NEW_PAGE_RESPECTED_EDEFAULT);
				return;
			case MidiplayerPackage.PRESENTATION_SCHEME__SHOW_TITLE:
				setShowTitle(SHOW_TITLE_EDEFAULT);
				return;
			case MidiplayerPackage.PRESENTATION_SCHEME__SHOW_COPYRIGHT:
				setShowCopyright(SHOW_COPYRIGHT_EDEFAULT);
				return;
			case MidiplayerPackage.PRESENTATION_SCHEME__SKIP_EMPTY_SLIDES:
				setSkipEmptySlides(SKIP_EMPTY_SLIDES_EDEFAULT);
				return;
			case MidiplayerPackage.PRESENTATION_SCHEME__OPTIMIZE_LINE_FILLING:
				setOptimizeLineFilling(OPTIMIZE_LINE_FILLING_EDEFAULT);
				return;
			case MidiplayerPackage.PRESENTATION_SCHEME__OPTIMIZE_EQUAL_PARTS:
				setOptimizeEqualParts(OPTIMIZE_EQUAL_PARTS_EDEFAULT);
				return;
			case MidiplayerPackage.PRESENTATION_SCHEME__OPTIMIZE_EMPTY_TOKENS:
				setOptimizeEmptyTokens(OPTIMIZE_EMPTY_TOKENS_EDEFAULT);
				return;
			case MidiplayerPackage.PRESENTATION_SCHEME__BORDER:
				setBorder(BORDER_EDEFAULT);
				return;
			case MidiplayerPackage.PRESENTATION_SCHEME__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case MidiplayerPackage.PRESENTATION_SCHEME__BACKGROUND_COLOR:
				setBackgroundColor(BACKGROUND_COLOR_EDEFAULT);
				return;
			case MidiplayerPackage.PRESENTATION_SCHEME__FOREGROUND_COLOR:
				setForegroundColor(FOREGROUND_COLOR_EDEFAULT);
				return;
			case MidiplayerPackage.PRESENTATION_SCHEME__SHOW_CHORDS:
				setShowChords(SHOW_CHORDS_EDEFAULT);
				return;
			case MidiplayerPackage.PRESENTATION_SCHEME__AUTO_WRAP_TO_NEW_PAGE:
				setAutoWrapToNewPage(AUTO_WRAP_TO_NEW_PAGE_EDEFAULT);
				return;
			case MidiplayerPackage.PRESENTATION_SCHEME__AUTOSIZING_PERCENT:
				setAutosizingPercent(AUTOSIZING_PERCENT_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MidiplayerPackage.PRESENTATION_SCHEME__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case MidiplayerPackage.PRESENTATION_SCHEME__SHOW_BACKGROUND:
				return SHOW_BACKGROUND_EDEFAULT == null ? showBackground != null : !SHOW_BACKGROUND_EDEFAULT.equals(showBackground);
			case MidiplayerPackage.PRESENTATION_SCHEME__SHOW_BLOCK_TYPE:
				return SHOW_BLOCK_TYPE_EDEFAULT == null ? showBlockType != null : !SHOW_BLOCK_TYPE_EDEFAULT.equals(showBlockType);
			case MidiplayerPackage.PRESENTATION_SCHEME__PAGE_PER_PART:
				return PAGE_PER_PART_EDEFAULT == null ? pagePerPart != null : !PAGE_PER_PART_EDEFAULT.equals(pagePerPart);
			case MidiplayerPackage.PRESENTATION_SCHEME__NEW_PAGE_RESPECTED:
				return NEW_PAGE_RESPECTED_EDEFAULT == null ? newPageRespected != null : !NEW_PAGE_RESPECTED_EDEFAULT.equals(newPageRespected);
			case MidiplayerPackage.PRESENTATION_SCHEME__SHOW_TITLE:
				return SHOW_TITLE_EDEFAULT == null ? showTitle != null : !SHOW_TITLE_EDEFAULT.equals(showTitle);
			case MidiplayerPackage.PRESENTATION_SCHEME__SHOW_COPYRIGHT:
				return SHOW_COPYRIGHT_EDEFAULT == null ? showCopyright != null : !SHOW_COPYRIGHT_EDEFAULT.equals(showCopyright);
			case MidiplayerPackage.PRESENTATION_SCHEME__SKIP_EMPTY_SLIDES:
				return SKIP_EMPTY_SLIDES_EDEFAULT == null ? skipEmptySlides != null : !SKIP_EMPTY_SLIDES_EDEFAULT.equals(skipEmptySlides);
			case MidiplayerPackage.PRESENTATION_SCHEME__OPTIMIZE_LINE_FILLING:
				return OPTIMIZE_LINE_FILLING_EDEFAULT == null ? optimizeLineFilling != null : !OPTIMIZE_LINE_FILLING_EDEFAULT.equals(optimizeLineFilling);
			case MidiplayerPackage.PRESENTATION_SCHEME__OPTIMIZE_EQUAL_PARTS:
				return OPTIMIZE_EQUAL_PARTS_EDEFAULT == null ? optimizeEqualParts != null : !OPTIMIZE_EQUAL_PARTS_EDEFAULT.equals(optimizeEqualParts);
			case MidiplayerPackage.PRESENTATION_SCHEME__OPTIMIZE_EMPTY_TOKENS:
				return OPTIMIZE_EMPTY_TOKENS_EDEFAULT == null ? optimizeEmptyTokens != null : !OPTIMIZE_EMPTY_TOKENS_EDEFAULT.equals(optimizeEmptyTokens);
			case MidiplayerPackage.PRESENTATION_SCHEME__BORDER:
				return BORDER_EDEFAULT == null ? border != null : !BORDER_EDEFAULT.equals(border);
			case MidiplayerPackage.PRESENTATION_SCHEME__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case MidiplayerPackage.PRESENTATION_SCHEME__BACKGROUND_COLOR:
				return BACKGROUND_COLOR_EDEFAULT == null ? backgroundColor != null : !BACKGROUND_COLOR_EDEFAULT.equals(backgroundColor);
			case MidiplayerPackage.PRESENTATION_SCHEME__FOREGROUND_COLOR:
				return FOREGROUND_COLOR_EDEFAULT == null ? foregroundColor != null : !FOREGROUND_COLOR_EDEFAULT.equals(foregroundColor);
			case MidiplayerPackage.PRESENTATION_SCHEME__SHOW_CHORDS:
				return SHOW_CHORDS_EDEFAULT == null ? showChords != null : !SHOW_CHORDS_EDEFAULT.equals(showChords);
			case MidiplayerPackage.PRESENTATION_SCHEME__AUTO_WRAP_TO_NEW_PAGE:
				return AUTO_WRAP_TO_NEW_PAGE_EDEFAULT == null ? autoWrapToNewPage != null : !AUTO_WRAP_TO_NEW_PAGE_EDEFAULT.equals(autoWrapToNewPage);
			case MidiplayerPackage.PRESENTATION_SCHEME__AUTOSIZING_PERCENT:
				return AUTOSIZING_PERCENT_EDEFAULT == null ? autosizingPercent != null : !AUTOSIZING_PERCENT_EDEFAULT.equals(autosizingPercent);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", showBackground: ");
		result.append(showBackground);
		result.append(", showBlockType: ");
		result.append(showBlockType);
		result.append(", pagePerPart: ");
		result.append(pagePerPart);
		result.append(", newPageRespected: ");
		result.append(newPageRespected);
		result.append(", showTitle: ");
		result.append(showTitle);
		result.append(", showCopyright: ");
		result.append(showCopyright);
		result.append(", skipEmptySlides: ");
		result.append(skipEmptySlides);
		result.append(", optimizeLineFilling: ");
		result.append(optimizeLineFilling);
		result.append(", optimizeEqualParts: ");
		result.append(optimizeEqualParts);
		result.append(", optimizeEmptyTokens: ");
		result.append(optimizeEmptyTokens);
		result.append(", border: ");
		result.append(border);
		result.append(", type: ");
		result.append(type);
		result.append(", backgroundColor: ");
		result.append(backgroundColor);
		result.append(", foregroundColor: ");
		result.append(foregroundColor);
		result.append(", showChords: ");
		result.append(showChords);
		result.append(", autoWrapToNewPage: ");
		result.append(autoWrapToNewPage);
		result.append(", autosizingPercent: ");
		result.append(autosizingPercent);
		result.append(')');
		return result.toString();
	}

} //PresentationSchemeImpl
