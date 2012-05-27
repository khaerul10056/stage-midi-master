package org.mda.google;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import mda.MidiPlayerRoot;
import mda.UserType;
import org.junit.Assert;
import org.junit.Test;
import org.mda.ApplicationSession;
import org.mda.MdaModule;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mockito.Mockito;
import com.google.gdata.client.GoogleService;
import com.google.gdata.data.contacts.ContactEntry;
import com.google.gdata.data.contacts.ContactFeed;
import com.google.gdata.data.contacts.ContactGroupEntry;
import com.google.gdata.data.contacts.GroupMembershipInfo;
import com.google.gdata.data.extensions.Email;
import com.google.gdata.data.extensions.FamilyName;
import com.google.gdata.data.extensions.GivenName;
import com.google.gdata.data.extensions.Name;


public class TestGoogleContacts {

  private static final Log LOGGER  = LogFactory.getLogger(TestGoogleContacts.class);


  private ContactEntry createContact (final String familyname, final String firstname, final String mail, final String href) {
    ContactEntry entry1 = mock(ContactEntry.class);
    Name name = new Name ();
    name.setGivenName(new GivenName(firstname, null));
    name.setFamilyName(new FamilyName(familyname, null));
    when (entry1.getName()).thenReturn(name);
    Email mailad = new Email();
    mailad.setAddress(mail);
    List <Email> mailads = new ArrayList<Email>();
    mailads.add(mailad);
    when (entry1.getEmailAddresses()).thenReturn(mailads);
    if (href != null) {
      GroupMembershipInfo info = new GroupMembershipInfo(false,href);
      List <GroupMembershipInfo> memberinfos = new ArrayList<GroupMembershipInfo>();
      memberinfos.add(info);
      when (entry1.getGroupMembershipInfos()).thenReturn(memberinfos);
    }
    return entry1;
  }

  @Test
  public void importUsers () throws Exception {

    final String NAME1 = "NAME1";
    final String NAME1_CHANGED = "NAME1";
    final String NAME2 = "NAME2";
    final String FIRSTNAME1 = "CALLNAME1";
    final String FIRSTNAME2 = "CALLNAME2";
    final String MAIL1 = "MAIL1";
    final String MAIL2 = "MAIL2";
    final String HREF1 = "http://HREF1";
    final String HREF2 = "http://HREF2";

    final String VALIDGROUP = "Sound of faith";

    ContactFeed contactFeed = mock(ContactFeed.class);
    ContactEntry entry1 = createContact(NAME1, FIRSTNAME1, MAIL1, HREF1);
    ContactEntry entry1Changed = createContact(NAME1_CHANGED, FIRSTNAME1, MAIL1, HREF1);

    ContactEntry entry2 = createContact(NAME2, FIRSTNAME2, MAIL2, HREF2);
    ContactEntry entry3 = createContact(NAME2, FIRSTNAME2, MAIL2, null);

    List<ContactEntry> list = new ArrayList<ContactEntry>();
    list.add(entry1);
    list.add(entry2);
    list.add(entry3);
    LOGGER.info("Entry1=" + System.identityHashCode(entry1));
    LOGGER.info("Entry2=" + System.identityHashCode(entry2));
    LOGGER.info("Entry3=" + System.identityHashCode(entry3));
    when (contactFeed.getEntries()).thenReturn(list);

    ContactGroupEntry invalidGroup = mock(ContactGroupEntry.class);
    LOGGER.info("InvalidGroup=" + System.identityHashCode(invalidGroup));
    when (invalidGroup.getPlainTextContent()).thenReturn("RATZL");

    ContactGroupEntry validGroup = mock(ContactGroupEntry.class);
    LOGGER.info("ValidGroup=" + System.identityHashCode(validGroup));
    when (validGroup.getPlainTextContent()).thenReturn(VALIDGROUP);

    GoogleService mockedService = Mockito.mock(GoogleService.class);
    when(mockedService.getFeed(new URL(GoogleContactsConnector.feedUrl), ContactFeed.class)).thenReturn(contactFeed);





    ApplicationSession session = MdaModule.getInjector().getInstance(ApplicationSession.class);
    session.load(null);
    MidiPlayerRoot currentModel = session.getCurrentModel();
    currentModel.getUsers().clear();

    GoogleContactsConnector connector = new GoogleContactsConnector();

    URL urlHref1 = connector.getUrl(HREF1);
    URL urlHref2 = connector.getUrl(HREF2);

    LOGGER.info("URL1 = " + System.identityHashCode(urlHref1));
    LOGGER.info("URL2 = " + System.identityHashCode(urlHref2));

    when (mockedService.getEntry(urlHref1, ContactGroupEntry.class)).thenReturn(validGroup);
    LOGGER.info("HRef " + HREF1 + " assigned to object " + System.identityHashCode(validGroup) + "-" + validGroup.getPlainTextContent());

    when (mockedService.getEntry(urlHref2, ContactGroupEntry.class)).thenReturn(invalidGroup);
    LOGGER.info("HRef " + HREF2 + " assigned to object " + System.identityHashCode(invalidGroup) + "-" + invalidGroup.getPlainTextContent());


    connector.setGoogleService(mockedService);
    GoogleContactsDescriptor desc = new GoogleContactsDescriptor(UserType.MEMBER);
    desc.addGroup(VALIDGROUP);

    List <GoogleContactsDescriptor> descriptors = new ArrayList<GoogleContactsDescriptor>();
    descriptors.add(desc);
    connector.importAllContacts(currentModel, descriptors);

    Assert.assertEquals (1, currentModel.getUsers().size());
    Assert.assertEquals (NAME1, currentModel.getUsers().get(0).getName());

    //second time, changed name
    list.set(0, entry1Changed);
    connector.importAllContacts(currentModel, descriptors);
    Assert.assertEquals(1, currentModel.getUsers().size());
    Assert.assertEquals (NAME1_CHANGED, currentModel.getUsers().get(0).getName());

  }

}