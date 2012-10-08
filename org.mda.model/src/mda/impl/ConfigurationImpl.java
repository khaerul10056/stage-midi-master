/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package mda.impl;

import mda.Configuration;
import mda.MidiplayerPackage;

import mda.Session;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link mda.impl.ConfigurationImpl#getScreenIDPresentation <em>Screen ID Presentation</em>}</li>
 *   <li>{@link mda.impl.ConfigurationImpl#getScreenIDAdmin <em>Screen ID Admin</em>}</li>
 *   <li>{@link mda.impl.ConfigurationImpl#getLastSession <em>Last Session</em>}</li>
 *   <li>{@link mda.impl.ConfigurationImpl#getPdfExportPath <em>Pdf Export Path</em>}</li>
 *   <li>{@link mda.impl.ConfigurationImpl#getAdditionalsPath <em>Additionals Path</em>}</li>
 *   <li>{@link mda.impl.ConfigurationImpl#getFontsize <em>Fontsize</em>}</li>
 *   <li>{@link mda.impl.ConfigurationImpl#getMailtextSendSongbook <em>Mailtext Send Songbook</em>}</li>
 *   <li>{@link mda.impl.ConfigurationImpl#getMailserverUrl <em>Mailserver Url</em>}</li>
 *   <li>{@link mda.impl.ConfigurationImpl#getMailserverUser <em>Mailserver User</em>}</li>
 *   <li>{@link mda.impl.ConfigurationImpl#getMailserverPassword <em>Mailserver Password</em>}</li>
 *   <li>{@link mda.impl.ConfigurationImpl#getMailsubjectSendSongbook <em>Mailsubject Send Songbook</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConfigurationImpl extends EObjectImpl implements Configuration {
  /**
	 * The default value of the '{@link #getScreenIDPresentation() <em>Screen ID Presentation</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getScreenIDPresentation()
	 * @generated
	 * @ordered
	 */
  protected static final String SCREEN_ID_PRESENTATION_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getScreenIDPresentation() <em>Screen ID Presentation</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getScreenIDPresentation()
	 * @generated
	 * @ordered
	 */
  protected String screenIDPresentation = SCREEN_ID_PRESENTATION_EDEFAULT;

  /**
	 * The default value of the '{@link #getScreenIDAdmin() <em>Screen ID Admin</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getScreenIDAdmin()
	 * @generated
	 * @ordered
	 */
  protected static final String SCREEN_ID_ADMIN_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getScreenIDAdmin() <em>Screen ID Admin</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getScreenIDAdmin()
	 * @generated
	 * @ordered
	 */
  protected String screenIDAdmin = SCREEN_ID_ADMIN_EDEFAULT;

  /**
	 * The cached value of the '{@link #getLastSession() <em>Last Session</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLastSession()
	 * @generated
	 * @ordered
	 */
  protected Session lastSession;

  /**
	 * The default value of the '{@link #getPdfExportPath() <em>Pdf Export Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPdfExportPath()
	 * @generated
	 * @ordered
	 */
	protected static final String PDF_EXPORT_PATH_EDEFAULT = null;

		/**
	 * The cached value of the '{@link #getPdfExportPath() <em>Pdf Export Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPdfExportPath()
	 * @generated
	 * @ordered
	 */
	protected String pdfExportPath = PDF_EXPORT_PATH_EDEFAULT;

		/**
	 * The default value of the '{@link #getAdditionalsPath() <em>Additionals Path</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getAdditionalsPath()
	 * @generated
	 * @ordered
	 */
  protected static final String ADDITIONALS_PATH_EDEFAULT = null;

    /**
	 * The cached value of the '{@link #getAdditionalsPath() <em>Additionals Path</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getAdditionalsPath()
	 * @generated
	 * @ordered
	 */
  protected String additionalsPath = ADDITIONALS_PATH_EDEFAULT;

    /**
	 * The default value of the '{@link #getFontsize() <em>Fontsize</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getFontsize()
	 * @generated
	 * @ordered
	 */
  protected static final Integer FONTSIZE_EDEFAULT = null;

    /**
	 * The cached value of the '{@link #getFontsize() <em>Fontsize</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getFontsize()
	 * @generated
	 * @ordered
	 */
  protected Integer fontsize = FONTSIZE_EDEFAULT;

    /**
	 * The default value of the '{@link #getMailtextSendSongbook() <em>Mailtext Send Songbook</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMailtextSendSongbook()
	 * @generated
	 * @ordered
	 */
	protected static final String MAILTEXT_SEND_SONGBOOK_EDEFAULT = null;

				/**
	 * The cached value of the '{@link #getMailtextSendSongbook() <em>Mailtext Send Songbook</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMailtextSendSongbook()
	 * @generated
	 * @ordered
	 */
	protected String mailtextSendSongbook = MAILTEXT_SEND_SONGBOOK_EDEFAULT;

				/**
	 * The default value of the '{@link #getMailserverUrl() <em>Mailserver Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMailserverUrl()
	 * @generated
	 * @ordered
	 */
	protected static final String MAILSERVER_URL_EDEFAULT = "";

				/**
	 * The cached value of the '{@link #getMailserverUrl() <em>Mailserver Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMailserverUrl()
	 * @generated
	 * @ordered
	 */
	protected String mailserverUrl = MAILSERVER_URL_EDEFAULT;

				/**
	 * The default value of the '{@link #getMailserverUser() <em>Mailserver User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMailserverUser()
	 * @generated
	 * @ordered
	 */
	protected static final String MAILSERVER_USER_EDEFAULT = null;

				/**
	 * The cached value of the '{@link #getMailserverUser() <em>Mailserver User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMailserverUser()
	 * @generated
	 * @ordered
	 */
	protected String mailserverUser = MAILSERVER_USER_EDEFAULT;

				/**
	 * The default value of the '{@link #getMailserverPassword() <em>Mailserver Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMailserverPassword()
	 * @generated
	 * @ordered
	 */
	protected static final String MAILSERVER_PASSWORD_EDEFAULT = null;

				/**
	 * The cached value of the '{@link #getMailserverPassword() <em>Mailserver Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMailserverPassword()
	 * @generated
	 * @ordered
	 */
	protected String mailserverPassword = MAILSERVER_PASSWORD_EDEFAULT;

				/**
	 * The default value of the '{@link #getMailsubjectSendSongbook() <em>Mailsubject Send Songbook</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMailsubjectSendSongbook()
	 * @generated
	 * @ordered
	 */
	protected static final String MAILSUBJECT_SEND_SONGBOOK_EDEFAULT = null;

				/**
	 * The cached value of the '{@link #getMailsubjectSendSongbook() <em>Mailsubject Send Songbook</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMailsubjectSendSongbook()
	 * @generated
	 * @ordered
	 */
	protected String mailsubjectSendSongbook = MAILSUBJECT_SEND_SONGBOOK_EDEFAULT;

				/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected ConfigurationImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return MidiplayerPackage.Literals.CONFIGURATION;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getScreenIDPresentation() {
		return screenIDPresentation;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setScreenIDPresentation(String newScreenIDPresentation) {
		String oldScreenIDPresentation = screenIDPresentation;
		screenIDPresentation = newScreenIDPresentation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.CONFIGURATION__SCREEN_ID_PRESENTATION, oldScreenIDPresentation, screenIDPresentation));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getScreenIDAdmin() {
		return screenIDAdmin;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setScreenIDAdmin(String newScreenIDAdmin) {
		String oldScreenIDAdmin = screenIDAdmin;
		screenIDAdmin = newScreenIDAdmin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.CONFIGURATION__SCREEN_ID_ADMIN, oldScreenIDAdmin, screenIDAdmin));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Session getLastSession() {
		if (lastSession != null && lastSession.eIsProxy()) {
			InternalEObject oldLastSession = (InternalEObject)lastSession;
			lastSession = (Session)eResolveProxy(oldLastSession);
			if (lastSession != oldLastSession) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MidiplayerPackage.CONFIGURATION__LAST_SESSION, oldLastSession, lastSession));
			}
		}
		return lastSession;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Session basicGetLastSession() {
		return lastSession;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setLastSession(Session newLastSession) {
		Session oldLastSession = lastSession;
		lastSession = newLastSession;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.CONFIGURATION__LAST_SESSION, oldLastSession, lastSession));
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPdfExportPath() {
		return pdfExportPath;
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPdfExportPath(String newPdfExportPath) {
		String oldPdfExportPath = pdfExportPath;
		pdfExportPath = newPdfExportPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.CONFIGURATION__PDF_EXPORT_PATH, oldPdfExportPath, pdfExportPath));
	}

		/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getAdditionalsPath() {
		return additionalsPath;
	}

    /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setAdditionalsPath(String newAdditionalsPath) {
		String oldAdditionalsPath = additionalsPath;
		additionalsPath = newAdditionalsPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.CONFIGURATION__ADDITIONALS_PATH, oldAdditionalsPath, additionalsPath));
	}

    /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Integer getFontsize() {
		return fontsize;
	}

    /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setFontsize(Integer newFontsize) {
		Integer oldFontsize = fontsize;
		fontsize = newFontsize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.CONFIGURATION__FONTSIZE, oldFontsize, fontsize));
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMailtextSendSongbook() {
		return mailtextSendSongbook;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMailtextSendSongbook(String newMailtextSendSongbook) {
		String oldMailtextSendSongbook = mailtextSendSongbook;
		mailtextSendSongbook = newMailtextSendSongbook;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.CONFIGURATION__MAILTEXT_SEND_SONGBOOK, oldMailtextSendSongbook, mailtextSendSongbook));
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMailserverUrl() {
		return mailserverUrl;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMailserverUrl(String newMailserverUrl) {
		String oldMailserverUrl = mailserverUrl;
		mailserverUrl = newMailserverUrl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.CONFIGURATION__MAILSERVER_URL, oldMailserverUrl, mailserverUrl));
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMailserverUser() {
		return mailserverUser;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMailserverUser(String newMailserverUser) {
		String oldMailserverUser = mailserverUser;
		mailserverUser = newMailserverUser;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.CONFIGURATION__MAILSERVER_USER, oldMailserverUser, mailserverUser));
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMailserverPassword() {
		return mailserverPassword;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMailserverPassword(String newMailserverPassword) {
		String oldMailserverPassword = mailserverPassword;
		mailserverPassword = newMailserverPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.CONFIGURATION__MAILSERVER_PASSWORD, oldMailserverPassword, mailserverPassword));
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMailsubjectSendSongbook() {
		return mailsubjectSendSongbook;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMailsubjectSendSongbook(String newMailsubjectSendSongbook) {
		String oldMailsubjectSendSongbook = mailsubjectSendSongbook;
		mailsubjectSendSongbook = newMailsubjectSendSongbook;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.CONFIGURATION__MAILSUBJECT_SEND_SONGBOOK, oldMailsubjectSendSongbook, mailsubjectSendSongbook));
	}

				/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MidiplayerPackage.CONFIGURATION__SCREEN_ID_PRESENTATION:
				return getScreenIDPresentation();
			case MidiplayerPackage.CONFIGURATION__SCREEN_ID_ADMIN:
				return getScreenIDAdmin();
			case MidiplayerPackage.CONFIGURATION__LAST_SESSION:
				if (resolve) return getLastSession();
				return basicGetLastSession();
			case MidiplayerPackage.CONFIGURATION__PDF_EXPORT_PATH:
				return getPdfExportPath();
			case MidiplayerPackage.CONFIGURATION__ADDITIONALS_PATH:
				return getAdditionalsPath();
			case MidiplayerPackage.CONFIGURATION__FONTSIZE:
				return getFontsize();
			case MidiplayerPackage.CONFIGURATION__MAILTEXT_SEND_SONGBOOK:
				return getMailtextSendSongbook();
			case MidiplayerPackage.CONFIGURATION__MAILSERVER_URL:
				return getMailserverUrl();
			case MidiplayerPackage.CONFIGURATION__MAILSERVER_USER:
				return getMailserverUser();
			case MidiplayerPackage.CONFIGURATION__MAILSERVER_PASSWORD:
				return getMailserverPassword();
			case MidiplayerPackage.CONFIGURATION__MAILSUBJECT_SEND_SONGBOOK:
				return getMailsubjectSendSongbook();
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
			case MidiplayerPackage.CONFIGURATION__SCREEN_ID_PRESENTATION:
				setScreenIDPresentation((String)newValue);
				return;
			case MidiplayerPackage.CONFIGURATION__SCREEN_ID_ADMIN:
				setScreenIDAdmin((String)newValue);
				return;
			case MidiplayerPackage.CONFIGURATION__LAST_SESSION:
				setLastSession((Session)newValue);
				return;
			case MidiplayerPackage.CONFIGURATION__PDF_EXPORT_PATH:
				setPdfExportPath((String)newValue);
				return;
			case MidiplayerPackage.CONFIGURATION__ADDITIONALS_PATH:
				setAdditionalsPath((String)newValue);
				return;
			case MidiplayerPackage.CONFIGURATION__FONTSIZE:
				setFontsize((Integer)newValue);
				return;
			case MidiplayerPackage.CONFIGURATION__MAILTEXT_SEND_SONGBOOK:
				setMailtextSendSongbook((String)newValue);
				return;
			case MidiplayerPackage.CONFIGURATION__MAILSERVER_URL:
				setMailserverUrl((String)newValue);
				return;
			case MidiplayerPackage.CONFIGURATION__MAILSERVER_USER:
				setMailserverUser((String)newValue);
				return;
			case MidiplayerPackage.CONFIGURATION__MAILSERVER_PASSWORD:
				setMailserverPassword((String)newValue);
				return;
			case MidiplayerPackage.CONFIGURATION__MAILSUBJECT_SEND_SONGBOOK:
				setMailsubjectSendSongbook((String)newValue);
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
			case MidiplayerPackage.CONFIGURATION__SCREEN_ID_PRESENTATION:
				setScreenIDPresentation(SCREEN_ID_PRESENTATION_EDEFAULT);
				return;
			case MidiplayerPackage.CONFIGURATION__SCREEN_ID_ADMIN:
				setScreenIDAdmin(SCREEN_ID_ADMIN_EDEFAULT);
				return;
			case MidiplayerPackage.CONFIGURATION__LAST_SESSION:
				setLastSession((Session)null);
				return;
			case MidiplayerPackage.CONFIGURATION__PDF_EXPORT_PATH:
				setPdfExportPath(PDF_EXPORT_PATH_EDEFAULT);
				return;
			case MidiplayerPackage.CONFIGURATION__ADDITIONALS_PATH:
				setAdditionalsPath(ADDITIONALS_PATH_EDEFAULT);
				return;
			case MidiplayerPackage.CONFIGURATION__FONTSIZE:
				setFontsize(FONTSIZE_EDEFAULT);
				return;
			case MidiplayerPackage.CONFIGURATION__MAILTEXT_SEND_SONGBOOK:
				setMailtextSendSongbook(MAILTEXT_SEND_SONGBOOK_EDEFAULT);
				return;
			case MidiplayerPackage.CONFIGURATION__MAILSERVER_URL:
				setMailserverUrl(MAILSERVER_URL_EDEFAULT);
				return;
			case MidiplayerPackage.CONFIGURATION__MAILSERVER_USER:
				setMailserverUser(MAILSERVER_USER_EDEFAULT);
				return;
			case MidiplayerPackage.CONFIGURATION__MAILSERVER_PASSWORD:
				setMailserverPassword(MAILSERVER_PASSWORD_EDEFAULT);
				return;
			case MidiplayerPackage.CONFIGURATION__MAILSUBJECT_SEND_SONGBOOK:
				setMailsubjectSendSongbook(MAILSUBJECT_SEND_SONGBOOK_EDEFAULT);
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
			case MidiplayerPackage.CONFIGURATION__SCREEN_ID_PRESENTATION:
				return SCREEN_ID_PRESENTATION_EDEFAULT == null ? screenIDPresentation != null : !SCREEN_ID_PRESENTATION_EDEFAULT.equals(screenIDPresentation);
			case MidiplayerPackage.CONFIGURATION__SCREEN_ID_ADMIN:
				return SCREEN_ID_ADMIN_EDEFAULT == null ? screenIDAdmin != null : !SCREEN_ID_ADMIN_EDEFAULT.equals(screenIDAdmin);
			case MidiplayerPackage.CONFIGURATION__LAST_SESSION:
				return lastSession != null;
			case MidiplayerPackage.CONFIGURATION__PDF_EXPORT_PATH:
				return PDF_EXPORT_PATH_EDEFAULT == null ? pdfExportPath != null : !PDF_EXPORT_PATH_EDEFAULT.equals(pdfExportPath);
			case MidiplayerPackage.CONFIGURATION__ADDITIONALS_PATH:
				return ADDITIONALS_PATH_EDEFAULT == null ? additionalsPath != null : !ADDITIONALS_PATH_EDEFAULT.equals(additionalsPath);
			case MidiplayerPackage.CONFIGURATION__FONTSIZE:
				return FONTSIZE_EDEFAULT == null ? fontsize != null : !FONTSIZE_EDEFAULT.equals(fontsize);
			case MidiplayerPackage.CONFIGURATION__MAILTEXT_SEND_SONGBOOK:
				return MAILTEXT_SEND_SONGBOOK_EDEFAULT == null ? mailtextSendSongbook != null : !MAILTEXT_SEND_SONGBOOK_EDEFAULT.equals(mailtextSendSongbook);
			case MidiplayerPackage.CONFIGURATION__MAILSERVER_URL:
				return MAILSERVER_URL_EDEFAULT == null ? mailserverUrl != null : !MAILSERVER_URL_EDEFAULT.equals(mailserverUrl);
			case MidiplayerPackage.CONFIGURATION__MAILSERVER_USER:
				return MAILSERVER_USER_EDEFAULT == null ? mailserverUser != null : !MAILSERVER_USER_EDEFAULT.equals(mailserverUser);
			case MidiplayerPackage.CONFIGURATION__MAILSERVER_PASSWORD:
				return MAILSERVER_PASSWORD_EDEFAULT == null ? mailserverPassword != null : !MAILSERVER_PASSWORD_EDEFAULT.equals(mailserverPassword);
			case MidiplayerPackage.CONFIGURATION__MAILSUBJECT_SEND_SONGBOOK:
				return MAILSUBJECT_SEND_SONGBOOK_EDEFAULT == null ? mailsubjectSendSongbook != null : !MAILSUBJECT_SEND_SONGBOOK_EDEFAULT.equals(mailsubjectSendSongbook);
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
		result.append(" (screenIDPresentation: ");
		result.append(screenIDPresentation);
		result.append(", screenIDAdmin: ");
		result.append(screenIDAdmin);
		result.append(", pdfExportPath: ");
		result.append(pdfExportPath);
		result.append(", additionalsPath: ");
		result.append(additionalsPath);
		result.append(", fontsize: ");
		result.append(fontsize);
		result.append(", mailtextSendSongbook: ");
		result.append(mailtextSendSongbook);
		result.append(", mailserverUrl: ");
		result.append(mailserverUrl);
		result.append(", mailserverUser: ");
		result.append(mailserverUser);
		result.append(", mailserverPassword: ");
		result.append(mailserverPassword);
		result.append(", mailsubjectSendSongbook: ");
		result.append(mailsubjectSendSongbook);
		result.append(')');
		return result.toString();
	}

} //ConfigurationImpl
