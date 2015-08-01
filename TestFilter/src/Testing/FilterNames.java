package Testing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;


public class FilterNames 
{
	private ArrayList<String> myNames = new ArrayList<String>();
	private ArrayList<String> filteredNames = new ArrayList<String>();
	private String target;
	
	public void PopulateNames()
	{
		myNames.add("Joseph");
		myNames.add("Greg");
		myNames.add("Jerimiah");
		myNames.add("Corey");
		myNames.add("Josh");
		myNames.add("Kelsey");
		
		System.out.println("The current list of names: " + myNames);
		System.out.println();
	}
	
	public String GetUserInput()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the letter you would like to filter the names by:");
		target = in.nextLine();
		in.close();
		
		return target;
	}
	
	public void FilterStrings(String targetFilter)
	{
		targetFilter = target;
		
		for(int i = 0; i<myNames.size(); i++)
		{
			if(myNames.get(i).startsWith(targetFilter.toUpperCase()) || myNames.get(i).startsWith(targetFilter.toLowerCase()))
			{
				filteredNames.add(myNames.get(i));
			}
		}		
		System.out.print(filteredNames.size() + " name(s) was/were found: ");
		System.out.println(filteredNames);
	}
	
	public static void main(String [] args)
	{
		FilterNames fn = new FilterNames();
		fn.PopulateNames();
		String targetFilter = fn.GetUserInput();
		fn.FilterStrings(targetFilter);
	}
	
	
}