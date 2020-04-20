import java.util.*;
import View.UserInterface;
public class AvalonApp
{
    private static Scanner input = new Scanner(System.in);
    private static Map<Integer, Selection> menuSelections;

    public static void main(String[] args)
    {
        UserInterface ui = new UserInterface();
        menuSelections = new HashMap<Integer, Selection>();
        menuSelections.put(1, new GoToShop());
        menuSelections.put(2, new ChooseCharacterName());
        menuSelections.put(3, new ChooseWeapon());
        menuSelections.put(4, new ChooseArmour());
        menuSelections.put(5, new StartBattle());
        menuSelections.put(6, new ExitGame());

        /* Read the file after this. */

        ui.displayMenu();
    }

}