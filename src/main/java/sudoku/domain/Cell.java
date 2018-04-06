package sudoku.domain;


import java.util.Collection;

/**
 * Interface for single cell in sudoku game board. Cell is either unresolved with specific possible numbers remaining or cell is resolved with specific number.
 *
 * Cell will notify all added {@link CellSolvedListener}-listeners when cell has been solved.
 *
 * Cell can belong also to some non standard sudoku board (other than with default 9 values).
 */
public interface Cell {


    /**
     * Is cells number already resolved
     */
    boolean isSolved();

    /**
     * Remove single possible number from the cell
     */
    void removePossibility(Integer number);

    /**
     * Add listener which will be notified when cell resolves.
     */
    void addListener(CellSolvedListener listener);

    /**
     * Returns possible numbers for this cell
     */
    Collection<Integer> getPossibilities();

    boolean containsPossibility(Integer number);

    void accept(SudokuVisitor visitor);
}
