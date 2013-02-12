package org.mda.presenter;

import org.mda.measurement.SizeInfo;
import org.mda.presenter.adapter.AreaInfo;

public class CalculationParam {

	private AreaInfo bounds;
	
	public CalculationParam (final AreaInfo bounds) {
		this.bounds = bounds;
	}
	
	public CalculationParam (final SizeInfo size) {
		this.bounds = new AreaInfo(-1, -1, size);
	}

	public AreaInfo getPresentationBounds() {
		return this.bounds;
	}
	
	public SizeInfo getPresentationSize () {
		return bounds.getSize();
	}

	public void setPresentationBounds(final AreaInfo areainfo) {
		this.bounds = areainfo;
	}
	
	

}
