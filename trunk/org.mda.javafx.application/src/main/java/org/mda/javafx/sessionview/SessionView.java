package org.mda.javafx.sessionview;

import java.util.Set;

import javafx.collections.FXCollections;
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
import javafx.scene.text.Text;
import javafx.util.Callback;
import mda.AbstractSessionItem;
import mda.Song;

import org.mda.ApplicationSession;
import org.mda.javafx.api.ISessionViewAction;
import org.mda.javafx.application.AbstractSessionItemListCell;
import org.mda.javafx.application.MdaJavaFXApp;
import org.mda.javafx.common.ActionPane;

import com.google.inject.Inject;

public class SessionView  {

	private TitledPane pane;
	
	@Inject
	private ApplicationSession appSession;
	
	@Inject
	private Set<ISessionViewAction>  sessionActions;
	
	private ListView <AbstractSessionItem> lvSessionItems;
	
	@Inject
	private SessionActionHover hover;
	
	private MdaJavaFXApp main;
	
	
	public void activate () {
		System.out.println ("SessionView activated");
		pane.setExpanded(true);
		lvSessionItems.requestFocus();
        lvSessionItems.getSelectionModel().select(0);
	}
	
	public void build (final MdaJavaFXApp main) {
	  this.main = main;
	BorderPane content = new BorderPane();
	  
      lvSessionItems = new ListView<AbstractSessionItem>();
      lvSessionItems.setMinWidth(600);
      lvSessionItems.setMaxWidth(600);
      content.setLeft(lvSessionItems);
      content.setCenter(new Text ("Song"));
      
      ActionPane actionPane = new ActionPane();
      actionPane.addActions(sessionActions);
      content.setTop(actionPane.getPane());
      
	  pane = new TitledPane("Session", content);
	  BorderPane.setMargin(lvSessionItems, new Insets(10, 10, 20, 10));
	  lvSessionItems.setCellFactory(new Callback<ListView<AbstractSessionItem>, ListCell<AbstractSessionItem>>() {
          @Override 
          public ListCell<AbstractSessionItem> call(ListView<AbstractSessionItem> list) {
              return new AbstractSessionItemListCell();
          }
      });
	  
	  lvSessionItems.setOnKeyPressed(new EventHandler<KeyEvent> () {

		@Override
		public void handle(KeyEvent arg0) {
			System.out.println ("Key pressed: " + arg0.getText());
			arg0.consume();
			
			
			if (arg0.getCode().equals(KeyCode.ENTER)) {
				stepToSong();
			}
			
			if (lvSessionItems.getSelectionModel().isSelected(0) && arg0.getCode().equals(KeyCode.UP)) {
				main.getModelView().activate();
			}
			
			if (arg0.getText().equals("+")) {
				hover.create(get());
			}
			
			
		}
		  
	  });
	  
	  
	  lvSessionItems.setOnMouseClicked(new EventHandler<MouseEvent>() {
		    @Override
		    public void handle(MouseEvent mouseEvent) {
		    	if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
		            if(mouseEvent.getClickCount() == 2){
		                stepToSong();
		            }
		        }
		    }
		});
	}
	
	private SessionView get () {
		return this;
	}
	
	public AbstractSessionItem getSelectedSessionItem () {
		return lvSessionItems.getSelectionModel().getSelectedItem();
	}
	
	
	public void stepToSong () {
		pane.setExpanded(false);
        appSession.setCurrentMidifile((Song) lvSessionItems.getSelectionModel().getSelectedItem());
        main.getSongView().activate();
		
	}
	
	public void refresh (final boolean withFocus) {
		if (appSession.getCurrentSession() != null) {
		  pane.setText("Session - " + appSession.getCurrentSession().getName());
		  lvSessionItems.setItems(FXCollections.observableArrayList(appSession.getCurrentSession().getItems()));
		}
		else {
		  pane.setText("Session");
		}
	}

	public TitledPane getPane() {
		return pane;
	}
	 

}
