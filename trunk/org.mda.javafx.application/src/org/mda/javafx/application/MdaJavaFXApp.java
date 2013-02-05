package org.mda.javafx.application;

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
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import org.eclipse.equinox.app.IApplicationContext;
import org.mda.ApplicationSession;
import org.mda.inject.InjectService;

import at.bestsolution.efxclipse.runtime.application.AbstractJFXApplication;

import com.google.inject.Inject;

public class MdaJavaFXApp extends AbstractJFXApplication {

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
	protected void jfxStart(IApplicationContext arg0, Application app, final Stage stage) {
		
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
        vbox.getChildren().addAll(//menubar, //toolbar, 
        							accordion);
        accordion.getPanes().addAll(modelview.getPane(), sessionView.getPane(), songview.getPane());
        accordion.setExpandedPane(modelview.getPane());
        VBox.setVgrow(accordion, Priority.ALWAYS);
 
        final Scene scene = new Scene(vbox, 800, 400, Color.BLACK);

        stage.setTitle("MDA");
        String cssUrl = getClass().getClassLoader().getResource("css/default.css").toExternalForm();
        scene.getStylesheets().add(cssUrl);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
        
        
            final EventHandler<KeyEvent> keyEventHandler =
                new EventHandler<KeyEvent>() {
                    public void handle(final KeyEvent keyEvent) {
                        if (keyEvent.getText().equals("+")) {
                        	keyEvent.consume();
                        }
                    }
                };
         
            scene.setOnKeyPressed(keyEventHandler);
            scene.setOnKeyReleased(keyEventHandler);
    }

	

}
