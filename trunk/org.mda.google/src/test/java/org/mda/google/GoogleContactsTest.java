package org.mda.google;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import mda.MidiPlayerRoot;
import mda.UserType;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mda.ApplicationSession;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.test.ModelCreator;

import com.google.gdata.data.PlainTextConstruct;
import com.google.gdata.data.TextConstruct;
import com.google.gdata.data.contacts.ContactEntry;
import com.google.gdata.data.contacts.ContactGroupEntry;
import com.google.gdata.data.contacts.GroupMembershipInfo;
import com.google.gdata.data.extensions.Email;
import com.google.gdata.data.extensions.FamilyName;
import com.google.gdata.data.extensions.GivenName;
import com.google.gdata.data.extensions.Name;

public class GoogleContactsTest {
	
	private static final Log LOGGER  = LogFactory.getLogger(GoogleContactsTest.class);
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
	  private static ApplicationSession session;
	  private static MidiPlayerRoot currentModel;
	  private ArrayList<ContactEntry> list;


	  @Before
	  public void before () {
	    connector = new GoogleContactsConnector();
	  }

	  @BeforeClass
	  public static void beforeClass () {
	    currentModel = ModelCreator.create().get();
	  }



	  @Test
	  public void importUsersInvalidGroup () throws Exception {

	    currentModel.getUsers().clear();

	    GoogleServiceBridge mockedService = getMockedService("INVALIDGROUP");
	    connector.setBridge(mockedService);
	    GoogleContactsDescriptor desc = new GoogleContactsDescriptor(UserType.MEMBER, "VALIDGROUP");

	    List<GoogleContactsDescriptor> descriptors = new ArrayList<GoogleContactsDescriptor>();
	    descriptors.add(desc);
	    connector.importAllContacts(currentModel, descriptors);

	    Assert.assertEquals(0, currentModel.getUsers().size());
	  }

	  @Test
	  public void importUsersValidGroup () throws Exception {
	    final String VALIDGROUP = "VALIDGROUP";
	    currentModel.getUsers().clear();

	    GoogleServiceBridge mockedService = getMockedService(VALIDGROUP);
	    connector.setBridge(mockedService);
	    GoogleContactsDescriptor desc = new GoogleContactsDescriptor(UserType.MEMBER, "VALIDGROUP");

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

	  public GoogleServiceBridge getMockedService (final String groupassignment) throws Exception {

	    GoogleServiceBridge bridge = mock(GoogleServiceBridge.class);

	    ContactGroupEntry validGroup = createGroup(groupassignment);
	    when (bridge.findGroup(groupassignment)).thenReturn(validGroup);

	    ContactEntry entry1 = createContact(NAME1, FIRSTNAME1, MAIL1, HREF1);
	    entry1Changed = createContact(NAME1_CHANGED, FIRSTNAME1, MAIL1, HREF1);

	    ContactEntry entry2 = createContact(NAME2, FIRSTNAME2, MAIL2, HREF2);
	    ContactEntry entry3 = createContact(NAME2, FIRSTNAME2, MAIL2, null);

	    list = new ArrayList<ContactEntry>();
	    list.add(entry1);
	    list.add(entry2);
	    list.add(entry3);

	    when (bridge.findContacts(validGroup)).thenReturn(list);
	    return bridge;
	  }

	  private ContactGroupEntry createGroup (final String name) {
	    ContactGroupEntry entry = mock(ContactGroupEntry.class);
	    TextConstruct construct = new PlainTextConstruct(name);
	    entry.setTitle(construct);
	    return entry;
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
