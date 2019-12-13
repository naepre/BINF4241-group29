import org.junit.Assert;
import org.junit.Test;


import java.io.ByteArrayInputStream;


public class PlayerTest {
    /**
     * Test to check the input which is received from the user
     * in order to play the game is correct
     *
     */
    @Test
    public void TestGetPlayerCounter() {
        Player playerno = new Player();
        for(int i = 2; i< 5;i++){
            String input = Integer.toString(i);
            System.out.println("Testing input: "+ input);
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            Assert.assertEquals(Integer.parseInt(input),playerno.getPlayerCounter());
        }
    }

}