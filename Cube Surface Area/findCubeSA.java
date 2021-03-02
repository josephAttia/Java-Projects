import java.util.*;

public class findCubeSA{
   public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
   
      int pieSize = 0;
      int amount = 0;
   
   
      System.out.println("Enter the # or servings of your PIE:");
      pieSize = sc.nextInt();
      
      System.out.println("How much wil you eat:");
      amount = sc.nextInt();
      
      System.out.println("You would eat " + (pieSize / amount) + " servings");
      System.out.print("You Will Have " + (pieSize % amount) + " left over");
   
   
   
   
   
   
   
   }
}