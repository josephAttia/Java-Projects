public class BankAccount
{
   //Makes Needed Variables
   private int balance;
   private String name;
   
   //Constructor
   public BankAccount(String n, int b)
   {
      name = n;
      balance = b;
   }

   //Getter Methods-------
   //Gets the name associated with the bank account
   public String getName()
   {
      return name;
   }
   //Gets the balance associated with the bank account
   public int getBalance()
   {
      return balance;
   }
   //End------------------

   //Mutator Methods--------
   //WithDraw
   public void withdraw(int x)
   {
       //Checks if there is enough money in the account
      if(balance - x >= 0)
      {
         balance = balance - x;
      }
   }
   //Deposit Money in the account
   public void deposit(int a)
   {
      balance += a;
   }
   //End-------------

   //Converts Everything to a String 
   public String toString()
   {
      return name + " has $" + balance + " left in their bank account";
   }
}