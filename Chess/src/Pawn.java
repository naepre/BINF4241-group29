import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pawn extends Figures {

    private char name;
    private char color;
    private int x;
    private int y;


    public Pawn(char name, char color, int x, int y){
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

    public ArrayList move(int x, int y, char[][][] board)
    {
        ArrayList possibleMoves = new ArrayList<>();

        if (board[x][y-1].length != 0) {
            possibleMoves.add(board[x][y-1]);
        }
        else if (board[x][y+1].length != 0) {
            possibleMoves.add(board[x][y+1]);
        }
        return possibleMoves;
    }

}
