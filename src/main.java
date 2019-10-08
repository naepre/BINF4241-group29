import java.util.*;

public class main {
    public static void main(String[] args){


        Scanner keyboard = new Scanner(System.in);
        Game game = new Game();

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
            game.updatePlayersCurrentPosition(name, 0);
        }

        //3. set players to game object
        game.setPlayers(players);
        game.setCurrentTurn((String) players.get(0));



        //4. create squares
        Square squares = new Square();
        Object[][] board = squares.createSquare();
        //set players in start position
        board[0][2] = players;

        game.setBoard(board);


        //GET GAME STATE:
        System.out.println("PLAYERS:"+game.players);
        System.out.println("PLAYERS POSITIONS:"+game.getPlayersCurrentPosition());
        System.out.println("CURRENT TURN:"+game.currentTurn);





        //##EXAMPLE BOARD MANIPULATION OF 2D ARRAY###
        //API to manipulate game board
        Object[][] currentBoard = game.getBoard();
        System.out.println("CURRENT BOARD:"+ Arrays.deepToString(game.getBoard()));
        //read an element:
        System.out.println("START SQUARE: "+currentBoard[0][2]);
        //modify an element
        currentBoard[3][2] = "some new player name";
        game.setBoard(currentBoard);
        System.out.println("UPDATED BOARD:"+ Arrays.deepToString(game.getBoard()));
        //##EXAMPLE BOARD MANIPULATION OF 2D ARRAY###



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