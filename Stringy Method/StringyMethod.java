public class StringyMethod {
   public static int countOccurrences(String sentence, String target) {
      int last = 0;
      int count = 0;
   
      while(last != -1){
      
         last = sentence.indexOf(target,last);
      
         if(last != -1){
            count ++;
            last += target.length();
         }
      }
      return count;
   }
   public static String reverse(String input) {
      String output = "";
   
      for (int i = input.length() - 1; i >= 0; i--) {
         output = output + input.substring(i, i+1);
      }
   
      return output; 
   }
   public static String codeString(String input) {
      String firstLetter = "";
      String secoundLetter = "";
      String result = "";
      for(int i = 0; i < input.length()-1; i+=2){
      
         firstLetter = input.substring(i, i+1);
         secoundLetter = input.substring(i+1, i+2);
         result = result + secoundLetter + firstLetter;
      
      }
      if(input.length() % 2 == 1)
      {
         result += input.substring(input.length()-1, input.length());
      }
      return result;
   }
   public static int countSubstringsStartingWith(String sentence, String target) {
      int count = 0;
      int targetLength = target.length();
      int sentenceLength = sentence.length();
      if (targetLength > sentenceLength) {
         return count;
      }
      int index = sentence.indexOf(target);
      while (index >= 0) {
         count += sentenceLength - (index + targetLength - 1);
         index = sentence.indexOf(target, index + 1);
      }
      return count;
   }

   public static void main(String[] args) {
      System.out.println("Expected: 4");
      System.out.println("  Actual: " + countOccurrences("Miss Mississippi is here!", "is"));
      System.out.println("Expected: 0");
      System.out.println("  Actual: " + countOccurrences("Miss Mississippi is here!", "sips"));
   
      System.out.println("Expected: rebraB .rM");
      System.out.println("  Actual: " + reverse("Mr. Barber"));
      System.out.println("Expected: suoicodilaipxecitsilegarfilacrepus");
      System.out.println("  Actual: " + reverse("supercalifragelisticexpialidocious"));
   
      System.out.println("Expected: abllte");
      System.out.println("  Actual: " + codeString("ballet"));
      System.out.println("Expected: dobdlal");
      System.out.println("  Actual: " + codeString("oddball"));
      System.out.println("Expected: beautiful");
      System.out.println("  Actual: " + codeString(codeString("beautiful")));
   
      System.out.println("Expected: 3");
      System.out.println("  Actual: " + countSubstringsStartingWith("blue", "bl"));
      System.out.println("Expected: 13");
      System.out.println("  Actual: " + countSubstringsStartingWith("bubble", "b"));
      System.out.println("Expected: 11");
      System.out.println("  Actual: " + countSubstringsStartingWith("Miss Mississippi", "si"));

      int x=2;
      int y=x+2;
      int z=y-x;
   if (y > z)
        System.out.print(z);
        if (z < x)
                System.out.print(x);
   else
        if (y > x)
            System.out.print(y);
        else
            System.out.print(z*2);
   System.out.println(x*y*z);
   
   }
}
