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
	
	public Shop(ArrayList<String> inInventory, UserInterface inUI, MainCharacter inGameCharacter)
	{
		ui = inUI;
		Inventory = inInventory;
		gameCharacter = inGameCharacter;
		itemFactory = new ItemFactory();
	}
	
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
	
	public void purchaseItem(int choice)
	{
		String item = Inventory.get(choice);
		try
		{
			Item newItem = itemFactory.CreateItem(item);
			int cost = newItem.getCost();
			if (cost <= (gameCharacter.getFunds()))
			{
				gameCharacter.addToInventory(newItem);
				gameCharacter.decreaseGold(cost);
			}
			else
			{
				System.out.println("Invalid Funds - Need " + (cost - funds) + " more gold.");
			}
		}
		catch (CreateItemException cie)
		{
			System.out.println("Failed to create Item.");
		}
	}
	
	
	
}