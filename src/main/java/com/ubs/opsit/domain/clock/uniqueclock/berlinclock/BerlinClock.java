package com.ubs.opsit.domain.clock.uniqueclock.berlinclock;

import com.ubs.opsit.domain.clock.standardclock.Clock;
import com.ubs.opsit.interviews.TimeConverter;
import static com.ubs.opsit.utility.Constants.INVALID_TIME_FORMAT;
import static com.ubs.opsit.utility.Constants.BERLIN_CLOCK_DELIMITER;;

public final class BerlinClock implements TimeConverter {

	private  Clock clock;
	private  BerlinClockHour berlinClockHour;
	private  BerlinClockMinute berlinClockMinute;
	private  BerlinCLockSecond berlinCLockSecond;

	private BerlinClock(String time) {
		super();
		this.clock = new Clock(time);
		this.berlinClockHour = new BerlinClockHour(clock.getClockHour());
		this.berlinClockMinute = new BerlinClockMinute(clock.getClockMinute());
		this.berlinCLockSecond = new BerlinCLockSecond(clock.getClockSecond());
	}

	public BerlinClock() {
		super();
	}
	
	@Override
	public String convertTime(String time) {
		if(time == null || time.isEmpty()){
			throw new IllegalArgumentException(INVALID_TIME_FORMAT);
		}
		
		BerlinClock berlinClock = new BerlinClock(time);
		return berlinClock.getBerlinCLockSecond().getBerlinSecond()
				+BERLIN_CLOCK_DELIMITER
		        +berlinClock.getBerlinClockHour().getBerlinHour()
		        +BERLIN_CLOCK_DELIMITER
		        +berlinClock.getBerlinClockMinute().getBerlinMinute();
		
	}

	public Clock getClock() {
		return clock;
	}

	public BerlinClockHour getBerlinClockHour() {
		return berlinClockHour;
	}

	public BerlinClockMinute getBerlinClockMinute() {
		return berlinClockMinute;
	}

	public BerlinCLockSecond getBerlinCLockSecond() {
		return berlinCLockSecond;
	}

	
}
