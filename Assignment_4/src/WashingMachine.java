import java.util.ArrayList;
import java.util.Scanner;

public class WashingMachine extends Appliance{

    private boolean on;
    private int degree;
    private AutomaticTimer automaticTimer;
    private enum Program {
        None,
        Double_Rinse,
        Intense,
        Quick,
        Spin
    }
    private Program program;
    private boolean washing;


    public WashingMachine(){
        this.on = false;
        this.degree = 0;
        this.automaticTimer = null;
        program = Program.None;
        this.washing = false;
    }


    private void setProgram(){
        Scanner scanner = new Scanner(System.in);
        int programSelected;
        do {
            System.out.println("Set a program by specifying the program number:");
            System.out.println("[1] Double Rinse");
            System.out.println("[2] Intense");
            System.out.println("[3] Quick");
            System.out.println("[4] Spin");
            programSelected = scanner.nextInt();

        }while(programSelected < 1 || programSelected > 4); //verify true integer.

        if(programSelected == 1){
            program = Program.Double_Rinse;
            automaticTimer = new AutomaticTimer(7200 * 1000);
        }else if(programSelected == 2){
            program = Program.Intense;
            automaticTimer = new AutomaticTimer(9000 * 1000);
        }else if(programSelected == 3){
            program = Program.Quick;
            automaticTimer = new AutomaticTimer(3600 * 1000);
        }else if(programSelected == 4){
            program = Program.Spin;
            automaticTimer = new AutomaticTimer(2400 * 1000);
        }
        System.out.println("Washing machine program set to "+ program +"\n");
    }


    public void cmd(int cmdNumber) {
        switch (cmdNumber){
            case 0:
                if(!on){
                    //Switch on the oven
                    on = switchOn(on);
                    System.out.println("Washing Machine switched on. \n");
                }else {
                    degree = setDegree();
                }
                break;
            case 1:
                //Set washing machine program
                if (washing == false) {
                    setProgram();
                }
                else {
                    System.out.println("Please wait for the machine to finish its current program!");
                }
                break;
            case 2:
                // start washing
                if (program != WashingMachine.Program.None &&  degree != 0) {
                    washing = true;
                    automaticTimer.run();
                } else {
                    System.out.println("You cannot start the program yet, please select a program! ");
                }
                break;

            case 3:
                //Check the timer
                if (washing) {
                    automaticTimer.checkTime();
                } else {
                    System.out.println("The timer is set to: " + automaticTimer + " seconds");
                }
                break;

            case 4:
                //Interrupt the program
                if (automaticTimer.isRunning() && washing) {
                    //pause the timer?
                    washing = false;
                } else {
                    System.out.println("The washing machine is not yet washing!");
                }
                break;
            case 5:
                //Switch off the dishwasher
                this.on = false;
                //this.timer = null;
                program = Program.None;
                this.washing = false;
                on = switchOff(on);
                System.out.println("Washing machine switched off. \n");
                break;
        }

        getWashingMachineSubMenu();
    }


    //prepare washing machine sub menu based on washing machine current state
    public void getWashingMachineSubMenu(){

        ArrayList washingMachineSubMenu = new ArrayList();

        if(!on){
            washingMachineSubMenu.add("Turn washing machine on"); //!!!
        }else {
            washingMachineSubMenu.add("set degrees");
            washingMachineSubMenu.add("set program");
            washingMachineSubMenu.add("start washing");
            washingMachineSubMenu.add("check timer");
            washingMachineSubMenu.add("interrupt washing"); // change!
            washingMachineSubMenu.add("Turn washing machine off");
        }


        System.out.println("###### WASHING MACHINE ######");
        for(int i = 0; i< washingMachineSubMenu.size();i++){
            System.out.println("["+i+"] "+washingMachineSubMenu.get(i));
        }
        System.out.println("[9] Main menu");
        System.out.println("Select an action by entering a number: ");

    }

}