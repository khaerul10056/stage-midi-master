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
		result.append(')');
		return result.toString();
	}

} //ConfigurationImpl
