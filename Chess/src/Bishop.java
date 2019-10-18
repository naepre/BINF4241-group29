public class Bishop extends Figures{

    private String color;
    private int x;
    private int y;

    public Bishop(String color, int x, int y){
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public String getColor(){
        return this.color;
    }

}