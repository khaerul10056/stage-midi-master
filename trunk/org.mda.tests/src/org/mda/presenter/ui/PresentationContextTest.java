package org.mda.presenter.ui;

import mda.MidiFile;
import mda.MidiFilePart;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.graphics.Point;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mda.ApplicationSession;
import org.mda.commons.ui.DefaultMidiFileContentEditorConfig;
import org.mda.commons.ui.calculator.Slide;
import org.mda.inject.InjectService;
import org.mda.inject.InjectServiceMock;



public class PresentationContextTest {

  private PresentationContext presentationContext;
  private ApplicationSession appsession;
  

  @Before
  public void setup () {
	InjectServiceMock.initialize();
	presentationContext = InjectService.getInstance(PresentationContext.class);
	appsession = InjectService.getInstance(ApplicationSession.class);
    presentationContext.clear();
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
    presentationContext.setCurrentSession(appsession.getCurrentModel().getSessions().get(0), new DefaultMidiFileContentEditorConfig(), new Point (400, 200));
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
