package org.mda.presenter;

import mda.AbstractSessionItem;

import org.junit.Assert;
import org.junit.Test;
import org.mda.presenter.ui.test.MidiFileCreator;

public class SlideContainerTest {

	@Test
	public void addContainer ()  {
		
		AbstractSessionItem item = MidiFileCreator.create().get();
		Slide slide = new Slide(item, null, null, true);
		
		
		SlideContainer container1 = new SlideContainer();
		Assert.assertEquals (0, container1.getSlides(item).size());

		container1.addSlide(item, slide);
		Assert.assertEquals (1, container1.getSlides(item).size());
		Assert.assertEquals (slide, container1.getSlides(item).get(0));
		
		
		SlideContainer container2 = new SlideContainer();
		AbstractSessionItem item2 = MidiFileCreator.create().get();
		Slide slide2 = new Slide(item, null, null, true);
		container2.addSlide(item2,  slide2);
		
		container2.addContainer(container1);
		Assert.assertEquals (slide, container2.getSlides(item).get(0));
		Assert.assertEquals (2, container2.getSlides().size());
		Assert.assertTrue ("slide from container1 not contained in slides", container2.getSlides().contains(slide));
		Assert.assertTrue ("slide from container2 not contained in slides", container2.getSlides().contains(slide2));
		
		
	}

}
