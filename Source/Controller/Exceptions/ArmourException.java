package Controller.Exceptions;

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

