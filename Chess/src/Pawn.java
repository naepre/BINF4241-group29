import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pawn extends Figures {

    private char name;
    private char color;
    private int x;
    private int y;


    public Pawn(char name, char color, int x, int y) {
        this.name = name;
        this.color = color;
        this.x = x;
        this.y = y;

    }

    public char getName() {
        return this.name;
    }

    public char getColor() {
        return this.color;
    }

    public ArrayList move(int x, int y, char[][][] board) {
        ArrayList possibleMoves = new ArrayList<>();

        if (board[y - 1][x].length != 0) {

            char[] cellData = board[y-1][x];
            int[] figPos = {y-1, x};
            Object[] cell = {board[y-1][x], figPos};
            //System.out.println(cell);

            possibleMoves.add(cell);

        }
        if (board[y + 1][x].length != 0) {
            possibleMoves.add(board[y + 1][x]);
        }
        if (y == 3 && board[y - 1][x].length == 0 && board[y - 2][x].length != 0) { //a black pawn start two space move
            possibleMoves.add(board[y + 2][x]);
        }
        if (y == 4 && board[y + 1][x].length == 0 && board[y + 2][x].length != 0) { //a white pawn start two space move
            possibleMoves.add(board[y + 2][x]);
        }
        return possibleMoves;
    }
}

