package org.mda.javafx.presenter.javafx;


import java.util.HashMap;
import java.util.List;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.GridPaneBuilder;
import javafx.scene.layout.Pane;
import javafx.scene.layout.PaneBuilder;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CircleBuilder;
import javafx.scene.text.Text;
import javafx.scene.text.TextBuilder;
import javafx.stage.Stage;
import mda.Session;

import org.mda.ApplicationSession;
import org.mda.inject.InjectService;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.presenter.CalculatorPreCondition;
import org.mda.presenter.MidiFileSlideCalculator;
import org.mda.presenter.Slide;
import org.mda.presenter.SlideItem;
import org.mda.presenter.adapter.Size;
import org.mda.presenter.config.IMidiFilePresenterConfig;
import org.mda.presenter.config.PresentationConfigurator;
import org.mda.presenter.config.PresentationType;
import org.mda.presenter.ui.slide.IPresentationView;

import com.google.inject.Inject;

public class BeamerPresenter implements IPresentationView {
	
	private static final Log LOGGER  = LogFactory.getLogger(BeamerPresenter.class);
	
//	@Inject
//	private MonitorManager monitormanager;
	
	@Inject
	MidiFileSlideCalculator calculator;
	
	
	@Inject
	ApplicationSession applicationSession;
	
	private Size size = new Size (800,600);
	
    private HashMap<Slide, Pane> panesPerSlide = new HashMap<Slide, Pane>();
	
	
	@Override
	public void end() {
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void refresh() {
		
		//panesPerSlide.values().iterator().next().setVisible(true);
        
		
	}

	public void build(Session currentSession, boolean onTop) {
		
		
		
		CalculatorPreCondition calcPreCondition = new CalculatorPreCondition();
		calcPreCondition.setCalculationsize(size);
		
		PresentationConfigurator configurator = new PresentationConfigurator();
	    IMidiFilePresenterConfig config = configurator.configure(null, applicationSession.getCurrentModel(), PresentationType.SCREEN);
	    InjectService.injectObject(config); //TODO make it better
		
		calculator.setConfig(config);
		
		StackPane stackpane = new StackPane();
		Stage presentationStage = new Stage();
		presentationStage.setScene(new Scene (stackpane));
		
	    List<Slide> calculate = calculator.calculate(currentSession, calcPreCondition);
		
		for (Slide nextSlide: calculate) {
			
			Pane nextPane = PaneBuilder.create().build();
			
			for (SlideItem slideItem : nextSlide.getItems()) {
				
				Text text = TextBuilder.create().text(slideItem.getText()).x(slideItem.getX()).y(slideItem.getY()).build();
				nextPane.getChildren().add(text);
				LOGGER.info("Create text <" + text.getText() + " on " + text.getX() + "-" + text.getY());
			}
			
			stackpane.getChildren().add(nextPane);
			panesPerSlide.put(nextSlide, nextPane);
			
		}

		panesPerSlide.values().iterator().next().setVisible(true);
		presentationStage.show();
		
	}

}
