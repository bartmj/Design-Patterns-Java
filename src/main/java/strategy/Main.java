package strategy;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // first we create a big java array and fill it with random numbers
        int size = 1000;
        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt();
        }

        // then we let the user dynamically choose sorting method thanks to the strategy pattern
        Scanner input = new Scanner(System.in);
        boolean exit = false;
        SortingMachine sortingMachine = null;

        while (!exit) {
            System.out.println("Please choose an option: ");
            System.out.println("1. Bubble sort");
            System.out.println("2. Merge sort");
            System.out.println("3. Exit");
            int choice = input.nextInt();
            if (choice == 1) {
                sortingMachine = new SortingMachine(new BubbleSort());
                exit = true;
            } else if (choice == 2) {
                sortingMachine = new SortingMachine(new MergeSort());
                exit = true;
            } else if (choice == 3) {
                exit = true;
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        input.close();

        // in the end we measure how much time it took to sort the array
        long start = System.currentTimeMillis();

        sortingMachine.executeSorting(array);

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;

        System.out.println("Sorting took: " + timeElapsed + " milliseconds");
    }
}
