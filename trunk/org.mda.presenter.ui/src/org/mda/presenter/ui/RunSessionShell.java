package org.mda.presenter.ui;

import javax.inject.Inject;

import mda.AbstractSessionItem;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.mda.commons.ui.ContentProvider;
import org.mda.commons.ui.LabelProvider;
import org.mda.commons.ui.Util;

@Creatable
public class RunSessionShell {
	
	@Inject
	private PresentationContext presentationContext;
	
	@Inject
	private ContentOverview overview;
	
	
	private Shell shell;
	
	private List treModel;
	
	@Inject
	private DefaultPresentationController controller;

	private ToolBar toolbar;
	
	
	private ToolBar buildToolBar (final Shell shell) {
		toolbar = new ToolBar(shell, SWT.FLAT | SWT.WRAP | SWT.RIGHT);
	    
	    ToolItem btnPrevSong = new ToolItem(toolbar, SWT.PUSH);
	    btnPrevSong.setText("Prev song");
	    btnPrevSong.addSelectionListener(new SelectionAdapter() {
	      public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
	        getController().previousSong();
	      }
	    });

	    ToolItem btnNextSong = new ToolItem(toolbar, SWT.PUSH);
	    btnNextSong.setText("Next song");
	    btnNextSong.addSelectionListener(new SelectionAdapter() {
	      public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
	        getController().nextSong ();
	      }
	    });

	    ToolItem btnPrev = new ToolItem(toolbar, SWT.PUSH);
	    btnPrev.setText("Prev slide");
	    btnPrev.addSelectionListener(new SelectionAdapter() {
	      public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
	        getController().previousSlide();
	      }
	    });

	    ToolItem btnNext = new ToolItem(toolbar, SWT.PUSH);
	    btnNext.setText("Next slide");
	    btnNext.addSelectionListener(new SelectionAdapter() {
	      public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
	        getController().nextSlide();
	      }
	    });
	    
	    

	    final ToolItem btnBlack = new ToolItem(toolbar, SWT.RADIO);
	    btnBlack.setText("Black");
	    btnBlack.addSelectionListener(new SelectionAdapter() {
	      public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
	        getController().toggleBlack ();
	      }
	    });

	    final ToolItem btnWhite = new ToolItem(toolbar, SWT.RADIO);
	    btnWhite.setText("White");
	    btnWhite.addSelectionListener(new SelectionAdapter() {
	      public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
	        getController().toggleWhite();
	      }
	    });

	    final ToolItem btnBackground = new ToolItem(toolbar, SWT.RADIO);
	    btnBackground.setText("Background");
	    btnBackground.addSelectionListener(new SelectionAdapter() {
	      public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
	        getController().toggleOnlyBackground();
	      }
	    });
	    
	    final ToolItem btnNormal = new ToolItem(toolbar, SWT.RADIO);
	    btnNormal.setText("Normal");
	    btnNormal.addSelectionListener(new SelectionAdapter() {
	      public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
	        getController().toggleNormalize();
	        btnBackground.setSelection(false); 
	        btnWhite.setSelection(false);
	        btnBlack.setSelection(false);
	        btnNormal.setSelection(false);
	      }
	    });

	    ToolItem btnDefaultSite = new ToolItem(toolbar, SWT.PUSH);
	    btnDefaultSite.setText("Default slide");
	    btnDefaultSite.setEnabled(false);
	    
	    GridData gd = new GridData(SWT.FILL,  SWT.FILL,  true, false, 2, 1);
	    gd.minimumHeight = 50;
	    toolbar.setLayoutData(gd);
	    
	    return toolbar;
	}
	
	public Shell build (final Shell parent) {
		shell = new Shell (parent, SWT.NONE); 
		shell.setBounds(parent.getBounds());
		
		presentationContext.registerController(getController());

		//Toolbar
		
		ToolBar toolbar = buildToolBar(shell);
		
		
		treModel = new List(shell, SWT.NONE);
	    treModel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true));
	    final ListViewer treviewer = new ListViewer(treModel);
	    treviewer.setContentProvider(new ContentProvider());
	    treviewer.setLabelProvider(new LabelProvider());
	    treviewer.setInput(presentationContext.getCurrentSession());
	    treviewer.addSelectionChangedListener(new ISelectionChangedListener() {

	      @Override
	      public void selectionChanged (SelectionChangedEvent arg0) {
	        AbstractSessionItem item = (AbstractSessionItem) Util.getStructuredSelection(treviewer.getSelection());
	          controller.toItem(item);
	      }
	    });
		
		shell.setLayout(new GridLayout(2, false));
		
		overview.build(shell);
		overview.getComp().setLayoutData(new GridData(SWT.FILL, SWT.FILL,  true, true));
		
		shell.setVisible(true);
		shell.setFocus();
		
		overview.refresh();
		
		return shell;
	}
	
	public Shell getShell () {
		return shell;
	}
	
	private DefaultPresentationController getController () {
	    return controller;
	  }
	

}
