package DrinkingBuddies;

import java.time.LocalDate;

public class Person {
	private String firstName;
	private String lastName;
	private LocalDate birthday;
	
	public Person(String firstName, String lastName, LocalDate birthday) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;		
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public LocalDate getBirthday() {
		return this.birthday;
	}
}
