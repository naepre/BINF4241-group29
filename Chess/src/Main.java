import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Pattern;

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
        //ArrayList[][][] board = game.getBoard();
        //System.out.println("THis" + Arrays.deepToString(board[0][1]));

        //game.validateMove('W', 'N', 2, 2);


        // CHANGE CELL 0,0 OF BOARD
        Game game = new Game();
        char[][][] board = game.getBoard();
        char[] topLeft = Arrays.copyOf(board[0][0], 2);
        System.out.println(topLeft[0]);
        System.out.println(topLeft[1]);

        topLeft[0] = 'z';
        System.out.println(topLeft[0]);
        System.out.println(topLeft[1]);

        board[0][0] = topLeft;
        System.out.println(Arrays.deepToString(board));



        //#######STRING TRANSLATION REGEX########
        System.out.print(Pattern.matches("[KQBNR][a-h|x]", "Kx")); //main move
        System.out.print(Pattern.matches("[KQBNR][x][a-h][1-8]", "Kxb6")); //main eat
        System.out.print(Pattern.matches("[a-h][1-8]", "d8")); //move pawn
        System.out.print(Pattern.matches("[x][a-h][1-8]", "xb8")); //eat pawn

    }

}
