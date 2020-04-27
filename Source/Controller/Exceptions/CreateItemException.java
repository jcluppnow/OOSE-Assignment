/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         CreateItemException.java                                      *
* Purpose:          Handles all CreateItemException functionality.				  *                                                      *
* Unit:             OOSE                                                          *
* Last Modified:    27/04/2020                                                    *
**********************************************************************************/
package Controller.Exceptions;

public class CreateItemException extends Exception
{
	public CreateItemException(String message, Throwable cause)
	{
		super(message, cause);
	}
	
	public CreateItemException(String message)
	{
		super(message);
	}
}

