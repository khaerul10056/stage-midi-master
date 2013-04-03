package org.mda.javafx.presentationcontrol;

import org.mda.javafx.api.IconRegistry;

import com.google.inject.Inject;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;

public abstract class AbstractControlViewPaneBuilder {
	
	@Inject
	protected IconRegistry iconregistry;
	
	protected VBox createVBox (final int right, final int left) {
		return VBoxBuilder.create().alignment(Pos.CENTER).spacing(20).padding(new Insets (10, right, 10, left)).build();
	}
	protected Button createButton (final String name, final String idIcon) {
		Button btn = ButtonBuilder.create().build();
		btn.setId("navigationbutton");
		btn.setFocusTraversable(false);
		if (name != null)
		  btn.setText(name);
		
		if (idIcon != null)
		  btn.setGraphic(new ImageView(iconregistry.getIcon(idIcon)));
		
		return btn;
	}

}
