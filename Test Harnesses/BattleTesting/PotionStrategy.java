/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         PotionStrategy.java                                           *
* Purpose:          Interface for the Strategy Pattern.    						  *
* Unit:             OOSE                                                          *
* Last Modified:    20/05/2020                                                    *
**********************************************************************************/
/*package Controller;

//Import Custom Packages
import Model.MainCharacter;
import Model.Enemy;*/

public interface PotionStrategy
{
	public void usePotion(MainCharacter gameCharacter, Enemy enemy, Potion potion);	//Implicitly Public Abstract
}