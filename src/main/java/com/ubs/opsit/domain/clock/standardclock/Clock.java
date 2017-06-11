package com.ubs.opsit.domain.clock.standardclock;

import java.util.function.Function;

import com.ubs.opsit.interviews.TimeConverter;
import static com.ubs.opsit.utility.Constants.*;

public final class Clock implements TimeConverter {

	private static final int HH = 0;
	private static final int MM = 1;
	private static final int SS = 2;
	
	private final Hour hour;
	private final Minute minute;
	private final Second second;
	
	private final Function<String, Integer[]> validateAndGetTime = (aTime) ->{
		
		Integer time[] = null;
		
		if(aTime == null || aTime.trim().isEmpty()){
			throw new IllegalArgumentException(INVALID_TIME_FORMAT+aTime);
		}
		
		String[] standardTimeValue = aTime.split(":");
		
		if(standardTimeValue.length!=3){
			throw new IllegalArgumentException(INVALID_TIME_FORMAT+aTime);
		}
		
		try{
			time = new Integer[3];
			time[0] = Integer.parseInt(standardTimeValue[0]);
			time[1] = Integer.parseInt(standardTimeValue[1]);
			time[2] = Integer.parseInt(standardTimeValue[2]);
		}catch(NumberFormatException e){
			throw new IllegalArgumentException(INVALID_TIME_FORMAT+aTime);
		}
		
		if(time[0].equals(24) && time[1] > 0 && time[2] >0 ){
			throw new IllegalArgumentException(INVALID_TIME_FORMAT+aTime);
		}
		
		return time;
	};
	
	
	public Clock(final Hour hour,final Minute minute,final Second second) {
		super();
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	public Clock(String aTime) {
		super();
		Integer[] time = validateAndGetTime.apply(aTime);
		this.hour = new Hour(time[HH]);
		this.minute = new Minute(time[MM]);
		this.second = new Second(time[SS]);
		
	}
	
	public Hour getClockHour() {
		return hour;
	}
	public Minute getClockMinute() {
		return minute;
	}
	public Second getClockSecond() {
		return second;
	}

	@Override
	public String convertTime(String aTime) {
		Clock clock = new Clock(aTime);
		return clock.getClockHour().getHour()+":"+clock.getClockMinute().getMinute()+":"+clock.getClockSecond();
	}
	
	@Override
	public String toString() {
		return "Clock [hour=" + hour + ", minute=" + minute + ", second=" + second + "]";
	}
}
