import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {
    Game game = new Game();
    Square square = new Square();
    Object[][] test = new Object[][]
            {
                    {0, 0, null},{1, 2, null},{2, 0, null},{3, 0, null},
                    {4, 4, null},{5, 0, null},{6, -3, null},{7, 0, null},
                    {8, 0, null},{9, -4, null},{10, 0, null},{11, 0, null}, {12, 0, null}
            };


    @Before
    public void setup() {


    }

    @Test
    public void setPlayers() {
    }

    @Test
    public void getPlayers() {
    }

    @Test
    public void TestUpdatePlayersCurrentPosition() {

        //Arrange
        game.playersCurrentPosition.put("clive",2);
        game.playersCurrentPosition.put("Nael",6);
        //Act && Assert for player 1 (Clive)
        game.updatePlayersCurrentPosition("clive",5);
        Assert.assertEquals(5,game.playersCurrentPosition.get("clive"));

        //Act && Arrange for player 2 (Nael)
        game.updatePlayersCurrentPosition("Nael",3);
        Assert.assertEquals(3,game.playersCurrentPosition.get("Nael"));
    }

    @Test
    public void TestGetPlayersCurrentPosition() {
        //Arrange
        game.playersCurrentPosition.put("clive",0);
        game.playersCurrentPosition.put("Nael",11);
        //Act && Assert Player 1 (clive)
        int player1pos = game.getPlayersCurrentPosition("clive");
        Assert.assertEquals(0,player1pos);

        //Act && Assert Player 2 (Nael)
        int player2pos = game.getPlayersCurrentPosition("Nael");
        Assert.assertEquals(11,player2pos);
    }

    @Test
    public void setCurrentTurn() {
    }

    @Test
    public void getCurrentTurn() {
    }

    @Test
    public void setBoard() {
    }

    @Test
    public void getBoard() {
    }

    @Test
    public void TestCheckWinCondition() {
        /**
         * When the player moves to last square function returns true
         */
        //Arrange
        game.board = square.createSquare();
        game.board[12][2]= "clive";
        //Act
        boolean checkwin= game.checkWinCondition();
        //Assert
        Assert.assertEquals(true,checkwin);
        /**
         * When the last square is empty/null
         */
        //Arrange
        game.board[12][2]= null;
        //Act
        boolean checknull= game.checkWinCondition();
        //Assert
        Assert.assertEquals(false,checknull);
    }
}