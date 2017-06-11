package com.ubs.opsit.domain.clock.standardclock;

import java.util.function.Function;
import java.util.function.Predicate;

import static com.ubs.opsit.utility.Constants.*;
public final class Second {

	private final int second;
	
	private final Predicate<Integer> isSecondsDataValid  = (second) ->  ( second != null && (second >=  0 && second < 60) ); 
	private final Function<Integer, Integer> validateAndGetSecondsData = (second) ->{
		
		if(!isSecondsDataValid.test(second)){
			throw new IllegalArgumentException(INVALID_SECOND_FORMAT);
		}
		return second;
	};
	
	public Second(final Integer second) {
		this.second = validateAndGetSecondsData.apply(second);
	}

	public int getSecond() {
		return second;
	}

}
