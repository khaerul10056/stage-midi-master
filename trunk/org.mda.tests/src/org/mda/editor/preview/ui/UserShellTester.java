package org.mda.editor.preview.ui;

import mda.MidiPlayerRoot;
import mda.MidiplayerFactory;
import mda.User;
import mda.UserType;
import org.eclipse.swt.widgets.Shell;
import org.mda.ApplicationSession;
import org.mda.commons.ui.user.UserShell;


public class UserShellTester {
  /** @param args */
  public static void main (String[] args) throws Exception {
    ApplicationSession session = new ApplicationSession();
    session.load(null);
    MidiPlayerRoot model = session.getCurrentModel();

    if (model.getUsers().size() == 0) {
      model.getUsers().add (UserShellTester.createUser("Name1", "Vorname1", UserType.FRIEND, "vorname1.name1@provider.de"));
      model.getUsers().add (UserShellTester.createUser("Name2", "Vorname2", UserType.MEMBER, "vorname2.name2@provider.de"));
      model.getUsers().add (UserShellTester.createUser("Name3", "Vorname3", UserType.MEMBER, "vorname3.name3@provider.de"));
    }



    Shell shell = new Shell();
    UserShell additionalshell = new UserShell(shell, session);

    while (!additionalshell.isDisposed()) {
      if (!shell.getDisplay().readAndDispatch()) {
        shell.getDisplay().sleep();
      }
    }

  }

  public static User createUser (final String name, final String firstname, final UserType type, final String mail) {
    User user = MidiplayerFactory.eINSTANCE.createUser();
    user.setName(name);
    user.setFirstname(firstname);
    user.setType(type);
    user.setMail(mail);
    return user;

  }


}
