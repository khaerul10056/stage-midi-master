package org.mda.presenter;

import java.io.File;
import java.util.Collection;

import org.mda.measurement.ColorInfo;
import org.mda.measurement.SizeInfo;

public interface ISlide {

	Collection<? extends SlideItem> getItems();

	Object getModelRef();

	File getBackgroundImageFile();

	ColorInfo getBackgroundColor();

	ColorInfo getForegroundColor();

	boolean isForceNewPage();

	SizeInfo getSize();
	

}
