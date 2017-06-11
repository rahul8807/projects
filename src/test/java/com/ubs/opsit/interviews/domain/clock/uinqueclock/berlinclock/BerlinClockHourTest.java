package com.ubs.opsit.interviews.domain.clock.uinqueclock.berlinclock;

import org.junit.Assert;
import org.junit.Test;

import com.ubs.opsit.domain.clock.standardclock.Hour;
import com.ubs.opsit.domain.clock.uniqueclock.berlinclock.BerlinClockHour;

public class BerlinClockHourTest {
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionHourInputHourIsNull(){
		BerlinClockHour berlinHour = new BerlinClockHour(null);
		Assert.assertNotNull(berlinHour);
	}
	
	@Test
	public void thisShouldGlowAllHoursLightsWhenHourIsSetTo24Hours(){
		BerlinClockHour berlinHour = new BerlinClockHour(new Hour(24));
		Assert.assertEquals(berlinHour.getBerlinHour(), "RRRR\r\nRRRR");
	}
	
	@Test
	public void thisShouldSwitchOffAllHoursLightsWhenMidNightAndHourSetTo00Hours(){
		BerlinClockHour berlinHour = new BerlinClockHour(new Hour(00));
		Assert.assertEquals(berlinHour.getBerlinHour(), "OOOO\r\nOOOO");
	}
	
	@Test
	public void thisShouldGlowOffAllHoursLightsOfTopRowWhenTimeIsSetTo20Hours(){
		BerlinClockHour berlinHour = new BerlinClockHour(new Hour(20));
		Assert.assertEquals(berlinHour.getBerlinHour(), "RRRR\r\nOOOO");
	}
	
	@Test
	public void thisShouldGlowOffAllHoursLightsOfBottomRowWhenTimeIsSetTo4Hours(){
		BerlinClockHour berlinHour = new BerlinClockHour(new Hour(4));
		Assert.assertEquals(berlinHour.getBerlinHour(), "OOOO\r\nRRRR");
	}
}
