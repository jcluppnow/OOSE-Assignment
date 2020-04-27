/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         Shop.java		                                              *
* Purpose:          One of the 5 Strategies, responsible for all Shop Activities. *                                                      *
* Unit:             OOSE                                                          *
* Last Modified:    27/04/2020                                                    *
**********************************************************************************/
package Controller;
import View.UserInterface;
import Controller.ItemFactory;
import Model.MainCharacter;
import Model.Item;
import Controller.Exceptions.CreateItemException;
import java.util.*;

public class Shop implements Selection
{	
	private ArrayList<String> Inventory;
	private UserInterface ui;
	private MainCharacter gameCharacter;
	private ItemFactory itemFactory;
	
	/*******************************************************************************
	* Submodule: Shop                                                              *
	* Import:    inInventory (ArrayList<String>), inUI (UserInterface),            *
	*            inGameCharacter (MainCharacter)                                   *
	* Export:    None                                                              *
	* Assertion: Alternate Constructor for Shop.                                   *
	*******************************************************************************/
	public Shop(ArrayList<String> inInventory, UserInterface inUI, MainCharacter inGameCharacter)
	{
		ui = inUI;
		Inventory = inInventory;
		gameCharacter = inGameCharacter;
		itemFactory = new ItemFactory();
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
		boolean exit = false;
		
		int choice;
		while(exit == false)
		{
			choice = ui.displayShop(Inventory);
			if (choice == 0)
			{
				exit = true;
			}
			else
			{
				purchaseItem(choice);
			}
		}
	}
	
	/*******************************************************************************
	* Submodule: purchaseItem                                                      *
	* Import:    choice (Integer)                                                  *
	* Export:    None                                                              *
	* Assertion: Responsible for purchasing an item.                               *
	*******************************************************************************/
	public void purchaseItem(int choice)
	{
		String item = Inventory.get(choice);
		try
		{
			Item newItem = itemFactory.CreateItem(item);
			int cost = newItem.getCost();
			int characterFunds = gameCharacter.getFunds();
			if (cost <= characterFunds)
			{
				gameCharacter.addToInventory(newItem);
				gameCharacter.decreaseGold(cost);
			}
			else
			{
				System.out.println("\u001B[31m Invalid Funds - Need " + (cost - characterFunds) + " more gold. \u001B[0m");
			}
		}
		catch (CreateItemException cie)
		{
			System.out.println("Failed to create Item.");
		}
	}
	
	
	
}