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

    @Before
    public void setup() {
        players.add("clive");
        players.add("tim");
    }


    @org.junit.Test
    public void TestMove() {
        //Arrange
        int[] startpos = {0, 2, 5, 7,10};
        int [] dicenumber = {1,2,3,4,5,6};
        Turn turn = new Turn();
        Object[][] board = square.createSquare();
        //Act && Assert
        /**
         * When the player moves to a square which is not a snake or a ladder
         */
        int normalcase = turn.move(startpos[0],dicenumber[4],board);
        Assert.assertEquals(5,normalcase);
        /**
         * When the player moves to a square which is a snake
         */
        int snakecase = turn.move(startpos[2],dicenumber[3],board);
        Assert.assertEquals(5,snakecase);
        /**
         * When the player moves to a square which is a ladder
         */
        int laddercase = turn.move(startpos[1],dicenumber[1],board);
        Assert.assertEquals(8,laddercase);
        /**
         * Test when a player rolls a dice number larger then the number of squares away the finish field
         */
        int stepcase = turn.move(startpos[4],dicenumber[5],board);
        Assert.assertEquals(8,stepcase);
        /**
         * Test when a player exactly lands on the final square
         */
        int lastsquare = turn.move(startpos[3],dicenumber[4],board);
        Assert.assertEquals(12,lastsquare);
        /**
         * Test when a player exactly lands on an occupied field should go back to beginning
         */
        board[7][2] = "Nael";// Player 2 occupies square 7
        int occupied = turn.move(startpos[1],dicenumber[4],board);
        Assert.assertEquals(0,occupied);
    }

    /**
     * Test to check if players position gets updated on the board
     */

    @org.junit.Test
    public void updatePlayerPos() {

        //Arrange
        Turn update = new Turn();
        Object[][] board1 = square.createSquare();
        ArrayList<String> copyPlayer = (ArrayList<String>) players.clone();
        board1[0][2] = copyPlayer;
        /**
         * Normal case simply update player position according to current-position, new-position and player name
         */
        //Act
        Object[][] returnedboard = update.updatePlayerPos(0,3,"clive",board1);
        Object expected = test[3][2] = "clive" ;
        //Assert
        Assert.assertEquals(expected,returnedboard[3][2]);
        /**
         * Test to see if the a player was removed from its starting position
         */
        //Act
        ArrayList<String> startCell = (ArrayList<String>) board1[0][2];
        //Assert
        Assert.assertFalse(startCell.contains("clive"));
    }
}