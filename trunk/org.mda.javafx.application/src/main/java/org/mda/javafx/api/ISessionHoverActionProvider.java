package org.mda.javafx.api;

import java.util.List;

/**
 * create a list of session hover actions 
 * to be shown in the session hover
 * @author OleyMa
 *
 */
public interface ISessionHoverActionProvider  {
	
	/**
	 * creates a list of session over actions
	 * @return lust of session hover actions
	 */
	List<ISessionHoverAction> get ();

	

}
