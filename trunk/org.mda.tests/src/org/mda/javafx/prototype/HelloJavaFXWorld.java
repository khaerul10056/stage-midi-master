package org.mda.javafx.prototype;

import java.net.URL;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.MenuItemBuilder;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


import org.mda.ApplicationSession;
import org.mda.inject.InjectService;
import org.mda.inject.InjectServiceMock;

import com.google.inject.Inject;

/**
 *
 */
public class HelloJavaFXWorld extends Application
{
	
	@Inject
	public ApplicationSession appSession;
	
	
    @Inject
	private ModelView modelview;
    
    @Inject
	private SessionView sessionView;
    
    @Inject
	private SongView songview;
	
	
	public ModelView getModelView () {
		return modelview;
	}
	
	public SessionView getSessionView () {
		return sessionView;
	}
	
	public SongView getSongView () {
		return songview;
	}



	public ToolBar createToolbar () {
		Button btnRun = new Button("Run");
		ToolBar toolbar = new ToolBar();
		toolbar.getItems().add(btnRun);
		return toolbar;
	}
    @Override
    public void start(final Stage stage) throws Exception
    {
    	
    	InjectServiceMock.initialize();
    	InjectService.injectObject(this);
    	
    	
    	appSession.load(null);

    	MenuBar menubar = new MenuBar();
    	Menu mnuGlobal = new Menu("Global");
    	

    	MenuItem mnuItem = MenuItemBuilder.create().text("Exit").onAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				stage.close();
			}
		}).build();

    	menubar.prefWidthProperty().bind(stage.widthProperty());


    	mnuGlobal.getItems().add(mnuItem);
    	menubar.getMenus().add(mnuGlobal);

        ToolBar toolbar = createToolbar();
        toolbar.prefWidthProperty().bind(stage.widthProperty());
        
        modelview.build(this);
        sessionView.build(this); 
        songview.build(this);
        final Accordion accordion = new Accordion ();
        VBox vbox = new VBox(0); // spacing = 8
        vbox.getChildren().addAll(menubar, toolbar, accordion);
        accordion.getPanes().addAll(modelview.getPane(), sessionView.getPane(), songview.getPane());
        accordion.setExpandedPane(modelview.getPane());
        VBox.setVgrow(accordion, Priority.ALWAYS);
 
        final Scene scene = new Scene(vbox, 800, 400, Color.BLACK);

        stage.setTitle("HelloWorld in JavaFX 2.0");
        URL url = getClass().getResource("/css/default.css");
        scene.getStylesheets().add("css/default.css");
        stage.setScene(scene);
        stage.show();
        
    }
    
    

    public static void main(String[] args)
    {
        Application.launch(args);
    }
}