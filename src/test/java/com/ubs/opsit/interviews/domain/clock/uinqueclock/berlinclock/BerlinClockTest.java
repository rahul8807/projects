package com.ubs.opsit.interviews.domain.clock.uinqueclock.berlinclock;

import org.junit.Assert;
import org.junit.Test;

import com.ubs.opsit.domain.clock.uniqueclock.berlinclock.BerlinClock;

public class BerlinClockTest {

	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionWhenTimeIsNull(){
		BerlinClock berlinCLock = new BerlinClock();
		Assert.assertNotNull(berlinCLock.convertTime(null));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionWhenTimeIsSetEmpty(){
		BerlinClock berlinCLock = new BerlinClock();
		Assert.assertNotNull(berlinCLock.convertTime(""));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionWhenTimeIsInvalid(){
		BerlinClock berlinCLock = new BerlinClock();
		Assert.assertNotNull(berlinCLock.convertTime("22:00:THIRTY"));
	}
	
	@Test
	public void shouldGlowAllHoursLightWhenBerlinTimeIsMidNight24Hours(){
		BerlinClock berlinCLock = new BerlinClock();
		Assert.assertEquals(berlinCLock.convertTime("24:00:00"), "Y\r\nRRRR\r\nRRRR\r\nOOOOOOOOOOO\r\nOOOO");
	}
	
	@Test
	public void shouldGlowOnlySecondsLightWhenBerlinTimeIsMidNight00Hours(){
		BerlinClock berlinCLock = new BerlinClock();
		Assert.assertEquals(berlinCLock.convertTime("00:00:00"), "Y\r\nOOOO\r\nOOOO\r\nOOOOOOOOOOO\r\nOOOO");
	}
	
	@Test
	public void shouldGlowAllMinutesLightWhenBerlinTimeIs23_59_59Hours(){
		BerlinClock berlinCLock = new BerlinClock();
		Assert.assertEquals(berlinCLock.convertTime("23:59:59"), "O\r\nRRRR\r\nRRRO\r\nYYRYYRYYRYY\r\nYYYY");
	}

}
