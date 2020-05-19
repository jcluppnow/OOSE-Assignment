/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         AvalonApp.java                                                *
* Purpose:          Main Run file for Game.										  *
* Unit:             OOSE                                                          *
* Last Modified:    27/04/2020                                                    *
**********************************************************************************/
package Controller;

//Import Custom Packages
import Controller.*;
import View.UserInterface;
import FileIO.ReadFile;
import Model.MainCharacter;

//Import Custom Packages
import java.util.*;

public class AvalonApp
{
    public static void main(String[] args)
    {
		MainCharacter gameCharacter = new MainCharacter();
		UserInterface ui = new UserInterface(gameCharacter);				
		gameCharacter.add(ui);												//Add UserInterface as an observer to MainCharacter
		MenuController mc = new MenuController();
		
		try
		{
			mc.run(gameCharacter, ui);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("Exception");
		}
		
	}
}

