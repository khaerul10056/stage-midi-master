package org.mda.presenter.ui.test;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import mda.MidiPlayerRoot;
import mda.Session;

import org.eclipse.swt.graphics.Point;
import org.mda.ApplicationSession;
import org.mda.commons.ui.DefaultMidiFileContentEditorConfig;
import org.mda.inject.InjectService;
import org.mda.inject.InjectServiceMock;
import org.mda.javafx.presenter.javafx.BeamerPresenter;
import org.mda.presenter.PresentationContext;
import org.mda.presenter.adapter.Size;
import org.mda.presenter.config.DefaultMidiFilePresenterConfig;
import org.mda.presenter.ui.slide.GlobalKeyRegistryPresentationController;

public class JavaFxPresenterTester extends Application {

	

	@Override
	public void start(Stage primaryStage) throws Exception {
		InjectServiceMock.initialize();
		primaryStage.setTitle("BeamerPresenterTester");
		primaryStage.setFullScreen(false);
		primaryStage.setWidth(800); 
		primaryStage.setHeight(300);
		ObservableList<Size> sizes = FXCollections.observableArrayList(
		  new Size(1400, 1050), 
		  new Size(1280, 900),
		  new Size(1152, 864),
		  new Size(1024, 768),
		  new Size(800, 600)
		);
		
		GridPane grid = new GridPane();
		 grid.setHgap(10);
		    grid.setVgap(10);
		    grid.setPadding(new Insets(0, 10, 0, 10));

		ApplicationSession appsession = InjectService.getInstance(ApplicationSession.class);
		appsession.load(null);

		final MidiPlayerRoot playerroot = appsession.getCurrentModel();
		
		ObservableList<Session> sessions = FXCollections.observableArrayList(playerroot.getSessions());

		final ComboBox<Session> cmbSession = new ComboBox<Session>(sessions);
		grid.add(new Label ("Session: "), 0, 0);
		grid.add(cmbSession, 1, 0);
		cmbSession.setValue(sessions.get(0));
		
		final CheckBox chkWithChords = new CheckBox();
		grid.add(new Label ("Show chords: "), 0, 1);
		grid.add(chkWithChords, 1, 1);
		
		final CheckBox chkWithBackground = new CheckBox();
		grid.add(new Label ("Show background: "), 0, 2);
		grid.add(chkWithBackground, 1, 2);

		final CheckBox chkWithBlocktypes = new CheckBox();
		grid.add(new Label ("Show blocktypes: "), 0, 3);
		grid.add(chkWithBlocktypes, 1, 3);
		
		final ComboBox<Size> cmbSize = new ComboBox<Size>(sizes);
		cmbSize.setValue(sizes.get(0));
		grid.add(new Label ("Size: "), 0, 4);
		grid.add(cmbSize, 1, 4);
		
		
		final Button btnOK = new Button("Show");
		btnOK.setText("Show");
		grid.add(btnOK, 0, 5);
		
		primaryStage.setScene(new Scene(grid, 300, 250));
		
		btnOK.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Size size = (Size) cmbSize.getSelectionModel().getSelectedItem();
                Session currentSession = (Session) cmbSession.getSelectionModel().getSelectedItem();
                
				DefaultMidiFilePresenterConfig config = InjectService.getInstance(DefaultMidiFilePresenterConfig.class);
				config.setShowChords(chkWithChords.isSelected());
				config.setShowBackground(chkWithBackground.isSelected());
				config.setShowBlockType(chkWithBlocktypes.isSelected());

				PresentationContext presentationContext = InjectService.getInstance(PresentationContext.class);
				presentationContext.setCurrentSession(currentSession, config, size);

				final GlobalKeyRegistryPresentationController globalKeyRegPresentationController = new GlobalKeyRegistryPresentationController();
				presentationContext.registerController(globalKeyRegPresentationController);

				BeamerPresenter beamerPresenter = InjectService.getInstance(BeamerPresenter.class);
				beamerPresenter.build(currentSession,false);
//				presentationContext.registerController(globalKeyRegPresentationController);
//				presentationContext.registerView(beamerPresenter);
				
				
				

//				beamerPresenter.getShell().addDisposeListener(
//						new DisposeListener() {
//
//							@Override
//							public void widgetDisposed(DisposeEvent arg0) {
//								globalKeyRegPresentationController.close();
//							}
//						});


            }
        });
		
		
		primaryStage.show();
		
		

				
	}

	
	public static void main(String[] args) throws Exception {
		launch(args);
	}

	

}
