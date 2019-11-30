import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MainMenu {

    private Oven oven = new Oven();
    private WashingMachine washingMachine = new WashingMachine();
    private Microwave microwave = new Microwave();
    private Dishwasher dishwasher = new Dishwasher();
    private  CleaningRobot cleaningRobot = new CleaningRobot();

    private Object menuType = null;

    public void mainMenu(){

<<<<<<< HEAD
        ArrayList appliances = new ArrayList();
        appliances.add(oven);
        appliances.add("Microwave");

        System.out.println("###### MAIN MENU ######");
        System.out.println("Select an appliance:");
        for(int i=0;i<appliances.size();i++){
            System.out.println("["+i+"]"+ appliances.get(i));
        }

        Scanner scanner = new Scanner(System.in);
        int userInput;

        do {

            userInput = scanner.nextInt();

        }while(userInput < 0 || userInput > 5);

        //If user is in main menu, call corresponding submenu. Otherwise, cast the user input command to the corresponding appliance
        if (menuType == -1){
            if (userInput == 0){
                // call submenu of oven
                oven.cmd(-1);
            }
            else if (userInput == 1){
                // call submenu of microwave
            }
        }
        else {
            //Object applianceToCastTo = appliances.get(userInput);
            //applianceToCastTo.cmd(userInput);
            if (userInput == 0){
                oven.cmd(userInput);
            }
        }
        menuType = userInput;

=======
        printMainMenu();

        int userInput;

        do {
            try{
                Scanner scanner = new Scanner(System.in);
                userInput = scanner.nextInt();

                if(userInput <= 9 && userInput >=0){
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
                            }else if(userInput == 4){
                                cleaningRobot.getCleaningRobotSubMenu();
                                menuType = cleaningRobot;
                            }

                        } else if(menuType == oven){
                            oven.cmd(userInput);
                        }else if(menuType == microwave){
                            microwave.cmd(userInput);
                        }else if(menuType == dishwasher){
                            dishwasher.cmd(userInput);
                        }else if(menuType == washingMachine){
                            washingMachine.cmd(userInput);
                        }else if(menuType == cleaningRobot){
                            cleaningRobot.cmd(userInput);
                        }
                    }
                }else {
                    System.out.println("Please enter a valid number.");
                }
            }catch (InputMismatchException e){
                System.out.println("Please enter a valid number.");
            }
        }while (true);

    }

    private void printMainMenu(){
        ArrayList appliances = new ArrayList();
        appliances.add(oven);
        appliances.add(microwave);
        appliances.add(dishwasher);
        appliances.add(washingMachine);
        appliances.add(cleaningRobot);

        System.out.println("###### MAIN MENU ######");
        for(int i=0;i<appliances.size();i++){
            System.out.println("["+i+"] "+ appliances.get(i).getClass().getName());
        }
        System.out.println("Select an appliance by entering a number: ");
>>>>>>> 6daa2077a3f70ad530ff09c6abd1bc0233174dc4
    }

}
