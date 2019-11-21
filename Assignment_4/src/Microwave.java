import java.util.ArrayList;

public class Microwave extends Appliance {

    private boolean on;
    private int temperature;
    private Timer timer;
    private boolean baking;


    public Microwave() {
        this.on = false;
        this.temperature = 0;
        this.timer = null;
        this.baking = false;
    }


    public void cmd(int cmdNumber) {

        switch (cmdNumber) {
            case 0:
                if (!on) {
                    //Switch on the oven
                    on = switchOn(on);
                    System.out.println("Microwave switched on. \n");
                } else {
                    timer = new Timer();
                }
                break;
            case 1:
                temperature = setTemperature();
                break;
            case 2:
                if (temperature != 0 && timer != null) {
                    baking = true;
                    System.out.println("The Microwave is baking...\n ");
                    timer.run();
                    System.out.println("The Microwave has completed baking! \n");
                } else {
                    System.out.println("Please first set a timer, a temperature!\n");
                }
                break;
            case 3:
                if (baking) {
                    timer.checkTime();

                } else {
                    System.out.println("The timer is set to:" + timer + "seconds");
                }
                break;
            case 4:
                //Interrupt the program
                if (timer.isRunning() && baking) {
                    baking = false;
                } else {
                    System.out.println("The Microwave is not yet baking!\n");
                }
                break;
            case 5:
                // Switch off the oven
                this.on = false;
                this.temperature = 0;
                //***timer ???
                this.baking = false;
                System.out.println("Microwave switched off \n");
                break;
        }
        getMicrowaveSubMenu();
    }

    public void getMicrowaveSubMenu(){

        ArrayList microwaveSubMenu = new ArrayList();

        if (!on) {
            microwaveSubMenu.add("Turn Microwave on");
        } else {
            microwaveSubMenu.add("set timer");
            microwaveSubMenu.add("set temperature");
            microwaveSubMenu.add("start baking");
            microwaveSubMenu.add("check timer");
            microwaveSubMenu.add("interrupt baking");
            microwaveSubMenu.add("Turn Microwave off");
        }

        System.out.println("###### Microwave ######");
        for(int i = 0; i< microwaveSubMenu.size();i++){
            System.out.println("["+i+"] "+microwaveSubMenu.get(i));
        }
        System.out.println("[9] Main menu");
        System.out.println("Select an action by entering a number: ");
    }

}