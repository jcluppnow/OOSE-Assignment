package Controller.Exceptions;

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

