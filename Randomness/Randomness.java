public class Randomness
{
   public static void main(String[] args)
   {
      // This is the original string
      String randomString = "Will it work?";
      // TODO 1. print out the original string
      System.out.println( "Original: "+ randomString);

      // TODO 2. call the randomStar method
      String modified = randomStar(randomString);

      // TODO 3. print out the modified string
     System.out.println("Modified: "+modified);
      
      // TODO 4. print out the location of the "*" in the modified string
      System.out.println("Star is at location: " + modified.indexOf("*"));

   }
   
   // TODO 5. randomStar method
   // Write the randomStar method here (be sure to make it static)
   // It should accept a String as input and produce a String for output
   // The new String should NOT be printed in this method.
   // The method will generate a random number.
   // The number generated should be a valid index in the input String
   // The produced String should match the input with one exception:
   // The character at the random index should be a *.
   // start by writing the method Header here
   public static String randomStar(String randomString)
   {
      // generate an appropriate random number here. What should the bounds be?
      int randomIndex = (int)(Math.random() * (randomString.length())); 
      // print out the random number in the proper format
      // (random is: n)
      System.out.println("Random is: " + randomIndex);
      
      
      // print out a line indicating what is changing in the proper format
      // (changing "a" to "*")  
      System.out.println("Changing"  + " \"" + randomString.substring(randomIndex, randomIndex+1) + "\" "  + "to: \"*\"");
      
      // build the new String here
      String newString = new String();

      newString =  (randomString.substring(0, randomIndex)) + "*" +  (randomString.substring(randomIndex + 1, randomString.length()));
      
      // send the new String back to the caller
      return newString;
   }
}
