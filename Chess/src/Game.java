import java.util.ArrayList;
import java.util.List;

public class Game {

    //private static final int COLUMNS = 8;
    //private static final int ROWS = 8;

    public Object[][] board; //= new Object[ROWS][COLUMNS];

    private Rook wR1 = new Rook("white", 0, 0);
    private Rook wR2 = new Rook("white", 0, 7);
    private Rook bR1 = new Rook("black", 7, 0);
    private Rook bR2 = new Rook("black", 7, 7);

    private Horse wH1 = new Horse("white", 0, 1);
    private Horse wH2 = new Horse("white", 0, 6);
    private Horse bH1 = new Horse("black", 7, 1);
    private Horse bH2 = new Horse("black", 7, 6);

    private Bishop wB1 = new Bishop("white", 0, 3);
    private Bishop wB2 = new Bishop("white", 0, 5);
    private Bishop bB1 = new Bishop("black", 7, 3);
    private Bishop bB2 = new Bishop("black", 7, 5);

    private Queen wQ = new Queen("white", 0, 3);
    private Queen bQ = new Queen("black", 7, 3);

    private King wK = new King("white", 0, 4);
    private King bK = new King("black", 7, 4);

    //PORNS


    public Game(){
         board = new Object[][]
                {
                        {wR1},{wH1},{wB1},{wQ},{wK},{wB2},{wH2},{wR2},
                        {},{},{},{},{},{},{},{},
                        {},{},{},{},{},{},{},{},
                        {},{},{},{},{},{},{},{},
                        {},{},{},{},{},{},{},{},
                        {},{},{},{},{},{},{},{},
                        {},{},{},{},{},{},{},{},
                        {bR1},{bH1},{bB1},{bQ},{bK},{bB2},{bH2},{bR2}
                };

    }



    public Object getField(int row, int column){
        try {
            return board[row][column];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.print("out of bounds! "+e);
            return null;
        }
    }


}



