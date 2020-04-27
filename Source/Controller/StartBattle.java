/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         StartBattle.java                                              *
* Purpose:          One of the 5 Strategies, responsible for All Battle 		  *
* 					Activities.													  *                                                      *
* Unit:             OOSE                                                          *
* Last Modified:    27/04/2020                                                    *
**********************************************************************************/
package Controller;
import Model.MainCharacter;
import View.UserInterface;
import java.util.*;
public class StartBattle implements Selection
{
	private MainCharacter gameCharacter;
	private UserInterface ui;
	
	public StartBattle(MainCharacter inGameCharacter, UserInterface inUI)
	{
		gameCharacter = inGameCharacter;
		ui = inUI;
	}
	
	@Override
	public void doSelection()
	{
		System.out.println("STUB FOR STARTING BATTLE.");
	}
}