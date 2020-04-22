package Controller;

import Source.View.UserInterface;
import FileIO.ReadFile;
import Model.MainCharacter;
import java.util.*;


public class AvalonApp
{
	private static Map<Integer, Selection> selections;
	
    public static void main(String[] args)
    {
        UserInterface ui = new UserInterface();
		MainCharacter gameCharacter = new MainCharacter();
		ArrayList<String> shopInventory = ((new ReadFile().readCSVFile()));	
		selections = new HashMap<Integer, Selection>();
		selections.put(1, new GoToShop(shopInventory));					//Creates new GoToShop Object as a Selections object.
		selections.put(2, new ChooseCharacterName(gameCharacter));		//Creates new ChooseCharacterName Object as a Selections object.
		selections.put(3, new ChooseWeapon());							//Creates new ChooseWeapon Object as a Selections object.
		selections.put(4, new ChooseArmour());							//Creates new ChooseArmour Object as a Selections object.
		selections.put(5, new StartBattle());							//Creates new StartBattle Object as a Selections object.
		ui.displayMenu(selections);		
	}
}

