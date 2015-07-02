import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;


public class WordFeatureTest {
	WordFeature myWord = new WordFeature("MyWord", 7, 10);
	double delta = 0.3;

	@Test
	public void testWordFeature() {
		Assert.assertEquals(myWord.getHamCount(), 7, delta);
		Assert.assertEquals(myWord.getSpamCount(), 10, delta);
	}

	@Test
	public void testGetSpamCount() {
		Assert.assertEquals(10, myWord.getSpamCount(), delta);
	}

	@Test
	public void testGetHamCount() {
		Assert.assertEquals(7, myWord.getHamCount(), delta);
	}

	@Test
	public void testGetWord() {
		Assert.assertEquals("MyWord", myWord.getWord());
	}

}
