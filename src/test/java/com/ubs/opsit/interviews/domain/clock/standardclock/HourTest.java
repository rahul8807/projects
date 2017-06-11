package com.ubs.opsit.interviews.domain.clock.standardclock;

import org.junit.Assert;
import org.junit.Test;

import com.ubs.opsit.domain.clock.standardclock.Hour;

public class HourTest {

	@Test
	public void thisSouldGetCorrectHourWhenInputHourIsBetweenZeroAnd23(){
		
		//Given
		int startHour_0 = 0;
		int endEour_24 = 24;

		//When Hours between 0 and 23
		for(int i=startHour_0; i<=endEour_24; i++){
			Hour hour = new Hour(i);
			
			//Then
			Assert.assertEquals(i, hour.getHour());
		}
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionWhenHourSetIsLessThanZero(){
		
		//Given
		Integer hh = -1;

		//When
		Hour hour = new Hour(hh);
		
		//Then
		Assert.assertNotNull(hour.getHour());
	}
	

	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionWhenHourSetIsGreaterThan24(){
		
		//Given
		Integer hh = 25;

		//When
		Hour hour = new Hour(hh);
		
		//Then
		Assert.assertNotNull(hour.getHour());
	}


	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionWhenHourSetIsNull(){
		
		//Given
		Integer hh = null;

		//When
		Hour hour = new Hour(hh);
		
		//Then
		Assert.assertNotNull(hour.getHour());
	}
	
}
