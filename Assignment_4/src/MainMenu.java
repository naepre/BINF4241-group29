
import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {

    private Oven oven = new Oven();
    private WashingMachine washingMachine = new WashingMachine();
    private Microwave microwave = new Microwave();
    private Dishwasher dishwasher = new Dishwasher();

    private Object menuType = null;

    public void mainMenu(){


        ArrayList appliances = new ArrayList();
        appliances.add(oven);
        appliances.add(microwave);
        appliances.add(dishwasher);
        appliances.add(washingMachine);

        System.out.println("###### MAIN MENU ######");
        for(int i=0;i<appliances.size();i++){
            System.out.println("["+i+"] "+ appliances.get(i).getClass().getName());
        }
        System.out.println("Select an appliance by entering a number: ");

        Scanner scanner = new Scanner(System.in);
        int userInput;

        do {
            userInput = scanner.nextInt();

            if (menuType == null) {
                if (userInput == 0) {
                    oven.getOvenSubMenu();
                    menuType = oven;
                }
            } else if(menuType == oven){
                oven.cmd(userInput);
            }
        }while (userInput >= 0); //still needs higher bound 5

        menuType = userInput;
    }

}
