public class Pawn extends Figures {

    private String name;
    private String color;
    private int x;
    private int y;

    public Pawn(String name, String color, int x, int y){
        this.name = name;
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public String getName(){
        return this.name;
    }

    public String getColor(){
        return this.color;
    }

}
