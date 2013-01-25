package org.mda.javafx.presenter.javafx;


import java.util.HashMap;

import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.SequentialTransitionBuilder;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.PaneBuilder;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineBuilder;
import javafx.scene.text.Font;
import javafx.scene.text.FontBuilder;
import javafx.scene.text.Text;
import javafx.scene.text.TextBuilder;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import mda.Session;

import org.mda.ApplicationSession;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.presenter.IPresentationView;
import org.mda.presenter.PresentationContext;
import org.mda.presenter.Slide;
import org.mda.presenter.SlideItem;
import org.mda.presenter.SpecialSlide;
import org.mda.presenter.adapter.AreaInfo;
import org.mda.presenter.adapter.ColorInfo;
import org.mda.presenter.adapter.SizeInfo;
import org.mda.presenter.config.IMidiFilePresenterConfig;

import com.google.inject.Inject;

public class BeamerPresenter implements IPresentationView {
	
	private static final Log LOGGER  = LogFactory.getLogger(BeamerPresenter.class);
	
	@Inject
	private MonitorManager monitormanager;
	
	@Inject
	PresentationContext presentationContext;
	
	@Inject
	ApplicationSession applicationSession;
	
	@Inject
	ColorResolver colorResolver;
	
	@Inject
	BackgroundImageResolver backgroundImageResolver;
	
	@Inject
	KeyPresentationController keycontroller;
	
	
    private HashMap<Slide, Pane> panesPerSlide = new HashMap<Slide, Pane>();
    private HashMap<SpecialSlide, Pane> specialSlidesPerPane = new HashMap<SpecialSlide, Pane> ();
    private HashMap<Slide, Pane> emptyPanesPerSlide = new HashMap<Slide, Pane>();
	
	private Stage presentationStage;
	
	private Pane currentPane;
	
	
	@Override
	public void end() {
		presentationContext.deregisterController(keycontroller.getClass());
		presentationContext.deregisterView(getClass());
		presentationStage.close();
	}
	
	private void logPane (final Pane pane, final String additionalText) {
		LOGGER.info("Pane      : " + pane.getId());
		LOGGER.info("Context   : " + additionalText);
		LOGGER.info("Opacity   : " + pane.getOpacity());
		LOGGER.info("Visible   : " + pane.isVisible()); 
		LOGGER.info("Managed   : " + pane.isManaged());
	}

	@Override
	public void refresh() {
		LOGGER.info("refresh called");
		Pane nextPane = null;
		Slide nextSlide = presentationContext.getCurrentSlide(); 
		
		if (presentationContext.getSpecialSlide() == SpecialSlide.NONE) {
			nextPane = panesPerSlide.get(nextSlide);
			LOGGER.info("get pane for slide " + nextSlide + ":" + nextPane );
		}
		else {
			if (presentationContext.getSpecialSlide() == SpecialSlide.WITHOUT_TEXT) {
				LOGGER.info("get pane without text for slide " + nextSlide);
				nextPane = emptyPanesPerSlide.get(nextSlide);
			}
			else {
				LOGGER.info("get pane for specialslide " + presentationContext.getSpecialSlide());
				nextPane = specialSlidesPerPane.get(presentationContext.getSpecialSlide());
			}
		}
		
		if  (nextPane != null) {
//		  LOGGER.info("NextPane = " + nextPane.getId());
//		  //TODO animations
//		  
//		  FadeTransition ft1 = new FadeTransition(Duration.millis(700), currentPane);
//		  
//		  final Pane thenext = nextPane; 
//          ft1.setFromValue(1.0);
//          ft1.setToValue(0.0);
//          ft1.setOnFinished(new EventHandler<ActionEvent>() {
//              @Override
//              public void handle(ActionEvent actionEvent) {
//                  currentPane.setVisible(false);
//                  thenext.setVisible(true);
//              }
//          });
//
//          FadeTransition ft2 = new FadeTransition(Duration.millis(700), nextPane);
//          ft2.setFromValue(0.0);
//          ft2.setToValue(1.0);
//          nextPane.setVisible(true);
//          nextPane.setOpacity(0.0);
//          
//          logPane(currentPane, "currentPane"); 
//		  logPane(nextPane, "nextPane");
//          
//          SequentialTransition pt = SequentialTransitionBuilder.create().children(ft1, ft2).build();
//          pt.play();	
			currentPane.setVisible(false);
			currentPane = nextPane;
			nextPane.setVisible(true);
		  
		}
		else
			LOGGER.error("Could not determine nextPane");
		
	}
	
	private void showGrid (Pane stackpane, SizeInfo size) {
        for (int i = 0; i < size.getWidth(); i += 100) {
        	Line line = LineBuilder.create().layoutX(i).layoutY(0).endX(0).endY(size.getHeight()).build();
        	stackpane.getChildren().add(line);
        }

        for (int i = 0; i < size.getHeight(); i += 100) {
          Line line = LineBuilder.create().layoutX(0).layoutY(i).endX(size.getWidth()).endY(0).build();
          stackpane.getChildren().add(line);
        }

      }
	
