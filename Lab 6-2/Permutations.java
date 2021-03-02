import java.util.*;
import java.io.*;
public class Permutations{

   public static void show(int[] array){
      System.out.println("Here is your shuffled array:");
      for(int i = 0; i < array.length; i++){
         System.out.print(array[i] +" ");
      }
   }

   public static void swap(int[] array, int a, int b){
      int temp = array[a];
      array[a] = array[b];
      array[b] = temp;
   }
   public static boolean isShuffled(int[] array) {
      boolean result = false;
      int shuffledInt = 0;
      for(int i = 0; i < array.length; i++){
         if(array[i] == i + 1){
            shuffledInt++;
         }
      }
      if(shuffledInt == array.length){
         result = true;
      }
      else{
         result = false;
      }
   
      return result;
   }

   public static void main(String[] args){
   
      Scanner input = new Scanner(System.in);
      int n = 0;
      int playAgain = 1;
      while(playAgain == 1){
         while(n < 5 || n > 20){
            System.out.println("How many elements (5-20) would you like to shuffle?");
            n = input.nextInt();
         }
      
         int[] array = new int[n];
      
         //Sets the array with {1, 2, 3, 4......n}
         for(int i = 0; i < array.length; i++)
         {
            array[i] = i + 1;
         }
      
         //Suffle the array
         for(int i = 0; i < (n * 10000); n++){
            int x = (int)(Math.random() * (array.length - 1));
            int y = (int)(Math.random() * (array.length - 1));
            int temp = array[x];
            array[x] = array[y];
            array[y] = temp;
         }
         n = array.length;
         int a = (2 * n) - 3;
         while(a > 0 && !isShuffled(array)){
            show(array);
            System.out.println();
            System.out.println("You have "+a+" turns remaining\nEnter # of elements (2 - "+n+") to reverse:");
            int c = input.nextInt();
            if(c <= n && c >= 2){
               for(int d = 0; d < c / 2; d++){
                  int temp2 = array[d];
                  array[d] = array[c-1-d];
                  array[c-1-d] = temp2;
                  a--;
               }
            }
            else{
            show(array);
            System.out.println();
            System.out.println("You have "+a+" turns remaining\nEnter # of elements (2 - "+n+") to reverse:");
            c = input.nextInt();
            }
         }

         while(a > 0 && isShuffled(array)){
            show(array);
            System.out.println();
            System.out.print("Congrats You Won!");
            System.out.print("Would you like to play again? \n Enter 1 for yes \n Enter 2 for no \n :");
            playAgain = input.nextInt();
            break;
         }
         while(a <= 0 && !isShuffled(array)){
            show(array);
            System.out.println();
            System.out.print("Sorry, you're out of moves.");
            System.out.print("Would you like to play again? \n Enter 1 for yes \n Enter 2 for no \n :");
            playAgain = input.nextInt();
            break;
         }
      }
   }
}