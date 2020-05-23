/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         MainCharacterAttackStrategy.java                              *
* Purpose:          One of the 2 Attack Strategies, responsible for the Main       *
*                   Character attacking the enemy.								  *                       
* Unit:             OOSE                                                          *
* Last Modified:    20/05/2020                                                    *
**********************************************************************************/
package Controller;

//Import Custom Packages
import Model.MainCharacter;
import Model.Weapon;
import Model.Enemy;


public class MainCharacterAttackStrategy implements AttackStrategy
{
	/*******************************************************************************
	* Submodule: attack                                                            *
	* Import:    gameCharacter (MainCharacter), enemy (Enemy)                      *
	* Export:    None                                                              *
	* Assertion: Overriding Parent Attack as part of Strategy Pattern.             *
	*******************************************************************************/
	@Override
	public void attack(MainCharacter gameCharacter, Enemy enemy)
	{		
		//Get the Current Weapon.
		Weapon weapon = gameCharacter.getWeapon();
		
		int mainCharacterAttack = gameCharacter.getDamage();
		
		int enemyDefence = enemy.getDefence();
		
		System.out.println("\nYou attacked the " + enemy.getName() + " with your " + weapon.getItemName() + ".");
		if (mainCharacterAttack > enemyDefence)
		{
			int damageTaken = mainCharacterAttack - enemyDefence;
			enemy.takeDamage(damageTaken);
			System.out.println("The " + enemy.getName() + " took " + damageTaken + " damage.");
		}
		else
		{
			System.out.println("The " + enemy.getName() + " seemed unharmed. ");
		}
	}
			
}