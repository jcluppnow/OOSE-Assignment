/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         EnemyException.java                                           *
* Purpose:          Handles all EnemyException functionality.					  *
* Unit:             OOSE                                                          *
* Last Modified:    27/04/2020                                                    *
**********************************************************************************/
package Controller.Exceptions;

public class EnemyException extends Exception
{
	public EnemyException(String message, Throwable cause)
	{
		super(message, cause);
	}
	
	public EnemyException(String message)
	{
		super(message);
	}
}

