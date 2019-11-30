public class Square
{

    public Object[][] createSquare()
    {
// Creating the board with snakes and ladders
        Object[][] board = new Object[][]
                {
                {0, 0, null},{1, 2, null},{2, 0, null},{3, 0, null},
                {4, 4, null},{5, 0, null},{6, -3, null},{7, 0, null},
                {8, 0, null},{9, -4, null},{10, 0, null},{11, 0, null}, {12, 0, null}
        };

        return board;
    }

}