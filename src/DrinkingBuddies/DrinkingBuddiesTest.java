package DrinkingBuddies;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class DrinkingBuddiesTest {
	static Person p1,p2,p3,p4,p5;
	static DrinkingAgeCalculator calc;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		p1 = new Person("Anna" , "Anneliese", LocalDate.of(2000, 11, 23));
		p2 = new Person("Bob", "Bobalski", LocalDate.of(2006, 5, 3));
		p3 = new Person("Carl", "Carlington", LocalDate.of(2005, 7, 4));
		p4 = new Person("Derril", "Lirred", LocalDate.of(2005, 7, 2));
		p5 = new Person("Emon", "Nome", LocalDate.of(2024, 12, 6));
		Clock clock = Clock.fixed(Instant.parse("2023-07-02T10:00:00Z"), ZoneId.of("UTC"));
		calc = new DrinkingAgeCalculator(clock);
	}

	@Test
	void testP1() {
		Assertions.assertTrue(calc.CanDrink(p1));
	}
	
	@Test
	void testP2() {
		Assertions.assertFalse(calc.CanDrink(p2));
	}
	@Test
	void testP3() {
		Assertions.assertFalse(calc.CanDrink(p3));
	}
	@Test
	void testP4() {
		Assertions.assertTrue(calc.CanDrink(p4));
	}
	@Test
	void testP5() {
		Throwable ex = Assertions.assertThrows(IllegalArgumentException.class, 
				() -> {calc.CanDrink(p5);});
		Assertions.assertTrue(ex.getMessage().contains("Person can't not been born yet"));
	}
	
	@Test
	void testNull() {
		Throwable ex = Assertions.assertThrows(IllegalArgumentException.class, 
				() -> {calc.CanDrink(null);});
		Assertions.assertTrue(ex.getMessage().contains("Person can't be null!"));
	}
}
