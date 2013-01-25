package org.mda.presenter;

import mda.MidiFile;
import mda.MidiFilePart;

import org.eclipse.emf.ecore.EObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mda.ApplicationSession;
import org.mda.inject.InjectService;
import org.mda.inject.InjectServiceMock;
import org.mda.presenter.adapter.SizeInfo;
import org.mda.presenter.config.DefaultMidiFilePresenterConfig;


public class PresentationContextTest {

  private PresentationContext presentationContext;
  private ApplicationSession appsession;
  private DefaultMidiFilePresenterConfig config;
  

  @Before
  public void setup () {
	InjectServiceMock.initialize();
	presentationContext = InjectService.getInstance(PresentationContext.class);
	appsession = InjectService.getInstance(ApplicationSession.class);
    presentationContext.clear();
    config = InjectService.getInstance(DefaultMidiFilePresenterConfig.class);
  }

  @After
  public void tearDown () {
    presentationContext.clear();
  }

  @Test
  public void testToPart () {
    appsession.load(null);

    MidiFile currentFile = (MidiFile) appsession.getCurrentModel().getSessions().get(0).getItems().get(0);
    MidiFilePart part1 = currentFile.getParts().get(0);
    MidiFilePart part2 = currentFile.getParts().get(1);
    presentationContext.setCurrentSession(appsession.getCurrentModel().getSessions().get(0), config, new SizeInfo (400, 200));
    presentationContext.setCurrentSessionItemIndex(0);

    Slide slide = presentationContext.getCurrentSlide();
    EObject modelRef = slide.getModelRef();
    Assert.assertEquals (part1, modelRef);
    presentationContext.toPart(part2);

    slide = presentationContext.getCurrentSlide();
    modelRef = slide.getModelRef();
    Assert.assertEquals (part2, modelRef);

  }

}
