/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         MenuController.java                                           *
* Purpose:          Responsible for the adding Strategies and handling Menu.	  *                                                      *
* Unit:             OOSE                                                          *
* Last Modified:    27/04/2020                                                    *
**********************************************************************************/
package Controller;

import View.UserInterface;
import Controller.Selection;
import FileIO.ReadFile;
import Model.MainCharacter;
import java.util.*;


public class MenuController
{
	private HashMap<Integer, Selection> selections;
	private Selection goToShop;
	private Selection chooseCharacterName;
	private Selection chooseWeapon;
	private Selection chooseArmour;
	private Selection startBattle;
	
	public void run(MainCharacter gameCharacter, UserInterface ui)
	{
		ArrayList<String> shopInventory = ((new ReadFile().readCSVFile()));	
		goToShop = new Shop(shopInventory, ui, gameCharacter);
		chooseCharacterName = new ChooseCharacterName(gameCharacter, ui);
		chooseWeapon = new ChooseWeapon(gameCharacter, ui);
		chooseArmour = new ChooseArmour(gameCharacter, ui);
		startBattle = new StartBattle(gameCharacter, ui);
		selections = new HashMap<Integer, Selection>();
		selections.put(1, goToShop);					//Creates new GoToShop Object as a Selections object.
		selections.put(2, chooseCharacterName);		//Creates new ChooseCharacterName Object as a Selections object.
		selections.put(3, chooseWeapon);							//Creates new ChooseWeapon Object as a Selections object.
		selections.put(4, chooseArmour);							//Creates new ChooseArmour Object as a Selections object.
		selections.put(5, startBattle);							//Creates new StartBattle Object as a Selections object.
		ui.displayMenu(selections);	
		
	}
}

