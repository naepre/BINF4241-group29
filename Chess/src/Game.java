import java.util.HashMap;

public class Game {

    private String[][] board;

    private Rook wR1 = new Rook("wR1", "white", 0, 0);
    private Rook wR2 = new Rook("wR2","white", 0, 7);
    private Rook bR1 = new Rook("bR1","black", 7, 0);
    private Rook bR2 = new Rook("bR2","black", 7, 7);

    private Horse wH1 = new Horse("wH1","white", 0, 1);
    private Horse wH2 = new Horse("wH2","white", 0, 6);
    private Horse bH1 = new Horse("bH1","black", 7, 1);
    private Horse bH2 = new Horse("bH2","black", 7, 6);

    private Bishop wB1 = new Bishop("wB1","white", 0, 3);
    private Bishop wB2 = new Bishop("wB2","white", 0, 5);
    private Bishop bB1 = new Bishop("bB1","black", 7, 3);
    private Bishop bB2 = new Bishop("bB2","black", 7, 5);

    private Queen wQ = new Queen("wQ","white", 0, 3);
    private Queen bQ = new Queen("bQ","black", 7, 3);

    private King wK = new King("wK","white", 0, 4);
    private King bK = new King("bK","black", 7, 4);

    private Pawn wP1 = new Pawn("wP1","white", 6, 0);
    private Pawn wP2 = new Pawn("wP2","white",6, 1);
    private Pawn wP3 = new Pawn("wP3","white",6, 2);
    private Pawn wP4 = new Pawn("wP4","white",6, 3);
    private Pawn wP5 = new Pawn("wP5","white",6, 4);
    private Pawn wP6 = new Pawn("wP6","white",6, 5);
    private Pawn wP7 = new Pawn("wP7","white",6, 6);
    private Pawn wP8 = new Pawn("wP8","white",6, 7);

    private Pawn bP1 = new Pawn("bP1","black",1, 0);
    private Pawn bP2 = new Pawn("bP2","black",1, 1);
    private Pawn bP3 = new Pawn("bP3","black",1,2);
    private Pawn bP4 = new Pawn("bP4","black",1, 3);
    private Pawn bP5 = new Pawn("bP5","black",1, 4);
    private Pawn bP6 = new Pawn("bP6","black",1, 5);
    private Pawn bP7 = new Pawn("bP7","black",1,6);
    private Pawn bP8 = new Pawn("bP8","black",1, 7);



    public Game(){
         board = new String[][]
                {
                        {wR1.getName(), wR1.getColor()},{wH1.getName(), wH1.getColor()},{wB1.getName(), wB1.getColor()},{wQ.getName(), wQ.getColor()},{wK.getName(), wK.getColor()},{wB2.getName(), wB2.getColor()},{wH2.getName(), wH2.getColor()},{wR2.getName(), wR2.getColor()},
                        {bP1.getName(), bP1.getColor()},{bP2.getName(), bP2.getColor()},{bP3.getName(), bP3.getColor()},{bP4.getName(), bP4.getColor()},{bP5.getName(),bP5.getColor()},{bP6.getName(), bP6.getColor()},{bP7.getName(), bP7.getColor()},{bP8.getName(), bP8.getColor()},
                        {},{},{},{},{},{},{},{},
                        {},{},{},{},{},{},{},{},
                        {},{},{},{},{},{},{},{},
                        {},{},{},{},{},{},{},{},
                        {wP1.getName(), wP1.getColor()},{wP2.getName(), wP2.getColor()},{wP3.getName(), wP3.getColor()},{wP4.getName(), wP4.getColor()},{wP5.getName(), wP5.getColor()},{wP6.getName(), wP6.getColor()},{wP7.getName(), wP7.getColor()},{wP8.getName(), wP8.getColor()},
                        {bR1.getName(), bR1.getColor()},{bH1.getName(), bH1.getColor()},{bB1.getName(), bB1.getColor()},{bQ.getName(), bQ.getColor()},{bK.getName(), bK.getColor()},{bB2.getName(), bB2.getColor()},{bH2.getName(), bH2.getColor()},{bR2.getName(), bR2.getColor()}
                };

    }

    public String[][] getBoard(){
        return board;
    }

    public String getField(int row, int column){
        try {
            return board[row][column];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.print("out of bounds! "+e);
            return null;
        }
    }


}



