package edu.neumont.CSC180BidPage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;


public class ItemServiceClient 
{
	private ArrayList<Product> allItems = new ArrayList<Product>();
	
	
	public ArrayList<Product> getAllItems()
	{
		return allItems;
	}

	public Product bid(long id, BigDecimal bidAmount)
	{
		for(int i = 0; i < allItems.size(); i++)
		{
			if(allItems.get(i).getId() == id)
			{
				allItems.get(i).setCurrentBid(allItems.get(i).getCurrentBid() + bidAmount.floatValue());
				return allItems.get(i);
			}
		}

		return null;
	}

	public Set<Product> Search(String whatToSearch)
	{
		Set<Product> searchedItems = new HashSet<Product>();
		Predicate<String> stringCheck = SetPredicates(whatToSearch);

		for(Product p : allItems)
		{
			if(stringCheck.test(p.getName()) || stringCheck.test(p.getDescription()))
			{
				searchedItems.add(p);
			}
		}
		return searchedItems;
	}


	private Stack<String> predicateStack = new Stack<String>();
	private Stack<String> operatorStack = new Stack<String>();
	private Stack<Predicate<String>> allPredicates = new Stack<Predicate<String>>();
	public Predicate<String> SetPredicates(String searchFilter)
	{
		for(String c : searchFilter.split(" "))
		{
			if(c.toLowerCase().contentEquals("or"))
			{
				if(operatorStack.peek().toLowerCase().contains("and"))
				{
					CondenseAnds();
					operatorStack.add(c);
				}
			}

			else if(c.toLowerCase().contentEquals("and"))
			{
				operatorStack.add(c);
			}

			else
			{
				predicateStack.add(c);
			}
		}

		while(!operatorStack.isEmpty())
		{
			CondenseAnds();
			CondenseOrs();
		}

		return allPredicates.pop();
	}


	//Condenses And Operators
	public Predicate<String> CondenseAnds()
	{
		Predicate<String> tempAnd = null;
		while(!operatorStack.isEmpty() && operatorStack.peek().toLowerCase().contentEquals("and"))		
		{
			if(tempAnd == null)
			{
				tempAnd = new AndPredicate(new PredicateHandler(predicateStack.pop()), new PredicateHandler(predicateStack.pop()));
			}
			else
			{
				tempAnd = new AndPredicate(tempAnd, new PredicateHandler(predicateStack.pop()));
			}
			operatorStack.pop();
		}
		
		allPredicates.add(tempAnd);

		return tempAnd;
	}

	//Condenses Or Operators
	public Predicate<String> CondenseOrs()
	{
		Predicate<String> tempOr = null;

		if(!operatorStack.isEmpty() && predicateStack.isEmpty())
		{
			while(operatorStack.peek().toLowerCase().contentEquals("or"))
			{
				if(tempOr == null)
				{
					tempOr = new OrPredicate(allPredicates.pop(), allPredicates.pop());
				}
				else
				{
					tempOr = new OrPredicate(tempOr, allPredicates.pop());
				}
				operatorStack.pop();
			}
			
			allPredicates.add(tempOr);
		}

		else if(!operatorStack.isEmpty())
		{
			if(allPredicates.isEmpty())
			{
				while(operatorStack.peek().toLowerCase().contentEquals("or"))
				{
					if(tempOr == null)
					{
						tempOr = new OrPredicate(new PredicateHandler(predicateStack.pop()), new PredicateHandler(predicateStack.pop()));
					}
					else
					{
						tempOr = new OrPredicate(tempOr, new PredicateHandler(predicateStack.pop()));
					}
					operatorStack.pop();
				}
				
				allPredicates.add(tempOr);
			}
			else
			{
				while(operatorStack.peek().toLowerCase().contentEquals("or"))
				{
					if(tempOr == null)
					{
						tempOr = new OrPredicate(new PredicateHandler(predicateStack.pop()), allPredicates.pop());
					}
					else if(predicateStack.isEmpty())
					{
						tempOr = new OrPredicate(tempOr, new PredicateHandler(predicateStack.pop()));
					}
					else 
					{
						tempOr = new OrPredicate(tempOr, allPredicates.pop());
					}
					operatorStack.pop();
				}
				
				allPredicates.add(tempOr);
			}
		}


		return tempOr;
	}


}
