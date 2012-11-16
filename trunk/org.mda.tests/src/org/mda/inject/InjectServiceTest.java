package org.mda.inject;

import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Test;

import com.google.inject.Module;

public class InjectServiceTest {
	
	@Test
	public void setup () {
		Collection<Module> setupModules = InjectService.setupModules();
		assertTrue (setupModules.size() > 2);
		
		
	}

}
