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

