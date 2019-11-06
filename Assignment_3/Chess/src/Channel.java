public class Channel {

    PrintOutToTerminal printOutToTerminal = new PrintOutToTerminal();
    Scoreboard scoreboard = new Scoreboard();


    public void updateBoard(char[][][] board){
        printOutToTerminal.updateBoard(board);
    }

    public void updateHitLists(Object hitLists){
        scoreboard.updateHitLists(hitLists);
    }

}
