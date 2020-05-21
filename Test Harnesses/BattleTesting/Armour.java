/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         Armour.java                                          		  *
* Purpose:          Handles all characteristics of Armour Class.				  *
* Unit:             OOSE                                                          *
* Last Modified:    27/04/2020                                                    *
**********************************************************************************/
/*package Model;

//Import Custom Packages
import Controller.Exceptions.ArmourException;*/

public class Armour extends Item
{
	private int minDefence;
	private int maxDefence;
	private String material;
	private static final String itemType = "Armour";
	
	/*******************************************************************************
	* Submodule: Armour                                                            *
	* Import:    None                                                              *
	* Export:    None                                                              *
	* Assertion: Default Constructor for Armour.        						   *
	*******************************************************************************/
	public Armour()
	{
		super();
		minDefence = 0;
		maxDefence = 0;
		material = null;
	}
	
	/*******************************************************************************
	* Submodule: Armour                                                            *
	* Import:    inName (String), inCost (Integer), inMinDefence (Integer),		   *
	*			 inMaxDefence (Integer), inMaterial (String)					   *
	* Export:    None                                                              *
	* Assertion: Alternate Constructor for Armour.						           *
	*******************************************************************************/
	public Armour(String inName, int inMinDefence, int inMaxDefence, int inCost, String inMaterial)
	{
		super(inName, inCost);
		if ((validateInteger(inMinDefence)) && (validateInteger(inMaxDefence)) && (validateString(inMaterial)))
		{
			minDefence = inMinDefence;
			maxDefence = inMaxDefence;
			material = inMaterial;
		}
	}
	
	/*******************************************************************************
	*                                 ACCESSORS                                    *
	********************************************************************************
	*               Responsible for accessing all Armour classfields.              *
	*******************************************************************************/
	public int getMinDefence()
	{
		return minDefence;
	}
	
	public int getMaxDefence()
	{
		return maxDefence;
	}
	
	public int calcDefence()
	{
		return getRandomValue(minDefence, maxDefence);
	}
	
	public String getMaterial()
	{
		return material;
	}

	public String getItemType()
	{
		return itemType;
	}	
	
	public String toString()
	{
		return super.toString() + ", Minimum Defence: " + minDefence + ", Maximum Defence: " + maxDefence + ", Material: " + material;
	}
	
	/*******************************************************************************
	*                                MUTATORS                                      *
	********************************************************************************
	*                Responsible for setting all Armour classfields.               *
	*******************************************************************************/
	public void setMinDefence(int inMinDefence) throws ArmourException
	{
		if (validateInteger(inMinDefence))
		{
			minDefence = inMinDefence;
		}
		else
		{
			throw new ArmourException("Invalid Minimum Defence - Armour.");
		}
	}
	
	public void setMaxDefence(int inMaxDefence) throws ArmourException
	{
		if (validateInteger(inMaxDefence))
		{
			maxDefence = inMaxDefence;
		}
		else
		{
			throw new ArmourException("Invalid Maximum Defence - Armour.");
		}
	}
	
	public void setMaterial(String inMaterial) throws ArmourException
	{
		if (validateString(inMaterial))
		{
			material = inMaterial;
		}
		else
		{
			throw new ArmourException("Invalid Material - Armour.");
		}
	}
	
	private int getRandomValue(int inMinimum, int inMaximum)
	{
		int range = inMaximum - inMinimum + 1;
		int value = (int) (Math.random() * range) + inMinimum;
		return value;
	}
}		