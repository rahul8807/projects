package com.ubs.opsit.domain.clock.standardclock;

import java.util.function.Function;
import java.util.function.Predicate;

import static com.ubs.opsit.utility.Constants.*;
public class Minute {

	private final Integer minute;
	
	private final Predicate<Integer> isMinuteValid  = (minute) ->  ( minute != null && (minute >=  0 && minute < 60) ); 
	private final Function<Integer, Integer> validateAndGetMinute = (minute) ->{
		
		if(!isMinuteValid.test(minute)){
			throw new IllegalArgumentException(INVALID_MINUTE_FORMAT);
		}
		
		return minute;
	};
	
	
	public Minute(Integer minute) {
		super();
		this.minute = validateAndGetMinute.apply(minute);
	}

	public int getMinute() {
		return minute;
	}

	@Override
	public String toString() {
		return "Minute [minute=" + minute + "]";
	}
	
}
