 
package org.mda.commons.ui;

import javax.inject.Inject;
import javax.inject.Named;

import mda.AbstractSessionItem;
import mda.MidiFile;
import mda.Session;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Tree;
import org.mda.ApplicationSession;
import org.mda.commons.ui.find.SearchEnginePanel;
import org.mda.commons.ui.navigator.NavigatorItem;

@Creatable
public class SessionOverviewPart {
  
  private String suchtextDefault = "Please add text to look for here...";
  
  private ApplicationSession appSession;
  
  private ESelectionService selectionService;

private TreeViewer treviewer;

private Label lblDetails;

  
  private GridData getGd (Integer verticalIndent) {
    GridData gd = new GridData(SWT.FILL);
    gd.grabExcessHorizontalSpace = true;
    
    gd.horizontalAlignment = SWT.FILL;
    if (verticalIndent != null)
      gd.verticalIndent = verticalIndent;
    return gd;
  }
  
	@Inject
	public SessionOverviewPart(final Composite comp, final ApplicationSession session, final ESelectionService selectionService) {
		this.selectionService = selectionService;
	  appSession = session;
	  comp.setLayout(new GridLayout(2, false));
	  
	  //Searchfield
//	  Text txt = new Text (comp, SWT.NONE);
//	  txt.setText(suchtextDefault); 
//	  txt.selectAll();
//	  txt.setFocus();
//	  
//	  GridData gd = getGd(20); 
//	  gd.horizontalIndent = 20;
//	  gd.horizontalSpan = 2;
//	  txt.setLayoutData(gd);
	  
	  //Details
	  
	  lblDetails = new Label (comp, SWT.None); 
    lblDetails.setText("");
    Font font = lblDetails.getFont(); 
    lblDetails.setFont(new Font(font.getDevice(), "Arial", 18, SWT.BOLD));
    GridData gd2 = getGd(30);
    gd2.horizontalSpan = 2;
    lblDetails.setLayoutData(gd2);
    
    GridData gdLabel = getGd(null);
    gdLabel.widthHint = 100;
    gdLabel.horizontalIndent = 10;
    gdLabel.horizontalAlignment = SWT.BEGINNING;
    gdLabel.grabExcessHorizontalSpace = false;
    GridData gdContent = getGd(null);
	  
//	  Label lblName = new Label (comp, SWT.None); 
//    lblName.setText("Location:");
//    lblName.setLayoutData(gdLabel);
//    
//    Label lblNameData = new Label (comp, SWT.None); 
//    lblNameData.setText("Petrikirche Kulmbach");
//    lblNameData.setLayoutData(gdContent);
//    
//	  Label lblWhen = new Label (comp, SWT.None); 
//    lblWhen.setText("Date:");
//    lblWhen.setLayoutData(gdLabel);
//    
//    Label lblWhenData = new Label (comp, SWT.None); 
//    lblWhenData.setText("20.08.2012");
//    lblWhenData.setLayoutData(gdContent);
	  
    
    //Items
	  Label lbl2 = new Label (comp, SWT.None); 
	  lbl2.setLayoutData(getGd(30));
	  
	  
	  final Tree treModel = new Tree(comp, SWT.NONE);
    treModel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
    treviewer = new TreeViewer(treModel);
    treviewer.setContentProvider(new ContentProvider());
    treviewer.setLabelProvider(new LabelProvider());
    
    selectionService.setSelection(appSession.getCurrentModel().getSessions().get(0)); //TODO read last edited session
    
    treviewer.setInput(appSession.getCurrentSession());
    treviewer.addSelectionChangedListener(new ISelectionChangedListener() {
		
		@Override
		public void selectionChanged(SelectionChangedEvent event) {
			IStructuredSelection selection = (IStructuredSelection) event.getSelection();
			selectionService.setSelection(selection.getFirstElement());
		}
	});
    
    treModel.setFocus();
    treModel.addKeyListener(new KeyAdapter() {
		  public void keyPressed(KeyEvent e) {
			  
			  if (e.keyCode == SWT.CTRL && e.character == ' ') {
			    
			  }
			  
		  }
	  });
	  
	}
	
	
	
	@Focus
	public void onFocus() {
		//TODO Your code here
	}
	
	@Inject
	public void setSession(Composite composite, @Optional @Named(IServiceConstants.ACTIVE_SELECTION) Session session) {
		if (session != null) {
		  treviewer.setInput(session);
		  lblDetails.setText(session.getName());
		}
	}
	
	
}