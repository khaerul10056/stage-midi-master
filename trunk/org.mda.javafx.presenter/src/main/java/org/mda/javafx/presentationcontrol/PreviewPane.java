package org.mda.javafx.presentationcontrol;

import java.util.HashMap;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.PaneBuilder;
import javafx.scene.text.Font;
import javafx.scene.text.FontBuilder;
import javafx.scene.text.Text;
import javafx.scene.text.TextBuilder;

import org.mda.ApplicationSession;
import org.mda.javafx.imagecache.ImageCache;
import org.mda.javafx.presenter.BackgroundImageResolver;
import org.mda.javafx.presenter.ColorResolver;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.measurement.AreaInfo;
import org.mda.measurement.SizeInfo;
import org.mda.presenter.CalculationParam;
import org.mda.presenter.ISlide;
import org.mda.presenter.PresentationContext;
import org.mda.presenter.SessionSlideCalculator;
import org.mda.presenter.Slide;
import org.mda.presenter.SlideContainer;
import org.mda.presenter.SlideItem;
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
	private SessionSlideCalculator calculator;
	
	
	@Inject
	private ColorResolver colorResolver;
	
	@Inject
	private BackgroundImageResolver backgroundImageResolver;

	private SlideContainer container;
	
	@Inject
	private ImageCache imageCache;
	
	
	private void addStyle (final Pane pane, final ISlide slide, AreaInfo beamerpresenterBounds) {
		if (slide.getBackgroundImageFile() != null) {
			ImageView imageView = new ImageView(imageCache.getImage(slide.getBackgroundImageFile(), beamerpresenterBounds.getSize()));
			imageView.setFitWidth(beamerpresenterBounds.getWidth());
			imageView.setFitHeight(beamerpresenterBounds.getHeight());
			//imageView.setPreserveRatio(true);
			imageView.setSmooth(true);
			imageView.setCache(true);
			pane.getChildren().add(imageView);
		}
		else if (slide.getBackgroundColor() != null)
		  pane.setStyle(colorResolver.getBackground (slide.getBackgroundColor()));
		pane.setVisible(false);
	}
	
	public HashMap<ISlide, Pane> build (final Slide slide, final SizeInfo sizeinfo) {
		
		CalculationParam calcParam = new CalculationParam(new AreaInfo (0,0, sizeinfo));
		
		PresentationConfigurator configurator = new PresentationConfigurator();
	    DefaultPresenterConfig config = (DefaultPresenterConfig) configurator.configure(null, appsession.getCurrentModel(), PresentationType.SCREEN);
	    
	    setContainer(calculator.calculate(context.getCurrentSession(), calcParam, config));
	    
	    HashMap <ISlide, Pane> allPanes = new HashMap<ISlide, Pane>();
	    for (ISlide nextSlide : getContainer().getSlides()) {
	    	
	    	Pane nextPane = PaneBuilder.create().build();
			nextPane.setPrefSize(sizeinfo.getWidth(),  sizeinfo.getHeight());
			nextPane.setMinSize(sizeinfo.getWidth(), sizeinfo.getHeight());
			nextPane.setMaxSize(sizeinfo.getWidth(), sizeinfo.getHeight());
			
			addStyle(nextPane, nextSlide, calcParam.getPresentationBounds());
			
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

	public SlideContainer getContainer() {
		return container;
	}

	private void setContainer(SlideContainer container) {
		this.container = container;
	}
	
}
