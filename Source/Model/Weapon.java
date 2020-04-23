package Model;
import Controller.Exceptions.WeaponException;

public class Weapon extends Item
{
	private int minDamage;
	private int maxDamage;
	private String damageType;
	private String weaponType;
	
	public Weapon()
	{
		super();
		minDamage = 0;
		maxDamage = 0;
		damageType = null;
		weaponType = null;
	}

	public Weapon(String inItemName, int inCost, int inMinDamage, int inMaxDamage, String inDamageType, String inWeaponType)
	{
		super(inItemName, inCost);
		if ((validateInteger(inMinDamage)) && (validateInteger(inMaxDamage)) && (validateString(inDamageType)) && (validateString(inWeaponType)))
		{
			minDamage = inMaxDamage;
			maxDamage = inMaxDamage;
			damageType = inDamageType;
			weaponType = inWeaponType;
		}
	}
	//Accessors
	public int getMinDamage()
	{
		return minDamage;
	}
	
	public int getMaxDamage()
	{
		return maxDamage;
	}
	
	public String getDamageType()
	{
		return damageType;
	}
	
	public String getWeaponType()
	{
		return weaponType;
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
		if (validateString(inWeaponType))
		{
			weaponType = inWeaponType;
		}
		else
		{
			throw new WeaponException("Invalid Weapon Type - Weapon.");
		}
	}
}
		