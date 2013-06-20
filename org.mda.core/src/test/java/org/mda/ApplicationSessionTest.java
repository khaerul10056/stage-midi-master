package org.mda;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.junit.Test;

public class ApplicationSessionTest {

	@Test
	public void defaults() throws Exception {
		final String PATH = "tmp";

		try {
			ApplicationSession session = new ApplicationSession();

			session.load(null);

			File confFile = new File("../org.mda.javafx.application/.mda/mda.properties");
			assertTrue(confFile.exists());

			Properties props = new Properties();
			props.load(new FileInputStream(confFile));
			assertNotNull(props.get(ApplicationSession.PROP_LASTMODELFILE));

		} finally {
			Utils.deleteDirectory(new File(PATH));
		}
	}

}