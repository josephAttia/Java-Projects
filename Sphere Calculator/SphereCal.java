import java.util.*;

public class SphereCal {

   public static void main(String[] args)
   {
   Scanner sc = new Scanner(System.in);
   
   double sRadius = 0;
   double diameter, circumference, surfaceArea, volume;
   
   System.out.println("    Sphere Calculator");
   System.out.println("-----Joseph Attia-----");
   System.out.println();
   
   System.out.print("Enter Sphere Radius: ");
   sRadius = sc.nextDouble();
   
   //Volume
   volume = (Math.pow(sRadius,3) * Math.PI)*4/3;
   
   //Surface Area
   surfaceArea = (Math.pow(sRadius, 2) * Math.PI)*4;
   
   //Diameter
   diameter = sRadius * 2;
   
   //circumference
   circumference = 2 * (Math.PI * sRadius);
   
   //Result
   System.out.println("----------------RESULT------------------");
   System.out.println("Diameter: " + diameter);
   System.out.println("Circumference: " + circumference);
   System.out.println("Volume: " + volume);
   System.out.println("Surface Area: " + surfaceArea);
   System.out.println("---------------END-------------------");
   }
}