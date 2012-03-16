package org.mda.google;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import mda.MidiPlayerRoot;
import mda.MidiplayerFactory;
import mda.User;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import com.google.gdata.client.contacts.ContactsService;
import com.google.gdata.client.http.AuthSubUtil;
import com.google.gdata.data.contacts.ContactEntry;
import com.google.gdata.data.contacts.ContactFeed;
import com.google.gdata.data.contacts.ContactGroupEntry;
import com.google.gdata.data.contacts.ContactGroupFeed;
import com.google.gdata.data.contacts.GroupMembershipInfo;
import com.google.gdata.util.ServiceException;

public class GoogleContactsConnector {

  private static final Log LOGGER  = LogFactory.getLogger(GoogleContactsConnector.class);

  public static ContactGroupEntry getGroup (ContactsService myService, final String name) throws Exception {

    URL feedUrl = new URL("https://www.google.com/m8/feeds/groups/markus.oley@gmail.com/full");
    ContactGroupFeed resultFeed = myService.getFeed(feedUrl, ContactGroupFeed.class);
    List<ContactGroupEntry> entries = resultFeed.getEntries();
    for (ContactGroupEntry nextEntry : entries) {
      System.out.println("Group: " +
        nextEntry.getTitle().getPlainText());
    }
    return null;
  }

  private User findByMailadress (final MidiPlayerRoot model, String name, String firstname) {
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

    String next = "http://www.example.com/welcome.html";
    String scope = "http://www.google.com/m8/feeds/";
    boolean secure = false;
    boolean session = true;
    AuthSubUtil.getRequestUrl(next, scope, secure, session);
    // Request the feed

    ContactsService myService = new ContactsService("exampleCo");
    myService.setUserCredentials("markus.oley@googlemail.com", "mo351977");

    URL feedUrl = new URL("https://www.google.com/m8/feeds/contacts/markus.oley@gmail.com/full?max-results=1000");
    ContactFeed resultFeed = myService.getFeed(feedUrl, ContactFeed.class);

    for (GoogleContactsDescriptor nextDesc : descs) {

      for (int i = 0; i < resultFeed.getEntries().size(); i++) {
        ContactEntry entry = resultFeed.getEntries().get(i);

        boolean groupFound = false;
        for (GroupMembershipInfo group : entry.getGroupMembershipInfos()) {
          String groupHref = group.getHref();
          ContactGroupEntry newentry = myService.getEntry(new URL(groupHref), ContactGroupEntry.class);

          if (nextDesc.usesGroup(newentry.getPlainTextContent())) {
            groupFound = true;
            break;
          }
        }
        if (!groupFound) {
          continue;
        }

        User existingUser = findByMailadress(model, getName(entry), getFirstName(entry));

        if (existingUser == null) {
          LOGGER.info("User " +  getName(entry) + "-" +  getFirstName(entry) + " was not found");
          existingUser = MidiplayerFactory.eINSTANCE.createUser();
          model.getUsers().add(existingUser);
        }
        else
          LOGGER.info("User " + getName(entry) + "-" +  getFirstName(entry) +  " already exists, overwrite basics");

        existingUser.setFirstname(getFirstName(entry));
        existingUser.setName(getName(entry));
        existingUser.setType(nextDesc.getUsertype());
        existingUser.setMail(getMailadress(entry));

        if (LOGGER.isInfoEnabled()) {
          LOGGER.info("First Name           : " + existingUser.getFirstname());
          LOGGER.info("Last  Name           : " + existingUser.getName());
          LOGGER.info("Type                 : " + existingUser.getType().getName());
          LOGGER.info("Mailadress           : " + existingUser.getMail());
        }

      }

    }
  }

}
