import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main(String[] args){

        Player player1 = new Player("Alice", "white");
        Player player2 = new Player("Bob", "black");
/*
        System.out.println(player1.getName());
        System.out.println(player1.getColor());




        Game game = new Game();
        String[][] board = game.getBoard();

        for(int i = 0; i < board.length; i++){
            if (i % 8 == 0) {
                System.out.println();
            }
            System.out.print(Arrays.deepToString(board[i]));
        }


 */
        Game game = new Game();
        String[][][] board = game.getBoard();
        game.validateMove('W', 'N', 2, 2);
    }

}
