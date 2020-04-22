package FileIO;

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