package edu.neumont.CSC180BidPage;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.bidpage.R;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;


import edu.neumont.csc180.mvc.Model;
import edu.neumont.csc180.mvc.View;

public class BidView extends RelativeLayout implements View<BidModel>, Model.Listener<BidModel>, OnClickListener
{
	private Button thineButton;
	private TextView thineCurrentPrice;
	private TextView thineDescription;
	private Animation thineAnimation;
	private Listener thineListener;
	private ImageView thineImage;
	private BidModel myBidModel;
	
	
	public BidView(Context thineContext, AttributeSet thineAttrs) 
	{ 
		super(thineContext, thineAttrs); 
		
	}
	
	public interface Listener extends View.Listener 
	{
		void placeBid(double amount);
		void setDefaultValues(Product product);
	}
	
	public BidModel getBidModel()
	{
		return myBidModel;
	}
	
	@Override
	protected void onFinishInflate() 
	{
		super.onFinishInflate();
		
		thineButton = (Button)findViewById(R.id.bid_btn);
		thineCurrentPrice = (TextView)findViewById(R.id.current_price);
		thineDescription = (TextView)findViewById(R.id.desc);
		thineImage = (ImageView)findViewById(R.id.img);
		thineAnimation = AnimationUtils.loadAnimation(thineButton.getContext(), R.anim.anim_alpha);
	
		thineButton.setOnClickListener(this);
		new LoadImageTask().execute("http://orig03.deviantart.net/49f0/f/2013/026/4/5/haunter_by_kawiko-d5sq5nk.png");
	}
	
	@Override
	public void onClick(android.view.View view)
	{
		thineListener.placeBid(0.93);
		view.startAnimation(thineAnimation);
	}
	
	@Override
	public void update(BidModel thineData)
	{
		DecimalFormat decimalFormat = new DecimalFormat("0.00");
		thineCurrentPrice.setText("Subject Price: $" + decimalFormat.format(thineData.getProduct().getCurrentBid()));
		myBidModel = thineData;
	}
	
	@Override
	public void updateDesc(BidModel thineData) 
	{
		thineDescription.setText(thineData.getProduct().getDescription());
	}
	
	@Override
	public void updateImg(BidModel thineData)
	{
		thineImage = thineData.getProduct().getImg();
	}
	
	public void setListener(View.Listener listener)
	{
		this.thineListener = (Listener)listener;
		((Listener) listener).setDefaultValues(new Product(1, "Haunter", "If you get the feeling of being watched in darkness when nobody is around, Haunter is there.", 93.00));
	}


	
	//Extra Credit, found online.
    private class LoadImageTask extends AsyncTask<String, Void, Bitmap> 
    {	
    	ImageView itemImage = (ImageView)findViewById(R.id.img);
    	
    	@Override
    	protected Bitmap doInBackground(String... arg0)
    	{
    		URL url = null;
    		Bitmap bmp = null;
    		
			try 
			{
				url = new URL(arg0[0]);
				bmp = BitmapFactory.decodeStream(url.openStream());
			} 
			catch(MalformedURLException e1) 
			{
				e1.printStackTrace();
			} 
			catch(IOException e) 
			{
    			e.printStackTrace();
    		}
			
    		return bmp;
    	}

    	@Override
    	protected void onPostExecute(Bitmap result){
    		itemImage.setImageBitmap(result);
    	}
    }
}
