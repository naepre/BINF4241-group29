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

    public List move (int x, int y, List [][] board)
    {
        ArrayList possibleMoves = new ArrayList<>();
        for (int i = x+1; i <= 7; i++) {
            if (board[y][i].isOccupied == true){
                possibleMoves.add(board[y][i]);
            }

        }
        for (int i = x-1; i >= 0; i--) {
            if (board[y][i].isOccupied == true) {
                possibleMoves.add(board[y][i]);
            }
        }
        for (int i = y+1; i <= 7; i++) {
            if (board[i][x].isOccupied == true) {
                possibleMoves.add(board[i][x]);
            }
        }
        for (int i = y-1; i >= 0; i--) {
            if (board[i][x].isOccupied == true) {
                possibleMoves.add(board[i][x]);
            }
        }
        return possibleMoves;
    }
}