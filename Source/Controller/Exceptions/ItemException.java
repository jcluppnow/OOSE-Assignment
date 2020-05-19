/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         ItemException.java                    			              *
* Purpose:          Handles all ItemException functionality.					  *
* Unit:             OOSE                                                          *
* Last Modified:    27/04/2020                                                    *
**********************************************************************************/
package Controller.Exceptions;

public class ItemException extends Exception
{
	public ItemException(String message, Throwable cause)
	{
		super(message, cause);
	}
	
	public ItemException(String message)
	{
		super(message);
	}
}

