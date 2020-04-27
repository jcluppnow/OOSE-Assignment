package Model;

public class Slime extends Enemy
{
	public Slime()
	{
		//Name, MaxHealth, Minimum Damage, Maximum Damage, Minimum Defence, Maximum Defence, Reward
		//Default Values for a Slime.
		super("Slime", 10, 3, 5, 0, 2, 10);
	}
	
	//Accessors
	public int getDamage()
	{ 
		return getRandomValue(minDamage, maxDamage);
	}
	
	public int getDefence()
	{
		return getRandomValue(minDefence, maxDefence);
	}
	
}
	
	