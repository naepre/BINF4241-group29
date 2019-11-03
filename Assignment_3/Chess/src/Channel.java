public class Channel implements ChannelInterface{

    PrintOutToTerminal printOutToTerminal = new PrintOutToTerminal();

    //private Object game;
    private char[][][] board;
    private Object hitLists;

    public void updateBoard(char[][][] board){
        this.board = board;
        printOutToTerminal.updateBoard(board);
    }

    public void updateHitLists(Object hitLists){
        this.hitLists = hitLists;
        //printOutScoreBoard.updateHitLists(hitLists);
    }

}
