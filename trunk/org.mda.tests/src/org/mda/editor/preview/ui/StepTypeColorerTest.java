package org.mda.editor.preview.ui;

import mda.SongPartType;

import org.junit.Assert;
import org.junit.Test;


public class StepTypeColorerTest {
	
	@Test
	public void color () {
		StepTypeColorInfo colorInfoBridge = StepTypeColorer.getColorInfo(SongPartType.BRIDGE);
		StepTypeColorInfo colorInfoRefrain = StepTypeColorer.getColorInfo(SongPartType.REFRAIN);
		
		Assert.assertEquals (colorInfoBridge.getNormal(), colorInfoRefrain.getNormal());
		Assert.assertEquals (colorInfoBridge.getSelected(), colorInfoRefrain.getSelected());
		
	}

}
