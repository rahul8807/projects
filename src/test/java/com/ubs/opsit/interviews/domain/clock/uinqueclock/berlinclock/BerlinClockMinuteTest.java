package com.ubs.opsit.interviews.domain.clock.uinqueclock.berlinclock;

import org.junit.Assert;
import org.junit.Test;

import com.ubs.opsit.domain.clock.standardclock.Minute;
import com.ubs.opsit.domain.clock.uniqueclock.berlinclock.BerlinClockMinute;

public class BerlinClockMinuteTest {

	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionWhenMinuteIsNull(){
		BerlinClockMinute berlinMinute = new BerlinClockMinute(null);
		Assert.assertNotNull(berlinMinute);
	}
	
	@Test
	public void shouldGlowAllMinutesLightsWhenMinuteIsSetTo59Minutes(){
		BerlinClockMinute berlinMinute = new BerlinClockMinute(new Minute(59));
		Assert.assertEquals(berlinMinute.getBerlinMinute(), "YYRYYRYYRYY\r\nYYYY");
	}
	
	@Test
	public void shouldGlowAllMinutesLightsOfTopRowWhenMinuteIsSetTo55Minutes(){
		BerlinClockMinute berlinMinute = new BerlinClockMinute(new Minute(55));
		Assert.assertEquals(berlinMinute.getBerlinMinute(), "YYRYYRYYRYY\r\nOOOO");
	}
	
	@Test
	public void shouldGlowAllMinutesLightsOfBottomRowWhenMinuteIsSetTo4Minutes(){
		BerlinClockMinute berlinMinute = new BerlinClockMinute(new Minute(4));
		Assert.assertEquals(berlinMinute.getBerlinMinute(), "OOOOOOOOOOO\r\nYYYY");
	}
	
	@Test
	public void thisShouldIndicateFirstQuaterWhenMinuteIsSetTo15Minutes(){
		BerlinClockMinute berlinMinute = new BerlinClockMinute(new Minute(15));
		Assert.assertEquals(berlinMinute.getBerlinMinute(), "YYROOOOOOOO\r\nOOOO");
	}
	
	@Test
	public void thisShouldIndicateHalfWhenMinuteIsSetTo30Minutes(){
		BerlinClockMinute berlinMinute = new BerlinClockMinute(new Minute(30));
		Assert.assertEquals(berlinMinute.getBerlinMinute(), "YYRYYROOOOO\r\nOOOO");
	}
	
	@Test
	public void thisShouldIndicateLastQuaterWhenMinuteIsSetTo45Minutes(){
		BerlinClockMinute berlinMinute = new BerlinClockMinute(new Minute(45));
		Assert.assertEquals(berlinMinute.getBerlinMinute(), "YYRYYRYYROO\r\nOOOO");
	}
	
	@Test
	public void thisShouldSwitchOffAllMinutesLightHourWhenMinuteIsSetTo60Minutes(){
		BerlinClockMinute berlinMinute = new BerlinClockMinute(new Minute(00));
		Assert.assertEquals(berlinMinute.getBerlinMinute(), "OOOOOOOOOOO\r\nOOOO");
	}
}
