import java.util.*;
public class PowersOfTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int userNum = 0;
        String again = "Y";

        while(again.equals("Y"))
        {
            //Gets User Input 
            System.out.println("Enter -1 to end the program");
            System.out.print("Enter a number greater than 0: ");
            userNum = sc.nextInt();

            //Check if UserNum == -1 
            //If Yes then it terminates the program
            if(userNum == -1)
            {
                break;
            }

            //Calculates the Power
            int result = (int) Math.pow(2, userNum);
            System.out.println("The Result is: "+result);

            //Prompts the user to start again
            System.out.print("Want to start again? (Y)(N): ");
            again = sc.next();
            
        }
    }
}
