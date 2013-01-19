package org.mda.javafx.prototype;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.MenuItemBuilder;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextBuilder;
import javafx.stage.Stage;

import com.sun.javafx.tk.FontMetrics;
import com.sun.javafx.tk.Toolkit;

/**
 *
 */
public class HelloJavaFXWorld extends Application
{

	public ToolBar createToolbar () {
		Button btnRun = new Button("Run");
		ToolBar toolbar = new ToolBar();
		toolbar.getItems().add(btnRun);
		return toolbar;
	}
    @Override
    public void start(final Stage stage) throws Exception
    {

    	MenuBar menubar = new MenuBar();
    	Menu mnuGlobal = new Menu("Global");
    	Text text = new Text ("Hello");
    	FontMetrics fontMetrics = Toolkit.getToolkit().getFontLoader().getFontMetrics(text.getFont());
    	fontMetrics.computeStringWidth("Hello");
    	fontMetrics.getMaxAscent();
    	
    	
    	

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

        Pane drecksPane = new Pane();
        Font font = new Font ("Arial", 48);
        for (int i = 0; i< 100; i++) {
          Text normalText = TextBuilder.create().text("Wasn des fuern Zeuch").font(font).build();
          normalText.setLayoutX(20); 
          normalText.setLayoutY(40 * i);
          drecksPane.getChildren().add(normalText);
        }
        
        final Scene scene = new Scene(drecksPane, 800, 400, Color.CORNSILK);

        stage.setTitle("HelloWorld in JavaFX 2.0");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        Application.launch(args);
    }
}