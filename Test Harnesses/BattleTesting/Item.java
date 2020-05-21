/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         Item.java             			                              *
* Purpose:          Parent class for all Items.									  *                                                      *
* Unit:             OOSE                                                          *
* Last Modified:    27/04/2020                                                    *
**********************************************************************************/
/*package Model;

//Import Custom Packages
import Controller.Exceptions.ItemException;*/

public abstract class Item
{
	protected String itemName;
	protected int cost;
	
	/*******************************************************************************
	*                                 ACCESSORS                                    *
	********************************************************************************
	*               Responsible for accessing all Item classfields.                *
	*******************************************************************************/
	
	/*******************************************************************************
	* Submodule: Item                                                              *
	* Import:    None															   *
	* Export:    None                                                              *
	* Assertion: Default Constructor for Item.							           *
	*******************************************************************************/
	public Item()
	{
		itemName = null;
		cost = 0;
	}
	
	/*******************************************************************************
	* Submodule: Item                                                              *
	* Import:    inItemName (String), inCost (Integer)          				   *
	* Export:    None                                                              *
	* Assertion: Alternate Constructor for Item.						           *
	*******************************************************************************/
	public Item(String inItemName,  int inCost)
	{
		if ((validateString(inItemName)) && (validateInteger(inCost)))
		{
			itemName = inItemName;
			cost = inCost;
		}
	}
	
	public abstract String getItemType();
	
	public String getItemName()
	{
		return itemName;
	}
	
	public int getCost()
	{
		return cost;
	}
	
	/*******************************************************************************
	*                                MUTATORS                                      *
	********************************************************************************
	*                Responsible for setting all Item classfields.                 *
	*******************************************************************************/
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
	
	public String toString()
	{
		return ("Item Name: " + itemName + ", Cost: " + cost);
	}
	
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
		return (inInteger >= 0);
	}
}