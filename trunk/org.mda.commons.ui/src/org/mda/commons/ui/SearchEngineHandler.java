 
package org.mda.commons.ui;

import mda.MidiFile;
import mda.Session;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.mda.ApplicationSession;
import org.mda.MidiPlayerService;
import org.mda.commons.ui.find.SearchEnginePanel;
import org.mda.find.SearchResult;

public class SearchEngineHandler {
	
	
	
	@Execute
	public void execute(final ApplicationSession appsession, final SearchEnginePanel searchenginepanel) {
		searchenginepanel.build();
		searchenginepanel.getShell().addDisposeListener(new DisposeListener() {
			
			@Override
			public void widgetDisposed(DisposeEvent e) {
				SearchResult activeSearchResult = searchenginepanel.getActiveSearchResult();
				
				if (activeSearchResult != null) {
					if (activeSearchResult.getEobject() instanceof MidiFile) {
						Session addSong = MidiPlayerService.addSessionItem(appsession.getCurrentSession(), (MidiFile) activeSearchResult.getEobject());
						
						appsession.getModelEvents().setCurrentModelElement(Session.class, addSong);
					}
				}
			}
		});
	}
		
}