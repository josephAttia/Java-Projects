import java.util.*;
public class PersonDriver {

    public static void sort(Person list[])
    {
        for (int j = 1; j < list.length; j++) {
            int current = list[j].getAge();
            int i = j-1;
            while ((i > -1) && ((list[i].compareTo(list[i + 1])) == 1)) {
                list[i+1].setAge(list[i].getAge());
                i--;
            }
            list[i+1].setAge(current);
        }
    }

    public static void sortAlpa(Person[] array){
        Person temp = new Person(15, "temp", "temp");
        for(int i = 1; i < array.length; i++)
          {
               temp = array[i];
               int j = 0;
               for(j = i; j > 0; j--)
               {
                    if(temp.compareTo(array[j - 1]) < 0){
                         array[j] = array[j - 1];
                    }
                    else{
                        break;
                    }
               }
               array[j] = temp;
          }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfPeople = 0;

        System.out.print("Enter the number of people (3-10) in your list:");
        numberOfPeople = sc.nextInt();

        while(numberOfPeople < 3 || numberOfPeople > 10){
        System.out.println("Inalid Input");
        System.out.print("Enter the number of people (3-10) in your list:");
        numberOfPeople = sc.nextInt();
        }   
        Person[] people = new Person[numberOfPeople];

        for(int i = 0; i < numberOfPeople; i++)
        {
            System.out.println("Person " + (i+1));
            System.out.print("Enter Age: ");
            int age = sc.nextInt();
            System.out.print("Enter Name: ");
            String name = sc.next();
            System.out.print("Enter Eye Color: ");
            String eyeColor = sc.next();
            people[i] = new Person(age, name, eyeColor);
        }

        System.out.println("\nHere is the original list");
        for(int i = 0; i < people.length; i++){
            System.out.println(people[i].toString());
        }
        sortAlpa(people);
        sort(people);
        
        System.out.println("\ninsertion sort ... \nHere is the sorted list");
        for(int i = 0; i < people.length; i++){
            System.out.println(people[i].toString());
        }
    }
}
