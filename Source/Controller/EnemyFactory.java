/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         EnemyFactory.java                                             *
* Purpose:          Responsible for all Enemy Creation via the Factory Pattern.	  *
* Unit:             OOSE                                                          *
* Last Modified:    27/04/2020                                                    *
**********************************************************************************/
package Controller;

//Import Custom Packages
import Model.Enemy;
import Model.Slime;
import Model.Goblin;
import Model.Ogre;
import Model.Dragon;

//Import Java Packages
import java.util.*;
import java.lang.Math;

public class EnemyFactory
{
	//Class Fields
	private int SlimeProbability;
	private int GoblinProbability;
	private int OgreProbability;
	private int DragonProbability;

	/*******************************************************************************
	* Submodule: EnemyFactory                                                      *
	* Import:    None 		                                                       *
	* Export:    None                                                              *
	* Assertion: Default Constructor for EnemyFactory.	         		           *
	*******************************************************************************/	
	public EnemyFactory()
	{
		//Initial Starting Probabilities of F
		SlimeProbability = 50;				
		GoblinProbability = 30;
		OgreProbability = 20;
		DragonProbability = 0;
	}
	
	/*******************************************************************************
	* Submodule: toString                                                          *
	* Import:    None                                                              *
	* Export:    String                                                            *
	* Assertion: Converts Probabilities to a String.					           *
	*******************************************************************************/
	public String toString()
	{
		return "Slime : " + SlimeProbability + " Goblin: " + GoblinProbability + " Ogre: " + OgreProbability + " Dragon: " + DragonProbability + "\n";
	}
	
	/*******************************************************************************
	* Submodule: CreateEnemy                                                       *
	* Import:    None                                                              *
	* Export:    newEnemy (Enemy)                                                  *
	* Assertion: Creates enemy object based on calculate probability.	           *
	*******************************************************************************/
	public Enemy CreateEnemy()
	{
		Enemy newEnemy = null;
		String type;
		type = calcEnemy();

		if (type.equals("Slime"))
		{
			newEnemy = new Slime();
		}
		else if (type.equals("Goblin"))
		{
			newEnemy = new Goblin();
		}
		else if (type.equals("Ogre"))
		{
			newEnemy = new Ogre();
		}
		else
		{
			newEnemy = new Dragon();
		}
		
		timeStepProbabilities();
		
		return newEnemy;
	}
	
	/*******************************************************************************
	* Submodule: calcEnemy                                                         *
	* Import:    None                                                              *
	* Export:    foundEnemy (String)                                               *
	* Assertion: Calculates probability of enemy spawning.				           *
	*******************************************************************************/
	private String calcEnemy()
	{
		ArrayList<String> enemies = new ArrayList<String>();
		
        if (SlimeProbability != 0)
        {
            for (int i = 0; i < SlimeProbability; i++)
            {
                enemies.add("Slime");
            }
        }
        
        if (GoblinProbability != 0)
        {
            for (int i = 0; i < GoblinProbability; i++)
            {
                enemies.add("Goblin");
            }
        }
           
        if (OgreProbability != 0)
        {
            for (int i = 0; i < OgreProbability; i++)
            {
                enemies.add("Ogre");
            }
        }
		
		if (DragonProbability != 0)
		{
			for (int i = 0; i < DragonProbability; i++)
			{
				enemies.add("Dragon");
			}
		}
		
		int enemy = getRandom();
        String foundEnemy = enemies.get(enemy);
		
		return foundEnemy;
	}
	
	/*******************************************************************************
	* Submodule: timeStepProbabilities                                             *
	* Import:    None                                                              *
	* Export:    None                                                              *
	* Assertion: Increment/Decrement Probabilities every run.			           *
	*******************************************************************************/
	private void timeStepProbabilities()
	{
		if(SlimeProbability > 5)
		{
			SlimeProbability = SlimeProbability - 5;
		}
		
		if (GoblinProbability > 5)
		{
			GoblinProbability = GoblinProbability - 5;
		}
		
		if (OgreProbability > 5)
		{
			OgreProbability = OgreProbability - 5;
		}
		
		DragonProbability = DragonProbability + 15;
		if (DragonProbability > 85)
		{
			DragonProbability = 85;
		}
	}
	
	/*******************************************************************************
	* Submodule: getRandom                                                         *
	* Import:    None                                                              *
	* Export:    value (Integer)                                                   *
	* Assertion: Calculates a Random Integer between 1 and 100.			           *
	*******************************************************************************/
	public int getRandom()
    {
       int inMaximum = 99;
       int inMinimum = 0;
       int range = inMaximum - inMinimum + 1;
	   int value = (int) (Math.random() * range) + inMinimum;
	   return value;
    }
}