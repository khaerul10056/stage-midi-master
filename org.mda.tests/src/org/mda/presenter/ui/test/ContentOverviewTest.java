package org.mda.presenter.ui.test;

import mda.Song;
import mda.SongPartType;
import mda.Session;

import org.eclipse.swt.widgets.Shell;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mda.ApplicationSession;
import org.mda.MidiPlayerService;
import org.mda.inject.InjectService;
import org.mda.inject.InjectServiceMock;
import org.mda.presenter.CalculationParam;
import org.mda.presenter.PresentationContext;
import org.mda.presenter.adapter.SizeInfo;
import org.mda.presenter.config.DefaultPresenterConfig;
import org.mda.presenter.ui.ContentOverview;


public class ContentOverviewTest {
	
  private static PresentationContext presentationContext;
  private static ApplicationSession instance;
  private static ContentOverview overview;
  private static DefaultPresenterConfig config;
  
  @BeforeClass
  public static void beforeClass () {
	  InjectServiceMock.initialize();
	  presentationContext = InjectService.getInstance(PresentationContext.class);
	  instance = InjectService.getInstance(ApplicationSession.class);
	  overview = InjectService.getInstance(ContentOverview.class);
	  config = InjectService.getInstance(DefaultPresenterConfig.class);
  }

  @After
  public void tearDown () {
    presentationContext.clear();
  }

  @Test
  public void testContentOverview () throws Exception {
    instance.load(null);
    CalculationParam param = new CalculationParam(new SizeInfo(400, 200));
    presentationContext.setCurrentSession(instance.getCurrentModel().getSessions().get(0), config, param);
    overview.build(new Shell());
    overview.refresh();
    Assert.assertTrue (overview.getPreviewParts().get(0).isSelected());

  }
  
  private ContentOverview getContentOverview () {
	  return InjectService.getInstance(ContentOverview.class);
  }

  @Test
  public void testContentOverviewOfPartWithNewSlide () throws Exception {
    MidiFileCreator part = MidiFileCreator.create().part(SongPartType.INTRO);
    part = part.line().chordAndText("D", "This is the first line").chordAndText("Ab", "");
    part = part.line().chordAndText("D", "Second line").chordAndText("Ab", "");
    part = part.line().chordAndText("D", "Third line").chordAndText("Ab", "");

    Song song = part.get();

    Session session = MidiPlayerService.mf.createSession();
    session.getItems().add(song);
    song.getParts().get(0).getTextlines().get(2).setNewSlide(true);

    CalculationParam param = new CalculationParam(new SizeInfo(400, 200));
    presentationContext.setCurrentSession(session, config, param);

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
    MidiFileCreator part = MidiFileCreator.create().part(SongPartType.VERS).line().text("First line").line().text("Second line");
    part = part.part(SongPartType.REFRAIN).line().text("First line").line().text("Second line");
    Song song1 = part.get();
    song1.getParts().get(0).getTextlines().get(1).setNewSlide(true);
    song1.getParts().get(1).getTextlines().get(1).setNewSlide(true);

    //System.out.println(MidiPlayerService.toString(song1));

    part = MidiFileCreator.create().part(SongPartType.VERS);
    part = part.part(SongPartType.REFRAIN);
    Song song2 = part.get();

    Session session = MidiPlayerService.mf.createSession();
    session.getItems().add(song1);
    session.getItems().add(song2);

    CalculationParam param = new CalculationParam(new SizeInfo(400, 200));
    presentationContext.setCurrentSession(session, config, param);
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
