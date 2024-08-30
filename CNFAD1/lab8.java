import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class UpperBoundWildcard<T extends Number> {
    private List<T> numberList;

    // Constructor to initialize the list
    public UpperBoundWildcard() {
        numberList = new ArrayList<>();
    }

    // Method to add a number to the list using a lower bound wildcard
    public void addNumber(T number) {
        numberList.add(number);
    }

    // Method to return the list using an upper bound wildcard
    public List<? extends T> getNumberList() {
        return numberList;
    }

    // Method to calculate the sum of numbers using an upper bound wildcard
    public double sumOfNumbers() {
        double sum = 0.0;
        for (T number : numberList) {
            sum += number.doubleValue();
        }
        return sum;
    }

    // Method to sort the list of numbers using Bubble Sort
    public void sortNumbers() {
        int n = numberList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (numberList.get(j).doubleValue() > numberList.get(j + 1).doubleValue()) {
                    // Swap numberList[j] and numberList[j+1]
                    T temp = numberList.get(j);
                    numberList.set(j, numberList.get(j + 1));
                    numberList.set(j + 1, temp);
                }
            }
        }
    }
}

public class GenericsUpperBoundDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UpperBoundWildcard<Number> upperBound = new UpperBoundWildcard<>();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Integer");
            System.out.println("2. Add Double");
            System.out.println("3. Calculate Sum");
            System.out.println("4. Sort Numbers");
            System.out.println("5. Display Numbers");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter 5 integers: ");
                    for (int i = 0; i < 5; i++) {
                        upperBound.addNumber(scanner.nextInt());
                    }
                    break;
                case 2:
                    System.out.print("Enter 5 double values: ");
                    for (int i = 0; i < 5; i++) {
                        upperBound.addNumber(scanner.nextDouble());
                    }
                    break;
                case 3:
                    System.out.println("Sum of Numbers: " + upperBound.sumOfNumbers());
                    break;
                case 4:
                    upperBound.sortNumbers();
                    System.out.println("Numbers have been sorted.");
                    break;
                case 5:
                    System.out.println("Numbers: " + upperBound.getNumberList());
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
