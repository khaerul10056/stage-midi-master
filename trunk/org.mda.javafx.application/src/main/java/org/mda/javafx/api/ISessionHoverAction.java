package org.mda.javafx.api;

import org.mda.javafx.sessionview.SessionView;

/**
 * A session hover action is a item in the session hover that defines action 
 * to be done with a sesion, e.g. add new items,....
 * @author OleyMa
 *
 */
public interface ISessionHoverAction extends IAction {
	
	
	public void setSessionView (final SessionView sessionView);

}
