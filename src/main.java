public class main {
    public static void main(String[] args){



        Player myPlayer = new Player();
        myPlayer.setPlayerName("Bob");

        System.out.println(myPlayer.getPlayerName());

        Dice myDice = new Dice();
        System.out.println(myDice.roll());
        System.out.println(myDice.roll());
        System.out.println(myDice.roll());
        System.out.println(myDice.roll());
        System.out.println(myDice.roll());
        System.out.println(myDice.roll());
    }
}