	private void addBlackSlide (final Stage stage, StackPane stackpane) {
		LOGGER.info("add black slide");
		Pane blackSlide = createPaneInStage(stage);
		blackSlide.setId("blackSlide");
		blackSlide.setStyle(colorResolver.getBackground(ColorInfo.BLACK));
		specialSlidesPerPane.put(SpecialSlide.BLACK, blackSlide);
		stackpane.getChildren().add(blackSlide);
	}
	
	private void addWhiteSlide (final Stage stage, StackPane stackpane) {
		LOGGER.info("add white slide");
		Pane whiteSlide = createPaneInStage(stage);
		whiteSlide.setId("whiteSlide");
		whiteSlide.setStyle(colorResolver.getBackground(ColorInfo.WHITE));
		specialSlidesPerPane.put(SpecialSlide.WHITE, whiteSlide);
		stackpane.getChildren().add(whiteSlide);
	}
	
	private Pane createPaneInStage (final Stage stage) {
		Pane nextPane = PaneBuilder.create().build();
		nextPane.prefHeightProperty().bind(stage.heightProperty());
		nextPane.prefWidthProperty().bind(stage.widthProperty());
		return nextPane;
	}
	
	private void addStyle (final Pane pane, final Slide slide, AreaInfo beamerpresenterBounds) {
		if (slide.getBackgroundImageFile() != null)
			  pane.setStyle(backgroundImageResolver.getBackgroundImageCss(slide.getBackgroundImageFile(), beamerpresenterBounds.getSize()));
			else
			  pane.setStyle(colorResolver.getBackground(slide.getBackgroundColor()));
		pane.setVisible(false);
	}

	public void build(final Session currentSession, boolean onTop, final IMidiFilePresenterConfig config) {
		
		presentationContext.registerView(this);
		presentationContext.setCurrentSession(currentSession, config, config.getDefaultPresentationScreenSize());
		
		StackPane stackpane = new StackPane();
		presentationStage = new Stage();
		presentationStage.initStyle(StageStyle.UNDECORATED);
		
		AreaInfo beamerpresenterBounds = monitormanager.getBeamerOrPreviewBounds();
		presentationStage.setX(beamerpresenterBounds.getX()); 
		presentationStage.setY(beamerpresenterBounds.getY());
		presentationStage.setWidth(beamerpresenterBounds.getWidth()); 
		presentationStage.setHeight(beamerpresenterBounds.getHeight());
		presentationStage.setScene(new Scene (stackpane));
		stackpane.prefHeightProperty().bind(presentationStage.heightProperty());
		stackpane.prefWidthProperty().bind(presentationStage.widthProperty());
		
		addBlackSlide(presentationStage, stackpane);
		addWhiteSlide(presentationStage, stackpane);
		
		currentPane = null;
		
		for (Slide nextSlide: presentationContext.getSlides()) {
			
			Pane nextPane = createPaneInStage(presentationStage);
			nextPane.setId("normal slide for " + nextSlide.toString());
			addStyle(nextPane, nextSlide, beamerpresenterBounds);
			
			Pane emptyPane = createPaneInStage(presentationStage);
			emptyPane.setId("empty slide for " + nextSlide.toString());
			addStyle(emptyPane, nextSlide, beamerpresenterBounds);
		
			if (applicationSession.getFeatureActivation().isShowGridEnabled())
			  showGrid(nextPane, config.getDefaultPresentationScreenSize());
	
			for (SlideItem slideItem : nextSlide.getItems()) {
				Font font = FontBuilder.create().name(slideItem.getFont().getFontname()).size(slideItem.getFont().getFontsizeAsInt()).build();
				Text text = TextBuilder.create().text(slideItem.getText()).font(font).build();
				text.setFill(colorResolver.getFxColor(nextSlide.getForegroundColor()));
				text.prefWidth(slideItem.getWidth());
				text.prefHeight(slideItem.getHeight());
				text.setLayoutX(slideItem.getX());
				text.setLayoutY(slideItem.getY() + slideItem.getHeight());
				
				nextPane.getChildren().add(text);
				LOGGER.info("Create text <" + text.getText() + " on " + text.getX() + "-" + text.getY() + "-Item " + slideItem + "-");
			}
			
			
			
			
			stackpane.getChildren().add(nextPane);
			stackpane.getChildren().add(emptyPane);
			panesPerSlide.put(nextSlide, nextPane);
			emptyPanesPerSlide.put(nextSlide, emptyPane);
			
			if (currentPane == null) 
				currentPane = nextPane;
		}
		
		

		currentPane.setVisible(true);
		
		presentationContext.registerController(keycontroller);
		presentationStage.addEventHandler(KeyEvent.KEY_PRESSED, keycontroller );
		presentationStage.show();
		
		
	
	}

}
