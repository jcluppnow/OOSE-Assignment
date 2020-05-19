/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:        	MainCharacterTestHarness.java                                 *
* Purpose:          Tests the properties of the MainCharacter Model.			  *
* Unit:             OOSE                                                          *
* Last Modified:    18/05/2020                                                    *
**********************************************************************************/
package TestHarnesses;

//Import Custom Packages
import Controller.EnchantmentFactory;
import Model.MainCharacter;

public class EnchantmentFactoryTestHarness
{
	public static void main(String args[])
	{
		EnchantmentFactory ef = new EnchantmentFactory();
		MainCharacter gameCharacter = new MainCharacter();
		
		String enchantment1 = "Enchantment, Damage + 2, Cost: 5, Add 2 to Attack Damage";
		String enchantment2 = "Enchantment, Damage + 5, Cost: 10, Add 10 to Attack Damage";
		String enchantment3 = "Enchantment, Fire Damage, Cost: 20, Adds between 5 and 10 to Attack Damage";
		String enchantment4 = "Enchantment, Power-Up, Cost: 10, Multiples Attack Damage by 1.1.";
		
		System.out.println("\n\u001b[32mGame Character Before Decoration: \n \u001b[0m" + gameCharacter.toString());
		
		System.out.println("Damage Before Enchantment: " +gameCharacter.getWeapon().calcDamage());
		
		
		ef.CreateEnchantment(enchantment1, gameCharacter);
		System.out.println("Damage After Applying Enchantment 1: " + gameCharacter.getWeapon().calcDamage());
		
		System.out.println("\n\u001b[31m Game Character After Decoration: \n \u001b[0m" + gameCharacter.toString());
		
		ef.CreateEnchantment(enchantment2, gameCharacter);
		System.out.println("Damage After Applying Enchantment 2: " + gameCharacter.getWeapon().calcDamage());
		
		ef.CreateEnchantment(enchantment3, gameCharacter);
		System.out.println("Damage After Applying Enchantment 3: " + gameCharacter.getWeapon().calcDamage());
		
		ef.CreateEnchantment(enchantment4, gameCharacter);
		System.out.println("Damage After Applying Enchantment 4: " + gameCharacter.getWeapon().calcDamage());
		
		ef.CreateEnchantment(enchantment4, gameCharacter);
		System.out.println("Damage After Applying Enchantment 4: " + gameCharacter.getWeapon().calcDamage());
		
		ef.CreateEnchantment(enchantment4, gameCharacter);
		System.out.println("Damage After Applying Enchantment 4: " + gameCharacter.getWeapon().calcDamage());
		
		ef.CreateEnchantment(enchantment4, gameCharacter);
		System.out.println("Damage After Applying Enchantment 4: " + gameCharacter.getWeapon().calcDamage());
		
		System.out.println("\n\u001b[32mGame Character After All Decoration: \n \u001b[0m" + gameCharacter.toString());
		
		

		
	}
}
		
