public class LoopyDeLoop {
   public static void  printStars(int n){
      for(int i = 1; i <= n; i++)
      {
         for(int j = 1; j <= i; j++)
         {
            System.out.print("*" + " ");
         }
         System.out.println("");
      }
   }
   public static void  printStarsInSpace(int n){
      for(int i=0; i<n; i++) 
      { 
         for(int j = 2 * (n-i); j >= 0; j--) 
         {           
            System.out.print(" "); 
         } 
         for(int j = 0; j<=i; j++) 
         {       
            System.out.print("* "); 
         }           
         System.out.println();
      } 
   }
   public static void printStarsVictory(int n) {
      n--;
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < n*2; j++) {
            if (j <= i || j >= n*2-i) {
               System.out.print("*");
            } 
            else
            {
               System.out.print(" ");
            } 
         }
         System.out.println();
      }
   }
   public static void main(String[] args) {
      System.out.println("Print Stars Method");
      printStars(10);
      System.out.println("Print Stars In Space Method");
      printStarsInSpace(10);
      System.out.println("Print Stars Victory Method");
      printStarsVictory(9);
   }   
}
