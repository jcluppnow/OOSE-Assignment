/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         AvalonApp.java                                                *
* Purpose:          Main Run file for Game.										  *                                                      *
* Unit:             OOSE                                                          *
* Last Modified:    27/04/2020                                                    *
**********************************************************************************/
package Controller;

import Controller.*;
import View.UserInterface;
import FileIO.ReadFile;
import Model.MainCharacter;
import java.util.*;


public class AvalonApp
{
    public static void main(String[] args)
    {
		UserInterface ui = new UserInterface();
		MainCharacter gameCharacter = new MainCharacter();
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

