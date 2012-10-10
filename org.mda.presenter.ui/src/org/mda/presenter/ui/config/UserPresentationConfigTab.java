package org.mda.presenter.ui.config;

import java.awt.Component;

import javax.inject.Inject;

import mda.User;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.mda.commons.ui.user.IUserTab;

@Creatable
public class UserPresentationConfigTab implements IUserTab{
	
	@Inject
	PresentationSchemaEditorBuilder presentationschemaeditorBuilder;

	@Override
	public Component build(TabFolder shell) {
		TabItem item = new TabItem (shell, SWT.NULL);
		item.setText ("Presentation");
		item.setControl(presentationschemaeditorBuilder.build(shell, null));
		return null;
	}

	@Override
	public void save(User user) {
		presentationschemaeditorBuilder.save(user);
	}

	@Override
	public void load(User user) {
		presentationschemaeditorBuilder.load(user);
		
	}

	@Override
	public boolean hasChanged() {
		// TODO Auto-generated method stub
		return false;
	}

}
