package Controller;
import Model.MainCharacter;
import Source.View.UserInterface;
import java.util.*;
public class StartBattle implements Selection
{
	private MainCharacter gameCharacter;
	private UserInterface ui;
	
	public StartBattle(MainCharacter inGameCharacter, UserInterface inUI)
	{
		gameCharacter = inGameCharacter;
		ui = inUI;
	}
	
	@Override
	public void doSelection()
	{
		System.out.println("STUB FOR STARTING BATTLE.");
	}
}