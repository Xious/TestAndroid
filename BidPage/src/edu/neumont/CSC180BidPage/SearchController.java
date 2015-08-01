package edu.neumont.CSC180BidPage;

import edu.neumont.csc180.mvc.Controller;

public class SearchController extends Controller<SearchModel> implements SearchListener
{

	public SearchController()
	{
		super(new SearchModel(), "search_result_layout");
	}
	@Override
	public void ClickedItem(String clickedItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Search(String searchedItems) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Start() {
		// TODO Auto-generated method stub
		
	}
	
}
