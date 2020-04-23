package Model;

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
		if ((validateInteger(inMaxDamage)) && (validateInteger(inMaxDamage)) && (validateString(inDamageType)) && (validateString(inWeaponType)))
		{
			minDamage = inMinDamage;
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
	
	public void setMinDamage(int inMinDamage)
	{
		if (validateInteger(inMinDamage))
		{
			minDamage = inMinDamage;
		}
	}
	
	public void setMaxDamage(int inMaxDamage)
	{
		if (validateInteger(inMaxDamage))
		{
			maxDamage = inMaxDamage;
		}
	}
	
	public void setDamageType(String inDamageType)
	{
		if (validateString(inDamageType))
		{
			damageType = inDamageType;
		}
	}
	
	public void setWeaponType(String inWeaponType)
	{
		if (validateString(inWeaponType))
		{
			weaponType = inWeaponType;
		}
	}
}
		