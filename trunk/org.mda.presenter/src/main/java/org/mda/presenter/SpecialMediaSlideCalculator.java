package org.mda.presenter;

import mda.AbstractSessionItem;
import mda.SpecialMedia;

import org.mda.presenter.config.IPresenterConfig;

public class SpecialMediaSlideCalculator implements ISlideCalculator {

	@Override
	public SlideContainer calculate(AbstractSessionItem sessionitem, CalculationParam param, IPresenterConfig config) {
		SpecialMedia specialmedia = (SpecialMedia) sessionitem;
		
		SpecialMediaSlide slide = new SpecialMediaSlide(specialmedia, param.getPresentationSize());
		
		SlideContainer container = new SlideContainer(); 
		container.addSlide(sessionitem, slide);
		
		return container;
	}

	@Override
	public boolean isAssigned(AbstractSessionItem item) {
		return item instanceof SpecialMedia;
	}

}
