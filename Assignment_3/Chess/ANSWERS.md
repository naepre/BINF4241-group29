PART 1

Assignment 3

Observer (Channel): Explanation

Definition:
An observer is used to notify its subscribers, when a certain object changes its state, so that all subscribers are getting updated accordingly.
How did we implement the observer?
We decided to use an observer to observe the state of our chessboard. Whenever the chessboard changes its state – when it gets updated with the new figure position – our observer called “channel” notifies its subscribers “PrintOutToTerminal”. 
Our subscriber called “PrintOutToTerminal” then gets the new board and prints it.
In short: After each board update the game notifies the channel which further notifies its subscribers.

Game Class:
private Channel channel = new Channel();

//call notifyGameChange at the end of a turn in the main.
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
