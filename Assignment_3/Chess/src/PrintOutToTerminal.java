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

