package org.mda.google;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import mda.MidiPlayerRoot;
import mda.UserType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mda.ApplicationSession;
import org.mda.MdaModule;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mockito.Mockito;
import com.google.gdata.client.GoogleService;
import com.google.gdata.client.Query;
import com.google.gdata.client.maps.FeatureQuery;
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
  private GoogleContactsConnector connector;

  private final String NAME1 = "NAME1";
  private final String NAME1_CHANGED = "NAME1";
  private final String NAME2 = "NAME2";
  private final String FIRSTNAME1 = "CALLNAME1";
  private final String FIRSTNAME2 = "CALLNAME2";
  private final String MAIL1 = "MAIL1";
  private final String MAIL2 = "MAIL2";
  private final String HREF1 = "http://HREF1";
  private final String HREF2 = "http://HREF2";
  private ContactEntry entry1Changed;
  private List<ContactEntry> list;
  private static ApplicationSession session;
  private static MidiPlayerRoot currentModel;


  @Before
  public void before () {
    connector = new GoogleContactsConnector();
  }

  @BeforeClass
  public static void beforeClass () {
    session = MdaModule.getInjector().getInstance(ApplicationSession.class);
    session.load(null);
    currentModel = session.getCurrentModel();
  }



  @Test
  public void importUsersInvalidGroup () throws Exception {

    currentModel.getUsers().clear();

    GoogleService mockedService = getMockedService("INVALIDGROUP");
    connector.setGoogleService(mockedService);
    GoogleContactsDescriptor desc = new GoogleContactsDescriptor(UserType.MEMBER);
    desc.addGroup("VALIDGROUP");

    List<GoogleContactsDescriptor> descriptors = new ArrayList<GoogleContactsDescriptor>();
    descriptors.add(desc);
    connector.importAllContacts(currentModel, descriptors);

    Assert.assertEquals(0, currentModel.getUsers().size());
  }

  @Test
  public void importUsersValidGroup () throws Exception {
    final String VALIDGROUP = "VALIDGROUP";
    currentModel.getUsers().clear();

    GoogleService mockedService = getMockedService(VALIDGROUP);
    connector.setGoogleService(mockedService);
    GoogleContactsDescriptor desc = new GoogleContactsDescriptor(UserType.MEMBER);
    desc.addGroup("VALIDGROUP");

    List <GoogleContactsDescriptor> descriptors = new ArrayList<GoogleContactsDescriptor>();
    descriptors.add(desc);
    connector.importAllContacts(currentModel, descriptors);

    Assert.assertEquals (2, currentModel.getUsers().size());
    Assert.assertEquals (NAME1, currentModel.getUsers().get(0).getName());

    //second time, changed name
    list.set(0, entry1Changed);
    connector.importAllContacts(currentModel, descriptors);
    Assert.assertEquals(2, currentModel.getUsers().size());
    Assert.assertEquals (NAME1_CHANGED, currentModel.getUsers().get(0).getName());

  }

  public GoogleService getMockedService (final String groupassignment) throws Exception {

    ContactFeed contactFeed = mock(ContactFeed.class);
    ContactEntry entry1 = createContact(NAME1, FIRSTNAME1, MAIL1, HREF1);
    entry1Changed = createContact(NAME1_CHANGED, FIRSTNAME1, MAIL1, HREF1);

    ContactEntry entry2 = createContact(NAME2, FIRSTNAME2, MAIL2, HREF2);
    ContactEntry entry3 = createContact(NAME2, FIRSTNAME2, MAIL2, null);

    list = new ArrayList<ContactEntry>();
    list.add(entry1);
    list.add(entry2);
    list.add(entry3);
    LOGGER.info("Entry1=" + System.identityHashCode(entry1));
    LOGGER.info("Entry2=" + System.identityHashCode(entry2));
    LOGGER.info("Entry3=" + System.identityHashCode(entry3));
    when (contactFeed.getEntries()).thenReturn(list);

    ContactGroupEntry group = mock(ContactGroupEntry.class);
    LOGGER.info("InvalidGroup=" + System.identityHashCode(group));
    when (group.getPlainTextContent()).thenReturn(groupassignment);
    LOGGER.info("InvalidGroup return " + group.getPlainTextContent());

    GoogleService mockedService = mock(GoogleService.class);
    Query query = new FeatureQuery(GoogleContactsConnector.feedUrl);
    when(mockedService.getFeed(query, ContactFeed.class)).thenReturn(contactFeed);

    URL urlHref1 = connector.getUrl(HREF1);
    URL urlHref2 = connector.getUrl(HREF2);

    LOGGER.info("URL1 = " + System.identityHashCode(urlHref1) + "-" + urlHref1);
    LOGGER.info("URL2 = " + System.identityHashCode(urlHref2) + "-" + urlHref2);

    when (mockedService.getEntry((URL)Mockito.any(), (Class)Mockito.any())).thenReturn(group);

    return mockedService;
  }

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

}
