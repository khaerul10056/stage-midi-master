package org.mda.presenter.config;


import mda.SongPartType;

import org.mda.presenter.adapter.ColorInfo;
import org.mda.presenter.adapter.FontInfo;
import org.mda.presenter.adapter.IGraphicsContext;

public interface IPresenterConfig {
	
	

	/**
	 * getter
	 * 
	 * @return true: chordline should be visible, false: chordline is not
	 *         visible
	 */
	boolean isChordPresented();

	/**
	 * some parts can be ignored e.g. for presentation editor no parts without
	 * text are shown
	 * 
	 * @param parttype
	 * @return
	 */
	boolean isPartIgnored(final SongPartType parttype);

	IGraphicsContext getGraphicsContext();

	ColorInfo getDefaultBackgroundColor();

	ColorInfo getDefaultForegroundColor();

	FontInfo getFont();

	/**
	 * returns if the background image should be shown
	 * 
	 * @return true/false
	 */
	boolean isShowBackground();

	/**
	 * returns if the blocktype at the beginning of an block (e.g. refrain) is
	 * shown If the blocktype is shown all following lines are indented after
	 * this type
	 * 
	 * @return
	 */
	boolean isShowBlockType();

	/**
	 * returns if a page should not contain more content than a part. Enabled
	 * e.g. for presentation on screen. Disabled e.g. for exporting to a
	 * songbook Parts can also be divided by the attribute isNewSlide () at the
	 * MidiFileTextLine.
	 * 
	 * @return
	 */
	boolean isPagePerPart();

	/**
	 * returns if the attribute isNewSlie() at the MidiFileTextLine is
	 * respected. Enabled e.g. for presentation on screen, splitting a too large
	 * part in different screens, Disabled e.g. for exporting to a songbook or
	 * the editor
	 * 
	 * @return
	 */
	boolean isNewPageRespected();

	/**
	 * returns is a title should be shown above
	 * 
	 * @return true/false
	 */
	boolean isShowTitle();

	/**
	 * returns if copyright-information should be should at the bottom of every
	 * song
	 * 
	 * @return true/false
	 */
	boolean isShowCopyright();

	/**
	 * returns if empty slides should be skipped
	 * 
	 * @return true/false
	 */
	boolean isSkipEmptySlides();

	/**
	 * returns if lines, that fit on one line should be merged automatically to
	 * need less space on the page
	 * 
	 * @return true/false
	 */
	boolean isOptimizeLineFilling();

	/**
	 * returns the border round a slide
	 * 
	 * @return border, cannot be <code>null</code>
	 */
	Integer getBorder();

	/**
	 * returns if parts, which are shown multiple times are optimized
	 * 
	 * REFRAIN ... VERS1 ... VERS1 ... REFRAIN ...
	 * 
	 * gets to REFRAIN ... VERS1 2x ... REFRAIN
	 * 
	 * @return true/false
	 */
	boolean isOptimizeEqualParts();

	/**
	 * returns, if empty tokens should be shown (false) or should be set to
	 * <code>null</code> In second case they have no influence on layout at all
	 * In editors this feature should be disabled because it has negative impact
	 * on split/merge lines
	 * 
	 * @return true/false
	 */
	boolean isOptimizeEmptyTokens();

	boolean isAutoWrapToNewPage();
	
	Integer getAutosizingPercent ();


}
