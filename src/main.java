import java.util.*;

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

        HashMap<Integer, ArrayList> map = new HashMap();
        List MyList = new ArrayList();
        MyList.add(0);
        MyList.add("null");
        List MyList2 = new ArrayList(); //snake
        MyList2.add(-3);
        MyList2.add("null");
        List MyList3 = new ArrayList(); //occupied list
        MyList3.add(0);
        MyList3.add("sali");
        MyList3.add("brudi");
        MyList3.add("junge");

        List MyList4 = new ArrayList(); //ladder
        MyList4.add(2);
        MyList4.add("null");

//        System.out.println(MyList3);

        MyList3.remove(1);

  //      System.out.println(MyList3);

        map.put(1, (ArrayList) MyList3);
        map.put(2, (ArrayList) MyList);
        map.put(3, (ArrayList) MyList);
        map.put(4, (ArrayList) MyList);
        map.put(5, (ArrayList) MyList4);
        map.put(6, (ArrayList) MyList);
        map.put(7, (ArrayList) MyList);
        map.put(8, (ArrayList) MyList);

        //System.out.println(map);

        Move mov = new Move();
        Game tryout = new Game();

        System.out.println(tryout.positioner(1, mov.move(1, 2, map), "sali", map));
        System.out.println(tryout.positioner(1, mov.move(1, 4, map), "sali", map));

        /*
        System.out.println(mov.move(1, 2, map)); // output = 3
        System.out.println(mov.move(2, 4, map)); // output = 3
        System.out.println(mov.move(2, 3, map)); // output = 7
        System.out.println(mov.move(3, 1, map)); // output = 1
        System.out.println(mov.move(5, 3, map)); // output = 8

        */


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

