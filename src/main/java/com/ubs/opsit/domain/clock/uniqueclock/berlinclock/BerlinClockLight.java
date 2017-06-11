package com.ubs.opsit.domain.clock.uniqueclock.berlinclock;

public enum BerlinClockLight {

	OFF("O","Switch off light"),
	YELLOW_LIGHT("Y","Switch on yellow light"),
	RED_LIGHT("R","Switch on red light");
	
	private final String lightValue;
	private final String description;
	
	private  BerlinClockLight(String lightValue, String description) {
		this.lightValue = lightValue;
		this.description = description;
	}

	public String getLightValue() {
		return lightValue;
	}
	
}
