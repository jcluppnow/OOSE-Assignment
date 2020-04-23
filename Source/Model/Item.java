package Model;

public class Item
{
	protected String itemName;
	protected int cost;
	
	//Accessors	
	public Item()
	{
		itemName = null;
		cost = 0;
	}
	
	public Item(String inItemName,  int inCost)
	{
		if ((validateString(inItemName)) && (validateInteger(inCost)))
		{
			itemName = inItemName;
			cost = inCost;
		}
	}
	
	public String getItemName()
	{
		return itemName;
	}
	
	public int getCost()
	{
		return cost;
	}
	
	public void setItemName(String inName)
	{
		if (validateString(inName))
		{
			itemName = inName;
		}
	}
	
	public void setCost(int inCost)
	{
		if (validateInteger(inCost))
		{
			cost = inCost;
		}
	}
	
	//Private Submodules
	protected boolean validateString(String inName)
	{
		boolean validName = true;
		String emptyString = "";
		if (inName.equals(emptyString))
		{
			validName = false;
		}
		return validName;
	}
	
	protected boolean validateInteger(int inInteger)
	{
		return (inInteger > 0);
	}
}