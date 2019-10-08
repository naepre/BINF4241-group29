import java.util.ArrayList;
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

    public int getPlayersCurrentPosition(String playername){
        int pcp = (int) playersCurrentPosition.get(playername);
        return pcp;
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

    public boolean checkWinCondition(){
        if(board[11][2] != null){
            return true;
        }
        return false;
    }

}