/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         ItemFactory.java                                              *
* Purpose:          Responsible for all Item Creation via Factory Pattern. 		  *                                                      *
* Unit:             OOSE                                                          *
* Last Modified:	27/04/2020                                                    *
**********************************************************************************/
package Controller;

//Import Custom Packages
import Model.Item;
import Model.Weapon;
import Model.Potion;
import Model.Armour;
import Controller.Exceptions.CreateItemException;

//Import Java Packages
import java.util.*;

public class ItemFactory
{
	public Item CreateItem(String line) throws CreateItemException
	{
		String[] parts = line.split(",");
		String name;
		char itemType = parts[0].charAt(0);
		int cost;
		Item newItem = null;
		try
		{
			if ((parts.length < 8) || (parts.length > 0))		
			{

				name = parts[1].trim();
				cost = Integer.parseInt((parts[4]).trim());
				if (itemType == 'W')
				{
					int minDamage, maxDamage;
					String damageType, weaponType;
					minDamage = Integer.parseInt((parts[2]).trim());
					maxDamage = Integer.parseInt((parts[3]).trim());
					damageType = parts[5].trim();
					weaponType = parts[6].trim();
					
					newItem = new Weapon(name, cost, minDamage, maxDamage, damageType, weaponType);				
				}
				else if (itemType == 'A')
				{
					int minDefence, maxDefence;
					String material;
					minDefence = Integer.parseInt((parts[2]).trim());
					maxDefence = Integer.parseInt((parts[3]).trim());
					material = parts[5].trim();
					
					newItem = new Armour(name, cost, minDefence, maxDefence, material);
				}
				else if (itemType == 'P')
				{
					int minEffect, maxEffect;
					char type;
					minEffect = Integer.parseInt((parts[2]).trim());
					maxEffect = Integer.parseInt((parts[3]).trim());
					type = parts[5].trim().charAt(0);					
					newItem = new Potion(name, cost, minEffect, maxEffect, type);
					
				}
				else
				{
					throw new CreateItemException("Item cannot be created from given types - CreateItem.");
				}
			}
			else
			{
				throw new CreateItemException("Item cannot be created invalid length - CreateItem.");
			}
		}
		catch (NumberFormatException nfe)
		{
			throw new CreateItemException("String does not contain an integer - CreateItem.");
		}
		catch (IndexOutOfBoundsException oob)
		{
			throw new CreateItemException("Index is out of bounds when converting Type - CreateItem.");
		}
		catch (NullPointerException npe)
		{
			
		}
		return newItem;
	}
}