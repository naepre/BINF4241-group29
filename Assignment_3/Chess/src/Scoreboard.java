import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Scoreboard {

    //private ArrayList hitLists;


    public void updateHitLists(ArrayList hitLists) {

        printScoreboard(hitLists);

    }

    public static void printScoreboard(ArrayList hitLists) {


        ArrayList whiteHitList = (ArrayList) hitLists.get(0);
        ArrayList blackHitList = (ArrayList) hitLists.get(1);

        int whiteScore = 0;
        for(int i=0; i< whiteHitList.size();i++){
            char eaten = (char) whiteHitList.get(i);
            if(eaten == 'Q'){
                whiteScore += 5;
            }else{
                whiteScore += 1;
            }
        }

        int blackScore = 0;
        for(int i=0; i< blackHitList.size();i++){
            char eaten = (char) blackHitList.get(i);
            if(eaten == 'Q'){
                blackScore += 5;
            }else{
                blackScore += 1;
            }
        }

        System.out.println(" \t__________________________SCOREBOARD___________________________");
        System.out.println(" \t White, score: "+ whiteScore + " - Black, score: "+ blackScore);
        System.out.println(" \t_______________________________________________________________");

    }
}
