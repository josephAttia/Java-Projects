public class FractionDriver {
   public static void main(String[] args)
   {
       //Add
      Fraction fracOne = new Fraction(3,5);	
      Fraction fracTwo = new Fraction(2,5);	
      Fraction result;
      result = fracOne.add(fracTwo);
      result = Fraction.add(fracOne, fracTwo);
      System.out.println(fracOne + " + " + fracTwo + " = " + result);
       
       //Subtract
      Fraction fracThree = new Fraction(3,5);	
      Fraction fracFour = new Fraction(2,5);	
      Fraction resultTwo;
      resultTwo = fracThree.subtract(fracFour);
      resultTwo = Fraction.subtract(fracThree, fracFour); 
      System.out.println(fracThree + " - " + fracFour + " = " + resultTwo);
       
       //Multiply
      Fraction fracFive = new Fraction(3,5);	
      Fraction fracSix = new Fraction(2,5);	
      Fraction resultThree;
      resultThree = fracFive.multiply(fracSix);
      resultThree = Fraction.multiply(fracFive, fracSix); 
      System.out.println(fracFive + " * " + fracSix + " = " + resultThree);
       
       //Divide
      Fraction fracSeven = new Fraction(3,5);	
      Fraction fracEight = new Fraction(2,5);	
      Fraction resultFour;
      resultFour = fracSeven.divide(fracEight);
      resultFour = Fraction.divide(fracSeven, fracEight); 
      System.out.println(fracSeven + " / " + fracEight + " = " + resultFour);
   }
}
