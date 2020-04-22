package Model;

public class MainCharacter
{
	//Classfields
	private String name;
	private int maxHealth;
	private int currentHealth;
	//private ArrayList<Weapon> inventory;
	//private Item mainWeapon;
	//private Item mainArmour;
	private int gold;
	
	public MainCharacter()
	{
		name = "";
		maxHealth = 30;
		currentHealth = maxHealth;
		gold = 100;
	}
	
	//Mutators
	
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
	
	//Accessors
	public int getMaxHealth()
	{
		return maxHealth;
	}
	
	public int getCurrentHealth()
	{
		return currentHealth;
	}
	
	public int getGold()
	{
		return gold;
	}
	
	public String getName()
	{
		return name;
	}
}
	
	