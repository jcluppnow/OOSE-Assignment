package FileIO;
import Controller.CreateItem;
import Controller.Exceptions.CreateItemException;
import Model.Item;
import java.util.*;
import java.io.*;

public class ReadFile
{
	public ArrayList<Item> readCSVFile()
	{
		String Line;
		ArrayList<Item> fileContents = new ArrayList<Item>();
		BufferedReader bReader = null;
		CreateItem itemCreator = new CreateItem();
		try
		{
			bReader = new BufferedReader(new FileReader("Inventory.txt"));
			String line = bReader.readLine();
			while (line != null)
			{
				try
				{
					Item newItem = itemCreator.CreateItem(line);
					fileContents.add(newItem);
				}
				catch (CreateItemException cie)
				{
					//Dont add to fileContents
				}
				line = bReader.readLine();
			}
			bReader.close();
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