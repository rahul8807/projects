package com.ubs.opsit.domain.clock.standardclock;

import java.util.function.Function;
import java.util.function.Predicate;

import static com.ubs.opsit.utility.Constants.*;

public class Hour {

	private final Integer hour;
	
	private final Predicate<Integer> isHourValid  = (hour) ->  ( hour != null && (hour >=  0 && hour <= 24) ); 
	private final Function<Integer, Integer> validateAndGetHour = (hour) ->{
		
		if(!isHourValid.test(hour)){
			throw new IllegalArgumentException(INVALID_HOUR_FORMAT);
		}
		
		return hour;
	};
	
	
	public Hour(Integer hour) {
		super();
		this.hour = validateAndGetHour.apply(hour);
	}

	public int getHour() {
		return hour;
	}

	@Override
	public String toString() {
		return "Hour [hour=" + hour + "]";
	}
	
}
