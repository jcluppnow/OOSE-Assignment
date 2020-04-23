package Model;
import Controller.Exceptions.PotionException;

public class Potion extends Item
{
	private int minEffect;
	private int maxEffect;
	private char type;
	
	public Potion()
	{
		super();
		minEffect = 0;
		maxEffect = 0;
		type = '\u0000';
	}
	
	public Potion(String inName, int inCost, int inMinEffect, int inMaxEffect, char inType)
	{
		super(inName, inCost);
		if ((validateInteger(inMinEffect)) && (validateInteger(inMaxEffect)) && (validateCharacter(inType)))
		{
			minEffect = inMinEffect;
			maxEffect = inMaxEffect;
			type = inType;
		}
	}
	
	//ACCESSORS
	public int getMinEffect()
	{
		return minEffect;
	}
	
	public int getMaxEffect()
	{
		return maxEffect;
	}
	
	public char getType()
	{
		return type;
	}
	
	//MUTATORS 
	public void setMinEffect(int inMinEffect) throws PotionException
	{
		if (validateInteger(inMinEffect))
		{
			minEffect = inMinEffect;
		}
		else
		{
			throw new PotionException("Invalid Minimum Effect - Potion.");
		}
	}
	
	public void setMaxEffect(int inMaxEffect) throws PotionException
	{
		if (validateInteger(inMaxEffect))
		{
			maxEffect = inMaxEffect;
		}
		else
		{
			throw new PotionException("Invalid Maximum Effect - Potion.");
		}
	}
	
	public void setType(char inType) throws PotionException
	{
		if (validateCharacter(inType))
		{
			type = inType;
		}
		else
		{
			throw new PotionException("Invalid Type - Potion.");
		}
	}
	
	//PRIVATE SUBMODULES
	private boolean validateCharacter(char inType)
	{
		boolean validCharacter = true;
		if (inType == ' ')
		{
			validCharacter = false;
		}
		return validCharacter;
	}
} 