import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//import static jdk.nashorn.internal.objects.NativeMap.size;

public class Game {

    List players;
    String currentTurn;
    List board;
    int turn_tracker = 0;

    public HashMap positioner(int turn_start_position,int turn_end_position, String playername, HashMap board) {
        HashMap newboard = new HashMap();
        newboard = board;
        List old_position = new ArrayList();
        List new_position = new ArrayList();
        if (turn_end_position != 1) {
            new_position.add(0, 0);
            new_position.add(1, playername);
        }
        else {
            new_position = (List) board.get(turn_end_position);
            new_position.add(playername);
        }
        old_position = (List) board.get(turn_start_position);
        old_position.add(1, "null");
        newboard.put(turn_start_position, old_position);
        newboard.put(turn_end_position, new_position);
        return newboard;
    }

/*    int number_of_players = size(players);
    public String next_turn(int numbers_of_turns) {
        int turn_of_player = 0;
        turn_of_player = numbers_of_turns % number_of_players;
        String playername = players.get(turn_of_player);
        return playername;

    public void check_winner() {
        }
    } */

}