import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Horse extends Figures{

    private String name;
    private String color;
    private int x;
    private int y;

    public Horse(String name, String color, int x, int y){
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

    public ArrayList move (int x, int y, String [][][] board) { //.length != 0)
        ArrayList possibleMoves = new ArrayList<>();
        if (board[y-1][x+2].length != 0){
            possibleMoves.add(Arrays.deepToString(board[y-1][x+2]));
        }
        if (board[y+1][x+2].length != 0){
            possibleMoves.add(Arrays.deepToString(board[y+1][x+2]));
        }
        if (board[y-1][x-2].length != 0){
            possibleMoves.add(Arrays.deepToString(board[y-1][x-2]));
        }
        if (board[y+1][x-2].length != 0){
            possibleMoves.add(Arrays.deepToString(board[y+1][x-2]));
        }
        if (board[y+2][x+1].length != 0){
            possibleMoves.add(Arrays.deepToString(board[y+2][x+1]));
        }
        if (board[y+2][x-1].length != 0){
            possibleMoves.add(Arrays.deepToString(board[y+2][x-1]));
        }
        if (board[y-2][x+1].length != 0){
            possibleMoves.add(Arrays.deepToString(board[y-2][x+1]));
        }
        if (board[y-2][x-1].length != 0){
            possibleMoves.add(Arrays.deepToString(board[y-2][x-1]));
        }
        //System.out.println(possibleMoves);
        return possibleMoves;
    }
}