import java.util.ArrayList;
import java.util.Scanner;

public class Dishwasher extends Appliance{
    private boolean on;
    private AutomaticTimer automaticTimer;
    private enum Program {
        None,
        Glasses,
        Plates,
        Pans,
        Mixed
    }
    private Dishwasher.Program program;
    private boolean washing;

    private int submenu;

    public Dishwasher(){
        this.on = false;
        this.automaticTimer = null;
        program = Dishwasher.Program.None;
        this.washing = false;
    }


    private void setProgram(){
        Scanner scanner = new Scanner(System.in);
        int programSelected;
        do {
            System.out.println("Set a program by specifying the program number:");
            System.out.println("[1] Glasses");
            System.out.println("[2] Plates");
            System.out.println("[3] Pans");
            System.out.println("[4] Mixed");
            programSelected = scanner.nextInt();

        }while(programSelected < 1 || programSelected > 4); //verify true integer.

        if(programSelected == 1){
            program = Program.Glasses;
            automaticTimer = new AutomaticTimer(2400 * 1000);
        }else if(programSelected == 2){
            program = Program.Plates;
            automaticTimer = new AutomaticTimer(3600 * 1000);
        }else if(programSelected == 3){
            program = Program.Pans;
            automaticTimer = new AutomaticTimer(4800 * 1000);
        }else if(programSelected == 4){
            program = Program.Mixed;
            automaticTimer = new AutomaticTimer(5400 * 1000);
        }
        System.out.println("Dishwasher program set to "+ program);
    }


    public void cmd(int cmdNumber) {

        if (cmdNumber == -1) {
            ArrayList submenu = prepareDishwasherSubMenu();
            System.out.println("###### Dishwasher ######");
            for (int i = 0; i < submenu.size(); i++) {
                System.out.println("[" + i + "]" + submenu.get(i));
            }
        } else if (cmdNumber == 0) {
            //Turn dishwasher on
            on = switchOn(on);
        } else {
            if (cmdNumber == 0) {
                //Set dishwasher program
                if (washing == false) {
                    setProgram();
                }
                else {
                    System.out.println("Please wait for the machine finishing its current program or interrupt it!");
                }
            } else if (cmdNumber == 1) {
                if (program != Dishwasher.Program.None) {
                    //Start dishwasher washing
                    washing = true;
                    automaticTimer.run();
                } else {
                    System.out.println("You cannot start the program yet, please select a program! ");
                }
            } else if (cmdNumber == 2) {
                //Check the timer
                if (washing) {
                    automaticTimer.checkTime();
                } else {
                    System.out.println("The timer is set to: " + automaticTimer + " seconds");
                }
            } else if (cmdNumber == 3) {
                //Interrupt the program
                if (automaticTimer.isRunning() && washing) {
                    //pause the timer?
                    washing = false;
                } else {
                    System.out.println("The dishwasher is not yet washing!");
                }
            } else if (cmdNumber == 4) {
                //Switch off the dishwasher
                on = switchOff(on);
            }
        }
    }

    //prepare dishwasher sub menu based on dishwasher current state
    private ArrayList prepareDishwasherSubMenu(){

        ArrayList dishwasherSubMenu = new ArrayList();

        if(!on){
            dishwasherSubMenu.add("on"); //!!!
        }else {
            dishwasherSubMenu.add("set program");
            dishwasherSubMenu.add("start washing");
            dishwasherSubMenu.add("check timer");
            dishwasherSubMenu.add("interrupt washing");
            dishwasherSubMenu.add("off");
        }

        return dishwasherSubMenu;
    }

}
