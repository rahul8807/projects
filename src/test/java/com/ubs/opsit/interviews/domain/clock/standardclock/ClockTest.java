package com.ubs.opsit.interviews.domain.clock.standardclock;


import org.junit.Assert;
import org.junit.Test;

import com.ubs.opsit.domain.clock.standardclock.Clock;

public class ClockTest {

	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionWhenTimeIsNull(){
		Clock clock = new Clock(null);
		Assert.assertNotNull(clock);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionWhenTimeIsEmpty(){
		Clock clock = new Clock("");
		Assert.assertNotNull(clock);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionWhenTimeIsEmptyString(){
		Clock clock = new Clock(" ");
		Assert.assertNotNull(clock);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionWhenTimeIsInvalidTimeFormat(){
		Clock clock = new Clock("23:45");
		Assert.assertNotNull(clock);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionWhenTimeIsInvalidWhenMilliSecondsIsAppended(){
		Clock clock = new Clock("23:45:00:00");
		Assert.assertNotNull(clock);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionWhenTimeIsInvalidString(){
		Clock clock = new Clock("23:45:ONE");
		Assert.assertNotNull(clock);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionWhenTimeIsInvalid24HoursFormat(){
		Clock clock = new Clock("24:01:02");
		Assert.assertNotNull(clock);
	}
	
	@Test
	public void shouldGetStandardTimeWhenTimeIsValid24HoursFormat(){
		Clock clock = new Clock("10:01:02");
		Assert.assertEquals(clock.getClockHour().getHour(), 10);
		Assert.assertEquals(clock.getClockMinute().getMinute(), 1);
		Assert.assertEquals(clock.getClockSecond().getSecond(), 2);
	}
	
	@Test
	public void shouldGetStandardTimeWhenTimeIsValid24HoursFormatAndTimeIsMidNight(){
		Clock clock = new Clock("00:00:00");
		Assert.assertEquals(clock.getClockHour().getHour(), 0);
		Assert.assertEquals(clock.getClockMinute().getMinute(), 0);
		Assert.assertEquals(clock.getClockSecond().getSecond(), 0);
	}
	
	@Test
	public void shouldGetStandardTimeWhenTimeIsValid24HoursFormatAndTimeIsMidNight24Hours(){
		Clock clock = new Clock("24:00:00");
		Assert.assertEquals(clock.getClockHour().getHour(), 24);
		Assert.assertEquals(clock.getClockMinute().getMinute(), 0);
		Assert.assertEquals(clock.getClockSecond().getSecond(), 0);
	}
}
