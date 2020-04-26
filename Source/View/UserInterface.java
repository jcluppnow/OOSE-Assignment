package View;
import Controller.*;
import Model.Item;
import java.util.*;

public class UserInterface
{

	private static Scanner input = new Scanner(System.in);
		
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
	
	public void displayCharacterInventory(List<Item> characterInventory)
	{
//DEBUG CODE
System.out.println("Reached Display Character Inventory");
System.out.println("Character Inventory Size: " + characterInventory.size());
		int itemNumber = 1;
		for (Item item : characterInventory)
		{
			System.out.println(" (" + itemNumber + ") - " + item.toString());
			itemNumber++;
		}
	}
		
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