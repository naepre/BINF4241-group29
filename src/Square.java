import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Square {


    /*
    ArrayList square = new ArrayList();

    public ArrayList createSquare(){

        square.clear();

        square.add(0, 0); //square type = {0, +, -}
        square.add(1, null); //isOccupied

        return square;
    }

    */

    public Object[][] createSquare(){

        Object[][] board = new Object[][]{
                {0, 0, null},{1, 0, null},{2, 0, null},{3, 0, null},
                {4, 0, null},{6, 0, null},{7, 0, null},{0, 0, null},
                {9, 0, null},{10, 0, null},{11, 0, null},{0, 0, null}
        };

        return board;
    }

}