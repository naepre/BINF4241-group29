import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;

public class Microwave extends Appliance {

        private boolean on;
        private int temperature;
        private Timer timer;


        private boolean cooking;

        private int submenu;

        public Microwave() {
            this.on = false;
            this.temperature = 0;
            this.timer = null;
            this.cooking = false;
        }


        public void cmd(int cmdNumber) {

            if (cmdNumber == -1) {
                ArrayList submenu = prepareMicrowaveSubMenu();
                System.out.println("###### Microwave ######");
                for (int i = 0; i < submenu.size(); i++) {
                    System.out.println("[" + i + "]" + submenu.get(i));
                }
            } else if (cmdNumber == 0) {
                //Turn microwave on
                on = switchOn(on);
            } else {
                if (cmdNumber == 0) {
                    //Set microwave timer
                    timer = new Timer();
                } else if (cmdNumber == 1) {
                    //Set microwave temperature
                    temperature = setTemperature();
                } else if (cmdNumber == 2) {
                    if (temperature != 0 && timer != null) {
                        //Start microwave cooking
                        cooking = true;
                        timer.run();
                    } else {
                        System.out.println("You cannot start the program yet, please set a timer, a temperature and select a program! ");
                    }
                } else if (cmdNumber == 3) {
                    //Check the timer
                    if (cooking) {
                        timer.checkTime();
                    } else {
                        System.out.println("The timer is set to: " + timer + " seconds");
                    }
                } else if (cmdNumber == 4) {
                    //Interrupt the program
                    if (timer.isRunning() && cooking) {
                        //pause the timer?
                        cooking = false;
                    } else {
                        System.out.println("The microwave is not yet cooking!");
                    }
                } else if (cmdNumber == 5) {
                    //Switch off the microwave
                    on = switchOff(on);
                }
            }

        }

        //prepare microwave sub menu based on microwave current state
        private ArrayList prepareMicrowaveSubMenu() {

            ArrayList microwaveSubMenu = new ArrayList();

            if (!on) {
                microwaveSubMenu.add("on"); //!!!
            } else {
                microwaveSubMenu.add("set timer");
                microwaveSubMenu.add("set temperature");
                microwaveSubMenu.add("start cooking");
                microwaveSubMenu.add("check timer");
                microwaveSubMenu.add("interrupt cooking");
                microwaveSubMenu.add("off");
            }

            return microwaveSubMenu;
        }
    }

