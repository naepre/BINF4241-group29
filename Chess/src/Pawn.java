import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pawn extends Figures {

    private String name;
    private String color;
    private int x;
    private int y;

    public Pawn(String name, String color, int x, int y){
        this.name = name;
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public String getName(){
        return this.name;
    }

    public String getColor(){
        return this.color;
    }

    public ArrayList move(int x, int y, String[][][] board)
    {
        ArrayList possibleMoves = new ArrayList<>();

        if (board[x][y-1].length != 0)
        {
            possibleMoves.add(Arrays.deepToString(board[x][y-1]));
        }
        else if (board[x][y+1].length != 0)
        {
            possibleMoves.add(Arrays.deepToString(board[x][y+1]));
        }
        return possibleMoves;
    }

}
