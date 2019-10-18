public class Dice {

    public int roll()
    {
        int SIDES = 6;
        int outcome = (int) (Math.random() * SIDES) + 1;
        return outcome;
    }

}
