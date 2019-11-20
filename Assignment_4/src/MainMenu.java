
import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {

    private Oven oven = new Oven();
    private WashingMachine washingMachine = new WashingMachine();
    private Microwave microwave = new Microwave();
    private Dishwasher dishwasher = new Dishwasher();

    private int menuType = -1;

    public void mainMenu(){


        ArrayList appliances = new ArrayList();
        appliances.add(oven);
        appliances.add(microwave);
        appliances.add(dishwasher);
        appliances.add(washingMachine);

        System.out.println("###### MAIN MENU ######");
        System.out.println("Select an appliance:");
        for(int i=0;i<appliances.size();i++){
            System.out.println("["+i+"]"+ appliances.get(i));
        }

        Scanner scanner = new Scanner(System.in);
        int userInput;

        do {
            userInput = scanner.nextInt();

            if (menuType == -1) {
                if (userInput == 0) {
                    // call submenu of oven
                    oven.cmd(0);
                } else if (userInput == 1) {
                    microwave.cmd(1);
                }
                else if (userInput == 2) {
                    dishwasher.cmd(2);
                }
            } else {
                if (userInput == 0) {
                    oven.cmd(userInput);
                }
            }
        }
            while (userInput >= 0) ;



        menuType = userInput;



        //print MAIN MENU
        //wait for u c
        //oven.cmd(-1);

    }

}
