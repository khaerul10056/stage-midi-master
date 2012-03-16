package org.mda.google;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import com.google.gdata.client.contacts.ContactsService;
import com.google.gdata.client.http.AuthSubUtil;
import com.google.gdata.data.contacts.ContactEntry;
import com.google.gdata.data.contacts.ContactFeed;
import com.google.gdata.data.contacts.ContactGroupEntry;
import com.google.gdata.data.contacts.ContactGroupFeed;
import com.google.gdata.data.contacts.GroupMembershipInfo;
import com.google.gdata.data.extensions.Email;
import com.google.gdata.data.extensions.ExtendedProperty;
import com.google.gdata.util.ServiceException;


public class GoogleContactsConnector {

  public static ContactGroupEntry getGroup (ContactsService myService, final String name) throws Exception {


    URL feedUrl = new URL("https://www.google.com/m8/feeds/groups/markus.oley@gmail.com/full");
    ContactGroupFeed resultFeed = myService.getFeed(feedUrl, ContactGroupFeed.class);
    List<ContactGroupEntry> entries = resultFeed.getEntries();
    for (ContactGroupEntry nextEntry : entries) {
      System.out.println ("Group: " + nextEntry.getTitle().getPlainText());
    }
    return null;
  }

  public static void printAllContacts(ContactsService myService, String groupname)
      throws ServiceException, IOException {

    // Request the feed
    URL feedUrl = new URL("https://www.google.com/m8/feeds/contacts/markus.oley@gmail.com/full?max-results=1000");
    ContactFeed resultFeed = myService.getFeed(feedUrl, ContactFeed.class);

    for (int i = 0; i < resultFeed.getEntries().size(); i++) {
      ContactEntry entry = resultFeed.getEntries().get(i);

      boolean groupFound = false;
      for (GroupMembershipInfo group : entry.getGroupMembershipInfos()) {
        String groupHref = group.getHref();
        ContactGroupEntry newentry = myService.getEntry(new URL (groupHref), ContactGroupEntry.class);

        if (newentry.getPlainTextContent().equals(groupname)) {
          groupFound = true;
          break;
        }
      }
      if (! groupFound) {
        continue;
      }


      System.out.println("Name            : " + entry.getTitle().getPlainText());


      System.out.println("Email addresses:");
      for (Email email : entry.getEmailAddresses()) {
        System.out.print(" " + email.getAddress());
        if (email.getRel() != null) {
          System.out.print(" rel:" + email.getRel());
        }
        if (email.getLabel() != null) {
          System.out.print(" label:" + email.getLabel());
        }
        if (email.getPrimary()) {
          System.out.print(" (primary) ");
        }
        System.out.print("\n");
      }

      System.out.println("Extended Properties:");
      for (ExtendedProperty property : entry.getExtendedProperties()) {
        if (property.getValue() != null) {
          System.out.println("  " + property.getName() + "(value) = " +
              property.getValue());
        } else if (property.getXmlBlob() != null) {
          System.out.println("  " + property.getName() + "(xmlBlob)= " +
              property.getXmlBlob().getBlob());
        }
      }





    }
  }


  public final static void main (String [] args) throws Exception {

    String next = "http://www.example.com/welcome.html";
    String scope = "http://www.google.com/m8/feeds/";
    boolean secure = false;
    boolean session = true;
    AuthSubUtil.getRequestUrl(next, scope, secure, session);


    ContactsService myService = new ContactsService("exampleCo");
    myService.setUserCredentials("markus.oley@googlemail.com", "mo351977");
    //ContactGroupEntry group = getGroup(myService, "Sound of faith");

//    List<Person> contributors = group.getContributors();
//    for (Person person: contributors) {
//      System.out.println(person.getName());
//
//    }
    printAllContacts(myService, "Sound of faith");



  }
}
