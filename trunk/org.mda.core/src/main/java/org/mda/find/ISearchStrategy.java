package org.mda.find;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

public interface ISearchStrategy {
	
	public List <SearchResult> find (final String searchtext, final EObject model);

}
