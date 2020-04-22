package Controller;
import Model.MainCharacter;
import Source.View.UserInterface;

import java.util.*;
public class ChooseCharacterName implements Selection
{
	private MainCharacter gameCharacter;
	
	public ChooseCharacterName(MainCharacter mCharacter)
	{
		gameCharacter = mCharacter;
	}
	
	@Override
	public void doSelection()
	{
		UserInterface ui = new UserInterface();
		gameCharacter.setName(ui.getCharacterName());
	}
}