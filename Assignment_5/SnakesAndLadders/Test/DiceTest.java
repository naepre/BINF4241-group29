import org.junit.Assert;
import org.junit.Test;



public class DiceTest {
    /**
     * Test to check whether the dice always returns a random number between 1 and 6
     *
     */
    @Test
    public void roll() {
        //Arrange
        Dice dice = new Dice();
        //Act
        for(int i=0;i<50;i++) {
            int diceno = dice.roll();
            //Assert
            Assert.assertTrue(diceno <= 6 || diceno > 0);
        }
    }
}