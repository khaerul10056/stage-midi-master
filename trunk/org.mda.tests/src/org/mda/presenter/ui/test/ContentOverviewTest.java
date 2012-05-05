package org.mda.presenter.ui.test;

import mda.MidiFile;
import mda.MidiFilePartType;
import mda.Session;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;
import org.junit.Assert;
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
  private ApplicationSession instance;

  @Before
  public void setup () {
    presentationContext = MdaPresenterModule.getInjector().getInstance(PresentationContext.class);
    instance = MdaModule.getInjector().getInstance(ApplicationSession.class);
  }

  @Test
  public void testContentOverview () throws Exception {
    instance.load(null);
    presentationContext.setCurrentSession(instance.getCurrentModel().getSessions().get(0), new DefaultMidiFileContentEditorConfig(), new Point (400, 200));
    ContentOverview overview = new ContentOverview();
    overview.createPartControl(new Shell());
    overview.toItem(presentationContext.getCurrentSession().getItems().get(0));
    Assert.assertTrue (overview.getPreviewParts().get(0).isSelected());

  }

  @Test
  public void testContentOverviewOfPartWithNewSlide () throws Exception {
    MidiFileCreator part = MidiFileCreator.create().part(MidiFilePartType.INTRO);
    part = part.line().chordAndText("D", "This is the first line").chordAndText("Ab", "");
    part = part.line().chordAndText("D", "Second line").chordAndText("Ab", "");
    part = part.line().chordAndText("D", "Third line").chordAndText("Ab", "");

    MidiFile song = part.get();

    Session session = MidiPlayerService.mf.createSession();
    session.getItems().add(song);
    song.getParts().get(0).getTextlines().get(2).setNewSlide(true);

    presentationContext.setCurrentSession(session, new DefaultMidiFileContentEditorConfig(), new Point (400, 200));

    ContentOverview overview = new ContentOverview();
    overview.createPartControl(new Shell());
    overview.toItem(song);

    overview.refresh();

    Assert.assertTrue (overview.getPreviewParts().get(0).isSelected());
    Assert.assertFalse (overview.getPreviewParts().get(1).isSelected());


  }



}
