package org.mda.midi.mapping;

import org.mda.transpose.AbsolutePitch;

public class MappingRule {
	
	private final AbsolutePitch custom; 
	
	private final AbsolutePitch generalMidi;
	
	private final String name; 
	
	public MappingRule (final AbsolutePitch custom, AbsolutePitch generalMidi, final String name) {
		this.custom = custom; 
		this.generalMidi = generalMidi;
		this.name = name;
	}

	public AbsolutePitch getCustom() {
		return custom;
	}

	public AbsolutePitch getGeneralMidi() {
		return generalMidi;
	}

	public String getName() {
		return name;
	}

	

}
