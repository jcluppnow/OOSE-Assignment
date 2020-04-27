/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         EnemyFactory.java                                             *
* Purpose:          Responsible for all Enemy Creation via the Factory Pattern.	  *                                                      *
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
	
	public EnemyFactory()
	{
		//Initial Starting Probabilities of F
		SlimeProbability = 50;				
		GoblinProbability = 30;
		OgreProbability = 20;
		DragonProbability = 0;
	}
	
	public String toString()
	{
		return "Slime : " + SlimeProbability + " Goblin: " + GoblinProbability + " Ogre: " + OgreProbability + " Dragon: " + DragonProbability + "\n";
	}
	
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
	
	public int getRandom()
    {
       int inMaximum = 99;
       int inMinimum = 0;
       int range = inMaximum - inMinimum + 1;
	   int value = (int) (Math.random() * range) + inMinimum;
	   return value;
    }
}