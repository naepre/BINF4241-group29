import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class King extends Figures {

    private char name;
    private char color;
    private int x;
    private int y;


    public King(char name, char color, int x, int y){
        this.name = name;
        this.color = color;
        this.x = x;
        this.y = y;

    }

    public char getName(){
        return this.name;
    }

    public char getColor(){
        return this.color;
    }


    public void changePosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public ArrayList move(int x, int y, char[][][] board) {
        ArrayList possibleMoves = new ArrayList<>();

        if (y > 0 && board[y-1][x].length != 0) {

            int[] figPos = {y-1, x};
            Object[] cell = {board[y-1][x], figPos};
            possibleMoves.add(cell);
        }
        if (y < 7 && board[y+1][x].length != 0) {
            int[] figPos = {y+1, x};
            Object[] cell = {board[y+1][x], figPos};
            possibleMoves.add(cell);

        }
        if (x < 7 && board[y][x+1].length != 0) {
            int[] figPos = {y, x+1};
            Object[] cell = {board[y][x+1], figPos};
            possibleMoves.add(cell);
        }
        if (x > 0 && board[y][x-1].length != 0) {
            int[] figPos = {y, x-1};
            Object[] cell = {board[y][x-1], figPos};
            possibleMoves.add(cell);
        }
        if (y < 7 && x < 7 && board[y + 1][x + 1].length != 0) {
            int[] figPos = {y+1, x+1};
            Object[] cell = {board[y+1][x+1], figPos};
            possibleMoves.add(cell);
        }
        if (x < 7 && y > 0 && board[y - 1][x + 1].length != 0) {
            int[] figPos = {y-1, x+1};
            Object[] cell = {board[y -1][x+1], figPos};
            possibleMoves.add(cell);
        }
        if (x > 0 && y > 0 && board[y - 1][x - 1].length != 0) {
            int[] figPos = {y-1, x-1};
            Object[] cell = {board[y-1][x-1], figPos};
            possibleMoves.add(cell);
        }
        if (x > 0 && y < 7 && board[y + 1][x - 1].length != 0) {
            int[] figPos = {y+1, x-1};
            Object[] cell = {board[y+1][x-1], figPos};
            possibleMoves.add(cell);
        }
        return possibleMoves;


    }
}