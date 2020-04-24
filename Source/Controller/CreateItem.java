package Controller;

import Model.*;
import Controller.Exceptions.CreateItemException;
import java.util.*;

public class CreateItem
{
	public Item CreateItem(String line) throws CreateItemException
	{
		String[] parts = line.split(",");
		String name;
		char itemType = parts[0].charAt(0);
		int cost;
		Item newItem =  null;
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
		return newItem;
	}
}