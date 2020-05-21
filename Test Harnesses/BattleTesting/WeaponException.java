/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         WeaponException.java                                          *
* Purpose:          Handles all WeaponException functionality.					  *
* Unit:             OOSE                                                          *
* Last Modified:    27/04/2020                                                    *
**********************************************************************************/
//package Controller.Exceptions;

public class WeaponException extends Exception
{
	public WeaponException(String message, Throwable cause)
	{
		super(message, cause);
	}
	
	public WeaponException(String message)
	{
		super(message);
	}
}

