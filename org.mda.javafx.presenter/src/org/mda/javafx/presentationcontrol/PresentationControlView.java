package org.mda.javafx.presentationcontrol;

import java.util.HashMap;
import java.util.List;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javafx.stage.StageBuilder;
import mda.AbstractSessionItem;
import mda.Session;

import org.mda.javafx.application.UISession;
import org.mda.javafx.presenter.KeyPresentationController;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.measurement.SizeInfo;
import org.mda.presenter.IPresentationView;
import org.mda.presenter.PresentationContext;
import org.mda.presenter.Slide;

import sun.rmi.log.LogHandler;

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
	
	@Inject
	KeyPresentationController keycontroller;
	
	private HashMap<AbstractSessionItem, TilePane> subpreviewTilePanes = new HashMap<AbstractSessionItem, TilePane>();
	
	private static final Log LOGGER  = LogFactory.getLogger(PresentationControlView.class);
	
	
	public void build () {
		  borderPane = new BorderPane();
		  
		  Button btn = new Button ("Buttons");
		  btn.setFocusTraversable(false);
		  borderPane.setTop(btn);
//		  borderPane.setCenter(new Button ("Current screen"));
//		  borderPane.setLeft(new Button ("Previous"));
//		  borderPane.setRight(new Button ("Next"));
//		  borderPane.setBottom(new Button ("Previews"));
		
		  Scene scene = new Scene(borderPane); 
		  Stage stage = StageBuilder.create().build();
		  stage.setScene(scene);
		  stage.setFullScreen(true);
		  stage.requestFocus();

		  //Main Previewpane
		  mainpreviewPanes = mainPreviewPaneBuilder.build(null, new SizeInfo(800, 600));
		  StackPane mainPreviewStackpane = new StackPane();
		  mainPreviewStackpane.getChildren().addAll(mainpreviewPanes.values());
		  borderPane.setCenter(mainPreviewStackpane);
		  
		  //Sub Previewpanes, adding a TilePane per sessionitem
		  Session session = context.getCurrentSession();
		  subpreviewPanes = subPreviewPaneBuilder.build(null, new SizeInfo(80, 60));
		  StackPane subPreviewStackpane = new StackPane();
		  for (AbstractSessionItem nextSessionItem : session.getItems()) {
			  List<Slide> slides = subPreviewPaneBuilder.getContainer().getSlides(nextSessionItem);
			  TilePane tile = new TilePane();
			  tile.setPadding(new Insets(5, 0, 5, 0));
			  tile.setVgap(8);
			  tile.setHgap(8);
			  tile.setPrefColumns(10);
			  for (Slide next: slides) {
				Pane nextPane = subpreviewPanes.get(next);
				nextPane.setVisible(true);
			    tile.getChildren().add(nextPane);
			  }
			  subpreviewTilePanes.put(nextSessionItem, tile);
			  subPreviewStackpane.getChildren().add(tile);
			  
		  }
		  subPreviewStackpane.setVisible(true);
		  borderPane.setBottom(subPreviewStackpane);
		  
		  Scene mainScene = uiSession.getMainStage().getScene();
		  stage.setX(mainScene.getX());
		  stage.setY(mainScene.getY());
		  stage.setWidth(mainScene.getWidth());
		  stage.setHeight(mainScene.getHeight());
		  
		  context.registerController(keycontroller);
		  stage.addEventHandler(KeyEvent.KEY_PRESSED, keycontroller );
		  
		  stage.show();
		  
		  refresh();
		  
	}


	@Override
	public void end() {
		context.deregisterController(keycontroller.getClass());
		context.deregisterView(getClass());
	}


	@Override
	public void refresh() {
		
		Slide currentPresentationSlide = context.getCurrentSlide();
		AbstractSessionItem currentSessionItem = context.getCurrentSessionItem();
		
		//set current mainpreview visible
		for (Slide nextSlide: mainpreviewPanes.keySet()) {
			Pane pane = mainpreviewPanes.get(nextSlide);
			boolean currentSlide = currentPresentationSlide.equals(nextSlide);
			pane.setVisible(currentSlide);
		}
		
		//set current tilepane visible
		TilePane currentTilePane = subpreviewTilePanes.get(currentSessionItem);
		for (TilePane nextTilePane : subpreviewTilePanes.values()) {
			boolean isCurrentTilePane = (nextTilePane == currentTilePane);
			nextTilePane.setVisible(isCurrentTilePane);
		}
		
		//set all opacities of non current items of current tilepane darker 
		for (Slide nextSlide: subPreviewPaneBuilder.getContainer().getSlides(currentSessionItem)) {
			Pane pane = subpreviewPanes.get(nextSlide);
			
			boolean currentSlide = currentPresentationSlide.equals(nextSlide);
			if (currentSlide)
			  pane.setOpacity(1.0);
			else
			  pane.setOpacity(0.5);
		}
		
	}


	@Override
	public boolean isFocused() {
		return false;
	}

	

}
