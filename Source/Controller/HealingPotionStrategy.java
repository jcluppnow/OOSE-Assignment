/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         HealingPotionStrategy.java                                    *
* Purpose:          One of the 2 Potion Strategies, responsible for the Main      *
*                   Character using a Healing Potion.   						  *                       
* Unit:             OOSE                                                          *
* Last Modified:    23/05/2020                                                    *
**********************************************************************************/
package Controller;

//Import Custom Packages
import Model.MainCharacter;
import Model.Potion;
import Model.Enemy;

public class HealingPotionStrategy implements PotionStrategy
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
		int currentHealth = gameCharacter.getCurrentHealth();
			
		int maxHealth = gameCharacter.getMaxHealth();
			
		if (currentHealth < maxHealth)
		{
			int healedAmount = potion.calcEffect();
			gameCharacter.heal(healedAmount);
			System.out.println("You drink the " + potion.getItemName());
			System.out.println("As you drink the potion you feel your vitality return, your insides warm and you strength returns.");
		}
		else
		{
			System.out.println("You gulp the potion down...  But besides the taste of cherry lingering you don't feel any difference.");
		}
	}
}