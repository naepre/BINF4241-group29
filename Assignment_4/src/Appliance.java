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



}
