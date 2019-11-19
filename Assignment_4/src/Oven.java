import java.util.ArrayList;
import java.util.Scanner;

public class Oven extends Appliance {

    private boolean on;
    private int temperature;
    private Timer timer;
    private enum Program {
        None,
        Grill,
        Ventilated,
        Defrost
    }
    private Program program;
    private boolean cooking;

    private int submenu;

    public Oven(){
        this.on = false;
        this.temperature = 0;
        this.timer = null;
        program = Program.None;
        this.cooking = false;
        this.submenu = 1;
    }


    private void setProgram(){
        Scanner scanner = new Scanner(System.in);
        int programSelected;
        do {
            System.out.println("Set a program by specifying the program number:");
            System.out.println("[1] Grill");
            System.out.println("[2] Ventilated");
            System.out.println("[3] Defrost");
            programSelected = scanner.nextInt();

        }while(programSelected < 1 || programSelected > 3); //verify true integer.

        if(programSelected == 1){
            program = Program.Grill;
        }else if(programSelected == 2){
            program = Program.Ventilated;
        }else if(programSelected == 3){
            program = Program.Defrost;
        }
        System.out.println("Oven program set to "+ program);
    }


    public void cmd(int cmdNumber){

        if(cmdNumber == -1){
            ArrayList submenu = prepareOvenSubMenu();
            System.out.println("###### OVEN ######");
            for(int i = 0; i< submenu.size();i++){
                System.out.println("["+i+"]"+submenu.get(i));
            }
        }else if(submenu == 1){
            if(cmdNumber == 0){
                //Turn oven on
                on = switchOn(on);
            }
        }else if(submenu == 2){
            if(cmdNumber == 0){
                //Set oven temperature
                temperature = setTemperature();
            }else if(cmdNumber == 1){
                //Set oven program
                setProgram();
            }else if(cmdNumber == 2){
                //Set oven timer
                timer = new Timer();
            }else if(cmdNumber == 3){
                //Switch off the oven
                on = switchOff(on);
            }
        }else if(submenu == 3){
            if(cmdNumber == 0){
                //Set oven temperature
                temperature = setTemperature();
            }else if(cmdNumber == 1){
                //Set oven program
                setProgram();
            }else if(cmdNumber == 2){
                //Set oven timer
                timer = new Timer();
            }else if(cmdNumber == 3){
                //Start oven cooking
                cooking = true;
                timer.run();
            }else if(cmdNumber == 4){
                //Switch off the oven
                on = switchOff(on);
            }
        }else if(submenu == 4){
            if(cmdNumber == 0){
                //Check the timer
                if(cooking){
                    timer.checkTime();
                }
            }else if(cmdNumber == 1){
                //Interrupt the program
                if(timer.isRunning() && cooking){
                    //pause the timer?
                    cooking = false;
                }
            }else if(cmdNumber == 2){
                //Switch off the oven
                on = switchOff(on);
            }
        }
    }

    //prepare oven sub menu based on oven current state
    private ArrayList prepareOvenSubMenu(){

        ArrayList ovenSubMenu = new ArrayList();

        if(!on){
            submenu = 1;
            ovenSubMenu.add("on"); //!!!
        }else if(on && temperature == 0 || program == Program.None || timer == null){
            submenu = 2;
            ovenSubMenu.add("set temperature");
            ovenSubMenu.add("set program");
            ovenSubMenu.add("set timer");
            ovenSubMenu.add("off");
        }else if(on && temperature != 0 && program != Program.None && timer != null && !cooking){
            submenu = 3;
            ovenSubMenu.add("set temperature");
            ovenSubMenu.add("set program");
            ovenSubMenu.add("set timer");
            ovenSubMenu.add("start cooking");
            ovenSubMenu.add("off");
        }else if(cooking){
            submenu = 4;
            ovenSubMenu.add("check timer");
            ovenSubMenu.add("interrupt cooking");
            ovenSubMenu.add("off");
        }

        return ovenSubMenu;
    }

}
