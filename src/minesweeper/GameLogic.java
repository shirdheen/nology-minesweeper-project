package minesweeper;

import java.util.Scanner;

public class GameLogic {
    private Board board;
    private UserInputHandler inputHandler;
    private boolean gameOver;
    private Scanner scanner;

    public GameLogic() {
        scanner = new Scanner(System.in);

    }

    public void start() { // Game starts inside a do-while loop. Each time the loop starts, a new board is created, initialises a new input handler, and resets the game
        do {
            board = new Board();
            inputHandler = new UserInputHandler();
            gameOver = false;

            System.out.println("Hi there! Let's play Minesweeper!");
            board.renderBoard();

            while (!gameOver) {
                int[] coords = inputHandler.getUserInput(10);

                gameOver = board.revealCell(coords[0], coords[1]);

                if (!gameOver && board.checkWin()) {
                    gameOver = true;
                }

                board.renderBoard(); // Game continues as usual until the player wins or hits a mine
            }
            System.out.println("Game over!");
        } while (playAgain()); // Game only restarts if askPlayAgain() returns true

    }

    private boolean playAgain() {
        System.out.println("Play again? (YES/NO): ");
        String response = scanner.nextLine().trim().toLowerCase();
        return response.equals("yes");
    } // If the user types "yes", the game restarts
 
}
