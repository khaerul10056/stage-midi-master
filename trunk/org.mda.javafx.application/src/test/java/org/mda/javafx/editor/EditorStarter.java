package org.mda.javafx.editor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import mda.Song;
import mda.SongPartType;

import org.mda.test.SongCreator;

import com.sun.javafx.font.PrismFontLoader;
import com.sun.javafx.tk.FontLoader;

public class EditorStarter extends Application{
	
	public static void main(String[] args) {
        launch(args);
    }
	
	public Song createSong () {
		SongCreator creator = SongCreator.create();
		creator = creator.part(SongPartType.VERS); 
		creator = creator.line().chordAndText("D", "This is a test ").chordAndText("G", "and you test the editor currently.");
		creator = creator.line().chordAndText("D", "Second line 12 ").chordAndText("F", "should have the same length as one");
		
		return creator.get();
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		FontLoader fl = new PrismFontLoader(); 
		for (String next: fl.getFontNames()) {
			
			
			System.out.println ("Fontloade " + next);
		}
			
		
		
		
		 SongEditorPane pane = new SongEditorPane();
		
		 VBox vbox = new VBox(0); // spacing = 8
	     vbox.getChildren().add(pane);
	        
	     VBox.setVgrow(pane, Priority.ALWAYS);
		
        Scene scene = new Scene(vbox, 1400, 800, Color.WHITE);
        String cssUrl = getClass().getClassLoader().getResource("css/default.css").toExternalForm();
        scene.getStylesheets().add(cssUrl);

		stage.setTitle("MDA");
        stage.setScene(scene);
        
        
        
        pane.setEditContent(createSong().getParts().get(0));
    	

        stage.show();
	}

}
