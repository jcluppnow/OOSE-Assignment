package Model;

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
	public void setMinDefence(int inMinDefence)
	{
		if (validateInteger(inMinDefence))
		{
			minDefence = inMinDefence;
		}
	}
	
	public void setMaxDefence(int inMaxDefence)
	{
		if (validateInteger(inMaxDefence))
		{
			maxDefence = inMaxDefence;
		}
	}
	
	public void setMaterial(String inMaterial)
	{
		if (validateString(inMaterial))
		{
			material = inMaterial;
		}
	}
}		