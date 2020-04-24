package Controller;
import Source.View.UserInterface;
import Model.Item;
import java.util.*;

public class GoToShop implements Selection
{	
	private ArrayList<Item> Inventory;
	private UserInterface ui;
	
	public GoToShop(ArrayList<Item> inInventory, UserInterface inUI)
	{
		ui = inUI;
		Inventory = inInventory;
	}
	@Override
	public void doSelection()
	{
		ui.displayShop(Inventory);
	}
}