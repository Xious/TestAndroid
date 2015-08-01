import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class DateFormatiingAndParsing 
{
	
//	public void DoThis(Calendar cal)
//	{
//		date.add(Calendar.Date, 1);
//		return date;
//	}
	
	
	public static void main(String[] args) throws ParseException
	{
		Scanner input = new Scanner(System.in);
		
		//Ask for BDay
		System.out.println("Welcome to MafiaPlusPlus. " + "Please enter your birthday. (MM/dd/yyyy)");
		String bday = input.nextLine();
		
		//Ask for $$$
		System.out.println("Please enter your current bank balance: ");
		String balance = input.nextLine();
				
		//Date Formatting
		SimpleDateFormat in = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat out = new SimpleDateFormat("MMMM dd, yyyy");
		
		Date birthDate = in.parse(bday);
		System.out.printf("You're birthday is: %s", out.format(birthDate) + "\n");
		
		
		//Currency Formatting
		NumberFormat withDollarSign = NumberFormat.getCurrencyInstance();
		NumberFormat withoutDollarSign = NumberFormat.getNumberInstance();
		
		// HOW TO SUPPORT MULTIPLE FORMATS??
		Number money = withoutDollarSign.parse(balance);
		System.out.println("You're bank account balance is: " + withDollarSign.format(money));
		
		//Calenday information
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2012);
		cal.set(Calendar.MONTH, 3);
		cal.set(Calendar.DATE, 4);
		
		
		System.out.println("\n \nBelow is the Calendar information: \n" + cal);
		System.out.println(cal.getTime());
		System.out.println(out.format(cal.getTime()));
		
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
		
		input.close();
		
//		Date date = new Date();  //Good for modularity, but has a lot of issues. (Bad to use for data object)
//		
//		System.out.println(date);
//		System.out.println(date.getTime());
//		
//		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy"); // "MM" = Month "mm" = minutes 3M will spell out the month
//		String formatted = sdf.format(date);
//		
//		System.out.println(formatted);
//		
//		Date parsed = sdf.parse(formatted);
//		System.out.println(parsed);
	}
}
