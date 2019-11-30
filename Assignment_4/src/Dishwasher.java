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
        System.out.println("Dishwasher program set to "+ program + "\n");
    }


    public void cmd(int cmdNumber) {

        switch(cmdNumber){
            case 0:
                if(!on){
                    //Switch on the dishwasher on
                    on = switchOn(on);
                    System.out.println("Dishwasher switched on. \n");
                }else {
                    //Set dishwasher program
                    if (washing == false) {
                        setProgram();
                    }
                    else {
                        System.out.println("Please wait for the machine to finish current program or interrupt it!");
                    }
                }
                break;
            case 1:
                if (program != Dishwasher.Program.None) {
                    //Start dishwasher washing
                    washing = true;
                    automaticTimer.run();
                } else {
                    System.out.println("You cannot start the program yet, please select a program! ");
                }
                break;
            case 2:
                //Check the timer
                if (washing) {
                    automaticTimer.checkTime();
                } else {
                    System.out.println("The timer is set to: " + automaticTimer + " seconds");
                }
                break;
            case 3:
                //Interrupt the program
                if (automaticTimer.isRunning() && washing) {
                    //pause the timer?
                    washing = false;
                } else {
                    System.out.println("The dishwasher is not yet washing!");
                }
                break;
            case 4:
                //Switch off the dishwasher
                this.on = false;
                //this.timer = null;
                program = Program.None;
                this.washing = false;
                on = switchOff(on);
                System.out.println("Dishwasher switched off. \n");
                break;
        }
        getDishwasherSubMenu();
    }


    public void getDishwasherSubMenu(){

        ArrayList dishwasherSubMenu = new ArrayList();

        if(!on){
            dishwasherSubMenu.add("Turn dishwasher On");
        }else {
            dishwasherSubMenu.add("set program");
            dishwasherSubMenu.add("start washing");
            dishwasherSubMenu.add("check timer");
            dishwasherSubMenu.add("interrupt washing");
            dishwasherSubMenu.add("Turn dishwasher off");
        }


        System.out.println("###### DISH WASHER ######");
        for(int i = 0; i< dishwasherSubMenu.size();i++){
            System.out.println("["+i+"] "+dishwasherSubMenu.get(i));
        }
        System.out.println("[9] Main menu");
        System.out.println("Select an action by entering a number: ");
    }

}
