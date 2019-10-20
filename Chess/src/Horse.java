import java.util.ArrayList;
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

    public List move (int x, int y, List [][] board) {
        ArrayList possibleMoves = new ArrayList<>();
        if (board[y-1][x+2] != null) {
            possibleMoves.add(board[y-1][x+2]);
        }
        else if (board[y+1][x+2] != null){
            possibleMoves.add(board[y+1][x+2]);
        }
        else if (board[y-1][x-2] != null){
            possibleMoves.add(board[y-1][x-2]);
        }
        else if (board[y+1][x-2] != null){
            possibleMoves.add(board[y+1][x-2]);
        }
        else if (board[y+2][x+1] != null){
            possibleMoves.add(board[y+2][x+1]);
        }
        else if (board[y+2][x-1] != null){
            possibleMoves.add(board[y+2][x-1]);
        }
        else if (board[y-2][x+1] != null){
            possibleMoves.add(board[y-21][x+1]);
        }
        else if (board[y-2][x+1] != null){
            possibleMoves.add(board[y-2][x+1]);
        }
        return possibleMoves;
    }
}
