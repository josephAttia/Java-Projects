public class Book
{
   //Book Class Variables
   private String title;
   private String author;
   
   //Constructor
   public Book(String t, String a)
   {
      title = t;
      author = a;
   }

   //Getter Method
   public String getTitle()
   {
      return title;
   }
   
   public String getAuthor()
   {
      return author;
   }
   
   //Checks if Book is equal to another book
   public boolean equals(Object other)
   {
      Book x = (Book)(other);
      return (title.equals(x.getTitle()) && author.equals(x.getAuthor()));
   }

   //To String
   public String toString()
   {
      return  title + " by " + author;
   }
}