package edu.neumont.CSC180BidPage;

import java.util.ArrayList;
import edu.neumont.csc180.mvc.Model;

public class SearchModel implements Model<SearchModel>
{
	
	Model.Listener<SearchModel> listener;
	ArrayList<BidModel> bidPages = new ArrayList<BidModel>();
	
	@Override
	public void setListener(edu.neumont.csc180.mvc.Model.Listener<SearchModel> listener) 
	{
		this.listener = listener;
		this.listener.update(this);
		
	}
	
	public ArrayList<BidModel> GetBidModelList()
	{
		return bidPages;
	}
	
	public void SetProducts(ArrayList<BidModel> productsList)
	{
		bidPages = productsList;
		listener.update(this);
	}
	
}
