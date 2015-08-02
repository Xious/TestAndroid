package edu.neumont.CSC180BidPage;

import edu.neumont.CSC180BidPage.Predicate;

public class PredicateHandler<T extends String> implements Predicate<T>
{
	T leftStack;
	public PredicateHandler(T argument)
	{
		leftStack = argument;
	}

	@Override
	public boolean test(T itemToBeTested) 
	{
		return itemToBeTested.toString().contains(leftStack) || 
				itemToBeTested.toString().contains(leftStack.toLowerCase()) || 
				itemToBeTested.toString().contains(leftStack.toUpperCase());
	
	}
	
}
