import java.util.Scanner;

public class PopulationGrowth
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double startingP,growthR, timeI, totalTime, intervals;

        //Starting Population
        System.out.print("Enter Starting Population: ");
        startingP = sc.nextInt();
        
        //Growth Rate
        System.out.print("Enter Growth Rate: ");
        growthR = sc.nextInt();

        //Time to achieve growth
        System.out.print("Enter amount of time it takes to achieve this growth: ");
        timeI = sc.nextInt();

        //Total Amount of time
        System.out.print("Enter Total Amount of Time: ");
        totalTime = sc.nextInt();

        //Calculate Intervals
        intervals = totalTime / timeI; 

        //Calculate Growth
        for(int i = 0; i < intervals; i++)
        {
            double finalP = startingP * growthR;
            System.out.println(finalP + " Orgamisms");
            growthR += growthR;
        }
    }
}