/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package mda.impl;

import mda.Copyright;
import mda.MidiplayerPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Copyright</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link mda.impl.CopyrightImpl#getOriginaltitle <em>Originaltitle</em>}</li>
 *   <li>{@link mda.impl.CopyrightImpl#getWriterMusic <em>Writer Music</em>}</li>
 *   <li>{@link mda.impl.CopyrightImpl#getWriterText <em>Writer Text</em>}</li>
 *   <li>{@link mda.impl.CopyrightImpl#getWriterInlandText <em>Writer Inland Text</em>}</li>
 *   <li>{@link mda.impl.CopyrightImpl#getYear <em>Year</em>}</li>
 *   <li>{@link mda.impl.CopyrightImpl#getPublisher <em>Publisher</em>}</li>
 *   <li>{@link mda.impl.CopyrightImpl#getPublisherInland <em>Publisher Inland</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CopyrightImpl extends EObjectImpl implements Copyright {
  /**
	 * The default value of the '{@link #getOriginaltitle() <em>Originaltitle</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getOriginaltitle()
	 * @generated
	 * @ordered
	 */
  protected static final String ORIGINALTITLE_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getOriginaltitle() <em>Originaltitle</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getOriginaltitle()
	 * @generated
	 * @ordered
	 */
  protected String originaltitle = ORIGINALTITLE_EDEFAULT;

  /**
	 * The default value of the '{@link #getWriterMusic() <em>Writer Music</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getWriterMusic()
	 * @generated
	 * @ordered
	 */
  protected static final String WRITER_MUSIC_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getWriterMusic() <em>Writer Music</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getWriterMusic()
	 * @generated
	 * @ordered
	 */
  protected String writerMusic = WRITER_MUSIC_EDEFAULT;

  /**
	 * The default value of the '{@link #getWriterText() <em>Writer Text</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getWriterText()
	 * @generated
	 * @ordered
	 */
  protected static final String WRITER_TEXT_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getWriterText() <em>Writer Text</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getWriterText()
	 * @generated
	 * @ordered
	 */
  protected String writerText = WRITER_TEXT_EDEFAULT;

  /**
	 * The default value of the '{@link #getWriterInlandText() <em>Writer Inland Text</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getWriterInlandText()
	 * @generated
	 * @ordered
	 */
  protected static final String WRITER_INLAND_TEXT_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getWriterInlandText() <em>Writer Inland Text</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getWriterInlandText()
	 * @generated
	 * @ordered
	 */
  protected String writerInlandText = WRITER_INLAND_TEXT_EDEFAULT;

  /**
	 * The default value of the '{@link #getYear() <em>Year</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getYear()
	 * @generated
	 * @ordered
	 */
  protected static final int YEAR_EDEFAULT = 0;

  /**
	 * The cached value of the '{@link #getYear() <em>Year</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getYear()
	 * @generated
	 * @ordered
	 */
  protected int year = YEAR_EDEFAULT;

  /**
	 * The default value of the '{@link #getPublisher() <em>Publisher</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getPublisher()
	 * @generated
	 * @ordered
	 */
  protected static final String PUBLISHER_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getPublisher() <em>Publisher</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getPublisher()
	 * @generated
	 * @ordered
	 */
  protected String publisher = PUBLISHER_EDEFAULT;

  /**
	 * The default value of the '{@link #getPublisherInland() <em>Publisher Inland</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getPublisherInland()
	 * @generated
	 * @ordered
	 */
  protected static final String PUBLISHER_INLAND_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getPublisherInland() <em>Publisher Inland</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getPublisherInland()
	 * @generated
	 * @ordered
	 */
  protected String publisherInland = PUBLISHER_INLAND_EDEFAULT;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected CopyrightImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return MidiplayerPackage.Literals.COPYRIGHT;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getOriginaltitle() {
		return originaltitle;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setOriginaltitle(String newOriginaltitle) {
		String oldOriginaltitle = originaltitle;
		originaltitle = newOriginaltitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.COPYRIGHT__ORIGINALTITLE, oldOriginaltitle, originaltitle));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getWriterMusic() {
		return writerMusic;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setWriterMusic(String newWriterMusic) {
		String oldWriterMusic = writerMusic;
		writerMusic = newWriterMusic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.COPYRIGHT__WRITER_MUSIC, oldWriterMusic, writerMusic));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getWriterText() {
		return writerText;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setWriterText(String newWriterText) {
		String oldWriterText = writerText;
		writerText = newWriterText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.COPYRIGHT__WRITER_TEXT, oldWriterText, writerText));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getWriterInlandText() {
		return writerInlandText;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setWriterInlandText(String newWriterInlandText) {
		String oldWriterInlandText = writerInlandText;
		writerInlandText = newWriterInlandText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.COPYRIGHT__WRITER_INLAND_TEXT, oldWriterInlandText, writerInlandText));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public int getYear() {
		return year;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setYear(int newYear) {
		int oldYear = year;
		year = newYear;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.COPYRIGHT__YEAR, oldYear, year));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getPublisher() {
		return publisher;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setPublisher(String newPublisher) {
		String oldPublisher = publisher;
		publisher = newPublisher;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.COPYRIGHT__PUBLISHER, oldPublisher, publisher));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getPublisherInland() {
		return publisherInland;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setPublisherInland(String newPublisherInland) {
		String oldPublisherInland = publisherInland;
		publisherInland = newPublisherInland;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.COPYRIGHT__PUBLISHER_INLAND, oldPublisherInland, publisherInland));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MidiplayerPackage.COPYRIGHT__ORIGINALTITLE:
				return getOriginaltitle();
			case MidiplayerPackage.COPYRIGHT__WRITER_MUSIC:
				return getWriterMusic();
			case MidiplayerPackage.COPYRIGHT__WRITER_TEXT:
				return getWriterText();
			case MidiplayerPackage.COPYRIGHT__WRITER_INLAND_TEXT:
				return getWriterInlandText();
			case MidiplayerPackage.COPYRIGHT__YEAR:
				return getYear();
			case MidiplayerPackage.COPYRIGHT__PUBLISHER:
				return getPublisher();
			case MidiplayerPackage.COPYRIGHT__PUBLISHER_INLAND:
				return getPublisherInland();
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
			case MidiplayerPackage.COPYRIGHT__ORIGINALTITLE:
				setOriginaltitle((String)newValue);
				return;
			case MidiplayerPackage.COPYRIGHT__WRITER_MUSIC:
				setWriterMusic((String)newValue);
				return;
			case MidiplayerPackage.COPYRIGHT__WRITER_TEXT:
				setWriterText((String)newValue);
				return;
			case MidiplayerPackage.COPYRIGHT__WRITER_INLAND_TEXT:
				setWriterInlandText((String)newValue);
				return;
			case MidiplayerPackage.COPYRIGHT__YEAR:
				setYear((Integer)newValue);
				return;
			case MidiplayerPackage.COPYRIGHT__PUBLISHER:
				setPublisher((String)newValue);
				return;
			case MidiplayerPackage.COPYRIGHT__PUBLISHER_INLAND:
				setPublisherInland((String)newValue);
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
			case MidiplayerPackage.COPYRIGHT__ORIGINALTITLE:
				setOriginaltitle(ORIGINALTITLE_EDEFAULT);
				return;
			case MidiplayerPackage.COPYRIGHT__WRITER_MUSIC:
				setWriterMusic(WRITER_MUSIC_EDEFAULT);
				return;
			case MidiplayerPackage.COPYRIGHT__WRITER_TEXT:
				setWriterText(WRITER_TEXT_EDEFAULT);
				return;
			case MidiplayerPackage.COPYRIGHT__WRITER_INLAND_TEXT:
				setWriterInlandText(WRITER_INLAND_TEXT_EDEFAULT);
				return;
			case MidiplayerPackage.COPYRIGHT__YEAR:
				setYear(YEAR_EDEFAULT);
				return;
			case MidiplayerPackage.COPYRIGHT__PUBLISHER:
				setPublisher(PUBLISHER_EDEFAULT);
				return;
			case MidiplayerPackage.COPYRIGHT__PUBLISHER_INLAND:
				setPublisherInland(PUBLISHER_INLAND_EDEFAULT);
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
			case MidiplayerPackage.COPYRIGHT__ORIGINALTITLE:
				return ORIGINALTITLE_EDEFAULT == null ? originaltitle != null : !ORIGINALTITLE_EDEFAULT.equals(originaltitle);
			case MidiplayerPackage.COPYRIGHT__WRITER_MUSIC:
				return WRITER_MUSIC_EDEFAULT == null ? writerMusic != null : !WRITER_MUSIC_EDEFAULT.equals(writerMusic);
			case MidiplayerPackage.COPYRIGHT__WRITER_TEXT:
				return WRITER_TEXT_EDEFAULT == null ? writerText != null : !WRITER_TEXT_EDEFAULT.equals(writerText);
			case MidiplayerPackage.COPYRIGHT__WRITER_INLAND_TEXT:
				return WRITER_INLAND_TEXT_EDEFAULT == null ? writerInlandText != null : !WRITER_INLAND_TEXT_EDEFAULT.equals(writerInlandText);
			case MidiplayerPackage.COPYRIGHT__YEAR:
				return year != YEAR_EDEFAULT;
			case MidiplayerPackage.COPYRIGHT__PUBLISHER:
				return PUBLISHER_EDEFAULT == null ? publisher != null : !PUBLISHER_EDEFAULT.equals(publisher);
			case MidiplayerPackage.COPYRIGHT__PUBLISHER_INLAND:
				return PUBLISHER_INLAND_EDEFAULT == null ? publisherInland != null : !PUBLISHER_INLAND_EDEFAULT.equals(publisherInland);
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
		result.append(" (originaltitle: ");
		result.append(originaltitle);
		result.append(", writerMusic: ");
		result.append(writerMusic);
		result.append(", writerText: ");
		result.append(writerText);
		result.append(", writerInlandText: ");
		result.append(writerInlandText);
		result.append(", year: ");
		result.append(year);
		result.append(", publisher: ");
		result.append(publisher);
		result.append(", publisherInland: ");
		result.append(publisherInland);
		result.append(')');
		return result.toString();
	}

} //CopyrightImpl
