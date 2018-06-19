package cz.moneta;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Ignore;
import org.junit.Test;

public class TextServiceTest {
	
	private final TextService tested = new TextServiceImpl();
			
	@Test
	public void transformNothing() {
		assertNull(tested.transform(null));
	}	
	
	@Test
	public void transformEmptyString() {
		assertEquals("", tested.transform(""));
	}
	
	@Test
	public void transformOneCharToUpperCase() {
		assertEquals("A", tested.transform("a"));
	}
	
	@Test
	public void transformOneCharToLowerCase() {
		assertEquals("r", tested.transform("R"));
	}
	
	@Test
	public void transformTwoCharacters() {
		assertEquals("Ba", tested.transform("ab"));
	}
	
	@Test
	public void transformWithSpaceReduction() {
		assertEquals(" t s r", tested.transform("r   s  t       "));
	}
	
	@Test
	@Ignore
	public void transformSentence() {
		assertEquals("?šÁm es kaj ,jOha", tested.transform("Ahoj, jak se máš?"));
	}
	
	@Test
	public void transformAnotherSentence() {
		assertEquals(".NjaF iM ej", tested.transform("Je mi fajn."));
	}

}
