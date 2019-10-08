import java.util.ArrayList;
import java.util.Map;
import java.util.List;

public class Move {

    public int move(int position, int dicenumber, String playername, Map board) {
        Game game = new Game();
        int index = position + dicenumber;
        int new_position = 1;
        List square = new ArrayList();
        square = (List) board.get(index);
        List start_square = new ArrayList();
        start_square = (List) board.get(1);
        int square_type = (int) square.get(0);
        String occupation = (String) square.get(1);
//        System.out.println(square_type);
        //      System.out.println(occupation);
        if (square_type != 0) {
            move(index, square_type, playername, board);
        }
        else if (square_type == 0 && occupation == "null") {
            new_position = index;
        }
        else {
        }
        return new_position;

    }

}
