import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rook extends Figures{

    private char name;
    private char color;
    private int x;
    private int y;

    public Rook(char name, char color, int x, int y){
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

    public ArrayList move (int x, int y, ArrayList [][][] board)
    {
        ArrayList possibleMoves = new ArrayList<>();
        for (int i = x+1; i <= 7; i++) {
            if (board[y][i].length != 0){
                possibleMoves.add(board[y][i]);
                break;
            }

        }
        for (int i = x-1; i >= 0; i--) {
            if (board[y][i].length != 0) {
                possibleMoves.add(Arrays.deepToString(board[y][i]));
                break;
            }
        }
        for (int i = y+1; i <= 7; i++) {
            if (board[i][x].length != 0) {
                possibleMoves.add(Arrays.deepToString(board[i][x]));
                break;
            }
        }
        for (int i = y-1; i >= 0; i--) {
            if (board[i][x].length != 0) {
                possibleMoves.add(Arrays.deepToString(board[i][x]));
                break;
            }
        }
        return possibleMoves;
    }
}