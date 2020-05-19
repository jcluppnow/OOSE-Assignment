/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         MainCharacter.java                                            *
* Purpose:          Handles all MainCharacter functionality.					  *                                                      *
* Unit:             OOSE                                                          *
* Last Modified:    27/04/2020                                                    *
**********************************************************************************/
package Model;

//Import Custom Packages
import View.UserInterface;
import Controller.IObservable;
import View.IObserver;
import Model.Item;

//Import Java Packages
import java.util.*;

public class MainCharacter implements IObservable
{
	//Classfields
	private ArrayList<IObserver> observers;
	private String name;
	private int maxHealth;
	private int currentHealth;
	private List<Item> inventory;
	private Weapon mainWeapon;
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
		observers = new ArrayList<IObserver>();
		name = "";
		maxHealth = 30;
		currentHealth = maxHealth;
		Weapon newWeapon = new Weapon("Short Sword", 5, 9, 10, "slashing", "Sword");
		Item newArmour = new Armour("Leather Armour", 5, 15, 10, "Leather");
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
	public void add(IObserver inObserver)
	{
		observers.add(inObserver);
	}
	
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
		notify();
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
		//Justifiable Down Casting, guarantees that the item is of type Weapon.
		if (inItem.getItemType().equals("Weapon"))
		{
			mainWeapon =  (Weapon) inItem;
		}
		else
		{
			//Throw Main Character Exception. 
		}
	}
	
	public void setMainArmour(Item inItem)
	{
		//Justifiable Down Casting, guarantees that the item is of type Armour.
		if (inItem.getItemType().equals("Armour"))
		{
			mainArmour = (Armour) inItem;
		}
		else
		{
			//Throw Main Character Exception. 
		}
	}
	
	public void decreaseHealth(int amount)
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
		for (IObserver observer : observers)
		{
			observer.update();
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
	
	public Item getArmour()
	{
		return mainArmour;
	}
	
	public void displayInventory()
	{
		UserInterface ui = new UserInterface(this);
		ui.displayCharacterInventory(inventory);
	}
	

}
	
	