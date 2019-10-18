public class Player {

    private String name;
    private String color;


    public Player(String name, String color){
        this.color = color;
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public String getColor(){
        return this.color;
    }

}
