import java.util.*;

public class main {
    public static void main(String[] args){

        Game game = new Game();
        Square squares = new Square();
        Player player = new Player();
        Dice dice = new Dice();
        Turn turn = new Turn();

        int numberOfPlayers = player.getPlayerCounter();
        ArrayList players = player.getPlayerNames(numberOfPlayers);
        for (Object p: players) {
            game.updatePlayersCurrentPosition((String) p, 0);
        }

        game.setPlayers(players);
        game.setCurrentTurn((String) players.get(0));

        //4. create squares
        Object[][] board = squares.createSquare();
        //set players in start position
        board[0][2] = players;
        game.setBoard(board);


        Boolean won = false;

        ArrayList<String> playOrder = game.getPlayers();
        System.out.println("PLAY ORDER: " + playOrder);

        while (won == false){
            for (int i = 0; i < playOrder.size(); i++){
                System.out.println("PLAY ORDER: " + playOrder);
                System.out.println("CURRENT PLAYER: " + playOrder.get(i));
                int playerCurrentPosition = game.getPlayersCurrentPosition(playOrder.get(i));
                Object[][] currentBoard = game.getBoard();
                System.out.println("CURRENT BOARD: " + Arrays.deepToString(currentBoard));
                int currentRoll = dice.roll();
                int newPosition = turn.move(playerCurrentPosition, currentRoll, currentBoard);
                System.out.println(newPosition);
                Object[][] newBoard = turn.updatePlayerPos(playerCurrentPosition, newPosition, playOrder.get(i), currentBoard); //playOrder removes current player from list for some reason!?!?
                System.out.println("PLAY ORDER: " + playOrder);
                System.out.println("NEW BOARD: " + Arrays.deepToString(newBoard));
            }
            won = true;
        }


/*

        Boolean won = false;

        while (won == false) {
            for (int i = 0; i < players.size(); i++){
                System.out.println(players);
                int playerCurrentPosition = game.getPlayersCurrentPosition(players.get(i));
                Object[][] currentBoard = game.getBoard();
                int currentRoll = dice.roll();
                int newPosition = turn.move(playerCurrentPosition, currentRoll, currentBoard);
                System.out.println("CURRENT PLAYER: " + players.get(i));
                System.out.println("CURRENT BOARD: " + Arrays.deepToString(currentBoard));
                System.out.println("CURRENT ROLL: " + currentRoll);
                System.out.println("NEW POSITION: " + newPosition);
                Object[][] newBoard = turn.updatePlayerPos(playerCurrentPosition, newPosition, players.get(i), currentBoard);
                System.out.println("CURRENT BOARD: " + Arrays.deepToString(newBoard));
                game.setBoard(newBoard);
                System.out.println(Arrays.deepToString(game.getBoard()));
                won = game.checkWinCondition();
                System.out.println(players);
                System.out.println(won);
            }

        }

*/




/*
        //Map to track players current position
        Map playerCurrentPositions = new HashMap();
        for (Object player: players)
        {
            playerCurrentPositions.put(player, 0);
        }
        System.out.println("CURRENT PLAYER POSITIONS"+ playerCurrentPositions);
*/


/*

        //GET GAME STATE:
        System.out.println("PLAYERS:"+game.players);
        //System.out.println("PLAYERS POSITIONS:"+game.getPlayersCurrentPosition());
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


        // Initializing player to the game
        currentBoard[0][2] = players;
        */


/*
        System.out.println("UPDATED BOARD with player :"+ Arrays.deepToString(game.getBoard()));

        Object x = game.updatePlayerPos(6, "bob", board);
        System.out.println(Arrays.deepToString((Object[]) x));
        System.out.println("PLAYER POSITION MAP:" + game.playersCurrentPosition);
*/



        /*
        //########SETUP END############
         Move mov = new Move();
         System.out.println(mov.move(0, 2, board)); // output = 2
         System.out.println(mov.move(0, 3, board)); // output = 0
         System.out.println(mov.move(0, 4, board)); // output = 6
         System.out.println(mov.move(5, 3, board)); // output = 5
         System.out.println(mov.move(9, 1, board)); // output = 5


         Game game1 = new Game();

         game1.updatePlayerPos(2,"bob",board);

         /*game1.playersCurrentPosition.put("bob" , 0);
         game1.playersCurrentPosition.get("bob");

         System.out.println("jajaj"+ game1.playersCurrentPosition);
         System.out.println("jajaj ="+ game1.playersCurrentPosition.get("bob"));


*/


        /* game.updatePlayerPos(5, "bob", board);*/


/*
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