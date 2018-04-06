package sudoku.domain;

/**
 * Interface which presents group of cells, aka rows, columns and grids.
 */
public interface GroupOfCells {

    void accept(SudokuVisitor solver);

    /**
     * Return true if this group of cells has been solved
     */
    boolean isSolved();
}
