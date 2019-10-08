import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    String playerName;
    Scanner keyboard = new Scanner(System.in);

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerCounter(){
        System.out.println("How many players are you [2-4]?");
        int numberOfPlayers = keyboard.nextInt();
        while(numberOfPlayers < 2 || numberOfPlayers > 4){
            System.out.println("Choose a number between 2 and 4 only.");
            numberOfPlayers = keyboard.nextInt();
        }
        return numberOfPlayers;
    }

    public ArrayList getPlayerNames(int numberOfPlayers){
        ArrayList<String> players = new ArrayList();
        for(int i=0; i<numberOfPlayers; i++){
            System.out.println("Enter a player name: ");
            String name = keyboard.next();
            players.add(name);
        }
        return players;
    }


}