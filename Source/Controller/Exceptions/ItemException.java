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

