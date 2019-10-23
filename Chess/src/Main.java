import java.util.*;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        Game game = new Game();
        char[][][] board = game.getBoard();
        ArrayList hitList = game.getHitList();

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a player one name (white): ");
        Player player1 = new Player(keyboard.next(), 'w');
        System.out.println("Enter a player two name (black): ");
        Player player2 = new Player(keyboard.next(), 'b');


        ArrayList playerOne = new ArrayList();
        playerOne.add(player1.getName());
        playerOne.add(player1.getColor());

        ArrayList playerTwo = new ArrayList();
        playerTwo.add(player2.getName());
        playerTwo.add(player2.getColor());


        ArrayList playOrder = new ArrayList();
        playOrder.add(playerOne);
        playOrder.add(playerTwo);

        printboard(board, hitList);

        Boolean checkmate = false;
        Boolean check = false;
        int[] whiteKingPos= new int[]{4, 7};
        int[] blackKingPos = new int[]{4, 0};

        while (checkmate == false) {
            while (check == false) {


                for (int i = 0; i < playOrder.size(); i++) {
                    ArrayList currentPlayer = (ArrayList) playOrder.get(i);
                    String playerName = (String) currentPlayer.get(0);
                    char playerColor = (char) currentPlayer.get(1);


                    System.out.println(playerName + ", please enter your move: ");
                    Scanner scanner = new Scanner(System.in);
                    String userInput = scanner.nextLine();
                    while (!Pattern.matches("(([QKNBR]([x][a-h][1-8]|[a-h][1-8]))|([x][a-h][1-8]|[a-h][1-8]))", userInput)) {
                        System.out.println(playerName + ", please enter a valid move of the form: Kxa6");
                        System.out.println("KQBNR, only target space for pawn and x to eat.");
                        scanner = new Scanner(System.in);
                        userInput = scanner.nextLine();
                    }

                    ArrayList userCommand = game.translate(userInput);

                    //deconstruct the userCommand
                    int moveType = (int) userCommand.get(0);
                    char figureType = (char) userCommand.get(1);
                    int targetX = (int) userCommand.get(2);
                    int targetY = (int) userCommand.get(3);

                    ArrayList isValidMove = new ArrayList();

                    if (moveType == 1) {
                        if (board[targetX][targetY].length == 0 | board[targetX][targetY][1] == playerColor) {
                            System.out.println("INVALID EAT: FIELD IS EMPTY OR THE FIGURE IS NOT BELONGING TO THE OPPOSITE PLAYER!");
                            //loop back to new user input
                            i = i - 1;
                        } else {
                            isValidMove = game.validateMove(playerColor, figureType, targetX, targetY, moveType);
                        }

                    } else {
                        isValidMove = game.validateMove(playerColor, figureType, targetX, targetY, moveType);
                    }

                    //VALIDATE MOVE IS EITHER VALID, DISAMBIGUOUS OR INVALID, THEN UPDATE BOARD IF VALID.
                    if (isValidMove.size() < 1) {
                        System.out.println("INVALID MOVE! PLEASE ENTER A CORRECT MOVE: ");
                        //restart turn
                        i = i - 1;

                    } else if (isValidMove.size() > 1) {
                        System.out.println("DISAMBIGUOUS MOVE! PLEASE SPECIFY START FIELD: ");
                        //read starting pos again with position list
                        //ask for input with start field.
                        //
                    } else {

                        Object[] cell = Arrays.copyOf((Object[]) isValidMove.get(0), 2);
                        char[] figureData = Arrays.copyOf((char[]) cell[0], 2); //figure data
                        int[] figureXY = Arrays.copyOf((int[]) cell[1], 2); // figure coordinate

                        int[] targetPosition = {targetX, targetY};

                        game.updateBoard(figureData, figureXY, targetPosition);

                        if(figureType == 'K' && playerColor == 'b'){
                            blackKingPos[0] = targetX;
                            blackKingPos[1] = targetY;
                        }else if(figureType == 'K' && playerColor == 'w'){
                            whiteKingPos[0] = targetX;
                            whiteKingPos[1] = targetY;
                        }

                        ArrayList kingPosition = new ArrayList(){};
                        kingPosition.add(whiteKingPos);
                        kingPosition.add(blackKingPos);

                        check = game.isCheck(kingPosition, playerColor); //check if you're checked

                        if(check == true){
                            System.out.println("INVALID MOVE! YOUR KING IS IN CHECK ");
                            //revert board and restart turn
                            game.updateBoard(figureData, targetPosition, figureXY);
                            i = i - 1;
                        }else{
                            System.out.println("VALID MOVE");
                            char[][][] boardAfterMove = game.getBoard();
                            ArrayList hitListAfterMove = game.getHitList();
                            printboard(boardAfterMove, hitListAfterMove);
                        }
                    }


                    if(figureType == 'K' && playerColor == 'b'){
                        blackKingPos[0] = targetX;
                        blackKingPos[1] = targetY;
                    }else if(figureType == 'K' && playerColor == 'w'){
                        whiteKingPos[0] = targetX;
                        whiteKingPos[1] = targetY;
                    }

                    ArrayList kingPosition = new ArrayList(){};
                    kingPosition.add(whiteKingPos);
                    kingPosition.add(blackKingPos);

                    System.out.println(whiteKingPos);
                    System.out.println(blackKingPos);

                    check = game.isCheck(kingPosition, playerColor);

                    if (check == true) {
                        System.out.println("Check BRA!!");
                    }

                }
            }
        }
    }

    public static void printboard(char[][][] board, ArrayList hitList) {
        char[][] prntboard;
        ArrayList blackHitList = (ArrayList) hitList.get(1);
        System.out.print("BLACK HIT LIST: ");
        for(int i=0;i<blackHitList.size();i++){
            char[] x = (char[]) blackHitList.get(i);
            System.out.print(new String(x)+" ");
        }
        System.out.println();
        System.out.println(" \t   a       b       c       d       e       f       g       h");
        System.out.println(" \t_______________________________________________________________");

        for (int p = 0; p < 8; p++)
        {
            for ( int j = 0; j < 1; j++)
            {
                prntboard = board[p];
                System.out.print(8-p+"\t");
                System.out.print(Arrays.deepToString(prntboard));
            }
            System.out.println();
        }
        ArrayList whiteHitList = (ArrayList) hitList.get(0);
        System.out.print("WHITE HIT LIST: ");
        for(int i=0;i<whiteHitList.size();i++){
            char[] x = (char[]) whiteHitList.get(i);
            System.out.print(new String(x)+" ");
        }

        System.out.println();
    }


}


