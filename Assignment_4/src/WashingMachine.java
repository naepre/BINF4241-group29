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
        private WashingMachine.Program program;
        private boolean washing;

        private int submenu;

        public WashingMachine(){
            this.on = false;
            this.automaticTimer = null;
            program = WashingMachine.Program.None;
            this.washing = false;
            this.degree = 0;
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
            System.out.println("Washing machine program set to "+ program);
        }


        public void cmd(int cmdNumber) {

            if (cmdNumber == -1) {
                ArrayList submenu = prepareWashingMachineSubMenu();
                System.out.println("###### Washing Machine ######");
                for (int i = 0; i < submenu.size(); i++) {
                    System.out.println("[" + i + "]" + submenu.get(i));
                }
            } else if (cmdNumber == 0) {
                //Turn washing machine on
                on = switchOn(on);
            } else {
                if (cmdNumber == 0) {
                   degree = setDegree();
                }
                else if (cmdNumber == 1) {
                    //Set washing machine program
                    if (washing == false) {
                        setProgram();
                    }
                    else {
                        System.out.println("Please wait for the machine finishing its current program!");
                    }
                } else if (cmdNumber == 2) {
                    if (program != WashingMachine.Program.None &&  degree != 0) {
                        //Start washing machine washing
                        washing = true;
                        automaticTimer.run();
                    } else {
                        System.out.println("You cannot start the program yet, please select a program! ");
                    }
                } else if (cmdNumber == 3) {
                    //Check the timer
                    if (washing) {
                        automaticTimer.checkTime();
                    } else {
                        System.out.println("The timer is set to: " + automaticTimer + " seconds");
                    }
                } else if (cmdNumber == 4) {
                    //Interrupt the program
                    if (automaticTimer.isRunning() && washing) {
                        //pause the timer?
                        washing = false;
                    } else {
                        System.out.println("The washing machine is not yet washing!");
                    }
                } else if (cmdNumber == 5) {
                    //Switch off the washing machine
                    on = switchOff(on);
                }
            }
        }

        //prepare washing machine sub menu based on washing machine current state
        private ArrayList prepareWashingMachineSubMenu(){

            ArrayList washingMachineSubMenu = new ArrayList();

            if(!on){
                washingMachineSubMenu.add("on"); //!!!
            }else {
                washingMachineSubMenu.add("set program");
                washingMachineSubMenu.add("start washing");
                washingMachineSubMenu.add("check timer");
                washingMachineSubMenu.add("interrupt washing"); // change!
                washingMachineSubMenu.add("off");
            }

            return washingMachineSubMenu;
        }

}

