import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;


public class MafiaPlusPlus 
{
	public void AskForBirthday()
	{
		System.out.println("What is your Birthday? (EX: mm/dd/yyyy)");
	}
	
	private String GetBirthdayInput()
	{
		Scanner bday = new Scanner(System.in);
		
		String birthday = bday.nextLine();
		
		return birthday;
	}
	
	
	
	public static void main(String[] args)
	{
		MafiaPlusPlus mpp = new MafiaPlusPlus();
		mpp.AskForBirthday();
		mpp.GetBirthdayInput();
	}
}
