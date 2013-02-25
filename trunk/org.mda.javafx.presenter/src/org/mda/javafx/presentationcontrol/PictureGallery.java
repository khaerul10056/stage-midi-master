package org.mda.javafx.presentationcontrol;

import java.util.Collection;
import java.util.LinkedList;

import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import org.mda.logging.Log;
import org.mda.logging.LogFactory;

public class PictureGallery extends HBox{
	
	private static final Log LOGGER  = LogFactory.getLogger(PictureGallery.class);

	private LinkedList<Pane> images = new LinkedList<Pane>();

	private int currentPos = 0;

	private int spacing = 10;
	private int picwidth;
	private int containerwidth;
	private int duration = 500;
	
	private boolean animating = false;

	private double getScale(int pos) {
		int offset = Math.abs(pos - currentPos);
		double newScale = 1 - (offset * 0.2);
		System.out.println("getSacle for pos " + pos + "/currentpos = " + currentPos + ": " + newScale);
		return newScale;
	}

	private int getFirstInset() {
		int firstInset = (containerwidth / 2) - (picwidth / 2);
		LOGGER.info("first inset = " + firstInset);
		return firstInset;
	}

	public PictureGallery (final Stage stage, final Collection<Pane> panes, final int picwidth) {
		this.images.addAll(panes);
		containerwidth = stage.widthProperty().intValue();
		this.picwidth = picwidth;
		
		getChildren().addAll(panes);
		
		TranslateTransition tt = new TranslateTransition(Duration.millis(10), this);
		tt.setToX(getFirstInset());
		
		ParallelTransition transition = new ParallelTransition();
		adaptSizeAndOrder(transition, 10);
		transition.getChildren().add(tt);
		transition.play();
	}
	
	public void stepTo(final int index) {
		
		LOGGER.info("set to " + index);

		currentPos = index;

		ParallelTransition parallel = new ParallelTransition();

		TranslateTransition tt = new TranslateTransition(Duration.millis(duration), this);
		tt.setToX(getFirstInset() - (index * (picwidth + spacing)));
		tt.play();
		adaptSizeAndOrder(parallel, duration);
		animating = true;
		parallel.setOnFinished(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				animating = false;
			}
		});
		parallel.play();

	}

	private void adaptSizeAndOrder(ParallelTransition parallel, int duration) {
		for (int i = 0; i < images.size(); i++) {
			Pane nextImageView = images.get(i);
			double newScale = getScale(i);
			ScaleTransition st = new ScaleTransition(Duration.millis(duration),nextImageView);
			st.setToX(newScale);
			st.setToY(newScale);
			parallel.getChildren().add(st);
			
			if (i == currentPos) 
					  nextImageView.setOpacity(1.0);
					else
					  nextImageView.setOpacity(0.5);
			

		}
	}

	public void setCurrentPicture(int indexOfCurrentSlide) {
  	  stepTo(indexOfCurrentSlide); 
	}

}