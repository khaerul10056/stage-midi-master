package org.mda.presenter.ui.test;

import mda.MidiFile;
import mda.MidiFilePartType;
import mda.Session;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.mda.ApplicationSession;
import org.mda.MidiPlayerService;
import org.mda.commons.ui.DefaultMidiFileContentEditorConfig;
import org.mda.presenter.ui.ContentOverview;
import org.mda.presenter.ui.PresentationContext;
import org.mda.tests.StandaloneInjector;


public class ContentOverviewTest {

  private PresentationContext presentationContext = StandaloneInjector.getInstance(PresentationContext.class);
  private ApplicationSession instance = StandaloneInjector.getInstance(ApplicationSession.class);
  private ContentOverview overview = StandaloneInjector.getInstance(ContentOverview.class);

  @After
  public void tearDown () {
    presentationContext.clear();
  }

  @Test
  public void testContentOverview () throws Exception {
    instance.load(null);
    presentationContext.setCurrentSession(instance.getCurrentModel().getSessions().get(0), new DefaultMidiFileContentEditorConfig(), new Point (400, 200));
    overview.build(new Shell());
    overview.refresh();
    Assert.assertTrue (overview.getPreviewParts().get(0).isSelected());

  }
  
  private ContentOverview getContentOverview () {
	  return StandaloneInjector.getInstance(ContentOverview.class);
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

    ContentOverview overview = getContentOverview();
    overview.build(new Shell());
    overview.refresh();

    Assert.assertTrue (overview.getPreviewParts().get(0).isSelected());
    Assert.assertFalse (overview.getPreviewParts().get(1).isSelected());


  }

  /**
   * Tests following szenario:
   * SONG1
   *   PART1
   *   PART2 with new slide
   *   PART1REF
   *   PART1REF
   * SONG2
   *   PART1
   *
   * If stepping back from song2 to song1 last ref should be the selected one
   */
  @Test
  public void navigateContentOverviewWithNewSlides () {
    MidiFileCreator part = MidiFileCreator.create().part(MidiFilePartType.VERS).line().text("First line").line().text("Second line");
    part = part.part(MidiFilePartType.REFRAIN).line().text("First line").line().text("Second line");
    MidiFile song1 = part.get();
    song1.getParts().get(0).getTextlines().get(1).setNewSlide(true);
    song1.getParts().get(1).getTextlines().get(1).setNewSlide(true);

    //System.out.println(MidiPlayerService.toString(song1));

    part = MidiFileCreator.create().part(MidiFilePartType.VERS);
    part = part.part(MidiFilePartType.REFRAIN);
    MidiFile song2 = part.get();

    Session session = MidiPlayerService.mf.createSession();
    session.getItems().add(song1);
    session.getItems().add(song2);

    presentationContext.setCurrentSession(session, new DefaultMidiFileContentEditorConfig(), new Point (400, 200));
    presentationContext.setCurrentSessionItemIndex(1);

    ContentOverview overview = getContentOverview();
    overview.build(new Shell());
    presentationContext.nextSong();
    overview.refresh();

    Assert.assertTrue (overview.getPreviewParts().get(0).isSelected());

    //..now stepping back
    presentationContext.toItem(song1, true);
    overview.refresh();

    for (int i = 0; i < overview.getPreviewParts().size(); i++) {
      System.out.println (overview.getPreviewParts().get(i).getCurrentPart().getParttype() + "-" + overview.getPreviewParts().get(i).isSelected());
    }

    Assert.assertFalse (overview.getPreviewParts().get(2).isSelected());
    Assert.assertTrue (overview.getPreviewParts().get(3).isSelected());





  }



}
