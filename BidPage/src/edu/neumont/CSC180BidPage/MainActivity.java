package edu.neumont.CSC180BidPage;

import android.widget.Toast;

import edu.neumont.csc180.mvc.Controller;

public class MainActivity extends Controller<BidModel> implements BidView.Listener 
{	
	public MainActivity() 
	{
		super(new BidModel(), "bidpage_controller");
	}
	
	public MainActivity(Product product)
	{
		super(new BidModel(product), "bidpage_controller");
	}

	@Override
	public void setDefaultValues(Product thineProduct) 
	{
		model.setProduct(thineProduct);
		model.updateDesc();
		getActionBar().setTitle(thineProduct.toString());
	}
	
	@Override
	public void placeBid(double thinePlacedBid)
	{
		model.getProduct().setCurrentBid(thinePlacedBid);
		Toast.makeText(MainActivity.this.getApplicationContext(), "Hope you don't regret your decision, your bid is placed!", Toast.LENGTH_SHORT).show();
		model.update();
	}


}