package DrinkingBuddies;

import java.time.temporal.ChronoUnit;
import java.time.Clock;
import java.time.LocalDate;

public class DrinkingAgeCalculator {
	private final long drinkingAge = 18;
	private final Clock clock;
	
	public DrinkingAgeCalculator(Clock clock){
		this.clock=clock;
	}
	
	public boolean CanDrink(Person p) {
		if(p == null) throw new IllegalArgumentException("Person can't be null!");
		LocalDate now = LocalDate.now(clock);
		long years = ChronoUnit.YEARS.between(p.getBirthday(), now);
		if(years < 0) throw new IllegalArgumentException("Person can't not been born yet");
		return years >= drinkingAge;
	}
}
