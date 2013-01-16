package org.mda.javafx.presenter.javafx;



import javafx.scene.text.FontBuilder;

import org.mda.presenter.adapter.Font;
import org.mda.presenter.adapter.IGraphicsContext;
import org.mda.presenter.adapter.Size;

import com.sun.javafx.tk.FontLoader;
import com.sun.javafx.tk.FontMetrics;
import com.sun.javafx.tk.Toolkit;

public class JavaFXGraphicsContext implements IGraphicsContext {
	
	private FontLoader fontloader = Toolkit.getToolkit().getFontLoader();

	@Override
	public Size getSize(String text, Font fontdesc) {
		javafx.scene.text.Font font = FontBuilder.create().name("Arial").size(fontdesc.getFontsize()).build();
		FontMetrics fontMetrics = fontloader.getFontMetrics(font);
		float computeStringWidth = fontMetrics.computeStringWidth(text);
		float computeStringHeight = fontMetrics.getAscent();
		return new Size (computeStringWidth,computeStringHeight);
	}

	

}