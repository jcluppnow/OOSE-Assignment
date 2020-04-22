package Controller;
import Model.MainCharacter;
import Source.View.UserInterface;

import java.util.*;
public class ChooseCharacterName implements Selection
{
	private MainCharacter gameCharacter;
	private UserInterface ui;
	
	public ChooseCharacterName(MainCharacter mCharacter, UserInterface inUI)
	{
		ui = inUI;
		gameCharacter = mCharacter;
	}
	
	@Override
	public void doSelection()
	{
		UserInterface ui = new UserInterface();
		gameCharacter.setName(ui.getCharacterName());
	}
}