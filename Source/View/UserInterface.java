/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         UserInterface.java                                            *
* Purpose:          Handles all UserInterface functionality.					  *                                                      *
* Unit:             OOSE                                                          *
* Last Modified:    27/04/2020                                                    *
**********************************************************************************/
package View;
import Controller.*;
import Model.Item;
import java.util.*;

public class UserInterface
{

	private static Scanner input = new Scanner(System.in);
	
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
				System.out.println("(1) Go To Shop \n(2) Choose Character Name \n(3) Choose Weapon \n(4) Choose Armour \n(5) Start Battle \n(6) Exit\n");
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
			System.out.println("Lauren's Humble Wares");
				for (String item : shopInventory)
				{
					System.out.print("\n\t(" + itemNumber + ")  " + item);
					itemNumber++;
				}

				System.out.println("What would you like to buy - 0 to exit. \nINPUT: ");
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
				System.out.println("Enter your Character's Name! \nINPUT: ");
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