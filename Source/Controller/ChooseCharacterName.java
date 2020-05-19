/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         ChooseCharacterName.java                                      *
* Purpose:          One of the 5 Strategies, responsible for setting character    *
*                   name. 														  *          
* Unit:             OOSE                                                          *
* Last Modified:    27/04/2020                                                    *
**********************************************************************************/
package Controller;

//Import Custom Packages
import Model.MainCharacter;
import View.UserInterface;

//Import Java Packages
import java.util.*;
public class ChooseCharacterName implements Selection
{
	private MainCharacter gameCharacter;
	private UserInterface ui;
	
	public ChooseCharacterName(MainCharacter mCharacter, UserInterface inUI)
	{
		ui = inUI;
		gameCharacter = mCharacter;
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
		UserInterface ui = new UserInterface(gameCharacter);
		gameCharacter.setName(ui.getCharacterName());
	}
}