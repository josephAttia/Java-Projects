public class PatronDriver
{
   public static void main(String[] args)
   {
      //Makes New Patron
      Patron person = new Patron("Fady Attia");
   
      //Borrowing Books
      person.borrowBook("Harry Potter", "J.K. Rowling's");
      person.borrowBook("The Lord of the Rings", "William Golding");
      person.borrowBook("A Tale of Two Cities", "Charles Dickens");
   
      //Prints Out Information
      System.out.println(person);
   
      //ReturnsBook
      person.returnBook("Harry Potter");
   
      //Prints out Infromation
      System.out.println(person);
   }
}