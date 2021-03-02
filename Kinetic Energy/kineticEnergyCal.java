import java.util.*;
public class kineticEnergyCal{

   public static void main(String[] args)
   {
      //Import Scanner
      Scanner sc = new Scanner(System.in);
   
      //Formula : KE=(1/2)mv^2 | For reference
      double mass, velocity, kE, momentum;
      
      System.out.println(" Kinetic Energy Calculator");
      System.out.println("-----Joseph Attia-----");
      System.out.println();
      
      System.out.print("Enter Object Mass: ");
      mass = sc.nextDouble();
      
      System.out.print("Enter Object Velocity: ");
      velocity = sc.nextDouble();
   
      kE = (Math.pow(velocity, 2)*mass)* 1/2;
      
      momentum = mass * velocity;
      
      System.out.println("Object's Kinetic Energy is: " + kE);
      System.out.println("Object's Momentum is: " + momentum);
   }
}