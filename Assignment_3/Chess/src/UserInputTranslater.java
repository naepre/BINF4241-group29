import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserInputTranslater {


    public String readUserInput(String playerName){
        System.out.println(playerName + ", please enter your move: ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        while (!Pattern.matches("(([QKNBR]([x][a-h][1-8]|[a-h][1-8]))|([x][a-h][1-8]|[a-h][1-8])|O-O-O|O-O|=)", userInput)) {
            System.out.println(playerName + ", please enter a valid move of the form: Kxa6");
            System.out.println("KQBNR, only target space for pawn and x to eat.");
            scanner = new Scanner(System.in);
            userInput = scanner.nextLine();
        }
        return userInput;
    }


    public ArrayList translate(String userInput){

        HashMap<Character, Integer> translation = new HashMap<Character, Integer>();


        translation.put('a', 0);
        translation.put('b', 1);
        translation.put('c', 2);
        translation.put('d', 3);
        translation.put('e', 4);
        translation.put('f', 5);
        translation.put('g', 6);
        translation.put('h', 7);
        translation.put('8', 0);
        translation.put('7', 1);
        translation.put('6', 2);
        translation.put('5', 3);
        translation.put('4', 4);
        translation.put('3', 5);
        translation.put('2', 6);
        translation.put('1', 7);


        char[] charArray = userInput.toCharArray();
        int l = charArray.length;
        int moveType;
        ArrayList inputList = new ArrayList();
        char figureType;
        char xCoordinate = charArray[l - 2]; //needs to convert letter to number
        char yCoordinate = charArray[l - 1]; //needs to convert letter to number
        int x = translation.get(xCoordinate);
        int y = translation.get(yCoordinate);

        if (l == 2) {
            figureType = 'p';
            moveType = 0;
            inputList.add(moveType);
            inputList.add(figureType);
        } else if (l == 3) {
            if (Character.isUpperCase(charArray[0]) == true) {
                figureType = charArray[0];
                moveType = 0;
                inputList.add(moveType);
                inputList.add(figureType);
            } else {
                figureType = 'p';
                moveType = 1;
                inputList.add(moveType);
                inputList.add(figureType);
            }
        }
        if (l == 4) {
            figureType = charArray[0];
            moveType = 1;
            inputList.add(moveType);
            inputList.add(figureType);
        }
        inputList.add(x);
        inputList.add(y);

        //System.out.println(xCoordinate);
        //System.out.println(yCoordinate);
        return inputList;
    }


}
