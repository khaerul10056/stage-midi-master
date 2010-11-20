package org.mda;

public enum PlayerMode {
	PERFORMANCE ("Performance"),
	PROBE ("Probe");

	private final String anzeigetext;

	private PlayerMode (final String anzeigetext) {
		this.anzeigetext = anzeigetext;
	}

	public String getAnzeigetext() {
		return anzeigetext;
	}
}
