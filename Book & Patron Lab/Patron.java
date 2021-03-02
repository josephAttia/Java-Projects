public class Patron {

   //Patron Variables
   private String name;
   private Book b1, b2, b3;

   //Create a Patron with 3 empty book slots
   public Patron(String n){
      name = n;
      b1 = null;
      b2 = null;
      b3 = null;
   }

   //Returns the book
   public void returnBook(String t)
   {    
      //Checks if Book 1 is the same as the return title
      if(b1.getTitle().equals(t))	
      {
         b1 = null;				
      }
      //Checks if Book 2 is the same as the return title
      else if(b2.getTitle(). equals(t))	
      {
         b2 = null;				
      }
      //Checks if Book 3 is the same as the return title
      else if(b3.getTitle().equals(t))	
      {
         b3 = null;		
      }
   }

   //Checks whether Patron Borrowed a book or no
   public boolean didYouborrow(String t, String a)
   {
      //Checks If Book One Is Open
      if(b1 == null)
      {	 
         return true;
      }
      //Checks If Book Two Is Open
      if(b2 == null)
      { 
         return true;
      }
      //Checks If Book Three Is Open
      if(b3 == null)
      { 
         return true;
      }
      //If none are avalible return false
      return false;
   }

   //Borrow Books
   public void borrowBook(String title, String author)
   {
      Book temp = new Book(title, author);
      //Checkes If 3 Books are Checked Out
      if(b1 != null && b2 != null && b3 != null)
      {
         System.out.println("3 Books Already Checked Out");
      }
      //Checking Whether Book Is Checked Out
      if(b1 != null && title.equals(b1.getTitle()) && author.equals(b1.getAuthor()))
      {
         System.out.println("You already check out this book");
      }
      //Checking Whether Book Is Checked Out
      else if(b2 != null && title.equals(b2.getTitle()) && author.equals(b2.getAuthor()))
      {
         System.out.println("You already check out this book");
      }
      //Checking Whether Book Is Checked Out
      else if(b3 != null && title.equals(b3.getTitle()) && author.equals(b3.getAuthor()))
      {
         System.out.println("You already check out this book");
      }
      //Forcing Book to be Unchanged
      else
      {
         if(b1 == null)
         {
            b1 = temp;
         }
         else if(b2 == null)
         {
            b2 = temp;
         }
         else if(b3 == null)
         {
            b3 = temp;
         }
      }
   }
   //To string method
   public String toString()
   {
      return "Name: " + name + " \nhas the books: \n1)" + b1 + "\n2)" + b2 + "\n3)" + b3 + "\n";
   }
}
