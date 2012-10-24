package org.mda.commons.ui.config;

import javax.inject.Inject;

import mda.Configuration;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.mda.ApplicationSession;
import org.mda.commons.ui.util.UIUtils;

public class GeneralPreferencePage extends PreferencePage implements
		IWorkbenchPreferencePage {

	private Label lblFile;

	private Spinner spnFontSize;

	private Button chkEnableGrid;

	private Text txtMailserverUrl;

	private Text txtMailserverUser;

	private Text txtMailserverPassword;

	@Inject
	private ApplicationSession session;

	public GeneralPreferencePage() {
		// TODO Auto-generated constructor stub
	}

	public GeneralPreferencePage(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public GeneralPreferencePage(String title, ImageDescriptor image) {
		super(title, image);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(IWorkbench workbench) {
		// TODO Auto-generated method stub

	}

	@Override
	protected Control createContents(Composite parent) {
		parent.setLayout(UIUtils.createLayout(2, 20));

		lblFile = new Label(parent, SWT.NONE);
		lblFile.setLayoutData(UIUtils.getContentData(2));
		lblFile.setText("File: "
				+ session.getCurrentModel().eResource().getURI().toFileString());

		// Fontsize
		Label lblFontsize = new Label(parent, SWT.NONE);
		lblFontsize.setText("Fontsize:");
		lblFontsize.setLayoutData(UIUtils.getLabelData());

		Configuration configuration = session.getConfig();

		spnFontSize = new Spinner(parent, SWT.NONE);
		if (configuration.getFontsize() != null)
			spnFontSize.setSelection(configuration.getFontsize());
		spnFontSize.setLayoutData(UIUtils.getContentData());

		if (session.getFeatureActivation().isShowGridEnabled()) {
			Label lblGrid = new Label(parent, SWT.NONE);
			lblGrid.setText("Grid:");
			lblGrid.setLayoutData(UIUtils.getLabelData());

			chkEnableGrid = new Button(parent, SWT.CHECK);
			chkEnableGrid.setSelection(session.getGlobalConfs().isShowGrid());
			chkEnableGrid.setLayoutData(UIUtils.getContentData());
		}

		Group mailgroup = new Group(parent, SWT.SHADOW_IN);
		mailgroup.setText("Mail");
		mailgroup.setLayoutData(UIUtils.getContentData(2));
		mailgroup.setLayout(UIUtils.createLayout(2, 10));

		Label lblMailserverUrl = new Label(mailgroup, SWT.NONE);
		lblMailserverUrl.setText("Mailserver URL:");
		lblMailserverUrl.setLayoutData(UIUtils.getLabelData());

		txtMailserverUrl = new Text(mailgroup, SWT.NONE);
		txtMailserverUrl
				.setText(configuration.getMailserverUrl() != null ? configuration
						.getMailserverUrl() : "");
		txtMailserverUrl.setLayoutData(UIUtils.getContentData());

		Label lblMailserverUser = new Label(mailgroup, SWT.NONE);
		lblMailserverUser.setText("Mailserver User:");
		lblMailserverUser.setLayoutData(UIUtils.getLabelData());

		txtMailserverUser = new Text(mailgroup, SWT.NONE);
		txtMailserverUser
				.setText(configuration.getMailserverUser() != null ? configuration
						.getMailserverUser() : "");
		txtMailserverUser.setLayoutData(UIUtils.getContentData());

		Label lblMailserverPassword = new Label(mailgroup, SWT.NONE);
		lblMailserverPassword.setText("Mailserver Password:");
		lblMailserverPassword.setLayoutData(UIUtils.getLabelData());

		txtMailserverPassword = new Text(mailgroup, SWT.PASSWORD);
		txtMailserverPassword
				.setText(configuration.getMailserverPassword() != null ? configuration
						.getMailserverPassword() : "");
		txtMailserverPassword.setLayoutData(UIUtils.getContentData());

		Label lblExtender = new Label(parent, SWT.NONE);
		lblExtender.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true,
				true, 2, 1));

		Label lblBorder = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL);
		lblBorder.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				2, 1));

		return parent;
	}

	public Configuration getConfiguration() {
		return session.getConfig();
	}

	@Override
	public boolean performOk() {
		getConfiguration().setFontsize(spnFontSize.getSelection());
		getConfiguration().setMailserverUrl(txtMailserverUrl.getText());
		getConfiguration().setMailserverUser(txtMailserverUser.getText());
		getConfiguration().setMailserverPassword(
				txtMailserverPassword.getText());
		session.getGlobalConfs().setShowGrid(chkEnableGrid.getSelection());

		session.saveModel();

		return true;
	}

}
