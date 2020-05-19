/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:        	MainCharacterTestHarness.java                                 *
* Purpose:          Tests the properties of the MainCharacter Model.			  *
* Unit:             OOSE                                                          *
* Last Modified:    18/05/2020                                                    *
**********************************************************************************/
package TestHarnesses;

//Import Custom Packages
import Model.MainCharacter;

public class MainCharacterTestHarness
{
	public static void main(String args[])
	{
		MainCharacter gameCharacter = new MainCharacter();
		
		System.out.println("Game Character Details \n" + gameCharacter.toString());
		
		System.out.println("Max Health: " + gameCharacter.getMaxHealth());
		
		System.out.println("Current Health: " + gameCharacter.getCurrentHealth());
		
		System.out.println("Funds: " + gameCharacter.getFunds());
		
		System.out.println("Name: " + gameCharacter.getName());
		
		System.out.println("Weapon Details:  \n\tMin Damage: " + gameCharacter.getWeapon().getMinDamage() + "\n\tMax Damage: " + gameCharacter.getWeapon().getMaxDamage() + "\n\tCalc Damage: " + gameCharacter.getWeapon().calcDamage() + "\n\tDamage Type: " + gameCharacter.getWeapon().getDamageType() + "\n\tItem Type: " + gameCharacter.getWeapon().getItemType());
	}
}
		
