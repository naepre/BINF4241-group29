import java.util.ArrayList;
import java.util.List;

public class Square {

    List square = new ArrayList();

    public List createSquare(){

        square.clear();

        square.add(0, 0); //square type = {0, +, -}
        square.add(1, null); //isOccupied

        return square;
    }

}