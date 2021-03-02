/*
Name: Joseph Attia
Subject: Computer Science AP
Date: 10/1/2020
*/
public class BottleDriver{

   public static void main(String[] args){
   
      Bottle b1 = new Bottle();
      Bottle b2 = new Bottle("Red", 12);
   
      System.out.println("Total Volume: " + (b1.getNumberOfOunces() + b2.getNumberOfOunces()) + " Ounces");
   
      System.out.println(b1.toString());
      System.out.println(b2.toString());
   }

}