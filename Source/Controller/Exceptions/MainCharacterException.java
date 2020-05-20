/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         MainCharacterException.java                                   *
* Purpose:          Handles all MainCharacterException functionality.			  *
* Unit:             OOSE                                                          *
* Last Modified:    27/04/2020                                                    *
**********************************************************************************/
package Controller.Exceptions;

public class MainCharacterException extends Exception
{
	public MainCharacterException(String message, Throwable cause)
	{
		super(message, cause);
	}
	
	public MainCharacterException(String message)
	{
		super(message);
	}
}

