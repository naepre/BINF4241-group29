import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class King extends Figures {

    private String name;
    private String color;
    private int x;
    private int y;

    public King(String name, String color, int x, int y) {
        this.name = name;
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return this.name;
    }

    public String getColor() {
        return this.color;
    }

    public void changePosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public ArrayList move(int x, int y, String[][][] board) {
        ArrayList possibleMoves = new ArrayList<>();

        if (board[x][y - 1].length != 0) {
            possibleMoves.add(Arrays.deepToString(board[x][y - 1]));
        }
        if (board[x][y + 1].length != 0) {
            possibleMoves.add(Arrays.deepToString(board[x][y + 1]));
        }
        if (board[x + 1][y].length != 0) {
            possibleMoves.add(Arrays.deepToString(board[x + 1][y]));
        }
        if (board[x - 1][y].length != 0) {
            possibleMoves.add(Arrays.deepToString(board[x - 1][y]));
        }
        if (board[x + 1][y + 1].length != 0) {
            possibleMoves.add(Arrays.deepToString(board[x + 1][y + 1]));
        }
        if (board[x + 1][y - 1].length != 0) {
            possibleMoves.add(Arrays.deepToString(board[x + 1][y - 1]));
        }
        if (board[x - 1][y - 1].length != 0) {
            possibleMoves.add(Arrays.deepToString(board[x - 1][y - 1]));
        }
        if (board[x - 1][y + 1].length != 0) {
            possibleMoves.add(Arrays.deepToString(board[x - 1][y + 1]));
        }
        return possibleMoves;


    }
}