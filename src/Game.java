import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {

    List players;
    Map playersCurrentPosition = new HashMap();
    String currentTurn;
    Object[][] board;

    public void setPlayers(List players) {
        this.players = players;
    }

    public List getPlayers() {
        return players;
    }

    public void updatePlayersCurrentPosition(String playerName, int newPosition){
        playersCurrentPosition.put(playerName, newPosition);
    }

    public Map getPlayersCurrentPosition(){
        return playersCurrentPosition;
    }


    public void setCurrentTurn(String currentTurn) {
        this.currentTurn = currentTurn;
    }

    public String getCurrentTurn() {
        return currentTurn;
    }

    public void setBoard(Object[][] board) {
        this.board = board;
    }

    public Object[][] getBoard() {
        return board;
    }



}