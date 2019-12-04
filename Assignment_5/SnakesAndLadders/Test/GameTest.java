import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {
    Game game = new Game();
    Square square = new Square();

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
        game.updatePlayersCurrentPosition("clive",0);
        Assert.assertEquals(0,game.playersCurrentPosition.get("clive"));
    }

    @Test
    public void TestGetPlayersCurrentPosition() {
        game.playersCurrentPosition.put("clive", 0);
        int pos = game.getPlayersCurrentPosition("clive");
        Assert.assertEquals(0,pos);
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
        //Square square = new Square();
        //Object[][] board = square.createSquare();
        // game.board[12][2] = "clive";
        //boolean bool = game.checkWinCondition();
        //System.out.println("Initial board: " +bool);
        // Assert.assertEquals(true,bool);

    }
}