import java.util.*;
public class TeacherPaySchedule{
   public static void main(String[] args) {

      //Constructing Variables
      double precent = 0;
      int startSalary = 0;
      int years = 0;
   
      //Creating Scanner
      Scanner input = new Scanner(System.in);
      
      //Salary
      System.out.print("Enter the teacher's starting salary: ");
      startSalary = input.nextInt();

      //Precent Increase
      System.out.print("Enter the teacher's salary precent increase: ");
      precent = input.nextInt();
      
      //Number of Years
      System.out.print("Enter the number of years the teacher worked: ");
      years = input.nextInt();
      
      //If Years is under 25
      if(years <= 25 ){
         for(int i = 1; i <= years; i++)
         {
            //Calculating Salary 
            double result = ((startSalary * (precent / 100)) + startSalary);
            startSalary = (int)result;
            System.out.println("Year "+ i + " : $" + (int)result); 
         }
      }
      //If years is above 25
      if(years > 25){
         //Start from 1 to 25
         for(int i = 1; i <= 25; i++)
         {
            double result = ((startSalary * (precent / 100)) + startSalary);
            startSalary = (int)result;
            System.out.println("Year "+ i + " : $" + (int)result); 
         }
         for(int c = 25; c <= years; c++)
         {
            System.out.println("Year "+ c + " : $" + (int)startSalary);
         }
      }
   }
}
