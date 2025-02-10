package minesweeper;

import java.util.Random;

public class Board {
    private static final int GRID_SIZE = 10;
    private static final int MINES = 10;
    private Cell[][] grid; // 2D array of Cell objects

    public Board() {
        grid = new Cell[GRID_SIZE][GRID_SIZE];
        initialiseBoard();
        placeMines();
        calculateAdjMines();
    }

    private void initialiseBoard() {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                grid[row][col] = new Cell();
            }
        }
    }

    private void placeMines() {
        Random random = new Random();
        int placedMines = 0;

        while (placedMines < MINES) {
            int row = random.nextInt(GRID_SIZE); // Random row
            int col = random.nextInt(GRID_SIZE); // Random column

            // If the cell does not have a mine, place a mine there
            if (!grid[row][col].isMine()) {
                grid[row][col].setMine(true);
                placedMines++;
            }
        }
    }

    private void calculateAdjMines() {
        int[] directions = { -1, 0, 1 }; // Row and column offsets for all 8 directions

        for (int row = 0; row < GRID_SIZE; row++) { // Loop over every cell
            for (int col = 0; col < GRID_SIZE; col++) {
                if (grid[row][col].isMine()) {
                    continue; // Skip if the current cell is a mine
                }
                
                int mineCount = 0; // Number of mines in the surrounding cells - value stored in grid[row][col]

                // [row][col] = current cell
                // [row - 1][col] = top middle cell
                // [row + 1][col] = bottom middle cell
                // [row][col + 1] = middle right cell
                // [row][col - 1] = middle left cell
                // [row + 1][col + 1] = bottom right cell
                // [row + 1][col - 1] = bottom left cell
                // [row - 1][col - 1] = top left cell
                // [row - 1][col + 1] = top right cell

                for (int r : directions) { // Checks every direction
                    for (int c : directions) {
                        int newRow = row + r;
                        int newCol = col + c;

                        if (isValidCell(newRow, newCol) && grid [newRow][newCol].isMine()) { // Checks if the cell is within bounds
                            mineCount++; // Mine count increases if the neighbouring cell is within bounds and is a mine
                        }
                    }
                }

                grid[row][col].setAdjMines(mineCount); // Stores the final count of mines in the Cell object
            }
        }
    }

    private boolean isValidCell(int row, int col) {
        return row >= 0 && row < GRID_SIZE && col >= 0 && col < GRID_SIZE;
    }

    public void renderBoard() {
        System.out.print("  "); // For column alignment

        for (int col = 0; col < GRID_SIZE; col++) {
            System.out.print(col + " "); // Print column numbers on a single line
        }

        System.out.println(); // Moves to a new line after printing the column headers

        for (int row = 0; row < GRID_SIZE; row++) { // Iterates through each row of the grid
            System.out.print(row + " "); // Prints the current row number at the beginning of each row
            for (int col = 0; col < GRID_SIZE; col++) { // Loops through each column
                System.out.print(grid[row][col] + " "); // Renders the content of the current cell (_ - hidden cell)
            }
            System.out.println(); // New line once a full row is printed
        }
    }

    public boolean revealCell(int row, int col) {
        if (!isValidCell(row, col) || grid[row][col].isRevealed()) {
            return false; // If the cell is out of bounds/already revealed, false is returned (do nothing)
        }

        grid[row][col].reveal(); // Reveals the cell, if in the grid and previously hidden

        if (grid[row][col].isMine()) {
            System.out.println("BOOM!! You hit a mine.");
            return true;
        }

        if (grid[row][col].getAdjMines() == 0) { // Checking if the selected cells has 0 adjacent mines; if true, all surrounding cells must be revealed recursively

            int[] directions = {-1, 0, 1};

            for (int r : directions) {
                for (int c : directions) { // Iterates through all possible neighbouring cells
                    int newRow = row + r;
                    int newCol = col + c;
                    if (isValidCell(newRow, newCol) && !grid[newRow][newCol].isRevealed()) { // If the cell is within bounds, and not yet revealed, it will be revealed
                        revealCell(newRow, newCol);
                        // If this cell is also 0, it will trigger further reveals
                    }
                }
            }
        }

        return false; // If the cell is not a mine, the game continues
    }

    public boolean checkWin() {
        for (int row = 0; row < GRID_SIZE; row++) { // Loops through each row
            for (int col = 0; col < GRID_SIZE; col++) { // Loops through each column in the row
                if (!grid[row][col].isMine() && !grid[row][col].isRevealed()) {
                    return false;
                } // If there is even one hidden, non-mine cell, return false
            }
        }
        System.out.println("Congratulations! You win!");
        return true; // If all non-mine cells are revealed, you win the game
    }

}
