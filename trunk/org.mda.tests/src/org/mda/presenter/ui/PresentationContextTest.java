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
import org.mda.MdaModule;
import org.mda.commons.ui.DefaultMidiFileContentEditorConfig;
import org.mda.commons.ui.calculator.Slide;


public class PresentationContextTest {

  private PresentationContext presentationContext;
  private ApplicationSession instance;

  @Before
  public void setup () {
    presentationContext = MdaPresenterModule.getInjector().getInstance(PresentationContext.class);
    presentationContext.clear();
    instance = MdaModule.getInjector().getInstance(ApplicationSession.class);
  }

  @After
  public void tearDown () {
    presentationContext.clear();
  }

  @Test
  public void testToPart () {
    instance.load(null);

    MidiFile currentFile = (MidiFile) instance.getCurrentModel().getSessions().get(0).getItems().get(0);
    MidiFilePart part1 = currentFile.getParts().get(0);
    MidiFilePart part2 = currentFile.getParts().get(1);
    presentationContext.setCurrentSession(instance.getCurrentModel().getSessions().get(0), new DefaultMidiFileContentEditorConfig(), new Point (400, 200));
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
