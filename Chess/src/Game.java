import java.util.HashMap;

public class Game {

    private String[][] board;

    private Rook wR1 = new Rook("R", "b", 0, 0);
    private Rook wR2 = new Rook("R","b", 0, 7);
    private Rook bR1 = new Rook("R","w", 7, 0);
    private Rook bR2 = new Rook("R","w", 7, 7);

    private Horse wH1 = new Horse("N","b", 0, 1);
    private Horse wH2 = new Horse("N","b", 0, 6);
    private Horse bH1 = new Horse("N","w", 7, 1);
    private Horse bH2 = new Horse("N","w", 7, 6);

    private Bishop wB1 = new Bishop("B","b", 0, 3);
    private Bishop wB2 = new Bishop("B","b", 0, 5);
    private Bishop bB1 = new Bishop("B","w", 7, 3);
    private Bishop bB2 = new Bishop("B","w", 7, 5);

    private Queen wQ = new Queen("Q","b", 0, 3);
    private Queen bQ = new Queen("Q","w", 7, 3);

    private King wK = new King("K","b", 0, 4);
    private King bK = new King("K","w", 7, 4);

    private Pawn wP1 = new Pawn("p","w", 6, 0);
    private Pawn wP2 = new Pawn("p","w",6, 1);
    private Pawn wP3 = new Pawn("p","w",6, 2);
    private Pawn wP4 = new Pawn("p","w",6, 3);
    private Pawn wP5 = new Pawn("p","w",6, 4);
    private Pawn wP6 = new Pawn("p","w",6, 5);
    private Pawn wP7 = new Pawn("p","w",6, 6);
    private Pawn wP8 = new Pawn("p","w",6, 7);

    private Pawn bP1 = new Pawn("p","b",1, 0);
    private Pawn bP2 = new Pawn("p","b",1, 1);
    private Pawn bP3 = new Pawn("p","b",1,2);
    private Pawn bP4 = new Pawn("p","b",1, 3);
    private Pawn bP5 = new Pawn("p","b",1, 4);
    private Pawn bP6 = new Pawn("p","b",1, 5);
    private Pawn bP7 = new Pawn("p","b",1,6);
    private Pawn bP8 = new Pawn("p","b",1, 7);



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




    private void validateMove (char playerColor, char figureType, char x, char y){

        if(figureType == 'K'){
            King king = new King("genericKing", "genericColor", 10, 10);
            //king.move(x, y, board);
        }else if(figureType == 'Q'){
            Queen queen = new Queen("genericQueen", "genericColor", 10, 10);
            queen.move(x, y, board);
        }else if(figureType == 'B'){
            Bishop bishop = new Bishop("genericBishop", "genericColor", 10, 10);
            bishop.move(x, y, board);
        }else if(figureType == 'N'){
            Horse horse = new Horse("genericHorse", "genericColor", 10, 10);
            //horse.move(x, y, board);
        }else if(figureType == 'R'){
            Rook rook = new Rook("genericRook", "genericColor", 10, 10);
            //rook.move(x, y, board);
        } else if(figureType == 'p'){
            Pawn pawn = new Pawn("genericPawn", "genericColor", 10, 10);
            //pawn.move(x, y, board);
        }
    }

    


}




