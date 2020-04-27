/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         MainCharacter.java                                            *
* Purpose:          Handles all MainCharacter functionality.					  *                                                      *
* Unit:             OOSE                                                          *
* Last Modified:    27/04/2020                                                    *
**********************************************************************************/
package Model;
import View.UserInterface;
import Model.Item;
import java.util.*;

public class MainCharacter
{
	//Classfields
	private String name;
	private int maxHealth;
	private int currentHealth;
	private List<Item> inventory;
	private Item mainWeapon;
	private Item mainArmour;
	private int gold;
	
	/*******************************************************************************
	* Submodule: MainCharacter                                                     *
	* Import:    None 															   *
	* Export:    None                                                              *
	* Assertion: Default Constructor for MainCharacter.					           *
	*******************************************************************************/
	public MainCharacter()
	{
		name = "";
		maxHealth = 30;
		currentHealth = maxHealth;
		inventory = new ArrayList<Item>();
		mainWeapon = null;
		mainArmour = null;
		gold = 100;
	}
	
	/*******************************************************************************
	*                                MUTATORS                                      *
	********************************************************************************
	*              Responsible for setting all MainCharacter classfields.          *
	*******************************************************************************/
	public void setName(String inName)
	{
		name = inName;
	}
	
	public void increaseHealth(int amount)
	{
		currentHealth = currentHealth + amount;
		if (currentHealth > maxHealth)
		{
			currentHealth = maxHealth;
		}
		//Call notify on Observers.
	}
	
	public void addToInventory(Item inItem)
	{
		inventory.add(inItem);
	}
	
	public void removeFromInventory(Item inItem)
	{
		//To be added.
	}
	
	public void setMainWeapon(Item inItem)
	{
		mainWeapon = inItem;
	}
	
	public void setMainArmour(Item inItem)
	{
		mainArmour = inItem;
	}
	
	public void decreaseHealth(int amount)
	{
		currentHealth = currentHealth - amount;
		if (currentHealth < 0)
		{
			currentHealth = 0;
		}
		//Notify Observers
	}
	
	public void increaseGold(int amount)
	{
		gold = gold + amount;
		//Notify Observers
	}
	
	public void decreaseGold(int amount)
	{
		gold = gold - amount;
		//Notify Observers
	}
	
	/*******************************************************************************
	*                                 ACCESSORS                                    *
	********************************************************************************
	*             Responsible for accessing all MainCharacter classfields.         *
	*******************************************************************************/
	public int getMaxHealth()
	{
		return maxHealth;
	}
	
	public int getCurrentHealth()
	{
		return currentHealth;
	}
	
	public List<Item> getInventory()
	{
		return inventory;
	}
	
	public int getFunds()
	{
		return gold;
	}
	
	public String getName()
	{
		return name;
	}
	
	public Item getItemFromInventory(int index)
	{
		return inventory.get(index);
	}
	
	public Item getWeapon()
	{
		return mainWeapon;
	}
	
	public Item getArmour()
	{
		return mainArmour;
	}
	
	public void displayInventory()
	{
		UserInterface ui = new UserInterface();
		ui.displayCharacterInventory(inventory);
	}
	

}
	
	