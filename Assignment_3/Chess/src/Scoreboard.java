import java.util.ArrayList;
import java.util.Arrays;

public class Scoreboard {

    private Object hitLists;


    public void updateHitLists(Object hitLists) {

        printScoreboard(hitLists);

    }

    public static void printScoreboard(ArrayList hitLists) {


        ArrayList whiteHitList = hitLists;

        System.out.println(" \t__________________________SCOREBOARD___________________________");
        System.out.println(" \t   ");
        System.out.println(hitLists);
        System.out.println(" \t_______________________________________________________________");

    }
}
