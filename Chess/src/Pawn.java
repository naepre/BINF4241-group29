import java.util.ArrayList;

public class Pawn extends Figures {

    private char name;
    private char color;
    private int x;
    private int y;


    public Pawn(char name, char color, int x, int y) {
        this.name = name;
        this.color = color;
        this.x = x;
        this.y = y;

    }

    public char getName() {
        return this.name;
    }

    public char getColor() {
        return this.color;
    }

    public ArrayList move(int x, int y, int moveType, char playercolor, char[][][] board)
    {
        ArrayList possibleMoves = new ArrayList<>();
        if (moveType == 0) {

            if (playercolor == 'b') {
                if (y > 0 && board[y - 1][x][0] != ' ') {
                    int[] figPos = {y - 1, x};
                    Object[] cell = {board[y - 1][x], figPos};
                    possibleMoves.add(cell);
                }
                if (y == 3 && board[y - 1][x][0] != ' ' && board[y - 2][x][0] != ' ') { //a black pawn start two space move
                    int[] figPos = {y - 2, x};
                    Object[] cell = {board[y - 2][x], figPos};
                    possibleMoves.add(cell);
                }
            }
            if (playercolor == 'w') {
                if (y < 7 && board[y + 1][x][0] != ' ') {
                    int[] figPos = {y + 1, x};
                    Object[] cell = {board[y + 1][x], figPos};
                    possibleMoves.add(cell);
                }

                if (y == 4 && board[y + 1][x][0] != ' ' && board[y + 2][x][0] != ' ') { //a white pawn start two space move
                    int[] figPos = {y + 2, x};
                    Object[] cell = {board[y + 2][x], figPos};
                    possibleMoves.add(cell);
                }
            }
        }

        else {
            if (playercolor == 'b') {
                if (x > 0 && y > 0 && board[y - 1][x - 1][0] != ' ') {
                    int[] figPos = {y - 1, x - 1};
                    Object[] cell = {board[y - 1][x - 1], figPos};
                    possibleMoves.add(cell);
                }
                if (x <= 6 && y > 0 && board[y - 1][x + 1][0] != ' ') {
                    int[] figPos = {y - 1, x + 1};
                    Object[] cell = {board[y - 1][x + 1], figPos};
                    possibleMoves.add(cell);
                }
            }
            if (playercolor == 'w') {
                if (x > 0 && y <= 6 && board[y + 1][x - 1][0] != ' ') {
                    int[] figPos = {y + 1, x - 1};
                    Object[] cell = {board[y + 1][x - 1], figPos};
                    possibleMoves.add(cell);
                }
                if (x <= 6 && y <= 6 && board[y + 1][x + 1][0] != ' ') {
                    int[] figPos = {y + 1, x + 1};
                    Object[] cell = {board[y + 1][x + 1], figPos};
                    possibleMoves.add(cell);
                }
            }
        }



        return possibleMoves;
    }
}

