package com.ubs.opsit.interviews.domain.clock.standardclock;

import org.junit.Assert;
import org.junit.Test;

import com.ubs.opsit.domain.clock.standardclock.Second;

public class SecondTest {

	@Test
	public void thisSouldGetCorrectSecondWhenInputSecondIsBetweenZeroAnd59(){
		
		//Given
		int startSecond_0 = 0;
		int endSecond_59 = 59;

		//When Seconds between 0 and 59
		for(int i=startSecond_0; i<=endSecond_59; i++){
			Second second = new Second(i);
			
			//Then
			Assert.assertEquals(i, second.getSecond());
		}
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionWhenSecondSetIsLessThanZero(){
		
		//Given
		Integer ss = -1;

		//When
		Second second = new Second(ss);
		
		//Then
		Assert.assertNotNull(second.getSecond());
	}
	

	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionWhenSecondSetIsGreaterThan59(){
		
		//Given
		Integer ss = 60;

		//When
		Second second = new Second(ss);
		
		//Then
		Assert.assertNotNull(second.getSecond());
	}


	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExceptionWhenSecondSetIsNull(){
		
		//Given
		Integer ss = null;

		//When
		Second second = new Second(ss);
		
		//Then
		Assert.assertNotNull(second.getSecond());
	}
	
}
