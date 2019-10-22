import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Horse extends Figures{

    private char name;
    private char color;
    private int x;
    private int y;


    public Horse(char name, char color, int x, int y){
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


    public ArrayList move (int x, int y, char[][][] board) { //.length != 0)

        ArrayList possibleMoves = new ArrayList<>();

        if (y >= 1 && x <= 5 && board[y-1][x+2].length != 0){

            int[] figPos = {y-1, x+2};
            Object[] cell = {board[y-1][x+2], figPos};
            possibleMoves.add(cell);

        }
        if (y <= 6 && x <= 5 && board[y+1][x+2].length != 0){

            int[] figPos = {y+1, x+2};
            Object[] cell = {board[y+1][x+2], figPos};
            possibleMoves.add(cell);

            //possibleMoves.add(board[y+1][x+2]);
        }
        if (y >= 1 &&  x >= 2 && board[y-1][x-2].length != 0){ //0-2 is out of bounds

            int[] figPos = {y-1, x-2};
            Object[] cell = {board[y-1][x-2], figPos};
            possibleMoves.add(cell);

            //possibleMoves.add(board[y-1][x-2]);
        }
        if (x >= 2 && board[y+1][x-2].length != 0){

            int[] figPos = {y+1, x-2};
            Object[] cell = {board[y+1][x-2], figPos};
            possibleMoves.add(cell);

            //possibleMoves.add(board[y+1][x-2]);
        }
        if (y <= 5 && x <= 6 && board[y+2][x+1].length != 0){

            int[] figPos = {y+2, x+1};
            Object[] cell = {board[y+2][x+1], figPos};
            possibleMoves.add(cell);

            //possibleMoves.add(board[y+2][x+1]);
        }
        if (y <= 5 && x >= 1 && board[y+2][x-1].length != 0){

            int[] figPos = {y+2, x-1};
            Object[] cell = {board[y+2][x-1], figPos};
            possibleMoves.add(cell);

            //possibleMoves.add(board[y+2][x-1]);
        }
        if (x <= 6 && y >= 2 && board[y-2][x+1].length != 0){

            int[] figPos = {y-2, x+1};
            Object[] cell = {board[y-2][x+1], figPos};
            possibleMoves.add(cell);

            //possibleMoves.add(board[y-2][x+1]);
        }
        if (y >= 2 && x >= 1 && board[y-2][x-1].length != 0){

            int[] figPos = {y-2, x-1};
            Object[] cell = {board[y-2][x-1], figPos};
            possibleMoves.add(cell);

            //possibleMoves.add(board[y-2][x-1]);
        }

        return possibleMoves;
    }
}