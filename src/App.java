import minesweeper.Cell;
import minesweeper.GameLogic;
import minesweeper.Board;

public class App {
    public static void main(String[] args) throws Exception {
        // Cell testCell = new Cell();
        // testCell.setMine(true);
        // testCell.reveal();

        // System.out.println("Cell status: " + testCell.toString());
        // System.out.println("Is revealed? " + testCell.isRevealed());
        // System.out.println("Adjacent mines: " + testCell.getAdjMines());
        // System.out.println("Is mine?: " + testCell.isMine());

        // Board board = new Board();
        // board.renderBoard();

        GameLogic game = new GameLogic();
        game.start();
        System.out.println("Goodbye, see you next time!");
    }

}
