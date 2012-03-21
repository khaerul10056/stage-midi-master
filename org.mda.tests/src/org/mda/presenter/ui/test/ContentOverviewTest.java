package org.mda.presenter.ui.test;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;
import org.junit.Before;
import org.junit.Test;
import org.mda.ApplicationSession;
import org.mda.MdaModule;
import org.mda.commons.ui.DefaultMidiFileContentEditorConfig;
import org.mda.presenter.ui.ContentOverview;
import org.mda.presenter.ui.MdaPresenterModule;
import org.mda.presenter.ui.PresentationContext;


public class ContentOverviewTest {

  private PresentationContext presentationContext;

  @Before
  public void setup () {
    presentationContext = MdaPresenterModule.getInjector().getInstance(PresentationContext.class);
    ApplicationSession instance = MdaModule.getInjector().getInstance(ApplicationSession.class);
    instance.load(null);
    presentationContext.setCurrentSession(instance.getCurrentModel().getSessions().get(0), new DefaultMidiFileContentEditorConfig(), new Point (400, 200));

  }

  @Test
  public void testContentOverview () throws Exception {
    ContentOverview overview = new ContentOverview();
    overview.createPartControl(new Shell());
    overview.toItem(presentationContext.getCurrentSession().getItems().get(0));
  }

}
