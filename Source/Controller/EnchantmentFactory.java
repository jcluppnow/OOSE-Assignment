/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         ItemFactory.java                                              *
* Purpose:          Responsible for all Item Creation via Factory Pattern. 		  *
* Unit:             OOSE                                                          *
* Last Modified:	27/04/2020                                                    *
**********************************************************************************/
package Controller;

//Import Custom Packages
import Model.MainCharacter;
import Model.Weapon;

public class EnchantmentFactory
{
	public void CreateEnchantment(String enchantment, MainCharacter gameCharacter)
	{
		String[] parts = enchantment.split(",");
		Weapon newWeapon = null;
		try
		{
			if (parts[1].equals(" Damage + 2"))
			{
				newWeapon = new PlusTwoDecorator(gameCharacter.getWeapon());
				gameCharacter.setMainWeapon(newWeapon);
			}
			else if (parts[1].equals(" Damage + 5"))
			{
				newWeapon = new PlusFiveDecorator(gameCharacter.getWeapon());
				gameCharacter.setMainWeapon(newWeapon);
			}
			else if (parts[1].equals(" Fire Damage"))
			{
				newWeapon = new FireDamageDecorator(gameCharacter.getWeapon());
				gameCharacter.setMainWeapon(newWeapon);
			}
			else if (parts[1].equals(" Power-Up"))
			{
				newWeapon = new PowerUpDecorator(gameCharacter.getWeapon());
				gameCharacter.setMainWeapon(newWeapon);
			}
			else
			{
				//Throw CreateEnchantment error.
			}
		}
		catch (Exception e)
		{
			
		}
	}
}
