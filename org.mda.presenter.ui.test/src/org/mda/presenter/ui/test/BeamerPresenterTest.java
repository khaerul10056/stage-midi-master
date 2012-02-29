package org.mda.presenter.ui.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import mda.MidiFile;
import mda.MidiFilePart;
import mda.MidiPlayerRoot;
import mda.Session;
import org.eclipse.swt.widgets.Display;
import org.junit.Test;
import org.mda.MidiPlayerService;
import org.mda.commons.ui.DefaultMidiFileContentEditorConfig;
import org.mda.presenter.ui.BeamerPresenter;
import org.mda.presenter.ui.DefaultPresentationController;
import org.mda.presenter.ui.IPresentationController;


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

  public BeamerPresenterTest () {
    root = MidiPlayerService.loadRootObject(new File("../org.mda.core.test/testdata/testmodel.conf"));

    session = root.getSessions().get(0);

    Collection <IPresentationController> controllers = new ArrayList<IPresentationController>();
    controllers.add(new DefaultPresentationController());
    presenter = new BeamerPresenter(Display.getCurrent(), session, false);
    firstSong = (MidiFile) session.getItems().get(0);
    secondSong = (MidiFile) session.getItems().get(1);
    lastSong = (MidiFile) session.getItems().get(session.getItems().size() - 1);
    prelastSong = (MidiFile) session.getItems().get(session.getItems().size() - 2);
    firstPartOfLastSong = lastSong.getParts().get(0);
    preLastPartOfLastSong = lastSong.getParts().get(lastSong.getParts().size() - 2);
    lastPartOfLastSong = lastSong.getParts().get(lastSong.getParts().size() - 1);


  }

  @Test
  public void next () {
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
  }

  @Test
  public void previous () {

    while (presenter.getCurrentSlide().getModelRef() != lastPartOfLastSong)
      assertTrue (controller.nextSlide());

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




  }

}
