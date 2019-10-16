import java.awt.*;
import java.lang.reflect.Field;
import java.util.Arrays;

public class Main {

    public static void main(String[] args){
        Game game = new Game();

        Object board = Arrays.deepToString(game.board);
        System.out.println(board);

    }

}
