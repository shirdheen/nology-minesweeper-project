package minesweeper;

public class Cell {

    private boolean isMine;
    private int adjMines;
    private boolean isRevealed;

    public Cell() {
        this.isMine = false;
        this.adjMines = 0;
        this.isRevealed = false;
    }

    public boolean isMine() {
        return isMine;
    }

    public int getAdjMines() {
        return adjMines;
    }

    public boolean isRevealed() {
        return isRevealed;
    }

    public void setMine(boolean mine) {
        this.isMine = mine;
    }

    public void setAdjMines(int count) {
        this.adjMines = count;
    }

    public void reveal() {
        this.isRevealed = true;
    }

    // 1. If the cell is hidden, _ is returned
    // 2. If the cell is revealed and there is a mine, * is returned
    // 3. If the cell is return and there is no mine, the number of adjacent mines is returned
    
    @Override
    public String toString() {
        if (!isRevealed) {
            return "_"; // Hidden cell
        } else if (isMine) {
            return "*"; // Mine (shown when the game ends)
        } else {
            return String.valueOf(adjMines); // Show number of surrounding mines
        }
    }

}
