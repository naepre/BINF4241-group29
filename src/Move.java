import java.util.HashMap;
import java.util.List;

public class Move {

    public int move(int position, int dicenumber, String playername, HashMap board) {
        int index = position + dicenumber;
        int new_position = 0;
        List square = (List) board.get(index);
        List start_square = (List) board.get(0);
        int square_type = (int) square.get(0);
        String occupation = (String) square.get(1);
        if (square_type != 0) {
            move(index, square_type, playername, board);
        }
        else if (square_type == 0 && occupation == "null") {
            square.add(1, playername);
            board.replace(index, square);
            new_position = index;
        }
        else {
            start_square.add(playername);
            board.replace(0, start_square);
        }
        return new_position;
    }
}
