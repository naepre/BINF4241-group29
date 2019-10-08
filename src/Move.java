import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Move {

    public int move(int position, int dicenumber, HashMap board) {
        Game game = new Game();
        int index = position + dicenumber;
        int new_position = 0;
        List square = new ArrayList();
        square = (List) board.get(index);
        int square_type = (int) square.get(0);
        String occupation = (String) square.get(1);
        if (square_type != 0) {
            new_position = move(index, square_type, board);
        }
        else if (square_type == 0 && occupation == "null") {
            new_position = index;
        }
        else {
            new_position = 1;
        }
//        System.out.println(new_position);
        return new_position;


    }
}
