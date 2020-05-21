/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         AttackStrategy.java                                           *
* Purpose:          Interface for the Strategy Pattern.    						  *
* Unit:             OOSE                                                          *
* Last Modified:    20/05/2020                                                    *
**********************************************************************************/
/*package Controller;

//Import Custom Packages
import Model.MainCharacter;
import Model.Enemy;*/

public interface AttackStrategy
{
	public void attack(MainCharacter gameCharacter, Enemy enemy);	//Implicitly Public Abstract
}