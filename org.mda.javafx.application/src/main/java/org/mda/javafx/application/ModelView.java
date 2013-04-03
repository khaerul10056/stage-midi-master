package org.mda.javafx.application;


import java.util.Set;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import mda.Session;

import org.mda.ApplicationSession;
import org.mda.javafx.api.IModelViewAction;
import org.mda.javafx.common.ActionPane;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;

import com.google.inject.Inject;


public class ModelView {
	
	private static final Log LOGGER = LogFactory.getLogger(ModelView.class);


	@Inject
	public ApplicationSession appSession;

	private TitledPane pane;
	
	@Inject
	private Set<IModelViewAction>  modelActions;

	private ListView <Session> lvFavourites;

	private MdaJavaFXApp main;

	public void build (final MdaJavaFXApp main) {
	  this.main = main;
	BorderPane content = new BorderPane();
      ObservableList<Session> favourites = FXCollections.observableArrayList(appSession.getCurrentModel().getSessions());
      lvFavourites = new ListView<Session>(favourites);
      lvFavourites.setMaxHeight(200);
      lvFavourites.setMaxWidth(600);
      BorderPane.setMargin(lvFavourites, new Insets(10, 10, 10, 10));
      
      ActionPane actionPane = new ActionPane();
      LOGGER.info("Add " + modelActions.size() + " modelActions");
      actionPane.addActions(modelActions);
      content.setTop(actionPane.getPane());
      
      content.setCenter(lvFavourites);
      
      
	  pane = new TitledPane("Client", content);
	  lvFavourites.setCellFactory(new Callback<ListView<Session>, ListCell<Session>>() {
          @Override 
          public ListCell<Session> call(ListView<Session> list) {
              return new SessionListCell();
          }
      });
	  
	  lvFavourites.setOnMouseClicked(new EventHandler<MouseEvent>() {
		    @Override
		    public void handle(MouseEvent mouseEvent) {
		    	if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
		            if(mouseEvent.getClickCount() == 2){
		                stepToSession();
		            }
		        }
		    }
		});
	  
	  lvFavourites.setOnKeyPressed(new EventHandler<KeyEvent>() {

		@Override
		public void handle(KeyEvent arg0) {
			arg0.consume();

			if (arg0.getCode().equals(KeyCode.ENTER))
					stepToSession();
		}
	});
	  
	  
	  
  
	}
	
	public void activate () {
		
		System.out.println ("ModelView activated");
		pane.setExpanded(true);
		lvFavourites.requestFocus(); 
		lvFavourites.getSelectionModel().select(0);
	}
	
	public void stepToSession () {
		appSession.setCurrentSession(lvFavourites.getSelectionModel().getSelectedItem());
        
        main.getSessionView().refresh(true);
        main.getSongView().refresh(false);
        main.getSessionView().activate();
	}

	public TitledPane getPane() {
		return pane;
	}

}
