import java.util.Arrays;

public class add {
    public String test() {
        main ob = new main();
        Dice di = new Dice();


        /*int position = di.roll();
        if (ob.firstarray[position][0] == "0")
        {
            ob.firstarray[position][1] = ob.player3;
        }
        else if  (ob.firstarray[position][1] == "-5")
        {
            ob.firstarray[position][1] = ob.player3;
        }
        /*else
        {
            ob.firstarray[position+2][1] = ob.player3;
        }*/
        System.out.println("Initial State: "+Arrays.deepToString(ob.firstarray));
        String ele = ob.firstarray[1][0];
        System.out.println("The element in postion is = " + ele);
        return ele;
    }
}

