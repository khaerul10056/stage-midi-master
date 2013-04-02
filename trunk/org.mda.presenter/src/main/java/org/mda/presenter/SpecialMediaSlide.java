package org.mda.presenter;

import java.io.File;
import java.util.Collection;
import java.util.Collections;

import mda.SpecialMedia;

import org.mda.measurement.ColorInfo;
import org.mda.measurement.SizeInfo;

public class SpecialMediaSlide implements ISlide {

	
	private final File specialMediaFile;
	private final SpecialMedia media;
	private final SizeInfo size;
	
	

	public SpecialMediaSlide (final SpecialMedia media, final SizeInfo size) {
		  this.size = size;
		this.specialMediaFile = new File (media.getPath());
		  this.media = media;
	}

	@Override
	public Collection<? extends SlideItem> getItems() {
		return Collections.emptyList();
	}

	@Override
	public Object getModelRef() {
		return media;
	}

	@Override
	public File getBackgroundImageFile() {
		return null;
	}

	@Override
	public ColorInfo getBackgroundColor() {
		return null;
	}

	@Override
	public ColorInfo getForegroundColor() {
		return null;
	}

	@Override
	public boolean isForceNewPage() {
		return false;
	}

	@Override
	public SizeInfo getSize() {
		return size;
	}

	public File getSpecialMediaFile() {
		return specialMediaFile;
	}
}
