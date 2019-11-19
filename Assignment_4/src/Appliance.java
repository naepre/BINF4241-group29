import java.util.Scanner;
import java.util.regex.Pattern;

public class Appliance {



    public boolean switchOn(boolean on){ return true; }

    public boolean switchOff(boolean on){ return false; }

    public int setTemperature(){
        Scanner scanner = new Scanner(System.in);
        int temperature;
        do {
            System.out.println("Please enter a temperature as an integer between 80 - 250 degrees: \n");
            temperature = scanner.nextInt();

        }while(temperature <= 79 || temperature >= 251); //verify true integer.

        return temperature;
    }

    class Timer implements Runnable{

        private boolean running;
        private int time = 0;

        //constructor
        public Timer(){

            Scanner scanner = new Scanner(System.in);
            int timeSelected;
            do {
                System.out.println("Set a time for the timer not lower than 10 seconds [10'000 => 10 sec]: ");
                timeSelected = scanner.nextInt();

            }while(timeSelected < 10000); //verify true integer.

            System.out.println("Timer set to "+ timeSelected + " milliseconds");

            time = timeSelected;
            running = false;
        }

        public boolean isRunning(){
            return  running;
        }

        public void checkTime(){
            if(isRunning()){
                System.out.println("Timer is at: "+ time); //modify after implementing decreasing version timer
            }
            System.out.println("Last set time: "+ time);
        }

        @Override
        public void run() {
            try {
                running = true;
                Thread.sleep(time);
                running = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



}
