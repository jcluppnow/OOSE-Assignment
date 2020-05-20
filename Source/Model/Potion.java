/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         Potion.java  												  *
* Purpose:          Handles all Potion Functionality.							  *
* Unit:             OOSE                                                          *
* Last Modified:    27/04/2020                                                    *
**********************************************************************************/
package Model;

//Import Custom Packages
import Controller.Exceptions.PotionException;

public class Potion extends Item
{
	private int minEffect;
	private int maxEffect;
	private char type;
	private static final String itemType = "Potion";
	
	/*******************************************************************************
	* Submodule: Potion                                                            *
	* Import:    None                                            				   *
	* Export:    None                                                              *
	* Assertion: Default Constructor for Potion.						           *
	*******************************************************************************/
	public Potion()
	{
		super();
		minEffect = 0;
		maxEffect = 0;
		type = '\u0000';
	}
	
	/*******************************************************************************
	* Submodule: Potion                                                            *
	* Import:    inName (String), inCost (Integer), inMinEffect (Integer),         *
	*			 inMaxEffect (Integer), inType (Character)						   *
	* Export:    None                                                              *
	* Assertion: Alternate Constructor for Potion.						           *
	*******************************************************************************/
	public Potion(String inName, int inMinEffect, int inMaxEffect, int inCost, char inType)
	{
		super(inName, inCost);
		if ((validateInteger(inMinEffect)) && (validateInteger(inMaxEffect)) && (validateCharacter(inType)))
		{
			minEffect = inMinEffect;
			maxEffect = inMaxEffect;
			type = inType;
		}
	}
	
	/*******************************************************************************
	*                                 ACCESSORS                                    *
	********************************************************************************
	*               Responsible for accessing all Potion classfields.              *
	*******************************************************************************/
	public int getMinEffect()
	{
		return minEffect;
	}
	
	public int getMaxEffect()
	{
		return maxEffect;
	}
	
	public char getType()
	{
		return type;
	}
	
	public String getItemType()
	{
		return itemType;
	}
	
	public String toString()
	{
		return (super.toString() + ", Minimum Effect: " + minEffect + ", Maximum Effect: " + maxEffect + ", Type: " + type);
	}
	
	/*******************************************************************************
	*                                MUTATORS                                      *
	********************************************************************************
	*                Responsible for setting all Potion classfields.               *
	*******************************************************************************/
	public void setMinEffect(int inMinEffect) throws PotionException
	{
		if (validateInteger(inMinEffect))
		{
			minEffect = inMinEffect;
		}
		else
		{
			throw new PotionException("Invalid Minimum Effect - Potion.");
		}
	}
	
	public void setMaxEffect(int inMaxEffect) throws PotionException
	{
		if (validateInteger(inMaxEffect))
		{
			maxEffect = inMaxEffect;
		}
		else
		{
			throw new PotionException("Invalid Maximum Effect - Potion.");
		}
	}
	
	public void setType(char inType) throws PotionException
	{
		if (validateCharacter(inType))
		{
			type = inType;
		}
		else
		{
			throw new PotionException("Invalid Type - Potion.");
		}
	}
	
	/*******************************************************************************
	* Submodule: validateCharacter                                                 *
	* Import:    inType                                          				   *
	* Export:    None                                                              *
	* Assertion: Returns true or false whether the character is empty.             *
	*******************************************************************************/
	private boolean validateCharacter(char inType)
	{
		boolean validCharacter = true;
		if (inType == ' ')
		{
			validCharacter = false;
		}
		return validCharacter;
	}
} 