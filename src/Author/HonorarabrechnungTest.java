package Author;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class HonorarabrechnungTest {
	private static Verlag v;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		v = new Verlag();
	}

	@Test
	void HonorarabrechnungStandard() {
		Assertions.assertEquals(2.0, v.BerechneHonorar("Dies sind 20 Buchstaben"));
	}
	
	@Test
	void HonorarabrechnungMindestbetrag() {
		//Immer mindestens 1€
		Assertions.assertEquals(1.0, v.BerechneHonorar("Hallo"));
	}
	
	@Test
	void HonorarabrechnungError() {
		Throwable ex = Assertions.assertThrows(IllegalArgumentException.class, ()->{v.BerechneHonorar(null);});
		Assertions.assertTrue(ex.getMessage().contains("Text can't be null!"));
	}
	

	void HonorarabrechnungNoCharacters() {
		Throwable ex = Assertions.assertThrows(IllegalArgumentException.class, ()->{v.BerechneHonorar("     ");});
		Assertions.assertTrue(ex.getMessage().contains("Text can't be empty!"));
	}

}
