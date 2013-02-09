package org.mda.javafx.presenter;

import java.io.File;
import java.net.MalformedURLException;

import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.presenter.adapter.SizeInfo;

public class BackgroundImageResolver {

	private static final Log LOGGER = LogFactory.getLogger(BackgroundImageResolver.class);

	public String getBackgroundImageCss(final File backgroundImage, SizeInfo size) {

		String image;
		try {
			image = backgroundImage.toURI().toURL().toExternalForm();

			String css = "-fx-background-image: url('" + image + "');\n" +
			             "-fx-background-position: center center;\n " +
					     "-fx-background-size: " + size.getWidth() + " " + size.getHeight() + ";\n" +
			             "-fx-background-repeat: stretch;";
			return css;
		} catch (MalformedURLException e) {
			LOGGER.error(e.toString(), e);
			return "";
		}
	}

}
