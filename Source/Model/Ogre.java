/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         Ogre.java                                       		       *
* Purpose:          Handles Characteristics for Ogre Class.						  *                                                      *
* Unit:             OOSE                                                          *
* Last Modified:    27/04/2020                                                    *
**********************************************************************************/
package Model;

public class Ogre extends Enemy
{
	/*******************************************************************************
	* Submodule: Ogre                                                              *
	* Import:    None                                           				   *
	* Export:    None                                                              *
	* Assertion: Default Constructor for Ogre.							           *
	*******************************************************************************/
	public Ogre()
	{
		//Name, MaxHealth, Minimum Damage, Maximum Damage, Minimum Defence, Maximum Defence, Reward
		//Default Values for a Ogre.
		super("Ogre", 40, 5, 10, 6, 12, 40);
	}
	
	/*******************************************************************************
	*                                 ACCESSORS                                    *
	********************************************************************************
	*               Responsible for accessing all Ogre classfields.                *
	*******************************************************************************/
	public int getDamage()
	{ 
		return getRandomValue(minDamage, maxDamage);
	}
	
	public int getDefence()
	{
		return getRandomValue(minDefence, maxDefence);
	}
	
}
	
	