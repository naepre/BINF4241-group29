
import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {

    private Oven oven = new Oven();
    private WashingMachine washingMachine = new WashingMachine();
    private Microwave microwave = new Microwave();
    private Dishwasher dishwasher = new Dishwasher();

    private Object menuType = null;

    public void mainMenu(){

        printMainMenu();

        Scanner scanner = new Scanner(System.in);
        int userInput;

        do {
            userInput = scanner.nextInt();
            if(userInput == 9){
                printMainMenu();
                menuType = null;
            }else{
                if (menuType == null) {

                    if (userInput == 0) {
                        oven.getOvenSubMenu();
                        menuType = oven;
                    }else if(userInput == 1){
                        microwave.getMicrowaveSubMenu();
                        menuType = microwave;
                    }else if(userInput == 2){
                        dishwasher.getDishwasherSubMenu();
                        menuType = dishwasher;
                    }else if(userInput == 3){
                        washingMachine.getWashingMachineSubMenu();
                        menuType = washingMachine;
                    }

                } else if(menuType == oven){
                    oven.cmd(userInput);
                }else if(menuType == microwave){
                    microwave.cmd(userInput);
                }else if(menuType == dishwasher){
                    dishwasher.cmd(userInput);
                }else if(menuType == washingMachine){
                    washingMachine.cmd(userInput);
                }

            }

        }while (true);

    }

    private void printMainMenu(){
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
    }

}
