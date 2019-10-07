import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;

public class main {
    public static void main(String[] args){

        Scanner keyboard = new Scanner(System.in);
        //Set up
        //1. get player count
        System.out.println("How many players are you [2-4]?");
        int numberOfPlayers = keyboard.nextInt();
        while(numberOfPlayers < 2 || numberOfPlayers > 4){
            System.out.println("Choose a number between 2 and 4 only.");
            numberOfPlayers = keyboard.nextInt();
        }

        //2. get player names
        List players = new ArrayList();
        for(int i=0; i<numberOfPlayers; i++){
            System.out.println("Enter a player name: ");
            String name = keyboard.next();
            players.add(name);
        }

        //3. set players to game object
        Game game = new Game();
        game.setPlayers(players);
        game.setCurrentTurn((String) players.get(0));


        //4. create squares
        Square squares = new Square();
        ArrayList squareOne = squares.createSquare();
        ArrayList squareTwo = squares.createSquare();
        ArrayList squareThree = squares.createSquare();
        ArrayList squareFour = squares.createSquare();
        ArrayList squareFive = squares.createSquare();
        ArrayList squareSix = squares.createSquare();

        Map board = new HashMap();
        board.put(0, squareOne);
        board.put(1, squareTwo);
        board.put(2, squareThree);
        board.put(3, squareFour);
        board.put(4, squareFive);

        System.out.println(board);
        game.setBoard(board);
        Map currentBoard = game.getBoard();
        System.out.println(currentBoard);


        


        /*
        Map board = new HashMap();
        for(int i=0;i<12;i++){
            board.put(i, squares.createSquare());
        }

        game.setBoard(board);
        Map currentBoard = game.getBoard();
        System.out.println(currentBoard);

        //read some square
        ArrayList currentSquare = (ArrayList) currentBoard.get(0);
        System.out.println(currentSquare);
        */

    }
}