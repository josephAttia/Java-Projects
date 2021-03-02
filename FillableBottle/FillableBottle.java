public class FillableBottle
{
   // data fields
   private String color;
   private int volume;  // ounces that the bottle can hold
   private int currentlyContains;   // ounces currently in the bottle
   
   // constructors
   public FillableBottle()
   {
      color = "Clear";
      volume = 8;
      currentlyContains = 0;
   }
   
   public FillableBottle(String col, int vol)
   {
      color = col;
      volume = vol;
      currentlyContains = 0;
   }

   // getter or "accessor" methods
   public String getColor()
   {
      return color;
   }
   
   public int getVolume()
   {
      return volume;
   }
   
   public int getCurrentlyContains()
   {
      return currentlyContains;
   }
   
   //setter or "mutator" methods
   
   // adds to the contents of the bottle without overflowing
   public void add(int ounces)
   {
      int temp = ounces + currentlyContains;
      if (temp > volume)
         currentlyContains = volume;
      else
         currentlyContains = temp;
   }
   
   // Removes a random amount of ounces from the bottle
   // and returns the number of ounces removed
   public int remove()
   {
      int x = (int)(Math.random()*currentlyContains);
      currentlyContains = currentlyContains - x;
      return x;
   }
   
   // returns a String representing this particular object
   public String toString()
   {
      String str = "";
      str = "The " + color + " bottle contains:\n\t" + currentlyContains;
      str +=  " ounces and has a capacity of " + volume + " ounces.";
      return str;
   }
}