package org.mda.commons.ui.util;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

public class UIUtils {
	
	public static GridLayout createLayout(int columns, int border) {
		GridLayout gl = new GridLayout(columns, false);
		gl.marginHeight = border;
		gl.marginWidth = border;
		gl.verticalSpacing = 15;
		gl.horizontalSpacing = 10;
		return gl;
	}

	public static GridData getLabelData() {
		return new GridData(SWT.BEGINNING, SWT.CENTER, false, false);
	}

	public static GridData getContentData() {
		return new GridData(SWT.FILL, SWT.FILL, true, false);
	}
	
	public static GridData getContentData(final int gap) {
		return new GridData(SWT.FILL, SWT.FILL, true, false, gap, 1);
	}

	public static GridData getGapData() {
		return new GridData(SWT.FILL, SWT.FILL, true, true);
	}

}
