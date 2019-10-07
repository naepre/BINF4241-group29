import java.util.List;
import java.util.Map;

public class Game {

    List players;
    String currentTurn;
    Map board;

    public void setPlayers(List players) {
        this.players = players;
    }

    public List getPlayers() {
        return players;
    }

    public void setCurrentTurn(String currentTurn) {
        this.currentTurn = currentTurn;
    }

    public String getCurrentTurn() {
        return currentTurn;
    }

    public void setBoard(Map board) {
        this.board = board;
    }

    public Map getBoard() {
        return board;
    }

}