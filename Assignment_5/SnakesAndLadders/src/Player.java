import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Player
{


    public int getPlayerCounter()
    {
        int numberOfPlayers = 0;
        boolean correctInput = false;
        while (correctInput == false) {
            try {
                System.out.println("How many players are you [2-4]?");
                Scanner keyboard = new Scanner(System.in);
                numberOfPlayers = keyboard.nextInt();
                if (numberOfPlayers < 2 || numberOfPlayers > 4) {
                    System.out.println("Choose a number between 2 and 4 only.");
                    correctInput = false;
                } else {
                    correctInput = true;
                }
            }
            catch (InputMismatchException exception)
            {
                System.out.println("Please enter an integer between 2 and 4 only");
            }
        }
        return numberOfPlayers;
    }

    public ArrayList getPlayerNames(int numberOfPlayers)
    {
        ArrayList<String> players = new ArrayList();
        for(int i=0; i<numberOfPlayers; i++){
            System.out.println("Enter a player name: ");
            Scanner keyboard = new Scanner(System.in);
            String name = keyboard.next();
            players.add(name);
        }
        System.out.println("\n");
        return players;
    }


}