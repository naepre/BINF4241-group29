import org.junit.Before;
import org.junit.Test;
import java.io.PrintStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class PlayerTest {


    @Test
    public void getPlayerCounter() {
        Player playerno = new Player();
        playerno.getPlayerCounter();
        String input = "5";
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        //Scanner scanner = new Scanner(System.in);
        System.setIn(stdin);


        //int output = playerno.numberOfPlayers;
        // assertEquals(Integer.parseInt(input),output);


    }

    @Test
    public void getPlayerNames() {
    }
}