package org.mda.editor.preview.ui;

import mda.MidiFilePartType;

import org.junit.Assert;
import org.junit.Test;


public class StepTypeColorerTest {
	
	@Test
	public void color () {
		StepTypeColorInfo colorInfoBridge = StepTypeColorer.getColorInfo(MidiFilePartType.BRIDGE);
		StepTypeColorInfo colorInfoRefrain = StepTypeColorer.getColorInfo(MidiFilePartType.REFRAIN);
		
		Assert.assertEquals (colorInfoBridge.getNormal(), colorInfoRefrain.getNormal());
		Assert.assertEquals (colorInfoBridge.getSelected(), colorInfoRefrain.getSelected());
		
	}

}
