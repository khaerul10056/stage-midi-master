/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package mda.impl;

import java.util.Collection;

import mda.MidiFile;
import mda.MidiFilePart;
import mda.MidiplayerPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Midi File</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link mda.impl.MidiFileImpl#getParts <em>Parts</em>}</li>
 *   <li>{@link mda.impl.MidiFileImpl#getFontsize <em>Fontsize</em>}</li>
 *   <li>{@link mda.impl.MidiFileImpl#getPic <em>Pic</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MidiFileImpl extends AbstractSessionItemImpl implements MidiFile {
	/**
   * The cached value of the '{@link #getParts() <em>Parts</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParts()
   * @generated
   * @ordered
   */
  protected EList<MidiFilePart> parts;
  /**
   * The default value of the '{@link #getFontsize() <em>Fontsize</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFontsize()
   * @generated
   * @ordered
   */
  protected static final String FONTSIZE_EDEFAULT = null;
  /**
   * The cached value of the '{@link #getFontsize() <em>Fontsize</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFontsize()
   * @generated
   * @ordered
   */
  protected String fontsize = FONTSIZE_EDEFAULT;
  /**
   * The default value of the '{@link #getPic() <em>Pic</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPic()
   * @generated
   * @ordered
   */
  protected static final String PIC_EDEFAULT = null;
  /**
   * The cached value of the '{@link #getPic() <em>Pic</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPic()
   * @generated
   * @ordered
   */
  protected String pic = PIC_EDEFAULT;
  /**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected MidiFileImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return MidiplayerPackage.Literals.MIDI_FILE;
  }

	/**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MidiFilePart> getParts() {
    if (parts == null) {
      parts = new EObjectContainmentEList<MidiFilePart>(MidiFilePart.class, this, MidiplayerPackage.MIDI_FILE__PARTS);
    }
    return parts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getFontsize() {
    return fontsize;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFontsize(String newFontsize) {
    String oldFontsize = fontsize;
    fontsize = newFontsize;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.MIDI_FILE__FONTSIZE, oldFontsize, fontsize));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPic() {
    return pic;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPic(String newPic) {
    String oldPic = pic;
    pic = newPic;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MidiplayerPackage.MIDI_FILE__PIC, oldPic, pic));
  }

  /**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case MidiplayerPackage.MIDI_FILE__PARTS:
        return ((InternalEList<?>)getParts()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case MidiplayerPackage.MIDI_FILE__PARTS:
        return getParts();
      case MidiplayerPackage.MIDI_FILE__FONTSIZE:
        return getFontsize();
      case MidiplayerPackage.MIDI_FILE__PIC:
        return getPic();
    }
    return super.eGet(featureID, resolve, coreType);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case MidiplayerPackage.MIDI_FILE__PARTS:
        getParts().clear();
        getParts().addAll((Collection<? extends MidiFilePart>)newValue);
        return;
      case MidiplayerPackage.MIDI_FILE__FONTSIZE:
        setFontsize((String)newValue);
        return;
      case MidiplayerPackage.MIDI_FILE__PIC:
        setPic((String)newValue);
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
      case MidiplayerPackage.MIDI_FILE__PARTS:
        getParts().clear();
        return;
      case MidiplayerPackage.MIDI_FILE__FONTSIZE:
        setFontsize(FONTSIZE_EDEFAULT);
        return;
      case MidiplayerPackage.MIDI_FILE__PIC:
        setPic(PIC_EDEFAULT);
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
      case MidiplayerPackage.MIDI_FILE__PARTS:
        return parts != null && !parts.isEmpty();
      case MidiplayerPackage.MIDI_FILE__FONTSIZE:
        return FONTSIZE_EDEFAULT == null ? fontsize != null : !FONTSIZE_EDEFAULT.equals(fontsize);
      case MidiplayerPackage.MIDI_FILE__PIC:
        return PIC_EDEFAULT == null ? pic != null : !PIC_EDEFAULT.equals(pic);
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
    result.append(" (fontsize: ");
    result.append(fontsize);
    result.append(", pic: ");
    result.append(pic);
    result.append(')');
    return result.toString();
  }

} //MidiFileImpl