package org.mda.javafx.presentationcontrol;

import java.util.HashMap;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javafx.stage.StageBuilder;

import org.mda.javafx.application.UISession;
import org.mda.presenter.IPresentationView;
import org.mda.presenter.PresentationContext;
import org.mda.presenter.Slide;
import org.mda.presenter.adapter.SizeInfo;

import com.google.inject.Inject;

/**
 * view to control the presentation 
 * @author oleym
 *
 */
public class PresentationControlView implements IPresentationView{

	@Inject
    private UISession uiSession;
	
	@Inject
	private PresentationContext context;
	
	@Inject
	private PreviewPane mainPreviewPaneBuilder;
	
	@Inject
	private PreviewPane subPreviewPaneBuilder;

	private BorderPane borderPane;
	
	private HashMap<Slide, Pane> mainpreviewPanes;

	private HashMap<Slide, Pane> subpreviewPanes;
	
	
	public void build () {
		
		  borderPane = new BorderPane();
		  
		  borderPane.setTop(new Button ("Buttons"));
		  borderPane.setCenter(new Button ("Current screen"));
		  borderPane.setLeft(new Button ("Previous"));
		  borderPane.setRight(new Button ("Next"));
		  borderPane.setBottom(new Button ("Previews"));
		
		  Scene scene = new Scene(borderPane); 
		  Stage stage = StageBuilder.create().build();
		  stage.setScene(scene);
		  stage.setFullScreen(true);
		  stage.requestFocus();

		  //Main Previewpane
		  mainpreviewPanes = mainPreviewPaneBuilder.build(null, new SizeInfo(400,  300));
		  StackPane mainPreviewStackpane = new StackPane();
		  mainPreviewStackpane.getChildren().addAll(mainpreviewPanes.values());
		  borderPane.setCenter(mainPreviewStackpane);
		  
		  //Sub Previewpanes
		  subpreviewPanes = subPreviewPaneBuilder.build(null, new SizeInfo(80, 60));
		  TilePane tile = new TilePane();
		  tile.setPadding(new Insets(5, 0, 5, 0));
		  tile.setVgap(4);
		  tile.setHgap(4);
		  tile.setPrefColumns(2);
		  tile.getChildren().addAll(subpreviewPanes.values());
		  borderPane.setBottom(tile);
		  
		  Scene mainScene = uiSession.getMainStage().getScene();
		  stage.setX(mainScene.getX());
		  stage.setY(mainScene.getY());
		  stage.setWidth(mainScene.getWidth());
		  stage.setHeight(mainScene.getHeight());
		  
		  
		  stage.show();
		  
		  refresh();
		  
	}


	@Override
	public void end() {
		context.deregisterView(getClass());
	}


	@Override
	public void refresh() {
		
		Slide currentPresentationSlide = context.getCurrentSlide();
		
		for (Slide nextSlide: mainpreviewPanes.keySet()) {
			Pane pane = mainpreviewPanes.get(nextSlide);
			boolean currentSlide = currentPresentationSlide.getModelRef().equals(nextSlide.getModelRef());
			pane.setVisible(currentSlide);
			
		}
		
		for (Slide nextSlide: subpreviewPanes.keySet()) {
			Pane pane = subpreviewPanes.get(nextSlide);
			boolean currentSlide = currentPresentationSlide.getModelRef().equals(nextSlide.getModelRef());
			if (currentSlide)
			  pane.setOpacity(1.0);
			else
			  pane.setOpacity(0.7);
			pane.setVisible(true);
			
		}
		
	}


	@Override
	public boolean isFocused() {
		return false;
	}

	

}
