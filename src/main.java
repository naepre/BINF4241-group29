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
        Map board = new HashMap();
        for(int i=0;i<12;i++){
            board.put(i, squares.createSquare());
        }

        game.setBoard(board);
        Map currentBoard = game.getBoard();

        ArrayList firstSquare = (ArrayList) currentBoard.get(0);
        firstSquare.set(1, players);
        currentBoard.replace(0, firstSquare);

        System.out.println(currentBoard);
    }
}