 
package org.mda.commons.ui;

import mda.AbstractSessionItem;
import mda.MidiFile;
import mda.Session;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.mda.ApplicationSession;
import org.mda.MidiPlayerService;
import org.mda.commons.ui.find.SearchEnginePanel;
import org.mda.find.SearchResult;
import org.mda.inject.InjectService;

import com.google.inject.Inject;

public class SearchEngineHandler {
	
	@Inject
	private ApplicationSession appsession;
	
	@Inject
	private SearchEnginePanel searchenginepanel;
	
	@Execute
	public void execute() {
		InjectService.injectObject(this);
		
		searchenginepanel.build();
		searchenginepanel.getShell().addDisposeListener(new DisposeListener() {
			
			@Override
			public void widgetDisposed(DisposeEvent e) {
				SearchResult activeSearchResult = searchenginepanel.getActiveSearchResult();
				
				if (activeSearchResult != null) {
					if (activeSearchResult.getEobject() instanceof MidiFile) {
						AbstractSessionItem selectedItem = appsession.getCurrentMidifile();
						Session sessionWithAddedSong = MidiPlayerService.addSessionItem(appsession.getCurrentSession(), selectedItem, (MidiFile) activeSearchResult.getEobject());
						appsession.getModelEvents().setCurrentModelElement(Session.class, sessionWithAddedSong);
					}
				}
			}
		});
	}
		
}