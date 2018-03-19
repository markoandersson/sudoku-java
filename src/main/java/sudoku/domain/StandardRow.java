package sudoku.domain;

import java.util.List;

/**
 * Presents single row of numbers in standard sudoku board. Accepts nine cells to be grouped as single row. If one cell resolved, other cells in this row will be notified.
 */
public class StandardRow implements Row {

    private final List<Cell> cells;

    StandardRow(List<Cell> cells) {

        if (cells.size() != 9) {
            throw new IllegalArgumentException("Exactly nine cells expected");
        }

        cells.forEach(cell -> cell.addListener(this));
        this.cells = cells;
    }

    @Override
    public void cellSolved(int resolvedNumber) {

        cells.stream()
                .filter(cell -> !cell.isSolved())
                .forEach(cell -> cell.removePossibility(resolvedNumber));
    }
}
