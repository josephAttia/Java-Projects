import java.util.Scanner;

public class Lab6_1_SuggestedTemplate{

   private static double getAverage(double[] nums){
      double sum = 0;
    
      for(int i = 0; i < nums.length; i++){
         sum += nums[i];
      }
      return sum / nums.length;
   }
   
   private static void showLargerValues(double[] nums, double avg){
    
    /************
    Write code here to output
    the values larger than the 
    average
    ************/
      String res = "Values Greater Than Average: ";
    
      for(int i = 0; i < nums.length; i++){
         if(nums[i] > avg){
            res = res + nums[i] + "    ";
         }
      }
   
      System.out.print(res);
    
   }
   
   public static void main(String[] args){
      double[] nums = new double[10];
    
    /************
    Write code here to fill the array
    ************/
      Scanner input = new Scanner(System.in);
      
    //Get the Input from the user 
      for(int i = 0; i < nums.length; i++){
         System.out.print((i+1) + "#:");
         nums[i] = input.nextDouble();
      }
    //End
   
      double average = getAverage(nums);
      System.out.println("Average: " + average);
      showLargerValues(nums, average);
   }
}
