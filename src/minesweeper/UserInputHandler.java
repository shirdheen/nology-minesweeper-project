package minesweeper;

import java.util.Scanner;

public class UserInputHandler {

    private Scanner scanner;

    public UserInputHandler() {
        scanner = new Scanner(System.in);
    } // Initialising scanner

    public int[] getUserInput(int gridSize) {
        int row, col;

        while (true) {
            System.out.println("Enter row and column number (e.g., '3 5'): ");
            String input = scanner.nextLine().trim(); // Reads user input as a string and removes extra spaces
            String[] parts = input.split("\\s+"); // Splits the input by spaces to get row and col
            // Regex has been used to allow multiple spaces

            if (parts.length != 2) {
                System.out.println("Oops! Invalid input. Please enter 2 numbers separated by a space");
                continue;
            } // If input has less or more than 2 values, an error is thrown, the loop is executed again

            try {
                row = Integer.parseInt(parts[0]);
                col = Integer.parseInt(parts[1]);
                // Converts String to int

                if (row >= 0 && row < gridSize && col >= 0 && col < gridSize) {
                    return new int[]{row, col};
                } else {
                    System.out.println("The values entered are out of bounds. Enter numbers between 0 and " + (gridSize -1) + "."); // Ensures that input is within bounds of the grid
                }
            } catch (NumberFormatException e) {
                System.out.println("Oops! Invalid input. Please enter numbers only.");
            }
        }
    }

}
