public class FillableBottleDriver 
{
   public static void main(String[] args)
   {
      //Make Bottles
      FillableBottle b1 = new FillableBottle();
      FillableBottle b2 = new FillableBottle("Blue", 15);
      
      //Current State
      System.out.println(b1.toString());
      System.out.println(b2.toString());
   
      //Adding
      b1.add(12);
      b2.add(12);
   
      System.out.println();
      System.out.println("Adding.....");
      System.out.println();
   
      //Current State
      System.out.println(b1.toString());
      System.out.println(b2.toString());
      
      //Removing
      System.out.println();
      System.out.println("Removing.....");
      System.out.println("Removed " + b2.remove() + " ounces from the blue bottle");
      System.out.println();
      
      //Current State
      System.out.println(b1.toString());
      System.out.println(b2.toString());
     
   }

}