## Demo and Snippets

- **Screenshots:**

## Requirements/Purpose

### MVP

- A 10x10 Minesweeper grid with 10 randomly placed mines.
- The player enter a row and column number to reveal a cell.
- If the cell contains a mine, the game ends with `BOOM!! You hit a mine.`
- If the cell has 0 adjacent mines, it will reveal the surrounding cells.
- If all non-mine cells are the revealed, the player wins the game.
- The board updates and render after each move.
- After the player finishes a game, they are allowed to choose if they want to play again.

### Purpose

- Implement the Minsweeper game as a Java console application.
- Use object-oriented programming to solve problems.
- Demonstrate 2D array manipulation, randomisation, and recursion.

### Stacks Used

- **Programming Language:** Java
- **Development Environment:** VSCode

## Build Steps

1. Clone the repository

```bash
git clone repo-link
```

## Design Goals/Approach

- **Design Goals:**

  - Implement a fully-functional console-based Minesweeper application.
  - Use OOP principles:
    - **Encapsulation:** `Cell.java` contains all cell properties.
    - **Abstraction:** `Board.java` abstracts all the board logic from the user, and handles functions including rendering of the board, revealing cells, checking if the user has won, etc.
    - **Separation of concerns:** The code has been modularised where each Java class handles a separate function, e.g., `GameLogic.java`, `UserInputHandler.java`, etc.
  - Make the game user-friendly with clear prompts and output formatting.

- **Implementation Choices:**
  - 2d array for the grid using `Cell[][] grid`.
  - Random placement of mines using `Random.nextInt()`.
  - Recursive flood-filling for cells that don't have adjacent mines.
  - A loop driven game engine to handle turns.
  - User input validation (error handling) to prevent the app from crashing.

## Features

- Randomised 10x10 grid with 10 mines.
- User input handling for cell selection.
- Flood filling (revealing empty cells).
- Winning and losing conditions.
- 'Play Again' option.
- Error handling for invalid inputs.

## Known Issues

- Board rendering may vary on some consoles

## Bugs to be Fixed

## Future Goals

- Implement a GUI version.
- Add difficulty level (i.e., more mines or a bigger grid).
- Time the game by implementing a timer functionality.
- Enhance board aesthetics.
