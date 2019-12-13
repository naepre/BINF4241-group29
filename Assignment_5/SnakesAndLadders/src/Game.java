import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game
{
    ArrayList players;
    Map playersCurrentPosition = new HashMap();
    String currentTurn;
    Object[][] board;

    public void setPlayers(ArrayList players) {
        this.players = players;
    }

    public ArrayList getPlayers() {
        return players;
    }

    public void updatePlayersCurrentPosition(String playerName, int newPosition) {
        playersCurrentPosition.put(playerName, newPosition);
    }

    public int getPlayersCurrentPosition(String playername) {
        int pcp = (int) playersCurrentPosition.get(playername);
        return pcp;
    }

    public void setCurrentTurn(String currentTurn) {
        this.currentTurn = currentTurn;
    }

    public void setBoard(Object[][] board) {
        this.board = board;
    }

    public Object[][] getBoard() {
        return board;
    }

    public boolean checkWinCondition(){
        if(board[12][2] != null){
            return true;
        }
        return false;
    }

}