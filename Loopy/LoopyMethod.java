/*
Topic: LoopyMethod
Name: Joseph Attia
Date: 11/10/2020
*/
public class LoopyMethod {
    public static void printStars(int num){
        for(int i = 0; i < num; i++){
            System.out.print("* ");
        }
    }

    public static void printMults(int start, int end){
        for(int i = start; i < end; i = i + start){
            System.out.print(i + " ");
        }
    }

    public static int countEs(String string){
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
			if (string.substring(i, i + 1).equals("e") || string.substring(i, i + 1).equals("E") ) {
                count++;
            }
        }
        return count;
    }
     public static void main(String[] args)
  {
      System.out.print("Expected: ");
      System.out.println("* * * * * *");
      System.out.print("  Actual: ");
      printStars(6);
      System.out.println();
      
      System.out.print("Expected: ");
      System.out.println("8 16 24 32 40 48 56 64 72 80 88 96");
      System.out.print("  Actual: ");
      printMults(8, 100);
      System.out.println();
      
      System.out.println("Expected: 4");
      System.out.println("  Actual: " + countEs("Elmer is an elephant."));
      System.out.println("Expected: 3");
      System.out.println("  Actual: " + countEs("Isn't Elastigirl incredible?"));  
      
  }
}

