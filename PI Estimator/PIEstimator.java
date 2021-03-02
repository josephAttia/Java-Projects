import java.util.Scanner;
public class PIEstimator{

    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of Iterations:");
        int n = sc.nextInt();

        double sum = 0;
        for (int i=1; i < n; i++) {
        double calculations = Math.pow(-1,i + 1) / (2 * (i-1) + 1);
        sum += calculations;
        }

        System.out.println("Estimate PI Number: " + (4*sum));
    }
}
