/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         Dragon.java                              		              *
* Purpose:          Handles all Dragon Characteristics.							  *                                                      *
* Unit:             OOSE                                                          *
* Last Modified:    27/04/2020                                                    *
**********************************************************************************/
package Model;

public class Dragon extends Enemy
{
	public Dragon()
	{
		//Name, MaxHealth, Minimum Damage, Maximum Damage, Minimum Defence, Maximum Defence, Reward
		//Default Values for a Dragon.
		super("Dragon", 100, 15, 30, 15, 20, 100);
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
	
	