package org.mda.midi;

public class Position {
	
	private final int bar; 
	private final int tick;
	
	public Position (final String position) {
		String [] splittedString = position.split("/");
		if (splittedString.length == 2) { 
	      bar = Integer.parseInt(splittedString [0]); 
		  tick = Integer.parseInt(splittedString [1]);
		}
		else {
			bar = 0; 
			tick = 0;
		}
	}
	
	public Position (final int bar, final int tick) {
		this.bar = bar; 
		this.tick = tick;
	}
	
	public boolean equals (final Object object) {
		if (! (object instanceof Position))
			return false;
		Position position2 = (Position) object;
		return position2.getBar() == bar && position2.getTick() == tick;
	}

	public int getBar() {
		return bar;
	}

	public int getTick() {
		return tick;
	}
	
	public String toString () {
		return bar + "/" + tick;
	}
	
	public boolean isAfter (final Position secondPosition) {
		if (bar > secondPosition.bar)
			return true; 
		if (bar == secondPosition.bar) {
			if (tick >= secondPosition.tick)
				return true; 
		}
		
		return false;
	}

	public int compareTo(Position secondPosition) {
		if (bar > secondPosition.bar)
			return 1; 
		if (bar == secondPosition.bar) {
			if (tick >= secondPosition.tick)
				return 1;
			if (tick == secondPosition.tick)
				return 0;
		}
		
		return -1;
	}

}
