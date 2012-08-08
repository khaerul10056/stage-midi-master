package org.mda.commons.ui.find;

import java.util.List;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.mda.ApplicationSession;
import org.mda.commons.ui.ContentProvider;
import org.mda.commons.ui.LabelProvider;
import org.mda.find.SearchEngine;
import org.mda.find.SearchResult;

@Creatable
public class SearchEnginePanel  {
	
	@Inject
	private ApplicationSession appsession;
	
	@Inject
	private SearchEngine searchengine;

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
		shell = new Shell (Display.getCurrent().getActiveShell(), SWT.NO_TRIM | SWT.ON_TOP);
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
			  public void keyReleased(KeyEvent e) {
				  
				  if (e.character == SWT.ESC) {
					  shell.dispose();
				  }
				  
				  if (e.keyCode == SWT.ARROW_DOWN) {
					  treModel.setFocus();					  
				  }
				  else {
					  List<SearchResult> find = searchengine.find(txt.getText(), appsession.getCurrentModel());
					  treviewer.setInput(find);
				  }
			  }
		  });
		
		treModel.addKeyListener(new KeyAdapter () {
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
