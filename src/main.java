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

        //Map to track players current position
        Map playerCurrentPositions = new HashMap();
        for (Object player: players) {
            playerCurrentPositions.put(player, 0);
        }
        System.out.println("CURRENT PLAYER POSITIONS"+ playerCurrentPositions);


        //4. create squares
        Square squares = new Square();
        ArrayList squareOne = squares.createSquare();
        ArrayList squareTwo = squares.createSquare();
        ArrayList squareThree = squares.createSquare();
        ArrayList squareFour = squares.createSquare();
        ArrayList squareFive = squares.createSquare();
        ArrayList squareSix = squares.createSquare();

        Map board = new HashMap();
        board.clear();
        board.put(0, squareOne);
        board.put(1, squareTwo);
        board.put(2, squareThree);
        board.put(3, squareFour);
        board.put(4, squareFive);
        board.put(5, squareSix);


        //set players into first square.
        System.out.println("BASIC BOARD: " + board);
        ArrayList firstSquare = (ArrayList) board.get(0); // [0, null]
        System.out.println("BASIC FIRST SQUARE: "+firstSquare);
        firstSquare.set(1, "plas"); //[0, ["player1","player2", ...]]
        //System.out.println("FIRST SQUARE: "+firstSquare);
        //board.replace(0, firstSquare);
        System.out.println(board);
        game.setBoard(board);


        /*


        //########SETUP END############

        //START (need some loop)
        Move movePlayer = new Move();
        Dice dice = new Dice();
        int diceRoll = dice.roll();
        System.out.println("DICE ROLL: "+diceRoll);
        //get players current position


        int lastMove = movePlayer.move(0, diceRoll, game.currentTurn, currentBoard);
        System.out.println(lastMove);
        playerCurrentPositions.replace(game.currentTurn, lastMove);


*/
    }
}