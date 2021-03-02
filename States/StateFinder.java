import java.io.FileReader;
import java.io.IOException;
import java.util.* ;
public class StateFinder {

   public static State[] readFile() throws IOException {
      State[] states = new State[51];
      Scanner input = new Scanner(new FileReader("states.txt"));
      int i = 0;
      String line;
      while (input.hasNextLine()) {
         String name = input.nextLine();
         String capital = input.nextLine();
         String abbrv = input.nextLine();
         states[i] = new State(name, capital, abbrv);
         i++;
      }
      input.close();
      return states;
   }

   public static int findState(State[] array, String name) {
      int low = 0;
      int high = array.length - 1;
      int mid = 0;
      name = name.toUpperCase();
      int res = -1;
      while (low <= high) { 
         mid = (low + high) / 2;
      
         if ((array[mid].getName().toUpperCase()).compareTo(name) < 0) {
            low = mid + 1;
         } 
         else if ((array[mid].getName().toUpperCase()).compareTo(name) > 0) {
            high = mid - 1;
         }
         else {
            return mid;
         }
      }
      return -1;
   }

   public static int linearSearch(State[] states, String value, int choice) {
      int index = 0;
      value = value.toUpperCase();
      //Abbreviation
      if (choice == 1) {
         for (int i = 0; i < states.length; i++) {
            if ((states[i].getAbbreviation()).equals(value)) {
               return i;
            }
         }
      }
       //Capital
      else if(choice == 2){
         for (int i = 0; i < states.length; i++) {
            if ((states[i].getCapital().toUpperCase()).equals(value)) {
               return i;
            }
         }
      }
   
      return -1;
   }
   public static void main(String[] args) throws IOException {
      Scanner input = new Scanner(System.in);
      State[] states = new State[51];
      int userSelect = 0;
      states = readFile();
   
      while ((userSelect != -1)) {
         // Execute Operation
         System.out.println("Enter 1 to search by state name \nEnter 2 to search by abbreviation \nEnter 3 to search by capital \nEnter -1 to quit");
         userSelect = Integer.parseInt(input.nextLine());
      
         if (userSelect == 1) {
            System.out.println("Enter state name:");
            String stateName = input.nextLine();
            stateName.toUpperCase();
         
            if(findState(states, stateName) == -1){
               System.out.println("State Not Found");
            }
            else{
               System.out.println(states[findState(states, stateName)]);
            } 
               
         }
         else if (userSelect == 2) {
            System.out.println("Enter state abbreviation:");
            String abbre = input.nextLine();
            abbre.toUpperCase();
            if(linearSearch(states, abbre, 1) == -1){
               System.out.println("State Not Found");
            }
            else{
               System.out.println(states[linearSearch(states, abbre, 1)].toString());
            } 
         }
         else if (userSelect == 3) {
            System.out.println("Enter state capital:");
            String cap = input.nextLine();
            cap = cap.toLowerCase();
            if(linearSearch(states, cap, 2) == -1){
               System.out.println("State Not Found");
            }
            else{
               System.out.println(states[linearSearch(states, cap, 2)].toString());
            } 
         }
         else if(userSelect == -1){
            break;
         }
         
         else if(userSelect != 1 && userSelect != 2 && userSelect != 3 && userSelect != -1)
         {
            System.out.println("Please enter a valid menu choice.\n");
         }
         // Execute Operation End
      }
   }
}