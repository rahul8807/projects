package com.ubs.opsit.interviews.domain.clock.uinqueclock.berlinclock;

import org.junit.Assert;
import org.junit.Test;

import com.ubs.opsit.domain.clock.standardclock.Second;
import com.ubs.opsit.domain.clock.uniqueclock.berlinclock.BerlinCLockSecond;

public class BerlinClockSecondTest {


	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionWhenSecondIsNull(){
		BerlinCLockSecond berlinCLockSecond = new BerlinCLockSecond(null);
		Assert.assertNotNull(berlinCLockSecond);
	}
	
	@Test
	public void shouldGlowSecondsLightWhenSecondsIsFactorOf2(){
		BerlinCLockSecond berlinCLockSecond = new BerlinCLockSecond(new Second(2));
		Assert.assertEquals(berlinCLockSecond.getBerlinSecond(), "Y");
	}

	@Test
	public void shouldSwitchOffSecondsLightWhenSecondsIsNotAnFactorOf2(){
		BerlinCLockSecond berlinCLockSecond = new BerlinCLockSecond(new Second(3));
		Assert.assertEquals(berlinCLockSecond.getBerlinSecond(), "O");
	}
}
