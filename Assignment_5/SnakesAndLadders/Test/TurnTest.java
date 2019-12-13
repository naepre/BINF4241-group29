import org.junit.Assert;
import org.junit.Before;

import java.util.ArrayList;


public class TurnTest {
    ArrayList<String> players = new ArrayList();

    Square square = new Square();
    Object[][] test = new Object[][]
            {
                    {0, 0, null},{1, 2, null},{2, 0, null},{3, 0, null},
                    {4, 4, null},{5, 0, null},{6, -3, null},{7, 0, null},
                    {8, 0, null},{9, -4, null},{10, 0, null},{11, 0, null}, {12, 0, null}
            };

    /**
     * To setup the arraylist with two players
     *
     */
    @Before
    public void setup() {
        players.add("clive");
        players.add("tim");
    }
    /**
     * Test to check all possible moves of a player
     *
     * 1.When the player moves to a square which is not a snake or a ladder
     * 2.When the player moves to a square which is a snake
     * 3.When the player moves to a square which is a ladder
     * 4.When a player rolls a dice number larger than the number of squares in front of him
     * 5.When a player exactly lands on the final square
     * 6.When a player lands on an occupied field
     */

    @org.junit.Test
    public void TestMove() {
        //Arrange
        int[] startpos = {0, 2, 5, 7,10};
        int [] dicenumber = {1,2,3,4,5,6};
        Turn turn = new Turn();
        Object[][] board = square.createSquare();
        //1.
        //Act && Assert
        int normalcase = turn.move(startpos[0],dicenumber[4],board);
        Assert.assertEquals(5,normalcase);
        //2.
        int snakecase = turn.move(startpos[2],dicenumber[3],board);
        Assert.assertEquals(5,snakecase);
        //3.
        int laddercase = turn.move(startpos[1],dicenumber[1],board);
        Assert.assertEquals(8,laddercase);
        //4.
        int stepcase = turn.move(startpos[4],dicenumber[5],board);
        Assert.assertEquals(8,stepcase);
        //5.
        int lastsquare = turn.move(startpos[3],dicenumber[4],board);
        Assert.assertEquals(12,lastsquare);
        //6.
        board[7][2] = "Nael";// Player 2 occupies square 7
        int occupied = turn.move(startpos[1],dicenumber[4],board);
        Assert.assertEquals(0,occupied);
    }

    /**
     * Test to check if players position gets updated on the board
     *
     * 1. Normal case simply update player position according to current-position, new-position and player name
     * 2. Test to see if the a player was removed from its starting position
     */
    @org.junit.Test
    public void updatePlayerPos() {
        //Arrange
        Turn update = new Turn();
        Object[][] board1 = square.createSquare();
        ArrayList<String> copyPlayer = (ArrayList<String>) players.clone();
        board1[0][2] = copyPlayer;
        //1.
        //Act
        Object[][] returnedboard = update.updatePlayerPos(0,3,"clive",board1);
        Object expected = test[3][2] = "clive" ;
        //Assert
        Assert.assertEquals(expected,returnedboard[3][2]);
        //2.
        //Act
        ArrayList<String> startCell = (ArrayList<String>) board1[0][2];
        //Assert
        Assert.assertFalse(startCell.contains("clive"));
    }
}