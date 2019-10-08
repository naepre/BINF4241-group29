import java.util.ArrayList;
import java.util.Map;
import java.util.List;

public class Move
{
    public int move(int position, int dicenumber, Object[][] board)
    {
        int targetPostion = position + dicenumber;
        int newPosition = 0;
        int square_type = (int) board[targetPostion][1];
        System.out.println("SQUARE TYPE"+square_type);
        String occupation = (String) board[targetPostion][2];
        System.out.println("OCCUPATION"+occupation);
        if (square_type != 0) {
            newPosition = move(targetPostion, square_type, board);
        }
        else if (square_type == 0 && occupation == null) {
            newPosition = targetPostion;
        }
        else {
            newPosition = 0;
        }
        return newPosition;


    }
}
