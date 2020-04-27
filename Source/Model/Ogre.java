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
	public Ogre()
	{
		//Name, MaxHealth, Minimum Damage, Maximum Damage, Minimum Defence, Maximum Defence, Reward
		//Default Values for a Ogre.
		super("Ogre", 40, 5, 10, 6, 12, 40);
	}
	
	//Accessors
	public int getDamage()
	{ 
		return getRandomValue(minDamage, maxDamage);
	}
	
	public int getDefence()
	{
		return getRandomValue(minDefence, maxDefence);
	}
	
}
	
	