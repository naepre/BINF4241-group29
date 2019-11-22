import java.util.ArrayList;
import java.util.Scanner;

public class CleaningRobot extends Appliance {

    private boolean on;
    private AutomaticTimer battery;
    private boolean atBase;
    private AutomaticTimer cleaningPart;
    private Timer timer;

    public CleaningRobot(){
        this.on = false;
        battery = new AutomaticTimer(7200 * 1000);
        this.atBase = true;
        this.cleaningPart = null;
        this.timer = null;
    }

    public void cmd(int cmdNumber) {

        switch(cmdNumber){
            case 0:
                if(!on){
                    //Switch on the cleaning robot on
                    on = switchOn(on);
                    System.out.println("Cleaning robot switched on. \n");
                }else {
                    if(atBase == true){
                        timer = new Timer();
                    }
                    else {
                        System.out.println("Please wait for the machine to finish its current cleaning or interrupt it!");
                    }
                }
                break;
            case 1:
                if (atBase == true && battery == new AutomaticTimer(7200 * 1000)) {
                    //Start cleaning robot
                    cleaningPart = new AutomaticTimer(10800 * 1000);
                    atBase = false;
                    battery.run();
                    timer.run();
                    atBase = true;
                    cleaningPart.run();
                } else if (atBase == false){
                    System.out.println("The device is already running! ");
                } else {
                    System.out.println("The Battery is not fully charged yet! Please wait for it to charge up!");
                }
                break;
            case 2:
                //Check the cleaning completion
                cleaningPart.checkPercentageRoom();
                break;
            case 3:
                //check battery status
                battery.checkPercentageCleaningRobot();
                break;
            case 4:
                //Complete outside cleaning
                if (atBase == true && battery == new AutomaticTimer(7200 * 1000) && cleaningPart != new AutomaticTimer(0)) {
                    atBase = false;
                    battery.run();
                    timer.run();
                    atBase = true;
                    cleaningPart.run();
                } else if (atBase == false){
                    System.out.println("The device is already running! ");
                } else if (cleaningPart == new AutomaticTimer(0)){
                    System.out.println("The room is already cleaned.");
                } else {
                    System.out.println("The Battery is not fully charged yet! Please wait for it to charge up!");
                }
                break;
            case 5:
                //Interrupt the program
                if (battery.isRunning() && atBase == false) {
                    //pause the timer?
                    atBase = true;
                } else {
                    System.out.println("The cleaning robot is not yet cleaning!");
                }
                break;
            //Interrupt Cleaning
            case 6:
                // turn robot off
                this.on = false;
                this.timer = null;
                this.cleaningPart = null;
                this.atBase = true;
                on = switchOff(on);
                System.out.println("Robot switched off. \n");
                break;
        }
        getCleaningRobotSubMenu();
    }

    public void getCleaningRobotSubMenu(){

        ArrayList cleaningrobotSubMenu = new ArrayList();

        if(!on){
            cleaningrobotSubMenu.add("Turn cleaning robot On");
        }else {
            cleaningrobotSubMenu.add("set timer");
            cleaningrobotSubMenu.add("start cleaning");
            cleaningrobotSubMenu.add("check percentage of cleaning completion");
            cleaningrobotSubMenu.add("check battery status (off and on docking station)");
            cleaningrobotSubMenu.add("finish outside cleaning");
            cleaningrobotSubMenu.add("interrupt cleaning");
            cleaningrobotSubMenu.add("turn off");
        }


        System.out.println("###### CLEANING BOT ######");
        for(int i = 0; i< cleaningrobotSubMenu.size();i++){
            System.out.println("["+i+"] "+ cleaningrobotSubMenu.get(i));
        }
        System.out.println("[9] Main menu");
        System.out.println("Select an action by entering a number: ");
    }

}