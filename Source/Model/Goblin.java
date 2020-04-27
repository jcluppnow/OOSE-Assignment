/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         Goblin.java                                                   *
* Purpose:          Handles Characteristics for Goblin Class.					  *                                                      *
* Unit:             OOSE                                                          *
* Last Modified:    27/04/2020                                                    *
**********************************************************************************/
package Model;

public class Goblin extends Enemy
{
	public Goblin()
	{
		//Name, MaxHealth, Minimum Damage, Maximum Damage, Minimum Defence, Maximum Defence, Reward
		//Default Values for a Goblin.
		super("Goblin", 30, 3, 8, 4, 8, 20);
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
	
	