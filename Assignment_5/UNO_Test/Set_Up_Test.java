import org.junit.Assert;
import org.junit.Test;



public class Set_Up_Test {
    /**
     * Test to check whether you cannot input a wrong playername, or twice the same
     *
     */
    @Test
    public void setPlayernameTest

    {
        //Arrange
        Player player1 = new player;
        Player player2 = new player;
        Player player3 = new player;
        //Act
        input = player1.setPlayername('');
        Assert.assertEquals('Invalid Input', input);
        input2 = player2.setPlayername('Bob');
        input3 = player3.setPlayername('Bob');
        Assert.assertEquals('Hi Bob', input2);
        Assert.assertEquals('Name already used', input3);
    }

    /**
     * Test to check whether you cannot input a wrong playerage
     */

    public void setPlayernameAgeTest

    {
        //Arrange
        Game game = new game;
        SetUP setup = new setup;
        Player player1 = new player;
        Player player2 = new player;
        Player player3 = new player;
        //Act
        input = player1.setPlayerage(b);
        Assert.assertEquals('Invalid Input', input1);
        input2 = player1.setPlayerage(3.4);
        Assert.assertEquals('Invalid Input', input2);
        input3 = player1.setPlayerage(-100);
        Assert.assertEquals('Invalid Input', input3);
        input4 = player1.setPlayerage(true);
        Assert.assertEquals('Invalid Input', input4);
        input5 = player2.setPlayerage(6);
        Assert.assertEquals('This player is too young to play UNO', input5);
        input6 = player3.setPlayerage(7);
        Assert.assertEquals('You are ready to play.', input6);

    }

    /**
     * Test to check whether you cannot input a wrong winning score
     */

    public void setScoreTest

    {
        //Arrange
        Game game = new game;
        SetUP setup = new setup;
        Player player1 = new player;
        Player player2 = new player;
        //Act
        input = player1.setScore(b);
        Assert.assertEquals('Invalid Input', input1);
        input2 = player1.setScore(3.4);
        Assert.assertEquals('Invalid Input', input2);
        input3 = player1.setScore(-100);
        Assert.assertEquals('Invalid Input', input3);
        input4 = player1.setScore(true);
        Assert.assertEquals('Invalid Input', input4);
        input5 = player2.setScore(600);
        Assert.assertEquals('You change is valid. The other player have to accept your score proposal', input5);

    }

    /**
     * Test to check whether you cannot input a wrong number of players
     */

    public void setPlayerTest

    {
        //Arrange
        Game game = new game;
        SetUP setup = new setup;
        //Act
        input = setup.setPlayer(b);
        Assert.assertEquals('Invalid Input', input1);
        input2 = setup.setPlayer(3.4);
        Assert.assertEquals('Invalid Input', input2);
        input3 = setup.setPlayer(-100);
        Assert.assertEquals('Invalid Input', input3);
        input4 = setup.setPlayer(true);
        Assert.assertEquals('Invalid Input', input4);
        input5 = setup.setPlayer(2);
        Assert.assertEquals('2 players are chosen', input5);
        input6 = setup.setPlayer(1);
        Assert.assertEquals('Not enough or too much players', input6);
        input7 = setup.setPlayer(10);
        Assert.assertEquals('Not enough or too much players', input7);


    }
}