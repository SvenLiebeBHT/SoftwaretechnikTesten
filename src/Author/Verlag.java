package Author;

public class Verlag {
	
	public final double eurosPerCharacter = 0.10;

	public Double BerechneHonorar(String Text) {
		if(Text == null)
			throw new IllegalArgumentException("Text can't be null!");
		String textWithoutSpaces = Text.replaceAll(" ", "");
		if(textWithoutSpaces.length() == 0) {
			throw new IllegalArgumentException("Text can't be empty!");
		}
		return Math.max(1.0, textWithoutSpaces.length() * eurosPerCharacter);
	}

}
