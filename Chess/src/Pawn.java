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

    public ArrayList move(int x, int y, char playercolor, int movetype, char[][][] board) {
        ArrayList possibleMoves = new ArrayList<>();

        if (movetype == 0) {

            if (playercolor == 'b') {
                if (board[y - 1][x].length != 0) {

                    int[] figPos = {y - 1, x};
                    Object[] cell = {board[y - 1][x], figPos};
                    possibleMoves.add(cell);

                }
                if (y == 3 && board[y - 1][x].length == 0 && board[y - 2][x].length != 0) { //a black pawn start two space move
                    int[] figPos = {y - 2, x};
                    Object[] cell = {board[y - 2][x], figPos};
                    possibleMoves.add(cell);
                }
            }
            if (playercolor == 'w') {
                if (board[y + 1][x].length != 0) {

                    int[] figPos = {y + 1, x};
                    Object[] cell = {board[y + 1][x], figPos};
                    possibleMoves.add(cell);
                }

                if (y == 4 && board[y + 1][x].length == 0 && board[y + 2][x].length != 0) { //a white pawn start two space move
                    int[] figPos = {y + 2, x};
                    Object[] cell = {board[y + 2][x], figPos};
                    possibleMoves.add(cell);
                }
            }
        } else {
            if (playercolor == 'b') {
                if (board[y - 1][x - 1].length != 0) {
                    int[] figPos = {y - 1, x - 1};
                    Object[] cell = {board[y - 1][x - 1], figPos};
                    possibleMoves.add(cell);
                }
                if (board[y - 1][x + 1].length != 0) {
                    int[] figPos = {y - 1, x + 1};
                    Object[] cell = {board[y - 1][x + 1], figPos};
                    possibleMoves.add(cell);
                }
            } else if (playercolor == 'w') {
                if (board[y + 1][x - 1].length != 0) {
                    int[] figPos = {y + 1, x - 1};
                    Object[] cell = {board[y + 1][x - 1], figPos};
                    possibleMoves.add(cell);
                }
                if (board[y + 1][x + 1].length != 0) {
                    int[] figPos = {y + 1, x + 1};
                    Object[] cell = {board[y + 1][x + 1], figPos};
                    possibleMoves.add(cell);
                }
            }

            return possibleMoves;
        }
    }
}

