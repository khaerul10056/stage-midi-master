package org.mda.find;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;


public class SearchEngine {
	
	private List <ISearchStrategy> strategies = new ArrayList<ISearchStrategy>(); 
	
	public SearchEngine () {
		strategies.add(new ByNameSearchStrategy());
	}
	
	public List <SearchResult> find (String searchtext, final EObject model) {
		
		List <SearchResult> results = new ArrayList<SearchResult>();
		
		if (!searchtext.trim().isEmpty()) {
			for (ISearchStrategy nextStrategy : strategies) {
				results.addAll(nextStrategy.find(searchtext, model));
			}
		}
		
		return results;		
	}

}
