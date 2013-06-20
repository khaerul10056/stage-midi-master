package org.mda.presenter;

import mda.MidiPlayerRoot;
import mda.Song;
import mda.SongPart;
import mda.SongPartType;

import org.eclipse.emf.ecore.EObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mda.CoreModule;
import org.mda.inject.InjectService;
import org.mda.measurement.SizeInfo;
import org.mda.presenter.config.DefaultPresenterConfig;
import org.mda.test.ModelCreator;
import org.mda.test.SongCreator;

/**
 * tests the presentation context
 * @author OleyMa
 *
 */
public class PresentationContextTest {
	
	/**
	 * presentation context
	 */
	private PresentationContext presentationContext;
	
	/**
	 * configuration
	 */
	private DefaultPresenterConfig config;

	@Before
	public void setup() {
		InjectService.cachedModules.add(new CoreModule());
		InjectService.cachedModules.add(new PresenterModule());
		InjectService.cachedModules.add(new PresenterTestModule());

		presentationContext = InjectService.getInstance(PresentationContext.class);
		presentationContext.clear();
		config = InjectService.getInstance(DefaultPresenterConfig.class);

	}

	@After
	public void tearDown() {
		presentationContext.clear();
	}

	@Test
	public void testToPart() {

		Song currentFile = SongCreator.create().setName("Hello")
				.part(SongPartType.VERS).line().chordAndText("C", "Hello song")
				.part(SongPartType.VERS).line().chordAndText("C", "Hello song")
				.get();
		MidiPlayerRoot root = ModelCreator.create().addSession("Hello").get();
		root.getSessions().get(0).getItems().add(currentFile);

		SongPart part1 = currentFile.getParts().get(0);
		SongPart part2 = currentFile.getParts().get(1);
		CalculationParam param = new CalculationParam(new SizeInfo(400, 200));
		presentationContext.setCurrentSession(root.getSessions().get(0),config, param);
		presentationContext.setCurrentSessionItemIndex(0);

		Slide slide = (Slide) presentationContext.getCurrentSlide();
		EObject modelRef = slide.getModelRef();
		Assert.assertEquals(part1, modelRef);
		presentationContext.toPart(part2);

		slide = (Slide) presentationContext.getCurrentSlide();
		modelRef = slide.getModelRef();
		Assert.assertEquals(part2, modelRef);

	}

}
