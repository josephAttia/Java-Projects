public class HorseDriver {
   public static void main(String[] args) {
      Horse h1 = new Horse(1, 1);
      Horse h2 = new Horse(1, 2);
      Horse h3 = new Horse(1, 3);
   
      System.out.println(h1); 
      System.out.println(h2); 
      System.out.println(h3); 
      System.out.println(); 
      
      while(h1.getLocation() != 15 && h2.getLocation() != 15 && h3.getLocation() != 15){
         h1.horseStride();
         System.out.println(h1); 
         h2.horseStride();
         System.out.println(h2);
         h3.horseStride();
         System.out.println(h3);  
         System.out.println();
      } 
   
      //This is for the tie
      if(h1.getLocation() == 15){
         System.out.println("Horse 1 won the race");
      }
      if(h2.getLocation() == 15){
         System.out.println("Horse 2 won the race");
      }
      if(h3.getLocation() == 15){
         System.out.println("Horse 3 won the race");
      }
   }
}
