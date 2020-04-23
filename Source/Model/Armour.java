package Model;
import Controller.Exceptions.ArmourException;

public class Armour extends Item
{
	private int minDefence;
	private int maxDefence;
	private String material;
	
	public Armour()
	{
		super();
		minDefence = 0;
		maxDefence = 0;
		material = null;
	}
	
	public Armour(String inName, int inCost, int inMinDefence, int inMaxDefence, String inMaterial)
	{
		super(inName, inCost);
		if ((validateInteger(inMinDefence)) && (validateInteger(inMaxDefence)) && (validateString(inMaterial)))
		{
			minDefence = inMinDefence;
			maxDefence = inMaxDefence;
			material = inMaterial;
		}
	}
	
	//ACCESSORS
	public int getMinDefence()
	{
		return minDefence;
	}
	
	public int getMaxDefence()
	{
		return maxDefence;
	}
	
	public String getMaterial()
	{
		return material;
	}
	
	//MUTATORS
	public void setMinDefence(int inMinDefence) throws ArmourException
	{
		if (validateInteger(inMinDefence))
		{
			minDefence = inMinDefence;
		}
		else
		{
			throw new ArmourException("Invalid Minimum Defence - Armour.");
		}
	}
	
	public void setMaxDefence(int inMaxDefence) throws ArmourException
	{
		if (validateInteger(inMaxDefence))
		{
			maxDefence = inMaxDefence;
		}
		else
		{
			throw new ArmourException("Invalid Maximum Defence - Armour.");
		}
	}
	
	public void setMaterial(String inMaterial) throws ArmourException
	{
		if (validateString(inMaterial))
		{
			material = inMaterial;
		}
		else
		{
			throw new ArmourException("Invalid Material - Armour.");
		}
	}
}		