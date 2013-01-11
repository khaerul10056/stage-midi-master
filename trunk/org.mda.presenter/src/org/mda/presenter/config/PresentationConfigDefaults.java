package org.mda.presenter.config;

import java.util.ArrayList;
import java.util.Collection;

import mda.PresentationScheme;

import org.mda.MidiPlayerService;
import org.mda.presenter.adapter.Color;
/**
 * Default values for configuration
 * @author oleym
 *
 */
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
		
		scheme.setBackgroundColor(Color.BLACK.toString());
		scheme.setBorder(new Integer (10));
		scheme.setForegroundColor(Color.WHITE.toString());
		scheme.setNewPageRespected(Boolean.TRUE);
		scheme.setOptimizeEmptyTokens(Boolean.TRUE);
		scheme.setOptimizeEqualParts(Boolean.FALSE);
		scheme.setOptimizeLineFilling(Boolean.FALSE);
		scheme.setPagePerPart(Boolean.TRUE);
		scheme.setShowBackground(Boolean.TRUE);
		scheme.setShowBlockType(Boolean.FALSE);
		scheme.setShowChords(Boolean.FALSE);
		scheme.setShowCopyright(Boolean.FALSE);
		scheme.setShowTitle(Boolean.FALSE);
		scheme.setSkipEmptySlides(Boolean.TRUE);
		scheme.setType(PresentationType.SCREEN.toString());
		return scheme;
	}
	
	private PresentationScheme createPdfScheme () {
		PresentationScheme scheme = MidiPlayerService.mf.createPresentationScheme();
		
		scheme.setBackgroundColor(Color.WHITE.toString());
		scheme.setBorder(new Integer (35));
		scheme.setForegroundColor(Color.BLACK.toString());
		scheme.setNewPageRespected(Boolean.FALSE);
		scheme.setOptimizeEmptyTokens(Boolean.TRUE);
		scheme.setOptimizeEqualParts(Boolean.TRUE);
		scheme.setOptimizeLineFilling(Boolean.TRUE);
		scheme.setPagePerPart(Boolean.FALSE);
		scheme.setShowBackground(Boolean.FALSE);
		scheme.setShowBlockType(Boolean.TRUE);
		scheme.setShowChords(Boolean.TRUE);
		scheme.setShowCopyright(Boolean.TRUE);
		scheme.setShowTitle(Boolean.TRUE);
		scheme.setSkipEmptySlides(Boolean.TRUE);
		scheme.setType(PresentationType.PDF.toString());
		
		return scheme;
	}
	
	private PresentationScheme createPptScheme () {
		PresentationScheme scheme = MidiPlayerService.mf.createPresentationScheme();
		
		scheme.setBackgroundColor(Color.BLACK.toString());
		scheme.setBorder(new Integer (10));
		scheme.setForegroundColor(Color.WHITE.toString());
		scheme.setNewPageRespected(Boolean.TRUE);
		scheme.setOptimizeEmptyTokens(Boolean.TRUE);
		scheme.setOptimizeEqualParts(Boolean.FALSE);
		scheme.setOptimizeLineFilling(Boolean.FALSE);
		scheme.setPagePerPart(Boolean.TRUE);
		scheme.setShowBackground(Boolean.TRUE);
		scheme.setShowBlockType(Boolean.FALSE);
		scheme.setShowChords(Boolean.FALSE);
		scheme.setShowCopyright(Boolean.FALSE);
		scheme.setShowTitle(Boolean.FALSE);
		scheme.setSkipEmptySlides(Boolean.TRUE);
		scheme.setType(PresentationType.PPT.toString());
		
		return scheme;
	}

}
