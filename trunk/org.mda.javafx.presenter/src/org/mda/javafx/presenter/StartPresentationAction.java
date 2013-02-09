package org.mda.javafx.presenter;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import org.mda.javafx.api.ISessionViewAction;
import org.mda.javafx.api.IconRegistry;
import org.mda.javafx.presentationcontrol.PresentationControlView;

import com.google.inject.Inject;

public class StartPresentationAction implements ISessionViewAction {
	
	@Inject
	PresentationControlView controlview;
	
	@Inject
	private IconRegistry iconregistry;

	@Override
	public String getName() {
		return "Start";
	}

	@Override
	public void execute(Pane parentPane) {
		controlview.build();
		

	}

	@Override
	public Image getIcon() {
		return iconregistry.getIcon(IPresenterIconConst.ICON_PLAY);
	}

	

}
