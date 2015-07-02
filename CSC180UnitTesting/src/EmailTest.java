import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.junit.Assert;
import org.junit.Test;


public class EmailTest 
{
	Email email = new Email("you@example.com", "me@example.com","Hello!","This content is only a test, thank you.");
	
	@Test
	public void testEmailInputStream() throws IOException
	{
		String testIS = "From: me@example" + "\n"
						+ "To: you@example" + "\n"
						+ "Subject: Hi" + "\n"
						+ "This is random content.";
		
		InputStream stream = new ByteArrayInputStream(testIS.getBytes(StandardCharsets.UTF_8));
		
		Email isTest = new Email(stream);
		
		Assert.assertEquals(isTest.getFrom(), "me@example");
		Assert.assertEquals(isTest.getTo(), "you@example");
		Assert.assertEquals(isTest.getSubject(), "Hi");
		Assert.assertEquals(isTest.getContent(), "This is random content.");
		
	}
	
	@Test
	public void testEmailInputStreamExceptions() throws IOException
	{
		String testIS = "me@example" + "\n"
						+ "To: you@example" + "\n"
						+ "Subject: Hi" + "\n"
						+ "This is random content.";
		
		boolean argumentThrown = false;
		
		InputStream stream = new ByteArrayInputStream(testIS.getBytes(StandardCharsets.UTF_8));
		
		try
		{
			@SuppressWarnings("unused")
			Email isTest = new Email(stream);
		}
		catch(IllegalArgumentException ignored)
		{
			argumentThrown = true;
		}
		
		Assert.assertTrue(argumentThrown);	
	}
	
	@Test
	public void testGetTo() 
	{
		Assert.assertEquals("you@example.com", email.getTo());
	}

	@Test
	public void testGetFrom() 
	{
		Assert.assertEquals("me@example.com", email.getFrom());
	}

	@Test
	public void testGetSubject() 
	{
		Assert.assertEquals("Hello!", email.getSubject());
	}

	@Test
	public void testGetContent() 
	{
		Assert.assertEquals("This content is only a test, thank you.", email.getContent());
	}

}
