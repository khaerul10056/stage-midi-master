package org.mda.javafx.presenter.javafx;


import java.util.HashMap;

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
import mda.Session;

import org.mda.ApplicationSession;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.presenter.IPresentationView;
import org.mda.presenter.PresentationContext;
import org.mda.presenter.Slide;
import org.mda.presenter.SlideItem;
import org.mda.presenter.adapter.Size;
import org.mda.presenter.config.IMidiFilePresenterConfig;

import com.google.inject.Inject;

public class BeamerPresenter implements IPresentationView {
	
	private static final Log LOGGER  = LogFactory.getLogger(BeamerPresenter.class);
	
//	@Inject
//	private MonitorManager monitormanager;
	
	@Inject
	PresentationContext presentationContext;
	
	@Inject
	ApplicationSession applicationSession;
	
	@Inject
	KeyPresentationController keycontroller;
	
	
    private HashMap<Slide, Pane> panesPerSlide = new HashMap<Slide, Pane>();
	
	private Stage presentationStage;
	
	private Pane currentPane;
	
	
	@Override
	public void end() {
		presentationContext.deregisterController(keycontroller.getClass());
		presentationContext.deregisterView(getClass());
		presentationStage.close();
		
		

		
	}

	@Override
	public void refresh() {
		LOGGER.info("refresh called");
		
		Slide nextSlide = presentationContext.getCurrentSlide(); 
		Pane nextPane = panesPerSlide.get(nextSlide);
		
		//TODO animations
		currentPane.setVisible(false);
		currentPane = nextPane; 
		currentPane.setVisible(true);
		
	}
	
	private void showGrid (Pane stackpane, Size size) {
        for (int i = 0; i < size.getWidth(); i += 100) {
        	Line line = LineBuilder.create().layoutX(i).layoutY(0).endX(0).endY(size.getHeight()).build();
        	stackpane.getChildren().add(line);
        }

        for (int i = 0; i < size.getHeight(); i += 100) {
          Line line = LineBuilder.create().layoutX(0).layoutY(i).endX(size.getWidth()).endY(0).build();
          stackpane.getChildren().add(line);
        }

      }

	public void build(final Session currentSession, boolean onTop, final IMidiFilePresenterConfig config) {
		
		presentationContext.registerView(this);
		presentationContext.setCurrentSession(currentSession, config, config.getDefaultPresentationScreenSize());
		
		StackPane stackpane = new StackPane();
		presentationStage = new Stage();
		presentationStage.initStyle(StageStyle.UNDECORATED);
		presentationStage.setWidth(config.getDefaultPresentationScreenSize().getWidth());
		presentationStage.setHeight(config.getDefaultPresentationScreenSize().getHeight());
		presentationStage.centerOnScreen();
		presentationStage.setScene(new Scene (stackpane));
		stackpane.prefHeightProperty().bind(presentationStage.heightProperty());
		stackpane.prefWidthProperty().bind(presentationStage.widthProperty());
		
		currentPane = null;
		
		for (Slide nextSlide: presentationContext.getSlides()) {
			
			Pane nextPane = PaneBuilder.create().build();
			
			nextPane.prefHeightProperty().bind(presentationStage.heightProperty());
			nextPane.prefWidthProperty().bind(presentationStage.widthProperty());
		
			if (applicationSession.getFeatureActivation().isShowGridEnabled())
			  showGrid(nextPane, config.getDefaultPresentationScreenSize());
	
			for (SlideItem slideItem : nextSlide.getItems()) {
				Font font = FontBuilder.create().name(slideItem.getFont().getFontname()).size(slideItem.getFont().getFontsizeAsInt()).build();
				Text text = TextBuilder.create().text(slideItem.getText()).font(font).build();
				text.prefWidth(slideItem.getWidth());
				text.prefHeight(slideItem.getHeight());
				text.setLayoutX(slideItem.getX());
				text.setLayoutY(slideItem.getY() + slideItem.getHeight());
				
				nextPane.getChildren().add(text);
				LOGGER.info("Create text <" + text.getText() + " on " + text.getX() + "-" + text.getY() + "-Item " + slideItem + "-");
			}
			
			nextPane.setVisible(false);
			
			
			stackpane.getChildren().add(nextPane);
			panesPerSlide.put(nextSlide, nextPane);
			
			if (currentPane == null) 
				currentPane = nextPane;
		}

		currentPane.setVisible(true);
		
		presentationContext.registerController(keycontroller);
		presentationStage.addEventHandler(KeyEvent.KEY_PRESSED, keycontroller );
		presentationStage.show();
		
		
	
	}

}
