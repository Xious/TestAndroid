import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.junit.Assert;
import org.junit.Test;


public class SpamDetectorTest {

	@Test
	public void testSpamDetector() throws FileNotFoundException {
		
		
		Email realMail = new Email("you@example.com", "me@example.com","Hello!","This is NOT spam.");
		Email spamMail = new Email("you@example.com", "me@example.com", "bringing bringing bringing", "package package");
		
		FileInputStream spamFile = new FileInputStream("antispam-table.txt");
		
		SpamDetector mySpam = new SpamDetector(spamFile);
		
		
		Assert.assertFalse(mySpam.isSpam(realMail));
		Assert.assertTrue(mySpam.isSpam(spamMail));
	}

}
