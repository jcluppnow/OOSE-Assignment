package Controller.Exceptions;

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

