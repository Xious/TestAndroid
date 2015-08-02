package edu.neumont.CSC180BidPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

import edu.neumont.csc180.mvc.Controller;

public class SearchController extends Controller<SearchModel> implements SearchListener
{

	public ItemServiceClient ISClient;
	
	public SearchController()
	{
		super(new SearchModel(), "search_result_layout");
		ISClient = new ItemServiceClient();
	}
	@Override
	public void ClickedItem(String clickedItem) 
	{
		ArrayList<BidModel> itemChoices = model.GetBidModelList();
		String[] itemDetails = clickedItem.split(":");
		Product temp = null;
		
		for(int i = 0; i < itemChoices.size(); i++)
		{
			if(itemChoices.get(i).getProduct().getName().contentEquals(itemDetails[0]))
			{
				temp = itemChoices.get(i).getProduct();
			}
		}
		
		model.SetProducts(itemChoices);
		BidModel tempModel = new BidModel(temp);
		goTo(tempModel, "bidpage_controller", MainActivity.class);
	}

	@Override
	public void Search(String searchedItems) 
	{
		Set<Product> bidItems = ISClient.Search(searchedItems);
		ArrayList<BidModel> bidModels = new ArrayList<BidModel>();
		
		for(int i = 0; i < bidItems.size(); i++)
		{
			bidModels.add(new BidModel(bidItems.iterator().next()));
		}
		model.SetProducts(bidModels);
	}

	@Override
	public void Start() 
	{
		ArrayList<BidModel> bidModels = new ArrayList<BidModel>();
		
		for(int i = 0; i < ISClient.getAllItems().size(); i++)
		{
			bidModels.add(new BidModel(ISClient.getAllItems().get(i)));
		}
		model.SetProducts(bidModels);
	}
	
}
