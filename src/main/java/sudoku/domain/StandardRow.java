package sudoku.domain;

import java.util.List;

/**
 * Presents single row of numbers in standard sudoku board. Accepts nine cells to be grouped as single row. If one cell resolved, other cells in this row will be notified.
 */
public class StandardRow extends AbstractRow{

    StandardRow(List<Cell> cells) {
        super(cells);

        if (cells.size() != 9) {
            throw new IllegalArgumentException("Exactly nine cells expected");
        }
    }

}
