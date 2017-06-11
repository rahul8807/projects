package com.ubs.opsit.domain.clock.uniqueclock.berlinclock;

import java.util.function.Function;

import com.ubs.opsit.domain.clock.standardclock.Second;
import static com.ubs.opsit.utility.Constants.*;

public class BerlinCLockSecond {

	private final Second second;
	
	private final Function<Second, Second> validateAndGetSecond = (second) -> {
		if(second == null){
			throw new IllegalArgumentException(INVALID_SECOND_FORMAT);
		}
		return second;
	};
	
	public BerlinCLockSecond(final Second second) {
		super();
		this.second = validateAndGetSecond.apply(second);
	}

	public final String getBerlinSecond(){
		return ((second.getSecond()) % 2 == 0 ? BerlinClockLight.YELLOW_LIGHT.getLightValue() : BerlinClockLight.OFF.getLightValue());	
	}
}
