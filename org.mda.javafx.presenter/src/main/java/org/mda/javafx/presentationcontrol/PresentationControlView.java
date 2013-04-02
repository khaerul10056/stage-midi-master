package org.mda.javafx.presentationcontrol;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageBuilder;
import javafx.stage.StageStyle;
import mda.AbstractSessionItem;
import mda.Session;

import org.mda.javafx.application.UISession;
import org.mda.javafx.common.MonitorManager;
import org.mda.javafx.presenter.KeyPresentationController;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.measurement.SizeInfo;
import org.mda.presenter.IPresentationView;
import org.mda.presenter.ISlide;
import org.mda.presenter.PresentationContext;
import org.mda.presenter.controller.DefaultPresentationController;

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
	
	@Inject
	private ActionButtonPane actionButtonPaneBuilder;
	
	@Inject
	private NavigationLeftPaneBuilder navigationLeftPaneBuilder;
	
	@Inject
	private NavigationRightPaneBuilder navigationRightPaneBuilder;

	private BorderPane borderPane;
	
	private HashMap<ISlide, Pane> mainpreviewPanes;

	private HashMap<ISlide, Pane> subpreviewPanes;
	
	@Inject
	private KeyPresentationController keycontroller;
	
	@Inject
	private DefaultPresentationController defaultcontroller;
	
	@Inject
	private MonitorManager monitormanager;
	
	
	
	private HashMap<AbstractSessionItem, PictureGallery> pictureGalleries = new HashMap<AbstractSessionItem, PictureGallery>();
	
	private static final Log LOGGER  = LogFactory.getLogger(PresentationControlView.class);
	
	
	public void build () {
		  borderPane = new BorderPane();
		  borderPane.setId("presentationcontrol");
		  
		  Pane actionButtonPane = actionButtonPaneBuilder.build(defaultcontroller);
		  Pane rightNavigationPane = navigationRightPaneBuilder.build(defaultcontroller);
		  Pane leftNavigationPane = navigationLeftPaneBuilder.build(defaultcontroller);
		  
		  BorderPane.setAlignment(actionButtonPane, Pos.CENTER);
		  BorderPane.setAlignment(rightNavigationPane, Pos.CENTER);
		  BorderPane.setAlignment(leftNavigationPane, Pos.CENTER);
		  
		  borderPane.setTop(actionButtonPane);
		  borderPane.setRight(rightNavigationPane);
		  borderPane.setLeft(leftNavigationPane);
		  Scene scene = new Scene(borderPane);
		  scene.getStylesheets().addAll(uiSession.getMainStage().getScene().getStylesheets());
		  
		  Stage stage = StageBuilder.create().build();
	      stage.initStyle(StageStyle.UNDECORATED);
		  stage.setScene(scene);
		  monitormanager.layoutToPrimaryMonitorBounds(stage);
		  //stage.setFullScreen(true);
		  stage.requestFocus();
		  
		  //Main Previewpane
		  mainpreviewPanes = mainPreviewPaneBuilder.build(null, new SizeInfo(800, 600));
		  StackPane mainPreviewStackpane = new StackPane();
		  mainPreviewStackpane.getChildren().addAll(mainpreviewPanes.values());
		  borderPane.setCenter(mainPreviewStackpane);
		  
		  //Sub Previewpanes, adding a VBox pane per sessionitem
		  Session session = context.getCurrentSession();
		  subpreviewPanes = subPreviewPaneBuilder.build(null, new SizeInfo(400, 300));
		  StackPane pictureGalleryStackPane = new StackPane();
		  
		  
		  for (AbstractSessionItem nextSessionItem : session.getItems()) {
			  List<ISlide> slides = subPreviewPaneBuilder.getContainer().getSlides(nextSessionItem);
			  Collection <Pane> panes = new ArrayList<Pane>();
			  for (ISlide next: slides) {
				Pane nextPane = subpreviewPanes.get(next);
				nextPane.setVisible(true);
			    panes.add(nextPane);
			  }
			  
			  if (slides.size() > 0) {
			    PictureGallery pictureGallery = new PictureGallery(uiSession.getMainStage(), panes, slides.get(0).getSize().getWidthAsInt());
			    pictureGalleries.put(nextSessionItem, pictureGallery);
			    pictureGalleryStackPane.getChildren().add(pictureGallery);
			  }
			  
		  }
		  pictureGalleryStackPane.setVisible(true);
		  
		  borderPane.setBottom(pictureGalleryStackPane);
		  BorderPane.setAlignment(pictureGalleryStackPane, Pos.CENTER_LEFT);
		  
		  

		  
		  context.registerController(keycontroller);
		  stage.addEventHandler(KeyEvent.KEY_PRESSED, keycontroller );
		  
		  
		  
		  context.registerController(defaultcontroller);
		  
		  stage.show();
		  
		  refresh();
		  
	}


	@Override
	public void end() {
		context.deregisterController(keycontroller.getClass());
		context.deregisterController(defaultcontroller.getClass());
		context.deregisterView(getClass());
		
	}


	@Override
	public void refresh() {
		
		ISlide currentPresentationSlide = context.getCurrentSlide();
		int indexOfCurrentSlide = context.getCurrentSlideIndex();
		AbstractSessionItem currentSessionItem = context.getCurrentSessionItem();
		
		//set current mainpreview visible
		for (ISlide nextSlide: mainpreviewPanes.keySet()) {
			Pane pane = mainpreviewPanes.get(nextSlide);
			boolean currentSlide = currentPresentationSlide.equals(nextSlide);
			pane.setVisible(currentSlide);
		}
		
		//set current tilepane visible
		PictureGallery currentTilePane = pictureGalleries.get(currentSessionItem);
		currentTilePane.setCurrentPicture (indexOfCurrentSlide);
		for (PictureGallery nextGallery : pictureGalleries.values()) {
			boolean isCurrentTilePane = (nextGallery == currentTilePane);
			nextGallery.setVisible(isCurrentTilePane);
		}
		
//		//set all opacities of non current items of current tilepane darker 
//		for (Slide nextSlide: subPreviewPaneBuilder.getContainer().getSlides(currentSessionItem)) {
//			Pane pane = subpreviewPanes.get(nextSlide);
//			
//			boolean currentSlide = currentPresentationSlide.equals(nextSlide);
//			if (currentSlide)
//			  pane.setOpacity(1.0);
//			else
//			  pane.setOpacity(0.5);
//		}
		
		
	}


	@Override
	public boolean isFocused() {
		return false;
	}

	

}
