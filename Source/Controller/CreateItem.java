import Model.*;
import Controller.Exceptions.CreateItemException;
import java.util.*;

public class CreateItem
{
	public Item CreateItem(String line) throws CreateItemException
	{
		String[] parts = line.split(",");
		String name;
		int cost;
		Item newItem =  null;
		try
		{
			if ((parts.length < 8) || (parts.length > 0))		
			{
				name = parts[1];
				cost = Integer.parseInt(parts[4]);
				if (parts[0].equals('W'))
				{
					int minDamage, maxDamage;
					String damageType, weaponType;
					minDamage = Integer.parseInt(parts[2]);
					maxDamage = Integer.parseInt(parts[3]);
					damageType = parts[5];
					weaponType = parts[6];
					
					newItem = new Weapon(name, cost, minDamage, maxDamage, damageType, weaponType);				
				}
				else if (parts[0].equals('A'))
				{
					int minDefence, maxDefence;
					String material;
					minDefence = Integer.parseInt(parts[2]);
					maxDefence = Integer.parseInt(parts[3]);
					material = parts[5];
					
					newItem = new Armour(name, cost, minDefence, maxDefence, material);
				}
				else if (parts[0].equals('P'))
				{
					int minEffect, maxEffect;
					char type;
					minEffect = Integer.parseInt(parts[2]);
					maxEffect = Integer.parseInt(parts[3]);
					type = parts[5].charAt(0);
					
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