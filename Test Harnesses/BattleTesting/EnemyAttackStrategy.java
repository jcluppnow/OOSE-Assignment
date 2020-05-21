/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         EnemyAttackStrategy.java                        			  *
* Purpose:          One of the 2 Attack Strategies, responsible for the Enemy     *
*                   attacking the Main Character.								  *                       
* Unit:             OOSE                                                          *
* Last Modified:    20/05/2020                                                    *
**********************************************************************************/
//package Controller;

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
		
System.out.println("\u001b[31mEnemy Atack DEBUGGING TEST:");
		//Get the Enemies Damage
		int enemyAttack = enemy.getDamage();
		
		//Get the gameCharacter's defence
		int gameCharacterDefence = gameCharacter.getDefence();

System.out.println("\tEnemy Attack: " + enemyAttack);
System.out.println("Main Character Defence: " + gameCharacterDefence + "\u001b[0m"); 		
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