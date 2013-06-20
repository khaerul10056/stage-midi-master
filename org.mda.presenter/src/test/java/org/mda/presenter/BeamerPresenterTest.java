package org.mda.presenter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import mda.MidiPlayerRoot;
import mda.Session;
import mda.Song;
import mda.SongPart;
import mda.SongPartType;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mda.ApplicationSession;
import org.mda.CoreModule;
import org.mda.inject.InjectService;
import org.mda.measurement.SizeInfo;
import org.mda.presenter.config.DefaultPresenterConfig;
import org.mda.presenter.controller.DefaultPresentationController;
import org.mda.test.ModelCreator;
import org.mda.test.SongCreator;

public class BeamerPresenterTest {
	//private static MidiPlayerRoot root = MidiPlayerService.loadRootObject(new File("testdata/testmodel.conf"));
	  private static Session session;
	  private Song firstSong;
	  private Song secondSong;
	  private DefaultPresentationController controller;
	  private Song lastSong;
	  private SongPart lastPartOfLastSong;
	  private SongPart preLastPartOfLastSong;
	  private SongPart firstPartOfLastSong;
	  private Song prelastSong;
	  private static PresentationContext presentationContext;
	  private static ApplicationSession appsession;
	  private static DefaultPresenterConfig config;
	  

	  @BeforeClass
	  public static void beforeClass () {
		InjectService.cachedModules.add(new CoreModule());
		InjectService.cachedModules.add(new PresenterModule());
		InjectService.cachedModules.add(new PresenterTestModule());
		
		presentationContext = InjectService.getInstance(PresentationContext.class);
		appsession = InjectService.getInstance(ApplicationSession.class);
		config = InjectService.getInstance(DefaultPresenterConfig.class);
		
		MidiPlayerRoot midiPlayerRoot = ModelCreator.create().addSession("Hello").get();
		session = midiPlayerRoot.getSessions().get(0);
		for (int i = 0; i < 10; i++) {
			SongCreator creator = SongCreator.create().part(SongPartType.BRIDGE).text("Hello"); 
			creator.part(SongPartType.VERS).text("Vers");
			creator.part(SongPartType.REFRAIN).text("REFRAIN");
			Song nextSong = creator.get();
			session.getItems().add(nextSong);
		}
		appsession.setCurrentSession(session);
		
	 }

	  @Before
	  public void before () {
		CalculationParam param = new CalculationParam(new SizeInfo(400, 200));
	    presentationContext.setCurrentSession(session, config, param);
	    controller = InjectService.getInstance(DefaultPresentationController.class);
	    presentationContext.registerController(controller);
	    
	    firstSong = (Song) session.getItems().get(0);
	    secondSong = (Song) session.getItems().get(1);
	    lastSong = (Song) session.getItems().get(session.getItems().size() - 1);
	    prelastSong = (Song) session.getItems().get(session.getItems().size() - 2);
	    firstPartOfLastSong = lastSong.getParts().get(0);
	    preLastPartOfLastSong = lastSong.getParts().get(lastSong.getParts().size() - 2);
	    lastPartOfLastSong = lastSong.getParts().get(lastSong.getParts().size() - 1);
	  }

