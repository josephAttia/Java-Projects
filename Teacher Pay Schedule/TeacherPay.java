import java.util.*;
public class TeacherPay {
   public static void main(String[] args) {
      double startingSalary = 0;
      double precentIncrease = 0;
      int numberOfYears = 0;
   
      Scanner sc = new Scanner(System.in);
   
      System.out.print("Enter Starting Salary: ");
      startingSalary = sc.nextInt();
   
      System.out.print("Enter Precent Increase: ");
      precentIncrease = sc.nextInt();
   
      System.out.print("Enter Number of Years: ");
      numberOfYears = sc.nextInt();
   
      if(numberOfYears <= 25 ){
         for(int i = 1; i <= numberOfYears; i++)
         {
            double total = ((startingSalary * (precentIncrease / 100)) + startingSalary);
            startingSalary = total;
            System.out.println("Year #"+ i + " : $" + (int)total); 
         }
      }
      
      if(numberOfYears > 25){
         for(int i = 1; i <= 25; i++)
         {
            double total = ((startingSalary * (precentIncrease / 100)) + startingSalary);
            startingSalary = total;
            System.out.println("Year #"+ i + " : $" + (int)total); 
         }
         for(int c = 25; c <= numberOfYears; c++)
         {
            System.out.println("Year #"+ c + " : $" + (int)startingSalary);
         }
      }
   }
}
