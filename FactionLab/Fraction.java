public class Fraction
{
   private int numerator;
   private int denominator;
   
   public Fraction(int n, int d)
   {
      numerator = n;
      denominator = d;
   }
   
   public Fraction add(Fraction other)
   {  
      int d = denominator * other.getDenominator();
      int n = (numerator * other.getDenominator()) + (other.getNumerator() * denominator);
      
      return new Fraction(n,d);
   }
   
   public static Fraction add(Fraction a, Fraction b)
   {
      int n = (a.getNumerator() * b.getDenominator()) + (b.getNumerator() * a.getDenominator());
      int d = a.getDenominator() * b.getDenominator();
      return new Fraction(n,d);
   }

   public Fraction subtract(Fraction other)
   {
      int d = denominator * other.getDenominator();
      int n = (numerator * other.getDenominator()) - (other.getNumerator() * denominator);
      return new Fraction(n,d);
   }
   
   public static Fraction subtract(Fraction a, Fraction b)
   {
      int n = (a.getNumerator() * b.getDenominator()) - (b.getNumerator() * a.getDenominator());
      int d = a.getDenominator() * b.getDenominator();
      return new Fraction(n,d);
   }

   public Fraction multiply(Fraction other)
   {
      int n = numerator * other.getNumerator();
      int d = denominator * other.getDenominator();
      return new Fraction(n,d);
   } 
   
   public static Fraction multiply(Fraction a, Fraction b)
   {
      int n = a.getNumerator() * b.getNumerator();
      int d = a.getDenominator() * b.getDenominator();
      return new Fraction(n,d);
   }
   
   public Fraction divide(Fraction other)
   {
      int n = numerator * other.getDenominator();
      int d = denominator * other.getNumerator();
      return new Fraction(n,d);
   } 
   
   public static Fraction divide(Fraction a, Fraction b)
   {
      int n = a.getNumerator() * b.getDenominator();
      int d = a.getDenominator() * b.getNumerator();
      return new Fraction(n,d);
   }

   //Getter Methods
   public int getNumerator()
   {
      return numerator;
   }
   
   public int getDenominator()
   {
      return denominator;
   }

   //To String
   public String toString()
   {
      return numerator + "/" + denominator;
   } 
}