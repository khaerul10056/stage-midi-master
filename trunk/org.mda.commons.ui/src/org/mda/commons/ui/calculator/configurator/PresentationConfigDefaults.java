package org.mda.commons.ui.calculator.configurator;

import java.util.ArrayList;
import java.util.Collection;

import mda.PresentationScheme;

import org.mda.MidiPlayerService;

public class PresentationConfigDefaults {
	
	private Collection <PresentationScheme> defaultschemes = new ArrayList<PresentationScheme>();
	
	public PresentationConfigDefaults () {
		defaultschemes.add(createPdfScheme());
		defaultschemes.add(createScreenScheme());
		defaultschemes.add(createPptScheme());
	}
	
	public Collection <PresentationScheme> getAllDefaultSchemes () {
		return defaultschemes;
	}
	
	private PresentationScheme createScreenScheme () {
		PresentationScheme scheme = MidiPlayerService.mf.createPresentationScheme();
		scheme.setType(PresentationType.SCREEN.toString());
		scheme.setShowChords(Boolean.FALSE);
		scheme.setShowBackground(Boolean.TRUE);
		scheme.setSkipEmptySlides(Boolean.TRUE);
		scheme.setOptimizeEmptyTokens(Boolean.TRUE);
		scheme.setOptimizeEqualParts(Boolean.FALSE);
		scheme.setOptimizeLineFilling(Boolean.FALSE);
		return scheme;
	}
	
	private PresentationScheme createPdfScheme () {
		PresentationScheme scheme = MidiPlayerService.mf.createPresentationScheme();
		scheme.setType(PresentationType.PDF.toString());
		scheme.setShowChords(Boolean.TRUE);
		scheme.setShowBlockType(Boolean.TRUE);
		scheme.setPagePerPart(Boolean.FALSE);
		scheme.setNewPageRespected(Boolean.FALSE);
		scheme.setShowTitle(Boolean.TRUE);
		
	    
	    scheme.setOptimizeLineFilling(Boolean.TRUE);
	    scheme.setOptimizeEmptyTokens(Boolean.TRUE);
	    scheme.setShowCopyright(Boolean.TRUE);
	    scheme.setBorder(new Integer (35));
		return scheme;
	}
	
	private PresentationScheme createPptScheme () {
		PresentationScheme scheme = MidiPlayerService.mf.createPresentationScheme();
		scheme.setType(PresentationType.PPT.toString());
		scheme.setShowBackground(Boolean.TRUE);
		scheme.setSkipEmptySlides(Boolean.TRUE);
		scheme.setOptimizeLineFilling(Boolean.FALSE);
		scheme.setShowChords(Boolean.FALSE);
		scheme.setShowTitle(Boolean.FALSE);
		scheme.setShowCopyright(Boolean.FALSE);
		scheme.setPagePerPart(Boolean.TRUE);
		return scheme;
	}

}
