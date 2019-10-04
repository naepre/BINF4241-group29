import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args){



        Player myPlayer = new Player();
        myPlayer.setPlayerName("Bob");
        System.out.println(myPlayer.getPlayerName());


        Dice myDice = new Dice();
        System.out.println(myDice.roll());


        //create a square
        Square squares = new Square();

        List squareOne = squares.createSquare();
        List squareTwo = squares.createSquare();
        List squareThree = squares.createSquare();
        List squareFour = squares.createSquare();
        List squareFive = squares.createSquare();
        List squareSix = squares.createSquare();
        List squareSeven = squares.createSquare();
        List squareEight = squares.createSquare();
        List squareNine = squares.createSquare();
        List squareTen = squares.createSquare();
        List squareEleven = squares.createSquare();
        List squareTwelve = squares.createSquare();

        List board = new ArrayList();
        board.add(squareOne);
        board.add(squareTwo);
        board.add(squareThree);
        board.add(squareFour);
        board.add(squareFive);
        board.add(squareSix);
        board.add(squareSeven);
        board.add(squareEight);
        board.add(squareNine);
        board.add(squareTen);
        board.add(squareEleven);
        board.add(squareTwelve);

        System.out.println(board);


    }
}