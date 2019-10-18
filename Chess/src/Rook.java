import java.util.ArrayList;
import java.util.List;

public class Rook extends Figures{

    private String name;
    private String color;
    private int x;
    private int y;

    public Rook(String name, String color, int x, int y){
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

    public ArrayList move (int x, int y, List [][] board)
    {
        ArrayList possibleMoves = new ArrayList<>();
        for (int i = x+1; i <= 7; i++) {
            if (board[y][i] != null){
                possibleMoves.add(board[y][i]);
                break;
            }

        }
        for (int i = x-1; i >= 0; i--) {
            if (board[y][i] != null) {
                possibleMoves.add(board[y][i]);
                break;
            }
        }
        for (int i = y+1; i <= 7; i++) {
            if (board[i][x] != null) {
                possibleMoves.add(board[i][x]);
                break;
            }
        }
        for (int i = y-1; i >= 0; i--) {
            if (board[i][x] != null) {
                possibleMoves.add(board[i][x]);
                break;
            }
        }
        return possibleMoves;
    }
}