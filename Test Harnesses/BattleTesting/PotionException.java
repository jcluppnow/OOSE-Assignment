/**********************************************************************************
* Author:           Jason Luppnow                                                 *
* Filename:         PotionException.java                                          *
* Purpose:          Handles all PotionException functionality.					  *
* Unit:             OOSE                                                          *
* Last Modified:    27/04/2020                                                    *
**********************************************************************************/
//package Controller.Exceptions;

public class PotionException extends Exception
{
	public PotionException(String message, Throwable cause)
	{
		super(message, cause);
	}
	
	public PotionException(String message)
	{
		super(message);
	}
}

