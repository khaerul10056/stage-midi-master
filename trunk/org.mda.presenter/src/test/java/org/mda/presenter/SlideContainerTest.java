package org.mda.presenter;

import mda.AbstractSessionItem;
import mda.Song;
import mda.SongPartType;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mda.CoreModule;
import org.mda.inject.InjectService;
import org.mda.test.SongCreator;

public class SlideContainerTest {

	@BeforeClass
	public static void beforeClass() {
		InjectService.cachedModules.add(new CoreModule());
		InjectService.cachedModules.add(new PresenterModule());
		InjectService.cachedModules.add(new PresenterTestModule());
	}

	@Test
	public void addContainer() {

		Song item = SongCreator.create().part(SongPartType.VERS).line().chord("D").get();
		Slide slide = new Slide(item, item.getParts().get(0).getTextlines().get(0), null, true);

		SlideContainer container1 = new SlideContainer();
		Assert.assertEquals(0, container1.getSlides(item).size());

		container1.addSlide(item, slide);
		Assert.assertEquals(1, container1.getSlides(item).size());
		Assert.assertEquals(slide, container1.getSlides(item).get(0));

		SlideContainer container2 = new SlideContainer();
		AbstractSessionItem item2 = SongCreator.create().part(SongPartType.VERS).line().chord("D").get();
		Slide slide2 = new Slide(item, item.getParts().get(0).getTextlines().get(0), null, true);
		container2.addSlide(item2, slide2);

		container2.addContainer(container1);
		Assert.assertEquals(slide, container2.getSlides(item).get(0));
		Assert.assertEquals(2, container2.getSlides().size());
		Assert.assertTrue("slide from container1 not contained in slides", container1.getSlides().contains(slide));
		Assert.assertTrue("slide from container2 not contained in slides", container2.getSlides().contains(slide2));

	}

}
