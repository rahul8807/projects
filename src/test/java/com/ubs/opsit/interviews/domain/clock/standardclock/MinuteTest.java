package com.ubs.opsit.interviews.domain.clock.standardclock;

import org.junit.Assert;
import org.junit.Test;

import com.ubs.opsit.domain.clock.standardclock.Minute;

public class MinuteTest {

	@Test
	public void thisSouldGetCorrectMinuteWhenInputMinuteIsBetweenZeroAnd59(){
		
		//Given
		int startMinute_0 = 0;
		int endMinute_59 = 59;

		//When Minutes between 0 and 59
		for(int i=startMinute_0; i<=endMinute_59; i++){
			Minute minute = new Minute(i);
			
			//Then
			Assert.assertEquals(i, minute.getMinute());
		}
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionWhenMinuteSetIsLessThanZero(){
		
		//Given
		Integer mm = -1;

		//When
		Minute minute = new Minute(mm);
		
		//Then
		Assert.assertNotNull(minute.getMinute());
	}
	

	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionWhenMinuteSetIsGreaterThan59(){
		
		//Given
		Integer mm = 60;

		//When
		Minute minute = new Minute(mm);
		
		//Then
		Assert.assertNotNull(minute.getMinute());
	}


	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionWhenMinuteSetIsNull(){
		
		//Given
		Integer mm = null;

		//When
		Minute minute = new Minute(mm);
		
		//Then
		Assert.assertNotNull(minute.getMinute());
	}
	
}
