import java.util.*;
public class employeeWageCal{

   public static void main(String[] args)
   {
      System.out.println(" Employee Wage Calculator");
      System.out.println("-----Joseph Attia-----");
      System.out.println();
      
      Scanner sc = new Scanner(System.in);
   
      double pay, rHours, oHours, wage;
      
      System.out.print("Enter your hourly wage/pay: "); 
      wage = sc.nextDouble();  
      
      System.out.print("Enter the amount of regualar hours worked: ");
      rHours = sc.nextDouble();
      
      System.out.print("Enter the amount of overtime hours worked: ");
      oHours = sc.nextDouble();
      
      while(wage > 0 && rHours >= 0 && oHours >=0)
      {
         pay = rHours * wage;
         pay = pay + (oHours * (1.5 * wage));
         System.out.print("Your pay for this week is: " + pay); 
         break;
      }

   }

}