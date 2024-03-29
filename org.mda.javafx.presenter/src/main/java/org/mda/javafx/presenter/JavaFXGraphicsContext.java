package org.mda.javafx.presenter;

import javafx.scene.text.FontWeight;

import org.mda.measurement.FontInfo;
import org.mda.measurement.SizeInfo;
import org.mda.presenter.adapter.IGraphicsContext;

import com.sun.javafx.tk.FontLoader;
import com.sun.javafx.tk.FontMetrics;
import com.sun.javafx.tk.Toolkit;

public class JavaFXGraphicsContext implements IGraphicsContext {

	@Override
	public SizeInfo getSize(String text, FontInfo fontdesc) {
		FontLoader fontloader = Toolkit.getToolkit().getFontLoader();
		javafx.scene.text.Font font = null;
		if (fontdesc.isBold())
		  font = javafx.scene.text.Font.font("Arial Alternative", FontWeight.BOLD, fontdesc.getFontsize());
		else
		  font = javafx.scene.text.Font.font("Arial Alternative", FontWeight.NORMAL, fontdesc.getFontsize());
		
		FontMetrics fontMetrics = fontloader.getFontMetrics(font);
		float computeStringWidth = fontMetrics.computeStringWidth(text);
		float computeStringHeight = fontMetrics.getAscent();
		return new SizeInfo (computeStringWidth,computeStringHeight);
	}

	

}
