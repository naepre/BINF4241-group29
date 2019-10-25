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

        printboard(game);

        Boolean checkmate = false;
        Boolean check = false;
        int[] whiteKingPos= new int[]{4, 7};
        int[] blackKingPos = new int[]{4, 0};



        while (checkmate == false) {
            while (check == false) {


                for (int i = 0; i < playOrder.size();) {
                    ArrayList currentPlayer = (ArrayList) playOrder.get(i);
                    String playerName = (String) currentPlayer.get(0);
                    char playerColor = (char) currentPlayer.get(1);

                    ArrayList copyPlayOrder = playOrder; // getting to opposite player and his color!
                    copyPlayOrder.remove(i);
                    ArrayList oppositePlayer = (ArrayList) copyPlayOrder.get(0);
                    String oppositePlayerName = (String) oppositePlayer.get(0);
                    char oppositePlayerColor = (char) oppositePlayer.get(1);
                    copyPlayOrder.add(i, currentPlayer);


                 //   System.out.println("CURRENT PLAYER: " + playerName + " i: " + i);

                    System.out.println(playerName + ", please enter your move: ");
                    Scanner scanner = new Scanner(System.in);
                    String userInput = scanner.nextLine();
                    while (!Pattern.matches("(([QKNBR]([x][a-h][1-8]|[a-h][1-8]))|([x][a-h][1-8]|[a-h][1-8])|O-O-O|O-O|=)", userInput)) {
                        System.out.println(playerName + ", please enter a valid move of the form: Kxa6");
                        System.out.println("KQBNR, only target space for pawn and x to eat.");
                        scanner = new Scanner(System.in);
                        userInput = scanner.nextLine();
                    }

                    // System.out.println(userInput.getClass());

                    if (userInput.equals("O-O-O")) { //Queenside Castling

                    } else if (userInput.equals("O-O")) { //Kingside Castling

                    } else if (userInput.equals("=")) {
                        System.out.println(oppositePlayerName + "! " + playerName + " offers you a draw! Do you want to accept it? [y/n]");
                        Scanner drawResponse = new Scanner(System.in);
                        String response = scanner.nextLine();
                        while (!Pattern.matches("y|n", response)) {
                            System.out.println("Please respond with y or n!");
                            drawResponse = new Scanner(System.in);
                            response = drawResponse.nextLine();
                        }
                        if (response.equals("y")) {
                            System.out.println("It's a draw! The player have declared peace!");
                            System.exit(0);
                        } else if (response.equals("n")) {
                            System.out.println(playerName + "! " + oppositePlayerName + " does not accept your offer! The slaughter shall continue!");
                            continue;
                        }
                    } else {

                        ArrayList userCommand = game.translate(userInput);

                        //deconstruct the userCommand
                        int moveType = (int) userCommand.get(0);
                        char figureType = (char) userCommand.get(1);
                        int targetX = (int) userCommand.get(2);
                        int targetY = (int) userCommand.get(3);

                        ArrayList isValidMove = new ArrayList();

                        if (moveType == 1) {
                            if (board[targetY][targetX][0] == ' ' || board[targetY][targetX][1] == playerColor) {
                                System.out.println("INVALID EAT: FIELD IS EMPTY OR THE FIGURE IS NOT BELONGING TO THE OPPOSITE PLAYER!");
                                //loop back to new user input
                                printboard(game);
                                continue;
                            } else {
                                isValidMove = game.validateMove(playerColor, figureType, targetX, targetY, moveType);
                            }

                        } else if (moveType == 0) {
                            if (board[targetY][targetX][0] != ' ') {
                                System.out.println("INVALID MOVE: OCCUPIED BY YOUR PIECE OR DID NOT SPECIFY EAT!");
                                //loop back to new user input
                                printboard(game);
                                continue;
                            } else {
                                isValidMove = game.validateMove(playerColor, figureType, targetX, targetY, moveType);
                            }
                        }

                        //VALIDATE MOVE IS EITHER VALID, DISAMBIGUOUS OR INVALID, THEN UPDATE BOARD IF VALID.
                        if (isValidMove.size() < 1) {
                            System.out.println("INVALID MOVE! PLEASE ENTER A CORRECT MOVE");
                            //restart turn
                            printboard(game);
                            continue;

                        } else if (isValidMove.size() > 1) {
                            System.out.println("DISAMBIGUOUS MOVE! PLEASE SPECIFY START FIELD: ");
                            //read starting pos again with position list
                            //ask for input with start field.
                            //
                        } else {

                            Object[] cell = Arrays.copyOf((Object[]) isValidMove.get(0), 2);
                            char[] figureData = Arrays.copyOf((char[]) cell[0], 2); //figure data
                            int[] figureXY = Arrays.copyOf((int[]) cell[1], 2); // figure coordinate

                            int[] targetPosition = {targetY, targetX};

                            game.updateBoard(figureData, figureXY, targetPosition);

                            if (figureType == 'K' && playerColor == 'b') {
                                blackKingPos[0] = targetX;
                                blackKingPos[1] = targetY;
                            } else if (figureType == 'K' && playerColor == 'w') {
                                whiteKingPos[0] = targetX;
                                whiteKingPos[1] = targetY;
                            }

                            ArrayList kingPositions = new ArrayList() {
                            };
                            kingPositions.add(whiteKingPos);
                            kingPositions.add(blackKingPos);


                            //check = game.isCheck(kingPosition, playerColor); //check if you're checked
                            HashMap isCheckMap = game.isCheck(kingPositions, playerColor);
                            boolean currentPlayerKingIsCheck = (boolean) isCheckMap.get(playerColor);

                            //if current player is in check after moving
                            if (currentPlayerKingIsCheck == true) {
                                System.out.println("INVALID MOVE! YOUR KING IS IN CHECK");
                                game.updateBoard(figureData, targetPosition, figureXY); //Reverse update the move
                                printboard(game);
                                continue;
                            } else {
                                //If opponent king is in check after moving
                                char opponentColor;
                                if (playerColor == 'w') {
                                    opponentColor = 'b';
                                } else {
                                    opponentColor = 'w';
                                }
                                boolean opponentKingIsCheck = (boolean) isCheckMap.get(opponentColor);
                                if (opponentKingIsCheck == true) {
                                    System.out.println("##CHECK##");
                                    //check = true
                                    i++;
                                    printboard(game);
                                }
                            }
                            i++;
                            printboard(game);
                        }
                    }
                }
            }
        }
    }

    public static void printboard(Game game) {

        char[][][] board = game.getBoard();
        ArrayList hitList = game.getHitList();

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


