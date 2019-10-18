import java.util.HashMap;
import java.util.List;

public class Game {

    private String[][] board;
    private HashMap<String, Object> nameMap = new HashMap<>();
    private HashMap<String, Object> objectNameMap = new HashMap<>();

    private Rook genericRook = new Rook(null, null, 10, 10);


    public Rook wR1 = new Rook("wR1", "white", 0, 0);
    private Rook wR2 = new Rook("wR2","white", 0, 7);
    private Rook bR1 = new Rook("bR1","black", 7, 0);
    private Rook bR2 = new Rook("bR2","black", 7, 7);

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

    private Pawn wP1 = new Pawn("white", 6, 0);
    private Pawn wP2 = new Pawn("white",6, 1);
    private Pawn wP3 = new Pawn("white",6, 2);
    private Pawn wP4 = new Pawn("white",6, 3);
    private Pawn wP5 = new Pawn("white",6, 4);
    private Pawn wP6 = new Pawn("white",6, 5);
    private Pawn wP7 = new Pawn("white",6, 6);
    private Pawn wP8 = new Pawn("white",6, 7);

    private Pawn bP1 = new Pawn("black",1, 0);
    private Pawn bP2 = new Pawn("black",1, 1);
    private Pawn bP3 = new Pawn("black",1,2);
    private Pawn bP4 = new Pawn("black",1, 3);
    private Pawn bP5 = new Pawn("black",1, 4);
    private Pawn bP6 = new Pawn("black",1, 5);
    private Pawn bP7 = new Pawn("black",1,6);
    private Pawn bP8 = new Pawn("black",1, 7);



    public Game(){
        /*
         board = new Object[][]
                {
                        {wR1},{wH1},{wB1},{wQ},{wK},{wB2},{wH2},{wR2},
                        {bP1},{bP2},{bP3},{bP4},{bP5},{bP6},{bP7},{bP8},
                        {},{},{},{},{},{},{},{},
                        {},{},{},{},{},{},{},{},
                        {},{},{},{},{},{},{},{},
                        {},{},{},{},{},{},{},{},
                        {wP1},{wP2},{wP3},{wP4},{wP5},{wP6},{wP7},{wP8},
                        {bR1},{bH1},{bB1},{bQ},{bK},{bB2},{bH2},{bR2}
                };
        */
        board = new String[][]
                {
                        {wR1.getName()}
                };

        nameMap.put("wR1", wR1);
        objectNameMap.put("R", genericRook);
    }



    public String getField(int row, int column){
        try {
            return board[row][column];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.print("out of bounds! "+e);
            return null;
        }
    }

    public Object getFigureAtSpace(String figureName){
        return nameMap.get(figureName);
    }

    public void validateMove (char playercolor, char figuretype, char x, char y, List[][] board){

        //List reverseStartPosition = board[x][y];
        Object currentFigure = null;
        try {
            currentFigure = Class.forName(objectNameMap.get(figuretype).toString()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Queen queen = new Queen("",  0,0);
        queen.move();

        currentFigure.move();

    }
    public boolean isOccupied(int x, int y, List[][] board){
        boolean verifier;
        if (board[x][y] != null){
            verifier = false;
        }
        else {
            verifier = true;
        }
        return verifier;
    }
}