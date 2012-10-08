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
 * A representation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link mda.Configuration#getScreenIDPresentation <em>Screen ID Presentation</em>}</li>
 *   <li>{@link mda.Configuration#getScreenIDAdmin <em>Screen ID Admin</em>}</li>
 *   <li>{@link mda.Configuration#getLastSession <em>Last Session</em>}</li>
 *   <li>{@link mda.Configuration#getPdfExportPath <em>Pdf Export Path</em>}</li>
 *   <li>{@link mda.Configuration#getAdditionalsPath <em>Additionals Path</em>}</li>
 *   <li>{@link mda.Configuration#getFontsize <em>Fontsize</em>}</li>
 *   <li>{@link mda.Configuration#getMailtextSendSongbook <em>Mailtext Send Songbook</em>}</li>
 *   <li>{@link mda.Configuration#getMailserverUrl <em>Mailserver Url</em>}</li>
 *   <li>{@link mda.Configuration#getMailserverUser <em>Mailserver User</em>}</li>
 *   <li>{@link mda.Configuration#getMailserverPassword <em>Mailserver Password</em>}</li>
 *   <li>{@link mda.Configuration#getMailsubjectSendSongbook <em>Mailsubject Send Songbook</em>}</li>
 * </ul>
 * </p>
 *
 * @see mda.MidiplayerPackage#getConfiguration()
 * @model
 * @generated
 */
public interface Configuration extends EObject {
  /**
	 * Returns the value of the '<em><b>Screen ID Presentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Screen ID Presentation</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Screen ID Presentation</em>' attribute.
	 * @see #setScreenIDPresentation(String)
	 * @see mda.MidiplayerPackage#getConfiguration_ScreenIDPresentation()
	 * @model
	 * @generated
	 */
  String getScreenIDPresentation();

  /**
	 * Sets the value of the '{@link mda.Configuration#getScreenIDPresentation <em>Screen ID Presentation</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Screen ID Presentation</em>' attribute.
	 * @see #getScreenIDPresentation()
	 * @generated
	 */
  void setScreenIDPresentation(String value);

  /**
	 * Returns the value of the '<em><b>Screen ID Admin</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Screen ID Admin</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Screen ID Admin</em>' attribute.
	 * @see #setScreenIDAdmin(String)
	 * @see mda.MidiplayerPackage#getConfiguration_ScreenIDAdmin()
	 * @model
	 * @generated
	 */
  String getScreenIDAdmin();

  /**
	 * Sets the value of the '{@link mda.Configuration#getScreenIDAdmin <em>Screen ID Admin</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Screen ID Admin</em>' attribute.
	 * @see #getScreenIDAdmin()
	 * @generated
	 */
  void setScreenIDAdmin(String value);

  /**
	 * Returns the value of the '<em><b>Last Session</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Last Session</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Session</em>' reference.
	 * @see #setLastSession(Session)
	 * @see mda.MidiplayerPackage#getConfiguration_LastSession()
	 * @model
	 * @generated
	 */
  Session getLastSession();

  /**
	 * Sets the value of the '{@link mda.Configuration#getLastSession <em>Last Session</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Session</em>' reference.
	 * @see #getLastSession()
	 * @generated
	 */
  void setLastSession(Session value);

		/**
	 * Returns the value of the '<em><b>Pdf Export Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pdf Export Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pdf Export Path</em>' attribute.
	 * @see #setPdfExportPath(String)
	 * @see mda.MidiplayerPackage#getConfiguration_PdfExportPath()
	 * @model
	 * @generated
	 */
	String getPdfExportPath();

		/**
	 * Sets the value of the '{@link mda.Configuration#getPdfExportPath <em>Pdf Export Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pdf Export Path</em>' attribute.
	 * @see #getPdfExportPath()
	 * @generated
	 */
	void setPdfExportPath(String value);

    /**
	 * Returns the value of the '<em><b>Additionals Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Additionals Path</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Additionals Path</em>' attribute.
	 * @see #setAdditionalsPath(String)
	 * @see mda.MidiplayerPackage#getConfiguration_AdditionalsPath()
	 * @model
	 * @generated
	 */
  String getAdditionalsPath();

    /**
	 * Sets the value of the '{@link mda.Configuration#getAdditionalsPath <em>Additionals Path</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Additionals Path</em>' attribute.
	 * @see #getAdditionalsPath()
	 * @generated
	 */
  void setAdditionalsPath(String value);

    /**
	 * Returns the value of the '<em><b>Fontsize</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fontsize</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Fontsize</em>' attribute.
	 * @see #setFontsize(Integer)
	 * @see mda.MidiplayerPackage#getConfiguration_Fontsize()
	 * @model
	 * @generated
	 */
  Integer getFontsize();

    /**
	 * Sets the value of the '{@link mda.Configuration#getFontsize <em>Fontsize</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fontsize</em>' attribute.
	 * @see #getFontsize()
	 * @generated
	 */
  void setFontsize(Integer value);

				/**
	 * Returns the value of the '<em><b>Mailtext Send Songbook</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mailtext Send Songbook</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mailtext Send Songbook</em>' attribute.
	 * @see #setMailtextSendSongbook(String)
	 * @see mda.MidiplayerPackage#getConfiguration_MailtextSendSongbook()
	 * @model
	 * @generated
	 */
	String getMailtextSendSongbook();

				/**
	 * Sets the value of the '{@link mda.Configuration#getMailtextSendSongbook <em>Mailtext Send Songbook</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mailtext Send Songbook</em>' attribute.
	 * @see #getMailtextSendSongbook()
	 * @generated
	 */
	void setMailtextSendSongbook(String value);

				/**
	 * Returns the value of the '<em><b>Mailserver Url</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mailserver Url</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mailserver Url</em>' attribute.
	 * @see #setMailserverUrl(String)
	 * @see mda.MidiplayerPackage#getConfiguration_MailserverUrl()
	 * @model default=""
	 * @generated
	 */
	String getMailserverUrl();

				/**
	 * Sets the value of the '{@link mda.Configuration#getMailserverUrl <em>Mailserver Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mailserver Url</em>' attribute.
	 * @see #getMailserverUrl()
	 * @generated
	 */
	void setMailserverUrl(String value);

				/**
	 * Returns the value of the '<em><b>Mailserver User</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mailserver User</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mailserver User</em>' attribute.
	 * @see #setMailserverUser(String)
	 * @see mda.MidiplayerPackage#getConfiguration_MailserverUser()
	 * @model
	 * @generated
	 */
	String getMailserverUser();

				/**
	 * Sets the value of the '{@link mda.Configuration#getMailserverUser <em>Mailserver User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mailserver User</em>' attribute.
	 * @see #getMailserverUser()
	 * @generated
	 */
	void setMailserverUser(String value);

				/**
	 * Returns the value of the '<em><b>Mailserver Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mailserver Password</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mailserver Password</em>' attribute.
	 * @see #setMailserverPassword(String)
	 * @see mda.MidiplayerPackage#getConfiguration_MailserverPassword()
	 * @model
	 * @generated
	 */
	String getMailserverPassword();

				/**
	 * Sets the value of the '{@link mda.Configuration#getMailserverPassword <em>Mailserver Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mailserver Password</em>' attribute.
	 * @see #getMailserverPassword()
	 * @generated
	 */
	void setMailserverPassword(String value);

				/**
	 * Returns the value of the '<em><b>Mailsubject Send Songbook</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mailsubject Send Songbook</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mailsubject Send Songbook</em>' attribute.
	 * @see #setMailsubjectSendSongbook(String)
	 * @see mda.MidiplayerPackage#getConfiguration_MailsubjectSendSongbook()
	 * @model
	 * @generated
	 */
	String getMailsubjectSendSongbook();

				/**
	 * Sets the value of the '{@link mda.Configuration#getMailsubjectSendSongbook <em>Mailsubject Send Songbook</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mailsubject Send Songbook</em>' attribute.
	 * @see #getMailsubjectSendSongbook()
	 * @generated
	 */
	void setMailsubjectSendSongbook(String value);

} // Configuration
