public class Horse{
   private int location;
   private int index;

   public Horse(){
      location = 1;
      index = 0;
   }

   public Horse(int loc, int i){
      location = loc;
      index = i;
   }
   
   public void horseStride(){
      int randomNum = (int)(Math.random() * (100)) + 1;
      if(randomNum < 50)
      {
         advance();
      }
   }

   public int getLocation(){
      return location;
   }

   public int getIndex(){
      return index;
   }

   public void advance(){
      if(location <= 15){
         location++;
      }
   }

   public String toString()
   {
      String result = "";
      result = "|";
      for(int i = 1; i < location; i++){
         result = result + "-";                       
      }
      result = result + index;
      for(int j = location; j < 15; j++)
      {
         result = result + "-";
      }
      result = result + "|";
      return result;
   }
}