import java.util.*;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        //Game game = new Game();
        Game game = Game.getInstance();
        char[][][] board = game.getBoard();
        ArrayList hitList = game.getHitList();
        int counter = 0;

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

        //printboard(game);
        game.notifyGameChange();

        Boolean checkmate = false;
        Boolean check = false;

        HashMap<Character, int[]> kingPositionHashMap = new HashMap<>();
        kingPositionHashMap.put('w', new int[]{4, 7});
        kingPositionHashMap.put('b', new int[]{4, 0});


        while (checkmate == false) {
            while (check == false) {


                for (int i = 0; i < playOrder.size(); ) {
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
/*
                    // System.out.println(userInput.getClass());
                    if (userInput.equals("O-O-O") && playerColor == 'w') {
                        if (counter == 0) {
                            if (board[7][2].length == 0 && board[7][3].length == 0) {
                                int[] KingMove = {7, 2};
                                char[] KingData = {'K', 'w'};
                                int[] KstartPosition = {7, 4};
                                int[] RookMove = {7, 3};
                                char[] RookData = {'R', 'w'};
                                int[] RstartPosition = {7, 0};
                                game.updateBoard(KingData, KstartPosition, KingMove);
                                if (board[7][1].length == 0 && board[7][2][0] == 'K' && board[7][3].length == 0) {
                                    game.updateBoard(RookData, RstartPosition, RookMove);
                                    //printboard(game);
                                }
                            } else {
                                if (board[0][2].length == 0 && board[0][3].length == 0) {
                                    int[] KingMove = {0, 2};
                                    char[] KingData = {'K', 'b'};
                                    int[] KstartPosition = {0, 4};
                                    int[] RookMove = {0, 3};
                                    char[] RookData = {'R', 'b'};
                                    int[] RstartPosition = {0, 0};
                                    game.updateBoard(KingData, KstartPosition, KingMove);
                                    if (board[0][3].length == 0 && board[0][2][0] == 'K' && board[0][1].length == 0)
                                        game.updateBoard(RookData, RstartPosition, RookMove);
                                    //printboard(game);
                                }
                            }
                        }
                    }
                    if (userInput.equals("O-O") && playerColor == 'w') {
                        System.out.println("sdjkserferferff");
                        if (counter == 0) {
                            if (board[7][5][0] == ' ' && board[7][6][0] == ' ') {
                                int[] KingMove = {7, 6};
                                char[] KingData = {'K', 'w'};
                                int[] KstartPosition = {7, 4};
                                int[] RookMove = {7, 5};
                                char[] RookData = {'R', 'w'};
                                int[] RstartPosition = {7, 7};
                                game.updateBoard(KingData, KstartPosition, KingMove);
                                if (board[7][6][0] == 'K' && board[7][5][0] == ' ')
                                    game.updateBoard(RookData, RstartPosition, RookMove);
                                //printboard(game);
                                game.notifyGameChange();
                            } else {
                                if (board[0][5][0] == ' ' && board[0][6][0] == ' ') {
                                    int[] KingMove = {0, 6};
                                    char[] KingData = {'K', 'b'};
                                    int[] KstartPosition = {0, 4};
                                    int[] RookMove = {0, 5};
                                    char[] RookData = {'R', 'b'};
                                    int[] RstartPosition = {0, 7};
                                    game.updateBoard(KingData, KstartPosition, KingMove);
                                    if (board[0][6][0] == 'K' && board[0][5].length == 0)
                                        game.updateBoard(RookData, RstartPosition, RookMove);
                                    //printboard(game);
                                    game.notifyGameChange();
                                }
                            }
                        }
                    } else {
                        System.out.println("Your king was moved before");
                        break;
                    }

*/
                    if (userInput.equals("=")) {
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
                                //printboard(game);
                                game.notifyGameChange();
                                continue;
                            } else {
                                isValidMove = game.validateMove(playerColor, figureType, targetX, targetY, moveType);
                            }

                        } else if (moveType == 0) {
                            if (board[targetY][targetX][0] != ' ') {
                                System.out.println("INVALID MOVE: OCCUPIED BY YOUR PIECE OR DID NOT SPECIFY EAT!");
                                //loop back to new user input
                                //printboard(game);
                                game.notifyGameChange();
                                continue;
                            } else {
                                isValidMove = game.validateMove(playerColor, figureType, targetX, targetY, moveType);
                            }
                        }

                        //VALIDATE MOVE IS EITHER VALID, DISAMBIGUOUS OR INVALID, THEN UPDATE BOARD IF VALID.
                        if (isValidMove.size() < 1) {
                            System.out.println("INVALID MOVE! PLEASE ENTER A CORRECT MOVE");
                            //restart turn
                            //printboard(game);
                            game.notifyGameChange();
                            continue;

                        } else if (isValidMove.size() > 1) {
                            System.out.println("DISAMBIGUOUS MOVE! PLEASE SPECIFY START FIELD: ");
                            //read starting pos again with position list
                            //ask for input with start field.
                                /*
                                String disamUserInput = scanner.nextLine();
                                while (!Pattern.matches("[a-h][1-8]", disamUserInput)) {
                                    System.out.println(playerName + ", please enter a valid disambigiuous move of the form.");
                                    scanner = new Scanner(System.in);
                                    disamUserInput = scanner.nextLine();
                                }
                                ArrayList disambUserCommand = game.translate(disamUserInput);
                                int disamStartX = (int) disambUserCommand.get(2);
                                int disamStartY = (int) disambUserCommand.get(3);
                                int[] figureXY = {disamStartY, disamStartX};  //X OR Y FIRST?
                                //make the move
*/


                        } else {

                            Object[] cell = Arrays.copyOf((Object[]) isValidMove.get(0), 2);
                            char[] figureData = Arrays.copyOf((char[]) cell[0], 2); //figure data
                            int[] figureXY = Arrays.copyOf((int[]) cell[1], 2); // figure coordinate

                            int[] targetPosition = {targetY, targetX};

                            if (figureData[0] == 'K' || figureData[0] == 'R') {
                                counter++;
                            }

                            game.updateBoard(figureData, figureXY, targetPosition);

                            if (figureType == 'K') {
                                if (playerColor == 'b') {
                                    kingPositionHashMap.put('b', new int[]{targetX, targetY});
                                } else {
                                    kingPositionHashMap.put('w', new int[]{targetX, targetY});
                                }
                            }

                            ArrayList kingPositions = new ArrayList();
                            kingPositions.add(kingPositionHashMap.get('w'));
                            kingPositions.add(kingPositionHashMap.get('b'));


                            //check = game.isCheck(kingPosition, playerColor); //check if you're checked
                            HashMap isCheckMap = game.isCheck(kingPositions, playerColor);
                            boolean currentPlayerKingIsCheck = (boolean) isCheckMap.get(playerColor);

                            //if current player is in check after moving
                            if (currentPlayerKingIsCheck == true) {
                                System.out.println("INVALID MOVE! YOUR KING IS IN CHECK");
                                game.updateBoard(figureData, targetPosition, figureXY); //Reverse update the move
                                //printboard(game);
                                game.notifyGameChange();
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
                                    //printboard(game);
                                    game.notifyGameChange();
                                }
                            }
                            i++;
                            //printboard(game);
                            game.notifyGameChange();
                        }
                    }
                }
            }
        }
    }
}


