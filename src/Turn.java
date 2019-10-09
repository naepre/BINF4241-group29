import java.util.ArrayList;

public class Turn {

    Game game = new Game();


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
        //System.out.println("SQUARE TYPE"+square_type);
        String occupation = (String) board[targetPosition][2];
        //System.out.println("OCCUPATION"+occupation);
        if (square_type != 0) {
            newPosition = move(targetPosition, square_type, board);
        }
        else if (square_type == 0 && occupation == null) {
            newPosition = targetPosition;
        }
        else {
            newPosition = 0;
        }
        return newPosition;
    }



    public Object[][] updatePlayerPos(int playerCurrentPosition, int newPosition, String playername, Object[][] board) {
        //int playerCurrentPosition = getPlayersCurrentPosition(playername);
        if (newPosition != 0) {
            board[newPosition][2] = playername;
            if (playerCurrentPosition != 0)
            {
                board[playerCurrentPosition][2] = null;
            }
            else
                {
                ArrayList playersStartSquare = (ArrayList) board[0][2];
                //System.out.println("player name::" + playername);
                //System.out.println("player start square ::" + playersStartSquare);
                playersStartSquare.remove(playername); //??
                //System.out.println(playersStartSquare);
                board[0][2] = playersStartSquare;
            }
        }
        else
            {
            ArrayList playersStartSquare = (ArrayList) board[0][2];
            playersStartSquare.add(playername);
            board[0][2] = playersStartSquare;
            if (playerCurrentPosition != 0) {
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
