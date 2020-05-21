/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         Weapon.java                                		              *
* Purpose:          Handles all characteristics of Weapon Class.				  *
* Unit:             OOSE                                                          *
* Last Modified:    27/04/2020                                                    *
**********************************************************************************/
/*package Model;

//Import Custom Packages
import Controller.Exceptions.WeaponException;*/

//Import Java Packages
import java.lang.Math;

public class Weapon extends Item
{
	private int minDamage;
	private int maxDamage;
	private String damageType;
	private String weaponType;
	private static final String itemType = "Weapon";
	
	public Weapon()
	{
		super();
		minDamage = 0;
		maxDamage = 0;
		damageType = null;
		weaponType = "";
	}

	public Weapon(String inItemName, int inMinDamage, int inMaxDamage, int inCost, String inDamageType, String inWeaponType)
	{
		super(inItemName, inCost);
		if ((validateInteger(inMinDamage)) && (validateInteger(inMaxDamage)) && (validateString(inDamageType)) && (validateWeaponType(inWeaponType)))
		{
			minDamage = inMinDamage;
			maxDamage = inMaxDamage;
			damageType = inDamageType;
			weaponType = inWeaponType;
		}
	}
	
	//Accessors
	public String getWeaponType()
	{
		return weaponType;
	}
	
	public int getMinDamage()
	{
		return minDamage;
	}
	
	public int getMaxDamage()
	{
		return maxDamage;
	}
	
	public int calcDamage()
	{
		return getRandomValue(minDamage, maxDamage);
	}
	
	public String getDamageType()
	{
		return damageType;
	}
	
	public String getItemType()
	{
		return itemType;
	}
	
	public String toString()
	{
		return (super.toString() + ", Minimum Damage: " + minDamage + ", Maxiumum Damage: " + maxDamage + ", Damage Type: " + damageType + ", Weapon Type: " + weaponType);
	}
	
	public void setMinDamage(int inMinDamage) throws WeaponException
	{
		if (validateInteger(inMinDamage))
		{
			minDamage = inMinDamage;
		}
		else
		{
			throw new WeaponException("Invalid Minimum Damage - Weapon.");
		}
	}
	
	public void setMaxDamage(int inMaxDamage) throws WeaponException
	{
		if (validateInteger(inMaxDamage))
		{
			maxDamage = inMaxDamage;
		}
		else
		{
			throw new WeaponException("Invalid Maxiumum Damage - Weapon.");
		}
	}
	
	public void setDamageType(String inDamageType) throws WeaponException
	{
		if (validateString(inDamageType))
		{
			damageType = inDamageType;
		}
		else
		{
			throw new WeaponException("Invalid Damage Type - Weapon.");
		}
	}
	
	public void setWeaponType(String inWeaponType) throws WeaponException
	{
		if (validateWeaponType(inWeaponType))
		{
			weaponType = inWeaponType;
		}
		else
		{
			throw new WeaponException("Invalid Weapon Type - Weapon.");
		}
	}
	
	private boolean validateWeaponType(String inWeaponType)
	{
		boolean validWeaponType = false;
		String emptyString = "";
		
		if ((inWeaponType.equals("Sword") || inWeaponType.equals("Axe") || inWeaponType.equals("Staff")) && (!(inWeaponType.equals(emptyString))))
		{
			validWeaponType = true;
		}
		return validWeaponType;

	}
	
	protected int getRandomValue(int inMinimum, int inMaximum)
	{
		int range = inMaximum - inMinimum + 1;
		int value = (int) (Math.random() * range) + inMinimum;
//System.out.println("Get Random Damage Debug: Minimum Damage: " + inMinimum + " Maxiumum Damage: " + inMaximum + "\nCalculate Value: " + value);
		return value;
	}
}
	