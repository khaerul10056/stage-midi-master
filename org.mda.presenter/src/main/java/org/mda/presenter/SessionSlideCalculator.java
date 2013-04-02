package org.mda.presenter;

import java.util.Set;

import mda.AbstractSessionItem;
import mda.Session;

import org.mda.presenter.config.IPresenterConfig;

import com.google.inject.Inject;

/**
 * calculates slides for a complete session, 
 * delegates calculating of one sessionitem to a specialized calculator
 * @author OleyMa
 *
 */
public class SessionSlideCalculator {
	
	@Inject
	private Set<ISlideCalculator>  calculatorDelegates;
	
	
	
	/**
	 * calculates slides for a complete session
	 * @param session  	session
	 * @param param		parameter
	 * @param config	configuration
	 * @return slidecontainer
	 */
	public SlideContainer calculate (final Session session, final CalculationParam param, final IPresenterConfig config) {
		SlideContainer container = new SlideContainer();
		
		for (AbstractSessionItem nextItem: session.getItems()) {
			
			for (ISlideCalculator nextCalculator : calculatorDelegates) {
				if (nextCalculator.isAssigned(nextItem)) {
				  container.addContainer(nextCalculator.calculate(nextItem, param, config));
				  break;
				}
			}
		}
		
		return container;
	}
	
	
	

	

}
