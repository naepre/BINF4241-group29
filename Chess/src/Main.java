import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main(String[] args){

        Player player1 = new Player("Alice", "white");
        Player player2 = new Player("Bob", "black");

        System.out.println(player1.getName());
        System.out.println(player1.getColor());




        Game game = new Game();
        System.out.println(Arrays.deepToString(game.getBoard()));
    }


}
