package Controller;
import Model.MainCharacter;
import View.UserInterface;
import java.util.*;
public class ChooseWeapon implements Selection
{
	private MainCharacter gameCharacter;
	private UserInterface ui;
	public ChooseWeapon(MainCharacter inGameCharacter, UserInterface inUI)
	{
		this.gameCharacter = inGameCharacter;
		this.ui = inUI;
	}
		
	@Override
	public void doSelection()
	{
		gameCharacter.displayInventory();
	}
}