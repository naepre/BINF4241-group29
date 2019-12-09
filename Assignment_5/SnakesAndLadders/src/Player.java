import java.util.ArrayList;
import java.util.Scanner;

public class Player
{
    Scanner keyboard = new Scanner(System.in);
    String playerName;
    static int numberOfPlayers;


    public void getPlayerCounter()
    {
        System.out.println("How many players are you [2-4]?");
        numberOfPlayers = keyboard.nextInt();
        while(numberOfPlayers < 2 || numberOfPlayers > 4){
            System.out.println("Choose a number between 2 and 4 only.");
            numberOfPlayers = keyboard.nextInt();
        }
    }

    public ArrayList getPlayerNames(int numberOfPlayers)
    {
        ArrayList<String> players = new ArrayList();
        for(int i=0; i<numberOfPlayers; i++){
            System.out.println("Enter a player name: ");
            String name = keyboard.next();
            players.add(name);
        }
        System.out.println("\n");
        return players;
    }


}