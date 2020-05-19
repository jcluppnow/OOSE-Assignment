/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         ReadFile.java                                                 *
* Purpose:          Handles all File Reading.									  *
* Unit:             OOSE                                                          *
* Last Modified:    27/04/2020                                                    *
**********************************************************************************/
package FileIO;

//Import Custom Packages
import Controller.Exceptions.CreateItemException;

//Import Java Packages
import java.util.*;
import java.io.*;

public class ReadFile
{
	/*******************************************************************************
	* Submodule: readCSVFile                                                       *
	* Import:    None                                                              *
	* Export:    fileContents (ArrayList<String>)                                  *
	* Assertion: Reads Items from CSV and adds enchantments to Shop.               *
	*******************************************************************************/
	public ArrayList<String> readCSVFile()
	{
		String Line;
		ArrayList<String> fileContents = new ArrayList<String>();
		BufferedReader bReader = null;
		try
		{
			bReader = new BufferedReader(new FileReader("Inventory.txt"));
			String line = bReader.readLine();
			while (line != null)
			{
				fileContents.add(line);
				line = bReader.readLine();
			}
			bReader.close();
			fileContents.add("Enchantment, Damage + 2, Cost: 5, Add 2 to Attack Damage");
			fileContents.add("Enchantment, Damage + 5, Cost: 10, Add 10 to Attack Damage");
			fileContents.add("Enchantment, Fire Damage, Cost: 20, Adds between 5 and 10 to Attack Damage");
			fileContents.add("Enchantment, Power-Up, Cost: 10, Multiples Attack Damage by 1.1.");			
		}
		catch (IOException ioe)
		{
			try 
			{
				if (bReader != null)
				{
					bReader.close();
				}
			}
			catch (IOException ioe2)
			{
				System.out.println("Can't close file.");
			}
		}
		finally
		{
			try
			{
				if (bReader != null)
				{
					bReader.close();
				}
			}
			catch (IOException ioe3)
			{
				System.out.println("Can't close file.");
			}
		}
		return fileContents;
	}
}