import java.util.*;
import java.util.Scanner;

public class main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();
        Square squares = new Square();
        Player player = new Player();
        Dice dice = new Dice();
        Turn turn = new Turn();

        // Player position

        int numberOfPlayers = player.getPlayerCounter();
        ArrayList players = player.getPlayerNames(numberOfPlayers);
        for (Object p: players) {
            game.updatePlayersCurrentPosition((String) p, 0);
        }

        // 3.Setting Players turn
        game.setPlayers(players);
        game.setCurrentTurn((String) players.get(0));

        //4. create board
        Object[][] board = squares.createSquare();

        //5.set players in start position
        ArrayList<String> copyPlayer = (ArrayList<String>) players.clone();
        board[0][2] = copyPlayer;
        game.setBoard(board);

        //6. Game Flow
        Boolean won = false;
        ArrayList<String> playOrder = game.getPlayers();
        //Displaying Starting board State
        System.out.println("Initial board: " + Arrays.deepToString(board));
        System.out.println("\n");
        System.out.println("***********************************************************************************************************************************************************************************************");
        while (won == false)
        {
            for (int i = 0; i < playOrder.size(); i++)
            {
                int playerCurrentPosition = game.getPlayersCurrentPosition(playOrder.get(i));
                System.out.println("\n");
                System.out.println("Player Turn: " + playOrder.get(i));
                Object[][] currentBoard = game.getBoard();
                int currentRoll = dice.roll();
                int newPosition = turn.move(playerCurrentPosition, currentRoll, currentBoard);
                System.out.println("------Press enter to roll dice------" );
                scanner.nextLine();
                System.out.println("dice roll :"+currentRoll);
                Object[][] newBoard = turn.updatePlayerPos(playerCurrentPosition, newPosition, playOrder.get(i), currentBoard);
                System.out.println("GAME State " + Arrays.deepToString(newBoard));
                game.updatePlayersCurrentPosition(playOrder.get(i), newPosition);
                won = game.checkWinCondition();
                if ( won == true )
                {
                    break;
                }
            }
        }
        System.out.println("\n");
        System.out.println(" *************** Player "+ board[12][2] + " has won ***************");
    }

}

