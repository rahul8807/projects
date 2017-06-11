package com.ubs.opsit.domain.clock.uniqueclock.berlinclock;

import static com.ubs.opsit.utility.Constants.INVALID_MINUTE_FORMAT;
import static com.ubs.opsit.utility.Constants.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

import com.ubs.opsit.domain.clock.standardclock.Minute;
public final class BerlinClockMinute {

	
	private final Minute minute;
	private final List<List<BerlinClockLight>> berlinClockMinuteLights = new ArrayList<>();
	
	private final Function<Minute, Minute> validateAndGetMinute = (minute) -> {
		if(minute == null){
			throw new IllegalArgumentException(INVALID_MINUTE_FORMAT);
		}
		return minute;
	};
	
	public BerlinClockMinute(final Minute minute) {
		super();
		this.minute = validateAndGetMinute.apply(minute);
		intializeBrelinClockMinuteLights.accept(minute);
	}

	private final BiConsumer<Integer,Integer> switchOnBerlinClockMinuteLightsForRow1 = (rowIndex,index) -> {
		while(index > 0){
			BerlinClockLight light = ((index % 3 == 0)?BerlinClockLight.RED_LIGHT:BerlinClockLight.YELLOW_LIGHT);
			berlinClockMinuteLights.get(rowIndex).set(--index, light);
		}
	}; 

	private final BiConsumer<Integer,Integer> switchOnBerlinClockMinuteLightsForRow2 = (rowIndex,index) -> {
		while(index > 0){
			berlinClockMinuteLights.get(rowIndex).set(--index, BerlinClockLight.YELLOW_LIGHT);
		}
	};
	
	private final Function<Integer,List<BerlinClockLight>> defaultIntialiseBerlinClockMinuteLights = (index) ->{
		List<BerlinClockLight> defaultBerlinClockHourLights = new ArrayList<>();
		for(int i=0; i<index; i++){
			defaultBerlinClockHourLights.add(BerlinClockLight.OFF);
		}
		return defaultBerlinClockHourLights;
		
	};
	
	private final Consumer<Minute> intializeBrelinClockMinuteLights = (minute) -> {
		berlinClockMinuteLights.add(defaultIntialiseBerlinClockMinuteLights.apply(11));
		berlinClockMinuteLights.add(defaultIntialiseBerlinClockMinuteLights.apply(4));
		
		switchOnBerlinClockMinuteLightsForRow1.accept(FIRST_ROW, minute.getMinute() / 5);
		switchOnBerlinClockMinuteLightsForRow2.accept(SECOND_ROW, minute.getMinute() % 5);
	};
	

	public final String getBerlinMinute(){

		return berlinClockMinuteLights.stream()
				.map(m -> m.stream()
						.collect(StringBuilder::new, 
								(berlinClockRowLights,berlinClockLight) -> {
									berlinClockRowLights.append( berlinClockLight.getLightValue());},
								(berlinClockLight1 , berlinClockLight2) -> { berlinClockLight1.append(berlinClockLight2);}))
				.reduce((hoursValueRow1,hoursValueRow2) -> { return hoursValueRow1.append(BERLIN_CLOCK_DELIMITER).append(hoursValueRow2);})
				.get().toString();
	}
}
