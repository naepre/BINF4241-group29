import org.junit.Assert;
import org.junit.Before;

import static org.junit.Assert.*;

public class TurnTest {
    Square square = new Square();

    @Before
    public void setup() {



    }


    @org.junit.Test
    public void TestMove() {
        int position = 2 ;
        int dicenumber = 6;
        Turn turn = new Turn();
        Object[][] board = square.createSquare();
        int newposition = turn.move(position,dicenumber,board);
        Assert.assertEquals(2,newposition);
    }

    @org.junit.Test
    public void updatePlayerPos() {
    }
}