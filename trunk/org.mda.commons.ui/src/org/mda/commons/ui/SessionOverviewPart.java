 
package org.mda.commons.ui;

import static org.mda.Utils.ICON_ADD_PART;
import static org.mda.Utils.ICON_REMOVE_PART;
import static org.mda.Utils.loadImageFromProject;

import java.util.HashMap;

import javax.inject.Inject;

import mda.MidiFile;
import mda.Session;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Tree;
import org.mda.ApplicationSession;
import org.mda.MidiPlayerService;
import org.mda.listeners.IModelElementReloadListener;

@Creatable
public class SessionOverviewPart {
  
  private String suchtextDefault = "Please add text to look for here...";
  
  private ApplicationSession appSession;
  
  private TreeViewer treviewer;

  private Label lblDetails;
  

private Button btnAdd;

private ECommandService commandservice;

private EHandlerService handlerservice;

  
  private GridData getGd (Integer verticalIndent) {
    GridData gd = new GridData(SWT.FILL);
    gd.grabExcessHorizontalSpace = true;
    
    gd.horizontalAlignment = SWT.FILL;
    if (verticalIndent != null)
      gd.verticalIndent = verticalIndent;
    return gd;
  }
  
  private Composite createButtons (final Composite composite) {
	  final Composite newComp = new Composite(composite, SWT.None);
	  
	  newComp.setLayoutData(new GridData(SWT.BEGINNING, SWT.END, false, false, 2, 1));
	  newComp.setLayout(new FillLayout (SWT.HORIZONTAL));
	  
	  btnAdd = new Button(newComp, SWT.NONE);
	  btnAdd.setImage(loadImageFromProject(ICON_ADD_PART));
	  btnAdd.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				ParameterizedCommand myCommand = commandservice.createCommand("org.mda.commons.ui.command.searchengine", new HashMap());
				Object result = handlerservice.executeHandler(myCommand);
				
			}
			
		});
	  
	  Button btnRemove = new Button(newComp, SWT.NONE);
	  btnRemove.setImage(loadImageFromProject(ICON_REMOVE_PART));
	  
	  //Remove item from session
	  btnRemove.addSelectionListener(new SelectionAdapter() {
		
		@Override
		public void widgetSelected(SelectionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	});
	  
	  //adapt position of searchpanel
	  composite.getShell().addControlListener(new ControlListener() {
			
			@Override
			public void controlResized(ControlEvent e) {
				appSession.getUiState().setPositionSearcher(Util.getLocationOnScreenAfterWidget(btnAdd));
			}
			
			@Override
			public void controlMoved(ControlEvent e) {
				appSession.getUiState().setPositionSearcher(Util.getLocationOnScreenAfterWidget(btnAdd));
			}
		  });
	  
	  return newComp;
	  
  }
  
	@Inject
	public SessionOverviewPart(final Composite comp, final ApplicationSession session, final EHandlerService handlerservice, 
			final ECommandService commandservice) {
		
	  appSession = session;
	this.handlerservice = handlerservice;
	this.commandservice = commandservice;
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
	  
	  Label lblName = new Label (comp, SWT.None); 
    lblName.setText("Location:");
    lblName.setLayoutData(gdLabel);
    
    Label lblNameData = new Label (comp, SWT.None); 
    lblNameData.setText("Petrikirche Kulmbach");
    lblNameData.setLayoutData(gdContent);
    
	  Label lblWhen = new Label (comp, SWT.None); 
    lblWhen.setText("Date:");
    lblWhen.setLayoutData(gdLabel);
    
    Label lblWhenData = new Label (comp, SWT.None); 
    lblWhenData.setText("20.08.2012");
    lblWhenData.setLayoutData(gdContent);
	  
    
    //Items
	  Label lbl2 = new Label (comp, SWT.None); 
	  lbl2.setLayoutData(getGd(30));
	  
	  
	  final Composite btnComp = createButtons(comp);
	  
	  final Tree treModel = new Tree(comp, SWT.NONE);
    treModel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
    treviewer = new TreeViewer(treModel);
    treviewer.setContentProvider(new ContentProvider());
    treviewer.setLabelProvider(new LabelProvider());
    
    
    
    
    DragSource ds = new DragSource(treModel, DND.DROP_MOVE);
    ds.setTransfer(new Transfer[] { TextTransfer.getInstance() });
    ds.addDragListener(new DragSourceAdapter() {
      public void dragSetData(DragSourceEvent event) {
    	  IStructuredSelection selection = (IStructuredSelection) treviewer.getSelection();
    	  EObject selectedObject = (EObject) selection.getFirstElement();
    	  int from = appSession.getCurrentSession().getItems().indexOf(selectedObject);
    	  event.data = Integer.toString(from);
      }
    });
    
    
    
    // Create the drop target on the button
    DropTarget dt = new DropTarget(treModel, DND.DROP_MOVE);
    dt.setTransfer(new Transfer[] { TextTransfer.getInstance() });
    dt.addDropListener(new DropTargetAdapter() {
      public void drop(DropTargetEvent event) {
    	  
    	  int from = Integer.parseInt(((String)event.data));
    	  

    	  int to = -1;
    	  for (int i = 0; i < treModel.getItemCount(); i++) {
    		  if (treModel.getItem(i).equals(event.item)) {
    			  to = i;
    			  break;
    		  }
    	  }
    	  to++;
    	  
    	  
    	  MidiPlayerService.moveSessionItem (appSession.getCurrentSession(), from, to);
    	  appSession.getModelEvents().setCurrentModelElement(Session.class, appSession.getCurrentSession());
      }
    });
    
    
    treviewer.setInput(appSession.getCurrentSession());
    treviewer.addSelectionChangedListener(new ISelectionChangedListener() {
		
		@Override
		public void selectionChanged(SelectionChangedEvent event) {
			IStructuredSelection structuredSelection = (IStructuredSelection) event.getSelection();
			appSession.setCurrentMidifile((MidiFile) structuredSelection.getFirstElement());
		}
	});
    
    appSession.getModelEvents().addReloadListener(new IModelElementReloadListener() {
		
		@Override
		public void reload(Object newObject, Object oldObject) {
			Session session = (Session) newObject;
			treviewer.setInput(session);
			lblDetails.setText(session.getName());
		}
		
		@Override
		public Class<? extends Object> isRelevant() {
			return Session.class;
		}
	});
    
    appSession.getModelEvents().setCurrentModelElement(Session.class, appSession.getCurrentModel().getSessions().get(0));	//TODO read last edited session
    
    
    treModel.setFocus();
    
	}
	
	@Focus
	public void onFocus() {
		//TODO Your code here
	}
	
}