package org.mda.navigator.ui;

import mda.AbstractSessionItem;
import mda.Session;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mda.ApplicationSession;
import org.mda.MdaModule;
import org.mda.commons.ui.navigator.NavigatorItem;


public class ContentNavigatorTest {

  private static ApplicationSession appSession;

  @Test
  public void partControl () throws Exception {



    ContentNavigator navigator = new ContentNavigator();
    navigator.createPartControl(new Shell());




  }

  @BeforeClass
  public static void beforeClass () {
    appSession = MdaModule.getInjector().getInstance(ApplicationSession.class);
    appSession.load(null);
  }

  @Test
  public void moveUp () throws Exception {
    Session session = appSession.getCurrentModel().getSessions().get(0);
    AbstractSessionItem abstractSessionItem = session.getItems().get(3);

    NavigatorItem<AbstractSessionItem> item = new NavigatorItem<AbstractSessionItem>(abstractSessionItem, session.getItems(), session);

    ContentNavigator navigator = new ContentNavigator();
    navigator.createPartControl(new Shell());
    navigator.getTreeViewer().setSelection(new StructuredSelection(item));
    navigator.moveUp();
    Assert.assertEquals(abstractSessionItem, appSession.getCurrentModel().getSessions().get(0).getItems().get(2));


  }

  @Test
  public void moveDown () throws Exception {
    Session session = appSession.getCurrentModel().getSessions().get(0);
    AbstractSessionItem abstractSessionItem = session.getItems().get(3);

    NavigatorItem<AbstractSessionItem> item = new NavigatorItem<AbstractSessionItem>(abstractSessionItem, session.getItems(), session);

    ContentNavigator navigator = new ContentNavigator();
    navigator.createPartControl(new Shell());
    navigator.getTreeViewer().setSelection(new StructuredSelection(item));
    navigator.moveDown();
    Assert.assertEquals(abstractSessionItem, appSession.getCurrentModel().getSessions().get(0).getItems().get(4));
  }


}
