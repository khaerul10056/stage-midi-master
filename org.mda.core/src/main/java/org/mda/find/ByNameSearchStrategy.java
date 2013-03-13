package org.mda.find;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

public class ByNameSearchStrategy implements ISearchStrategy {

	@Override
	public List<SearchResult> find(String searchtext, EObject model) {
		
		List <SearchResult> results = new ArrayList<SearchResult>();
		
		TreeIterator<EObject> eAllContents = model.eAllContents();
		while (eAllContents.hasNext()) {
			EObject nextObject = eAllContents.next();
			EList<EAttribute> eAllAttributes = nextObject.eClass().getEAllAttributes();
			for (EAttribute next: eAllAttributes) {
				if (next.getName().equals("name")) {
					Object eGet = nextObject.eGet(next);
					if (eGet instanceof String) {
						String value = (String) eGet;
						if (value.indexOf(searchtext) >= 0) {
						  results.add(new SearchResult(nextObject.eClass(), nextObject, value));	
						}
					}
				}
			}
		}
		return results;
	}
	
	

}
