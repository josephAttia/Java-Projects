import java.util.*;
public class BankAccountDriver
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      int withdraw, deposit, balance;
      
      //Gets Name
      System.out.println("Enter a name that will be associated with this account");
      String name = input.next();
      
      //Gets Balance
      System.out.println("Enter a balance that will be associated with this account");
      balance = input.nextInt();
      
      //Creates a new Bank Account with the given information
      BankAccount account = new BankAccount(name, balance);
      
      //Prints the Bank Account Information
      System.out.println(account);
      
      //Deposit Method called to deposit into the bank account 
      System.out.println("Enter Deposit Ammount");
      deposit = input.nextInt();
      account.deposit(deposit);
      
      //Reprintes the Bank Account Information
      System.out.println(account);
      
      //WithDraw Method called to withdraw from the bank account 
      System.out.println("Enter Withdraw Ammount");
      withdraw = input.nextInt();
      account.withdraw(withdraw);
      
      //Reprintes the Bank Account Information
      System.out.println(account);
   }
}
