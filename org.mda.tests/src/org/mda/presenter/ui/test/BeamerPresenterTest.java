package org.mda.presenter.ui.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;

import mda.MidiFile;
import mda.MidiFilePart;
import mda.MidiPlayerRoot;
import mda.Session;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mda.ApplicationSession;
import org.mda.MidiPlayerService;
import org.mda.commons.ui.DefaultMidiFileContentEditorConfig;
import org.mda.inject.InjectService;
import org.mda.inject.InjectServiceMock;
import org.mda.presenter.ui.BeamerPresenter;
import org.mda.presenter.ui.DefaultPresentationController;
import org.mda.presenter.ui.PresentationContext;
import org.mda.presenter.ui.SpecialSlide;


@Deprecated
public class BeamerPresenterTest {

  private static MidiPlayerRoot root = MidiPlayerService.loadRootObject(new File("testdata/testmodel.conf"));
  private static Session session;
  private BeamerPresenter presenter;
  private MidiFile firstSong;
  private MidiFile secondSong;
  private DefaultPresentationController controller;
  private MidiFile lastSong;
  private MidiFilePart lastPartOfLastSong;
  private MidiFilePart preLastPartOfLastSong;
  private MidiFilePart firstPartOfLastSong;
  private MidiFile prelastSong;
  private static PresentationContext presentationContext;
  private static ApplicationSession appsession;
  private static DefaultMidiFileContentEditorConfig config;
  

  @BeforeClass
  public static void beforeClass () {
	InjectServiceMock.initialize();
	presentationContext = InjectService.getInstance(PresentationContext.class);
	appsession = InjectService.getInstance(ApplicationSession.class);
	config = InjectService.getInstance(DefaultMidiFileContentEditorConfig.class);
    session = root.getSessions().get(0);
    appsession.load(null);
  }

  @Before
  public void before () {
    presentationContext.setCurrentSession(session, config, new Point (400, 200));

    presenter = InjectService.getInstance(BeamerPresenter.class); 
    presenter.build(Display.getDefault(), session, false);
    controller = InjectService.getInstance(DefaultPresentationController.class);
    presentationContext.registerController(controller);
    presentationContext.registerView(presenter);

    presenter.getShell().redraw();
    firstSong = (MidiFile) session.getItems().get(0);
    secondSong = (MidiFile) session.getItems().get(1);
    lastSong = (MidiFile) session.getItems().get(session.getItems().size() - 1);
    prelastSong = (MidiFile) session.getItems().get(session.getItems().size() - 2);
    firstPartOfLastSong = lastSong.getParts().get(0);
    preLastPartOfLastSong = lastSong.getParts().get(lastSong.getParts().size() - 2);
    lastPartOfLastSong = lastSong.getParts().get(lastSong.getParts().size() - 1);
  }



  
  @Test
  public void paint () {
	  presenter.getShell().computeSize(400, 400);
  }

  @Test
  public void nextAndPreviousSlide () {
    //Next slide
    assertEquals(firstSong, presenter.getCurrentSessionItem());
    assertEquals (firstSong.getParts().get(0), presenter.getCurrentSlide().getModelRef());
    assertTrue (controller.nextSlide()); //Next slide
    assertEquals(firstSong, presenter.getCurrentSessionItem());
    assertEquals (firstSong.getParts().get(1), presenter.getCurrentSlide().getModelRef());

    //step to last slide in first file
    MidiFilePart lastPartOfFirstSong = firstSong.getParts().get(firstSong.getParts().size() - 1);
    while (presenter.getCurrentSlide().getModelRef() != lastPartOfFirstSong)
      assertTrue (controller.nextSlide());

    //step to next song
    assertTrue (controller.nextSlide());
    assertEquals(secondSong, presenter.getCurrentSessionItem());
    assertEquals (secondSong.getParts().get(0), presenter.getCurrentSlide().getModelRef());

    //step to last slide in last song
    while (presenter.getCurrentSlide().getModelRef() != lastPartOfLastSong)
      assertTrue (controller.nextSlide());
    assertFalse (controller.nextSlide());

    //Previous slide
    assertTrue (controller.previousSlide());
    assertEquals (lastSong, presenter.getCurrentSessionItem());
    assertEquals (preLastPartOfLastSong, presenter.getCurrentSlide().getModelRef());

    //step to first slide in last song
    while (presenter.getCurrentSlide().getModelRef() != firstPartOfLastSong)
      assertTrue (controller.previousSlide());

    //step to previous song
    assertTrue (controller.previousSlide());
    assertEquals (prelastSong, presenter.getCurrentSessionItem());
    assertEquals (prelastSong.getParts().get(prelastSong.getParts().size() - 1), presenter.getCurrentSlide().getModelRef());

    //step to first slide in first song
    while (presenter.getCurrentSlide().getModelRef() != firstSong.getParts().get(0))
      assertTrue (controller.previousSlide());

    assertFalse (controller.previousSlide());
    controller.end();
  }

  @Test
  public void nextAndPreviousSong () {
    assertEquals(firstSong, presenter.getCurrentSessionItem());
    assertEquals (firstSong.getParts().get(0), presenter.getCurrentSlide().getModelRef());
    assertTrue (controller.nextSong()); //Next song
    assertEquals (secondSong.getParts().get(0), presenter.getCurrentSlide().getModelRef());
    while (presenter.getCurrentSlide().getModelRef() != firstPartOfLastSong)
      assertTrue (controller.nextSong());

    assertFalse (controller.nextSong());
    while (presenter.getCurrentSlide().getModelRef() != firstSong.getParts().get(0))
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
    Assert.assertTrue(presenter.getShell().isDisposed());
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
