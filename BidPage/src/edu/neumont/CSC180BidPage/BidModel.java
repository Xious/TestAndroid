package edu.neumont.CSC180BidPage;

import android.util.Log;


import edu.neumont.csc180.mvc.Model;

public class BidModel implements Model<BidModel>
{
	private Model.Listener<BidModel> listener;
	private Product thineProduct = new Product(0, "", "", 93.00);
	
	public void setProduct(Product product)
	{
		double thineBid = product.getCurrentBid();
		String thineDescription = product.getDescription();
		
		Log.d("Description", thineDescription);
		thineProduct = product;
		
		
		//Updates the price
		if(!thineDescription.equalsIgnoreCase(product.getDescription()))
		{
			listener.updateDesc(this);
		}
		else if(thineBid != product.getCurrentBid())
		{
			listener.update(this);
		}
	}
	
	@Override
	public void setListener(edu.neumont.csc180.mvc.Model.Listener<BidModel> thineListener) 
	{
		listener = thineListener;
		thineListener.update(this);
	}
	
	public Product getProduct() 
	{ 
		return thineProduct; 
		
	}
	
	public void update() 
	{ 
		listener.update(this); 
		
	}
	
	public void updateDesc() 
	{ 
		listener.updateDesc(this); 
		
	}
}
