package org.mda.javafx.api;

import java.util.List;

/**
 * create a list of song hover actions 
 * to be shown in the song hover
 * @author OleyMa
 *
 */
public interface ISongHoverActionProvider  {
	
	/**
	 * creates a list of song hover actions
	 * @return lust of song hover actions
	 */
	List<ISongHoverAction> get ();

	

}
