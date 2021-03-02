import java.util.*;

public class TelephoneCall{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int minutes;
        double money;

        System.out.print("Enter the number  of minutes: ");
        minutes = sc.nextInt();

        if(minutes > 2 )
        {
            minutes -= 2;
            money = (double)(1.15 + (double)(minutes)/2);
            System.out.print("The total money is: $" + money);
        }
        else if(minutes > 0 && minutes <= 2)
        {
            System.out.print("The total money is: $1.15");
        }
        else{
            System.out.print("Please enter a valid number of minutes");
        }
    }
}