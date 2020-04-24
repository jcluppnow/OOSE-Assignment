package Source.View;
import Controller.*;
import Model.Item;
import java.util.*;

public class UserInterface
{

	private static Scanner input = new Scanner(System.in);
		
	public void displayMenu(Map<Integer, Selection> selections)
	{
		boolean done = false;
		while(!done)
		{	
			try
			{
				int selection;
				System.out.println("(1) Go To Shop \n(2) Choose Character Name \n(3) Choose Weapon \n(4) Choose Armour \n(5) Start Battle \n(6) Exit");
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
	
	public void displayShop(ArrayList<Item> shopInventory)
	{
		System.out.println("Lauren's Humble Wares");
		for (Item item : shopInventory)
		{
			System.out.print("\n\t" + item.toString());
		}
		System.out.println("\n\tEnchantment: Damage + 2  - 5  - Add 2 to Attack Damage");
		System.out.println("\tEnchantment: Damage + 5  - 10 - Add 5 to Attack Damage");
		System.out.println("\tEnchantment: Damage + 2  - 20 - Adds between 5 & 10 to Attack Damage.");
		System.out.println("\tEnchantment: Damage + 2  - 10 - Amplifies attack damage by 10%.\n ");
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