
public class Main {

    public static void main(String[] args){

        Player player1 = new Player("Alice", "white");
        Player player2 = new Player("Bob", "black");

        System.out.println(player1.getName());
        System.out.println(player1.getColor());




        Game game = new Game();

        String eightA = game.getField(0,0);
        System.out.println(eightA);
        Object rook = game.getFigureAtSpace(eightA);
        System.out.println(rook);
    }

}
