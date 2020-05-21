/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         CreateEnemyException.java                                     *
* Purpose:          Handles all CreateEnemyException functionality.				  *
* Unit:             OOSE                                                          *
* Last Modified:    27/04/2020                                                    *
**********************************************************************************/
//package Controller.Exceptions;

public class CreateEnemyException extends Exception
{
	public CreateEnemyException(String message, Throwable cause)
	{
		super(message, cause);
	}
	
	public CreateEnemyException(String message)
	{
		super(message);
	}
}

