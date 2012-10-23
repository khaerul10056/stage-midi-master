package org.mda.commons.ui.find;

import java.util.List;

import javax.inject.Inject;

import mda.MidiFile;
import mda.MidiplayerFactory;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.mda.ApplicationSession;
import org.mda.MidiPlayerService;
import org.mda.commons.ui.ContentProvider;
import org.mda.commons.ui.LabelProvider;
import org.mda.commons.ui.UIHandler;
import org.mda.find.SearchEngine;
import org.mda.find.SearchResult;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;

@Creatable
public class SearchEnginePanel  {
	
	private static final Log LOGGER  = LogFactory.getLogger(SearchEnginePanel.class);
	
	@Inject
	private ApplicationSession appsession;
	
	@Inject
	private SearchEngine searchengine;
	
	@Inject
	UIHandler uihandler;

	private Shell shell;
	
	private SearchResult activeSearchResult;
	
	public Shell getShell () {
		return shell;
	}
	
	public SearchResult getActiveSearchResult () {
		return activeSearchResult;
	}
	
	public Shell build () {
		
		activeSearchResult = null;
		shell = new Shell (Display.getCurrent().getActiveShell(), SWT.NO_TRIM ); //| SWT.ON_TOP);
		shell.setSize(400, 200);
		shell.setLocation(appsession.getUiState().getPositionSearcher().x, appsession.getUiState().getPositionSearcher().y);
		
		shell.setLayout(new GridLayout());
		
		shell.setText("Suche...");
		
		final Text txt = new Text (shell, SWT.NONE);
		txt.setText("Suchtext");
		txt.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		final Tree treModel = new Tree(shell, SWT.NONE);
		treModel.setBackground(shell.getBackground());
	    treModel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
	    final TreeViewer treviewer = new TreeViewer(treModel);
	    treviewer.setContentProvider(new ContentProvider());
	    treviewer.setLabelProvider(new LabelProvider());
		
		txt.addKeyListener(new KeyAdapter() {
			  @Override
			public void keyReleased(KeyEvent e) {
				  
				  if (e.character == SWT.ESC) {
					  shell.dispose();
				  }
				  
				  if (e.keyCode == SWT.CR || e.keyCode == SWT.ARROW_DOWN) {
					  if (treModel.getItemCount() == 0) {
						  LOGGER.info("Calling creation of new song, " + treModel.getItemCount());
						  int style = SWT.ICON_INFORMATION |SWT.NO | SWT.YES;
							String text = "No song found with title '" + txt.getText() + "'. Do you want to create own?";
							int messageBoxResult = uihandler.showMessageBox(shell, style, text);
							
							if (messageBoxResult == SWT.YES) {
								System.out.println("Yes pressed");
								MidiFile createSong = MidiPlayerService.createSong(appsession.getCurrentModel(), txt.getText());
								activeSearchResult = new SearchResult(createSong.eClass(), createSong, txt.getText());
								shell.dispose();
							}
					  }
					  else {
						LOGGER.info("Calling creation of new song, " + treModel.getItemCount());
						treModel.setFocus();
					  }
					  
				  } else {
					  List<SearchResult> find = searchengine.find(txt.getText(), appsession.getCurrentModel());
					  treviewer.setInput(find);
				  }
			  }
		  });
		
		treModel.addKeyListener(new KeyAdapter () {
			 @Override
			public void keyReleased(KeyEvent e) {
				  if (e.character == SWT.CR) {
					  IStructuredSelection selection = (IStructuredSelection) treviewer.getSelection();
					  activeSearchResult = (SearchResult) selection.getFirstElement();
					  shell.dispose();
				  }
			 }
		});
		
		shell.setVisible(true);
		shell.forceActive();
		txt.setFocus();
		txt.selectAll();
		
		return shell;
	}

}
