package org.mda.javafx.presentationcontrol;

import java.util.HashMap;

import javafx.scene.layout.Pane;
import javafx.scene.layout.PaneBuilder;
import javafx.scene.text.Font;
import javafx.scene.text.FontBuilder;
import javafx.scene.text.Text;
import javafx.scene.text.TextBuilder;

import org.mda.ApplicationSession;
import org.mda.javafx.presenter.ColorResolver;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.presenter.CalculationParam;
import org.mda.presenter.PresentationContext;
import org.mda.presenter.Slide;
import org.mda.presenter.SlideContainer;
import org.mda.presenter.SlideItem;
import org.mda.presenter.SongSlideCalculator;
import org.mda.presenter.adapter.AreaInfo;
import org.mda.presenter.adapter.SizeInfo;
import org.mda.presenter.config.DefaultPresenterConfig;
import org.mda.presenter.config.PresentationConfigurator;
import org.mda.presenter.config.PresentationType;

import com.google.inject.Inject;

public class PreviewPane {
	
	private static final Log LOGGER  = LogFactory.getLogger(PreviewPane.class);

	@Inject
	private PresentationContext context;
	
	@Inject
	private ApplicationSession appsession;
	
	@Inject
	private SongSlideCalculator calculator;
	
	
	@Inject
	private ColorResolver colorResolver;
	
	
	public HashMap<Slide, Pane> build (final Slide slide, final SizeInfo sizeinfo) {
		
		CalculationParam calcParam = new CalculationParam(new AreaInfo (0,0, sizeinfo));
		
		PresentationConfigurator configurator = new PresentationConfigurator();
	    DefaultPresenterConfig config = (DefaultPresenterConfig) configurator.configure(null, appsession.getCurrentModel(), PresentationType.SCREEN);
	    
	    SlideContainer container = calculator.calculate(context.getCurrentSession(), calcParam, config);
	    
	    HashMap <Slide, Pane> allPanes = new HashMap<Slide, Pane>();
	    for (Slide nextSlide : container.getSlides()) {
	    	
	    	Pane nextPane = PaneBuilder.create().build();
			nextPane.setPrefSize(sizeinfo.getWidth(),  sizeinfo.getHeight());
			
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
	    	
	    	allPanes.put(nextSlide, nextPane);
	    }
	    
		context.getCurrentSession();
		
		
		return allPanes;
	}
	
	public void refresh () {
		
		
	}
	
}
