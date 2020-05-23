/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         Goblin.java                                                   *
* Purpose:          Handles Characteristics for Goblin Class.					  *
* Unit:             OOSE                                                          *
* Last Modified:    27/04/2020                                                    *
**********************************************************************************/
package Model;

public class Goblin extends Enemy
{
	/*******************************************************************************
	* Submodule: Goblin                                                            *
	* Import:    None                                           				   *
	* Export:    None                                                              *
	* Assertion: Default Constructor for Goblin.						           *
	*******************************************************************************/
	public Goblin()
	{
		//Name, MaxHealth, Minimum Damage, Maximum Damage, Minimum Defence, Maximum Defence, Reward
		//Default Values for a Goblin.
		super("Goblin", 30, 3, 8, 4, 8, 20);
	}
	
	/*******************************************************************************
	*                                 ACCESSORS                                    *
	********************************************************************************
	*               Responsible for accessing all Goblin classfields.              *
	*******************************************************************************/
	public int getDamage()
	{ 
		return getRandomValue(minDamage, maxDamage);
	}
	
	public int getDefence()
	{
		return getRandomValue(minDefence, maxDefence);
	}
	
	public String getAttackType()
	{
		return (" Clobbered you with it's makeshift club.");
	}
	
	public int triggerSpecialAbility()
	{
		System.out.println("The Goblin grabs it's makeshift club with 2 hands, and hits you for a CRITICAL hit.");
		return (getDamage() + 3);
	}
	
	public boolean hasAbilityTriggered()
	{
		boolean abilityProc = false;
		int chance = getRandomValue(1, 100);
		if (chance <= 50)
		{
			abilityProc = true;
		}
		return abilityProc;
	}
	
}
	
	