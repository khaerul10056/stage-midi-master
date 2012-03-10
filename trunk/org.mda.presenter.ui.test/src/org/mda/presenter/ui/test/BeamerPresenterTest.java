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
import org.junit.Test;
import org.mda.ApplicationSession;
import org.mda.MdaModule;
import org.mda.MidiPlayerService;
import org.mda.commons.ui.DefaultMidiFileContentEditorConfig;
import org.mda.presenter.ui.BeamerPresenter;
import org.mda.presenter.ui.DefaultPresentationController;
import org.mda.presenter.ui.MdaPresenterModule;
import org.mda.presenter.ui.PresentationContext;
import org.mda.presenter.ui.SpecialSlide;


public class BeamerPresenterTest {

  private MidiPlayerRoot root;
  private Session session;
  private BeamerPresenter presenter;
  private MidiFile firstSong;
  private MidiFile secondSong;
  private DefaultPresentationController controller;
  private MidiFile lastSong;
  private MidiFilePart lastPartOfLastSong;
  private MidiFilePart preLastPartOfLastSong;
  private MidiFilePart firstPartOfLastSong;
  private MidiFile prelastSong;
  private PresentationContext presentationContext;

  @Before
  public void before () {
    root = MidiPlayerService.loadRootObject(new File("../org.mda.core.test/testdata/testmodel.conf"));

    session = root.getSessions().get(0);

    //Collection <IPresentationController> controllers = new ArrayList<IPresentationController>();
    presenter = new BeamerPresenter(Display.getDefault(), session, false, null);
    controller = new DefaultPresentationController();
    controller.connect(presenter);

    presentationContext = MdaPresenterModule.getInjector().getInstance(PresentationContext.class);
    MdaModule.getInjector().getInstance(ApplicationSession.class).load(null);
    presentationContext.setCurrentSession(session, new DefaultMidiFileContentEditorConfig(), new Point (400, 200));
    presenter.redraw();
    firstSong = (MidiFile) session.getItems().get(0);
    secondSong = (MidiFile) session.getItems().get(1);
    lastSong = (MidiFile) session.getItems().get(session.getItems().size() - 1);
    prelastSong = (MidiFile) session.getItems().get(session.getItems().size() - 2);
    firstPartOfLastSong = lastSong.getParts().get(0);
    preLastPartOfLastSong = lastSong.getParts().get(lastSong.getParts().size() - 2);
    lastPartOfLastSong = lastSong.getParts().get(lastSong.getParts().size() - 1);
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
    controller.toggleBlack(false);
    Assert.assertEquals (SpecialSlide.NONE, presentationContext.getSpecialSlide());
    controller.toggleBlack(true);
    Assert.assertEquals (SpecialSlide.BLACK, presentationContext.getSpecialSlide());
    controller.toggleBlack(false);
    Assert.assertEquals (SpecialSlide.NONE, presentationContext.getSpecialSlide());
    controller.end();
    Assert.assertTrue(presenter.isDisposed());
  }


  @Test
  public void toggleWhite () {
    controller.toggleWhite(false);
    Assert.assertEquals (SpecialSlide.NONE, presentationContext.getSpecialSlide());
    controller.toggleWhite(true);
    Assert.assertEquals (SpecialSlide.WHITE, presentationContext.getSpecialSlide());
    controller.toggleWhite(false);
    Assert.assertEquals (SpecialSlide.NONE, presentationContext.getSpecialSlide());
    controller.end();
  }

  @Test
  public void toggleOnlyBackground () {
    controller.toggleOnlyBackground(false);
    Assert.assertEquals (SpecialSlide.NONE, presentationContext.getSpecialSlide());
    controller.toggleOnlyBackground(true);
    Assert.assertEquals (SpecialSlide.WITHOUT_TEXT, presentationContext.getSpecialSlide());
    controller.toggleOnlyBackground(false);
    Assert.assertEquals (SpecialSlide.NONE, presentationContext.getSpecialSlide());
    controller.end();
  }



}
