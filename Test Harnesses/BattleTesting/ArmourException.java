/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         ArmourException.java                                          *
* Purpose:          Handles all ArmourException functionality.					  *
* Unit:             OOSE                                                          *
* Last Modified:    27/04/2020                                                    *
**********************************************************************************/
//package Controller.Exceptions;

public class ArmourException extends Exception
{
	public ArmourException(String message, Throwable cause)
	{
		super(message, cause);
	}
	
	public ArmourException(String message)
	{
		super(message);
	}
}

