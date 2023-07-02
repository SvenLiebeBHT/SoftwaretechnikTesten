package DrinkingBuddies;

import java.time.temporal.ChronoUnit;
import java.time.Clock;
import java.time.LocalDate;

public class DrinkingAgeCalculator {
	private final long liqueurDrinkingAge = 18;
	private final long beerDrinkingAge = 16;
	private final Clock clock;
	
	public DrinkingAgeCalculator(Clock clock){
		this.clock=clock;
	}
	
	public boolean CanDrinkLiquer(Person p) {
		return CanDrink(p, this.liqueurDrinkingAge);
	}
	
	public boolean CanDrinkBeer(Person p) {
		return CanDrink(p, this.beerDrinkingAge);
	}
	
	private boolean CanDrink(Person p, long ageLimit) {
		if(p == null) throw new IllegalArgumentException("Person can't be null!");
		LocalDate now = LocalDate.now(clock);
		long years = ChronoUnit.YEARS.between(p.getBirthday(), now);
		if(years < 0) throw new IllegalArgumentException("Person can't not been born yet");
		return years >= ageLimit;
	}
	

}
