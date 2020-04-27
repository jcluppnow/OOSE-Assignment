/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         Enemy.java                                      		      *
* Purpose:          Parent Class for all Enemies.								  *                                                      *
* Unit:             OOSE                                                          *
* Last Modified:    27/04/2020                                                    *
**********************************************************************************/
package Model;

//Import Custom Packages
import Controller.Exceptions.EnemyException;

//Import Java Packages
import java.lang.Math;

public abstract class Enemy
{
	protected String name;
	protected int maxHealth;
	protected int currentHealth;
	protected int minDamage;
	protected int maxDamage;
	protected int minDefence;
	protected int maxDefence;
	protected int reward;

	public Enemy()
	{
		name = "";
		maxHealth = 0;
		currentHealth = 0;
		minDamage = 0;
		maxDamage = 0;
		minDefence = 0;
		maxDefence = 0;
		reward = 0;
	}
	
	public Enemy(String inName, int inMaxHealth, int inMinDamage, int inMaxDamage, int inMinDefence, int inMaxDefence, int inReward)
	{
		if ((validateString(inName)) && (validateInteger(inMaxHealth)) && (validateInteger(inMinDamage)) && (validateInteger(inMaxDamage)) && (validateMinDefence(inMinDefence)) && (validateInteger(inMaxDefence)) && (validateInteger(inReward)))
		{
			name = inName;
			maxHealth = inMaxHealth;
			currentHealth = inMaxHealth;
			minDamage = inMinDamage;
			maxDamage = inMaxDamage;
			minDefence = inMinDefence;
			maxDefence =  inMaxDefence;
			reward = inReward;
		}
	}
	
	//MUTATORS 
	public void setName(String inName) throws EnemyException
	{
		if (validateString(inName))
		{
			name = inName;
		}
		else
		{
			throw new EnemyException("Invalid Name - Enemy.");
		}
	}
	
	public void setMaxHealth(int inMaxHealth) throws EnemyException
	{
		if (validateInteger(inMaxHealth))
		{
			maxHealth = inMaxHealth;
		}
		else
		{
			throw new EnemyException("Invalid Max Health - Enemy.");
		}
	}
	
	public void takeDamage(int inDamage)
	{
		if (inDamage < currentHealth)
		{
			currentHealth = currentHealth - inDamage;
		}
		else
		{
			currentHealth = 0;
			//Notify Observers
		}
	}
	
	public void setMinDamage(int inMinDamage) throws EnemyException
	{
		if (validateInteger(inMinDamage))
		{
			minDamage = inMinDamage;
		}
		else
		{
			throw new EnemyException("Invalid Min Damage - Enemy.");
		}
	}
	
	public void setMaxDamage(int inMaxDamage) throws EnemyException
	{
		if (validateInteger(inMaxDamage))
		{
			maxDamage = inMaxDamage;
		}
		else
		{
			throw new EnemyException("Invalid Max Damage - Enemy.");
		}
	}
	
	public void setMinDefence(int inMinDefence) throws EnemyException
	{
		if (validateInteger(inMinDefence))
		{
			minDefence = inMinDefence;
		}
		else
		{
			throw new EnemyException("Invalid Min Defence - Enemy.");
		}
	}
	
	public void setMaxDefence(int inMaxDefence) throws EnemyException
	{
		if (validateInteger(inMaxDefence))
		{
			maxDefence = inMaxDefence;
		}
		else
		{
			throw new EnemyException("Invalid Max Defence - Enemy.");
		}
	}
	
	public void setReward(int inReward) throws EnemyException
	{
		if (validateInteger(inReward))
		{
			reward = inReward;
		}
		else
		{
			throw new EnemyException("Invalid Reward - Enemy.");
		}
	}
	
	//ACCESSORS
	public String toString()
	{
		return "Name: " + name + " Max Health: " + maxHealth + " Current Health: " + currentHealth + " Min Damage: " + minDamage + " Max Damage: " + maxDamage +  " Min Defence: " + minDefence + " Max Defence: " + maxDefence + " Gold Reward: " + reward + "\n";
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getMaxHealth()
	{
		return maxHealth;
	}
	
	public int getCurrentHealth()
	{
		return currentHealth;
	}
		
	public abstract int getDamage();
	
	protected int getRandomValue(int inMinimum, int inMaximum)
	{
		int range = inMaximum - inMinimum + 1;
		int value = (int) (Math.random() * range) + inMinimum;
		return value;
	}
	
	public abstract int getDefence();
	
	public int getReward()
	{
		return reward;
	}
	
	//Protected Submodules
	protected boolean validateInteger(int inInteger)
	{
		return (inInteger > 0);
	}
	
	protected boolean validateString(String inString)
	{
		boolean validString = true;
		String emptyString = "";
		
		if (inString.equals(emptyString))
		{
			validString = false;
		}
		return validString;
	}
	
	protected boolean validateMinDefence(int inMinDefence)
	{
		return (inMinDefence >= 0);
	}
		
}
	