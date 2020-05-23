/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         EnemyAttackStrategy.java                        			  *
* Purpose:          One of the 2 Attack Strategies, responsible for the Enemy     *
*                   attacking the Main Character.								  *                       
* Unit:             OOSE                                                          *
* Last Modified:    20/05/2020                                                    *
**********************************************************************************/
package Controller;

//Import Custom Packages
import Model.MainCharacter;
import Model.Enemy;

public class EnemyAttackStrategy implements AttackStrategy
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
		//Get the Enemies Damage
		int enemyAttack = enemy.getDamage();
		
		//Get the gameCharacter's defence
		int gameCharacterDefence = gameCharacter.getDefence();
		
		if (enemy.hasAbilityTriggered() == true)
		{
			enemyAttack = enemy.triggerSpecialAbility();
			
			if (enemyAttack > gameCharacterDefence)
			{
				int damageTaken = enemyAttack - gameCharacterDefence;
				System.out.println("Causing " + damageTaken + " damage.");
				gameCharacter.takeDamage(damageTaken);
			}
			else
			{
				System.out.println("You braced yourself and withstood the damage.");
			}
			
			if (enemy.hasSecondAttack() == true)
			{
				System.out.println("The " + enemy.getName() + " caught you unaware and took a second attack. ");
				enemyAttack = enemy.triggerSpecialAbility();
				gameCharacterDefence = gameCharacter.getDefence();
				
				if (enemyAttack > gameCharacterDefence)
				{
					int damageTaken = enemyAttack - gameCharacterDefence;
					System.out.println("Causing " + damageTaken + " damage.");
					gameCharacter.takeDamage(damageTaken);
				}
				else
				{
					System.out.println("You managed to recover and dodge the second attack. ");
				}
			}
		}
		else
		{
			System.out.println("The " + enemy.getName() + enemy.getAttackType());
			if (enemyAttack > gameCharacterDefence)
			{
				int damageTaken = enemyAttack - gameCharacterDefence;
				System.out.println("Causing " + damageTaken + " damage.");
				gameCharacter.takeDamage(damageTaken);
				
			}
			else
			{
				System.out.println("You braced yourself and withstood the damage. ");
			}
		}	
	}
			
}