public class Bottle
{
   // data fields
   private String color;
   private int volume;  // ounces
   
   // constructors
   public Bottle()
   {
      color = "Clear";
      volume = 8;
   }
   
   public Bottle(String col, int vol)
   {
      color = col;
      volume = vol;
   }

   
   // getter methods
   public String getColr()
   {
      return color;
   }
   
   public int getNumberOfOunces()
   {
      return volume;
   }
   
   public String toString()
   {
      return "The " + color + " bottle has a capacity of " + volume + " ounces.";
   }
}