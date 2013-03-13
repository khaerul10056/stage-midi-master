package org.mda.midi.mapping;

import org.mda.transpose.AbsolutePitch;
import org.mda.transpose.Pitch;

public class MappingInfoFactory {
	
	public static MappingInfo getMappingInfo () {
		MappingInfo info = new MappingInfo();
		info.getMappings().add(new MappingRule(new AbsolutePitch(Pitch.A, 3), new AbsolutePitch(Pitch.A, 2), "Crash Becken"));
		info.getMappings().add(new MappingRule(new AbsolutePitch(Pitch.E, 3), new AbsolutePitch(Pitch.E, 2), "Crash Becken"));
		info.getMappings().add(new MappingRule(new AbsolutePitch(Pitch.GIS, 2), new AbsolutePitch(Pitch.GIS, 1), "Hihat"));
		info.getMappings().add(new MappingRule(new AbsolutePitch(Pitch.AIS, 2), new AbsolutePitch(Pitch.AIS, 1), "Open Hihat"));
		info.getMappings().add(new MappingRule(new AbsolutePitch(Pitch.DIS, 2), new AbsolutePitch(Pitch.DIS, 1), "Handclap"));
		info.getMappings().add(new MappingRule(new AbsolutePitch(Pitch.D, 2), new AbsolutePitch(Pitch.D, 1), "Snare"));
		info.getMappings().add(new MappingRule(new AbsolutePitch(Pitch.C, 2), new AbsolutePitch(Pitch.CIS, 1), "Snare Tick"));
		info.getMappings().add(new MappingRule(new AbsolutePitch(Pitch.A, 1), new AbsolutePitch(Pitch.E, 1), "Snare electric"));
		info.getMappings().add(new MappingRule(new AbsolutePitch(Pitch.G, 1), new AbsolutePitch(Pitch.C, 1), "Basedrum"));
		info.getMappings().add(new MappingRule(new AbsolutePitch(Pitch.DIS, 3), new AbsolutePitch(Pitch.DIS, 2), "Ridebecken"));
		info.getMappings().add(new MappingRule(new AbsolutePitch(Pitch.G, 2), new AbsolutePitch(Pitch.G, 1), "Mid Tom"));
		info.getMappings().add(new MappingRule(new AbsolutePitch(Pitch.F, 2), new AbsolutePitch(Pitch.F, 1), "Deep Tom"));
		info.getMappings().add(new MappingRule(new AbsolutePitch(Pitch.A, 2), new AbsolutePitch(Pitch.A, 1), "High Tom"));
		return info;
	}

	

}
