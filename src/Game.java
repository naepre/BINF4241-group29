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

    public Object[][] updatePlayerPos(int turn_end_position, String playername, Object[][] board) {
        int playerCurrentPosition = getPlayersCurrentPosition(playername);
        if (turn_end_position != 0) {
            board[turn_end_position][2] = playername;
            if (playerCurrentPosition != 0) {
                board[playerCurrentPosition][2] = null;
            }
            else {
               ArrayList playersStartSquare = (ArrayList) board[0][2];
               playersStartSquare.remove(playername);
               board[0][2] = playersStartSquare;
            }
        }
        else {
            ArrayList playersStartSquare = (ArrayList) board[0][2];
            playersStartSquare.add(playername);
            board[0][2] = playersStartSquare;
            if (playerCurrentPosition != 0) {
                board[playerCurrentPosition][2] = null;
            }else {
                playersStartSquare.remove(playername);
                board[0][2] = playersStartSquare;
            }
        }
        System.out.println(board);
        return board;

    }


}


}