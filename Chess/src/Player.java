import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    private String name;
    private char color;


    public Player(String name, char color){
        this.color = color;
        this.name = name;
    }



    public String getName(){
        return this.name;
    }

    public char getColor(){
        return this.color;
    }



}
