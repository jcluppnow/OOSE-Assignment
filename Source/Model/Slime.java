/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         Slime.java                                		              *
* Purpose:          Handles all characteristics of Slime Class.		    		  *
* Unit:             OOSE                                                          *
* Last Modified:    18/05/2020                                                    *
**********************************************************************************/
package Model;

public class Slime extends Enemy
{
	/*******************************************************************************
	* Submodule: Slime                                                             *
	* Import:    None 											   				   *
	* Export:    None                                                              *
	* Assertion: Default Constructor for Slime.							           *
	*******************************************************************************/
	public Slime()
	{
		//Name, MaxHealth, Minimum Damage, Maximum Damage, Minimum Defence, Maximum Defence, Reward
		//Default Values for a Slime.
		super("Slime", 10, 3, 5, 0, 2, 10);
	}
	
	/*******************************************************************************
	*                                 ACCESSORS                                    *
	********************************************************************************
	*               Responsible for accessing all Slime classfields.               *
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
		return (" Spat acid at you");
	}
	
	public int triggerSpecialAbility()
	{
		System.out.println("The slime attempted to spit acid at you but nothing happened. ");
		return 0;
	}
	
	public boolean hasAbilityTriggered()
	{
		boolean abilityProc = false;
		int chance = getRandomValue(1, 100);
		if (chance <= 20)
		{
			abilityProc = true;
		}
		return abilityProc;
	}
}
	
	