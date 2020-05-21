import java.util.*;

public class StartBattleTest
{	
	public static void main(String[] args)
	{
		HashMap<Integer, AttackStrategy> attackStrategies;
	    HashMap<Integer, PotionStrategy> potionStrategies;
		AttackStrategy mainCharacterAttack;
		AttackStrategy enemyAttack;
		PotionStrategy healingPotion;
		PotionStrategy explosivePotion;
		boolean characterAlive;
		boolean enemyAlive;
	
		EnemyFactory ef = new EnemyFactory();
		
		//Create the Main Character, this would be imported in the actual one.
		MainCharacter gameCharacter = new MainCharacter();		
		characterAlive = true;
		
		//Create the Enemy Based on Probability.
		Enemy enemy = ef.CreateEnemy();
		enemyAlive = true;
		
		//Construct the User Interface that Observes Game Character and Enemy
		UserInterface ui = new UserInterface(gameCharacter, enemy);
		
		//Add Ui As an Observer to Main Character.
		gameCharacter.add(ui);
		
		//Add Ui As an Observer to Enemy
		enemy.add(ui);
		
		//Display the Initial Enemies Details.
		ui.displayEnemyStatistics(enemy);
		
		//Display the Initial Main Character Statistics
		ui.displayUserStatistics();
		
		//Create Attack Strategies
		attackStrategies = new HashMap<Integer, AttackStrategy>();
		attackStrategies.put(1, new MainCharacterAttackStrategy());
		attackStrategies.put(2, new EnemyAttackStrategy());
	
		//Create Potion Strategies
		potionStrategies = new HashMap<Integer, PotionStrategy>();
		potionStrategies.put(1, new HealingPotionStrategy());
		potionStrategies.put(2, new ExplosivePotionStrategy());
		
		while ((characterAlive == true) && (enemyAlive == true))			//Loop until either character or enemy dies.
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
System.out.println("\u001b[32mEnemy Health Check: " + enemy.getCurrentHealth() + "\u001b[0m");
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
			addReward(gameCharacter, enemy);
		}
		
		//Game Over
		if (characterAlive == false)
		{
			gameOver(gameCharacter, enemy);
		}
	}
	
	public static void addReward(MainCharacter gameCharacter, Enemy enemy)
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
	
	public static void gameOver(MainCharacter gameCharacter, Enemy enemy)
	{
		System.out.println("\u001b[31mUnfortunately you lost your life to the " + enemy.getName() + "\u001b[0m");
		System.out.println("\u001b[31mYou can't continue any further. GAME OVER.\u001b[0m");
	}
}