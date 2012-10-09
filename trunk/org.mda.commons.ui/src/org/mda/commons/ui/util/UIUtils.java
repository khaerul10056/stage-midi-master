package org.mda.commons.ui.util;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;

public class UIUtils {

	public static GridData getLabelData() {
		return new GridData(SWT.BEGINNING, SWT.CENTER, false, false);
	}

	public static GridData getContentData() {
		return new GridData(SWT.FILL, SWT.FILL, true, false);
	}

	public static GridData getGapData() {
		return new GridData(SWT.FILL, SWT.FILL, true, true);
	}

}
