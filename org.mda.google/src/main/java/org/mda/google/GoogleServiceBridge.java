package org.mda.google;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import com.google.gdata.client.GoogleService;
import com.google.gdata.client.contacts.ContactsService;
import com.google.gdata.client.http.AuthSubUtil;
import com.google.gdata.data.contacts.ContactEntry;
import com.google.gdata.data.contacts.ContactFeed;
import com.google.gdata.data.contacts.ContactGroupEntry;
import com.google.gdata.data.contacts.ContactGroupFeed;
import com.google.gdata.util.ServiceException;


public class GoogleServiceBridge {

  private GoogleService service;

  private static final Log LOGGER  = LogFactory.getLogger(GoogleServiceBridge.class);

  public final static String contactsUrl;
  public final static String groupsUrl;


  static {
      contactsUrl = "https://www.google.com/m8/feeds/contacts/markus.oley@gmail.com/full?max-results=1000";
      groupsUrl = "https://www.google.com/m8/feeds/groups/markus.oley@gmail.com/full";
  }


  public GoogleService getGoogleService () throws ServiceException, IOException{
    if (service == null) {
      String next = "http://www.example.com/welcome.html";
      String scope = "http://www.google.com/m8/feeds/";
      boolean secure = false;
      boolean session = true;
      AuthSubUtil.getRequestUrl(next, scope, secure, session);
      // Request the feed

      ContactsService myService = new ContactsService("exampleCo");
      myService.setUserCredentials("markus.oley@googlemail.com", "Momopomo351977");
      service = myService;
    }

    return service;
  }

  public ContactGroupEntry findGroup (final String name) throws ServiceException, IOException {
    ContactGroupFeed resultFeed = getGoogleService().getFeed(new URL (groupsUrl), ContactGroupFeed.class);
    List<ContactGroupEntry> entries = resultFeed.getEntries();
    for (ContactGroupEntry nextEntry : entries) {
      if (name.equals(nextEntry.getTitle().getPlainText())) {
          LOGGER.info("Found Group: " + nextEntry.getTitle().getPlainText());
          return nextEntry;
      }
      else
        LOGGER.info("Group " + nextEntry.getTitle().getPlainText() + " not matching " + name);
    }
    return null;
  }

  public List <ContactEntry> findContacts (final ContactGroupEntry group) throws ServiceException, IOException {
    URL feedURL = new URL (contactsUrl + group.getId());
    ContactFeed resultFeed = getGoogleService().getFeed(feedURL, ContactFeed.class);
    return resultFeed.getEntries();

  }

}
