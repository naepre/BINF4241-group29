To make a move you have to input any move in the algebraic notation.

Specify the piecetype you are moving with its first letter in capital! (B = Bishop, K = King, Q = Queen, N = Knight, R = Rook, p = no name input)
Specify the targeted field, where you want to move to with writing the letters from 'a - h' for the columns and '1 - 8' for the rows. (The chessfield is labeled accordingly.)
For eating a piece please put in an 'x' before the specification of the targeted field. (Otherwise you are not allowed to do that.)
You input should contain 2 to 4 characters depending on the piecetype and movetype you want to move.


PART 1

Observer (Channel): Explanation

Definition:
An observer is used to notify its subscribers, when a certain object changes its state, so that all subscribers are getting updated accordingly.
How did we implement the observer?
We decided to use an observer to observe the state of our chessboard. Whenever the chessboard changes its state – when it gets updated with the new figure position – our observer called “channel” notifies its subscribers “PrintOutToTerminal”. 
Our subscriber called “PrintOutToTerminal” then gets the new board and prints it.
In short: After each board update the game notifies the channel which further notifies its subscribers.

Game Class:
private Channel channel = new Channel();

public void notifyGameChange(){
    channel.updateBoard(getBoard());
    channel.updateHitLists(getHitList());
}

Channel Class:

public class Channel {

    PrintOutToTerminal printOutToTerminal = new PrintOutToTerminal();

    //private Object game;
    private char[][][] board;
    private Object hitLists;

    public void updateBoard(char[][][] board){
        this.board = board;
        printOutToTerminal.updateBoard(board);
    }

    public void updateHitLists(Object hitLists){
        this.hitLists = hitLists;
        //printOutScoreBoard.updateHitLists(hitLists);
    }

}



PrintOutToTerminal Class:

import java.util.ArrayList;
import java.util.Arrays;

public class PrintOutToTerminal{

    private static char[][][] board;
    private Object hitLists;

    public void updateBoard(char[][][] board){
        this.board = board;
        printboard();
    }




    public static void printboard() {

        char[][] prntboard;

        System.out.println();
        System.out.println(" \t   a       b       c       d       e       f       g       h");
        System.out.println(" \t_______________________________________________________________");

        for (int p = 0; p < 8; p++)
        {
            for ( int j = 0; j < 1; j++)
            {
                prntboard = board[p];
                System.out.print(8-p+"\t");
                System.out.print(Arrays.deepToString(prntboard));
            }
            System.out.println();
        }

        System.out.println();
    }


}

Why did we choose to implement an observer?
We chose this type of design pattern for several reasons. 
1.	We already had a similar structure to this concept, so it is easy to implement.
2.	With this observer we can decrease the size of our main which had too many jobs and thus improving its structure.
3.	We may just have one subscriber for our observer right now, so one could argue it is a useless intermediate object, but this observer can be very useful for implementing other objects which need the updated board. I. e. If we wanted to implement a proper checkmate object we can also subscribe it to our channel to get the current state of the board and then look for a checkmate on it.


Singleton: Explanation

Definition:
The Singleton Pattern ensures a class has only one instance, and provides a global point of access to it. 

How did we implement the singleton?
We created a private static game object called uniqueGame and then we created a public static synchronized function call getInstance(), which gives us a new game if uniqueGame is null or hands us back the actual uniqueGame.

//Unique game instance private variable
private static Game uniqueGame;

//single entry point to unique game instance
public static synchronized Game getInstance(){
    if(uniqueGame == null){
        uniqueGame = new Game();
    }
    return uniqueGame;
}

Why did we choose to implement an observer?
We chose this type of design pattern for several reasons. 
1.	We already had a similar structure to this concept, so it is easy to implement.
2.	We chose to make our game a singleton, since you only want to have one game running at the time. With a singleton we can ensure that there won’t be any second or third game initiated during the runtime of our program. 




PART 2




PART 3
We decided to implement an observer pattern scoreboard as that easily extends from what we already can do. Specifically, we implemented a class called Scoreboard that subscribes to the observer and receives updated hit lists for both white and black players. For each hit list, we iterate, identifying eaten pieces and increment a score integer accordingly. Finally, the scores are printed.
Hint: To quickly test this implementation try the following sequence of moves:
White begins:
1. e4
2. e5
3. Qf3
4. f6
5. Qxf6
6. xf6
