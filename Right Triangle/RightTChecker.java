import java.util.*;


public class RightTChecker{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int s1,s2,s3;

        System.out.print("Enter one side: ");
        s1 = sc.nextInt();

        System.out.print("Enter another side: ");
        s2 = sc.nextInt(); 

        System.out.print("Enter the last side: ");
        s3 = sc.nextInt();

        if(s2 > s1 && s2 > s3)
        {
            if((Math.pow(s1, 2) + Math.pow(s3, 2)) == Math.pow(s2, 2))
            {
                System.out.println("Yes, this is a right triangle");
            }
            else{
                System.out.print("No, this is not a right triangle");
            }
        } 
        else if(s1 > s2 && s1 > s3)
        {
            if((Math.pow(s2, 2) + Math.pow(s3, 2)) == Math.pow(s1, 2))
            {
                System.out.print("Yes, this is a right triangle");
            }
            else{
                System.out.print("No, this is not a right triangle");
            }
        }
        else if(s3 > s2 && s3 > s1)
        {
            if((Math.pow(s1, 2) + Math.pow(s2, 2)) == Math.pow(s3, 2))
            {
                System.out.print("Yes, this is a right triangle");
            }
            else{
                System.out.print("No, this is not a right triangle");
            }
        }         
    }
}