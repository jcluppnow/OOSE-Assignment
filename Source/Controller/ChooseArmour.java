/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         ChooseArmour.java                                             *
* Purpose:          One of the 5 Strategies responsible for equipping Armour.	  *                                                      *
* Unit:             OOSE                                                          *
* Last Modified:    27/04/2020                                                    *
**********************************************************************************/
package Controller;
import Model.MainCharacter;
import View.UserInterface;
import java.util.*;
public class ChooseArmour implements Selection
{
	private MainCharacter gameCharacter;
	private UserInterface ui;
	
	public ChooseArmour(MainCharacter inGameCharacter, UserInterface inUI)
	{
		gameCharacter = inGameCharacter;
		ui = inUI;
	}
	@Override
	public void doSelection()
	{
		boolean done = false;
		int choice;
		gameCharacter.displayInventory();
		while (!done)
		{
			choice = ui.getChoice("Enter a number for which Armour to set.\n");
			if (gameCharacter.getItemFromInventory(choice).getItemType().equals("Armour"))
			{
				gameCharacter.setMainArmour(gameCharacter.getItemFromInventory(choice));
			}
			else
			{
				System.out.println("Choice is not Armour.");
			}
			choice = ui.getChoice("Press 0 to exit.");
			if (choice == 0)
			{
				done = true;
			}
		}
	}
}