	  @Test
	  public void nextAndPreviousSlide () {
	    //Next slide
	    assertEquals(firstSong, presentationContext.getCurrentSessionItem());
	    assertEquals (firstSong.getParts().get(0), presentationContext.getCurrentSlide().getModelRef());
	    assertTrue (controller.nextSlide()); //Next slide
	    assertEquals(firstSong, presentationContext.getCurrentSessionItem());
	    assertEquals (firstSong.getParts().get(1), presentationContext.getCurrentSlide().getModelRef());

	    //step to last slide in first file
	    SongPart lastPartOfFirstSong = firstSong.getParts().get(firstSong.getParts().size() - 1);
	    while (presentationContext.getCurrentSlide().getModelRef() != lastPartOfFirstSong)
	      assertTrue (controller.nextSlide());

	    //step to next song
	    assertTrue (controller.nextSlide());
	    assertEquals(secondSong, presentationContext.getCurrentSessionItem());
	    assertEquals (secondSong.getParts().get(0), presentationContext.getCurrentSlide().getModelRef());

	    //step to last slide in last song
	    while (presentationContext.getCurrentSlide().getModelRef() != lastPartOfLastSong)
	      assertTrue (controller.nextSlide());
	    assertFalse (controller.nextSlide());

	    //Previous slide
	    assertTrue (controller.previousSlide());
	    assertEquals (lastSong, presentationContext.getCurrentSessionItem());
	    assertEquals (preLastPartOfLastSong, presentationContext.getCurrentSlide().getModelRef());

	    //step to first slide in last song
	    while (presentationContext.getCurrentSlide().getModelRef() != firstPartOfLastSong)
	      assertTrue (controller.previousSlide());

	    //step to previous song
	    assertTrue (controller.previousSlide());
	    assertEquals (prelastSong, presentationContext.getCurrentSessionItem());
	    assertEquals (prelastSong.getParts().get(prelastSong.getParts().size() - 1), presentationContext.getCurrentSlide().getModelRef());

	    //step to first slide in first song
	    while (presentationContext.getCurrentSlide().getModelRef() != firstSong.getParts().get(0))
	      assertTrue (controller.previousSlide());

	    assertFalse (controller.previousSlide());
	    controller.end();
	  }

	  @Test
	  public void nextAndPreviousSong () {
	    assertEquals(firstSong, presentationContext.getCurrentSessionItem());
	    assertEquals (firstSong.getParts().get(0), presentationContext.getCurrentSlide().getModelRef());
	    assertTrue (controller.nextSong()); //Next song
	    assertEquals (secondSong.getParts().get(0), presentationContext.getCurrentSlide().getModelRef());
	    while (presentationContext.getCurrentSlide().getModelRef() != firstPartOfLastSong)
	      assertTrue (controller.nextSong());

	    assertFalse (controller.nextSong());
	    while (presentationContext.getCurrentSlide().getModelRef() != firstSong.getParts().get(0))
	      assertTrue (controller.previousSong());

	    assertFalse (controller.previousSong());
	    controller.end();
	  }

	  @Test
	  public void toggleBlack () {
	    controller.toggleNormalize();
	    Assert.assertEquals (SpecialSlide.NONE, presentationContext.getSpecialSlide());
	    controller.toggleBlack();
	    Assert.assertEquals (SpecialSlide.BLACK, presentationContext.getSpecialSlide());
	    controller.toggleNormalize();
	    Assert.assertEquals (SpecialSlide.NONE, presentationContext.getSpecialSlide());
	    controller.end();
	    //TODO Assert.assertTrue(presenter.getShell().isDisposed()); 
	  }


	  @Test
	  public void toggleWhite () {
	    controller.toggleNormalize();
	    Assert.assertEquals (SpecialSlide.NONE, presentationContext.getSpecialSlide());
	    controller.toggleWhite();
	    Assert.assertEquals (SpecialSlide.WHITE, presentationContext.getSpecialSlide());
	    controller.toggleNormalize();
	    Assert.assertEquals (SpecialSlide.NONE, presentationContext.getSpecialSlide());
	    controller.end();
	  }

	  @Test
	  public void toggleOnlyBackground () {
	    controller.toggleNormalize();
	    Assert.assertEquals (SpecialSlide.NONE, presentationContext.getSpecialSlide());
	    controller.toggleOnlyBackground();
	    Assert.assertEquals (SpecialSlide.WITHOUT_TEXT, presentationContext.getSpecialSlide());
	    controller.toggleNormalize();
	    Assert.assertEquals (SpecialSlide.NONE, presentationContext.getSpecialSlide());
	    controller.end();
	  }

}
