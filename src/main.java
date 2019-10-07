import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main
{
    String [][] firstarray = new String[][] {{"1"},{"2->6"},{"3"},{"4"},
            {"5"},{"6"},{"7->9"},{"8"},{"9"},{"10"},{"5<-11"},{"12"}};

    String player3 = "robin";
    //firstarray[0][1] = player3;
    public static void main(String[] args)
    {
        main obj = new main();

        /*Player myPlayer1 = new Player();
        Player myPlayer2 = new Player();
        myPlayer1.setPlayerName("Bob");
        myPlayer2.setPlayerName("Lucy");
        System.out.println(myPlayer1.getPlayerName());
        System.out.println(myPlayer2.getPlayerName());*/

        Dice myDice = new Dice();
        System.out.println(myDice.roll());

        System.out.println("This is the first array");


       /* //create a square
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

        List<List> board = new ArrayList();
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

        /*list ele = board.get();
        System.out.println();*/
        /*squareOne.add(myPlayer);*/

        /*System.out.println(board);*/



    }


}

