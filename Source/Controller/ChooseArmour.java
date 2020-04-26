package Controller;
import Model.MainCharacter;
import View.UserInterface;
import java.util.*;
public class ChooseArmour implements Selection
{
	private MainCharacter gameCharacter;
	private UserInterface ui;
	
	public ChooseArmour(MainCharacter inGameCharacter, UserInterface inUI)
	{
		gameCharacter = inGameCharacter;
		ui = inUI;
	}
	@Override
	public void doSelection()
	{
		System.out.println("STUB FOR CHOOSE ARMOUR");
	}
}