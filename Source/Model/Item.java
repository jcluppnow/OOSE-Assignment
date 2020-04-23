package Model;
import Controller.Exceptions.ItemException;

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
	
	public void setItemName(String inName) throws ItemException
	{
		if (validateString(inName))
		{
			itemName = inName;
		}
		else
		{
			throw new ItemException("Invalid Item Name - Item.");
		}
	}
	
	public void setCost(int inCost) throws ItemException
	{
		if (validateInteger(inCost))
		{
			cost = inCost;
		}
		else
		{
			throw new ItemException("Invalid Item Cost - Item.");
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