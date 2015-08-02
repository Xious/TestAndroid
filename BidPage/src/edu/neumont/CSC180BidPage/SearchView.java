package edu.neumont.CSC180BidPage;

import java.util.ArrayList;

import com.example.bidpage.R;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;
import edu.neumont.csc180.mvc.View;

public class SearchView extends LinearLayout implements View<SearchModel>, OnItemClickListener
{
	private EditText mySearchText;
	private Button searchButton;
	private ListView myLayout;
	private SearchListener myListener;

	public SearchView(Context context, AttributeSet attrs) 
	{
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void onFinishInflate()
	{
		super.onFinishInflate();
		mySearchText = (EditText)findViewById(R.id.MySearchField);
		searchButton = (Button)findViewById(R.id.SearchButton);
		myLayout = (ListView)findViewById(R.id.MyListView);
		
		myLayout.setOnItemClickListener(this);
		
		searchButton.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(android.view.View v) 
			{
				myListener.Search(mySearchText.getText().toString());
			}
			
		});
		
	}
	
	@Override
	public void onItemClick(AdapterView<?> parent, android.view.View view, int position, long id) 
	{
		myListener.ClickedItem((String)(myLayout.getItemAtPosition(position)));
	}


	@Override
	public void update(SearchModel data)
	{
		ArrayList<BidModel> moreBidItems = data.GetBidModelList();
		String[] items = new String[moreBidItems.size()];
		
		for(int i =0; i < items.length; i++)
		{
			String name = moreBidItems.get(i).getProduct().getName();
			double itemPrice = moreBidItems.get(i).getProduct().getCurrentBid();
			items[i] = name + ": $" + itemPrice;
		}
		
		ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_list_item_1, items);
		myLayout.setAdapter(myAdapter);
	}

	@Override
	public void updateDesc(SearchModel data) 
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void updateImg(SearchModel data) 
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void setListener(edu.neumont.csc180.mvc.View.Listener listener) 
	{
		myListener = (SearchListener)listener;
		myListener.Start();
		
	}


}
