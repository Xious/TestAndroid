package edu.neumont.CSC180BidPage;

import android.widget.ImageView;

public class Product 
{
	private int thineID;
	private String thineName;
	private String thineDescription;
	private double thineCurrentBid;
	private ImageView thineImage;
	
	public Product(int id, String name, String description, double currentBid)
	{
		thineID = id;
		thineName = name;
		thineDescription = description;
		thineCurrentBid = currentBid;
	}
	
	public Product(int id, String name, String description, double currentBid, ImageView img)
	{
		this(id,name,description,currentBid);
		thineImage = img;
	}

	public int getId() 
	{ 
		return thineID; 
		
	}
	
	public void setId(int id) 
	{ 
		thineID = id; 
		
	}
	
	public String getName() 
	{ 
		return thineName; 
		
	}
	
	public void setName(String name) 
	{ 
		thineName = name; 
		
	}
	
	public String getDescription() 
	{ 
		return thineDescription; 
		
	}
	
	public void setDescription(String description) 
	{ 
		thineDescription = description; 
		
	}
	
	public double getCurrentBid() 
	{ 
		return thineCurrentBid; 
		
	}
	
	public void setCurrentBid(double currentBid) 
	{ 
		thineCurrentBid += currentBid; 
		
	}
	
	public void setImg(ImageView itemImg)
	{ 
		thineImage = itemImg; 
		
	}
	
	public ImageView getImg() 
	{ 
		return thineImage; 
		
	}

	@Override
	public String toString() 
	{ 
		return thineName; 
		
	}

	@Override
	public int hashCode() 
	{
		final int thePrime = 31;
		int theResult = 1;
		long temp;
		temp = Double.doubleToLongBits(thineCurrentBid);
		theResult = thePrime * theResult + (int) (temp ^ (temp >>> 32));
		theResult = thePrime * theResult + ((thineDescription == null) ? 0 : thineDescription.hashCode());
		theResult = thePrime * theResult + thineID;
		theResult = thePrime * theResult + ((thineName == null) ? 0 : thineName.hashCode());
		return theResult;
	}

	@Override
	public boolean equals(Object obj) 
	{
		Product other = (Product) obj;
		
		if (this == obj) 
		{ 
			return true; 
			
		}
		
		if (obj == null) 
		{ 
			return false; 
			
		}
		
		if (getClass() != obj.getClass()) 
		{ 
			return false; 
			
		}
		
		if (Double.doubleToLongBits(thineCurrentBid) != Double.doubleToLongBits(other.thineCurrentBid)) 
		{ 
			return false; 
			
		}
		
		if (thineDescription == null) 
		{
			if (other.thineDescription != null) { return false; }
		} 
		
		else if (!thineDescription.equals(other.thineDescription)) 
		{ 
			return false; 
			
		}
		
		if (thineID != other.thineID) 
		{ 
			return false; 
			
		}
		
		if (thineName == null) 
		{
			if (other.thineName != null) 
			{ 
				return false; 
				
			}
		} 
		else if (!thineName.equals(other.thineName)) 
		{ 
			return false; 
			
		}
		
		return true;
	}
}
