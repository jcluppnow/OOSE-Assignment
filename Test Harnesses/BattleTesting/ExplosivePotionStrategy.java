/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         ExplosivePotionStrategy.java                                  *
* Purpose:          One of the 2 Potion Strategies, responsible for the Main      *
*                   Character using a Explosive Potion against the enemy.    	  *                       
* Unit:             OOSE                                                          *
* Last Modified:    20/05/2020                                                    *
**********************************************************************************/
//package Controller;

public class ExplosivePotionStrategy implements PotionStrategy
{
	/*******************************************************************************
	* Submodule: usePotion                                                         *
	* Import:    gameCharacter (MainCharacter), enemy (Enemy), potion (Potion)     *
	* Export:    None                                                              *
	* Assertion: Overriding Parent usePotion as part of Strategy Pattern.          *
	*******************************************************************************/
	@Override
	public void usePotion(MainCharacter gameCharacter, Enemy enemy, Potion potion)
	{
		int potionDamage = potion.calcEffect();
		
		int enemyDefence = enemy.getDefence();
			
		System.out.println("You throw the potion at the " + enemy.getName());
		if (potionDamage > enemyDefence)
		{
			int damageTaken = potionDamage - enemyDefence;
			System.out.println("The potion shatters against the " + enemy.getName() + " and you hear it shriek in pain.");
			System.out.println("You dealt " + damageTaken + "damage.");
		}
		else
		{
			System.out.println("You watch as the potion arcs towards the enemy who sees it coming and has time to sidestep the obvious attack.");
		}	
	}		
}