public class Die{
    //Die Side
    private int side;

    public Die(){
        //Calls Roll to roll die
        roll();
    }

    public void roll(){
        //Getting Die Side
        side = (int)(Math.random() * 6) + 1;
    }

    public int getSide(){
        //Returns Side of the Die
        return side;
    }

    public String toString()
    {
        return "Die is on side" + side;
    }
}