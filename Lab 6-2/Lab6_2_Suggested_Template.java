import java.util.Scanner;

public class Lab6_2_Suggested_Template{
   
   private static void showArray(int[] arrayNum)
   {
      for(int i = 0; i < arrayNum.length; i++){
         if(arrayNum[i] != 0){
            System.out.println(arrayNum[i]);
         }
      }
   }
   
   public static void main(String[] args){
       
      int[] nums = new int[10];
    
      int[] odds = new int[10];
      int[] negatives = new int[10];
      int[] evens = new int[10];
    
    
      Scanner sc = new Scanner(System.in);
   
   
    //Fills Up the Array of Numbers
      for(int i = 0; i < nums.length; i++){
         System.out.print((i+1) + "#:");
         nums[i] = sc.nextInt();
      }
   
   
    //Checks if any of the numbers are even
      for(int i = 0; i <= nums.length -1 ; i++){
         if(nums[i] % 2 == 0 ){
            evens[i] = nums[i];
         }
      
      }   
    
    //Checks if any of the numbers are odd
      for(int i = 0; i <= nums.length -1; i++){
         if(nums[i] % 2 != 0 ){
            odds[i] = nums[i];
         }
      }      
      
    //Checks if any of the numbers are negative
      for(int i = 0; i <= nums.length -1 ; i++){
         if(nums[i] < 0 ){
            negatives[i] = nums[i];
         }
      }      
      
      //Outputs the results
      System.out.println("Odds:");
      showArray(odds);
      System.out.println("Evens:");
      showArray(evens);
      System.out.println("Negatives:");
      showArray(negatives);
   }
}