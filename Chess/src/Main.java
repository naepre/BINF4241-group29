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


        //#######STRING TRANSLATION REGEX########
        /*
        System.out.print(Pattern.matches("[KQBNR][a-h|x]", "Kx")); //main move
        System.out.print(Pattern.matches("[KQBNR][x][a-h][1-8]", "Kxb6")); //main eat
        System.out.print(Pattern.matches("[a-h][1-8]", "d8")); //move pawn
        System.out.print(Pattern.matches("[x][a-h][1-8]", "xb8")); //eat pawn
*/
        //find coordinate mapping from letter literal

        //######################################




        //######VALIDATE MOVE##########
        Game game = new Game();
        char[][][] boardBeforeMove = game.getBoard();
        System.out.println(Arrays.deepToString(boardBeforeMove));

        //char[] topLeft = Arrays.copyOf(board[0][0], 2);
        //System.out.println(topLeft[0]);
        //System.out.println(topLeft[1]);
        //topLeft[0] = 'z';
        //System.out.println(topLeft[0]);
        //System.out.println(topLeft[1]);
        //board[0][0] = topLeft;
        //System.out.println(Arrays.deepToString(board));

        char playerColor = 'w';
        char figureType = 'N';
        int targetX = 2;
        int targetY = 2;

        boolean isValidMove = game.validateMove(playerColor, figureType, targetX, targetY);
        System.out.println("IS VALID MOVE: " + isValidMove);

        int[] startPosition = {0, 1}; //how to get this and from where?? either translation function or calculated move
        int[] targetPosition = {targetX, targetY};
        game.updateBoard(playerColor, figureType, startPosition, targetPosition);


        char[][][] boardAfterMove = game.getBoard();
        System.out.println(Arrays.deepToString(boardAfterMove));
    }

}
