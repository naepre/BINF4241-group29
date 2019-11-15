public class Oven extends Appliance {

    private boolean on;
    private int temperature;
    private Thread timer;
    private String program;
    private boolean cooking;


    public Oven(){
        this.on = false;
        this.temperature = 0;
    }

    public void cmd(int cmdNumber){

        on = switchOn(on);
        temperature = setTemperature();



    }



}
