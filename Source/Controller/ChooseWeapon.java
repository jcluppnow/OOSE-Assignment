/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         ChooseWeapon.java                                             *
* Purpose:          One of the 5 Strategies, responsible for equipping a Weapon.  *                                                      *
* Unit:             OOSE                                                          *
* Last Modified:    27/04/2020                                                    *
**********************************************************************************/
package Controller;
import Model.MainCharacter;
import View.UserInterface;
import java.util.*;
public class ChooseWeapon implements Selection
{
	private MainCharacter gameCharacter;
	private UserInterface ui;
	
	/*******************************************************************************
	* Submodule: ChooseWeapon                                                      *
	* Import:    inGameCharacter (MainCharacter), inUI (UserInterface)             *
	* Export:    None                                                              *
	* Assertion: Alternate Constructor for ChooseWeapon.				           *
	*******************************************************************************/
	public ChooseWeapon(MainCharacter inGameCharacter, UserInterface inUI)
	{
		this.gameCharacter = inGameCharacter;
		this.ui = inUI;
	}
	
	/*******************************************************************************
	* Submodule: doSelection                                                       *
	* Import:    None                                                    *
	* Export:    None                                                              *
	* Assertion: Overriding Parent Selection as a part of the Strategy Pattern.    *
	*******************************************************************************/
	@Override
	public void doSelection()
	{
		boolean done = false;
		int choice;
		gameCharacter.displayInventory();
		while (!done)
		{
			choice = ui.getChoice("Enter a number for which weapon to set.\n");
			if (gameCharacter.getItemFromInventory(choice).getItemType().equals("Weapon"))
			{
				gameCharacter.setMainWeapon(gameCharacter.getItemFromInventory(choice));
			}
			else
			{
				System.out.println("Choice is not a weapon.");
			}
			choice = ui.getChoice("Press 0 to exit.");
			if (choice == 0)
			{
				done = true;
			}
		}
	}
}