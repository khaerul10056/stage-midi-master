package org.mda.commons.ui.user;

import java.awt.Component;

import mda.User;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;
import org.mda.commons.ui.util.UIUtils;

public class UserGeneralTab implements IUserTab {

	Text txtFamilyName;

	Text txtFirstName;

	Text txtMail;

	Button chkSendSongbooks;

	@Override
	public Component build(TabFolder shell) {
		TabItem item = new TabItem (shell, SWT.NULL);
		item.setText ("General");
		Composite comp = new Composite(shell, SWT.NONE);
		item.setControl(comp);
		comp.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		comp.setLayout(new GridLayout(2, false));

		Label lblFamilyName = new Label(comp, SWT.NONE);
		lblFamilyName.setText("Name:");
		lblFamilyName.setLayoutData(UIUtils.getLabelData());
		txtFamilyName = new Text(comp, SWT.NONE);
		txtFamilyName.setLayoutData(UIUtils.getContentData());

		Label lblFirstname = new Label(comp, SWT.NONE);
		lblFirstname.setText("First name:");
		lblFirstname.setLayoutData(UIUtils.getLabelData());
		txtFirstName = new Text(comp, SWT.NONE);
		txtFirstName.setLayoutData(UIUtils.getContentData());

		Label lblMail = new Label(comp, SWT.NONE);
		lblMail.setText("E-Mail:");
		lblMail.setLayoutData(UIUtils.getLabelData());
		txtMail = new Text(comp, SWT.NONE);
		txtMail.setLayoutData(UIUtils.getContentData());

		Label lblSend = new Label(comp, SWT.NONE);
		lblSend.setText("Send songbook:");
		lblSend.setLayoutData(UIUtils.getLabelData());
		chkSendSongbooks = new Button(comp, SWT.CHECK);

		Label lblDivider = new Label(comp, SWT.SEPARATOR | SWT.HORIZONTAL);

		Label lblGap = new Label(comp, SWT.NONE);
		lblGap.setLayoutData(UIUtils.getGapData());
		lblGap = new Label(comp, SWT.NONE);
		lblGap.setLayoutData(UIUtils.getGapData());
		return null;
	}

	@Override
	public void save(User currentUser) {
		currentUser.setFirstname(txtFirstName.getText());
	    currentUser.setName(txtFamilyName.getText()); 
	    currentUser.setSendSongbook(chkSendSongbooks.getSelection());
	}

	@Override
	public boolean hasChanged() {
		return false;
	}

	@Override
	public void load(User currentUser) {
		txtFamilyName.setEnabled(currentUser != null);
		txtFirstName.setEnabled(currentUser != null);
		txtMail.setEnabled(currentUser != null);
		txtFamilyName.setText(currentUser != null ? currentUser.getName() : "");
		txtFirstName.setText(currentUser != null ? currentUser.getFirstname() : "");
		txtMail.setText(currentUser != null ? currentUser.getMail() : "");
		chkSendSongbooks.setEnabled(currentUser != null);
		chkSendSongbooks.setSelection(currentUser != null
				&& currentUser.isSendSongbook());

	}

}
