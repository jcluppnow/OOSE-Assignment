/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         MainCharacter.java                                            *
* Purpose:          Handles all MainCharacter functionality.					  *
* Unit:             OOSE                                                          *
* Last Modified:    27/04/2020                                                    *
**********************************************************************************/
package Model;

//Import Custom Packages
import Controller.Exceptions.MainCharacterException;
import Controller.MainCharacterObservable;
import View.UserInterface;
import View.MainCharacterObserver;
import Model.Item;
import Model.Armour;
import Model.Weapon;

//Import Java Packages
import java.util.*;

public class MainCharacter implements MainCharacterObservable
{
	//Classfields
	private ArrayList<MainCharacterObserver> observers;
	private String name;
	private int maxHealth;
	private int currentHealth;
	private List<Item> inventory;
	private Weapon mainWeapon;
	private Armour mainArmour;
	private int gold;

	
	/*******************************************************************************
	* Submodule: MainCharacter                                                     *
	* Import:    None 															   *
	* Export:    None                                                              *
	* Assertion: Default Constructor for MainCharacter.					           *
	*******************************************************************************/
	public MainCharacter()
	{
		observers = new ArrayList<MainCharacterObserver>();
		name = "";
		maxHealth = 30;
		currentHealth = maxHealth;
		Weapon newWeapon = new Weapon("Short Sword", 5, 9, 10, "slashing", "Sword");
		Armour newArmour = new Armour("Leather Armour", 5, 15, 10, "Leather");
		mainWeapon = newWeapon;
		mainArmour = newArmour;
		inventory = new ArrayList<Item>();
		inventory.add(newWeapon);
		inventory.add(newArmour);
		gold = 100;
	}
	
	/*******************************************************************************
	*                                MUTATORS                                      *
	********************************************************************************
	*              Responsible for setting all MainCharacter classfields.          *
	*******************************************************************************/
	public void add(MainCharacterObserver inObserver)
	{
		observers.add(inObserver);
	}
	
	public void setName(String inName)
	{
		name = inName;
		notifyObservers();
	}
	
	public void heal(int amount)
	{
		currentHealth = currentHealth + amount;
		if (currentHealth > maxHealth)
		{
			currentHealth = maxHealth;
		}
		notifyObservers();
	}
	
	public void addToInventory(Item inItem)
	{
		inventory.add(inItem);
	}
	
	public void removeFromInventory(int index)
	{
		inventory.remove(index);
	}
	
	public void setMainWeapon(Item inItem) throws MainCharacterException
	{
		//Justifiable Down Casting, guarantees that the item is of type Weapon.
		if (inItem.getItemType().equals("Weapon"))
		{
			mainWeapon =  (Weapon) inItem;
			notifyObservers();
		}
		else
		{
			throw new MainCharacterException("Invalid Type: " + inItem.getItemType() + "\nMust be of type Weapon."); 
		}
	}
	
	public void setMainArmour(Item inItem) throws MainCharacterException
	{
		//Justifiable Down Casting, guarantees that the item is of type Weapon.
		if (inItem.getItemType().equals("Armour"))
		{
			mainArmour =  (Armour) inItem;
			notifyObservers();
		}
		else
		{
			throw new MainCharacterException("Invalid Type: " + inItem.getItemType() + "\nMust be of type Armour."); 
		}
	}
	
	public void takeDamage(int amount)
	{
		currentHealth = currentHealth - amount;
		if (currentHealth < 0)
		{
			currentHealth = 0;
		}
		notifyObservers();
	}
	
	public void increaseGold(int amount)
	{
		gold = gold + amount;
		notifyObservers();
	}
	
	public void decreaseGold(int amount)
	{
		gold = gold - amount;
		notifyObservers();
	}
	
	/*******************************************************************************
	*                                 ACCESSORS                                    *
	********************************************************************************
	*             Responsible for accessing all MainCharacter classfields.         *
	*******************************************************************************/
	public void notifyObservers()
	{
		for (MainCharacterObserver observer : observers)
		{
			observer.updateMainCharacter();
		}
	}
	
	public String toString()
	{
		
		return ("(1) Character Name: " + name + "\n(2) Health: " + currentHealth + "/" + maxHealth + "\n(3) Main Weapon: " + mainWeapon.toString() + "\n(4) Main Armour: " + mainArmour.toString() + "\n(5) Funds: " + gold + " gold\n"); 
	}
	
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
	
	public Weapon getWeapon()
	{
		return mainWeapon;
	}
	
	//Calls it's weapoon's calcDamage method.
	public int getDamage()
	{
		return mainWeapon.calcDamage();
	}
	
	public String getWeaponName()
	{
		return mainWeapon.getItemName();
	}
	
	public Item getArmour()
	{
		return mainArmour;
	}
	
	//Calls it's armour's calcDefence method.
	public int getDefence()
	{
		return mainArmour.calcDefence();
	}
	
	public void displayInventory()
	{
		UserInterface ui = new UserInterface(this);
		ui.displayCharacterInventory(inventory);
	}
	

}
	
	