/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         UserInterface.java                                            *
* Purpose:          Handles all UserInterface functionality.					  *
* Unit:             OOSE                                                          *
* Last Modified:    27/04/2020                                                    *
**********************************************************************************/
/*package View;

//Import Custom Packages
import Controller.*;
import Model.Item;
import Model.MainCharacter;*/

//Import Java Packages
import java.util.*;

public class UserInterface implements MainCharacterObserver, EnemyObserver
{
	private MainCharacter gameCharacter;				//User Interface Observes MainCharacter at all times
	private Enemy enemy;								//User Interface Observes Enemy during Battle Only
	private static Scanner input = new Scanner(System.in);
	
	public UserInterface(MainCharacter inGameCharacter)
	{
		gameCharacter = inGameCharacter;
	}
	
	public UserInterface(MainCharacter inGameCharacter, Enemy inEnemy)
	{
		gameCharacter = inGameCharacter;
		enemy = inEnemy;
	}
	
	/*******************************************************************************
	* Submodule: displayMenu                                                       *
	* Import:    selections (Map<Integer, Selection>) 							   *
	* Export:    None                                                              *
	* Assertion: Display the Main Menu.    									       *
	*******************************************************************************/
	public void displayMenu(Map<Integer, Selection> selections)
	{
		boolean done = false;
		while (!done)
		{	
			try
			{
				int selection;
				System.out.println("\n+================+");
				System.out.println("|  Menu Options  |");
				System.out.println("+================+============+");
				System.out.println("|  (1) Go To Shop             |");
				System.out.println("|  (2) Choose Character Name  |");
				System.out.println("|  (3) Choose Weapon          |");
				System.out.println("|  (4) Choose Armour          |");
				System.out.println("|  (5) Start Battle           |");
				System.out.println("|  (6) Exit                   |");
				System.out.println("+=============================+");
				System.out.print("INPUT: ");
				selection = Integer.parseInt(input.nextLine());
				if (selection == 6)
				{
					done = true;
				} 
				else if (selections.containsKey(selection))
				{
					Selection strategy = selections.get(selection);
					strategy.doSelection();
				} 
				else
				{
					throw new NumberFormatException();
				}
			}
            catch (NumberFormatException e)
            {
                // The user entered something non-numerical.
                System.out.println("Enter a number");
            }
		}
	}
	
	/*******************************************************************************
	* Submodule: displayShop                                                       *
	* Import:    shopInventory (ArrayList<String>)                                 *
	* Export:    choice (Integer)                                                  *
	* Assertion: Responsible for displaying Shop Inventory and recieving choice.   *
	*******************************************************************************/
	public int displayShop(ArrayList<String> shopInventory)
	{ 
		boolean exit = true;
		int choice = 0;
		do
		{
			try
			{

				int itemNumber = 1;
				System.out.println("\nLauren's Humble Wares");
				System.out.println("\nType, Name, Min Damage, Max Damage, Cost, Damage Type, Weapon Type");
				for (String item : shopInventory)
				{
					System.out.print("\n\t(" + itemNumber + ")  " + item);
					itemNumber++;
				}

				System.out.println("\n\nWhat would you like to buy - 0 to exit.");
				System.out.print("INPUT: ");
				choice = Integer.parseInt(input.nextLine());
			}
			catch (NumberFormatException nfe)
			{
				exit = false;
			}
		}
		while (exit == false);
		return choice;
	}
	
	/*******************************************************************************
	* Submodule: displayCharacterInventory                                         *
	* Import:    characterInventory (List<Item>)                                   *
	* Export:    None                                                              *
	* Assertion: Display all the Items in the Character's Inventory.	           *
	*******************************************************************************/	
	public void displayCharacterInventory(List<Item> characterInventory)
	{
		System.out.println("\nInventory:\n");
		int itemNumber = 1;
		for (Item item : characterInventory)
		{
			System.out.println(" (" + itemNumber + ") - " + item.toString());
			itemNumber++;
		}
	}
	
	/*******************************************************************************
	* Submodule: getCharacterName                                                  *
	* Import:    None                                                              *
	* Export:    name (String)                                                     *
	* Assertion: Processes and validates character name. 				           *
	*******************************************************************************/	
	public String getCharacterName()
	{
		boolean done = false;
		String name = "";
		
		while (!done)
		{
			try
			{
				System.out.println("\nEnter your Character's Name! \nINPUT: ");
				name = input.nextLine();
				if (validateName(name))
				{
					done = true;
				}
				else
				{
					throw new IllegalArgumentException();
				}
			}
			catch (IllegalArgumentException iae)
			{
				System.out.println("Enter a non empty string.");
			}
		}
		return name;
	}

	/*******************************************************************************
	* Submodule: displayString                                                     *
	* Import:    inString (String)                                                 *
	* Export:    None                                                              *
	* Assertion: Prints the parameter.									           *
	*******************************************************************************/	
	public void displayString(String inString)
	{
		System.out.println(inString);
	}
	
	/*******************************************************************************
	* Submodule: getChoice		                                                   *
	* Import:    message (String)                                                  *
	* Export:    choice (Integer)                                                  *
	* Assertion: Processes and Validates Choice, while displaying Parameter.       *
	*******************************************************************************/	
	public int getChoice(String message)
	{
		boolean done = false;
		int choice = 0;
		
		while (!done)
		{
			try
			{
				System.out.println(message);
				System.out.print("INPUT: ");
				choice = Integer.parseInt(input.nextLine());
				
				if (choice >= 0)
				{
					done = true;
				}
				else
				{
					System.out.println("Enter a positive Integer.");
				}
			}
			catch (NumberFormatException nfe)
			{
				System.out.println("Enter an Integer.");
			}
		}
		return choice;
	}
	
	public void updateMainCharacter()
	{
		displayUserStatistics();
	}
	
	public void updateEnemy()
	{
		displayEnemyStatistics();
	}
	
	public void displayUserStatistics()
	{
		System.out.println("\nCharacter Statistics: ");
		System.out.println(gameCharacter.toString());
		displayCharacterInventory(gameCharacter.getInventory());
	}
	
	public void displayEnemyStatistics()
	{
		System.out.println("\nEnemy Statistics: ");
		System.out.println(enemy.toString());
	}
	
	public void displayEnemyStatistics(Enemy inEnemy)
	{
		System.out.println("\nEnemy Statistics: ");
		System.out.println(inEnemy.toString());
	}
	
	/*******************************************************************************
	* Submodule: validateName                                                      *
	* Import:    inName (String)                                                   *
	* Export:    validName (Boolean)                                               *
	* Assertion: Returns true or false depending on whether the string is valid.   *
	*******************************************************************************/	
	private boolean validateName(String inName)
	{
		boolean validName = true;
		String emptyString = "";
		
		if (inName.equals(emptyString))
		{
			validName = false;
		}
		return validName;
	}

}