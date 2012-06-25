package org.mda.google;

import java.io.IOException;
import java.util.List;
import mda.MidiPlayerRoot;
import mda.MidiplayerFactory;
import mda.User;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import com.google.gdata.data.contacts.ContactEntry;
import com.google.gdata.data.contacts.ContactGroupEntry;
import com.google.gdata.util.ServiceException;

public class GoogleContactsConnector {

  private static final Log LOGGER  = LogFactory.getLogger(GoogleContactsConnector.class);

  private GoogleServiceBridge bridge = new GoogleServiceBridge();

  private User findByNames (final MidiPlayerRoot model, String name, String firstname) {
    for (User next : model.getUsers()) {
      if (next.getName().equals(name) &&
        next.getFirstname().equals(firstname))
        return next;
    }

    return null;
  }

  public String getMailadress (final ContactEntry entry) {
    if (entry.getEmailAddresses() == null || entry.getEmailAddresses().size() == 0 || entry.getEmailAddresses().get(0) == null)
      return "";
    else
      return entry.getEmailAddresses().get(0).getAddress();
  }
  public String getName (final ContactEntry entry) {
    if (entry.getName() == null || entry.getName().getFamilyName() == null)
      return "";
    return entry.getName().getFamilyName().getValue();
  }

  public String getFirstName (final ContactEntry entry) {
    if (entry.getName() == null || entry.getName().getGivenName() == null)
      return "";
    return entry.getName().getGivenName().getValue();
  }


  public void importAllContacts (MidiPlayerRoot model, List<GoogleContactsDescriptor> descs) throws ServiceException, IOException {


    for (GoogleContactsDescriptor nextDesc : descs) {
      LOGGER.info("Analyse googlecontactsdescriptor " + nextDesc);

      ContactGroupEntry membersGroup = getBridge().findGroup(nextDesc.getGroup());
      List <ContactEntry> contacts = getBridge().findContacts(membersGroup);

      for (ContactEntry entry: contacts) {
        User existingUser = findByNames(model, getName(entry), getFirstName(entry));

        if (existingUser == null) {
          LOGGER.info("  User " +  getName(entry) + "-" +  getFirstName(entry) + " was not found");
          existingUser = MidiplayerFactory.eINSTANCE.createUser();
          model.getUsers().add(existingUser);
        }
        else
          LOGGER.info("  User " + getName(entry) + "-" +  getFirstName(entry) +  " already exists, overwrite basics");

        existingUser.setFirstname(getFirstName(entry));
        existingUser.setName(getName(entry));
        existingUser.setType(nextDesc.getUsertype());
        existingUser.setMail(getMailadress(entry));

        if (LOGGER.isInfoEnabled()) {
          LOGGER.info("  First Name           : " + existingUser.getFirstname());
          LOGGER.info("  Last  Name           : " + existingUser.getName());
          LOGGER.info("  Type                 : " + existingUser.getType().getName());
          LOGGER.info("  Mailadress           : " + existingUser.getMail());
        }

      }

    }
  }

  public GoogleServiceBridge getBridge () {
    return bridge;
  }

  public void setBridge (GoogleServiceBridge bridge) {
    this.bridge = bridge;
  }

}
