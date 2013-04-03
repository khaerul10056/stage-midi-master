package org.mda.javafx.application;

import java.io.IOException;
import java.util.List;

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
import javafx.stage.StageStyle;

import org.mda.ApplicationSession;
import org.mda.inject.InjectService;
import org.mda.javafx.autoconfig.AutomaticPluginConfigurator;
import org.mda.javafx.common.MonitorManager;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.plugins.PluginInfo;
import org.mda.plugins.PluginManager;

import com.google.inject.Inject;

public class MdaJavaFXApp extends Application {
	
	private static final Log LOGGER = LogFactory.getLogger(MdaJavaFXApp.class);


	@Inject
	public ApplicationSession appSession;
	
	@Inject
    private UISession uiSession;
	
    @Inject
	private ModelView modelview;
    
    @Inject
	private SessionView sessionView;
    
    @Inject
	private SongView songview;
    
    @Inject
    private AutomaticPluginConfigurator configurator;
    
    @Inject
	private MonitorManager monitormanager;

	private Scene scene;
	
	
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
	
	public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(final Stage stage) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
    	try {
    	
    	PluginManager manager = new PluginManager(); 
    	List<PluginInfo> plugins = manager.loadPlugins();
    	
    	InjectService.injectObject(this);
        
    	
    	
    	configurator.configure(plugins);	//load icons in icon registry, i18n, css and so on
    	
    	appSession.load(null);
    	
    	
    	LOGGER.info("Monitormanager Enviroment: "); 
    	LOGGER.info(monitormanager.toString());
    	

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
 
        scene = new Scene(vbox, 1400, 800, Color.BLACK);
        
        
        
        uiSession.setMainStage(stage);

        stage.setTitle("MDA");
        stage.initStyle(StageStyle.UNDECORATED);
        String cssUrl = getClass().getClassLoader().getResource("css/default.css").toExternalForm();
        scene.getStylesheets().add(cssUrl);
        stage.setScene(scene);
    	stage.setFullScreen(appSession.getFeatureActivation().isPresentationAlwaysOnTop());
   		//monitormanager.layoutToPrimaryMonitorBounds(stage);

        stage.show();
        
        modelview.activate();
        
        
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
            
    	} catch (Exception e) {
    		LOGGER.error(e.toString(), e);
    	}
    }
	
	public Scene getScene () {
		return scene;
	}

	

}
