package edu.neumont.CSC180BidPage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.example.bidpage.R;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class ItemStorage extends BaseAdapter
{
	private List<BidView> bidViews;
	
	public ItemStorage(Context context, Collection<BidModel> models)
	{
		bidViews = new ArrayList<BidView>();
		for(int i = 0; i < models.size(); i++)
		{
			BidView myViews = (BidView)android.view.View.inflate(context, R.layout.bidpage_controller, null);
			models.iterator().next().setListener(myViews);
			this.bidViews.add(myViews);
		}
	}
	
	@Override
	public int getCount() 
	{
		return bidViews.size();
	}

	@Override
	public Object getItem(int position) 
	{
		return bidViews.get(position).getBidModel();
	}

	@Override
	public long getItemId(int position) 
	{
		return (long)bidViews.get(position).getId();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) 
	{
		return bidViews.get(position);
	}
	
}
