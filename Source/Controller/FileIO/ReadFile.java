/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         ReadFile.java                                                 *
* Purpose:          Handles all File Reading.									  *                                                      *
* Unit:             OOSE                                                          *
* Last Modified:    27/04/2020                                                    *
**********************************************************************************/
package FileIO;
import Controller.Exceptions.CreateItemException;
import java.util.*;
import java.io.*;

public class ReadFile
{
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
			fileContents.add("Enchantment: Damage + 2  - 5  - Add 2 to Attack Damage");
			fileContents.add("Enchantment: Damage + 5  - 10 - Add 5 to Attack Damage");
			fileContents.add("Enchantment: Damage + 2  - 20 - Adds between 5 & 10 to Attack Damage.");
			fileContents.add("Enchantment: Damage + 2  - 10 - Amplifies attack damage by 10%.\n ");
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