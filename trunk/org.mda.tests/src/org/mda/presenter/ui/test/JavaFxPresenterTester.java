package org.mda.presenter.ui.test;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import mda.MidiPlayerRoot;
import mda.Session;

import org.mda.ApplicationSession;
import org.mda.presenter.adapter.Size;

public class JavaFxPresenterTester extends Application {

	

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("BeamerPresenterTester");
		primaryStage.setFullScreen(false);
		primaryStage.setWidth(400); 
		primaryStage.setHeight(200);
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

		ApplicationSession appsession = new ApplicationSession();
		appsession.load(null);

		final MidiPlayerRoot playerroot = appsession.getCurrentModel();
		
		ObservableList<Session> sessions = FXCollections.observableArrayList(playerroot.getSessions());

		final ComboBox cmbSession = new ComboBox(sessions);
		grid.add(new Label ("Session: "), 0, 0);
		grid.add(cmbSession, 0, 1);
		
		final CheckBox chkWithChords = new CheckBox("Show chords");
		grid.add(chkWithChords, 0, 1);
		
		final CheckBox chkWithBackground = new CheckBox("Show background");
		grid.add(chkWithBackground, 0, 2);

		final CheckBox chkWithBlocktypes = new CheckBox("Show blocktypes");
		grid.add(chkWithBlocktypes, 0, 3);
		
		final ComboBox cmbSize = new ComboBox(sizes);
		grid.add(cmbSize, 0, 4);
		
		
		final Button btnOK = new Button("Show");
		btnOK.setText("Show");
		grid.add(btnOK, 0, 5);
		
		primaryStage.setScene(new Scene(grid, 300, 250));
		
//		btnOK.addSelectionListener(new SelectionAdapter() {
//
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//
//				Point size = sizes.get(cmbSize.getSelectionIndex());
//				Session currentSession = root.getSessions().get(
//						cmbSession.getSelectionIndex());
//
//				DefaultMidiFileContentEditorConfig config = new DefaultMidiFileContentEditorConfig();
//				config.setShowChords(chkWithChords.getSelection());
//				config.setShowBackground(chkWithBackground.getSelection());
//				config.setShowBlockType(chkWithBlocktypes.getSelection());
//
//				PresentationContext presentationContext = new PresentationContext();
//				presentationContext.setCurrentSession(currentSession, config,
//						size);
//
//				final GlobalKeyRegistryPresentationController globalKeyRegPresentationController = new GlobalKeyRegistryPresentationController();
//				presentationContext
//						.registerController(globalKeyRegPresentationController);
//
//				BeamerPresenter beamerPresenter = new BeamerPresenter();
//				beamerPresenter.build(Display.getCurrent(), currentSession,false);
//				presentationContext.registerController(globalKeyRegPresentationController);
//				presentationContext.registerView(beamerPresenter);
//
//				beamerPresenter.getShell().addDisposeListener(
//						new DisposeListener() {
//
//							@Override
//							public void widgetDisposed(DisposeEvent arg0) {
//								globalKeyRegPresentationController.close();
//							}
//						});
//
//				btnOK.setFocus();
//			}
//		});
		
		primaryStage.show();
		
		

				
	}

	
	public static void main(String[] args) throws Exception {
		launch(args);
	}

	

}
