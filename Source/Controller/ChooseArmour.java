/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         ChooseArmour.java                                             *
* Purpose:          One of the 5 Strategies responsible for equipping Armour.	  *                       
* Unit:             OOSE                                                          *
* Last Modified:    27/04/2020                                                    *
**********************************************************************************/
package Controller;

//Import Custom Packages
import Controller.Exceptions.MainCharacterException;
import Model.MainCharacter;
import View.UserInterface;

//Import Java Packages
import java.util.*;

public class ChooseArmour implements Selection
{
	private MainCharacter gameCharacter;
	private UserInterface ui;
	
	/*******************************************************************************
	* Submodule: ChooseArmour                                                      *
	* Import:    inGameCharacter (MainCharacter), inUI (UserInterface)             *
	* Export:    None                                                              *
	* Assertion: Alternate Constructor for ChooseArmour.				           *
	*******************************************************************************/
	public ChooseArmour(MainCharacter inGameCharacter, UserInterface inUI)
	{
		gameCharacter = inGameCharacter;
		ui = inUI;
	}
	
	/*******************************************************************************
	* Submodule: doSelection                                                       *
	* Import:    None                                                              *
	* Export:    None                                                              *
	* Assertion: Overriding Parent Selection as part of Strategy Pattern.          *
	*******************************************************************************/
	@Override
	public void doSelection()
	{
		boolean done = false;
		int choice;
		gameCharacter.displayInventory();
		choice = ui.getChoice("Enter a number for which Armour to set.\n");
		while (!done)
		{
			try
			{
				//Subtract 1 from Choice for 0 based indexing.
				gameCharacter.setMainArmour(gameCharacter.getItemFromInventory(choice-1));
				done = true;
			}
			catch (MainCharacterException mce)
			{
				System.out.println("Re-enter Choice, that was an invalid Armour. ");
				choice = ui.getChoice("Press 0 to exit.");
			}
			catch (IndexOutOfBoundsException invalidChoice)
			{
				System.out.println("Invalid Choice - Choose Weapon.");
			}
						
			if (choice == 0)
			{
				done = true;
			}
		}
	}
}