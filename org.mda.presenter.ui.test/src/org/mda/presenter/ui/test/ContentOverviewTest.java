package org.mda.presenter.ui.test;

import java.io.File;
import mda.MidiPlayerRoot;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;
import org.junit.Before;
import org.junit.Test;
import org.mda.ApplicationSession;
import org.mda.MdaModule;
import org.mda.MidiPlayerService;
import org.mda.commons.ui.DefaultMidiFileContentEditorConfig;
import org.mda.presenter.ui.ContentOverview;
import org.mda.presenter.ui.MdaPresenterModule;
import org.mda.presenter.ui.PresentationContext;


public class ContentOverviewTest {

  private PresentationContext presentationContext;

  @Before
  public void setup () {
    MidiPlayerRoot root = MidiPlayerService.loadRootObject(new File("../org.mda.core.test/testdata/testmodel.conf"));
    presentationContext = MdaPresenterModule.getInjector().getInstance(PresentationContext.class);
    MdaModule.getInjector().getInstance(ApplicationSession.class).load(null);
    presentationContext.setCurrentSession(root.getSessions().get(0), new DefaultMidiFileContentEditorConfig(), new Point (400, 200));

  }

  @Test
  public void testContentOverview () throws Exception {
    ContentOverview overview = new ContentOverview();
    overview.createPartControl(new Shell());
    overview.toItem(presentationContext.getCurrentSession().getItems().get(0));
  }

}
