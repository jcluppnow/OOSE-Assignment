package Controller;
import Source.View.UserInterface;
import java.util.*;
public class GoToShop implements Selection
{	
	private ArrayList<String> Inventory;
	private UserInterface ui;
	
	public GoToShop(ArrayList<String> inInventory, UserInterface inUI)
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