/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         StartBattle.java                                              *
* Purpose:          One of the 5 Strategies, responsible for All Battle 		  *
* 					Activities.													  *  
* Unit:             OOSE                                                          *
* Last Modified:    27/04/2020                                                    *
**********************************************************************************/
package Controller;

//Import Custom Packages
import View.MainCharacterObserver;
import View.EnemyObserver;
import Model.MainCharacter;
import Model.Enemy;
import Model.Potion;
import Model.Item;
import View.UserInterface;

//Import Java Packages
import java.util.*;
public class StartBattle implements Selection, MainCharacterObserver, EnemyObserver
{
	private HashMap<Integer, AttackStrategy> attackStrategies;
	private HashMap<Integer, PotionStrategy> potionStrategies;
	private EnemyFactory enemyFactory;
	private Enemy enemy;
	private MainCharacter gameCharacter;
	private UserInterface ui;
	private boolean characterAlive;
	private boolean enemyAlive;
	
	/*******************************************************************************
	* Submodule: StartBattle                                                       *
	* Import:    inGameCharacter (MainCharacter), inUI (UserInterface)             *
	* Export:    None                                                              *
	* Assertion: Alternate Constructor for StartBattle.					           *
	*******************************************************************************/
	public StartBattle(MainCharacter inGameCharacter, EnemyFactory inEF)
	{
		//Create Attack Strategies
		attackStrategies = new HashMap<Integer, AttackStrategy>();
		attackStrategies.put(1, new MainCharacterAttackStrategy());
		attackStrategies.put(2, new EnemyAttackStrategy());
		
		//Create Potion Strategies
		potionStrategies = new HashMap<Integer, PotionStrategy>();
		potionStrategies.put(1, new HealingPotionStrategy());
		potionStrategies.put(2, new ExplosivePotionStrategy());
		
		gameCharacter = inGameCharacter;
		enemyFactory = inEF;
		characterAlive = true;
		enemyAlive = false;
	}
	
	/*******************************************************************************
	* Submodule: doSelection                                                       *
	* Import:    None                                                              *
	* Export:    None                                                              *
	* Assertion: Overriding Parent Selection as a part of Strategy Pattern.        *
	*******************************************************************************/
	@Override
	public void doSelection()
	{
		this.enemy = enemyFactory.CreateEnemy();
		
		//Create the UserInterface with the newly created Enemy.
		ui = new UserInterface(gameCharacter, enemy);
		
		//Add User Interface as an Observer to the Enemy.
		enemy.add(ui);
		
		//Add Start Battle As an Observer to the Enemy.
		enemy.add(this);
		
		//Add Start Battle as an Observer to the Main Character.
		gameCharacter.add(this);
		
		ui.displayEnemyStatistics(enemy);
		
		ui.displayUserStatistics();
		
		enemyAlive = true;
		while ((characterAlive == true) && (enemyAlive == true))
		{
						String message = "\n+==============================+\n|  What would you like to do?  |\n+==============================+\n|  (1) Attack.                 |\n|  (2) Use a Potion.           |\n+==============================+";
			int choice = ui.getChoice(message);

			switch (choice)
			{
				case 1:
					//Attack - Do the MainCharacterAttackStrategy then the EnemyAttackStrategy
					AttackStrategy firstStrategy = attackStrategies.get(1);
					AttackStrategy secondStrategy = attackStrategies.get(2);
					
					firstStrategy.attack(gameCharacter, enemy);
					secondStrategy.attack(gameCharacter, enemy);
					break;
					
				case 2:
					//Display the inventory.
					String messageTwo = "Choose a Potion";
					int potionChoice;
					ui.displayCharacterInventory(gameCharacter.getInventory());
					potionChoice = ui.getChoice(messageTwo);
					
					try
					{
						//Subtract one to make it suitable for 0 based indexing.
						Item item = gameCharacter.getItemFromInventory(potionChoice-1);
						if (item.getItemType().equals("Potion"))
						{
							//Justifiable downcasting. I can guarantee this is a potion and would have no other way of calling potions methods.
							Potion potion = (Potion) item;
							if (potion.getType() == 'H')
							{
								PotionStrategy potionStrategy = potionStrategies.get(1);
								potionStrategy.usePotion(gameCharacter, enemy, potion);
								//Subtract one ot make it suitable for 0 based indexing.
								gameCharacter.removeFromInventory(potionChoice - 1);
								
							}
							else if (potion.getType() == 'D')
							{
								PotionStrategy potionStrategy = potionStrategies.get(2);
								potionStrategy.usePotion(gameCharacter, enemy, potion);
								//Subtract one to make it suitable for 0 based indexing.
								gameCharacter.removeFromInventory(potionChoice - 1);
							}
							else
							{
								System.out.println("\u001b[31mInvalid Potion - StartBattle. \u001b[0m");
							}
							
						}
						else
						{
							System.out.println("\u001b[31mItem is not a Potion. \u001b[0m");
						}
					}
					catch (IndexOutOfBoundsException invalidChoice)
					{
						System.out.println("\u001b[31mInvalid Choice from Inventory. \u001b[0m");
					}
					break;
					
				default:
					System.out.println("\u001b[31mInvalid Choice - " + choice + "\u001b[0m");
			}
				if (gameCharacter.getCurrentHealth() == 0)
				{
					characterAlive = false;
				}
				
				if (enemy.getCurrentHealth() == 0)
				{
					enemyAlive = false;
				}			
		}
		
		//Give the Reward 
		if (enemyAlive == false)
		{
			addReward(enemy);
		}
		
		//Game Over
		if (characterAlive == false)
		{
			gameOver(enemy);
		}
	}
	
	public void addReward(Enemy enemy)
	{
		int reward = enemy.getReward();
		int funds = gameCharacter.getFunds();
		int total = funds + reward;
		int healthRecovered = ((int)(gameCharacter.getCurrentHealth() * 1.5)) - gameCharacter.getCurrentHealth();
		
		System.out.println("\u001b[32mCongratulations you defeated the Enemy.");
		System.out.println("You earned " + reward + " gold from defeating the " + enemy.getName() + ".");
		System.out.println("Totals Funds: " + total);
		gameCharacter.increaseGold(reward);
		
		System.out.println("You have recovered " + healthRecovered + " health.\u001b[0m");
		gameCharacter.heal(healthRecovered);	
	}
	
	public void gameOver(Enemy enemy)
	{
		System.out.println("\u001b[31mUnfortunately you lost your life to the " + enemy.getName() + "\u001b[0m");
		System.out.println("\u001b[31mYou can't continue any further. GAME OVER.\u001b[0m");
	}
	
	public void updateMainCharacter()
	{
		if (gameCharacter.getCurrentHealth() == 0)
		{
			characterAlive = false;
		}
	}
	
	public void updateEnemy()
	{
		if (enemy.getCurrentHealth() == 0)
		{
			enemyAlive = false;
		}
	}
}