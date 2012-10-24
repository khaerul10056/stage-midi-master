 
package org.mda.commons.ui.config;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.contributions.IContributionFactory;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.preference.IPreferenceNode;
import org.eclipse.jface.preference.IPreferencePage;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.jface.preference.PreferenceManager;
import org.eclipse.jface.preference.PreferenceNode;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.internal.dialogs.EmptyPreferencePage;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.osgi.framework.Bundle;

public class PreferenceHandler {
	public static final String PREFS_PAGE_XP = "org.eclipse.ui.preferencePages";
	protected static final String ELMT_PAGE = "page";	// $NON-NLS-1$
	protected static final String ATTR_ID = "id";	// $NON-NLS-1$
	protected static final String ATTR_CATEGORY = "category";	// $NON-NLS-1$
	protected static final String ATTR_CLASS = "class";	// $NON-NLS-1$
	protected static final String ATTR_NAME = "name";	// $NON-NLS-1$

	@Inject @Named(IServiceConstants.ACTIVE_SHELL) 
	protected Shell shell;
	
	private static final Log LOGGER  = LogFactory.getLogger(PreferenceHandler.class);
	
	@Inject protected IEclipseContext context;
	@Inject protected IExtensionRegistry registry;
	
	
	@Execute
	public void execute(MApplication app) {
		shell.setText("Preferences");
		PreferenceManager pm = configurePreferences();
		PreferenceDialog dialog = new PreferenceDialog(shell, pm);
		dialog.setMinimumPageSize(800, 600);
		dialog.setPreferenceStore(new ScopedPreferenceStore(new InstanceScope(), "HALLO"));
		dialog.create();
		dialog.getTreeViewer().setComparator(new ViewerComparator());
		dialog.getTreeViewer().expandAll();
		dialog.open();
	}

	private PreferenceManager configurePreferences() {
		PreferenceManager pm = new PreferenceManager();
		IContributionFactory factory = context.get(IContributionFactory.class);

		for(IConfigurationElement elmt : registry.getConfigurationElementsFor(PREFS_PAGE_XP)) {
			if (! elmt.getAttribute(ATTR_ID).startsWith("mda."))
				continue;
			
			if(!elmt.getName().equals(ELMT_PAGE)) {
				LOGGER.warn("unexpected element: " + elmt.getName());
				continue;
			} else if(isEmpty(elmt.getAttribute(ATTR_ID))
					|| isEmpty(elmt.getAttribute(ATTR_NAME))) {
				LOGGER.warn("missing id and/or name: " + elmt.getNamespaceIdentifier());
				continue;				
			}
			PreferenceNode pn = null;
			if(elmt.getAttribute(ATTR_CLASS) != null) {
				IPreferencePage page = null;
				try {
					
					Bundle bundle = Platform.getBundle(elmt.getDeclaringExtension().getContributor().getName());
					Class<?> loadClass = bundle.loadClass(elmt.getAttribute(ATTR_CLASS));
					Object object = null;
					try {
						object = loadClass.newInstance();
					} catch (InstantiationException e) {
						LOGGER.error(e.toString(), e);
					} catch (IllegalAccessException e) {
						LOGGER.error(e.toString(), e);
					}
					if(!(object instanceof IPreferencePage)) {
						LOGGER.error("Expected instance of IPreferencePage: " + elmt.getAttribute(ATTR_CLASS));
						continue;
					}
					page = (IPreferencePage)object;
				} catch(ClassNotFoundException e) {
					LOGGER.error(e.toString(), e);
					continue;
				}
				ContextInjectionFactory.inject(page, context);
				if((page.getTitle() == null || page.getTitle().isEmpty()) && elmt.getAttribute(ATTR_NAME) != null) {
					page.setTitle(elmt.getAttribute(ATTR_NAME));
				}
				pn = new PreferenceNode(elmt.getAttribute(ATTR_ID), page);
			} else {
				pn = new PreferenceNode(elmt.getAttribute(ATTR_ID), new EmptyPreferencePage());
			}
			if(isEmpty(elmt.getAttribute(ATTR_CATEGORY))) {				
				pm.addToRoot(pn);
			} else {
				IPreferenceNode parent = findNode(pm, elmt.getAttribute(ATTR_CATEGORY));
				if(parent == null) {
					pm.addToRoot(pn);
				} else {
					parent.add(pn);
				}
			}
		}
		
		return pm;
	}

	private IPreferenceNode findNode(PreferenceManager pm, String categoryId) {
		for(Object o : pm.getElements(PreferenceManager.POST_ORDER)) {
			if(o instanceof IPreferenceNode && ((IPreferenceNode)o).getId().equals(categoryId)) {
				return (IPreferenceNode)o;
			}
		}
		return null;
	}


	private boolean isEmpty(String value) {
		return value == null || value.trim().isEmpty();
	}
		
}