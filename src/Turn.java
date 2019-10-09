import java.util.ArrayList;

public class Turn
{

    Game game = new Game();
/// moving the player
    public int move(int position, int dicenumber, Object[][] board)
    {
        int targetPosition = 0;
        int newPosition = 0;
        int squaresInFront = 12-position;
        if (squaresInFront - dicenumber >= 0)
        {
            targetPosition = position + dicenumber;
        }
        else
        {
            targetPosition = position + (2*squaresInFront -dicenumber);
        }
        int square_type = (int) board[targetPosition][1];
        String occupation = (String) board[targetPosition][2];
        if (square_type != 0)
        {
            newPosition = move(targetPosition, square_type, board);
        }
        else if (square_type == 0 && occupation == null)
        {
            newPosition = targetPosition;
        }
        else {
            newPosition = 0;
        }
        return newPosition;
    }

////// updating player position

    public Object[][] updatePlayerPos(int playerCurrentPosition, int newPosition, String playername, Object[][] board)
    {
        if (newPosition != 0) {
            board[newPosition][2] = playername;
            if (playerCurrentPosition != 0)
            {
                board[playerCurrentPosition][2] = null;
            }
            else
                {
                ArrayList playersStartSquare = (ArrayList) board[0][2];
                playersStartSquare.remove(playername);
                board[0][2] = playersStartSquare;
            }
        }
        else
            {
            ArrayList playersStartSquare = (ArrayList) board[0][2];
            playersStartSquare.add(playername);
            board[0][2] = playersStartSquare;
            if (playerCurrentPosition != 0)
            {
                board[playerCurrentPosition][2] = null;
            }
            else
                {
                playersStartSquare.remove(playername);
                board[0][2] = playersStartSquare;
            }
        }
        return board;
    }

}
