import java.util.ArrayList;
import java.util.Scanner;

public class Oven extends Appliance {

    private boolean on;
    private int temperature;
    private Timer timer;
    private Thread thread;
    private enum Program {
        None,
        Grill,
        Ventilated,
        Defrost
    }
    private Program program;
    private boolean cooking;


    public Oven(){
        this.on = false;
        this.temperature = 0;
        this.timer = null;
        program = Program.None;
        this.cooking = false;
    }


    public void setProgram(){
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
        System.out.println("Oven program set to "+ program +"\n");
    }


    public void cmd(int cmdNumber){

        switch (cmdNumber){
            case 0:
                if(!on){
                    //Switch on the oven
                    on = switchOn(on);
                    System.out.println("Oven switched on. \n");
                }else {
                    if(cooking != true){
                        timer = new Timer();
                        thread = new Thread(timer);
                    }else{
                        System.out.println("Please wait for the machine to finish its current program or interrupt it!\n");
                    }
                }
                break;
            case 1:
                temperature = setTemperature();
                break;
            case 2:
                if (cooking == false) {
                    setProgram();
                } else {
                    System.out.println("Please wait for the machine to finish its current program or interrupt it!\n");
                }
                break;
            case 3:
                //start cooking
                if(temperature != 0 && timer != null && program != Program.None) {
                    cooking = true;
                    thread.start();
                    System.out.println("The oven is cooking...\n");

                    //this.cooking = false; //Need to think about
                    //System.out.println("The oven has completed cooking!\n"); //Need to think about
                } else {
                    System.out.println("Please first set a timer, a temperature and select a program!\n");
                }
                break;
            case 4:
                //check timer
                if(cooking){
                    timer.checkTime();
                } else{
                    System.out.println("The timer is set to: " + timer + " seconds");
                }
                break;
            case 5:
                //Interrupt the program
                //if (timer.isRunning() && cooking) {
                if(thread.isAlive() && cooking){
                    //interrupt the timer?
                    thread.interrupt();
                    cooking = false;
                } else {
                    System.out.println("The oven is not yet cooking!\n");
                }
                break;
            case 6:
                //Switch off the oven
                this.on = false;
                this.temperature = 0;
                //this.timer = null;
                program = Program.None;
                this.cooking = false;
                on = switchOff(on);
                System.out.println("Oven switched off. \n");
                break;
        }

        getOvenSubMenu();
    }


    //prepare oven sub menu based on oven current state
    public void getOvenSubMenu(){

        ArrayList ovenSubMenu = new ArrayList();

        if(!on){
            ovenSubMenu.add("Turn Oven On");
        }else {
            ovenSubMenu.add("set timer");
            ovenSubMenu.add("set temperature");
            ovenSubMenu.add("set program");
            ovenSubMenu.add("start cooking");
            ovenSubMenu.add("check timer");
            ovenSubMenu.add("interrupt cooking");
            ovenSubMenu.add("Turn Oven Off");
        }

        System.out.println("###### OVEN ######");
        for(int i = 0; i< ovenSubMenu.size();i++){
            System.out.println("["+i+"] "+ovenSubMenu.get(i));
        }
        System.out.println("[9] Main menu");
        System.out.println("Select an action by entering a number: ");

    }

}
