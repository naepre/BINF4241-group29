import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Square {


    ArrayList square = new ArrayList();

    public ArrayList createSquare(){

        square.clear();

        square.add(0, 0); //square type = {0, +, -}
        square.add(1, null); //isOccupied

        return square;
    }


/*
    ArrayList[][] board;

    public void setBoard(ArrayList[][] board) {
        this.board = new ArrayList[][]{
                {1},{2}
        };

    }

    public String getBoard(){
        return board;
    }

    */
}