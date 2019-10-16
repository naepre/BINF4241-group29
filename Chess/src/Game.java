import java.util.List;

public class Game {

    private static final int COLUMNS = 8;
    private static final int ROWS = 8;

    private List[][] board = new List[ROWS][COLUMNS];

    private Rook wR1 = new Rook("white", 0, 0);
    private Rook wR2 = new Rook("white", 0, 7);
    private Rook bR3 = new Rook("black", 7, 0);
    private Rook bR4 = new Rook("black", 7, 7);

    private Horse wH1 = new Horse("white", 0, 1);
    private Horse wH2 = new Horse("white", 0, 6);
    private Horse bH3 = new Horse("black", 7, 1);
    private Horse bH4 = new Horse("black", 7, 6);

    private Bishop wB1 = new Bishop("white", 0, 3);
    private Bishop wB2 = new Bishop("white", 0, 5);
    private Bishop bB3 = new Bishop("black", 7, 3);
    private Bishop bB4 = new Bishop("black", 7, 5);

    private Queen wQ1 = new Queen("white", 0, 3);
    private Queen bQ2 = new Queen("black", 7, 3);

    private King wK1 = new King("white", 0, 4);
    private King bK2 = new King("black", 7, 4);

    //PAWNS

    public void setField(int row, int column, List figureTuple){
        board[row][column] = figureTuple;
    }

    private List getField(int row, int column){
        try {
            return board[row][column];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.print("out of bounds! "+e);
            return null;
        }
    } 

}



