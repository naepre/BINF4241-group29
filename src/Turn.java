import java.util.ArrayList;

public class Turn {

    Game game = new Game();


    public int move(int position, int dicenumber, Object[][] board)
    {
        int targetPostion = position + dicenumber;
        int newPosition = 0;
        int square_type = (int) board[targetPostion][1];
        //System.out.println("SQUARE TYPE"+square_type);
        String occupation = (String) board[targetPostion][2];
        //System.out.println("OCCUPATION"+occupation);
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

    public Object[][] updatePlayerPos(int playerCurrentPosition, int turn_end_position, String playername, Object[][] board) {
        //int playerCurrentPosition = getPlayersCurrentPosition(playername);
        if (turn_end_position != 0) {
            board[turn_end_position-1][2] = playername;
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
        game.updatePlayersCurrentPosition(playername, turn_end_position);
        return board;

    }


}
