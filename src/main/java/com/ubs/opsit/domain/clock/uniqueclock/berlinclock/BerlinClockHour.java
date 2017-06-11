package com.ubs.opsit.domain.clock.uniqueclock.berlinclock;

import static com.ubs.opsit.utility.Constants.INVALID_HOUR_FORMAT;
import static com.ubs.opsit.utility.Constants.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

import com.ubs.opsit.domain.clock.standardclock.Hour;

public final class BerlinClockHour{

	private final Hour hour;
	private final List<List<BerlinClockLight>> berlinClockHourLights = new ArrayList<>();
	
	private final Function<Hour, Hour> validateAndGetHour = (hour) -> {
		if(hour == null){
			throw new IllegalArgumentException(INVALID_HOUR_FORMAT);
		}
		return hour;
	};
	
	public BerlinClockHour(final Hour hour) {
		super();
		
		
		this.hour = validateAndGetHour.apply(hour);
		intializeBrelinClockHourLights.accept(hour);
	}

	private final BiConsumer<Integer,Integer> switchOnBerlinClockHourLightsForRow = (rowIndex,index) -> {
		while(index > 0){
			berlinClockHourLights.get(rowIndex).set(--index, BerlinClockLight.RED_LIGHT);
		}
	}; 

	private final Function<Integer,List<BerlinClockLight>> defaultIntialiseBerlinClockHourLights = (index) ->{
		List<BerlinClockLight> defaultBerlinClockHourLights = new ArrayList<>();
		for(int i=0; i<index; i++){
			defaultBerlinClockHourLights.add(BerlinClockLight.OFF);
		}
		return defaultBerlinClockHourLights;
		
	};
	
	private final Consumer<Hour> intializeBrelinClockHourLights = (hour) -> {
		berlinClockHourLights.add(defaultIntialiseBerlinClockHourLights.apply(4));
		berlinClockHourLights.add(defaultIntialiseBerlinClockHourLights.apply(4));
		
		switchOnBerlinClockHourLightsForRow.accept(FIRST_ROW, hour.getHour() / 5);
		switchOnBerlinClockHourLightsForRow.accept(SECOND_ROW, hour.getHour() % 5);
	};
	

	public final String getBerlinHour(){

		return berlinClockHourLights.stream()
				.map(m -> m.stream()
						.collect(StringBuilder::new, 
								(berlinClockRowLights,berlinClockLight) -> {
									berlinClockRowLights.append( berlinClockLight.getLightValue());},
								(berlinClockLight1 , berlinClockLight2) -> { berlinClockLight1.append(berlinClockLight2);}))
				.reduce((hoursValueRow1,hoursValueRow2) -> { return hoursValueRow1.append(BERLIN_CLOCK_DELIMITER).append(hoursValueRow2);})
				.get().toString();
	}



}
