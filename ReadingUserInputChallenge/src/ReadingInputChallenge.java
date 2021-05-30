import java.util.Scanner;

public class ReadingInputChallenge {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter 10 numbers");

        int counter = 0;
        int sum = 0;

        while (true) {
            int order = counter + 1;
            System.out.println("Enter number " + order);

            boolean isAnInt = input.hasNextInt();

            if (isAnInt) {
                int number = input.nextInt();
                counter++;
                sum += number;
                if(counter == 10){
                    break;
                }
            } else {
                System.out.println("Invalid input");
            }
            input.nextLine(); // Enter handler
        }

        input.close();
        System.out.println(" Sum of numbers is " + sum);

    }
}
